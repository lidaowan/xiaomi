package com.zrcx.mellit.car.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zrcx.mellit.base.Conn;
import com.zrcx.mellit.car.bean.Carbean;

public class Cardao extends Conn {

	public List<Object[]> getallcarbean(Integer user_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = getcon();
		List<Object[]> list = new ArrayList<Object[]>();
		try {
			preparedStatement = connection
					.prepareStatement("select c.id,c.user_id,c.goods_id,c.num,g.name,g.image,g.price,g.describes,g.gclass,g.price*c.num from car c left join goods g on c.goods_id = g.id where c.user_id=?");
			preparedStatement.setInt(1, user_id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Object[] ob = new Object[10];
				ob[0] = resultSet.getInt(1);
				ob[1] = resultSet.getInt(2);
				ob[2] = resultSet.getInt(3);
				ob[3] = resultSet.getInt(4);
				ob[4] = resultSet.getString(5);
				ob[5] = resultSet.getString(6);
				ob[6] = resultSet.getBigDecimal(7);
				ob[7] = resultSet.getString(8);
				ob[8] = resultSet.getInt(9);
				ob[9] = resultSet.getInt(10);
				list.add(ob);

			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public List<Object[]> getallcarbean2(Integer id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = getcon();
		List<Object[]> list = new ArrayList<Object[]>();
		try {
			preparedStatement = connection
					.prepareStatement("select c.id,c.user_id,c.goods_id,c.num,g.name,g.image,g.price,g.describes,g.gclass,sum(g.price*c.num) from car c left join goods g on c.goods_id = g.id where c.user_id=?");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Object[] ob = new Object[10];
				ob[0] = resultSet.getInt(1);
				ob[1] = resultSet.getInt(2);
				ob[2] = resultSet.getInt(3);
				ob[3] = resultSet.getInt(4);
				ob[4] = resultSet.getString(5);
				ob[5] = resultSet.getString(6);
				ob[6] = resultSet.getBigDecimal(7);
				ob[7] = resultSet.getString(8);
				ob[8] = resultSet.getInt(9);
				ob[9] = resultSet.getInt(10);
				list.add(ob);

			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Carbean getcarbeanbygoods_id(String goods_id, Integer user_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = getcon();

		try {
			preparedStatement = connection
					.prepareStatement("select id,user_id,goods_id,num from car where goods_id=? and user_id = ?");
			preparedStatement.setInt(1, Integer.parseInt(goods_id));
			preparedStatement.setInt(2, user_id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Carbean carbean = new Carbean();
				carbean.setId(resultSet.getInt(1));
				carbean.setUserd_id(resultSet.getInt(2));

				carbean.setGoods_id(resultSet.getInt(3));

				carbean.setNum(resultSet.getInt(4));

				return carbean;

			}

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

	public void xiugaijilu(String goods_id, Integer id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = getcon();

		try {
			preparedStatement = connection
					.prepareStatement("update car set num=num+1 where goods_id=? and user_id = ?");
			preparedStatement.setInt(1, Integer.parseInt(goods_id));
			preparedStatement.setInt(2, id);
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

	public void addcarbean(String goods_id, Integer id) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = getcon();

		try {
			preparedStatement = connection
					.prepareStatement("insert into car(user_id,goods_id,num) values(?,?,1) ");
			preparedStatement.setInt(1, id);
			preparedStatement.setInt(2, Integer.parseInt(goods_id));
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

	public void jia(String car_id) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = getcon();

		try {
			preparedStatement = connection
					.prepareStatement("update car set num=num+1 where id=? ");
			preparedStatement.setInt(1, Integer.parseInt(car_id));
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

	public int getcarbean_num(String car_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = getcon();
ResultSet resultSet = null;
		try {
			preparedStatement = connection
					.prepareStatement("select num from car where id=? ");
			preparedStatement.setInt(1, Integer.parseInt(car_id));
			resultSet = preparedStatement.executeQuery();
			
			resultSet.next();
			return resultSet.getInt(1);

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

		}		return 0;
	}

	public void jian(String car_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = getcon();

		try {
			preparedStatement = connection
					.prepareStatement("update car set num=num-1 where id=? ");
			preparedStatement.setInt(1, Integer.parseInt(car_id));
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

	public void deletall(Integer id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = getcon();

		try {
			preparedStatement = connection
					.prepareStatement("delete from car where user_id=? ");
			preparedStatement.setInt(1, id);
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

	public void shanchucar(int parseInt) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = getcon();

		try {
			preparedStatement = connection
					.prepareStatement("delete from car where id=? ");
			preparedStatement.setInt(1, parseInt);
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

}
