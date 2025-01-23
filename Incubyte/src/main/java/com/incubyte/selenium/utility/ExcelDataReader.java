package com.incubyte.selenium.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;

public class ExcelDataReader implements IDataReader {

	private final ExcelConfiguration config;
	private Logger logger= LoggerFactory.getLogger(ExcelDataReader.class);

	public ExcelDataReader(ExcelConfiguration config) {
		this.config=config;
	}

	//To get the instance of the work book

	private XSSFWorkbook getWorkBook() throws InvalidFormatException, IOException {
		return new XSSFWorkbook(new File(config.getFileLocation()));
	}
	//To get the sheet using work book object

	private XSSFSheet getSheet(XSSFWorkbook workbook) {
		return workbook.getSheet(config.getSheetName());
	}

	//get the header from the excel file

	private List<String> getHeaders(XSSFSheet sheet){

		List<String> headers= new ArrayList<>();
		XSSFRow row = sheet.getRow(0);
		row.forEach((Cell)->{
			headers.add(Cell.getStringCellValue());
		});
		return Collections.unmodifiableList(headers);
	}

	@Override
	public List<Map<String, String>> getAllRows() {

		List<Map<String, String>> data = new ArrayList<Map<String, String>>();
		//try with resource
		try (XSSFWorkbook workbook = getWorkBook()) {
             XSSFSheet sheet=getSheet(workbook);
             data=getData(sheet);
		}catch (Exception e) {
			logger.error(e, () ->{
				return String.format("not able to read the excel from %s from location %s", 
						config.getFileName(), config.getFileLocation());
			});
			return Collections.emptyList();
		}
		return Collections.unmodifiableList(data);
	}

	private List<Map<String, String>> getData(XSSFSheet sheet) {

		List<Map<String, String>> data = new ArrayList<Map<String, String>>();
		List<String> headers=getHeaders(sheet);
		DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale
		
		for(int i=1; i<=sheet.getLastRowNum();i++) {
			Map<String, String> rowMap=new HashedMap<String, String>();
			XSSFRow row = sheet.getRow(i);
			forEachWithCounter(row, (index, Cell) ->{
				rowMap.put(headers.get(index), Cell.getStringCellValue());

			});
			data.add(rowMap);
		}

		return Collections.unmodifiableList(data);
	}
	
	private Map<String, String> getData(XSSFSheet sheet, int rowIndex) {

		List<String> headers=getHeaders(sheet);
			Map<String, String> rowMap=new HashedMap<String, String>();
			XSSFRow row = sheet.getRow(rowIndex);
			forEachWithCounter(row, (index, cell) ->{
				rowMap.put(headers.get(index), cell.getStringCellValue());

			});		

		return Collections.unmodifiableMap(rowMap);
	}

	@Override
	public Map<String, String> getSingleRows() {

		Map<String, String> data = new HashedMap<String, String>();
		
		try (XSSFWorkbook workbook = getWorkBook()) {
            XSSFSheet sheet=getSheet(workbook);
            data=getData(sheet, config.getIndex());
		}catch (Exception e) {
			logger.error(e, () ->{
				return String.format("not able to read the excel from %s from location %s", 
						config.getFileName(), config.getFileLocation());
			});
			return Collections.emptyMap();
		}
		return Collections.unmodifiableMap(data);
	}

	private void forEachWithCounter(Iterable<Cell> source, BiConsumer<Integer, Cell> biConsumer)
	{
		int i =0;
		for (Cell cell : source) {
			biConsumer.accept(i, cell);
			i++;
		}
	}

}
