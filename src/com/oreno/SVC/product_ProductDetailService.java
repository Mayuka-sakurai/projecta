package com.oreno.SVC;

import java.util.List;

import com.oreno.DAO.product_productDAO;
import com.oreno.VO.ProductBean;




public class product_ProductDetailService {

	public List<ProductBean> getArticle(String product_code) throws Exception{

		List<ProductBean> detailList = null;
		product_productDAO productDAO = product_productDAO.getinstance();
		
		int categoryMax = productDAO.getProductCode(product_category);

		detailList = productDAO.selectDetailList(product_code);
		
		
		
		int readCount = boardDAO.updateReadCount(room_review_no);
		System.out.println("������ ����ī��Ʈ"+readCount);
		article = boardDAO.selectArticle(room_review_no);
		
		System.out.println("������ ������ ��ƼŬ"+article);

		return article;

	}

}
