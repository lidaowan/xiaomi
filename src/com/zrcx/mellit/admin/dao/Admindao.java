package com.zrcx.mellit.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.storeconfig.ConnectorStoreAppender;

import com.zrcx.mellit.admin.bean.Adminbean;
import com.zrcx.mellit.base.Conn;
import com.zrcx.mellit.base.Goodsclassbean;
import com.zrcx.mellit.goods.bean.Goodbean;
import com.zrcx.mellit.user.bean.Userbean;

public class Admindao extends Conn {

	public Adminbean findadmin(String em, String pwd) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = getcon();
		try {
			preparedStatement = connection
					.prepareStatement("select id,email,image,pwd from admin where email=? and pwd=?");
			preparedStatement.setString(1, em);
			preparedStatement.setString(2, pwd);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Adminbean adminbean = new Adminbean();
				adminbean.setId(resultSet.getInt(1));
				adminbean.setEmail(resultSet.getString(2));
				adminbean.setImage(resultSet.getString(3));
				adminbean.setPwd(resultSet.getString(4));
				return adminbean;
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

	public int getnum(String adminemail2) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = getcon();
		try {
			preparedStatement = connection
					.prepareStatement("select count(id) from admin where email like ?");
			preparedStatement.setString(1, adminemail2);

			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {

				return resultSet.getInt(1);
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
		return 0;
	}

	public List<Adminbean> getadmins(String adminemail2, int begin, int pageSize) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = getcon();
		List<Adminbean> list = new ArrayList<Adminbean>();
		try {
			preparedStatement = connection
					.prepareStatement("select id,email,image,pwd from admin where email like ? limit ?,?");
			preparedStatement.setString(1, adminemail2);
			preparedStatement.setInt(2, begin);
			preparedStatement.setInt(3, pageSize);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Adminbean adminbean = new Adminbean();
				adminbean.setId(resultSet.getInt(1));
				adminbean.setEmail(resultSet.getString(2));
				adminbean.setImage(resultSet.getString(3));
				adminbean.setPwd(resultSet.getString(4));
				list.add(adminbean);
			}
			return list;
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

	public void deleteadmin(int adminid) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = getcon();

		try {
			preparedStatement = connection
					.prepareStatement("delete from admin where id=?");
			preparedStatement.setInt(1, adminid);
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

	public void addadmin(Adminbean adminbean) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = getcon();

		try {
			preparedStatement = connection
					.prepareStatement("insert into admin(email,image,pwd) values(?,?,?)");
			preparedStatement.setString(1, adminbean.getEmail());
			preparedStatement.setString(2, adminbean.getImage());
			preparedStatement.setString(3, adminbean.getPwd());
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

	public Adminbean findoneadmin(int adminid) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = getcon();
		Adminbean adminbean = new Adminbean();
		ResultSet resultSet = null;
		try {
			preparedStatement = connection
					.prepareStatement("select id,email,image,pwd from admin where id=?");
			preparedStatement.setInt(1, adminid);

			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			adminbean.setEmail(resultSet.getString(2));
			adminbean.setId(resultSet.getInt(1));
			adminbean.setImage(resultSet.getString(3));
			adminbean.setPwd(resultSet.getString(4));
			return adminbean;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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

	public void updataadmin1(String pwd, int id) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = getcon();
		Adminbean adminbean = new Adminbean();
		ResultSet resultSet = null;
		try {
			preparedStatement = connection
					.prepareStatement("update admin set pwd=? where id=?");
			preparedStatement.setString(1, pwd);
			preparedStatement.setInt(2, id);

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

	public void updataadmin2(String pwd, int id, String filename) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = getcon();
		Adminbean adminbean = new Adminbean();
		ResultSet resultSet = null;
		try {
			preparedStatement = connection
					.prepareStatement("update admin set pwd=?,image=? where id=?");
			preparedStatement.setString(1, pwd);
			preparedStatement.setString(2, filename);
			preparedStatement.setInt(3, id);

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

	public void adduser(String phone, String pwd) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = getcon();

		try {
			preparedStatement = connection
					.prepareStatement("insert into user(phone,pwd) values(?,?)");
			preparedStatement.setString(1, phone);
			preparedStatement.setString(2, pwd);
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

	public int getusercount(String cphone) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = getcon();
		ResultSet resultSet = null;
		try {
			preparedStatement = connection
					.prepareStatement("select count(id) from user where phone like ?");
			preparedStatement.setString(1, cphone);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			return resultSet.getInt(1);

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
		return 0;
	}

	public List<Userbean> showusers(String cphone, int begin, int pageSize) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = getcon();
		List<Userbean> list = new ArrayList<Userbean>();
		try {
			preparedStatement = connection
					.prepareStatement("select id,phone,pwd from user where phone like ? limit ?,?");
			preparedStatement.setString(1, cphone);
			preparedStatement.setInt(2, begin);
			preparedStatement.setInt(3, pageSize);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Userbean userbean = new Userbean();
				userbean.setId(resultSet.getInt(1));
				userbean.setPhone(resultSet.getString(2));
				userbean.setPwd(resultSet.getString(3));
				list.add(userbean);
			}
			return list;
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

	public void deluser(int userid) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = getcon();

		try {
			preparedStatement = connection
					.prepareStatement("delete from user where id=?");
			preparedStatement.setInt(1, userid);
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

	public Userbean findoneuser(int userid) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = getcon();
		Userbean userbean = new Userbean();
		ResultSet resultSet = null;
		try {
			preparedStatement = connection
					.prepareStatement("select id,phone,pwd from user where id=?");
			preparedStatement.setInt(1, userid);

			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			userbean.setId(resultSet.getInt(1));
			userbean.setPhone(resultSet.getString(2));
			userbean.setPwd(resultSet.getString(3));
			return userbean;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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

	public void xiugaiuser(int userid, String pwd) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = getcon();
		Adminbean adminbean = new Adminbean();
		ResultSet resultSet = null;
		try {
			preparedStatement = connection
					.prepareStatement("update user set pwd=? where id=?");
			preparedStatement.setString(1, pwd);
			preparedStatement.setInt(2, userid);

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

	public int getgoodscount(String cgoodsname) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = getcon();
		try {
			preparedStatement = connection
					.prepareStatement("select count(id) from goods where name like ?");
			preparedStatement.setString(1, cgoodsname);

			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {

				return resultSet.getInt(1);
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
		return 0;
	}

	public List<Goodbean> getgoods(String cgoodsname, int begin, int pageSize) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = getcon();
		List<Goodbean> list = new ArrayList<Goodbean>();
		try {
			preparedStatement = connection
					.prepareStatement("select g.id,g.name,g.image,g.price,g.describes,g.gclass,gc.name from goods g left join gclass gc on g.gclass=gc.id where g.name like ? order by id desc limit ?,?");
			preparedStatement.setString(1, cgoodsname);
			preparedStatement.setInt(2, begin);
			preparedStatement.setInt(3, pageSize);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Goodbean goodbean = new Goodbean();
				goodbean.setId(resultSet.getInt(1));
				goodbean.setName(resultSet.getString(2));
				goodbean.setImage(resultSet.getString(3));
				goodbean.setPrice(resultSet.getBigDecimal(4));
				goodbean.setDescribes(resultSet.getString(5));
				goodbean.setGclass(resultSet.getInt(6));
				goodbean.setGclassname(resultSet.getString(7));
				list.add(goodbean);
			}
			return list;
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

	public List<Goodsclassbean> checkgoodsclass() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = getcon();
		List<Goodsclassbean> list = new ArrayList<Goodsclassbean>();
		try {
			preparedStatement = connection
					.prepareStatement("select id,name from gclass");
			
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
			Goodsclassbean goodsclassbean = new Goodsclassbean();
			goodsclassbean.setId(resultSet.getInt(1));
			goodsclassbean.setName(resultSet.getString(2));
				
				list.add(goodsclassbean);
			}
			return list;
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

	public void addgood(Goodbean goodbean) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = getcon();

		try {
			preparedStatement = connection
					.prepareStatement("insert into goods(name,image,price,describes,gclass) values(?,?,?,?,?)");
			preparedStatement.setString(1, goodbean.getName());
			preparedStatement.setString(2, goodbean.getImage());

			preparedStatement.setBigDecimal(3, goodbean.getPrice());
			preparedStatement.setString(4, goodbean.getDescribes());
			preparedStatement.setInt(5, goodbean.getGclass());

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

	public int getclasscount(String cclassname) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = getcon();
		try {
			preparedStatement = connection
					.prepareStatement("select count(id) from gclass where name like ?");
			preparedStatement.setString(1, cclassname);

			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {

				return resultSet.getInt(1);
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
		return 0;
	}


public List<Goodsclassbean> checkgoodsclass2(String classname,int begin,int size) {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	connection = getcon();
	List<Goodsclassbean> list = new ArrayList<Goodsclassbean>();
	try {
		preparedStatement = connection
				.prepareStatement("select id,name from gclass where name like ? limit ?,?");
		preparedStatement.setString(1, classname);
		preparedStatement.setInt(2, begin);
		preparedStatement.setInt(3, size);
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
		Goodsclassbean goodsclassbean = new Goodsclassbean();
		goodsclassbean.setId(resultSet.getInt(1));
		goodsclassbean.setName(resultSet.getString(2));
			
			list.add(goodsclassbean);
		}
		return list;
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

public List<Goodbean> getgoodsbyid(String classid) {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	connection = getcon();
	List<Goodbean> list = new ArrayList<Goodbean>();
	try {
		preparedStatement = connection
				.prepareStatement("select id,name,image,price,describes,gclass from goods where gclass=?");
		preparedStatement.setString(1, classid);
		
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
		Goodbean goodbean = new Goodbean();
		goodbean.setId(resultSet.getInt(1));
		goodbean.setName(resultSet.getString(2));
		goodbean.setImage(resultSet.getString(3));
		goodbean.setPrice(resultSet.getBigDecimal(4));
		goodbean.setDescribes(resultSet.getString(5));
		goodbean.setGclass(resultSet.getInt(6));

			
			list.add(goodbean);
		}
		return list;
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

public Goodbean getgoodsbygoods_id(Integer goods_id) {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	connection = getcon();
	try {
		preparedStatement = connection
				.prepareStatement("select id,name,image,price,describes,gclass from goods where id=?");
		preparedStatement.setInt(1, goods_id);
		
		resultSet = preparedStatement.executeQuery();
		if(resultSet.next()) {
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
	}	return null;
}

public void shanchugoods(Integer goods_id) {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	connection = getcon();
	try {
		preparedStatement = connection
				.prepareStatement("delete from goods where id=?");
		preparedStatement.setInt(1, goods_id);
		
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
}}
}
