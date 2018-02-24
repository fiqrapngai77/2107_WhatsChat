import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditDialog extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditDialog frame = new EditDialog(1,"null");
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
	public EditDialog(int index, String groupName) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setTitle("WhatsChatClient - Edit Group");
		
		JLabel lblGroupNumber = new JLabel("Group Number: ");
		lblGroupNumber.setBounds(10, 11, 79, 14);
		contentPane.add(lblGroupNumber);
		
		JLabel lblNumber = new JLabel("Number");
		lblNumber.setBounds(109, 11, 49, 14);
		lblNumber.setText(String.valueOf(index));
		contentPane.add(lblNumber);
		
		JLabel lblGroupName = new JLabel("Group Name");
		lblGroupName.setBounds(10, 36, 68, 14);
		contentPane.add(lblGroupName);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(10, 61, 414, 20);
		textFieldName.setText(groupName);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		JButton btnChange = new JButton("Change");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				WhatsChatClient.getGroupModel().setElementAt(textFieldName.getText(), index);
				WhatsChatClient.getFrame().setEnabled(true);
				dispose();
			}
		});
		btnChange.setBounds(10, 93, 89, 23);
		contentPane.add(btnChange);
	}

}
