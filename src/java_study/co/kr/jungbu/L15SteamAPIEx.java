package java_study.co.kr.jungbu;

import java.util.ArrayList;
import java.util.List;

public class L15SteamAPIEx {
	static int sum2;
	
	public static void main(String[] args) {
		
		Integer n=new Integer(500);
		System.out.println(10+n);
		System.out.println(10+n.intValue()); // 참조형 Integer 객체에서 기본형을 반환하여 계산
		List<Integer> numList=new ArrayList<Integer>();
		numList.add(500); //=>new Integer(500)
		numList.add(50);
		numList.add(5);
		numList.add(null);
		numList.add(555);
		numList.add(9);
		numList.add(16);
		numList.add(-32);
		
		//외부반복문은 내부반복문 보다 조건을 파악하기 어렵다.
		int sum=0;
		for(Integer num : numList) { //int num = numList.get[i].intValue(); => int num = null.intValue();
			if(num!=null) {				
				sum+=num;
			}
		}
		// null이 필드가 없는데 참조해서 오류
		System.out.println(sum);
		
		numList.stream()
		.filter(i->i!=null)	//filter(중간연산):검사식에서 true를 반환하는 값만 stream으로 다시 반환
		.forEach((i)->{sum2+=i;}); //forEach(최종연산)
		System.out.println(sum2);
		
	}
}



