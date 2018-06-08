package com.zrcx.mellit.gorders.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zrcx.mellit.base.Conn;

public class Gorderdao extends Conn{

	public void addgorder(Integer id, String order_id, String goods_id, int i) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		connection = getcon();
		try {
			preparedStatement = connection
					.prepareStatement("insert into gorders(user_id,orders_id,goods_id,num) values(?,?,?,?)");
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, order_id);
			preparedStatement.setString(3, goods_id);
			preparedStatement.setInt(4, i);
			

			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
