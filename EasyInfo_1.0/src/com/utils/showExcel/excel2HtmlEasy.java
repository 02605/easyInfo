package com.utils.showExcel;

import java.util.ArrayList;

import com.domain.ExcelCell;

public class excel2HtmlEasy {
	/**
	 * excel07转html filename:要读取的文件所在文件夹 filepath:文件名 htmlname:生成html名称
	 * path:html存放路径
	 * */
	public static void ExcelToHtml(String filepath, String sourceid,
			ArrayList<ExcelCell> excelCellArrayList) throws Exception {
		// 判断高度
		int height = 0;
		for (int i = 0; i < excelCellArrayList.size(); i++) {
			int row = excelCellArrayList.get(i).getAddress().getRow();
			if (row > height)
				height = row;
		}
		System.out.println("excel height is :"+height);
		String html = "";
		// 生成基本的table语句
		html += "<table border='1' align='left'>";
		for (int i = 0; i < height; i++) {
			html += "\n<tr>";
			// 开始遍历单元格对象
			for (int j = 0; j < excelCellArrayList.size(); j++) {
				// 获取当前对象的所在列号
				int oldAddressCol = excelCellArrayList.get(j).getAddress()
						.getColumn();
				int oldAddressRow = excelCellArrayList.get(j).getAddress()
						.getRow();
				String originString = excelCellArrayList.get(j)
						.getOriginString();
				// 写入原始内容
				if (i == oldAddressRow) {
					if (!excelCellArrayList.get(j).getOriginString()
							.equals(null)) {
						html += "\n<td>\n" + originString + "\n</td>";
					} else {
						html += "\n<td>\n" + "\n</td>";
					}
				}
			}
			html += "\n</tr>";
		}
		html += "\n</table>";
		System.out.println(html);
		// // 获取地址
		// filepath =
		// "D:\\Data\\This Computer\\Desktop\\project\\EasyInfo_1.0\\WebRoot\\methods\\publicMethods\\teacher.xlsx";
		// Workbook workbook = null;
		// // 打开输入流
		// InputStream is = new FileInputStream(filepath);
		// try {
		// String html = "";
		// workbook = new XSSFWorkbook(is);
		// for (int numSheet = 0; numSheet < workbook.getNumberOfSheets();
		// numSheet++) {
		// // 判断有几个表
		// Sheet sheet = workbook.getSheetAt(numSheet);
		// if (sheet == null) {
		// continue;
		// }
		// // 获取第一行的位置
		// int firstRowIndex = sheet.getFirstRowNum();
		// // 获取最后一行的位置
		// int lastRowIndex = sheet.getLastRowNum();
		// // 生成基本的table语句
		// html += "<table border='1' align='left'>";
		// // 获取第一行的内容
		// Row firstRow = sheet.getRow(firstRowIndex);
		// if (firstRow==null) {
		// break;
		// }
		// // 开始遍历单元格
		// for (int i = firstRow.getFirstCellNum(); i < firstRow
		// .getLastCellNum(); i++) {
		// Cell cell = firstRow.getCell(i);
		// String cellValue = getCellValue(cell, true);
		// // 生成表头
		// html += "\n<th>" + cellValue + "</th>";
		// }
		//
		// // 行
		// for (int rowIndex = firstRowIndex + 1; rowIndex < lastRowIndex;
		// rowIndex++) {
		// Row currentRow = sheet.getRow(rowIndex);
		// html += "\n<tr>";
		// if (currentRow != null) {
		//
		// int firstColumnIndex = currentRow.getFirstCellNum();
		// int lastColumnIndex = currentRow.getLastCellNum();
		// // 列
		// for (int columnIndex = firstColumnIndex; columnIndex <=
		// lastColumnIndex; columnIndex++) {
		// Cell currentCell = currentRow
		// .getCell(columnIndex + 1);
		// String currentCellValue = getCellValue(currentCell,
		// true);
		// html += "\n<td>" + currentCellValue + "</td>";
		// }
		// } else {
		// html += "\n";
		// }
		// html += "\n</tr>";
		// }
		// html += "\n</table>";
		// System.out.println(html);
		// // 注释掉输出流
		// // ByteArrayOutputStream outStream = new
		// // ByteArrayOutputStream();
		// // DOMSource domSource = new DOMSource();
		// // StreamResult streamResult = new StreamResult(outStream);
		// //
		// // TransformerFactory tf = TransformerFactory.newInstance();
		// // Transformer serializer = tf.newTransformer();
		// // serializer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
		// // serializer.setOutputProperty(OutputKeys.INDENT, "yes");
		// // serializer.setOutputProperty(OutputKeys.METHOD, "html");
		// // serializer.transform(domSource, streamResult);
		// // outStream.close();
		// // FileUtils.writeStringToFile(new File(path, htmlname), html,
		// // "gbk");
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		//
		// }
		//
		// /**
		// * 读取单元格
		// *
		// */
		// private static String getCellValue(Cell cell, boolean treatAsStr) {
		// if (cell == null) {
		// return "";
		// }
		//
		// if (treatAsStr) {
		// cell.setCellType(Cell.CELL_TYPE_STRING);
		// }
		//
		// if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
		// return String.valueOf(cell.getBooleanCellValue());
		// } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
		// return String.valueOf(cell.getNumericCellValue());
		// } else {
		// return String.valueOf(cell.getStringCellValue());
		// }
	}
}
