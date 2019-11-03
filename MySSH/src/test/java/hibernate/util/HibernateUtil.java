package hibernate.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	//静态日志对象实例，用于输出日志信息
	private static Log log = LogFactory.getLog(HibernateUtil.class);
	//静态Configuration和SessionFactory对象的实例（全局唯一）
	private static Configuration configuration;
	private static SessionFactory sessionFactory;
	
	static {
		//从缺省配置文件创建SessionFactory
		try {
			configuration = new Configuration();
			configuration.configure();//读取properties或cfg.xml文件
			sessionFactory = configuration.buildSessionFactory();
		}catch (Throwable e) {
			log.error("构建SessionFactory实例失败",e);
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		}
	}
	//返回全局Configuration对象的实例
	public static Configuration getConfiguration() {
		return configuration;
	}
	
	//返回SessionFactory对象实例
	public static SessionFactory getSessionFactory() {
		SessionFactory sf= sessionFactory;
		if(sf==null) {
			throw new IllegalStateException("SessionFactory不可访问");
		}
		return sf;
	}
	
	//关闭当前SessionFactorty释放对象
	public static void shutdown() {
		log.debug("Shutting down Hibernate");
		//关闭的同时就同时关闭了缓存和连接池
		getSessionFactory().close();
		
		configuration=null;
		sessionFactory=null;
	}
	
	//提交当前事务
	public static void commitAndBeginTransaction() {
		sessionFactory.getCurrentSession().getTransaction().commit();
		sessionFactory.getCurrentSession().beginTransaction();
	}
}
