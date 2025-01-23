package com.incubyte.selenium.stepdefinition;

/**
 * 
 * @author Ethesh Gaur
 */
import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

	
	private static final Map<ScenarioKeys, Object> data = new HashMap<>();
	 
    public void save(ScenarioKeys scenarioKeys, Object value) {
        data.put(scenarioKeys, value);
    }
 
    public <T> T getData(ScenarioKeys scenarioKeys) {
        return (T) data.get(scenarioKeys);
    }
}

