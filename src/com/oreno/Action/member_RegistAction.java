package com.oreno.Action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreno.SVC.member_RegistService;
import com.oreno.VO.ActionForward;
import com.oreno.VO.UserBean;

public class member_RegistAction implements Action{

	@Override

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{

		ActionForward forward = null;
		UserBean userBean = null;

		HttpSession session = request.getSession();

		userBean = new UserBean();

		userBean.setUserid((String)session.getAttribute("userid"));
		userBean.setPassword((String)session.getAttribute("password"));
		userBean.setName((String)session.getAttribute("name"));
		userBean.setAddress((String)session.getAttribute("address_main")+" "+(String)session.getAttribute("address_detail"));
		userBean.setTel((String)session.getAttribute("tel"));

		member_RegistService registservice = new member_RegistService();

		boolean isRegistSuccess = registservice.registMember(userBean);

		if(isRegistSuccess = false) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();


			out.println("<script>");
			out.println("alert('회원가입이 실패하였습니다.')");
			out.println("history.back()");
			out.println("</script>");

		}else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("index.mem");

		}

		return forward;

	}

}
