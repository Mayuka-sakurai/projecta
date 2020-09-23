package com.oreno.SVC;

import com.oreno.DAO.product_productDAO;
import com.oreno.VO.ProductBean;

public class product_ProductRegistProService {

	// 신규 상품 등록
	public boolean registProduct(ProductBean productBean) throws Exception{
		
		boolean isWriteSuccess = false;
	
		product_productDAO productDAO = productDAO.getinstance();
		
		productDAO = new product_productDAO();
		
		

		int registCount = productDAO.registProduct(productBean);
		
		
		
	
		int room_review_no = 0;
		
		room_review_no = boardDAO.articleNumber();
		boardBean.setRoom_review_no(room_review_no);
	
		
		int insertCount = boardDAO.insertArticle(boardBean);
		
		if(insertCount > 0){
			
			isWriteSuccess = true;
		}
		else{
			
		}
		
	

		return isWriteSuccess;
		
	}

}
