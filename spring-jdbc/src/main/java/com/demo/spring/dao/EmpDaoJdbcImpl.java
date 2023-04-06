package com.demo.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Emp;
@Repository
public class EmpDaoJdbcImpl implements EmpDao{
	@Autowired
	private JdbcTemplate jt;

	@Override
	public String save(Emp e) {
		String INSERT_SQL = "insert into emp(empno,name,address,salary) values(?,?,?,?)";
		
		int count = jt.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement pst = con.prepareStatement(INSERT_SQL);
				pst.setInt(1, e.getEmpid());
				pst.setString(2, e.getEmpName());
				pst.setString(3, e.getCity());
				pst.setDouble(4, e.getSalary());
				return pst;
			}
		});
		if(count == 1) {
			return "saved";
		}
		return null;
	}

	@Override
	public List<Emp> listAll() {
		// TODO Auto-generated method stub
		List<Emp> empList = jt.query("select * from emp", new RowMapper<Emp>() {

			@Override
			public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return new Emp(rs.getInt("EMPNO"), rs.getString("NAME"), rs.getString("ADDRESS"), rs.getDouble("SALARY"));
			}
		});
		return empList;
	}

	@Override
	public Emp findById(int id) {

		// TODO Auto-generated method stub
		//Emp emp = jt.queryForObject("select * from emp where empno="+id, new RowMapper<Emp>() {
	List<Emp> empList = jt.query(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement pst = con.prepareStatement("select * from emp where empno=?");
				pst.setInt(1, id);
				return pst;
			
			}
		}, new RowMapper<Emp>() {

			@Override
			public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return new Emp(rs.getInt("EMPNO"), rs.getString("NAME"), rs.getString("ADDRESS"), rs.getDouble("SALARY"));
			}
		});
		return empList.get(0);
		
	
	}

	
}
