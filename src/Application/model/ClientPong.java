package Application.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.rmi.UnknownHostException;

import Application.controller.TestMainController;
import Application.view.TestStartMenyn;

public class ClientPong  {
	
	InetAddress iadr;
	DatagramSocket socket;
	int port;
	
	
	public ClientPong (String toAddress, int portNr) 
						throws UnknownHostException, SocketException {
	//Create a socket for sending and receiving.
		try {
			iadr = InetAddress.getByName(toAddress);
		} catch (java.net.UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		port = portNr;
		socket = new DatagramSocket();
		//pack();
						}
	
	private void report (String name) {
		String message = String.format("%-10s%", name);
		byte[] data = message.getBytes(); //Convert the text to bytes.
		for (int i=1; i<=3;i++) {  //Make three sending attempts.
			//Create a datagram with the message.
			DatagramPacket packet = new DatagramPacket(data, data.length, iadr, port);
			
			try {
				socket.send(packet);
				socket.receive(packet); //Wait until response arrives.
				//Convert the received message from bytes to String.
				String response = new String(packet.getData(),0,
									packet.getLength());
				if (response.equals("OK"))
						return;
			}
			catch(IOException ie) {} //Timeout or error.			
		}
		//Failure of sending data .
		System.out.println("Issues with the communication");
	}


public static void main(String[]arg)
				throws UnknownHostException, SocketException {
	//Get the internetaddresss and port number from arg.
	new ClientPong (arg[0],Integer.parseInt(arg[1]));
}
}

	
	
	
	



