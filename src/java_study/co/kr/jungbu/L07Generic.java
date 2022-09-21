package java_study.co.kr.jungbu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class GenericTest<T>{
	T name; //기본값은 Object(모든 객체를 참조할수 있기 때문)
	public GenericTest(T name) {
		this.name=name;
	}
}

interface Carable{}

class K7 implements Carable{
	@Override
	public String toString() {return "KIA K7";}
}
class K5 implements Carable{
	@Override
	public String toString() {return "KIA K5";}
}
// Carable이 부모인 타입만 제네릭으로 지정 가능
class CarInfo<T extends Carable>{ //제네릭의 extends 특정 타입을 제한하기 위해 사용
	T car;
	public void print() {
		System.out.println(car.getClass()+":"+car.toString());
	}
}

public class L07Generic {
	public static void main(String[] args) {
		K5 k5=new K5();
		K7 k7=new K7();
		CarInfo carInfo=new CarInfo();
		carInfo.car=k5;
//		carInfo.car="DDD";
		carInfo.print();
		
		
		GenericTest a=new GenericTest("19.99");
		System.out.println(a.name);
		GenericTest<Integer> a2=new GenericTest<Integer>(19);
		System.out.println(a2.name);
		GenericTest<Integer> a3=new GenericTest<Integer>(null);
		System.out.println(a3.name); //기본형의 랩퍼 클래스는 참조형이기 때문에 null을 사용할 수 있다. 
		
		
		
		List<Integer> list=new ArrayList<Integer>(); //기본형은 Generic으로 사용할수 없다.
//		list.add("1");
		//Integer는 int의 랩퍼 클래스
		//기본형의 랩퍼 클래스가 하는 일 (Byte,Short,Integer,Long,Float,Double,Character(아스키코드참조 1byte, 유티코드참조 2byte[가변크기]))
		//1. 형변환"Integer.perseInt("12");
		//2. 기본데이터 타입의 정보 포함 ex) Integer.MAX_VALUE
		//3. 제네릭 타입으로 활용된다.
		
		list.add(1);
		list.add(20);
		list.add(300);
		System.out.println(list);
		
		Object [] birthArr={1986, 2000, 1990, 2002, 1998}; // 태어난 날만
		int now=2022;
		Object[] ageArr=new Object[5];
		for(int i=0;i<birthArr.length;i++) {
			int age=(now-(int)birthArr[i]);
			System.out.println(age);

			ageArr[i]=age;
		}
		List birthList=new ArrayList();
		birthList.add(1986);
		birthList.add("1986");
		birthList.add(1986.0);
		birthList.add(1986f);
		birthList.add(1986l);
		for(int i=0;i<birthList.size();i++) {
			try {
				int age=now-(int)birthList.get(i); // 컴파일시 발견되지 않는 심각한 오류
			} catch (Exception e) {}
		}
		List<Integer> birthList2=new ArrayList<Integer>();
		birthList2.add(1986);
//		birthList2.add("1986");
//		birthList2.add(1986.0);
//		birthList2.add(1986f);
//		birthList2.add(1986l);
//		제네릭을 사용하면 정수만 필드로 참조할 수 있다.
//		List와 Array의 Key : index(순서가 있는)
//		Map에서 key : 중복되지 않는 어떤 것이든 가능(Set)
		Map<Integer ,String> person=new HashMap<Integer ,String>();
		person.put(1998, "다나카");
		person.put(1998, "홍길동");
		person.put(2000, "고길동");
		person.put(2002, "둘리");
		System.out.println(person); //{2000=고길동, 2002=둘리, 1998=홍길동}
		//key는 중복될 수 없는 Set 타입이기 때문에 "다나카" 필드를 "홍길동"이  재정의 함
		//Map의 자료구조는 순서가 없다.
		System.out.println(person.get(2002));
		
		
		Set<Integer> set=new HashSet<Integer>(); //중복이 활용되지 않는 순서가 있는 자료구조
		set.add(10);
		set.add(10);
		set.add(10);
		set.add(10);
		set.add(10);
		set.add(10);
		set.add(12);
		set.add(14);
		set.add(16);
		System.out.println(set);
	}
}
