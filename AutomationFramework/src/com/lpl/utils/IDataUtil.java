package com.lpl.utils;

import java.sql.Connection;
import java.util.HashMap;

public interface IDataUtil {
	
	public HashMap<String,String> getTestData(int intScriptID, int intEnvID);
	public void getLoginCredential();
	public void getObjects();
	
}
