package com.oreno.Action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import com.oreno.SVC.product_ProductRegistProService;
import com.oreno.VO.ActionForward;
import com.oreno.VO.product_BoardBean;
import com.oreno.BoardDAO.REVIEW_BoardDAO;


public class product_BoardWriteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ActionForward forward = null;
		product_BoardBean boardBean = null;
		String realFolder = "";
		String saveFolder = "/reviewphoto";
		int fileSize = 5*1024*1024;
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request, realFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());
		
		//jsp 세션과 http세션은 다르기때문에, httpsession의 객체를 선언한 이후, 이 세션으로 사용이 가능하다.
		HttpSession session = request.getSession();

		
		boardBean = new product_BoardBean();
		boardBean.setRoom_review_category(multi.getParameter("category"));
		boardBean.setRoom_review_title(multi.getParameter("texttitle"));
		boardBean.setRoom_review_contents(multi.getParameter("content"));
		
		// 세션에 등록되어진 값을 가져오는 경우 > 일반 session.get으로 받아오면 된다. 폼에서 진행되는 경우 multi로 받았음!
		boardBean.setMember_id((String)session.getAttribute("id"));
		boardBean.setMember_password((String)session.getAttribute("pw"));
		boardBean.setRoom_review_file(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
	
		product_ProductRegistProService boardWriteProService = new product_ProductRegistProService();
		boolean isWriteSuccess = boardWriteProService.registArticle(boardBean);
		System.out.println(isWriteSuccess);

		
		if(isWriteSuccess = false) {
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('등록실패')");
			out.println("history.back();");
			out.println("</script>");
					
		}else{
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("room_reviewList.room");
			
		}
		
		
		return forward;

	}

	

}