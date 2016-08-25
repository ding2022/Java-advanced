1.搭建开发环境
	1.1 导入项目所需的开发包
		dom4j-1.6.1.jar
		jaxen-1.1-beta-6.jar
		commons-beanutils-1.8.0.jar
		commons-logging.jar
		jstl.jar
		standard.jar
		
	1.2 创建程序的包名
		cn.itcast.domain
		cn.itcast.dao
		cn.itcast.dao.impl
		cn.itcast.service
		cn.itcast.service.impl
		cn.itcast.web.controller  
		cn.itcast.web.UI  (user interface)(放为用户提供用户界面的servlet)
		cn.itcast.utils
		junit.test
		
		在web-inf\jsp目录，保存jsp页面
		
	1.3 在类目录下面，创建用于保存用户数据的xml文件(users.xml)
	
	
2、开发实体user
	private String id;
	private String username;
	private String password;
	private String email;
	private Date birthday;
	
3、开发dao
	3.1  开发UserDaoXmlImpl
			public void add(User user)
			public User find(String username)
			public User find(String username,String password)
			
	3.2  抽取接口
	
	3.3  开发工具类： XmlUtils 
	3.4  开发测试类


4、开发service(service 对web层提供所有的业务服务)
 	4.1  开发BusinessService
 			public void registerUser(User user) throws UserExistException
 			public User loginUser(String username,String password);
 			
 
 5、开发web层
 	5.1 开发注册
 		5.1.1  写一个RegisterUIServlet为用户提供注册界面,它收到请求，跳到register.jsp
 		5.1.2  写register.jsp
 		5.1.3  register.jsp提交请求，交给RegisterServlet处理
 		5.1.4  写RegisterServlet
 				1.设计用于校验表单数据RegisterFormbean 
 				2、写WebUtils工具类，封装请求数据到formbean中
 				3、如果校验失败跳回到register.jsp，并回显错误信息
 				4、如果校验通过，调用service向数据库中注册用户
 				
 	5.2 开发登陆
 		5.2.1  	写一个LoginUIServlet为用户提供注册界面,它收到请求，跳到login.jsp	
 		5.2.2  	login.jsp提交给LoginServlet处理登陆请求
 				
 				
 				
改造 day14_user工程
1、导入驱动
2、创建数据库和表
	create database day14_user;
	use day14_user;
	create table users(
		id varchar(40) primary key,
		username varchar(40) unique not null,
		password varchar(40) not null,
		email varchar(100),
		birthday date
	);	
	
	
3、写一个操作数据库的dao	



preparedStatement和statement的区别
1、preparedStatement是statement的孩子
2、preparedStatement可以防止sql注入的问题
3、preparedStatement它可以对它所代表的sql语句进行预编译，以减轻服务器压力
		
		