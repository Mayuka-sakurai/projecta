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


	// �ű� ��ǰ ����ڵ� �ο��� ī�װ� maxCount 

	public int getProductCode(String p_category) {
	
	int categoryMax = 0;
		
	SqlSession session = sqlfactory.openSession();
	
	
	try {
		// ���� ī�װ��� ��� �� �ִ� ��ǰ �ڵ� +1  => �ű� ī�װ� ��ȣ
		categoryMax = session.selectOne("ī�װ�max", p_category);
		
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


	// �ű� ��ǰ ���

	public int registProduct(ProductBean productdetail){
		int registResult = 0;


		return registResult;
	}


	// ��� ��ǰ ����

	public int deleteProduct(String product_code) {
		int deleteResult = 0;

		return deleteResult;
	}


	// ��ǰ ��� ����

	public int updateProduct(String product_code) {
		int updateResult = 0;

		return updateResult;

	}

	// ��ǰ Ŭ���� ������ ���� get

	public List<ProductBean> getProductDetail(String produce_code) {
		List<ProductBean> p_detail = new ArrayList<ProductBean>();



		return p_detail;
	}

	// article ��ȣ ���(Write)

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

	// article ���

	public int insertArticle (product_BoardBean boardBean) {

		SqlSession sqlsession = sqlfactory.openSession();

		int count = sqlsession.insert("insertArticle",boardBean);
		sqlsession.commit();
		sqlsession.close();
		return count;
	}

	// List view���� ���Ǵ� ListCount

	public int selectListCount() {	

		int listcount = 0;

		SqlSession sqlsession = sqlfactory.openSession();


		listcount = sqlsession.selectOne("selectListCount");
		sqlsession.close();

		return listcount;
	}

	// ��ü article �������� (List View)
	public List<product_BoardBean> selectArticleList (int page, int limit) {

		List<product_BoardBean> articleList = new ArrayList<product_BoardBean>();

		SqlSession sqlsession = sqlfactory.openSession();


		int startrow = (page-1)*10;

		articleList = sqlsession.selectList("selectArticleList", startrow);
		System.out.println(articleList);
		sqlsession.close();

		return articleList;

	}

	// �� Ŭ���� Ȯ�εǴ� article ����

	public List<product_BoardBean> selectArticle (int room_review_no) {


		SqlSession sqlsession = sqlfactory.openSession();
		List<product_BoardBean> article = new ArrayList<product_BoardBean>();

		article = sqlsession.selectList("selectArticle",room_review_no);
		sqlsession.close();
		System.out.println(article);

		return article;
	}

	// Ŭ���� readcount ����ó��
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

	// �۾����� ���̵�� ��й�ȣ get
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
