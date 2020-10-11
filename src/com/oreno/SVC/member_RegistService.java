package com.oreno.SVC;

import com.oreno.DAO.member_MemberDAO;
import com.oreno.VO.UserBean;

public class member_RegistService {

	public boolean registMember(UserBean userBean) throws Exception {
		boolean isNewMember = false;

		member_MemberDAO memberDAO = member_MemberDAO.getinstance();
		memberDAO = new member_MemberDAO();

		int regmemeber = memberDAO.registMember(userBean);

		if(regmemeber > 0 ) {
			isNewMember = true;
		}else {
			isNewMember = false;
		}

		return isNewMember; 
	}
}
