package Data与Caender;

import java.text.DateFormat;
import java.util.Date;

//对时间进行处理
public class DataTest {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println("距离1970年1月1日00：00:00时间已经过了 " + date.getTime()
				+ " 毫秒");
		System.out.println("当前时间 "+date.toGMTString());
		
		DateFormat shortdate=DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
		System.out.println(shortdate.format(date));
	}
}
