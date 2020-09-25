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
import com.oreno.VO.ProductBean;



public class product_ProductRegistAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ActionForward forward = null;
		ProductBean productBean = null;
		String realFolder = "";
		String saveFolder = "/product_img";
		int fileSize = 5*1024*1024;
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request, realFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());
		
		//jsp 세션과 http세션은 다르기때문에, httpsession의 객체를 선언한 이후, 이 세션으로 사용이 가능하다.
		HttpSession session = request.getSession();

		productBean = new ProductBean();
//		productBean.setProduct_code(product_code);
		productBean.setProduct_title(multi.getParameter("title"));
		productBean.setProduct_artist(multi.getParameter("artist"));
		productBean.setProduct_category(multi.getParameter("category"));
		productBean.setProduct_year(multi.getParameter("year"));
		productBean.setProduct_barcode(multi.getParameter("barcode"));
		productBean.setProduct_image(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
		productBean.setProduct_country(multi.getParameter("country"));
			
		product_ProductRegistProService boardWriteProService = new product_ProductRegistProService();
		
		boolean isRegistSuccess = product_ProductRegistProService(productBean)
		boolean isWriteSuccess = boardWriteProService.registArticle(productBean);
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