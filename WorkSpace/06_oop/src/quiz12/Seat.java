package quiz12;

public class Seat {
	
	private String name;
	//1.예매자 이름 확인
	public String getName() {
		return name;
	}
	//2.예매할때 사용
	public void setName(String name) {
		this.name = name;
	}
	//3. 예매 취소
	public void cancel() {
		this.name = null;
	}
	//4. 예매 여부 확인
	//1) 예매가 된 좌석 : false(예매 불가)
	//2) 비어있는 좌석 : true(예매 가능)
	public boolean check() {
		
		
		return (name == null);
	}
	//5.좌석 확인
	public void info() {
		if(name == null) {
			System.out.print("가능");
		}else {
			System.out.print(name.charAt(0)+"*"+(name.length() > 2 ? name.charAt(name.length() -1) : ""));
		}
	}
	
}
