package java_study.co.kr.jungbu;

import java.lang.management.OperatingSystemMXBean;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


@FunctionalInterface
interface Func<T,R>{
	R apply(T t);
}

public class L12Lamda {
	public static void main(String[] args) {
		//JavaScript(함수형언어, 프로토타입언어) 람다식 : function(){} 함수 => 프로토 타입(타입), class(문법적 설탕) ,()=>{} 람다식 함수(타입이 존재하지 않는)
		// function Calc(a, b){this.a=a; this.b=b; this.sum=function(){}} let s=new sum();
		//Java(객체지향언어) 람다식 : 함수가 하나 있는 객체의 매개변수 대신에 간편하게 작성하는 문법적 설탕
		Function<Integer, Long> square=(i)->{return (long)i*i;}; //function은 매개변수가 하나 있고 반환하는 것이 있는 함수
		Function<Integer, Long> square2=new Function<Integer, Long>() {
			@Override
			public Long apply(Integer t) {
				long result= t*t;
				return result;
			}
		};
		
		BiFunction<Integer, Integer, Long> sum=(i,i2)->{return (long)(i+i2);};
		System.out.println(sum.apply(40, 100));
		Consumer<Integer> squarePrint=(i)->{System.out.println(i*i);}; // 매개변수 1개만 존재하는 함수
		squarePrint.accept(133);
		//Predicate(검사식) : 매개변수와 반환하는 값이 있는데 반환하는 값의 타입은 무조건 boolean
		Predicate<String> nullCheck=s->s!=null;;
		//Supplier : 반환하는 것만 있는 함수 정의
		Supplier<Integer> randomNum=()->{return (int)(Math.random()*10)+1;}; // 1~10까지 랜덤한 수 반환
		System.out.println(randomNum.get());
		//BinaryOperator(연산하는 함수) : 매개변수가 2개고 반환하는 것이 있으면 매개변수와 바환 값의 타입이 같은 것
		BinaryOperator<Integer> sum2=(i,i2)->i+i2;
		System.out.println(sum2.apply(45, 81));
		
		//코드가 줄어들수록 가독성+시간+메모리+유지보수 시간.. 등등이 줄어든다...
	}
}
