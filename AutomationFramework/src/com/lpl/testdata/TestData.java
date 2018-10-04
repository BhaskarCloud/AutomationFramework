package com.lpl.testdata;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.HashMap;

import com.lpl.utils.DBFactory;
import com.lpl.utils.IDataUtil;

public class TestData {
	String testDataType;

	public String getTestDataType() {
		return testDataType;
	}

	public void setTestDataType(String testDataType) {
		this.testDataType = testDataType;
	}

	public TestData() {

	}

	public static HashMap<String, String> getTestDataFromDB(int intScriptID, int intEnvID) {
		/**
		 * Create the HashMap to store the test data key and test data value Example:
		 * Key will be "strAccountNo" and Value will be "1111-1111"
		 */

		IDataUtil dbutil = DBFactory.getWorker("mysql");
		return dbutil.getTestData(intScriptID, intEnvID);

	}

}
