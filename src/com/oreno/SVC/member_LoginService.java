package com.oreno.SVC;

import java.sql.ResultSet;
import java.util.List;

import com.oreno.DAO.member_MemberDAO;
import com.oreno.VO.UserBean;


public class member_LoginService {

		public List<UserBean> getUsreInfo(String inputid){
			List<UserBean> userBean = null;
			
			member_MemberDAO memberDAO = member_MemberDAO.getinstance();
			
			//inputid�� ���� ������ ���� ����Ʈ�� ���� --> userBean ����
			userBean = memberDAO.getLoginInfo(inputid);
			
			return userBean;
			
		}
	
	}

