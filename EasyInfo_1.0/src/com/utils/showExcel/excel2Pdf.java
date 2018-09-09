package com.utils.showExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class excel2Pdf {

	public excel2Pdf(String filePath) throws DocumentException, IOException {
		// 打开输入流
		FileInputStream input_document = new FileInputStream(new File(filePath));
		// 加载excel文件
		XSSFWorkbook excelFile = new XSSFWorkbook(input_document);
		// 开始读取excel文件，获取第一个表
		XSSFSheet my_worksheet = excelFile.getSheetAt(0);
		// 新建遍历器，遍历excel行
		Iterator<Row> rowIterator = my_worksheet.iterator();
		// 新建pdf文件
		Document aimPdf = new Document();
		PdfWriter.getInstance(aimPdf, new FileOutputStream(
				"WebRoot/methods/autoCreateExcel/teacher.pdf"));
		// 打开pdf文件
		aimPdf.open();
		// PdfPTable(int row)构造函数，传参为行数
		// 以后可以读取行数再传参过去
		PdfPTable my_table = new PdfPTable(my_worksheet.getRow(0)
				.getLastCellNum());
		// We will use the object below to dynamically add new data to the table
		PdfPCell table_cell;
		// 开始遍历行
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			// 开始遍历本行的单个单元格
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					// Push the data from Excel to PDF Cell
					table_cell = new PdfPCell(new Phrase(
							cell.getStringCellValue()));
					// feel free to move the code below to suit to your needs
					my_table.addCell(table_cell);
					break;
				case Cell.CELL_TYPE_BLANK:
					// Push the data from Excel to PDF Cell
					table_cell = new PdfPCell(new Phrase(""));
					// feel free to move the code below to suit to your needs
					my_table.addCell(table_cell);
					break;
				}
			}

		}
	}
}
