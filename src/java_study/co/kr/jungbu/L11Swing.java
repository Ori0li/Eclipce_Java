package java_study.co.kr.jungbu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class L11Swing {
	static boolean start=true;
		public static void main(String[] args) {
			//JFrame awt > JFrame Swing GUI를 제공하는 객체
			//java : 플랫폼(os)에 독립적이다.
			JFrame frame=new JFrame("Swing Frame"); //Container : Component객체를 포함 할 수 있다 , Window : os에서 제공하는 창을 생성
			JButton btn1=new JButton("시간 출력"); //Component : Container에 포함 될 수 있고 이벤트를 받을 수 있다.
			JButton btn2=new JButton("시간 멈춤");
			JLabel label=new JLabel("현재 시간 출력");
			label.setFont(new Font("Serif", Font.BOLD, 16));
			//boolean start=true; //익명 클래스에서 지역변수를 참조할때 그것을 상수로 취급
			
			btn1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(!start)start=true;
					new Thread(()->{while(start) {
						System.out.println("버튼이 눌림");
						String now=LocalTime.now().toString();
						label.setText(now);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
					} }).start();
					//component의 thread를 독점해 frame이 아무런 동작 안함
					//actionPerfomed() 함수가 종료되어야 frame 다음 동작을 할수 있다.
				}
			});
			
			btn2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					start=false;
				}
			});
			
			
//			람다식 쓰면
//			btn2.addActionListener((e)->{
//				start=false;
//			});
			
			//frame은 기본 레이아웃(borderlayout)이 지정되어 있다.
//			frame.add(btn1,BorderLayout.CENTER);
//			frame.add(btn2,BorderLayout.NORTH);
			frame.setLayout(null); //레이아웃을 지우면 위치나 크기로 컴포넌트(버튼)의 위치를 지정
			btn1.setBounds(0, 0, 100, 60); //frame에 존재할 위치와 크기 지정
			btn2.setBounds(150, 0, 100, 60);
			label.setBounds(0, 100, 300, 100);
			
			frame.add(btn1);
			frame.add(btn2);
			frame.add(label);
			frame.setBounds(100, 100, 300, 200); //프레임의 화면 배치
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //window의 종료 버튼을 누르면 어떻게 되는지
			frame.setVisible(true);
		}
}
