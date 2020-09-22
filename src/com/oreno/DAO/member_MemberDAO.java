package com.oreno.DAO;

import java.io.IOException;
import java.io.Reader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oreno.VO.UserBean;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class member_MemberDAO {

	Connection con;
	SqlSessionFactory sqlfactory;

	private static member_MemberDAO instance;

	public static member_MemberDAO getinstance() {
		if(instance == null) {
			synchronized (member_MemberDAO.class) {
				instance = new member_MemberDAO();
			}
		}
		return instance;
	}


	public member_MemberDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlfactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}



	public List<UserBean> getLoginInfo(String inputid) {
		SqlSession session = sqlfactory.openSession();
		List<UserBean> userInfo = new ArrayList<UserBean>();


		try {
			userInfo = session.selectList("loginInfo", inputid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userInfo;

	}
}