package com.zrcx.mellit.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zrcx.mellit.base.Conn;
import com.zrcx.mellit.user.bean.Userbean;

public class Userdao extends Conn {

	public Userbean getuser(String phone, String pwd) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			connection = getcon();
			preparedStatement = connection
					.prepareStatement("select id,phone,pwd from user where phone=? and pwd=?");
			preparedStatement.setString(1, phone);
			preparedStatement.setString(2, pwd);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				Userbean userbean = new Userbean();
				userbean.setId(resultSet.getInt(1));
				userbean.setPhone(resultSet.getString(2));
				userbean.setPwd(resultSet.getString(3));
				return userbean;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public int checkphone(String phone) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			connection = getcon();
			preparedStatement = connection
					.prepareStatement("select count(id) from user where phone=?");
			preparedStatement.setString(1, phone);
			
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				System.out.println(resultSet.getInt(1));
				return resultSet.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return 0;
	}

	public void adduser(String phone, String pwd) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {

			connection = getcon();
			preparedStatement = connection
					.prepareStatement("insert into user(phone,pwd) values(?,?)");
			preparedStatement.setString(1, phone);
			preparedStatement.setString(2, pwd);

			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
	}

}
