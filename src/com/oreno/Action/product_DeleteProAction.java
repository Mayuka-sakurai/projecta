package com.oreno.Action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreno.SVC.product_ProductDeleteProService;
import com.oreno.VO.ActionForward;
import com.oreno.VO.product_BoardBean;



public class product_DeleteProAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception{	 

		System.out.println("delete 도착");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ActionForward forward = null;
		int room_review_no = Integer.parseInt(request.getParameter("room_review_no"));
		String nowPage = request.getParameter("page");
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("id");
		String userpw = (String)session.getAttribute("pw");


		product_ProductDeleteProService boardDeleteProService = new product_ProductDeleteProService();
		ArrayList<product_BoardBean> writerDBId = new ArrayList<product_BoardBean>();
		writerDBId= (ArrayList<product_BoardBean>) boardDeleteProService.isArticleWriter(room_review_no);
		System.out.println("delete = userid" + userid);
		System.out.println(writerDBId.get(0).getMember_id());
		System.out.println("delete = userpw" + userpw);
		System.out.println(writerDBId.get(0).getMember_password());


		if(writerDBId.get(0).getMember_id().equals(userid)){
			if(writerDBId.get(0).getMember_password().equals(userpw)) {
				// 아이디와 비밀번호가 맞아서 삭제가 가능한 상태.
				forward = new ActionForward();
				boolean isDeleteSuccess = boardDeleteProService.removeArticle(room_review_no);
				forward.setRedirect(true);
				forward.setPath("room_reviewList.room?page=" + nowPage);
				System.out.println("isDeleteSuccess" + isDeleteSuccess);
				System.out.println("삭제완료");
			}else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('삭제실패');");
				out.println("history.back();");
				out.println("</script>");
				out.close();
			}


		}
		return forward;
	}
}






