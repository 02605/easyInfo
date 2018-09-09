package com.utils;

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

	public excel2Pdf() throws DocumentException, IOException {
		// 打开输入流
		FileInputStream input_document = new FileInputStream(
				new File(
						"D:\\Data\\This Computer\\Desktop\\project\\EasyInfo_1.0\\WebRoot\\methods\\publicMethods\\teacher-en.xlsx"));
		// 加载excel文件
		XSSFWorkbook excelFile = new XSSFWorkbook(input_document);
		// 开始读取excel文件，获取第一个表
		XSSFSheet my_worksheet = excelFile.getSheetAt(0);
		// 新建遍历器，遍历excel行
		Iterator<Row> rowIterator = my_worksheet.iterator();
		// 新建pdf文件
		Document aimPdf = new Document();
		PdfWriter
				.getInstance(
						aimPdf,
						new FileOutputStream(
								"D:\\Data\\This Computer\\Desktop\\project\\EasyInfo_1.0\\WebRoot\\methods\\publicMethods\\teacher.pdf"));
		// 打开pdf文件
		aimPdf.open();
		// PdfPTable(int row)构造函数，传参为行数
		// 以后可以读取行数再传参过去
		PdfPTable my_table = new PdfPTable(4);
		// We will use the object below to dynamically add new data to the table
		PdfPCell table_cell;
		// 开始遍历行
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			// 开始遍历本行的单个单元格
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next(); // Fetch CELL
				switch (cell.getCellType()) { // Identify CELL type
				// you need to add more code here based on
				// your requirement / transformations
				case Cell.CELL_TYPE_STRING:
					// Push the data from Excel to PDF Cell
					table_cell = new PdfPCell(new Phrase(
							cell.getStringCellValue()));
					// feel free to move the code below to suit to your needs
					my_table.addCell(table_cell);
					break;
				case Cell.CELL_TYPE_BLANK:
					// Push the data from Excel to PDF Cell
					table_cell = new PdfPCell(new Phrase(
							""));
					// feel free to move the code below to suit to your needs
					my_table.addCell(table_cell);
					break;
				}
				// next line
			}

		}
		// Finally add the table to PDF document
		aimPdf.add(my_table);

		aimPdf.close();
		// we created our pdf file..
		input_document.close(); // close xls
		// BaseFont bfChinese = BaseFont.createFont("STSong-Light",
		// "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
		// Font FontChinese = new Font(bfChinese, 12, Font.NORMAL);
		//
		// // 第一步，创建 document 对象
		// Rectangle rectPageSize = new Rectangle(PageSize.A4);
		//
		// // 下面代码设置页面横置
		// // rectPageSize = rectPageSize.rotate();
		//
		// // 创建 document 对象并指定边距
		// Document doc = new Document(rectPageSize, 50, 50, 50, 50);
		// Document document = new Document();
		// try {
		// // 第二步, 将 Document 实例和文件输出流用 PdfWriter 类绑定在一起
		// // 从而完成向 Document 写，即写入 PDF 文档
		// PdfWriter.getInstance(document, new FileOutputStream(
		// "src/com/test/HelloWorld.pdf"));
		// // 第 3 步, 打开文档
		// document.open();
		// // 第 3 步, 向文档添加文字. 文档由段组成
		// document.add(new Paragraph("Hello World"));
		//
		// Paragraph par = new Paragraph("世界你好", FontChinese);
		// document.add(par);
		//
		// PdfPTable table = new PdfPTable(3);
		// for (int i = 0; i < 12; i++) {
		// if (i == 0) {
		// PdfPCell cell = new PdfPCell();
		// cell.setColspan(3);
		// // cell.setBackgroundColor(new Color(180, 180, 180));
		// cell.addElement(new Paragraph("表格头", FontChinese));
		// table.addCell(cell);
		// } else {
		// PdfPCell cell = new PdfPCell();
		// cell.addElement(new Paragraph("表格内容", FontChinese));
		// table.addCell(cell);
		// }
		// }
		// document.add(table);
		//
		// } catch (DocumentException de) {
		// System.err.println(de.getMessage());
		// } catch (IOException ioe) {
		// System.err.println(ioe.getMessage());
		// }
		// // 关闭 document
		// document.close();
		//
		// System.out.println("生成 HelloPdf 成功！");
	}
}
