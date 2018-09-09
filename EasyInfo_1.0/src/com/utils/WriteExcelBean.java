package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
import org.apache.struts2.ServletActionContext;

import com.domain.ExcelCell;

public class WriteExcelBean {
	private int fileSheetNum;
	private String specialWrite;// 判读特殊写入
	private int doFlag = 0;
	private int trueFlag = 0;// 计数器

	/**
	 * 填充内容
	 * 
	 * @param exList
	 * @param fromPath
	 * @param toPath
	 * @param fileName
	 * @param direction
	 * @param step
	 * @return
	 * @throws IOException
	 * @throws InvalidFormatException
	 * @throws EncryptedDocumentException
	 */
	public boolean fill(ArrayList<ExcelCell> exList, String toFile,
			String direction, int step, String way) throws IOException,
			EncryptedDocumentException, InvalidFormatException {
		System.out.println("Fill:" + toFile);
		InputStream in = new FileInputStream(toFile);
		Workbook wb = WorkbookFactory.create(in);
		// 获取表格数量
		setFileSheetNum(wb.getNumberOfSheets());
		// ↓↓↓开始写入
		if (way.equals("back")) {
			// ↓↓↓根据模板中的英文字段-逆向写入中文字段-确保了语义不冲突
			if (backWrite(exList, wb)) {
				System.out.println("原始字段写入成功");
				// ↓↓↓清理部分无用的重复项-当读取到的数量大于1的时候，删除那些没有值的格子
				// 但是如果在正向解析私人模板的时候 可能对其造成不可预料的结果
				// 故该方法只用在公共模板上
				clearNullExcel(exList, wb);
			} else {
				System.out.println("原始字段写入失败");
			}
		}
		// ↓↓↓正向写入读取到的内容
		forwardWrite(exList, wb, direction, step);
		// ↓↓↓写入一些特殊字段-例如教师证件照等信息
		// switch (getSpecialWrite()) {
		// case "tea_img":
		// wirteImg(exList, wb);
		// break;
		// default:
		// break;
		// }
		// ↓↓↓保存为 Excel 文件
		FileOutputStream out = null;

		try {
			out = new FileOutputStream(toFile);
			wb.write(out);
			System.out.println("写入成功\n文件地址为:" + toFile);
			System.out.println("循环了:" + doFlag + " 真实有效的次数为:" + trueFlag);
			return true;
		} catch (IOException e) {
			System.out.println(e.toString());
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				System.out.println(e.toString());
			}
		}

		return false;
	}

	/**
	 * 反向解析时的写入方法
	 * 
	 * @param exList
	 * @param wb
	 * @return
	 */
	private boolean backWrite(ArrayList<ExcelCell> exList, Workbook wb) {
		// TODO 反向写入
		for (int sheetIndex = 0; sheetIndex < fileSheetNum; sheetIndex++) {
			for (int rowIndex = 0; rowIndex <= wb.getSheetAt(sheetIndex)
					.getLastRowNum(); rowIndex++) {
				// 开始遍历单元格对象
				for (ExcelCell cell : exList) {
					doFlag++;
					// 获取当前对象原始字段的位置
					int oldAddressCol = cell.getAddress().getColumn();
					int oldAddressRow = cell.getAddress().getRow();
					if (oldAddressRow == rowIndex
							&& sheetIndex == cell.getSheetIndex()) {
						// 获取读取到的数据
						String origin = cell.getOriginString();
						// 读取到的数据不存在即不写入，继续下一个循环
						if (origin == null || origin.equals("null"))
							continue;
						// 获取当前表格的当前行&列,并进行判断，如果没有则新建一个
						Row nowRow = wb.getSheetAt(sheetIndex).getRow(rowIndex);
						if (nowRow == null)
							nowRow = wb.getSheetAt(sheetIndex).createRow(
									rowIndex);// continue
						Cell nowCell = nowRow.getCell(oldAddressCol);
						if (nowCell == null)
							nowCell = nowRow.createCell(oldAddressCol);
						// 写入数据
						nowCell.setCellValue(origin);
						trueFlag++;
					}
				}
			}
		}
		return true;

	}

	/**
	 * 正向写入内容
	 * 
	 * @param exList
	 * @param wb
	 * @param direction
	 * @param step
	 * @return
	 */
	private boolean forwardWrite(ArrayList<ExcelCell> exList, Workbook wb,
			String direction, int step) {
		// TODO 正向写入
		for (int sheetIndex = 0; sheetIndex < fileSheetNum; sheetIndex++) {
			for (int rowIndex = 0; rowIndex <= wb.getSheetAt(sheetIndex)
					.getLastRowNum(); rowIndex++) {
				for (ExcelCell cell : exList) {
					doFlag++;
					String dbString = cell.getDatabaseString();
					// 如果已经写入了，则跳过该ExcelCell对象-便于写入重复内容
					if (cell.getIsWrite() == true)
						continue;
					// 针对合并单元格的位置判断
					if (cell.getIsMergeCell()) {
						cell.setAddress(new CellAddress(cell.getMergeLastRow(),
								cell.getMergeLastCol()));
					}
					// 一个移动单元格的方法，用于给读取到的内容一个新的位置
					cell.setNewAddress(direction, step);// 统一移动，并写入到对象中
					// 获取当前对象移动后的新位置
					int newAddressCol = cell.getNewAddress().getColumn();
					int newAddressRow = cell.getNewAddress().getRow();
					// 写入读取到的内容
					if (rowIndex == newAddressRow
							&& sheetIndex == cell.getSheetIndex()) {
						// 获取读取到的数据
						String value = cell.getValue();
						// 读取到的数据不存在即不写入，继续下一个循环
						if (value == null || value.equals("null"))
							continue;
						if (dbString != null) {
							// 判断特殊字符，如果是，则跳过下面的写入过程
							if (isSpecialWord(dbString))
								continue;
						}
						// 获取当前表格的当前行&列,并进行判断，如果没有则新建一个
						Row nowRow = wb.getSheetAt(sheetIndex).getRow(rowIndex);
						if (nowRow == null)
							nowRow = wb.getSheetAt(sheetIndex).createRow(
									rowIndex);// continue
						Cell nowCell = nowRow.getCell(newAddressCol);
						if (nowCell == null)
							nowCell = nowRow.createCell(newAddressCol);
						// 写入数据
						nowCell.setCellValue(value);
						// // 输出写入的内容
						// System.out
						// .println(cell.getOriginString() + ":" + value);
						// 存储写入状态
						cell.setIsWrite(true);
						trueFlag++;
					}
				}
			}
		}
		return true;

	}

	/**
	 * 判断该字符是否为需要特殊处理的字符
	 * 
	 * @param word
	 * @return
	 */
	public boolean isSpecialWord(String word) {
		String[] judge = { "tea_img" };
		int flag = 0;
		for (int i = 0; i < judge.length; i++) {
			if (judge[i].equals(word)) {
				flag++;
				setSpecialWrite(word);
			}
		}
		if (flag != 0)
			return true;
		else
			return false;
	}

	/**
	 * 写入图片的方法
	 * 
	 * @param exList
	 * @param wb
	 * @throws IOException
	 */
	public void wirteImg(ArrayList<ExcelCell> exList, Workbook wb)
			throws IOException {
		// TODO 写入图片
		// 准备写入
		for (int sheetIndex = 0; sheetIndex < fileSheetNum; sheetIndex++) {
			// 遍历行
			for (int rowIndex = 0; rowIndex <= wb.getSheetAt(sheetIndex)
					.getLastRowNum(); rowIndex++) {
				// 遍历列
				for (int cellIndex = 0; cellIndex < exList.size(); cellIndex++) {
					doFlag++;

					// 开始遍历单元格对象
					ExcelCell cell = exList.get(cellIndex);
					String dbString = cell.getDatabaseString();
					int addressRow = cell.getMergeFirstRow();
					int addressCol = cell.getMergeFirstCol();
					int lastCol = cell.getMergeLastCol() - addressCol;
					int lastRow = cell.getMergeLastRow() - addressRow;
					if (rowIndex == addressRow
							&& sheetIndex == cell.getSheetIndex()) {
						if (dbString != null) {
							if (isSpecialWord(dbString)) {
								// 一个sheet只可以获取一个drawing
								// ERROR : 会在多个表格写入图片
								Drawing drawing = wb.getSheetAt(sheetIndex)
										.createDrawingPatriarch();
								CreationHelper helper = wb.getCreationHelper();
								if (cell.getValue() == null
										|| cell.getValue().equals(""))
									continue;
								// add a picture in this workbook.
								InputStream is = new FileInputStream(
										cell.getValue());
								// 写入bean的282行地址存在问题，届时修复
								byte[] bytes = IOUtils.toByteArray(is);
								is.close();
								int pictureIdx = wb.addPicture(bytes,
										Workbook.PICTURE_TYPE_JPEG);

								// add a picture shape
								ClientAnchor anchor = helper
										.createClientAnchor();
								anchor.setCol1(addressCol);
								anchor.setRow1(addressRow);
								Picture pict = drawing.createPicture(anchor,
										pictureIdx);
								// 调整大小 //-1为了美观
								pict.resize(lastCol, lastRow);
								trueFlag++;
							}
						}
					}
				}
			}
		}
	}

	/**
	 * 删除空的重复项
	 * 
	 * @param exList
	 * @param wb
	 */
	private void clearNullExcel(ArrayList<ExcelCell> exList, Workbook wb) {
		// TODO 填写重复对象时清理无用单元格
		for (int sheetIndex = 0; sheetIndex < fileSheetNum; sheetIndex++) {
			for (int rowIndex = 0; rowIndex <= wb.getSheetAt(sheetIndex)
					.getLastRowNum(); rowIndex++) {
				for (ExcelCell cell : exList) {
					doFlag++;
					// 该单元格重复次数大于1，且单元格读取不到相应的数据，则可以删除此单元格
					if (cell.getDuplicateNum() > 0) {
						String value = cell.getValue();
						if (value == null) {
							int nowCol = cell.getAddress().getColumn();
							int nowRow = cell.getAddress().getRow();
							// 删除多余的内容
							if (rowIndex == nowRow
									&& sheetIndex == cell.getSheetIndex()) {
								// System.out.println("被移除的对象为:"
								// + cell.getOriginString() + ",重复次数:"
								// + cell.getDuplicateNum());
								// 通过移动行来实现删除
								wb.getSheetAt(sheetIndex).shiftRows(nowRow + 1,
										nowRow + 1, -1);
								trueFlag++;
							}
						}
					}
				}
			}
		}
	}

	/**
	 * 通过对文件的操作-复制模板
	 * 
	 * @param fromPath
	 * @param toPath
	 * @param fileName
	 * @throws IOException
	 */
	public boolean copyExcelFile(String fromPath, String toPath,
			String fileName, String toFile) throws IOException {
		File excelFile = new File(fromPath + fileName);
		File toFileDir = new File(toPath);
		FileUtils.copyFileToDirectory(excelFile, toFileDir);
		return true;
	}

	public void copyExcel(String fromPath, String toPath, String fileName)
			throws FileNotFoundException, IOException {
		// TODO 通过单元格的读取拷贝Excel文件
		// 创建新的excel
		HSSFWorkbook wbCreat = new HSSFWorkbook();
		File file = new File(fromPath);
		for (File excel : file.listFiles()) {
			// 打开已有的excel
			// strExcelPath = "WebRoot/methods/publicMethods/大而全公共模板.xls";
			InputStream in = new FileInputStream(fromPath + fileName);
			HSSFWorkbook wb = new HSSFWorkbook(in);
			for (int ii = 0; ii < wb.getNumberOfSheets(); ii++) {
				HSSFSheet sheet = wb.getSheetAt(ii);
				HSSFSheet sheetCreat = wbCreat.createSheet();
				// 复制源表中的合并单元格
				MergerRegion(sheetCreat, sheet);
				int firstRow = sheet.getFirstRowNum();
				int lastRow = sheet.getLastRowNum();
				for (int i = firstRow; i <= lastRow; i++) {
					// 创建新建excel Sheet的行
					HSSFRow rowCreat = sheetCreat.createRow(i);
					// 取得源有excel Sheet的行
					HSSFRow row = sheet.getRow(i);
					if (row == null)
						continue;
					// 单元格式样
					int firstCell = row.getFirstCellNum();
					int lastCell = row.getLastCellNum();
					for (int j = firstCell; j < lastCell; j++) {
						// 自动适应列宽 貌似不起作用
						// sheetCreat.autoSizeColumn(j);
						// System.out.println(row.getCell(j));
						rowCreat.createCell(j);
						String strVal = "";
						if (row.getCell(j) == null) {

						} else {
							strVal = removeInternalBlank(row.getCell(j)
									.getStringCellValue());
						}
						rowCreat.getCell(j).setCellValue(strVal);
					}
				}
			}
		}
		FileOutputStream fileOut = new FileOutputStream(toPath + fileName);
		wbCreat.write(fileOut);
		fileOut.close();
	}

	/**
	 * 复制原有sheet的合并单元格到新创建的sheet
	 * 
	 * @param sheetCreat
	 *            　　　　新创建sheet
	 * @param sheet
	 *            　　　　原有的sheet
	 */
	private static void MergerRegion(HSSFSheet sheetCreat, HSSFSheet sheet) {
		int sheetMergerCount = sheet.getNumMergedRegions();
		for (int i = 0; i < sheetMergerCount; i++) {
			CellRangeAddress mergedRegionAt = sheet.getMergedRegion(i);
			sheetCreat.addMergedRegion(mergedRegionAt);
		}

	}

	private static void getFont(HSSFSheet sheetCreat, HSSFSheet sheet) {

	}

	private static void getBlod(HSSFSheet sheetCreat, HSSFSheet sheet) {

	}

	private static void getAlign(HSSFSheet sheetCreat, HSSFSheet sheet) {

	}

	/**
	 * 去除字符串内部空格
	 */
	public static String removeInternalBlank(String s) {
		// System.out.println("bb:" + s);
		Pattern p = Pattern.compile("\\s*|\t|\r|\n");
		Matcher m = p.matcher(s);
		char str[] = s.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < str.length; i++) {
			if (str[i] == ' ') {
				sb.append(' ');
			} else {
				break;
			}
		}
		String after = m.replaceAll("");
		return sb.toString() + after;
	}

	public int getFileSheetNum() {
		return fileSheetNum;
	}

	public void setFileSheetNum(int fileSheetNum) {
		this.fileSheetNum = fileSheetNum;
	}

	public String getSpecialWrite() {
		return specialWrite;
	}

	public void setSpecialWrite(String specialWrite) {
		this.specialWrite = specialWrite;
	}

}
