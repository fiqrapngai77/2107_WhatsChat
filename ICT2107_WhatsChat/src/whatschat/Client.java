package whatschat;

import java.awt.EventQueue;

public class Client {

	static Thread clientThread = null;
	static View frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/**
		 * Run JFrame.
		 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new View();
					frame.setVisible(true);
					frame.setView();//setup window views
					frame.onClickRegister();//call register button click view
					frame.onClickCreate();//calls create button click view
					frame.onClickSend();// calls send button click view

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		/**
		 * Declare Thread
		 */
		clientThread = new Thread(new Runnable() {
			@Override
			public void run() {
				
				while (true) {
					String msg = Socket.dgpRecieve();//Recieve data packet from socket
					String[] msgString = msg.split("-");//Splits Recieve data packet into command and arg
					String command = msgString[0];
					String arg = msgString[1];

					if (command.equals("registerUserID")) {
						
						Variables.setUserIDList(arg);//put new userID in user list
						frame.updateListView();//Update entire list view in all running clients
						frame.appendConvoText(arg + "has joined!");//Update and displays new user after register to all running clients
						
					} else if (command.equals("createGroupName")) {
						//TODO: Create Group name
						//TODO: Validate group name
						Variables.setGroupNameList(arg);//put new Group name in group list
						frame.updateListView();//Update entire list view in all running clients
						frame.appendConvoText(arg + " group has been created!");//Update and displays new group name to all running clients
						//TODO: Select group members
						//TODO: Display to online users they are part of group

					}else if (command.equals("activeGroup")) {
						//TODO: Select/Switch active group
						//TODO: Display active group in convo box
						
					}else if (command.equals("groupMemberhip")) {
						//TODO: Add/Delete members
						//TODO: change group name
						//TODO: Choose to leave group
						//TODO: Existing member add user
						//TODO: Update and diplay last 10 msg sent
						
					}
				}
			}
		});
		Socket.runSocket();//Run socket
		clientThread.start();//Run Thread

	}

}
