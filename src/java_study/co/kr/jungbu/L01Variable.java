package java_study.co.kr.jungbu;

import java.util.ArrayList;

// class 이름 규칙 : 파스칼 표기법(이름 표기할때 사용), 숫자로 시작하면 안됨

public class L01Variable extends Object{
	// 메소드 이름 규칙 : 카멜표기법 사용, 숫자로 시작하면 안됨
	// public void 11print() {}
	// main 메소드 규칙 : public(어디서든 접근 가능), static(정적인 jvm(main)<jre 스택에서 참조됨), void(반환되는게 없음), args(main이 실행될 때 지정되는 기본값)
	public static void main(String[] args) { // 파라미터(매개변수)
		
		for(String a:args) { // foreach or 향상된 for
			System.out.println(a);
		}
		String [] arr= {"a", "b", "c", "d"}; // Array
		System.out.println(arr.length);
		System.out.println(arr.toString()); //Object.toString() : 객체의 주소(객체에 대한 정보를 재정의 하기를 기대하는 함수)
		//java.lang.Object : 모든 타입의 부모, 모든 객체의 부모(모든 타입이 객체가 될 수 있는 정보를 포함 => 클래스의 생성자를 new 연산자로 호출해서 객체를 생성할 수 있게 해준다.)
		ArrayList<String> list=new ArrayList<String>();// List 배열
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		System.out.println(list.toString());
		System.out.println(list.size());
		System.out.println(list.contains("c")); //Object.toString > List.toString() : 객체의 설명으로 재정의
		
		L01Variable l01Variable=new L01Variable();
		System.out.println(l01Variable); // toString은 생략 가능
		System.out.println(l01Variable.toString());
		//@Override: 부모의 필드를 재정의 하는 것을 오버라이드 (다형성 : 한개의 이름으로 여러가지의 역할)
		//자식은 부모의 모든 필드를 물려 받지만 제정의 된 필드가 우선 순위를 가진다.
		//오버로드 : 메소드 이름이 같지만 매개변수가 다른것 (다형성 : 한개의 이름으로 여러가지의 역할)
		//타입의 다형성 : 한개의 객체가 여러 타입에 참조 가능(다형성)
		
		String hello = "안녕";
		Object o=hello; // 변수 o는 Object 타입의 객체만 참조 가능, 부모로 Object인 객체를 참조(타입의 다향성 => 형변환)
		
		// 0 (전기적 신호 있음) or 1 (전기적 신호 없음)
		// 2진수와 16진수 -> 1byte(8bit)
		// - , + (부호비트) 7bit로 2진수 표기 => 수는 약속
		
		
		//부동소수점으로 표기하는 실수
		//0.005(고정소수점 표기) => 5.0 * 10-3 (부동소수점 표기)
		// +(-) : 부호비트
		// 5 : 가수부 => 첫번째, 세번째 전기적 신호
		// -3 : 지수부 => 가수부의 부호비트에 정기적 신호, 첫번째 두번째 전기적 신호
		
		
		
		byte b; // 1byte(8bit)로 참조할 수 있는 정수
		short s; // 2byte로 참조 할 수 있는 정수
		// 변수 i가 선언(참조할 객체의 타입을 명시)
		int i; // 4byte로 참조할 수 있는 정수
		long l; // 8byte로 참조할 수 있는 정수
		char c; // 문자표(아스키코드, 유니코드)의 번호를 참조
		
		// 실수를 참조하는 타입
		float f; //4byte로 표기하는 실수 float 0.000314 => 3.14 * 10-4 (부동소수)
		double d; //8byte로 표기하는 실수
		System.out.println(13.33); //double
		System.out.println(13); //int
		i=320000000*320000000;
		System.out.println("음음" + i); // 
		i=2147483647+1;
		System.out.println("2147483647+1" + i); //정수(기본타입)는 표현할 수 있는 수보다 큰 수를 참조하면 가장 작은 수부터 나머지를 더한다.
		
		l=9223372036854775807L + 1;
		System.out.println("9223372036854775807L+1" + l);
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		f=13; // 13.0
		System.out.println(f);
		f=13.123123123123123123123123f; // 가수부로 표현할수 없는 부분은 버림
		System.out.println(f);
		f=13123123123123123123123123f; //1.3123123E25 // 10의 25승
		System.out.println(f);
		
		//float 지수부로 표현할 수 없는 수를 참조할 수 없다.
		//float 로 참조하기에 큰 변수는 Infinity를 반환
		
		d=13123123123123123123123123.0*13123123123123123123123123.0;
		System.out.println(d);
		
		d=13.123123123123123123123123;
		System.out.println(d);
		
		//javaScript의 Number는 java double과 같다
		
		boolean bo = true; // 참 1, 거짓 0 => 1bit data => java에선 8bit 사용(메모리를 1byte로 구성하기 때문에)
		
		
		// 상수
		final int I = 10; // 다른 값을 대입을 못함. (기본형 data를 값이라 부른다. 객체라 불러도 큰 문제는 없으나 객체를 참조형 data로 구분하는 사람들이 있음)
//		I=20;
		System.out.println(I);
		
		System.out.println(I==20);

		Integer obj_I=new Integer(20); //java는 기본형을 참조형으로 선언하는 것을 권장하지 않음
		
		System.out.println(I==obj_I); // false(x) => true
		
		String objStr=new String("안녕");
		String literalStr="안녕";
		String literalStr2="안녕";
		
		System.out.println(objStr==literalStr); // false
		System.out.println(literalStr==literalStr2); // true  문자열은 참조형 data(객체)는 동등비교를 할수가 없다.
		
		Object obj=new Object();
		Object obj2=new Object();
		System.out.println(obj==obj2);
		
		// == 동등비교가 비교하는 것
		// 1. 객체가 같은지 비교 (참조형은 선언 할때마다 새로운 객체를 만들기 때문에 무조건 false)
		// 2. 값이 같은지 비교(값은 기본형 => 수(값) => 수(값)가 같은지)
		
		System.out.println(20==20.0); // 값을 비교
		System.out.println(new String("안녕")==new String("안녕")); // 참조형은 주소를 비교(완전히 같은 객체인지)
		System.out.println("안녕"=="안녕"); //true 
		//참조형중에 String만 예외 : 문자열을 리터럴 선언시 기본형처럼 새로운 데이터를 만들지 않고 기존의 데이터를 참조. 리터럴하게 선언한 두 문자열은 완전히 같은 객체다.
		
		//참조형은 비교연산 하는 방법 : Object.equals(obj) 서로 다른 두 객체가 같으려면 필드가 완전히 같으면 됨(주관적으로 필드의 범위를 지정) => 재정의해야 가능
		//String은 equals를 재정의 하고 있다.
		
		//리터럴하게 선언된 문자열도 참조형 데이터이다. 
		//문자열의 (==)동등비교 권장 안함
		//참조형을 동등비교 할수 있나요? 안됩니다. =>왜 안되나요? 문자열은 비교하던데??
		//주소를 비교, 리터럴하게 하면 비교는 가능하다
		
		System.out.println(new String("안녕").equals(new String("안녕")));
		
	}
	
	public void print() {}
	public void print(int i) {}
	public void print(String s) {}
	public void print(String s , String s2) {}
	public void print(double d) {}
	public void print(char c) {}
	public void print(Object o) {}
	public void print(float f) {}
	
	@Override // 모든 class는 object를 자동으로 상속하기 떄문에 toString을 재정의 할수 있다.
	public String toString() {
		return "변수에 대한 수업";
	}
}
