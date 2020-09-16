package com.oreno.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.orno.SVC.BoardDetailService;
import com.oreno.VO.ActionForward;
import com.oreno.VO.review_BoardBean;


public class review_BoardReplyFormAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
			throws Exception{

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		String nowPage = request.getParameter("page");
		int room_review_no = Integer.parseInt(request.getParameter("room_review_no"));
		BoardDetailService boardDetailService = new BoardDetailService();
		review_BoardBean article=boardDetailService.getArticle(room_review_no);	
		request.setAttribute("article", article);
		request.setAttribute("page", nowPage);
		forward.setPath("/qna_board_reply.jsp");
		return forward;

	}

}