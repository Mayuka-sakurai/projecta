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


	//유저 로그인
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
	//사용자 인증
	public void userCehck(String id, String password){
		SqlSession session = sqlfactory.openSession();
		int auth = -1;
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//id중복확인
	public void confirmid(String id) {
		SqlSession session = sqlfactory.openSession();
		String dbid = null;
		try {
			dbid = session.selectOne("idauth", id);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	//회원정보 수정
	public void updateUserInfo() {}

	// 회원탈퇴 
	public void deleteUser(String id, String password) {}
}