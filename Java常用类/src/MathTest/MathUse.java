package MathTest;

import java.util.Random;

public class MathUse {
	public static void main(String[] args) {
		// random 类 不属于math的,随机数
		Random random = new Random();
		int a = random.nextInt(100);
		System.out.println(a);
		// 属于math的
		Math.random();
		
		//求对数值
		Math.cbrt(a);//求立方根
		Math.log10(a);//求以10为底，a的对数值
		
		//使用取整函数
		Math.abs(a);//绝对值
		Math.ceil(a);//大于等于a的最小的浮点数形式的整数
		Math.floor(a);//小于等于a的最大的浮点数形式的整数
		Math.rint(a);//四舍五入 浮点数形式的整数
		Math.round(a);//四舍五入 长整数
		
		
		
	}
}
