package Data��Caender;

import java.text.DateFormat;
import java.util.Date;

//��ʱ����д���
public class DataTest {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println("����1970��1��1��00��00:00ʱ���Ѿ����� " + date.getTime()
				+ " ����");
		System.out.println("��ǰʱ�� "+date.toGMTString());
		
		DateFormat shortdate=DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
		System.out.println(shortdate.format(date));
	}
}
