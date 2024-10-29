package com.emp.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repository {
	static Repository repo;
	Connection con ;
	private Repository() {
		String dbUser = "root";
		String dbPassword = "Vengat@12345";
		String url = "jdbc:mysql://localhost:3306/Spotify";
		con = DriverManager.getConnection(url,dbUser,dbPassword);
	}
	public static Repository getInstance() {
		if(repo == null) repo = new Repository();
		return repo;
	}
	public void addEmp(Emp emp) {
		String query = "insert into emp values(?,?,?,?,?);";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1,emp.getName());
		pst.setInt(2,emp.getAge());
		pst.setString(3,emp.getDes());
		pst.setString(4,emp.getDept());
		pst.setString(5,emp.getMgr());
		pst.executeUpdate();
		
	}
	public List<Emp> getEmpList() {
		List<Emp> list = new ArrayList<>();
		String query = "select * from emp";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			list.add(new Emp(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5)));
		}
		return list;
	}
}
