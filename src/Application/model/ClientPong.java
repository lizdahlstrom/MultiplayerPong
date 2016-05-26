package Application.model;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.rmi.UnknownHostException;

import Application.controller.TestMainController;
import Application.view.TestStartMenyn;

public class ClientPong extends Thread {
	
	private InetAddress ipAddress;
	private DatagramSocket socket;
	private TestStartMenyn testStartMenyn;
	private TestMainController testMainController;
	
	
	public ClientPong(TestStartMenyn testStartMenyn, String ipAddress) throws UnknownHostException {
		this.testStartMenyn = testStartMenyn;
		try {
			this.socket = new DatagramSocket();
			this.ipAddress = InetAddress.getByName(ipAddress);
			}catch (SocketException e) {
				e.printStackTrace();
			}catch (java.net.UnknownHostException e) {
				e.printStackTrace();
			}
	}
	
	public void run() {
	
	}
}


