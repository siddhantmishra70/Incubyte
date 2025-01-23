package com.incubyte.selenium.utility;

import java.util.List;
import java.util.Map;

public interface IDataReader {
	
	/**
	 * To get all the row from Excel
	 * @return
	 * @author Ethesh Gaur
	 */
	public List<Map<String, String>> getAllRows();

	/**
	 * To get the single row
	 * 
	 */
	public Map<String, String> getSingleRows();
}
