package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test.GUI_Server.Eserver.ThreadForClient;


public class UserName {

	public static String username;
	public static int port = 8007;
	public static String host = "localhost";

	public List<ThreadForClient> ListthreadForClient = new ArrayList<ThreadForClient>();// �����ͻ��˵��߳��б�
	public Map<ThreadForClient, String> MapuserAndThread=new HashMap<ThreadForClient, String>();//���߳���ͻ���������

	
	public List<ThreadForClient> getThreadForClient() {
		return ListthreadForClient;
	}

	public void setThreadForClient(List<ThreadForClient> threadForClient) {
		this.ListthreadForClient = threadForClient;
	}

	public Map<ThreadForClient, String> getUserAndThread() {
		return MapuserAndThread;
	}

	public void setUserAndThread(Map<ThreadForClient, String> userAndThread) {
		this.MapuserAndThread = userAndThread;
	}
	
	public static int getPort() {
		return port;
	}

	public static void setPort(int port) {
		UserName.port = port;
	}

	public static String getHost() {
		return host;
	}

	public static void setHost(String host) {
		UserName.host = host;
	}

	public static String getUsername() {
		return username;
	}
	
	public static void setUsername(String username1) {
		username = username1;
	}
}
