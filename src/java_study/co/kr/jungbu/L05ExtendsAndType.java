package java_study.co.kr.jungbu;

class ObjectA{
	String a="ObjectA.a 입니다";
}
class ObjectB extends ObjectA{
	String b="ObjectB.b 입니다";
}
class ObjectC extends ObjectB{
	String c="ObjectC.c 입니다";
}
//상속을 받은 타입을 자식이라 하고 상속을 한 타입을 부모라 한다.
//자식은 부모의 필드를 물려 받는다.
public class L05ExtendsAndType {
	public static void main(String[] args) {
		//상속은 타입의 다형성을 만든다.
		ObjectC c=new ObjectC();
		System.out.println(c.a);
		System.out.println(c.b);
		System.out.println(c.c);
		
		ObjectB b=c;//ObjectB가 참조할 수 있는 필드만 접근 가능
		System.out.println(b.a);
		System.out.println(b.b);
//		System.out.println(b.c); ERROR
		
		ObjectA a=c;
		System.out.println(a.a);
//		System.out.println(a.b); ERROE
//		System.out.println(a.c); ERROE
		
		Object o=c;
//		System.out.println(o.a); ERROE
//		System.out.println(o.b); ERROE
//		System.out.println(o.c); ERROE
		
		//c가 참조하는 객체가 줄어드는 것일까? => no 객체는 그대로이지만 참조만
		
		Object o_c=(ObjectC)o; // 캐스팅 형변환
		
		// 처리방법 1
		if(o.getClass()==String.class) {
			String s_o=(String)o; //객체와 상관없는 타입으로 캐스팅하면 오류(컴파일시 발견도지 않는 심각한 오류) 발생 => 실행도중에 오류가 발생하며 어플이 멈춘다.			
		}
		
		// 처리방법 2
		if(o instanceof String) {
			String s_o=(String)o;
		}
		
		// 처리방법 3
		try {
			String s_o=(String)o;
		}catch(ClassCastException e){
			e.printStackTrace();
		}
		
//		int i=(int)"문자열";  // 오류가 있어 컴파일 할수가 없다 => 미리 오류 감지해 배포되지 않음(js 단점)
		//컴파일 되는 언어의 장점 : 오류가 있는 코드를 배포하지 않는다.
		System.out.println("오류가 발생하면 실행되지 않을 코드");
		
	}
}
