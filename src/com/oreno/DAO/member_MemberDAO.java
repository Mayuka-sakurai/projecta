package com.oreno.DAO;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mysql.jdbc.Connection;
import com.oreno.VO.UserBean;

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

	//�ű� ��� ���
	public int registMember(UserBean userBean){
		SqlSession session = sqlfactory.openSession();
		boolean newMember = false;
		int regcount = session.insert("signup", userBean);

		System.out.println("dao ����");
		session.commit();
		session.close();

		
		return regcount;

	}
	//���� �α���
	public List<UserBean> getLoginInfo(String inputid) {
		SqlSession session = sqlfactory.openSession();
		List<UserBean> userInfo = new ArrayList<UserBean>();


		try {
			userInfo = session.selectList("loginInfo", inputid);

		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		
		return userInfo;

	}
	//����� ����
	public void userCehck(String id, String password){
		SqlSession session = sqlfactory.openSession();
		int auth = -1;
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//id�ߺ�Ȯ��
	public void confirmid(String id) {
		SqlSession session = sqlfactory.openSession();
		String dbid = null;
		try {
			dbid = session.selectOne("idauth", id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		session.close();
	}

	//ȸ������ ����
	public void updateUserInfo() {}

	// ȸ��Ż�� 
	public void deleteUser(String id, String password) {}
}