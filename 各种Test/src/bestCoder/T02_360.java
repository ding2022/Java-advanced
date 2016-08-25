package bestCoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T02_360 {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Scanner in = new Scanner(System.in);
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(reader);
		String buffer = null;

		int T = in.nextInt();
		int m = T;
		char[] s = new char[T];
		while (T != 0 && (buffer = br.readLine()) != null) {
			T--;
			s[T] = solve(buffer);
		}
		for (int i = m - 1; i >= 0; i--) {
			System.out.println(s[i]);
		}
		in.close();
	}

	public static char solve(String s) {
		char[] sChar = s.toCharArray();
		int len = sChar.length;
		/*
		 * for(int i=0;i<len;i++){
		 * if(s.indexOf(sChar[i]+"")==s.lastIndexOf(sChar[i]+"")){ return
		 * sChar[i]; } }
		 */
		List<Character> list = new ArrayList<Character>();
		for (int i = 0; i < len; i++)
			list.add(sChar[i]);
		while (!list.isEmpty()) {
			int s1 = list.size();
			char t = list.get(0);
			list.remove(t);
			int s2 = list.size();
			if (s2 - s1 == 1) {
				return t;
			}
		}
		return (Character) null;
	}
}
