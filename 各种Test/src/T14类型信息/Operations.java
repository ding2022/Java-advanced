package T14类型信息;

import java.util.List;

import javax.lang.model.type.NullType;

public interface Operations {
	String description();

	void command();
}

interface Robot {
	String name();

	String model();

	List<Operations> operations();

	class Test {
		public static void Test(Robot r) {
			if (r instanceof NullType) {
				System.out.println("null robot");
			}
			System.out.println(r.name());
			System.out.println(r.model());
			for (Operations operation : r.operations()) {
				System.out.println(operation.description());
				operation.command();
			}
		}
	}

}