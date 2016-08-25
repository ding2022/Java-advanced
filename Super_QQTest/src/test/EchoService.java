package test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
 
public class EchoService {
	SocketServer sos = new SocketServer();
	int port = sos.port_public;
	ServerSocket serverSocket;

	public EchoService() throws IOException {
		serverSocket = new ServerSocket(sos.getPort());
		System.out.println("Service running");
	}

	public void Service() {
		// sos.readfromSocket();
		int i=0;
		while (true) {
			Socket socket = null;
			try {
				socket = serverSocket.accept();
				Thread workThread = new Thread(new Handler(socket));// create
				i++;
				System.out.println(i);
				workThread.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void OnlineMembers() {
	}
	public static void main(String[] args) throws IOException {
		new EchoService().Service();
	}
}

class Handler implements Runnable {
	private Socket socket;

	public Handler(Socket socket) {
		this.socket = socket;
	}

	SocketServer sos = new SocketServer();

	@Override
	public void run() {
		sos.readfromSocket(socket);
	}
}