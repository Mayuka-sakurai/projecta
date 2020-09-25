package com.oreno.Controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreno.Action.Action;

import com.oreno.Action.member_LoginAction;
import com.oreno.Action.product_ProductRegistAction;


import com.oreno.VO.ActionForward;


@WebServlet("*.pro")
public class ProductController extends javax.servlet.http.HttpServlet 
{
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());

		ActionForward forward = null;
		Action action = null;

		//jsp ������ ������ �α��� ��ư Ŭ����
		if(command.equals("/regist.pro")) {

			forward = new ActionForward();
			forward.setPath("/regist.jsp");

			//jsp ���������� ��Ϲ�ư Ŭ���� 
		}else if(command.equals("/registProduct.pro")){

			action = new product_ProductRegistAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}


			if(forward != null){

				if(forward.isRedirect()){
					response.sendRedirect(forward.getPath());
				}else{
					RequestDispatcher dispatcher=request.getRequestDispatcher(forward.getPath());
					dispatcher.forward(request, response);
				}



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
