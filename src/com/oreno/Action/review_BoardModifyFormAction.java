package com.oreno.Action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreno.SVC.BoardDetailService;
import com.oreno.VO.ActionForward;
import com.oreno.VO.review_BoardBean;

public class review_BoardModifyFormAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		System.out.println("ModifyFromAction ����");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String userid = null;
		String userpw = null;
		ActionForward forward = new ActionForward();
		BoardDetailService boardDetailService = new BoardDetailService();	


		int room_review_no = Integer.parseInt(request.getParameter("room_review_no"));

		System.out.println("modify Action room��ȣ" + room_review_no);
		List<review_BoardBean> article = new ArrayList<review_BoardBean>();
		article = boardDetailService.getArticle(room_review_no);

		// �α��� ���� session�� ����� ��й�ȣ ȹ��
		HttpSession session = request.getSession();
		userid = (String)session.getAttribute("id");
		userpw = (String)session.getAttribute("pw");

		String dbid = article.get(0).getMember_id();
		String dbpw = article.get(0).getMember_password();
		request.setAttribute("article", article);

		if(dbid.equals(userid)) {
			if(dbpw.equals(userpw)) {

				forward.setPath("/review_modify.jsp");
			}
		}
		return forward;


	}

}