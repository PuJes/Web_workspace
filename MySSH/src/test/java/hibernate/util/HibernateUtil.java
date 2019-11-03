package hibernate.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	//��̬��־����ʵ�������������־��Ϣ
	private static Log log = LogFactory.getLog(HibernateUtil.class);
	//��̬Configuration��SessionFactory�����ʵ����ȫ��Ψһ��
	private static Configuration configuration;
	private static SessionFactory sessionFactory;
	
	static {
		//��ȱʡ�����ļ�����SessionFactory
		try {
			configuration = new Configuration();
			configuration.configure();//��ȡproperties��cfg.xml�ļ�
			sessionFactory = configuration.buildSessionFactory();
		}catch (Throwable e) {
			log.error("����SessionFactoryʵ��ʧ��",e);
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		}
	}
	//����ȫ��Configuration�����ʵ��
	public static Configuration getConfiguration() {
		return configuration;
	}
	
	//����SessionFactory����ʵ��
	public static SessionFactory getSessionFactory() {
		SessionFactory sf= sessionFactory;
		if(sf==null) {
			throw new IllegalStateException("SessionFactory���ɷ���");
		}
		return sf;
	}
	
	//�رյ�ǰSessionFactorty�ͷŶ���
	public static void shutdown() {
		log.debug("Shutting down Hibernate");
		//�رյ�ͬʱ��ͬʱ�ر��˻�������ӳ�
		getSessionFactory().close();
		
		configuration=null;
		sessionFactory=null;
	}
	
	//�ύ��ǰ����
	public static void commitAndBeginTransaction() {
		sessionFactory.getCurrentSession().getTransaction().commit();
		sessionFactory.getCurrentSession().beginTransaction();
	}
}
