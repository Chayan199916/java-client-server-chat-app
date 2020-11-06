package com.onetonteaching.chatapplication.consolebased;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketClient {

public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		String ip = "localhost";
		int port = 9999; // 0-1023 not available ; total 65535
		
		try {
			
			Socket socket = new Socket(ip, port);
			String meString = null;
			Scanner scanner = new Scanner(System.in);
			DataOutputStream dataOutputStream = null;
			DataInputStream dataInputStream = null;
			
			while (true) {
				
				meString = scanner.nextLine();
				
				if (meString.equals("Abort")) {
					
					dataOutputStream = new DataOutputStream(socket.getOutputStream());
					dataOutputStream.writeUTF(meString);
					dataOutputStream.flush();	
					dataOutputStream.close();
					
					socket.close();
					scanner.close();
					
					break;
					
				}
				
				dataOutputStream = new DataOutputStream(socket.getOutputStream());
				dataOutputStream.writeUTF(meString);
				dataOutputStream.flush();
				
				System.out.println("Message sent...");
				
				dataInputStream = new DataInputStream(socket.getInputStream());
				String reString = (String)dataInputStream.readUTF();
				
				System.out.println(reString);
				
				System.out.println("Message received...");
				
			}
			
			
		} catch (UnknownHostException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		

	}


}