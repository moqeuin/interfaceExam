package interfaceExam;

public class InterfaceExam {

	public static void main(String[] args) {
		
		CloverCard cc = new CloverCard();
		
		// 인터페이스를 구현한 클래스를 인터페이스 참조변수로 참조할 수 있으며 형변환은 생략가능하다.
		PlayingCard card = cc; 
	}
}

interface PlayingCard{
	
	// 멤버변수와 멤버메서드 구현 규칙
	
	public static final int number = 0; // 인터페이스의 변수는 무조건 public static final이 붙는다. 생략가능
	static final int number2 = 0; // public은 컴파일러가 자동으로 추가한다.
	final int number3 = 0; // public static은 컴파일러가 자동으로 추가한다.
	int number4 = 0; // public static final은 컴파일러가 자동으로 추가한다.
	
	public abstract String getCardNumber(); // 인터페이스의 메서드는 무조건 public abstract이 붙는다. 생략가능
	String getCardImage(); // public abstract는 컴파일러가 자동으로 추가한다.
	
	
	// jdk 1.8이후로는 static 메서드와 디폴트메서드를 구현가능하다.
	static void method() {} //static 메서드
	public default void getCardDek() {} // 디폴트메서드 public은 생략가능하고 {}은 구현해야한다
}

interface PlayCard2{}

// extends == 상속, 다중상속이 가능하다
interface subCard extends PlayingCard, PlayCard2{
	
	
	// 밑에 메서드들은 해당 상속받은 인터페이스의 메서드를 상속받은 것이며 굳이 명시해주지 않아도 된다.
	@Override
	default String getCardImage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	default String getCardNumber() {
		// TODO Auto-generated method stub
		return null;
	}
}

// implements == 구현
class CloverCard implements PlayingCard{
	
	// 추상메서드를 구현할 때 public접근지정자를 꼭 명시해야한다.
	public String getCardNumber() {
		System.out.println("클로버카드");
		return "클로버카드"; 
			
	}
	public String getCardImage() {
		return "킹 이미지";
	}
	
	// 반환타입이 인터페이스이면 이를 구현한 클래스의 인스턴스를 반환한다는 의미이다.
	// 인터페이스는 인스턴스를 생성할 수 없으니 당연히 이를 구현한 클래스의 인스턴스를 반환할 수 밖에 없다.
	PlayingCard method() {
		
		CloverCard cc = new CloverCard();
		return cc;
	}
	
	// 인터페이스 매개변수로 구현한 클래스의 인스턴스를 참조할 수 있다.
	void changeCard(PlayingCard card) {
		
		// 인터페이스 참조변수로 자식클래스의 인터페이스를 참조하면 자식의 멤버를 사용할 수 없으니 
		// 자식 참조변수로 다시 참조해서 사용한다.
		if(card instanceof CloverCard) {
			
			CloverCard cc2 = (CloverCard)card;
		}
	}
}