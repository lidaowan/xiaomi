package com.zrcx.mellit.goods.dao;

import java.lang.reflect.Executable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zrcx.mellit.admin.bean.Adminbean;
import com.zrcx.mellit.base.Conn;
import com.zrcx.mellit.goods.bean.Goodbean;

public class Goodsdao extends Conn {

	public Goodbean getgoodsxiangxixinxi(String goods_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = getcon();
		try {
			preparedStatement = connection
					.prepareStatement("select id,name,image,price,describes,gclass from goods where id=?");
			preparedStatement.setString(1, goods_id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Goodbean goodbean = new Goodbean();
				goodbean.setId(resultSet.getInt(1));
				goodbean.setName(resultSet.getString(2));
				goodbean.setImage(resultSet.getString(3));
				goodbean.setPrice(resultSet.getBigDecimal(4));
				goodbean.setDescribes(resultSet.getString(5));
				goodbean.setGclass(resultSet.getInt(6));

				return goodbean;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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

		return null;
	}

	public void xiugaigoods(Goodbean goodbean) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = getcon();
		try {
			preparedStatement = connection
					.prepareStatement("update goods set name=?,image=?,price=?,describes=?,gclass=? where id=?");
			preparedStatement.setString(1, goodbean.getName());
			preparedStatement.setString(2, goodbean.getImage());
			preparedStatement.setBigDecimal(3, goodbean.getPrice());
			preparedStatement.setString(4, goodbean.getDescribes());
			preparedStatement.setInt(5, goodbean.getGclass());
			preparedStatement.setInt(6, goodbean.getId());

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
		}	}

}
