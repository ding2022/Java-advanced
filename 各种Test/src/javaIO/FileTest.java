package javaIO;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class FileTest {
	public static File[] local(File dir, final String regex) {// ��ù���ƥ�䵽���ļ��б�
		return dir.listFiles(new FilenameFilter() {

			private Pattern pattern = Pattern.compile(regex);// ����ƥ��

			@Override
			public boolean accept(File dir, String name) {
				return pattern.matcher(new File(name).getName()).matches();
			}
		});
	}

	public static File[] local(String path, final String regex) {// ��д�����ļ�
		return local(new File(path), regex);
	}

	public static class TreeInfo implements Iterable<File> {
		public List<File> files = new ArrayList<File>();
		public List<File> dirs = new ArrayList<File>();

		public Iterator<File> iterator() {
			return files.iterator();
		}

		void addAll(TreeInfo other) {
			files.addAll(other.files);
			dirs.addAll(other.dirs);
		}

		public String pprint(List<File> list){
			String string=null;
			for(File file: list){
				string+=file.getPath()+"\n";
			}
			return string;
		}
		public String toString() {
			return "dirs : \n" + pprint(dirs) + "\nfiles : \n" + pprint(files);
		}
	}

	public static TreeInfo walk(String start, String regex) {
		return recurseDirs(new File(start), regex);
	}

	public static TreeInfo walk(File start, String regex) {
		return recurseDirs(start, regex);
	}

	public static TreeInfo walk(File start) {
		return recurseDirs(start, ".*");
	}

	public static TreeInfo walk(String start) {
		return recurseDirs(new File(start), ".*");
	}

	static TreeInfo recurseDirs(File startDir, String regex) {
		TreeInfo result = new TreeInfo();
		for (File item : startDir.listFiles()) {
			if (item.isDirectory()) {
				result.dirs.add(item);
				result.addAll(recurseDirs(item, regex));
			} else if (item.getName().matches(regex)) {
				result.files.add(item);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println(walk("."));
		}
	}
}
