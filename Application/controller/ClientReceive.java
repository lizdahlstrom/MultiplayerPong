package Application.controller;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ClientReceive implements Runnable {
	
	// Instance variables
		DatagramPacket packet;
		DatagramSocket socket;
		String strData;

		// Constructor
		public ClientReceive(DatagramSocket socket, DatagramPacket packet) {
			this.socket = socket;
			this.packet = packet;
		}

	
		public ClientReceive() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public void run() {

			while (true) {
				try {
					socket.receive(packet);
					socket.setSoTimeout(10000);
					strData = new String(packet.getData(),0,packet.getLength());
					strData = strData.trim();
					System.out.println("Connection established: " + strData);

				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		}
		
		public String setStrData() {
			if(strData != null){
			return strData;}
			return null;
		}
	}



