package com.incubyte.selenium.utility;

import java.util.Objects;

public class ExcelConfiguration {
	
	private final String fileName;
	private final String fileLocation;
	private final String sheetName;
	private int index =-1;
	
	public int getIndex() {
		return index;
	}

	public String getFileName() {
		return fileName;
	}

	public String getFileLocation() {
		return fileLocation;
	}

	public String getSheetName() {
		return sheetName;
	}

	
	
	
	private ExcelConfiguration(String fileName, String fileLocation, String sheetName, int index) {
		
		this.fileName = fileName;
		this.fileLocation = fileLocation;
		this.sheetName = sheetName;
		this.index = index;
	}
	
	public static class ExcelConfigurationBuilder {
		
		private String fileName;
		private String fileLocation;
		private String sheetName;
		private int index = -1;
	
	
	public ExcelConfigurationBuilder setFileName(String fileName) {
		this.fileName=fileName;
		return this;
	}
	
	public ExcelConfigurationBuilder setFileLocation(String fileLocation) {
		this.fileLocation=fileLocation;
		return this;
	}
	public ExcelConfigurationBuilder setSheetName(String sheetName) {
		this.sheetName=sheetName;
		return this;
	}
	public ExcelConfigurationBuilder setIndex(int index) {
		this.index=index;
		return this;
	
	}
	
	public ExcelConfiguration build() {
		Objects.requireNonNull(fileName);
		Objects.requireNonNull(fileLocation);
		Objects.requireNonNull(sheetName);
		Objects.requireNonNull(index);
		return new ExcelConfiguration(fileName, fileLocation, sheetName, index) ;
		
		
	}
	}
	
}
