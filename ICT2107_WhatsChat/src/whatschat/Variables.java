package whatschat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.DefaultListModel;

public final class Variables {
		
	private static DefaultListModel<String> userIDList = new DefaultListModel<String>();//UserId List
	private static DefaultListModel<String> groupNameList = new DefaultListModel<String>();//Group Name
	Map<String,String> membership = new HashMap<String, String>();//Members of group
	static Map<String, List<String>> map = new HashMap<String, List<String>>();//Members of group test
	static String ERROR ="";
	
	public static void put(String groupName, String userID) {
		map.putIfAbsent(groupName, new ArrayList<String>());
		map.get(groupName).add(userID);
		for (Entry<String, List<String>> ee : map.entrySet()) {
		    String key = ee.getKey();
		    List<String> values = ee.getValue();
		    // TODO: Do something.
		    System.out.println(values);
		}
	}


	//Get userIDList
	public static DefaultListModel<String> getUserIDList() {
		return userIDList;
	}
	
	//Set UserIDList
	public static void setUserIDList(String userIDList) {
		Variables.userIDList.addElement(userIDList);
	}
	
	//Get groupNameList
	public static DefaultListModel<String> getGroupNameList() {
		return groupNameList;
	}
	
	//Set groupNameList
	public static void setGroupNameList(String groupIDList) {
		Variables.groupNameList.addElement(groupIDList);
	}	

	//Get ERROR
	public static String getERROR() {
		return ERROR;
	}
	
	//Set ERROR
	public static void setERROR(String ERROR) {
		Variables.ERROR = "SYSTEM NOTICE: " + ERROR + "Please try again";
	}
	
	
}
