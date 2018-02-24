package whatschat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

public class View extends JFrame{

	private JButton btnRegister;
	private JLabel lblGroupManagement;
	private JButton btnSendMessage;
	private JPanel contentPane;
	private JTextField textFieldName;
	private JButton btnCreate;
	private JButton btnEdit;
	private JButton btnDelete;
	private JSeparator separator;
<<<<<<< HEAD:ICT2107_WhatsChat/src/WhatsChatClient.java
	private JList userList; 
	private DefaultListModel users;
	private static DefaultListModel groups;
=======
	private JList userList;
>>>>>>> develop/registration_tuhin:ICT2107_WhatsChat/src/whatschat/View.java
	private JLabel lblGroups;
	private static JList groupList;
	private JLabel lblConversation;
	private JTextField messageTextField;
<<<<<<< HEAD:ICT2107_WhatsChat/src/WhatsChatClient.java
	private static WhatsChatClient frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new WhatsChatClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
=======
	private JTextArea conversationText;
	private JTextField groupTextField;
	
	public void onClickRegister() {
		
		// Register User
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String newUser = textFieldName.getText();
				
				if (Register.validation(newUser) == true){
					Socket.dgpSend("registerUserID-" + newUser);
					
					
				}else {
					appendConvoText(Variables.getERROR());
				}
			}
		});
	}
	
	public void onClickCreate() {
		
		//Create Group
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String newGroup = groupTextField.getText();
				if (Register.validation(newGroup) == true){
					Socket.dgpSend("createGroupName-" + newGroup);
				}else {
					appendConvoText(Variables.getERROR());
>>>>>>> develop/registration_tuhin:ICT2107_WhatsChat/src/whatschat/View.java
				}
			}
		});
	}
	
	public void onClickSend() {
		btnSendMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String message = messageTextField.getText();
				appendConvoText(message);
				messageTextField.setText("");
			}
		});
		
	}
	
	public void appendConvoText(String message) {
		conversationText.append(message + "\n");
	}
	
	public void updateListView() {
		userList.setModel(Variables.getUserIDList());
		groupList.setModel(Variables.getGroupNameList());
	}
	

	public void setView() {

		// Set Window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
<<<<<<< HEAD:ICT2107_WhatsChat/src/WhatsChatClient.java
		
		setTitle("WhatsChatClient");
		
		//Initialize DefaultListModels (basically arrays)
		users = new DefaultListModel();
		groups = new DefaultListModel();
		
		//Dummy Data
		users.addElement("Kenny Omega");
		groups.addElement("Example Group");
		
		//Initialize Views
		JButton btnRegister = new JButton("Register User");
		textFieldName = new JTextField();
		JLabel lblGroupManagement = new JLabel("Group Management");
		btnCreate = new JButton("Create");
		btnEdit = new JButton("Edit");
		btnDelete = new JButton("Delete");
		separator = new JSeparator();
		messageTextField = new JTextField();
		JButton btnSendMessage = new JButton("Send Message");
		
		//Register Button
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newUser = textFieldName.getText();
				
				//Username validation
				if(newUser.length()<8 || newUser.contains(" ") || Character.isDigit(newUser.charAt(0)) || newUser.isEmpty()) {
					System.out.println("Error");
				}else {
					users.addElement(newUser);
					userList.setModel(users);
				}
			}
		});
=======

		// -------------------------User Register-----------------------------------------//
		// Register Button
		btnRegister = new JButton("Register User");
>>>>>>> develop/registration_tuhin:ICT2107_WhatsChat/src/whatschat/View.java
		btnRegister.setBounds(10, 21, 105, 23);
		contentPane.add(btnRegister);

		// Username Field
		textFieldName = new JTextField();
		textFieldName.setBounds(125, 24, 271, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);

		// -------------------------Group Management-----------------------------------------//
		// Group Management label
		lblGroupManagement = new JLabel("Group Management");
		lblGroupManagement.setBounds(10, 76, 118, 14);
		contentPane.add(lblGroupManagement);

		groupTextField = new JTextField();
		groupTextField.setBounds(130, 70, 118, 20);
		contentPane.add(groupTextField);
		groupTextField.setColumns(10);

		// Create Button
		btnCreate = new JButton("Create");
		btnCreate.setBounds(10, 101, 89, 23);
		contentPane.add(btnCreate);
<<<<<<< HEAD:ICT2107_WhatsChat/src/WhatsChatClient.java
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CreateDialog().setVisible(true);
				frame.setEnabled(false);
			}
		});
				
		//Edit Button
		btnEdit.setBounds(109, 101, 89, 23);
		contentPane.add(btnEdit);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new EditDialog(groupList.getSelectedIndex(),groupList.getSelectedValue().toString()).setVisible(true);
				frame.setEnabled(false);
			}
		});
		
		//Delete Button
		btnDelete.setBounds(208, 101, 89, 23);
		contentPane.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				groups.removeElementAt(groupList.getSelectedIndex());
			}
		});
		
		//Separator
=======

		// Edit Button
		btnEdit = new JButton("Edit");
		btnEdit.setBounds(109, 101, 89, 23);
		contentPane.add(btnEdit);

		// Delete Button
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(208, 101, 89, 23);
		contentPane.add(btnDelete);

		// Separator
		separator = new JSeparator();
>>>>>>> develop/registration_tuhin:ICT2107_WhatsChat/src/whatschat/View.java
		separator.setBounds(10, 129, 289, 2);
		contentPane.add(separator);

		// ----------------------------Online User List------------------------------------//
		// Online Users label
		JLabel lblOnlineUsers = new JLabel("Online Users");
		lblOnlineUsers.setBounds(10, 163, 63, 14);
		contentPane.add(lblOnlineUsers);

		// Online Users JList
		userList = new JList();
		userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		userList.setModel(Variables.getUserIDList());
		userList.setBounds(10, 188, 105, 241);
		contentPane.add(userList);

		// -------------------------Groups List---------------------------------------------//
		// Groups List Label
		lblGroups = new JLabel("Groups");
		lblGroups.setBounds(125, 163, 49, 14);
		contentPane.add(lblGroups);

		// Group JList
		groupList = new JList();
		groupList.setModel(Variables.getGroupNameList());
		groupList.setBounds(125, 188, 172, 241);
		contentPane.add(groupList);
		groupList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// ---------------------------------Conversation---------------------------------------//

		lblConversation = new JLabel("Conversation");
		lblConversation.setBounds(307, 163, 205, 14);
		contentPane.add(lblConversation);

		conversationText = new JTextArea();
		conversationText.setEditable(false);
		conversationText.setWrapStyleWord(true);
		conversationText.setLineWrap(true);
		conversationText.setBounds(307, 188, 344, 241);
		contentPane.add(conversationText);
<<<<<<< HEAD:ICT2107_WhatsChat/src/WhatsChatClient.java
		
		
		btnSendMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				message = messageTextField.getText();
				conversationText.append(message + "\n");
				messageTextField.setText("");
				
			}
		});
=======

		btnSendMessage = new JButton("Send Message");
>>>>>>> develop/registration_tuhin:ICT2107_WhatsChat/src/whatschat/View.java
		btnSendMessage.setBounds(10, 461, 128, 23);
		contentPane.add(btnSendMessage);

		messageTextField = new JTextField();
		messageTextField.setBounds(148, 462, 502, 20);
		contentPane.add(messageTextField);
		messageTextField.setColumns(10);
		
	}
<<<<<<< HEAD:ICT2107_WhatsChat/src/WhatsChatClient.java
	
	//--------------------------Functions to get the private variables-----------------------//
	public static DefaultListModel getGroupModel() {
		return groups;
	}
	
	public static JList getGroupList() {
		return groupList;
	}
	
	public static JFrame getFrame() {
		return frame;
	}
	
	//---------------------------------------------------------------------------------------//
=======


	
>>>>>>> develop/registration_tuhin:ICT2107_WhatsChat/src/whatschat/View.java
}
