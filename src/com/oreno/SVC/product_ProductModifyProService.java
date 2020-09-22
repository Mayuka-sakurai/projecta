package com.oreno.SVC;


import java.util.ArrayList;
import java.util.List;

import com.especial.BoardDAO.REVIEW_BoardDAO;
import com.especial.VO.BoardBean;


public class product_ProductModifyProService {

	public List<BoardBean> isArticleWriter(int room_review_no) throws Exception {
		
		
		REVIEW_BoardDAO boardDAO = REVIEW_BoardDAO.getinstance();
		ArrayList<BoardBean> userInfo = new ArrayList<BoardBean>();
		// �� �ۼ����� information get
		userInfo = (ArrayList<BoardBean>) boardDAO.isArticleBoardWriter(room_review_no);
		
		return userInfo;
		
	}

	public boolean modifyArticle(BoardBean article) throws Exception {
		
		boolean isModifySuccess = false;
		REVIEW_BoardDAO boardDAO = REVIEW_BoardDAO.getinstance();
		
		
		List<BoardBean> temp = boardDAO.updateArticle(article);
		
		if(temp.size() == 1) {
			isModifySuccess = true;
		}
	
		return isModifySuccess;
		
	}

}
