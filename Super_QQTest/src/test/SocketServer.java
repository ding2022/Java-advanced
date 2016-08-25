package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SocketServer {

	int port_public = 8004;
	String host = "localhost";
	ServerSocket serverSocket;
	
	public Map<String, String> userMap = new HashMap<String, String>();
	public ArrayList<String> username=new ArrayList<String>();
	
	public int getPort() {
		return port_public;
	}

	public PrintWriter getWriter(Socket socket) throws IOException {
		OutputStream socketOut = socket.getOutputStream();
		return new PrintWriter(socketOut, true);
	}

	public BufferedReader getReader(Socket socket) throws IOException {
		InputStream socketIn = socket.getInputStream();
		return new BufferedReader(new InputStreamReader(socketIn));
	}

	public void readfromSocket(Socket socket) {

		while (true) {
			try {
				System.out.println("Accetped" + socket.getInetAddress() + ":"
						+ socket.getPort());
				String str = socket.getInetAddress().toString()
						+ socket.getPort();
				username.add(UserName.getUsername());
				userMap.put(str, UserName.username);

				BufferedReader br = getReader(socket);

				// PrintWriter pw = getWriter(socket);

				String msg = null;
				if ((msg = br.readLine()) != null) {// read msg from client

					System.out.println(msg);

					if (msg.equals("bye")) {
						break;
					}
				}
			} catch (IOException e) {

				e.printStackTrace();
			} /*finally {
				if (socket != null)
					try {
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}*/
		}
	}
}
