package com.zrcx.mellit.addr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zrcx.mellit.addr.bean.Addrbean;
import com.zrcx.mellit.base.Conn;

public class Addrdao extends Conn {

	public List<Object[]> getsheng() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = getcon();
		List<Object[]> list = new ArrayList<Object[]>();
		try {
			preparedStatement = connection
					.prepareStatement("select ProvinceID,ProvinceName from province ");

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Object[] obj = new Object[2];
				obj[0] = resultSet.getInt(1);
				obj[1] = resultSet.getString(2);
				list.add(obj);

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

	public List<Object[]> getshi(String sheng_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = getcon();
		List<Object[]> list = new ArrayList<Object[]>();
		try {
			preparedStatement = connection
					.prepareStatement("select CityID,CityName from city where ProvinceID=? ");
			preparedStatement.setString(1, sheng_id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Object[] obj = new Object[2];
				obj[0] = resultSet.getInt(1);
				obj[1] = resultSet.getString(2);
				list.add(obj);

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

	public List<Object[]> getqu(String shi_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = getcon();
		List<Object[]> list = new ArrayList<Object[]>();
		try {
			preparedStatement = connection
					.prepareStatement("select DistrictID,DistrictName from district where CityID=? ");
			preparedStatement.setString(1, shi_id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Object[] obj = new Object[2];
				obj[0] = resultSet.getInt(1);
				obj[1] = resultSet.getString(2);
				list.add(obj);

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

	public String getprovincebyid(Integer province_id) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = getcon();
		List<Object[]> list = new ArrayList<Object[]>();
		try {
			preparedStatement = connection
					.prepareStatement("select ProvinceName from province where ProvinceID=?");
			preparedStatement.setInt(1, province_id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				return resultSet.getString(1);

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

	public String getcitybyid(Integer city_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = getcon();
		List<Object[]> list = new ArrayList<Object[]>();
		try {
			preparedStatement = connection
					.prepareStatement("select CityName from city where CityID=? ");
			preparedStatement.setInt(1, city_id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				return resultSet.getString(1);

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

	public String getdistrictbyid(Integer district_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = getcon();
		List<Object[]> list = new ArrayList<Object[]>();
		try {
			preparedStatement = connection
					.prepareStatement("select DistrictName from district where DistrictID=? ");
			preparedStatement.setInt(1, district_id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				return resultSet.getString(1);

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
		}		return null;
	}

	public void addaddr(Addrbean addrbean) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = getcon();
		try {
			preparedStatement = connection
					.prepareStatement("insert into addr(name,province,city,district,street,postCode,phone,user_id,state) values(?,?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, addrbean.getName());
			preparedStatement.setString(2, addrbean.getProvince());
			preparedStatement.setString(3, addrbean.getCity());
			preparedStatement.setString(4, addrbean.getDistrict());
			preparedStatement.setString(5, addrbean.getStreet());
			preparedStatement.setString(6, addrbean.getPostcode());
			preparedStatement.setString(7, addrbean.getPhone());
			preparedStatement.setInt(8, addrbean.getUser_id());
			preparedStatement.setInt(9, addrbean.getState());
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

	public List<Addrbean> getalladdrbyuserid(Integer id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = getcon();
		List<Addrbean> list = new ArrayList<Addrbean>();
		try {
			preparedStatement = connection
					.prepareStatement("select id,name,province,city,district,street,postCode,phone,user_id,state from addr where user_id=? order by state desc");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
Addrbean addrbean  = new Addrbean();
addrbean.setId(resultSet.getInt(1));
addrbean.setName(resultSet.getString(2));
addrbean.setProvince(resultSet.getString(3));
addrbean.setCity(resultSet.getString(4));
addrbean.setDistrict(resultSet.getString(5));
addrbean.setStreet(resultSet.getString(6));
addrbean.setPostcode(resultSet.getString(7));
addrbean.setPhone(resultSet.getString(8));
addrbean.setUser_id(resultSet.getInt(9));
addrbean.setState(resultSet.getInt(10));

list.add(addrbean);
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
		}					return null;
	}

	public void shanchudizhibyid(String addr_id) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = getcon();
		try {
			preparedStatement = connection
					.prepareStatement("delete from addr where id=?");
			preparedStatement.setString(1, addr_id);
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

	public Addrbean getoneaddrbyaddr_id(String addr_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = getcon();
		ResultSet resultSet = null;
		try {
			preparedStatement = connection
					.prepareStatement("select name,province,city,district,street,postCode,phone,id from addr where id=? ");
			preparedStatement.setString(1, addr_id);
			resultSet =preparedStatement.executeQuery();
			if(resultSet.next()){
				Addrbean addrbean = new Addrbean();
				addrbean.setName(resultSet.getString(1));
				addrbean.setProvince(resultSet.getString(2));
				addrbean.setCity(resultSet.getString(3));
				addrbean.setDistrict(resultSet.getString(4));
				addrbean.setStreet(resultSet.getString(5));
				addrbean.setPostcode(resultSet.getString(6));
				addrbean.setPhone(resultSet.getString(7));
				addrbean.setId(resultSet.getInt(8));
return addrbean;
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
		}		return null;
	}

	public void xiugaidizhi(Addrbean addrbean) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = getcon();
		try {
			preparedStatement = connection
					.prepareStatement("update addr set name=?,province=?,city=?,district=?,street=?,postCode=?,phone=? where id=?");
			preparedStatement.setString(1, addrbean.getName());
			preparedStatement.setString(2, addrbean.getProvince());
			preparedStatement.setString(3, addrbean.getCity());
			preparedStatement.setString(4, addrbean.getDistrict());
			preparedStatement.setString(5, addrbean.getStreet());
			preparedStatement.setString(6, addrbean.getPostcode());
			preparedStatement.setString(7, addrbean.getPhone());
			preparedStatement.setInt(8, addrbean.getId());


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

	public void qudiaomoren() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = getcon();
		try {
			preparedStatement = connection
					.prepareStatement("update addr set state=0 where state=1");
			


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

	public void addmoren(String addr_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = getcon();
		try {
			preparedStatement = connection
					.prepareStatement("update addr set state=1 where id=?");
			preparedStatement.setString(1, addr_id);


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

	public int getaddrcount(Integer id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = getcon();
		ResultSet resultSet = null;
		try {
			preparedStatement = connection
					.prepareStatement("select count(id) from addr where user_id=?");
			preparedStatement.setInt(1, id);


			resultSet =  preparedStatement.executeQuery();
			if(resultSet.next()){
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
		}		return 0;
	}

}
