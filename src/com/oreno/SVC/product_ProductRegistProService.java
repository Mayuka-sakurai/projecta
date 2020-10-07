package com.oreno.SVC;

import com.oreno.DAO.product_productDAO;
import com.oreno.VO.ProductBean;

public class product_ProductRegistProService {

	// 신규 상품 코드 등록시 카테고리 약자 등록



	// 신규 상품 등록
	public boolean registProduct(ProductBean productBean) throws Exception{

		boolean isRegistSuccess = false;

		product_productDAO productDAO = productDAO.getinstance();

		productDAO = new product_productDAO();

		int product_no = productDAO.getproductCode();
		productBean.setProduct_code(product_no);

		int registCount = productDAO.registProduct(productBean);

		if(registCount > 0 ) {
			isRegistSuccess = true;

		}else {

		}


		return isRegistSuccess;




	}
}