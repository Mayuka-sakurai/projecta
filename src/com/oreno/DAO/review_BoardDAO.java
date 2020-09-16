package com.oreno.DAO;

import java.io.IOException;
import java.io.Reader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oreno.VO.review_BoardBean;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class review_BoardDAO {

	Connection con;
	SqlSessionFactory sqlfactory;

	private static review_BoardDAO instance;

	public static review_BoardDAO getinstance() {
		if(instance == null) {
			synchronized (review_BoardDAO.class) {
				instance = new review_BoardDAO();
			}
		}
		return instance;
	}


	public review_BoardDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlfactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}



	// article 번호 등록(Write)

	public int articleNumber() {

		int listCount = 0;
		int count = 0;
		SqlSession sqlsession = sqlfactory.openSession();


		try {

			count = sqlsession.selectOne("listCount");

			if(count > 0) {

				listCount = count + 1;

			}else {
				listCount = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return listCount;
	}

	// article 등록

	public int insertArticle (review_BoardBean boardBean) {

		SqlSession sqlsession = sqlfactory.openSession();

		int count = sqlsession.insert("insertArticle",boardBean);
		sqlsession.commit();
		sqlsession.close();
		return count;
	}

	// List view에서 사용되는 ListCount

	public int selectListCount() {	

		int listcount = 0;

		SqlSession sqlsession = sqlfactory.openSession();


		listcount = sqlsession.selectOne("selectListCount");
		sqlsession.close();
		
		return listcount;
	}

	// 전체 article 가져오기 (List View)
	public List<review_BoardBean> selectArticleList (int page, int limit) {

		List<review_BoardBean> articleList = new ArrayList<review_BoardBean>();

		SqlSession sqlsession = sqlfactory.openSession();


		int startrow = (page-1)*10;

		articleList = sqlsession.selectList("selectArticleList", startrow);
		System.out.println(articleList);
		sqlsession.close();
		
		return articleList;

	}

	// 글 클릭시 확인되는 article 개별

	public List<review_BoardBean> selectArticle (int room_review_no) {


		SqlSession sqlsession = sqlfactory.openSession();
		List<review_BoardBean> article = new ArrayList<review_BoardBean>();

		article = sqlsession.selectList("selectArticle",room_review_no);
		sqlsession.close();
		System.out.println(article);
		
		return article;
	}

	// 클릭시 readcount 증가처리
	public int updateReadCount(int room_review_no) {
		SqlSession sqlsession = sqlfactory.openSession();

		int readcount = 0;

		readcount = sqlsession.update("updateReadCount", room_review_no);

		System.out.println("dao readcount" + readcount);
		sqlsession.commit();
		sqlsession.close();
		
		return readcount;
	}


	public int hotelCount() {
		SqlSession sqlsession = sqlfactory.openSession();

		int hotelcount = 0;

		hotelcount = sqlsession.selectOne("hotelArticleCount");
		sqlsession.close();

		return hotelcount;
	}

	public int facilityCount() {
		SqlSession sqlsession = sqlfactory.openSession();

		int facilitycount = 0;

		facilitycount = sqlsession.selectOne("facilityArticleCount");
		sqlsession.close();
		return facilitycount;
	}

	public int hallcount() {
		SqlSession sqlsession = sqlfactory.openSession();

		int hallcount = 0;

		hallcount = sqlsession.selectOne("hallArticleCount");
		sqlsession.close();
		return hallcount;
	}

	// 글쓴이의 아이디와 비밀번호 get
	public List<review_BoardBean> isArticleBoardWriter(int room_review_no) {

		SqlSession sqlsession = sqlfactory.openSession();

		List<review_BoardBean> wirterInfo = new ArrayList<review_BoardBean>();

		wirterInfo = sqlsession.selectList("isArticleBoardWriter", room_review_no);
		
		sqlsession.close();

		return wirterInfo;
	}


	public List<review_BoardBean> updateArticle(review_BoardBean article) {
		SqlSession sqlsession = sqlfactory.openSession();
		
		List<review_BoardBean> updateArticle = new ArrayList<review_BoardBean>();
		
		updateArticle = sqlsession.selectList("updateArticle", article);
		sqlsession.commit();
		sqlsession.close();
		
		return updateArticle;
	}
	

		public int deleteArticle(int room_review_no){
			int deleteCount = 0;
			
			SqlSession sqlsession = sqlfactory.openSession();
			
			deleteCount = sqlsession.delete("deleteArticle", room_review_no);
			
			sqlsession.commit();
			sqlsession.close();
			
			return deleteCount;
		}
	
	
	//	public int insertReplyArticle(BoardBean article) {
	//		return 0;
	//	}
	//
}
