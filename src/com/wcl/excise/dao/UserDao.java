package com.wcl.excise.dao;

import com.wcl.excise.tools.JdbcUtils;
import com.wcl.excise.vo.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	
	public User getUser(String name) {
		User user = new User();
		ResultSet resultSet;
		try {
			resultSet = JdbcUtils.query("select * from t_user where userName=?", name);
			while(resultSet.next()) {
				user.setUserName(resultSet.getString(1));
				user.setPassword(resultSet.getString(2));
				user.setChrName(resultSet.getString(3));
				user.setRole(resultSet.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("查询用户失败！");
			e.printStackTrace();
		}
		return user;
	}
	
}
