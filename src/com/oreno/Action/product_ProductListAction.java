package com.oreno.Action;

import java.io.PrintWriter;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreno.SVC.member_LoginService;
import com.oreno.VO.ActionForward;
import com.oreno.VO.product_BoardBean;
import com.oreno.VO.PageInfo;
import com.oreno.VO.ReviewCount;



public class product_ProductListAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		List<product_BoardBean> articleList = new ArrayList<product_BoardBean>();

		int page = 1;
		int limit = 10;

		System.out.println("page " + page);
		if(request.getParameter("page") != null){

			page = Integer.parseInt(request.getParameter("page"));
		}


		member_LoginService boardListService = new member_LoginService();
		int listCount = boardListService.getListCount();
		System.out.println(listCount);
		articleList = boardListService.getArticleList(page, limit);

		System.out.println("articleList"+  articleList);
		int hotelCount = boardListService.getHotelArticleCount();
		int facilityCount = boardListService.getFacilityArticleCount();
		int hallCount = boardListService.getHallArticleCount();


		ReviewCount count = new ReviewCount();
		count.setHotel(hotelCount);
		count.setFacility(facilityCount);
		//		count.setOffer(offer);
		count.setWedding_Conference(hallCount);



		System.out.println("hotelCount" + hotelCount);
		System.out.println("facilityCount" + facilityCount);
		System.out.println("hallCount" + hallCount);





		//�� ������ ��.
		int maxPage = (int)((double)listCount / limit + 0.95); //0.95�� ���ؼ� �ø� ó��.

		//���� �������� ������ ���� ������ ��(1, 11, 21 ��...)
		int startPage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;

		//���� �������� ������ ������ ������ ��.(10, 20, 30 ��...)
		int endPage = startPage + 10 - 1;

		if (endPage > maxPage) endPage = maxPage;

		PageInfo pageInfo = new PageInfo();

		pageInfo.setEndPage(endPage);
		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);	



		request.setAttribute("listcount", count);
		request.setAttribute("pageInfo", pageInfo); 
		request.setAttribute("articleList", articleList);

		System.out.println("pageinfo" + pageInfo);
		System.out.println(articleList);


		//		response.setContentType("text/html; charset=UTF-8");
		//		PrintWriter out = response.getWriter();
		//
		//		out.println("<input type = 'text' name = 'hotelcount' value = " + hotelCount + "/>");


		ActionForward forward = new ActionForward();

		forward.setPath("room-List.room");

		return forward;

	}

}