package com.oreno.SVC;


import java.util.ArrayList;
import java.util.List;

import com.especial.BoardDAO.REVIEW_BoardDAO;

import com.especial.VO.BoardBean;


public class product_ProductDeleteProService {

	public List<BoardBean> isArticleWriter(int room_review_no) throws Exception {

		REVIEW_BoardDAO boardDAO = new REVIEW_BoardDAO();
		REVIEW_BoardDAO.getinstance();
		List<BoardBean> writerInfo = new ArrayList<BoardBean>();
		writerInfo = boardDAO.isArticleBoardWriter(room_review_no);

		// �۾����� id ��ȯ
		
		return writerInfo;
		
	}

	public boolean removeArticle(int room_review_no) throws Exception{
		// TODO Auto-generated method stub
		
		boolean isRemoveSuccess = false;
		REVIEW_BoardDAO boardDAO = REVIEW_BoardDAO.getinstance();
		int deleteCount = boardDAO.deleteArticle(room_review_no);
		System.out.println(room_review_no);
		System.out.println("****************"+deleteCount);
		
		if(deleteCount == 1) {
			isRemoveSuccess = true;
		}else {
			System.out.println("��������");
		}

		return isRemoveSuccess;
	}

}
