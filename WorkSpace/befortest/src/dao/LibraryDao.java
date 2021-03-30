package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.LibraryDto;

public class LibraryDao {
	private Connection con;
	private ResultSet rs ;
	private PreparedStatement ps ;
	private String sql;
	private int result;
	
	public LibraryDao() {}
	private static LibraryDao library = new LibraryDao();
	
	public static LibraryDao getInstance() {
		
		return library;
	}
	
	public Connection getConntect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user ="spring";
			String password ="1111";
			
			con = DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return con;
	}
	
	public void close(Connection con,PreparedStatement ps,ResultSet rs) {
		try {
			if(con!=null) {con.close();}
			if(rs!=null) {rs.close();}
			if(ps!=null) {ps.close();}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int MaxNo() {
		int no = 0;
		try {
			con = getConntect();
			sql = "SELECT MAX(no) FROM library";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			no = rs.getInt(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps, rs);
		}
		return no;
	}
	
	public int addBook(LibraryDto dto) {
		try {
			con = getConntect();
			sql ="INSERT INTO staff VALUES(?,?,?,SYSDATE)";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, dto.getBookNo());
			ps.setString(2, dto.getBookTitle());
			ps.setString(3, dto.getBookWriter());
			
			result =ps.executeUpdate();
			
		
		} catch (Exception e) {
			e.printStackTrace();
			}finally {
				close(con, ps, null);
			}
		return result;
		
	}
	
	public LibraryDto selectBook(int no) {
		LibraryDto dto =null;
		try {
			
			con = getConntect();
			sql ="SELECT * FROM libaray WHERE no = ?";
			ps =con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new LibraryDto();
				dto.setBookNo(rs.getInt(1));
				dto.setBookTitle(rs.getNString(2));
				dto.setBookWriter(rs.getNString(3));
				dto.setPubDate(rs.getDate(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps, rs);
		}
		return dto;
	}
}
