import java.net.*;
import java.io.*;
import java.util.*;

public class udptime_server
{
	public static void main (String [] args) throws Exception
	{
		DatagramSocket serversocket = new DatagramSocket(7777);
	
		while(true)
		{
			System.out.println("Connected to Server");

			byte [] receiveData = new byte [100];
			byte [] sendData = new byte [100];

			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

			serversocket.receive(receivePacket);
			InetAddress IP = receivePacket.getAddress();
			
			int port = receivePacket.getPort();

			Date d = new Date();
			String time = d + "";
			sendData = time.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,IP,port);
			serversocket.send(sendPacket);
			receivePacket = null;
			
			System.out.println("Connection Terminated");
		}		
			
	}
			
}
