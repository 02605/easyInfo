package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;

import com.domain.ExcelCell;

public class ReadExcelBean {
	public ReadExcelBean() {
	}

	/**
	 * 公共模板可以使用反向解析，更精准。私人模板只允许正向解析
	 * 
	 * @way forward 正向解析(姓名->tea_name) back 反向解析(tea_name->姓名)
	 * @param fromPath
	 *            文件所在地址
	 * @param fileName
	 *            文件名
	 * @return 所有ExcelCell对象，对应所有Excel中有值的单元格。
	 * @throws Exception
	 */
	public ArrayList<ExcelCell> readOriginExcelFile(String fromPath,
			String fileName, String way) throws Exception {
		// 获取解析表
		ArrayList<String[]> basicCheckTable = new AnalyticExcelBean()
				.getBasicCheckTable();
		// 新建存储对象-originExcelCells->原始excel文件的表头字段的列表
		ArrayList<ExcelCell> originExcelCells = new ArrayList<ExcelCell>();
		// 新建对象,并赋值为null
		File excelFile = null;// Excel文件对象
		InputStream is = null;// 输入流对象
		// -----------------------------------开始读取文件
		try {
			// 一.文件是否存在判断
			excelFile = new File(fromPath + fileName);
			if (!excelFile.exists()) {
				throw new Exception(
						"The file not exit.Please cheack out.不存在此文件，请检查重试");
			}
			// 获取文件输入流
			is = new FileInputStream(excelFile);
			// 打开Excel文件
			Workbook workbook = WorkbookFactory.create(is);
			/**
			 * @param sheetIndex
			 *            excel文件中表格索引号
			 * @param rowIndex
			 *            此表格内的行索引号
			 * @param colIndex
			 *            此行的列索引号
			 */
			for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
				// 获取当前所在表格
				Sheet sheet = workbook.getSheetAt(sheetIndex);
				// 开始遍历该表格
				for (int rowIndex = 0; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
					// 根据行索引号，获取当前行
					Row row = sheet.getRow(rowIndex);
					// 如果读取的行,为null，则跳过该行
					if (row == null)
						continue;
					// 根据列索引号，结合行索引号，共同锁定到具体单元格
					for (int colIndex = 0; colIndex < row.getLastCellNum(); colIndex++) {
						Cell cell = row.getCell(colIndex);
						int nullFlag = cell.CELL_TYPE_BLANK;// nullFlag=3即为空
						// 只有不为空的字段才会被加入匹配列表,实现去除空字段
						if (row.getCell(colIndex) != null
								&& nullFlag == 3
								&& !(row.getCell(colIndex).getStringCellValue()
										.equals(""))) {
							// 新建单元格实体
							ExcelCell tempExcelCell = new ExcelCell();
							// 存储所在表格索引号
							tempExcelCell.setSheetIndex(sheetIndex);
							// 将读取到的内容存取到实体中-此为源文件拥有的字段
							tempExcelCell.setOriginString(cell.toString());
							// 存储在表格内的位置-用以进行单元格的移动
							tempExcelCell.setAddress(cell.getAddress());
							// 存储表格样式，暂时无用可以考虑删除
							// tempExcelCell.setFront(cell.getCellStyle());
							// 获取当前单元格的行号与列号-用以判断合并单元格的范围
							int mergeRow = cell.getAddress().getRow();
							int mergeCol = cell.getAddress().getColumn();
							// 判断是否为合并单元格
							if (isMergedRegion(sheet, mergeRow, mergeCol,
									tempExcelCell)) {
								// 如果是合并单元格-存储合并单元格属性为true
								tempExcelCell.setIsMergeCell(true);
							} else {
								// 否则存为false
								tempExcelCell.setIsMergeCell(false);
							}
							// 判断重复次数-从0开始技术-例如:存在一个，计数为0
							int duplicate = 0;
							for (ExcelCell excelCell : originExcelCells) {
								if (cell.toString().equals(
										excelCell.getOriginString()))
									duplicate++;
							}
							// 写入重复次数
							tempExcelCell.setDuplicateNum(duplicate);

							// 同时满足"空单元格","合并单元格"的对象予以去除
							if (tempExcelCell.getOriginString().equals("")
									&& tempExcelCell.getIsMergeCell() == true)
								continue;
							// 将该临时Excel对象压入到list中
							originExcelCells.add(tempExcelCell);
						}
					}

				}

			}
			// -----------------------------------------------------循环结束后,excel中所有的单元格字段存储完毕
			// --------------------------------------------开始在自定义的库中进行匹对关键词(AnalyticExcelBean)
			// 从表头字段list开始外循环
			/**
			 * @cellIndex ExcelCell对象索引号
			 * @listIndex 用以对照的list的索引号
			 * @stringIndex 用以对照的String[]的索引号
			 */
			for (int cellIndex = 0; cellIndex < originExcelCells.size(); cellIndex++) {
				// 开始和基础检查表的各个数组进行匹对
				begin: for (int listIndex = 0; listIndex < basicCheckTable
						.size(); listIndex++) {
					// 获取数组对象
					String[] tempArray = (String[]) basicCheckTable
							.get(listIndex);
					// 从获取的数组对象中开始遍历
					for (int stringIndex = 0; stringIndex < tempArray.length; stringIndex++) {
						// 如果匹配成功-存储其数据库标准字段到ExcelCell对象中
						if (tempArray[stringIndex].equals(originExcelCells.get(
								cellIndex).getOriginString())) {
							originExcelCells.get(cellIndex).setDatabaseString(
									tempArray[0]);
							// 反向解析的处理过程-根据标准字段存储相应的中文
							if (way.equals("back")) {
								originExcelCells.get(cellIndex)
										.setOriginString(tempArray[1]);
							}
							listIndex = 0;
							// 跳出循环到开始检查基础表的时候,便于listIndex++
							break begin;
						} else {
							// 当表内的数组对象 检索到最后一项之后显示未查找到,开始检索基础检查表的下一项
							// -1为了防止数组越界
							if (stringIndex == tempArray.length - 1) {
								// 如果不等于最终长度,就跳转回检查表的遍历起点
								// 说明此数组已经检索完毕，没有找到相应的信息，开始进行下一个数组的匹配
								if (listIndex != basicCheckTable.size() - 1) {
									continue begin;
								} else {
									// 如果检索完毕等于基础检查表的长度,说明可以结束了,显示未查询到的结果
									// System.out.println("不存在 "
									// + originExcelCells.get(cellIndex)
									// + " 请检查表格");
								}
							}
						}
					}
				}
			}
			// System.out.println(originExcelCells.toString());// 输出查看获取的表头元素
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
		} finally {// 关闭文件流
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return originExcelCells;
	}

	/**
	 * 判断是否为合并单元格
	 * 
	 * @param sheet
	 *            读取表格
	 * @param row
	 *            行号
	 * @param column
	 *            列号
	 * @return
	 */
	private boolean isMergedRegion(Sheet sheet, int row, int column,
			ExcelCell cell) {
		// 获取表格中的合并单元格的数量
		int sheetMergeCount = sheet.getNumMergedRegions();
		// 根据数量开始遍历
		for (int i = 0; i < sheetMergeCount; i++) {
			// 获取合并单元格的范围
			CellRangeAddress range = sheet.getMergedRegion(i);
			// 精确获取范围
			int firstColumn = range.getFirstColumn();
			int lastColumn = range.getLastColumn();
			int firstRow = range.getFirstRow();
			int lastRow = range.getLastRow();
			if (row >= firstRow && row <= lastRow) {
				if (column >= firstColumn && column <= lastColumn) {
					// 设定ExcelCell对象属性
					cell.setMergeLastRow(lastRow);
					cell.setMergeLastCol(lastColumn);
					cell.setMergeFirstRow(firstRow);
					cell.setMergeFirstCol(firstColumn);
					return true;
				}
			}
		}
		return false;
	}
}
