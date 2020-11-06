package com.onetonteaching.chatapplication.guibased;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import java.awt.Color;

public class SocketClientFront extends JFrame{

		
	JTextField textField;
	JLabel lblNewLabel_1;
	JButton btnNewButton;
	String meString = "";
	Socket socket;
	DataOutputStream dataOutputStream = null;
	DataInputStream dataInputStream = null;
	String ip = "localhost";
	int port = 9999; // 0-1023 not available ; total 65535
	int msgCount = 0;
	String msgs[] = new String[11];
	JLabel labels[] = new JLabel[11];

	public static void main(String args[]) throws IOException {
		
		SocketClientFront socketClientFront = new SocketClientFront();
		
		while (true) {
			
			try {
				
				socketClientFront.dataInputStream = new DataInputStream(socketClientFront.socket.getInputStream());
				
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(socketClientFront,"Waiting for server...");
				return;
				
			}
			
			try {
				
				String reString = (String)socketClientFront.dataInputStream.readUTF();
				socketClientFront.manageMessages(reString + "/server");		
				
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(socketClientFront,"Server left the conversation :(");
				return;
				
			}
			
			
		}
		
	}
	
	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;

	public SocketClientFront() {
		
		setTitle("Client");
		
		try {
			
			socket = new Socket(ip, port);
			
		}
		
		catch (ConnectException e) {
			
			// TODO: handle exception
			JOptionPane.showMessageDialog(rootPane, "Server has not yet connected...");
			return;
			
		}
		
		catch (UnknownHostException e) {
			
			// TODO Auto-generated catch block
//			e.printStackTrace();
			JOptionPane.showMessageDialog(rootPane, "The one, you are trying to reach has left...");
			return;
			
		} 
		
		catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} 
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Gabriola", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 380, 464, 34);
//		lblNewLabel.setText("DemoText");
		labels[0] = lblNewLabel_1;
		
		textField = new JTextField();
		textField.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		textField.setBounds(0, 414, 401, 34);
		textField.setColumns(10);
		
		btnNewButton = new JButton("SEND");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO Auto-generated method stub
				meString = textField.getText();
				if (meString.length() > 0) {
					
					try {
		
							dataOutputStream = new DataOutputStream(socket.getOutputStream());
							dataOutputStream.writeUTF(meString);
							dataOutputStream.flush();
							
							manageMessages(meString + "/client");
							textField.setText("");
										
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
					
				}
				else {
					
					JOptionPane.showMessageDialog(rootPane, "Blank message can't be sent...");
					
				}
				
			}
		});
		btnNewButton.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 14));
		btnNewButton.setBounds(399, 414, 85, 34);
		
		getContentPane().add(lblNewLabel_1);
		getContentPane().add(textField);
		getContentPane().add(btnNewButton);
					
		getContentPane().setLayout(null);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Gabriola", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 342, 464, 34);
		getContentPane().add(lblNewLabel_2);
		labels[1] = lblNewLabel_2;
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Gabriola", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(10, 304, 464, 34);
		getContentPane().add(lblNewLabel_3);
		labels[2] = lblNewLabel_3;
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setFont(new Font("Gabriola", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(10, 266, 464, 34);
		getContentPane().add(lblNewLabel_4);
		labels[3] = lblNewLabel_4;
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setFont(new Font("Gabriola", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(10, 228, 464, 34);
		getContentPane().add(lblNewLabel_5);
		labels[4] = lblNewLabel_5;
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setFont(new Font("Gabriola", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(10, 190, 464, 34);
		getContentPane().add(lblNewLabel_6);
		labels[5] = lblNewLabel_6;
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setFont(new Font("Gabriola", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(10, 152, 464, 34);
		getContentPane().add(lblNewLabel_7);
		labels[6] = lblNewLabel_7;
		
		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setFont(new Font("Gabriola", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(10, 114, 464, 34);
		getContentPane().add(lblNewLabel_8);
		labels[7] = lblNewLabel_8;
		
		lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setFont(new Font("Gabriola", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(10, 76, 464, 34);
		getContentPane().add(lblNewLabel_9);
		labels[8] = lblNewLabel_9;
		
		lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setFont(new Font("Gabriola", Font.PLAIN, 20));
		lblNewLabel_10.setBounds(10, 38, 464, 34);
		getContentPane().add(lblNewLabel_10);
		labels[9] = lblNewLabel_10;
		
		lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setFont(new Font("Gabriola", Font.PLAIN, 20));
		lblNewLabel_11.setBounds(10, 0, 464, 34);
		getContentPane().add(lblNewLabel_11);
		labels[10] = lblNewLabel_11;
		
		setSize(500, 487);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
public void manageMessages(String msg) {
		
		if (msgCount > 10) {
			
			for(int i = 10; i > 0; i--) {
				
				msgs[i] = msgs[i - 1];
				
			}
			msgs[0] = msg;
			
		}else {
			
			for(int i = msgCount + 1; i <= 10; i++) {
				
				msgs[i] = "";
				
			}
			
			for(int i = msgCount; i > 0; i--) {
				
				msgs[i] = msgs[i - 1];
				
			}
			
			msgs[0] = msg;
			msgCount++;
			
		}
		showMessages(msgs);
		
	}

	public void showMessages(String msgs[]) {
		
		for (int i = 0; i < msgs.length; i++) {
			
			if (msgs[i].length() > 0) {
				
				if (msgs[i].split("/")[1].equals("client")) {
					
					labels[i].setText(msgs[i].split("/")[0]);
					labels[i].setHorizontalAlignment(SwingConstants.RIGHT);
					
				}else if (msgs[i].split("/")[1].equals("server")) {
					
					labels[i].setText(msgs[i].split("/")[0]);
					labels[i].setHorizontalAlignment(SwingConstants.LEFT);
					
				}
				
			}
			
		}
		
	}

}
