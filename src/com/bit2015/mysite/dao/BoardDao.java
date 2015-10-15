package com.bit2015.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bit2015.mysite.vo.BoardVo;



public class BoardDao {
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

//1.insert
	public void insert(BoardVo vo){
		try{
			Connection conn=null;
			conn =getConnection();
			
			String sql= "insert INTO BOARD "+
						"values (board_no_seq.nextval,?,?,?,0,SYSDATE)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//3.바인딩
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setLong(3, vo.getMemberNo());
		
		
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();	
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//2.select
	public List<BoardVo> getList() {
		List<BoardVo> list = new ArrayList<BoardVo>();
		try{
			//1. 커넥션 만들기(ORACLE DB)
			Connection connection = getConnection();
			
			//2. Statement 생성
			Statement stmt = connection.createStatement();
			
			//3.

			String sql =
				"   select a.no," +
				"          a.title," +
				"          a.member_no," +
				"          b.name as member_name," +
				"          a.view_cnt," +
				"          to_char(a.reg_date, 'yyyy-mm-dd hh:MM:ss')" +
				"     from board a," +
				"          member b" +
				"    where a.member_no = b.no" +
				" order by a.reg_date desc";
			ResultSet rs = stmt.executeQuery( sql );
			while( rs.next() ){
				
				Long no = rs.getLong( 1 );
				String title = rs.getString( 2 );
				Long memberNo = rs.getLong( 3 );
				String memberName = rs.getString( 4 );
				int viewCount = rs.getInt( 5 );
				String regDate = rs.getString( 6 );
				
				BoardVo vo = new BoardVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setMemberNo(memberNo);
				vo.setMemberName(memberName);
				vo.setViewCount(viewCount);
				vo.setRegDate(regDate);
				
				list.add( vo );
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return list;
	}
	
	public BoardVo get( Long no ) {
		BoardVo vo = null;
		try{
			Connection conn = getConnection();
			
			String sql= "select no,title,content,member_no "+
			"from board where no=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//3.바인딩
			pstmt.setLong(1,no);
			
			//4.sql실행
			ResultSet rs= pstmt.executeQuery();
			if(rs.next()){
				vo = new BoardVo();
				vo.setNo(rs.getLong(1));
				vo.setTitle(rs.getString(2));
				vo.setContent(rs.getString(3));
				vo.setMemberNo(rs.getLong(4));
				
			}
		}catch(Exception e){
			
		}
		
		return vo;
	}
	public void increaseViewCount( Long no ) {
		
		try{
			Connection conn = getConnection();
			String sql = 
					" update board" +
					"    set view_cnt = view_cnt + 1" +		
					"  where no=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, no);
			
			pstmt.executeUpdate();
		
		}catch( SQLException ex ) {
			System.out.println( "SQL Error:" + ex );
		}
		
	}
	
//3.delect
	public void delete( BoardVo vo ) {
		try{
			Connection conn = getConnection();
			String sql = "delete from BOARD WHERE no=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, vo.getNo());
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
			
		}catch( Exception ex ) {
			System.out.println( "SQL Error:" + ex );
		}
	}
//4.update
	public void update(BoardVo vo){
		
		try{
			Connection conn = getConnection();
			String sql = "update BOARD "
					+"SET  title=?"
					+"content =?"
					+"where no=?";
			PreparedStatement pstmt =conn.prepareStatement(sql);
			
			//3.바인딩
			pstmt.setString(1,vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setLong(3, vo.getMemberNo());
			pstmt.setInt(4, vo.getViewCount());
			pstmt.setString(5,vo.getRegDate());
			pstmt.setLong(6, vo.getNo());
			
			pstmt.executeUpdate();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
