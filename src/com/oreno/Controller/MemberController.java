package com.oreno.Controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreno.Action.Action;

import com.oreno.Action.member_LoginAction;
import com.oreno.Action.member_RegistAction;
import com.oreno.VO.ActionForward;


@WebServlet("*.mem")
public class MemberController extends javax.servlet.http.HttpServlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());

		ActionForward forward = null;
		Action action = null;

		//jsp 페이지 내에서 로그인 버튼 클릭시
		if(command.equals("/login.mem")) {

			forward = new ActionForward();
			forward.setPath("/login.jsp");

			//로그인 페이지에서 로그인 submit 실행시
		}else if(command.equals("/login.mem")){

			action = new member_LoginAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/index.mem")) {
			forward = new ActionForward();
			forward.setPath("/index.jsp");
		}else if(command.equals("/signup.mem")) {
			action = new member_RegistAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}


	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request,response);
	}  	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request,response);
	}   

}
