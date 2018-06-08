package com.zrcx.mellit.orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.zrcx.mellit.base.Conn;

public class Orderdao extends Conn {

	public List<Object[]> getallorders(String or, Integer userid) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Object[]> list = new ArrayList<Object[]>();

		connection = getcon();
		try {
			preparedStatement = connection
					.prepareStatement("select o.id,o.code,o.time,o.state,o.user_id,o.addr_id,gg.num,g.name,g.image,g.price,g.describes,g.gclass,sum(g.price*gg.num) from orders  o left join gorders gg on gg.orders_id=o.id  left join goods g on gg.goods_id=g.id where o.user_id=? and o.state=? group by o.id");
			preparedStatement.setInt(1, userid);
			preparedStatement.setString(2, or);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Object[] yuy = new Object[13];
				yuy[0] = resultSet.getInt(1);
				yuy[1] = resultSet.getString(2);
				yuy[2] = resultSet.getTimestamp(3);
				yuy[3] = resultSet.getInt(4);
				yuy[4] = resultSet.getInt(5);
				yuy[5] = resultSet.getInt(6);
				yuy[6] = resultSet.getInt(7);
				yuy[7] = resultSet.getString(8);
				yuy[8] = resultSet.getString(9);
				yuy[9] = resultSet.getBigDecimal(10);
				yuy[10] = resultSet.getString(11);
				yuy[11] = resultSet.getInt(12);
				yuy[12] = resultSet.getBigDecimal(13);

				list.add(yuy);

			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;
	}

	public List<Object[]> getorderxiangqing(String order_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Object[]> list = new ArrayList<Object[]>();

		connection = getcon();
		try {
			preparedStatement = connection
					.prepareStatement("select o.id,o.code,o.time,o.state,o.user_id,o.addr_id,gg.num,g.name,g.image,g.price,g.describes,g.gclass,g.price*gg.num,a.id,a.name,a.province,a.city,a.district,a.street,a.postCode,a.phone,a.state,gg.goods_id from orders  o left join gorders gg on gg.orders_id=o.id  left join goods g on gg.goods_id=g.id left join addr a on o.addr_id = a.id where o.id=? ");
			preparedStatement.setString(1, order_id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Object[] yuy = new Object[23];
				yuy[0] = resultSet.getInt(1);
				yuy[1] = resultSet.getString(2);
				yuy[2] = resultSet.getTimestamp(3);
				yuy[3] = resultSet.getInt(4);
				yuy[4] = resultSet.getInt(5);
				yuy[5] = resultSet.getInt(6);
				yuy[6] = resultSet.getInt(7);
				yuy[7] = resultSet.getString(8);
				yuy[8] = resultSet.getString(9);
				yuy[9] = resultSet.getBigDecimal(10);
				yuy[10] = resultSet.getString(11);
				yuy[11] = resultSet.getInt(12);
				yuy[12] = resultSet.getBigDecimal(13);
				yuy[13] = resultSet.getInt(14);
				yuy[14] = resultSet.getString(15);
				yuy[15] = resultSet.getString(16);
				yuy[16] = resultSet.getString(17);
				yuy[17] = resultSet.getString(18);
				yuy[18] = resultSet.getString(19);
				yuy[19] = resultSet.getString(20);
				yuy[20] = resultSet.getString(21);
				yuy[21] = resultSet.getInt(22);
				yuy[22] = resultSet.getInt(23);
				list.add(yuy);

			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<Object[]> getorderxiangqing2(String order_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Object[]> list = new ArrayList<Object[]>();

		connection = getcon();
		try {
			preparedStatement = connection
					.prepareStatement("select o.id,o.code,o.time,o.state,o.user_id,o.addr_id,gg.num,g.name,g.image,g.price,g.describes,g.gclass,sum(g.price*gg.num) from orders  o left join gorders gg on gg.orders_id=o.id  left join goods g on gg.goods_id=g.id where o.id=? ");
			preparedStatement.setString(1, order_id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Object[] yuy = new Object[13];
				yuy[0] = resultSet.getInt(1);
				yuy[1] = resultSet.getString(2);
				yuy[2] = resultSet.getTimestamp(3);
				yuy[3] = resultSet.getInt(4);
				yuy[4] = resultSet.getInt(5);
				yuy[5] = resultSet.getInt(6);
				yuy[6] = resultSet.getInt(7);
				yuy[7] = resultSet.getString(8);
				yuy[8] = resultSet.getString(9);
				yuy[9] = resultSet.getBigDecimal(10);
				yuy[10] = resultSet.getString(11);
				yuy[11] = resultSet.getInt(12);
				yuy[12] = resultSet.getBigDecimal(13);

				list.add(yuy);

			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public void addorder(String code, Timestamp timestamp, int state, Integer id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		connection = getcon();
		try {
			preparedStatement = connection
					.prepareStatement("insert into orders(code,time,state,user_id) values(?,?,?,?)");
			preparedStatement.setString(1, code);
			preparedStatement.setTimestamp(2, timestamp);
			preparedStatement.setInt(3, state);
			preparedStatement.setInt(4, id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
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

	public List<Object[]> getorderxiangqing3(String code) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Object[]> list = new ArrayList<Object[]>();

		connection = getcon();
		try {
			preparedStatement = connection
					.prepareStatement("select o.id,o.code,o.time,o.state,o.user_id,o.addr_id,gg.num,g.name,g.image,g.price,g.describes,g.gclass,g.price*gg.num from orders  o left join gorders gg on gg.orders_id=o.id  left join goods g on gg.goods_id=g.id where o.code=? ");
			preparedStatement.setString(1, code);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Object[] yuy = new Object[13];
				yuy[0] = resultSet.getInt(1);
				yuy[1] = resultSet.getString(2);
				yuy[2] = resultSet.getTimestamp(3);
				yuy[3] = resultSet.getInt(4);
				yuy[4] = resultSet.getInt(5);
				yuy[5] = resultSet.getInt(6);
				yuy[6] = resultSet.getInt(7);
				yuy[7] = resultSet.getString(8);
				yuy[8] = resultSet.getString(9);
				yuy[9] = resultSet.getBigDecimal(10);
				yuy[10] = resultSet.getString(11);
				yuy[11] = resultSet.getInt(12);
				yuy[12] = resultSet.getBigDecimal(13);

				list.add(yuy);

			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public void xiugaidingdan(String order_id, String addr_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		connection = getcon();
		try {
			preparedStatement = connection
					.prepareStatement("update orders set addr_id=?,state=1 where id=? ");
			preparedStatement.setString(1, addr_id);
			preparedStatement.setString(2, order_id);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public int getorderscount() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = getcon();
		try {
			preparedStatement = connection
					.prepareStatement("select count(id) from orders ");

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				return resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	public List<Object[]> admingetorder(int begin, int pageSize, String cphone) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Object[]> list = new ArrayList<Object[]>();
		connection = getcon();
		try {
			preparedStatement = connection
					.prepareStatement("select o.id,o.code,o.time,o.state,u.phone from orders o left join user u on o.user_id = u.id where u.phone like ? limit ?,? ");
			preparedStatement.setString(1, cphone);
			preparedStatement.setInt(2, begin);
			preparedStatement.setInt(3, pageSize);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Object[] ob = new Object[5];
				ob[0] = resultSet.getInt(1);
				ob[1] = resultSet.getString(2);
				ob[2] = resultSet.getTimestamp(3);
				ob[3] = resultSet.getInt(4);
				ob[4] = resultSet.getString(5);
				list.add(ob);
			}return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
