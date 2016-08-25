package Base;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.lang.ref.SoftReference;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.FileNameMap;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;
import java.util.Vector;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * ���ػ�
 * 2012-11-28 
 * @author qq:542335496
 *
 */
public class TestAPI {

	enum Sex {
		MAN, WOMEN
	}

	@SuppressWarnings("unused")
	private class Person {
		private Integer id;
		private String name;

		public Person() {
		};

		public Person(Integer id, String name) {

			this.id = id;
			this.name = name;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		/** ���� */
		Collection<Integer> collection;
		{
			collection=new ArrayList<Integer>();
			collection.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9));
			
			/** �жϳ�������У�������*/
			if(true){
				return ;
			}
		}
		/** �б� */
		List<Integer> list;
		/** �����б� */
		ArrayList<Integer> arrayList;
		/** ���� */
		LinkedList<Integer> linkedList;
		/** ����ʵ�ֵ�hashmap */
		LinkedHashMap<Integer, String> linkedHashMap;
		{
			arrayList=new ArrayList<Integer>();
			for(int i=0;i<15;i++){
				arrayList.add(i);
			}
			System.out.println(arrayList);
			linkedList=new LinkedList<Integer>();
			linkedList.addAll(arrayList);
			System.out.println(linkedList);
			linkedHashMap=new LinkedHashMap<Integer, String>();
			for(int i=0;i<15;i++){
				linkedHashMap.put(i, "value"+i);
			}
			System.out.println(linkedHashMap);
			System.out.println(arrayList.contains(14));
			System.out.println(linkedList.indexOf(11));
			System.out.println(linkedList.offer(100));
			System.out.println(linkedList.peekLast());
			System.out.println(linkedList.peek());
			System.out.println(linkedList.remove(2));
			System.out.println(linkedList);
			
			Set<Integer> set=linkedHashMap.keySet();
			Set<Map.Entry<Integer, String>> entrySet=linkedHashMap.entrySet();
			Iterator<Integer> iterator=set.iterator();
			while(iterator.hasNext()){
				Integer key=iterator.next();
				String value=linkedHashMap.get(key);
				System.out.print(" key="+key+" value="+value);
			}
			System.out.println();		
			if(true){
				return ;
			}
		}
		/** ���� */
		Queue<Integer> queue;
		/**˫�˶��� */
		ArrayDeque<Integer> arrayDeque;
		/**���ȼ����� */
		PriorityQueue<Integer> priorityQueue;
		ConcurrentLinkedQueue<Integer> concurrentLinkedQueue;
		{
			priorityQueue = new PriorityQueue<Integer>();
			priorityQueue.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
			System.out.println(priorityQueue);
					
			arrayDeque=new ArrayDeque<Integer>();
			arrayDeque.addAll(priorityQueue);
			System.out.println(arrayDeque.pop());
			System.out.println(arrayDeque.poll());
			//�����
			arrayDeque.push(500);
			arrayDeque.push(200);
			//������
			System.out.println(arrayDeque.remove());
			//�����
			System.out.println(arrayDeque.add(99));
			System.err.println(arrayDeque);
			// ������,����˳�����ˣ�
			//priorityQueue.poll();
			show(priorityQueue);
			Iterator<Integer>  iterator=priorityQueue.iterator();
			while(iterator.hasNext()){			
				Integer data=iterator.next();
				System.out.print("\t"+data);			
			}
			System.out.println();
			concurrentLinkedQueue=new ConcurrentLinkedQueue<Integer>();
			concurrentLinkedQueue.addAll(priorityQueue);
			System.out.println(concurrentLinkedQueue);
		
			if(true){
				return ;
			}
		}

		

		/** ջ */
		Stack<Integer> stack;
		{
			stack = new Stack<Integer>();
			for (int i = 0; i < 10; i++) {
				stack.add(i);
			}
			show(stack);
			stack.addElement(111);
			// ��������ʱ������һ��
			System.out.println(stack.capacity());
			System.out.println(stack.size());
			System.out.println(stack.indexOf(111));
			System.out.println(stack.remove(1));
			System.out
					.println(stack.retainAll(Arrays.asList(3, 4, 5, 6, 7, 8)));
			System.out.println(stack.search(3));
			System.out.println(stack.toString());
			System.out.println(stack.peek());
			stack.pop();
			stack.pop();
			stack.push(100);
			System.out.println(stack.subList(1, 4));

			show(stack);
			stack.removeAllElements();
			System.out.println(stack.isEmpty());

		}
		/** ���� */
		Vector<Integer> vector;
		{

			vector = new Vector<Integer>();
			for (int i = 0; i < 20; i++) {
				vector.add(i);
			}
			show(vector);
			vector.addElement(1999);
			// ��������ʱ������һ��
			System.out.println(vector.capacity());
			System.out.println(vector.contains(1));
			System.out.println(vector.containsAll(Arrays.asList(1, 2, 3, 4, 5,
					6)));
			System.out.println(vector.lastIndexOf(19));
			System.out.println(vector.remove(1));
			System.out.println(vector.removeAll(Arrays.asList(1, 2, 3, 4, 5, 6,
					7, 8, 9)));
			System.out.println(vector.retainAll(Arrays.asList(10, 11, 12, 13,
					14, 15, 60)));
			System.out.println(vector.size());
			System.out.println(vector.elementAt(2));
			System.out.println(vector.firstElement());
			System.out.println(vector.lastElement());
			System.out.println(vector.subList(1, 5));
			vector.ensureCapacity(52);
			System.out.println(vector.size());
			vector.removeAllElements();
			System.out.println(vector.isEmpty());
			show(vector);

		}

		System.out.println("========map=======");
		Map<Integer, String> map;
		Hashtable<Integer, String> hashtable;
		HashMap<Integer, String> hashMap;
		// EnumMap<Sex,Map> enumMap;
		/** ��ʵ�ֵ�map */
		TreeMap<Integer, String> treeMap;
		// ConcurrentHashMap<Integer, String> concurrentHashMap;
		// ConcurrentMap<Integer, String> concurrentMap;
		WeakHashMap<Integer, String> weakHashMap;
		IdentityHashMap<Integer, String> identityHashMap;
		{
			hashMap = new HashMap<Integer, String>();
			hashtable = new Hashtable<Integer, String>();
			treeMap = new TreeMap<Integer, String>();
			weakHashMap = new WeakHashMap<Integer, String>();
			identityHashMap = new IdentityHashMap<Integer, String>();
			for (int i = 0; i < 20; i++) {
				hashMap.put(i, "���ػ�" + i);
			}
			show(hashMap);
			hashtable.putAll(hashMap);
			treeMap.putAll(hashMap);
			weakHashMap.putAll(hashMap);
			identityHashMap.putAll(hashMap);
			show(hashtable);
			show(treeMap);
			show(weakHashMap);
			show(identityHashMap);
			System.out.println(hashMap.containsKey(14));
			System.out.println(hashMap.containsValue("���ػ�5"));
			System.out.println(hashMap.values());
			System.out.println(hashtable.remove(1));
			System.out.println(hashtable.values());
			hashtable.clear();
			System.out.println(hashtable.isEmpty());

		}
		System.out.println("========set=======");
		// ����Set��ʹ��
		Set<Integer> set;
		BitSet bitSet;

		EnumSet enumSet;

		HashSet<Integer> hashSet;
		/** ��ʵ�ֵ�set */
		TreeSet<Integer> treeSet;
		/** ����ʵ�ֵ�hashset */
		LinkedHashSet<Integer> linkedHashSet;

		Iterator<Integer> iterator;
		{

			enumSet = EnumSet.noneOf(Sex.class);
			hashSet = new HashSet<Integer>();
			treeSet = new TreeSet<Integer>();
			linkedHashSet = new LinkedHashSet<Integer>();
			// �Զ����򣿣�
			for (int i = 15; i > 0; i--) {
				hashSet.add(i);
			}
			treeSet.addAll(hashSet);
			linkedHashSet.addAll(hashSet);

			enumSet.add(Sex.MAN);
			enumSet.add(Sex.WOMEN);
			show(hashSet);
			show(treeSet);
			show(linkedHashSet);
			show(enumSet);
			System.out.println(enumSet.size());
			enumSet.clear();
			System.out.println(enumSet.size());
			System.out.println(enumSet.isEmpty());
			System.out.println(hashSet.contains(10));
			System.out.println(linkedHashSet.containsAll(hashSet));
			linkedHashSet.remove(14);
			System.out.println(linkedHashSet.containsAll(hashSet));
			hashSet.removeAll(linkedHashSet);
			show(hashSet);
			Object[] objs = treeSet.toArray();
			show(objs);
			Integer[] strs = treeSet.toArray(new Integer[0]);
			show(strs);
			for (Iterator<Integer> iterator2 = treeSet.iterator(); iterator2
					.hasNext();) {
				Integer data = iterator2.next();
				System.out.print(data + "\t");
			}
			System.out.println();

		}
		// Ҫѧϰ
		java.util.StringTokenizer stringTokenizer;
		{
			String[] temps = "1,2,3,4,5,6".split(",");
			show(temps);
			stringTokenizer = new StringTokenizer("1,2,3,4,5,6,7,8,9", ",");
			String[] datas = new String[stringTokenizer.countTokens()];
			int i = 0;
			while (stringTokenizer.hasMoreTokens()) {

				String str = stringTokenizer.nextToken();
				System.out.print(str + "\t");
				datas[i] = str;
				i++;
			}
			System.out.println();
			show(datas);
		}
		java.util.Calendar calendar;
		java.util.Date date;
		{
			calendar = Calendar.getInstance();
			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH) + 1;
			int day = calendar.get(Calendar.DAY_OF_MONTH);
			int hours = calendar.get(Calendar.HOUR_OF_DAY);
			int minute = calendar.get(Calendar.MINUTE);
			int second = calendar.get(Calendar.SECOND);
			System.out.println(year + "-" + month + "-" + day + " " + hours
					+ ":" + minute + ":" + second);

			date = new Date();
			System.out.println(date.after(new Date(
					System.currentTimeMillis() + 1000)));
			System.out.println(date.compareTo(new Date(System
					.currentTimeMillis() - 1000)));
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			String str = dateFormat.format(date);
			System.out.println(str);

		}

		java.util.Random random;
		{
			random = new Random();
			System.out.println(random.nextBoolean());
			System.out.println(random.nextDouble());
			System.out.println(random.nextFloat());
			System.out.println(random.nextInt());
			System.out.println(random.nextInt(15));
			System.out.println(random.nextLong());
			byte[] datas = new byte[10];
			random.nextBytes(datas);
			System.out.println(datas);
			random.setSeed(10000);
			System.out.println(random.nextInt());
			System.out.println(random.nextInt());

		}
		java.util.Scanner scanner;
		java.util.Timer timer;
		java.util.TimerTask timerTask;
		{

			timer = new Timer();
			timerTask = new TimerTask() {

				@SuppressWarnings("deprecation")
				@Override
				public void run() {

					System.out.println(new Date().toLocaleString());
				}

			};
			timer.schedule(timerTask, 1000, 1000);
			// timerTask.run();

		}
		java.util.TimeZone timeZone;
		{
			System.gc();
			System.out.println(UUID.randomUUID());
			timeZone = TimeZone.getDefault();
			System.out.println(timeZone.getDisplayName());
			/**
			 * String[] strs=timeZone.getAvailableIDs(); for(String str:strs){
			 * System.out.println(str); }
			 */

		}
		java.lang.Character character;
		{
			character = Character.valueOf('f');
			int data = Character.digit(character, 16);
			System.out.println(data);
			int data2 = Character.digit(5, 16);
			System.out.println(data2);
			System.out.println(Character.isDigit('b'));
			System.out.println(Character.reverseBytes('a'));

		}
		java.lang.Process process;
		{
			process = Runtime.getRuntime().exec("cmd /c dir", null,
					new File("."));
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(process.getInputStream(), "GBK"));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
			// ///////
			System.out.println("=======");
			ProcessBuilder builder = new ProcessBuilder("java");
			builder.directory(new File(
					"C:\\Program Files\\Java\\jdk1.6.0_30\\bin"));
			Process process2 = builder.start();
			BufferedReader bufferedReader2 = new BufferedReader(
					new InputStreamReader(process2.getInputStream(), "GBK"));
			while ((line = bufferedReader2.readLine()) != null) {
				System.out.println(line);
			}

		}
		java.lang.Class<Integer> class1;
		java.lang.CharSequence charSequence;
		{
			java.lang.ClassLoader.getSystemResource("file.xml");

			charSequence = "wujianhua";
			System.out.println(charSequence.charAt(6));
			System.out.println(charSequence.length());
			System.out.println(charSequence.subSequence(2, 5));
			System.out.println(charSequence.hashCode());

		}

		java.lang.Number number;
		java.lang.Package package1;
		{
			/**
			 * Package[] datas=Package.getPackages(); for(Package
			 * package2:datas){ System.out.println(package2.getName()); }
			 */
			package1 = Package.getPackage("java.lang");
			System.out.println(package1.getImplementationTitle());
			System.out.println(package1.getImplementationVendor());
			System.out.println(package1.getImplementationVersion());
			System.out.println(package1.getSpecificationTitle());
			System.out.println(package1.getSpecificationVendor());
			System.out.println(package1.getSpecificationVersion());
			System.out.println(package1.getDeclaredAnnotations());
			System.out.println(package1.isSealed());

		}
		java.lang.String string;
		{
			System.out.println("".isEmpty());

		}

		// ѧϰ�Ľӿ�

		java.util.Comparator<Integer> comparator;
		java.util.RandomAccess randomAccess;
		java.util.SortedMap<Integer, String> sortedMap;
		java.util.SortedSet<Integer> sortedSet;

		java.applet.Applet applet;
		java.io.File file;
		java.io.FileFilter fileFilter;

		java.io.PrintWriter printWriter;
		{
			try {
				printWriter = new PrintWriter(new BufferedWriter(
						new FileWriter("writer.txt")));
				printWriter.append("���");
				printWriter.append(",");
				printWriter.append("���ػ�");
				printWriter.println();
				printWriter.print("�Ǻ�");
				printWriter.write("����");
				printWriter.println(new BigInteger("123456789"));

				printWriter.flush();
				printWriter = new PrintWriter(System.out);
				printWriter.println("�ʶ�����");
				printWriter.write("˳��ǣ��");
				printWriter.flush();
				printWriter.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		java.io.RandomAccessFile randomAccessFile;
		{
			try {
				randomAccessFile = new RandomAccessFile("test.txt", "rw");
				randomAccessFile.write("������".getBytes());
				randomAccessFile.writeUTF("��");
				randomAccessFile.write(22);
				// again
				randomAccessFile.write("���ػ�".getBytes());
				randomAccessFile.writeUTF("Ů");
				randomAccessFile.write(21);
				randomAccessFile.close();
				RandomAccessFile randomAccessFile2 = new RandomAccessFile(
						"test.txt", "rw");
				randomAccessFile2.skipBytes(6);
				System.out.println(randomAccessFile2.getFilePointer());
				System.out.println(randomAccessFile2.readUTF());
				randomAccessFile2.skipBytes(1);
				byte[] names = new byte[6];
				randomAccessFile2.read(names);
				System.out.println(new String(names));
				randomAccessFile2.seek(0);
				randomAccessFile2.read(names);
				System.out.println(new String(names));
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (true) {
				return;
			}

		}

		/** ������ */
		java.lang.ref.SoftReference<Integer> softReference;
		{
			Integer data = 0;
			softReference = new SoftReference<Integer>(data);
			data = softReference.get();
			if (data == null) {
				data = softReference.get();
			}
			System.out.println(data);

		}
		java.math.BigDecimal bigDecimal = new BigDecimal("123456789");

		System.out.println("====bigInteger===");
		java.math.BigInteger bigInteger = new BigInteger("123456789");
		{
			System.out.println(bigInteger.abs() + "\t" + bigInteger.bitCount()
					+ "\t" + bigInteger.bitLength());
			System.out.println(bigInteger.doubleValue());
			System.out.println(bigInteger.floatValue());
			System.out.println(bigInteger.longValue());
			System.out.println(bigInteger.intValue());
			System.out.println(bigInteger.divide(new BigInteger("11111111")));
			// System.out.println(bigInteger);
			System.out.println(bigInteger.multiply(new BigInteger("2")));
			System.out
					.println(bigInteger.subtract(new BigInteger("111111111")));
			System.out.println(bigInteger.add(new BigInteger("111111111")));

		}
		java.net.HttpURLConnection httpURLConnection;
		java.net.Socket socket;
		java.net.URI uri;
		java.net.URLConnection urlConnection;

		java.net.FileNameMap fileNameMap = new FileNameMap() {

			@Override
			public String getContentTypeFor(String fileName) {

				return "txt";
			}

		};

		System.out.println(fileNameMap.getContentTypeFor("d:\test.txt"));

		java.util.regex.Matcher matcher;
		java.util.regex.Pattern pattern;

		System.out.println("====zipFile===");
		java.util.zip.ZipFile zipFile;
		{
			File file2 = new File(".");
			System.out.println(file2.getAbsolutePath());
			try {
				zipFile("file.doc", "file.zip", "file.doc");
				unZip("file.zip", "d:/test/");
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		javax.crypto.Cipher cipher;
		System.out.println("====collections===");
		Collections collections;
		{
			List<Integer> list2 = new ArrayList<Integer>();
			Collections.addAll(list2, 12, 45, 62, 98, 32, 41, 15, 24, 3, 4);
			Collections.sort(list2);// ����
			show(list2);
			int pos = 0;
			if ((pos = Collections.binarySearch(list2, 15)) != -1) {

				System.out.println("���ֲ��ҵ���λ�ã�" + pos);
			}
			;
			// ��ʼ������list3.size()>0,Ȼ��ſ��Խ������
			List<Integer> list3 = new ArrayList<Integer>(Arrays
					.asList(new Integer[list2.size()]));
			System.out.println(list3.size());
			Collections.copy(list3, list2);// ����
			show(list3);
			System.out.println("���ֵ��" + Collections.max(list3));
			System.out.println("��Сֵ:" + Collections.min(list3));
			// ö�ټ���
			Enumeration<Integer> enumerations = Collections.enumeration(list2);
			show(enumerations);
			List<Integer> list4 = new ArrayList<Integer>();
			// ����һ����ȫ�ļ���
			list4 = Collections.synchronizedList(list3);
			show(list4);
			// ��ת����
			Collections.reverse(list3);
			show(list3);

		}

	}

	@SuppressWarnings("unchecked")
	private static void show(Queue queue) {
		for (Object obj : queue) {
			System.out.print("\t" + obj);
		}
		System.out.println();

	}

	private static void show(Map<Integer, String> maps) {
		Set<Integer> keySet = maps.keySet();
		// Set<Map.Entry<Integer, String>> entrySet=maps.entrySet();
		for (Iterator<Integer> iterator = keySet.iterator(); iterator.hasNext();) {
			Integer key = iterator.next();
			String value = maps.get(key);
			System.out.print("key=" + key + "\tvalue=" + value + "\t");
		}
		System.out.println();
	}

	private static void show(Object[] objs) {
		for (Object data : objs) {
			System.out.print(data + "\t");
		}
		System.out.println();
	}

	@SuppressWarnings("unchecked")
	private static void show(Set hashSet) {

		for (Object data : hashSet) {
			System.out.print(data + "\t");
		}
		System.out.println();

	}

	public static void show(List<Integer> datas) {
		for (Integer data : datas) {
			System.out.print(data + "\t");
		}
		System.out.println();

	}

	public static void show(Vector<Integer> datas) {

		for (Integer data : datas) {

			System.out.print(data + "\t");
		}
		System.out.println();

	}

	public static void show(Enumeration<Integer> datas) {

		for (Enumeration<Integer> e = datas; e.hasMoreElements();) {
			System.out.print(e.nextElement() + "\t");
		}
		System.out.println();

	}

	public static void show(String[] datas) {
		for (String data : datas) {
			System.out.print(data + "\t");
		}
		System.out.println();
	}

	/** ѹ�� */
	public static void zipFile(String srcFilePath, String destZipFilePath,
			String fileName) throws Exception {
		File file = new File(destZipFilePath);
		int leng = 0;
		byte[] b = new byte[1024];
		// ѹ��
		ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(file));

		// ��ѹ�����ļ�
		FileInputStream fis = new FileInputStream(srcFilePath);
		// ��ѹ�����е�·��
		ZipEntry z1 = new ZipEntry(fileName);
		zos.putNextEntry(z1);

		while ((leng = fis.read(b)) != -1) {
			zos.write(b, 0, leng);
		}
		zos.close();
		fis.close();
	}

	@SuppressWarnings("unchecked")
	public static void unZip(String fileName, String unZipDir) throws Exception {
		// ���ж�Ŀ���ļ����Ƿ���ڣ�������������½��������Ŀ¼������Ҳ�½�
		File f = new File(unZipDir);
		if (!f.exists()) {
			f.mkdirs();
		}
		BufferedOutputStream dest = null;
		BufferedInputStream is = null;
		ZipEntry entry;
		ZipFile zipfile = new ZipFile(fileName);
		Enumeration e = zipfile.entries();
		while (e.hasMoreElements()) {
			entry = (ZipEntry) e.nextElement();
			// System.out.println("Extracting: " + entry);
			is = new BufferedInputStream(zipfile.getInputStream(entry));
			int count;
			byte data[] = new byte[1024];
			FileOutputStream fos = new FileOutputStream(unZipDir + "/"
					+ entry.getName());
			// System.out.println("entry.getName(): " + entry.getName());
			dest = new BufferedOutputStream(fos, 1024);
			while ((count = is.read(data, 0, 1024)) != -1) {
				dest.write(data, 0, count);
			}
			dest.flush();
			dest.close();
			is.close();
		}
	}

	public static boolean makeDir(String unZipDir) {
		boolean b = false;
		try {
			File f = new File(unZipDir);
			if (!f.exists()) {
				b = f.mkdirs();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return b;
		}
		return b;
	}
}
