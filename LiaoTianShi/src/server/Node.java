/*5、Node类
功能：用户链表的节点类，定义了链表中的用户。该类与前面所讲的链表节点Node类的功能相当。
代码：*/
package server;

import java.net.*;
import java.io.*;

/**
 * 用户链表的结点类
 */
public class Node {
	String username = null;
	Socket socket = null;
	ObjectOutputStream output = null;
	ObjectInputStream input = null;

	Node next = null;
}