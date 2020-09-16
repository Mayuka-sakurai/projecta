package com.oreno.Action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreno.SVC.BoardDetailService;
import com.oreno.VO.ActionForward;
import com.oreno.VO.review_BoardBean;




public class review_BoardDetailAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{ 
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		List<review_BoardBean> article = new ArrayList<review_BoardBean>();
		int room_review_no = Integer.parseInt(request.getParameter("room_review_no"));
		String page = request.getParameter("page");


		BoardDetailService boardDetailService = new BoardDetailService();

		article = boardDetailService.getArticle(room_review_no);
		System.out.println("article" + article);

		ActionForward forward = new ActionForward();

		request.setAttribute("page", page);
		request.setAttribute("article", article);

		System.out.println("boarddetail액션  page" + page);
		System.out.println("boarddetail액션  article" + article);

		forward.setPath("/review_detail.jsp");

		return forward;

	}

}