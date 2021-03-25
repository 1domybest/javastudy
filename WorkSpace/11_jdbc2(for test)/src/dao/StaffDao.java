package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.StaffDto;

public class StaffDao {
	private Connection con;
	private PreparedStatement ps ;
	private ResultSet rs ;
	String sql ;
	
	
	public StaffDao() {}
	
	private static StaffDao staffdao = new StaffDao();
	public static StaffDao getInstance() {
		
		return staffdao;
	}
	
	//========1.접속===========
	public Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user = "spring";
		String password = "1111";
		Connection con = DriverManager.getConnection(url,user,password);
		
		return con;
	}
	
	//========1.접속 해체===========
	public void close(Connection con,PreparedStatement ps,ResultSet rs) {
		try {
			if(con!= null) {con.close();}
			if(rs!= null) {rs.close();}
			if(ps!= null) {ps.close();}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//========1.최대 no===========
	public int MaxNo() {
		int no = 0;
		
		try {
			con = getConnection();
			sql = "SELECT MAX(no) FROM staff";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				no = rs.getInt(1);				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps, rs);
		}
		return no;
	}
	
	//========1.추가하기===========
	public int addStaff(StaffDto staffdto) {
		int result = 0;
		try {
			con = getConnection();
			sql = "INSERT INTO staff(no,name,department,hireDate) VALUES(?,?,?,SYSDATE)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, staffdto.getNo());
			ps.setString(2, staffdto.getName());
			ps.setString(3, staffdto.getDepartment());
		
		
			 result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps, null);
		}
		return result;
	}
	
	
		
	
	//========1.수정하기===========
	
	public int updateStaff(StaffDto staffdto) {
		int result =0 ;
		try {
			con = getConnection();
			sql = "UPDATE staff SET name = ? , department = ? WHERE no = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, staffdto.getName());
			ps.setString(2, staffdto.getDepartment());
			ps.setInt(3, staffdto.getNo());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps, null);
		}
		return result;
	}
	//========4.삭제하기===========
	public int deleteStaff(int no) {
		int result =0 ;
		try {
			con = getConnection();
			sql = "DELETE FROM staff WHERE no =?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			
			result = ps.executeUpdate();
				
		} catch (Exception e) {
		e.printStackTrace();
		}finally {
		close(con, ps, rs);
		}
		return result;
	}
	
	
	
	//========1.검색하기===========
	public StaffDto searchStaff(int no) {
		StaffDto staffdto =null;
		try {
			con = getConnection();
			sql = "SELECT * FROM staff WHERE no =? ";
			ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				staffdto =new StaffDto();
				staffdto.setNo(no);
				staffdto.setName(rs.getString(2));
				staffdto.setDepartment(rs.getString(3));
				staffdto.setHireDate(rs.getDate(4));
			}
			
		} catch (Exception e) {
				e.printStackTrace();
		}finally {
			close(con, ps, rs);
		}
		return staffdto;
	}
	
		
	
	//========1.전체조회===========
	public List<StaffDto> staffList(){
		List<StaffDto> list = new ArrayList<StaffDto>();
	try {
		con = getConnection();
		sql = "SELECT * FROM staff";
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			StaffDto staffdto = new StaffDto();
			staffdto.setNo(rs.getInt(1));
			staffdto.setName(rs.getString(2));
			staffdto.setDepartment(rs.getString(3));
			staffdto.setHireDate(rs.getDate(4));
			
			list.add(staffdto);
		}
		
		
	} catch (Exception e) {
			e.printStackTrace();
	}finally {
			close(con, ps, rs);
	}
	return list;
		
	}

	
}
