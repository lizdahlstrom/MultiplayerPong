//Handler for communication from client to server.


package Application;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable{
	//Instance variables
	private Socket socket;
	private BufferedReader br;
	private DataOutputStream os;

	public ClientHandler(Socket socket) {
		this.socket = socket;
	}

	private void sendMsg(){

	}


	@Override
	public void run() {

//				try {
//					os = new DataOutputStream(socket.getOutputStream());
//					br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//					String strIndata = br.readLine();
//					System.out.println(strIndata);
//		} catch (IOException e) {
//			e.printStackTrace();
		

	}

}
