package com.oreno.Action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreno.SVC.BoardDeleteProService;
import com.oreno.VO.ActionForward;
import com.oreno.VO.review_BoardBean;



public class review_DeleteProAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception{	 

		System.out.println("delete ����");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ActionForward forward = null;
		int room_review_no = Integer.parseInt(request.getParameter("room_review_no"));
		String nowPage = request.getParameter("page");
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("id");
		String userpw = (String)session.getAttribute("pw");


		BoardDeleteProService boardDeleteProService = new BoardDeleteProService();
		ArrayList<review_BoardBean> writerDBId = new ArrayList<review_BoardBean>();
		writerDBId= (ArrayList<review_BoardBean>) boardDeleteProService.isArticleWriter(room_review_no);
		System.out.println("delete = userid" + userid);
		System.out.println(writerDBId.get(0).getMember_id());
		System.out.println("delete = userpw" + userpw);
		System.out.println(writerDBId.get(0).getMember_password());


		if(writerDBId.get(0).getMember_id().equals(userid)){
			if(writerDBId.get(0).getMember_password().equals(userpw)) {
				// ���̵�� ��й�ȣ�� �¾Ƽ� ������ ������ ����.
				forward = new ActionForward();
				boolean isDeleteSuccess = boardDeleteProService.removeArticle(room_review_no);
				forward.setRedirect(true);
				forward.setPath("room_reviewList.room?page=" + nowPage);
				System.out.println("isDeleteSuccess" + isDeleteSuccess);
				System.out.println("�����Ϸ�");
			}else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('��������');");
				out.println("history.back();");
				out.println("</script>");
				out.close();
			}


		}
		return forward;
	}
}






