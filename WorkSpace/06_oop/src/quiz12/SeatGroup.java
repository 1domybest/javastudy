package quiz12;

import java.util.Scanner;

public class SeatGroup {
	private char seatType; //'S','R','A','B'
	private int charge; //요금
	private Seat[] seats;
	private Scanner sc = new Scanner(System.in);
	
	
	public Seat[] getSeats() {
		return seats;
	}


	public void setSeats(Seat[] seats) {
		this.seats = seats;
	}


	//생성자
	public SeatGroup(char seatType,int seatCount, int charge ) {
		this.seatType = seatType;
		this.charge = charge;
		this.seats = new Seat[seatCount]; //배열 생성                  
		//배열에 실제 시트를 생성
		for (int i = 0; i < seats.length; i++) {
			seats[i] = new Seat();
		}
	}
	

	
	
	
}
