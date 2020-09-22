package com.oreno.DAO;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mysql.jdbc.Connection;
import com.oreno.VO.ProductBean;



public class product_BoardDAO {

	Connection con;
	SqlSessionFactory sqlfactory;

	private static product_BoardDAO instance;

	public static product_BoardDAO getinstance() {
		if(instance == null) {
			synchronized (product_BoardDAO.class) {
				instance = new product_BoardDAO();
			}
		}
		return instance;
	}


	public product_BoardDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlfactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}


	// 신규 상품 등록코드 부여중 카테고리 maxCount 

	public int getProductCode(String p_category) {
	
	int categoryMax = 0;
		
	SqlSession session = sqlfactory.openSession();
	
	
	try {
		// 통일 카테고리로 등록 된 최대 상품 코드 +1  => 신규 카테고리 번호
		categoryMax = session.selectOne("카테고리max", p_category);
		
		if(categoryMax == 0) {
			categoryMax = 1;
		}else {
			categoryMax = categoryMax+1;
			
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	return categoryMax;
	}


	// 신규 상품 등록

	public int registProduct(ProductBean productdetail){
		int registResult = 0;


		return registResult;
	}


	// 등록 상품 삭제

	public int deleteProduct(String product_code) {
		int deleteResult = 0;

		return deleteResult;
	}


	// 상품 등록 수정

	public int updateProduct(String product_code) {
		int updateResult = 0;

		return updateResult;

	}

	// 상품 클릭시 디테일 내용 get

	public List<ProductBean> getProductDetail(String produce_code) {
		List<ProductBean> p_detail = new ArrayList<ProductBean>();



		return p_detail;
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

	public int insertArticle (product_BoardBean boardBean) {

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
	public List<product_BoardBean> selectArticleList (int page, int limit) {

		List<product_BoardBean> articleList = new ArrayList<product_BoardBean>();

		SqlSession sqlsession = sqlfactory.openSession();


		int startrow = (page-1)*10;

		articleList = sqlsession.selectList("selectArticleList", startrow);
		System.out.println(articleList);
		sqlsession.close();

		return articleList;

	}

	// 글 클릭시 확인되는 article 개별

	public List<product_BoardBean> selectArticle (int room_review_no) {


		SqlSession sqlsession = sqlfactory.openSession();
		List<product_BoardBean> article = new ArrayList<product_BoardBean>();

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
	public List<product_BoardBean> isArticleBoardWriter(int room_review_no) {

		SqlSession sqlsession = sqlfactory.openSession();

		List<product_BoardBean> wirterInfo = new ArrayList<product_BoardBean>();

		wirterInfo = sqlsession.selectList("isArticleBoardWriter", room_review_no);

		sqlsession.close();

		return wirterInfo;
	}


	public List<product_BoardBean> updateArticle(product_BoardBean article) {
		SqlSession sqlsession = sqlfactory.openSession();

		List<product_BoardBean> updateArticle = new ArrayList<product_BoardBean>();

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
