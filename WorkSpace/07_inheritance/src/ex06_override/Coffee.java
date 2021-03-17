package ex06_override;

public class Coffee {
	//field
	private String bean;

	public Coffee(String bean) {
		this.bean = bean;
	}
	
	
	public String getBean() {
		return bean;
	}


	public void setBean(String bean) {
		this.bean = bean;
	}


	public void taste() {
		System.out.println(bean+"원산지 원두는 맛이 없습니다.");
	}
}
