package java_study.co.kr.jungbu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class L18StreamAPIEx4 {
	
	public static void main(String[] args) {
		//Stream 최종 연산 종류
		//forEach(Consumer)  : 출력 
		//reduce(BinaryOperator)	: 소모 (요소들을 1개의 결과로 줄인다.)
		//sum(),average() : 연산 소모 (기본형)
		//count(), max, min(기본형), max, min(참조형 sort) : 집계, 통계 연산
		
		//any,all,noneMatch(Predicate) : 검사 (중간 연산 filter 유사함)
		
		//collect() : 수집 ( 주간연산 map 과 유사 )

	
		int [] scoreArrDLY= {88,50,70,100,30,90}; // 둘리 성적
		int [] scoreArrKKD= {90,100,99,100,85,92}; // 고길동 성적
		// 성적 관리 프로그램
		// 장학금 대상자 2명이 있는데 모든 과목의 성적이 80점이상이여야 장학금이 나온다(검사식 구성)
		
		long c=Arrays.stream(scoreArrDLY)
		.filter((s)->s<80)
		.count();
		System.out.println("둘리의 성적이 80점이하인 과목의 수 :"+c);
		
		
		boolean t1=Arrays.stream(scoreArrDLY)
		.allMatch(s->s>=80);
		
		System.out.println("둘리의 성적은 모두 80이상인가요? : "+t1);
		
		boolean t2=Arrays.stream(scoreArrKKD)
				.allMatch(s->s>=80);				
		System.out.println("고길동의 성적은 모두 80이상인가요? : "+t2);

		// 1개라도 60점 미만의 점수가 있으면 장학금 대상에서 탈락
		t1=Arrays.stream(scoreArrDLY)
				.anyMatch(s->s<60);
		System.out.println("둘리의 성적이 60점 미안인 것이 1개라도 있나요? :"+t1);
		
		t2=Arrays.stream(scoreArrKKD)
				.anyMatch(s->s<60);
		System.out.println("고길동의 성적이 60점 미안인 것이 1개라도 있나요? :"+t2);
		
		Stream stream = Stream.of("a",1,"b",33.9,"c",'d'); //(Object ...value) : 매개변수의 수 제한이 없게 선언됨
		Stream<String> stream2 = Stream.of("11","1","55","33","100","-51");
		stream.sorted().count();
		ArrayList<Integer> strList = 
				stream2
				.map(Integer::parseInt)//정수로 바꾼다
				.collect(Collectors.toCollection(ArrayList<Integer>::new));
		System.out.println(strList);
		
//		stream2.forEach(System.out::println); //Stream은 방향성이 있는 자료구조 한번 사용하면 다시 사용할수 없다.
		
		
		Stream<String> stream3 = Stream.of("11","1","55","33","100","-51");
//		int sum=stream3.collect(Collectors.summingInt((str)->Integer.parseInt(str)));
		int sum=stream3.mapToInt(Integer::parseInt).sum();
		System.out.println(sum);
	}
}
