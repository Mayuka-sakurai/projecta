package com.oreno.SVC;

import com.oreno.DAO.product_productDAO;
import com.oreno.VO.ProductBean;

public class product_ProductRegistProService {

	// �ű� ��ǰ �ڵ� ��Ͻ� ī�װ� ���� ���



	// �ű� ��ǰ ���
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