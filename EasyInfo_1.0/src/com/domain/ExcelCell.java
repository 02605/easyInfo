package com.domain;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.CellAddress;

public class ExcelCell {
	String originString;

	String value;// 存储查询出的value
	CellStyle front;// 存储该单元格的格式
	String databaseString;// 存储该单元格对应的数据库字段

	// 以下为原始单元格的位置
	CellAddress address;
	// 移动位置后的单元格
	CellAddress newAddress;
	int sheetIndex;

	// 用以判断是否为合并单元格
	Boolean isMergeCell;
	int mergeLastRow;
	int mergeLastCol;
	int mergeFirstRow;

	Boolean isWrite=false;

	public Boolean getIsWrite() {
		return isWrite;
	}

	public void setIsWrite(Boolean isWrite) {
		this.isWrite = isWrite;
	}

	public int getMergeLastRow() {
		return mergeLastRow;
	}

	public void setMergeLastRow(int mergeLastRow) {
		this.mergeLastRow = mergeLastRow;
	}

	public int getMergeLastCol() {
		return mergeLastCol;
	}

	public void setMergeLastCol(int mergeLastCol) {
		this.mergeLastCol = mergeLastCol;
	}

	public int getMergeFirstRow() {
		return mergeFirstRow;
	}

	public void setMergeFirstRow(int mergeFirstRow) {
		this.mergeFirstRow = mergeFirstRow;
	}

	public int getMergeFirstCol() {
		return mergeFirstCol;
	}

	public void setMergeFirstCol(int mergeFirstCol) {
		this.mergeFirstCol = mergeFirstCol;
	}

	int mergeFirstCol;

	// 用以区分该字符段重复的次数
	int duplicateNum;

	public int getDuplicateNum() {
		return duplicateNum;
	}

	public void setDuplicateNum(int duplicateNum) {
		this.duplicateNum = duplicateNum;
	}

	public int getSheetIndex() {
		return sheetIndex;
	}

	public void setSheetIndex(int sheetIndex) {
		this.sheetIndex = sheetIndex;
	}

	public Boolean getIsMergeCell() {
		return isMergeCell;
	}

	public void setIsMergeCell(Boolean isMergeCell) {
		this.isMergeCell = isMergeCell;
	}

	public void setNewAddress(CellAddress newAddress) {
		this.newAddress = newAddress;
	}

	public String getOriginString() {
		return originString;
	}

	public void setOriginString(String originString) {
		this.originString = originString;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public CellStyle getFront() {
		return front;
	}

	public void setFront(CellStyle cellStyle) {
		this.front = cellStyle;
	}

	public String getDatabaseString() {
		return databaseString;
	}

	public void setDatabaseString(String databaseString) {
		this.databaseString = databaseString;
	}

	public CellAddress getAddress() {
		return address;
	}

	public void setAddress(CellAddress cellAddress) {
		this.address = cellAddress;
	}

	public CellAddress getNewAddress() {
		return newAddress;
	}

	/**
	 * 传参确定写入的方向，例如right，则将该单元格右移一格
	 * 
	 * @param direction
	 *            方向
	 * @return
	 */
	public void setNewAddress(String direction, int step) {
		int x = step;
		int y = step;
		switch (direction) {
		case "right":
			y = 0;
			break;
		case "left":
			y = 0;
			x = -x;
			break;
		case "up":
			y = -y;
			x = 0;
			break;
		case "down":// 往下写入可能存在问题
			x = 0;
			break;
		default:
			System.out.println("方向选择错误，请确定代码正确");
			break;
		}
		// 获取现有的Address
		CellAddress originAddress = this.getAddress();
		// 获取col&row
		int column = originAddress.getColumn();
		int row = originAddress.getRow();
		// 利用CellAddress的构造函数，改变单元格的位置
		this.newAddress = new CellAddress(row + y, column + x);
	}

	public String toString() {
		return "源文件的单元格内容为：" + originString + "\n重复次数(默认+1，便于显示):"
				+ (getDuplicateNum() + 1) + "\n该单元格对应的数据库字段为：" + databaseString
				+ "\n链接数据库后读取到的数据为：" + value + "\n表格的位置为：" + getSheetIndex()
				+ " " + address + "\n转为位置坐标为 X:" + address.getColumn() + " Y:"
				+ address.getRow() + "\n右移一格后的坐标：" + getNewAddress()
				+ "\n是否为合并单元格:" + getIsMergeCell() + printMergeRange()
				+ printWrite() + "\n\n";
	}

	private String printMergeRange() {
		if (getIsMergeCell()) {
			int row = getMergeLastRow() - getMergeFirstRow() + 1;
			int col = getMergeLastCol() - getMergeFirstCol() + 1;
			String str = "\n范围为(" + getMergeFirstRow() + ","
					+ getMergeFirstCol() + " : " + getMergeLastRow() + ","
					+ getMergeLastCol() + ")" + "\n占据 " + row + " 行," + col
					+ " 列" + "," + row * col + " 单元格";
			return str;
		}
		return "";
	}

	private String printWrite() {
		if (getIsWrite()==false)
			return "\n※※※※※※※※写入状态:" + getIsWrite();
		return "";
	}
}
