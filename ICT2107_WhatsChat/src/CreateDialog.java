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

public class CreateDialog extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCreateName;
	
	private String groupName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateDialog frame = new CreateDialog();
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
	public CreateDialog() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setTitle("WhatsChatClient - Create Group");
		
		JLabel lblNewGroupName = new JLabel("New Group Name: ");
		lblNewGroupName.setBounds(10, 11, 121, 14);
		contentPane.add(lblNewGroupName);
		
		textFieldCreateName = new JTextField();
		textFieldCreateName.setBounds(10, 52, 400, 20);
		contentPane.add(textFieldCreateName);
		textFieldCreateName.setColumns(10);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				groupName = textFieldCreateName.getText();
				WhatsChatClient.getGroupModel().addElement(groupName);
				WhatsChatClient.getFrame().setEnabled(true);
				dispose();
			}
		});
		btnCreate.setBounds(10, 83, 89, 23);
		contentPane.add(btnCreate);
	}
}
