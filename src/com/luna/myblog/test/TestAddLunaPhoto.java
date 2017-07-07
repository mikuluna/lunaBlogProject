package com.luna.myblog.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.luna.myblog.entity.LunaLog;
import com.luna.myblog.entity.LunaPhoto;
import com.luna.myblog.entity.LunaPhotoDetial;

public class TestAddLunaPhoto {
	Configuration conf;
	SessionFactory sessionFactory;
	Session session;
	@Before
	public void init(){
		session= new Configuration().configure().buildSessionFactory().openSession();
	}
	@Test
	public void testAddPhoto(){
		LunaPhoto lupho = new LunaPhoto();
		lupho.setIntro("dsa");
		lupho.setTitle("dsd");
		LunaPhotoDetial det1 = new LunaPhotoDetial("1.jpg");
		LunaPhotoDetial det2 = new LunaPhotoDetial("2.jpg");
		LunaPhotoDetial det3 = new LunaPhotoDetial("3.jpg");
		lupho.getLunaphodet().add(det1);
		lupho.getLunaphodet().add(det2);
		lupho.getLunaphodet().add(det3);
		Transaction tx = session.beginTransaction();
		session.save(lupho);
		tx.commit();
	}
	@Test
	public void testAddLog(){
		LunaLog log = new LunaLog();
		log.setContain("<p style="+"text-align:center;"+"><strong><span style="+"font-size: 22px;"+">Java的基本理念是“结构不佳的代码不能运行”恢复模型和终止模型。&nbsp;</span></strong></p><p style="+"margin-left: 0px; text-align: justify;text-indent:2em;"+">&nbsp; &nbsp;&nbsp;恢复模型开始显得很吸引人，但是不是很实用。其中主要原因可能是它所导致的耦合：恢复性的处理程序需要了解异常抛出的地点，这势必要包含依赖于抛出位置的非通用性代码。这增加了代码编写和维护的困难，对于异常可能会从许多地方抛出的大型程序来说，更是如此。</p>");
		log.setIntroduction("aaaaaa");
		log.setTitle("biaoti");
		Transaction tx = session.beginTransaction();
		session.save(log);
		tx.commit();
	}
	
	
	
	@After
	public void close(){
		session.close();
	}
}
