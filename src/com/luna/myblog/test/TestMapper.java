package com.luna.myblog.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.luna.myblog.entity.LunaDance;
import com.luna.myblog.entity.Pager;
import com.luna.myblog.mapper.LunaDanceMapper;

public class TestMapper {
	// 会话工厂
		private SqlSessionFactory sqlSessionFactory;


		// 创建工厂
		@Before
		public void init() throws IOException {
			// 配置文件（SqlMapConfig.xml）
			String resource = "mybatis/SqlMapConfig.xml";
			// 加载配置文件到输入 流
			InputStream inputStream = Resources.getResourceAsStream(resource);
			// 创建会话工厂
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		}
		@Test
		public void testInsertLunaDance()throws Exception{
			SqlSession sqlSession = sqlSessionFactory.openSession();
			LunaDanceMapper ludanMapper = sqlSession.getMapper(LunaDanceMapper.class);
			LunaDance lunadance = new LunaDance("dsfs","dfsfs","sdfsfds");
			ludanMapper.insertLunaDance(lunadance);
			sqlSession.commit();
			sqlSession.close();
			
		}
		@Test
		public void testQueryLunaDance()throws Exception{
			SqlSession sqlSession = sqlSessionFactory.openSession();
			LunaDanceMapper ludanMapper = sqlSession.getMapper(LunaDanceMapper.class);
			Pager pager = new Pager();
		
			List<LunaDance> ludanlist = ludanMapper.queryLunaDanceList(pager);
			sqlSession.close();
		}
		@Test
		public void testCountLunaDance()throws Exception{
			SqlSession sqlSession = sqlSessionFactory.openSession();
			LunaDanceMapper ludanMapper = sqlSession.getMapper(LunaDanceMapper.class);
			int count = ludanMapper.countLunaDance();
			System.out.println(count);
		}
}
