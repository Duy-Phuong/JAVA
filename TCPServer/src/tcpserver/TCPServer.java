/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpserver;

import java.io.*;
import java.net.*;

public class TCPServer 
{
	public static void main(String arg[])
	{
		try
		{
			ServerSocket s = new ServerSocket(3200);
			
			do
			{
				System.out.println("Waiting for a Client");
			
				Socket ss=s.accept(); //synchronous
				
			
				
				System.out.println("Talking to client");
				System.out.println(ss.getPort());
				
				InputStream is=ss.getInputStream();
				BufferedReader br=new BufferedReader(new InputStreamReader(is));
				
				OutputStream os=ss.getOutputStream();
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
				
				
				String receivedMessage;
				
				do
				{
					receivedMessage=br.readLine();
					System.out.println("Received : " + receivedMessage);
					if (receivedMessage.equalsIgnoreCase("quit"))
					{
						System.out.println("Client has left !");
						break;
					}
					else
					{
						DataInputStream din=new DataInputStream(System.in);
						String k=din.readLine();
						bw.write(k);
						bw.newLine();
						bw.flush();
					}
				}
				while (true);
				bw.close();
				br.close();
			}
			while (true);
			
		}
		catch(IOException e)
		{
			System.out.println("There're some error");
		}
	}
}

