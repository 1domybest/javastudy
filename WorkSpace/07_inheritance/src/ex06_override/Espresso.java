package ex06_override;

public class Espresso extends Coffee{

	private int wather;
	public Espresso(String bean,int wather) {
		
		super(bean);
		this.wather = wather;
	}
	//espresso 클래스는 이미 coffee 클래스의 메소드를 사용할수 있다
	//espresso 클래스의 coffee 클래스의 taste() 메소드를 사용하는 것이 적절할까?
	//적절하지 않다. espresso 클래스는 자신의 맛을 표현하기 위해서 새롭게 taste()메소드를 만드는것이 좋습니다.
	@Override
	public void taste() {
		System.out.println(getBean()+"원산지 원두에 물 "+wather+"L 섞으면 맛있습니다.");
	
	}
	
	
	
	
	
	
}
