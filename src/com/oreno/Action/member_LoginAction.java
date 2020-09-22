package com.oreno.Action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreno.SVC.member_LoginService;
import com.oreno.VO.ActionForward;
import com.oreno.VO.UserBean;

public class member_LoginAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
	
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-&");
		ActionForward forward = null;
		HttpSession session = request.getSession();
		List<UserBean> userbean = new ArrayList<UserBean>();
		String inputid = request.getParameter("inputid");
		String inputpw = request.getParameter("password");
		
		
		member_LoginService loginService = new member_LoginService();
		
		List<UserBean> dbdata = loginService.getUsreInfo(inputid);
		
		if(dbdata.get(1).getUserid().equals(inputid)) {
			
			if(dbdata.get(1).getPassword().equals(inputpw)) {
				
				session.setAttribute("userid", inputid);
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("index.jsp");
				
			}else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				
				out.println("<script>");
				out.println("alert('비밀번호가 다릅니다')");
				out.println("history.back();");
				out.println("</script>");
			}
		}else {
			response.setContentType("test/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('아이디가 없습니다.')");
			out.println("history.back();");
			out.println("</script>");
			
		}
		return forward;
	}
}
