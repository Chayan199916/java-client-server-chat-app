package com.onetonteaching.chatapplication.consolebased;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketServer {

public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		try {
			
			String meString = null;
			DataInputStream dataInputStream = null;
			DataOutputStream dataOutputStream = null;
			Scanner scanner = null;
			
			System.out.println("Server is ready...");
			ServerSocket serverSocket = new ServerSocket(9999);
			
			System.out.println("Server is waiting for a connection...");
			Socket socket = serverSocket.accept();
			System.out.println("Connection established...");
			
			while (true) {
				
				dataInputStream = new DataInputStream(socket.getInputStream());
				String requeString = (String)dataInputStream.readUTF();
				System.out.println(requeString);
				
				System.out.println("Message received...");
				
				if (requeString.equals("Abort")) {
					
					dataOutputStream.close();
					
					serverSocket.close();
					
					scanner.close();
					
					break;
					
				}
				
				scanner = new Scanner(System.in);
				meString = scanner.nextLine();
				
				dataOutputStream = new DataOutputStream(socket.getOutputStream());
				dataOutputStream.writeUTF(meString);
				dataOutputStream.flush();
				
				System.out.println("Message sent...");
				
			}
			
			
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

	}


}