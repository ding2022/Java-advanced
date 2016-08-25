package »ù´¡Ï°Ìâ;

import java.util.Date;
import java.util.Formatter;

public class FormatterTest {
	private static Formatter fmt;

	public static void main(String[] args) {
		fmt = new Formatter(System.out);

		Date date = new Date();
		Object[] obj = new Object[1];
		obj[0] = date;

		fmt.format("%tc\n", obj);
		fmt.format("%tF\n", obj);
		fmt.format("%tD\n", obj);
		fmt.format("%tA\n", obj);
		fmt.format("%tT\n", obj);
		fmt.format("%tR\n", obj);
		fmt.format("%tB\n", obj);
		fmt.format("%te\n", obj);
	}

}
