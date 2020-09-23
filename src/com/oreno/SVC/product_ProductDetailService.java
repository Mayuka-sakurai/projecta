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
		System.out.println("디테일 리드카운트"+readCount);
		article = boardDAO.selectArticle(room_review_no);
		
		System.out.println("수정후 디테일 아티클"+article);

		return article;

	}

}
