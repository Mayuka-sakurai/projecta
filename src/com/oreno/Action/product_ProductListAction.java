package com.oreno.Action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreno.SVC.product_ProductListService;
import com.oreno.VO.ActionForward;
import com.oreno.VO.PageInfo;
import com.oreno.VO.ProductBean;


public class product_ProductListAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		List<ProductBean> productList = new ArrayList<ProductBean>();

		int page = 1;
		int limit = 10;

		System.out.println("page " + page);
		if(request.getParameter("page") != null){

			page = Integer.parseInt(request.getParameter("page"));
		}

		product_ProductListService listSerivce = new product_ProductListService();
		
		int listCount = listSerivce.getListCount();
		
		productList = listSerivce.getList(page, limit);
		
		//총 페이지 수.
		int maxPage = (int)((double)listCount / limit + 0.95); //0.95를 더해서 올림 처리.

		//현재 페이지에 보여줄 시작 페이지 수(1, 11, 21 등...)
		int startPage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;

		//현재 페이지에 보여줄 마지막 페이지 수.(10, 20, 30 등...)
		int endPage = startPage + 10 - 1;

		if (endPage > maxPage) endPage = maxPage;

		PageInfo pageInfo = new PageInfo();

		pageInfo.setEndPage(endPage);
		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);	



		
		request.setAttribute("pageInfo", pageInfo); 
		request.setAttribute("productlist", productList);

		System.out.println("pageinfo" + pageInfo);
		System.out.println(productList);


		//		response.setContentType("text/html; charset=UTF-8");
		//		PrintWriter out = response.getWriter();
		//
		//		out.println("<input type = 'text' name = 'hotelcount' value = " + hotelCount + "/>");


		ActionForward forward = new ActionForward();

		forward.setPath("room-List.room");

		return forward;

	}

}