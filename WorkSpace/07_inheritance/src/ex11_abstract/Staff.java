package ex11_abstract;



/*
 * 추상메소드
 * 1) 본문이 없는 메소드 입니다
 * 2) 메소드를 정의할때 abstract 키워드를 앞에 추가합니다.
 * 3) 중괄호({})를 빼고 세미콜론을 붙입니다.
 * 
 * 
 * 추상클래스
 * 1)추상 메소드가 1개이상 포함된 클래스 입니다.
 * 2)클래스 정의 앞에 abstract 키워드를 추가합니다.
 */



public abstract class Staff {
	private String name;

	public Staff(String name) {
		super();
		this.name = name;
	}
	
	public void info() {
		System.out.println("직원명: "+name);
		}

	
	/**
	 * 반환할수 있는 값은 없습니다
	 * 본문이 없는 getpay메소드를 만듭니다
	 * 
	 */
	public abstract int getPay();
	}
