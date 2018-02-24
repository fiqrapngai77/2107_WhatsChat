package whatschat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private JList userList;
	private JLabel lblGroups;
	private JList groupList;
	private JLabel lblConversation;
	private JTextField messageTextField;
	private JTextArea conversationText;
	private JTextField groupTextField;
	
	
	
	public void onClickRegister() {
		
		// Register User
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String newUser = textFieldName.getText();
				
				if (Validation.userIDValidation(newUser) == true){
					Socket.dgpSend("register-" + newUser);
					
					
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
				if (Validation.groupNameValidation(newGroup) == true){
					Socket.dgpSend("createGroup-" + newGroup);
				}else {
					appendConvoText(Variables.getERROR());
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
	
	public void onlineListOnClick() {
	userList.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent evt) {
	        if (evt.getClickCount() == 2) {
	            String onlineUser = (String) userList.getSelectedValue();
	            Variables.put("123",onlineUser);
	            System.out.println(onlineUser);
	        } 
	    }
    });
	
	}
	

	public void setView() {

		// Set Window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// -------------------------User Register-----------------------------------------//
		// Register Button
		btnRegister = new JButton("Register User");
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

		btnSendMessage = new JButton("Send Message");
		btnSendMessage.setBounds(10, 461, 128, 23);
		contentPane.add(btnSendMessage);

		messageTextField = new JTextField();
		messageTextField.setBounds(148, 462, 502, 20);
		contentPane.add(messageTextField);
		messageTextField.setColumns(10);
		
	}


	
}
