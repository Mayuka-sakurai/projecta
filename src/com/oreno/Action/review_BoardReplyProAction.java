package com.oreno.Action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreno.SVC.BoardReplyProService;
import com.oreno.VO.ActionForward;
import com.oreno.VO.review_BoardBean;


public class review_BoardReplyProAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
			throws Exception{

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		ActionForward forward = null;
		String nowPage = request.getParameter("page");
		HttpSession session = request.getSession();
		review_BoardBean article = new review_BoardBean();  		

		article.setRoom_review_no(Integer.parseInt(request.getParameter("room_review_no")));
		article.setMember_id((String)session.getAttribute("id"));
		article.setMember_password((String)session.getAttribute("pw"));
		article.setRoom_review_title(request.getParameter("texttitle"));
		article.setRoom_review_contents(request.getParameter("content"));
		article.setBOARD_RE_REF(Integer.parseInt(request.getParameter("BOARD_RE_REF")));
		article.setBOARD_RE_LEV(Integer.parseInt(request.getParameter("BOARD_RE_LEV")));
		article.setBOARD_RE_SEQ(Integer.parseInt(request.getParameter("BOARD_RE_SEQ")));	   		
		BoardReplyProService boardReplyProService = new BoardReplyProService();
		boolean isReplySuccess = boardReplyProService.replyArticle(article);

		if(isReplySuccess){
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("room_review_no?page=" + nowPage);
		}
		else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('답장실패')");
			out.println("history.back()");
			out.println("</script>");
		}

		return forward;

	}  	

}