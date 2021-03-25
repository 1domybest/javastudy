package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.StaffDto;

//데이터와 직접 통신을 받는 영역

//DAO : Database Access Object
//DB 의 CRUD를 처리하는 메소드를 포함하고 있습니다.

public class StaffDao  {
	private Connection con ;
	private PreparedStatement ps ;
	private ResultSet rs ;
	private int result;
	private String sql;
	
	//생성자
	
	//싱글톤 패턴
	//1. 프로그램 전체에서 오직 하나의 StaffDao 만 생성할수 있습니다.
	//2. 원리(싱글톤패턴)
	//	1)외부에서 new StffDao()가 불가능하도록 설계합니다
	// 	2)내부에서 new StaffDao()를 실행하고 생성된 1개의 인스턴스를 반환하는 메소드를 만듭니다.
	
	//3. getInstance() 메소드 호출 방법
		//1. 객체(인스턴스) : private StaffDao(){} 때문에 외부에서는 객체 생성이 불가능 하다.
			//:private static StaffDao staffDao = new StaffDao(); private이여서 호출불가능하여 안심해도 좋다.
		//2. 클래스 : 클래스 메소드로 바꿔야한다.
		
	
	private StaffDao() {}
	
	private static StaffDao staffDao = new StaffDao();
	
	public static  StaffDao getInstance() {
		return staffDao;
	}
	
	
	
	//메소드
	
	/***** 1, 접속 *****/
	public Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "spring";
		String password = "1111";
		Connection con = DriverManager.getConnection(url,user,password);
		return con;
	}
	
	
	/***** 2. 접속 해제*****/
	public void close(Connection con,PreparedStatement ps , ResultSet rs) {
		try {
			if(rs != null) {rs.close();}
			if(ps != null) {ps.close();}
			if(con != null) {con.close();}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int selectMaxNo() {
		int no =0;
		try {
			con = getConnection();
			sql ="SELECT MAX(no) FROM staff";
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
	
	/***** 3.staff 추가하기*****/
	//public int insertStaff(int no, String name, String department, Date hireDate) //
	public int insertStaff(StaffDto staffdto) {
		try {
			con = getConnection(); //접속은 메소드 마다 열고 닫는것이 좋다.
			sql= "INSERT INTO staff(no,name,department,hireDate) VALUES(?,?,?,SYSDATE)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, staffdto.getNo());
			ps.setString(2, staffdto.getName());
			ps.setString(3, staffdto.getDepartment());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con,ps,null);
		}
		return result; //삽입되면 result = 1 , 실패하면 result = 0
	}
	
	/***** 4.staff 수정하기*****/
	public int updateStaff(StaffDto staffdto) {
		
		try {
			con = getConnection();
			sql = "UPDATE staff SET name =? , department = ? WHERE no = ?";
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
	/***** 4.staff 삭제하기*****/
	public int deleteStaff(StaffDto staffdto) {
		try {
			con = getConnection();
			sql = "DELETE FROM staff WHERE no = ? ";
			ps = con.prepareStatement(sql);
			ps.setInt(1,staffdto.getNo());
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps, null);
			
		}
		return result;
	}
	/***** 4.staff 조회하기*****/
	public StaffDto searchStaff(int no) {
		StaffDto staffdto= null;
		try {
			con = getConnection();
			sql = "SELECT * FROM staff WHERE no = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			if(rs.next()) {
				staffdto = new StaffDto();
				staffdto.setNo(rs.getInt(1));
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
	
	/***** 4.staff 전체 조회하기*****/
	public List<StaffDto> FullSearch() {
		List<StaffDto> staffList = new ArrayList<StaffDto>();
		try {
			con = getConnection();
			sql = "SELECT * FROM staff";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				StaffDto staffdto = new StaffDto();
				staffdto.setNo(rs.getInt(1));
				staffdto.setName(rs.getNString(2));
				staffdto.setDepartment(rs.getString(3));
				staffdto.setHireDate(rs.getDate(4));
				
				staffList.add(staffdto);
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps, rs);
		}
		return staffList;
	}
	
	
}




























