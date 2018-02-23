
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JTextPane;


public class WhatsChatClient extends JFrame {

	String label[] = { "Zero", "One", "Two", "Three", "Four", "Five", "Six",
		      "Seven", "Eight", "Nine", "Ten", "Eleven" };
	
	private String newUser;
	private String message;
	
	private JPanel contentPane;
	private JTextField textFieldName;
	private JButton btnCreate;
	private JButton btnEdit;
	private JButton btnDelete;
	private JSeparator separator;
	private JList userList; 
	private DefaultListModel users;
	private DefaultListModel groups;
	private JLabel lblGroups;
	private JList groupList;
	private JLabel lblConversation;
	private JTextField messageTextField;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WhatsChatClient frame = new WhatsChatClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WhatsChatClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Initialize DefaultListModels (basically arrays)
		users = new DefaultListModel();
		groups = new DefaultListModel();
		
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
				users.addElement(newUser);
				userList.setModel(users);
				
			}
		});
		btnRegister.setBounds(10, 21, 105, 23);
		contentPane.add(btnRegister);
		
		//Username Field
		textFieldName.setBounds(125, 24, 271, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		//-------------------------Group Management-----------------------------------------//
		//Group Management label
		lblGroupManagement.setBounds(10, 76, 118, 14);
		contentPane.add(lblGroupManagement);
		
		//Create Button
		btnCreate.setBounds(10, 101, 89, 23);
		contentPane.add(btnCreate);
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				groups.addElement("group");
				groupList.setModel(groups);
			}
		});
				
		//Edit Button
		btnEdit.setBounds(109, 101, 89, 23);
		contentPane.add(btnEdit);
		
		//Delete Button
		btnDelete.setBounds(208, 101, 89, 23);
		contentPane.add(btnDelete);
		
		//Separator
		separator.setBounds(10, 129, 289, 2);
		contentPane.add(separator);
		
		//---------------------------------------------------------------------------------//
				
		
		//----------------------------Online User List------------------------------------//
		//Online Users label
		JLabel lblOnlineUsers = new JLabel("Online Users");
		lblOnlineUsers.setBounds(10, 163, 63, 14);
		contentPane.add(lblOnlineUsers);
		
		//Online Users JList
		userList = new JList();
		userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		userList.setModel(users);
		userList.setBounds(10, 188, 105, 241);
		contentPane.add(userList);
		
		//--------------------------------------------------------------------------------//
		
		//-------------------------Groups List---------------------------------------------//
		//Groups List Label
		lblGroups = new JLabel("Groups");
		lblGroups.setBounds(125, 163, 49, 14);
		contentPane.add(lblGroups);
		
		//Group JList
		groupList = new JList();
		groupList.setModel(groups);
		groupList.setBounds(125, 188, 172, 241);
		contentPane.add(groupList);
		groupList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//---------------------------------Conversation---------------------------------------//
		
		lblConversation = new JLabel("Conversation");
		lblConversation.setBounds(307, 163, 205, 14);
		contentPane.add(lblConversation);
		
		JTextArea conversationText = new JTextArea();
		conversationText.setEditable(false);
		conversationText.setBounds(307, 188, 344, 241);
		contentPane.add(conversationText);
		
		
		btnSendMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				message = messageTextField.getText();
				conversationText.append(message);
				messageTextField.setText("");
			}
		});
		btnSendMessage.setBounds(10, 461, 128, 23);
		contentPane.add(btnSendMessage);
		
		
		messageTextField.setBounds(148, 462, 502, 20);
		contentPane.add(messageTextField);
		messageTextField.setColumns(10);
		
		//------------------------------------------------------------------------------------//
				
		
	}
}
