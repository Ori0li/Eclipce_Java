package java_study.co.kr.jungbu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L17StreamAPIEx3 {
	public static void main(String[] args) {
		/*
		 * Stream의 중간 연산
		 * sort() : stream 자료 정렬
		 */
		
		//Array : 배열의 기본이 되는 타입 : 필드가 Index와 길이 뿐인 자료형, 선언한 길이를 변경할 수 없다.
		int numAr[]= {99,-5,1,2,33,-7}; //
		
		Arrays.sort(numAr);
		System.out.println(Arrays.toString(numAr));
		
		//List : 배열을 제어하기 위한 자료형 : 필드가 Index와 제어에 유용한 함수를 포함, 배열의 아이템을 추가 삭제 기능(길이가 변경가능)
		List<Integer> numList=new ArrayList<>();
		numList.add(99);
		numList.add(-5);
		numList.add(1);
		numList.add(2);
		numList.add(33);
		numList.add(-7);
		numList.sort(null); //기본값이 오름차순 정렬(배열, 자신을 변경하는 함수)
		System.out.println(numList);
		
		int numAr2[]= {99,-5,1,2,33,-7};
		
		//Stream 자료형의 목표는 모든 자료형의 반복문을 통일
		
		Arrays.stream(numAr2)
		.sorted()
		.forEach(System.out::println);
		
		String [] strAr= {"abc","aaa","bbc","ADc","Bae","zzz","aaa","abc","zzz","zzz"};
		
		Arrays.stream(strAr)
		.distinct() // 중복을 제거
		.sorted(String.CASE_INSENSITIVE_ORDER)
		.forEach(System.out::println);
		
		
		int [] intAr3 = {0,1,2,3,4,5,6,7,8,9};
		
		Arrays.stream(intAr3)
		.skip(3) // 건너뛰는 중간 연산
		.limit(3) // 길이 만큼 잘라내는 연산
		.forEach(System.out::println);
		
	}
}
