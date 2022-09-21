package java_study.co.kr.jungbu;

import java.io.IOException;

public class L20InputOutputSteam {
	public static void main(String[] args){
		// 입출력(IO) 장치와 스트립
		// 입력(input)과 출력(output) : 컴퓨터 내부(cpu, memory), 외부(장치)에서 프로그램간에 데이터를 주고 받는 것
		// 파일을 입력받거나 출력하는 행위
		// 소리를 출력하는 행위, 키보드 or 마우스 입력
		// 모니터에 출력
		try {
			int i=System.in.read(); //InputStream : byte 기반의 입출력 클래스라 문자열을 입력 받을 수 없다.
			System.out.println("입력한 값: "+i); 
			// 아스키코드(1byte): 최초로 만들어진 문자표, 유니코드(2byte):모든 자를 사용하기 위해 만들어진 문자표
			// 입출력은 기본 1byte를 기준으로 data를 입력하거나 출력한다.
			// 예)바이트 기준으로 저장되있다 치고 
			// 예) char (97 16) (255 77) (0 44) (99 254) -1 (문서) => 유니코드 변환
			// 예) char (97) (16) (255) (77) (0) (44) (99) (254) -1 (문서) => 아스키 변환
			
			//  2^0 0 0 0 0 0 0 2^7  약속 byte type이라 하겠다.
			//  2^0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 2^15 약속 char type이라 하겠다.
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
