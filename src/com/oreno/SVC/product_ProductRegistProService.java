package com.oreno.SVC;

import com.oreno.DAO.product_productDAO;
import com.oreno.VO.ProductBean;

public class product_ProductRegistProService {

	// 신규 상품 코드 등록시 카테고리 약자 등록

	public String registCode(String productCategory) throws Exception{

		String code = null;

		if(productCategory.equalsIgnoreCase("cd")) {
			code = "C";
		}else if(productCategory.equalsIgnoreCase("DVD")) {
			code ="D";
		}else if(productCategory.equalsIgnoreCase("blu-ray")) {
			code="BL";
		}else if(productCategory.equalsIgnoreCase("book")) {
			code="B";
		}else if(productCategory.equalsIgnoreCase("magazine")) {
			code ="M";
		}else if(productCategory.equalsIgnoreCase("goods")) {
			code ="G";
		}else {
			code = "E";
		}


		return code;

	}

	// 신규 상품 등록
	public boolean registProduct(ProductBean productBean) throws Exception{

		boolean isWriteSuccess = false;

		product_productDAO productDAO = productDAO.getinstance();

		productDAO = new product_productDAO();



		int registCount = productDAO.registProduct(productBean);

		productBean.setProduct_code(product_code);


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
