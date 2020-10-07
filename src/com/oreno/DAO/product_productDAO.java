package com.oreno.DAO;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mysql.jdbc.Connection;
import com.oreno.VO.ProductBean;



public class product_productDAO {

	Connection con;
	SqlSessionFactory sqlfactory;

	private static product_productDAO instance;

	public product_productDAO getinstance() {
		if(instance == null) {
			synchronized (product_productDAO.class) {
				instance = new product_productDAO();
			}
		}
		return instance;
	}


	public product_productDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlfactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}


	// 신규 상품 등록코드 부여중 카테고리 maxCount 

	public int getproductCode() {
		int productCode = 0;
		int product_num = 0;
		SqlSession session = sqlfactory.openSession();

		try {
			product_num = session.selectOne("productCount");

			if(product_num > 0 ) {
				product_num = product_num + 1;

			}else {
				product_num = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productCode;
	}


	// 신규 상품 등록

	public int registProduct(ProductBean productBean){
		int registResult = 0;
		
		SqlSession session = sqlfactory.openSession();
		
		registResult = session.insert("registProduct", productBean);
		
		session.commit();
		session.close();

		return registResult;
	}


	// 등록 상품 삭제

	public int deleteProduct(String product_code) {
		int deleteResult = 0;
		
		SqlSession session = sqlfactory.openSession();
		
		deleteResult = session.delete("deleteProduct", product_code);
		
		session.commit();
		session.close();
		return deleteResult;
	}


	// 상품 등록 수정

	public int updateProduct(ProductBean productBean) {
		int updateResult = 0;

		SqlSession session = sqlfactory.openSession();
		
		List<ProductBean> updateProduct = new ArrayList<ProductBean>();
		
		updateProduct = session.selectList("updateProduct", productBean);
		
		session.commit();
		session.close();
		
		return updateResult;

	}

	// 상품 클릭시 디테일 내용 get

	public List<ProductBean> getProductDetail(String produce_code) {
		List<ProductBean> p_detail = new ArrayList<ProductBean>();
		SqlSession session = sqlfactory.openSession();
		p_detail = session.selectList("product_detail", produce_code);
		
		session.commit();
		session.close();

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

	public int insertArticle (ProductBean boardBean) {

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
	public List<ProductBean> selectArticleList (int page, int limit) {

		List<ProductBean> articleList = new ArrayList<ProductBean>();

		SqlSession sqlsession = sqlfactory.openSession();


		int startrow = (page-1)*10;

		articleList = sqlsession.selectList("selectArticleList", startrow);
		System.out.println(articleList);
		sqlsession.close();

		return articleList;

	}

	// 글 클릭시 확인되는 article 개별

	public List<ProductBean> selectArticle (int room_review_no) {


		SqlSession sqlsession = sqlfactory.openSession();
		List<ProductBean> article = new ArrayList<ProductBean>();

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
	public List<ProductBean> isArticleBoardWriter(int room_review_no) {

		SqlSession sqlsession = sqlfactory.openSession();

		List<ProductBean> wirterInfo = new ArrayList<ProductBean>();

		wirterInfo = sqlsession.selectList("isArticleBoardWriter", room_review_no);

		sqlsession.close();

		return wirterInfo;
	}


	public List<ProductBean> updateArticle(ProductBean article) {
		SqlSession sqlsession = sqlfactory.openSession();

		List<ProductBean> updateArticle = new ArrayList<ProductBean>();

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
