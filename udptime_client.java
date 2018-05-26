import java.io.*;
import java.net.*;

public class udptime_client
{
	public static void main(String args[]) throws Exception
	{
		
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress IP = InetAddress.getByName("192.168.197.129");
		System.out.println("Server IP: " + "\n" + IP.getHostAddress());
	
		byte [] receiveData = new byte [100];
		byte [] sendData = new byte [100];

		DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,IP,7777);

		DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);

		clientSocket.send(sendPacket);
		clientSocket.receive(receivePacket);

		String time = new String(receivePacket.getData());	
		System.out.println("Server Time: ");
		System.out.println(time);
		clientSocket.close();

	}

}
