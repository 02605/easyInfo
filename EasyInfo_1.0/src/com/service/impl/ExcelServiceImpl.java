package com.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.dao.impl.getListFromDBDaoImpl;
import com.domain.ExcelCell;
import com.service.ExcelService;
import com.utils.EntityToMapBean;
import com.utils.ReadExcelBean;
import com.utils.WriteExcelBean;

/**
 * 关于Excel操作的实现类
 * 
 * @author 陶宇豪
 * 
 */
public class ExcelServiceImpl implements ExcelService {
	private getListFromDBDaoImpl getListFromDB;// Spring管理
	private ReadExcelBean readExcelBean;// Spring管理
	private WriteExcelBean writeExcelBean;// Spring管理

	private String way;

	/**
	 * @return url 如果返回正常的url，则表明自动填充成功，否则返回null
	 * @throws Exception
	 */
	public String autoFillData(String tea_id, String fromPath, String toPath,
			String fileName) throws Exception {
		// ↓↓↓文件名称分析
		String toFile = nameService(fromPath, toPath, fileName, tea_id);
		// ↓↓↓开始读取表格，获取单元格的内容
		ArrayList<ExcelCell> excelCellArrayList = readExcelBean
				.readOriginExcelFile(fromPath, fileName, way);// 地址后期传参得到，计划只需要传递一个文件名既可
		// // ↓↓↓写入一些特殊字段,例如混合显示的论文信息。
		// writeSpecial(excelCellArrayList);
		// ↓↓↓开始获取数据库中该教师的基础信息
		ArrayList<Object> searchResult = getListFromDB.getList(tea_id);
		// ↓↓↓将读取到的数据写入到对应的属性中,例如tea_id:101
		for (Object temp : searchResult) {
			saveDBValue(excelCellArrayList, temp);
		}
		// ↑↑↑到此解析完成
		// ↓↓↓以下开始重新写入Excel文件
		if (writeExcelBean.copyExcelFile(fromPath, toPath, fileName, toFile)
				&& writeExcelBean.fill(excelCellArrayList, toFile, "right", 1,
						way)) {
			System.out.println("文件写入成功");
		}
		// System.out.println("用以查看数据读取是否正确\n" + excelCellArrayList.toString());
		return toFile;// 返回生成位置，便于进行下一步操作
	}

	//
	// private void writeSpecial(ArrayList<ExcelCell> excelCellArrayList) {
	// for (ExcelCell cell : excelCellArrayList) {
	// isSpecial(cell.getOriginString());
	// cell.setValue(value);
	// }
	// }
	//
	// private String isSpecial(String word) {
	// String result;
	// switch (word) {
	// case "the_merge":
	// result=
	// break;
	// case "cm_merge":
	//
	// break;
	// case "pat_merge":
	//
	// break;
	//
	// default:
	// break;
	// }
	// return result;
	// }

	/**
	 * 
	 * @param excelCellArrayList
	 *            ExcelCell对象
	 * @param teacher
	 *            查询到的对象
	 * @return
	 */
	private ArrayList<ExcelCell> saveDBValue(
			ArrayList<ExcelCell> excelCellArrayList, Object object) {
		// 将实体的属性和value做成键值对的形式，方便单元格存储
		// eg:"单元格原始内容为:姓名","转换成标准数据库字段后为:tea_name","通过此方法可以将数据库查询出的name赋予tea_name","得到的最终结果为:姓名为name"
		new EntityToMapBean();
		Map<Object, Object> entityFromDB = EntityToMapBean.object2Map(object);
		// System.out.println(entityFromDB.toString());

		// 开始将查询出的实体对象存入到单元格对象中
		Set set = entityFromDB.keySet();// 遍历查询出的实体对象，此时只有一个Teacher实体

		for (Iterator iter = set.iterator(); iter.hasNext();) {

			// 获取键值对
			String key = (String) iter.next();// key=数据库标准字段
			String value = String.valueOf(entityFromDB.get(key));// value=根据字段读取的数据
			// 新建重复次数计数器，用以遍历
			// 开始遍历读取出的单元格对象
			for (ExcelCell cell : excelCellArrayList) {
				// 判断该表格字段是否重复
				// 已经存储有数据了，跳过该对象
				// 在外界遍历器的作用下【数据是堆栈的，如果存储完就意味着这条数据舍弃了】存储过的数据将不会重复存储到不同的对象上，实现了重复数据的利用
				if (cell.getValue() != null) {
					continue;

				}
				// 获取"数据库标准字段"
				String cellDB = cell.getDatabaseString();
				// 如果标准字段和键相同，则把值填入该单元格对象中
				if (key.equals(cellDB)) {
					cell.setValue(value);
					// 第一次存储的时候就会存储所有当前的数据到所有的重复单元格中
					// 下一次遍历时就不存在所谓的为null的单元格了,将无法实现多条相同归属的数据添加
					// 故加上break
					break;
				}
			}
		}
		return excelCellArrayList;
	}

	/**
	 * @param fromPath
	 *            文件根目录地址
	 * @param toPath
	 *            生成文件的目录地址
	 * @param fileName
	 *            模板名称
	 * @param tea_id
	 *            教师id
	 * @return 结合生成目录，教师id和模板名称生成的新文件地址
	 * @throws Exception
	 */
	private String nameService(String fromPath, String toPath, String fileName,
			String tea_id) throws Exception {
		String fileFont = fileName.substring(fileName.indexOf("."));// 获取文件后缀
		String realFileName = fileName.substring(0, fileName.indexOf("."));// 获取文件名
		if (!fileFont.equals(".xls") && !fileFont.equals(".xlsx")) {
			throw new Exception("不支持此文件格式，请重试");
		}
		// 设定解析模式
		if (fileName.contains("back"))
			setWay("back");
		else
			setWay("forward");
		// 返回根据教师id重新设定的新名字
		return toPath + realFileName + "-" + tea_id + fileFont;

	}

	// set方法用于Spring控制
	public void setGetListFromDB(getListFromDBDaoImpl getListFromDB) {
		this.getListFromDB = getListFromDB;
	}

	public void setreadExcelBean(ReadExcelBean readExcelBean) {
		this.readExcelBean = readExcelBean;
	}

	public void setWriteExcelBean(WriteExcelBean writeExcelBean) {
		this.writeExcelBean = writeExcelBean;
	}

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}

}
