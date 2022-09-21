package java_study.co.kr.jungbu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L14StreamAPI {
	static int foreachSum;
	public static void main(String[] args) {
		//IOStream : 통신을 할때 흐름(입력방향,출력방향)
		//StreamAPI : 모든 자료구조를 동일한 방식으로 다루기 위해 존재 (흐름이 있는 자료구조)
		
		List<Integer> numList=new ArrayList<Integer>();
		numList.add(500);
		numList.add(50);
		numList.add(5);
		numList.add(555);
		numList.add(9);
		numList.add(16);
		numList.add(-32);
		//numList의 모든 값을 더하기
		int sum=0;
		for(int i=0;i<numList.size();i++) {
			int num=numList.get(i);
			sum+=num;
		}
		System.out.println("for 반복문 결과 : " + sum);
		sum=0;
		for(int num : numList) { //배열과 관련된 자료구조는 Iterator(정렬)을 사용하기 때문에 향샹된 for문 가능
			sum+=num;
		}
		System.out.println("향상된 for 반복문 결과 : " + sum);
		// 내부 반복문 => Js List 흉내냄
		sum=0;
		//foreach는 List만 가능
		numList.forEach((num)->{foreachSum+=num;}); // Consumer 람다식 : 매개변수만 존재
		System.out.println("내부 반복문 foreach 결과 : " + foreachSum);
		foreachSum=0;
		numList.stream().forEach((num)->{foreachSum+=num;});
		System.out.println("내부 반복문 stream foreach 결과 (List): " + foreachSum);
		foreachSum=0;
		int[] numArr= {33,111,222,1,-5,55};
		Arrays.stream(numArr).forEach((num)->{foreachSum+=num;}); // 배열을 지원하는 객체(랩퍼클래스)
		System.out.println("내부 반복문 stream foreach 결과 (Array): " + foreachSum);
		
		int intStreamSum=Arrays.stream(numArr).sum();
		//List,Map,Set... 컬렉션프레임워크에서 제공하는 자료구조는 기본형으로 자료를 지정할 수 없다. => stream은 기본형 자료구조를 제공한다.
		
		System.out.println("내부 반복문 intStream sum 결과 (Array): " + intStreamSum);
	}
}
