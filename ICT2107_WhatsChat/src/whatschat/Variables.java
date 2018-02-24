package whatschat;

import javax.swing.DefaultListModel;

public final class Variables {
		
	private static DefaultListModel<String> userIDList = new DefaultListModel<String>();
	private static DefaultListModel<String> groupNameList = new DefaultListModel<String>();
	static String ERROR ="";


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
