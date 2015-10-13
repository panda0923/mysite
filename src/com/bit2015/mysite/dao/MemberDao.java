package com.bit2015.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bit2015.mysite.vo.GuestbookVo;
import com.bit2015.mysite.vo.MemberVo;

public class MemberDao {
private Connection getConnection() throws SQLException {
		
		Connection connection = null;
		
		try {
			//1.드라이버 로딩
			Class.forName( "oracle.jdbc.driver.OracleDriver" );
		
			//2.커넥션 만들기(ORACLE DB)
			String dbURL  = "jdbc:oracle:thin:@localhost:1521:xe";
			connection = DriverManager.getConnection( dbURL, "webdb", "webdb" );
			
		} catch( ClassNotFoundException ex ){
			System.out.println( "드라이버 로딩 실패-" + ex );
		} 
		
		return connection;
	}
	public void insert(MemberVo vo){
		try{
			//1.DB커넥션
			Connection conn = null;
			conn= getConnection();
			
			//2.prepare statement
			String sql = 
						"insert into  MEMBER values (member_no_seq.nextval,?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//3.바인딩
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3,vo.getPassword());
			pstmt.setString(4, vo.getGender());
			//4.sql실행
			pstmt.executeUpdate();//insert,delete에는 이거 사용
			
			//5.자원정리
			pstmt.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void delete(){
		
	}
	public MemberVo get(String email,String password){
		MemberVo vo = null;
		try{
			Connection conn = getConnection();
			
			String sql = 
					" select no, name, email" +
					"   from member" +
					"  where email=?"+
					"    and password=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			//pstmt.executeQuery();//select에서는 executeQuery
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				Long no = rs.getLong(1);
				String name =rs.getString(2);
				String email2 = rs.getString(3);
				
				vo = new MemberVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setEmail(email2);
			}
		
			
		}catch(Exception e){
			e.printStackTrace();
		}
		 return vo;
	}
	public MemberVo get(Long no){
		MemberVo vo = null;
		return vo;
	}

	public void update(MemberVo vo){
		try{
			Connection conn =getConnection();
			String sql="UPDATE MEMBER set name=?,EMAIL=?,password=?,GENDER=?where no=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//3.바인딩
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getPassword());
			pstmt.setString(4, vo.getGender());
			pstmt.setLong(5, vo.getNo());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
