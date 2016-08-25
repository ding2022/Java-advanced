package cn.haofeng.Dao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import cn.haofeng.domin.User;

/**
 * 数据类
 * 
 * @author hao.feng
 *
 */
public class UserDao {
	// private String
	// path="E:/MySoftWareWorkSpace/eclipse-workspace/MVC_Test02/WebContent/users.xml";
	private String path = "E:/users.xml";

	public User findByUserName(String name) {
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(path);

			Element ele = (Element) doc.selectSingleNode("//user[@username='"
					+ name + "']");

			if (ele == null) {
				return null;
			}

			User user = new User();
			String attrname = ele.attributeValue("username");
			String attrpass = ele.attributeValue("password");
			user.setUname(attrname);
			user.setUpass(attrpass);

			return user;
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void addUser(User user) {

		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(path);
			Element root = doc.getRootElement();

			Element userEle = root.addElement("user");
			userEle.addAttribute("username", user.getUname());
			userEle.addAttribute("password", user.getUpass());
			// 缩进使用 \t
			OutputFormat format = new OutputFormat("\t", true);
			format.setTrimText(true);

			// XMLWriter writer = new XMLWriter(new FileWriter(path),format);
			XMLWriter writer = new XMLWriter(new OutputStreamWriter(
					new FileOutputStream(path), "UTF-8"), format);
			writer.write(doc);// 保存doc对象
			writer.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch (DocumentException e) {
			throw new RuntimeException();
		} catch (Exception e) {
			throw new RuntimeException();
		}

	}
/*	public static void main(String[] args) {
		UserDao userDao=new UserDao();
		User user=new User("zhang","lisi","");
		userDao.addUser(user);
		System.out.println(userDao.findByUserName("zhang").getUpass());
	}*/
}
