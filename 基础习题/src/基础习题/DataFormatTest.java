package ����ϰ��;

import java.text.DateFormat;
import java.util.Date;

public class DataFormatTest {

	public static void main(String[] args) {
		date_Format();
	}

	public static void date_Format() {
		System.out.println("ʹ��DateFormat���ȡϵͳ���ڵ�ʾ�����£�");

		Date date = new Date();

		DateFormat shortdDateFormat = DateFormat.getDateTimeInstance(
				DateFormat.SHORT, DateFormat.SHORT);
		DateFormat mediumDateFormat = DateFormat.getDateTimeInstance(
				DateFormat.MEDIUM, DateFormat.MEDIUM);
		DateFormat longDateFormat = DateFormat.getDateTimeInstance(
				DateFormat.LONG, DateFormat.LONG);
		DateFormat fullDateFormat = DateFormat.getDateTimeInstance(
				DateFormat.FULL, DateFormat.FULL);

		System.out.println(shortdDateFormat.format(date));
		System.out.println(mediumDateFormat.format(date));
		System.out.println(longDateFormat.format(date));
		System.out.println(fullDateFormat.format(date));

	}
}
