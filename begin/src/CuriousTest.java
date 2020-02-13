
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class CuriousTest {

	public void run() {
		
		// System.out.println(this.abs(-1));
		// System.out.println(this.reverseByteSign((byte)-10));
		// System.out.println(this.recursionFactorial(5));
		// System.out.println(this.concatenate(",", new String[] {"100", "200", "300"}));
		// this.callInstanceofTest();
		// System.out.println(this.getTodayInfo());
		//this.parserTest();
		//this.exceptionError();
		//this.basic();
		//this.newTimeEx();
	}
	
	// 절대값
	public int abs(int x) {
		
		return x>0? x:-x;
	}
	
	//if 논리 연산에 대한 고찰
	public void basic( ) {
		
		int a=10, b=10;
		
		int c=0;
		
		if(++a>c||b++>c)
			System.out.println(a+","+b+","+c);
		
		char ch = 'A';
		float f = 5.2f;
		
		f += ch;
		System.out.println(f);
	}
	
	// 부호 바꾸기
	public byte reverseByteSign(byte x) {
		
		return (byte)(~x + 1);
	}
	
	// 재귀 활용 팩토리얼
	public int recursionFactorial(int n) {
		
		// f(n) = n * f(n-1), 단 f(1) = 1
		if(n<1 || n >12)
			return -1;
		
		if(n == 1) return 1;
		
		return n * recursionFactorial(n-1);
	}
	
	// 반복문 활용 팩토리얼
	public int loopFactorial(int n) {
		
		// f(n) = n * f(n-1), 단 f(1) = 1
		int result = 1;
		
		while(n!=0) {
			result *= n--;
		}
		
		return result;
	}
	
	// 가변인자 테스트
	public String concatenate(String delim, String... args) {
        String result = "";

        for(String str: args) {
            result += str + delim;
        }

        return result;
    }
	
	// 날짜 함수 테스트
	public String getTodayInfo() {
		
		Date today = new Date();
		
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss a");
		
		return "오늘 날짜는" + date.format(today) + "\n" + "현재 시간은" + time.format(today) + "\n"; 
	}
	
	//instanceOf 테스트
	public class Car {}
	public class Bus extends Car {}
	public class Dump extends Car {}
	
	public void instanceofTest(Car kindOfCar) {
		if(kindOfCar instanceof Bus) {
			System.out.println("넣은 객체는 버스");
		}
		
		else if(kindOfCar instanceof Dump) {
			System.out.println("넣은 객체는 덤프");
		}
		
		else
			System.out.println("넣은 객체는 차");
	}
	
	public void callInstanceofTest() {
		
		this.instanceofTest(new Car());
		this.instanceofTest(new Bus());
		this.instanceofTest(new Dump());
	}
	
	// 파서 테스트
	public void parserTest() {
		
		Parseable parser = ParserManager.getParser("XML");
		parser.parse("docsXml.xml");
		
		parser = ParserManager.getParser("HTML");
		parser.parse("docsHtml.html");
	}
	
	// 예외처리 테스트
	public void exceptionError() {
		
		try{
			int err = 100/0;
		}catch(ArithmeticException e) {
			System.out.println("divide zero");
		}catch(Exception e) {
			System.out.println("그 이외 예외 모두 처리");
		}
		
		try {
			throw new Exception("고의 발생");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 예외 발생시 stack trace 테스트
	public void tryWithResourcesTest() throws FileNotFoundException, IOException {
		
		try(FileInputStream fis = new FileInputStream("log.txt");
			DataInputStream dis = new DataInputStream(fis)) {
			
		} catch (Exception e) {
			//if(e instanceof FileNotFoundException)
			e.printStackTrace();
		} 
	}
	
	// 날짜 및 시간 관련  테스트
	public void newTimeEx() {
		
		LocalDate today = LocalDate.now();		// 오늘의 날짜
		LocalTime now	= LocalTime.now();		// 현재 시간
		
		LocalDate birthDay = LocalDate.of(1992, 2, 8);	// 1992년 2월 8일
		LocalTime birthTime = LocalTime.of(23, 59, 59);	// 23시 59분 59초
		
		System.out.printf("today = %s\n",today);
		System.out.printf("now = %s\n",now);
		System.out.printf("birthDay = %s\n",birthDay);
		System.out.printf("birthTime = %s\n",birthTime);
		
		System.out.println(birthDay.withYear(2000));			// 2000-02-08
		System.out.println(birthDay.plusDays(1));				// 1992-02-09
		System.out.println(birthDay.plus(1, ChronoUnit.DAYS));	// 1992-02-09
		
		System.out.println(birthTime.truncatedTo(ChronoUnit.HOURS));	// 23:00
		
		// 특정 ChronoField 범위를 알아내는 법
		System.out.println(ChronoField.CLOCK_HOUR_OF_DAY.range());	// 1 - 24
		System.out.println(ChronoField.HOUR_OF_DAY.range());		// 0 - 23
		
	}
}

//=======================
// interface 다형성 예제
//=======================
interface Parseable {
	// 구문 분석 작업 수행
	public abstract void parse(String fileName);
}
	
class XMLParser implements Parseable {
	public void parse(String fileName) {
		/* 구문 분석 작업 수행 코드 */
		System.out.println(fileName + "- XML parsing completed");
	}
}
	
class HTMLParser implements Parseable {
	public void parse(String fileName) {
		/* 구문 분석 작업 수행 코드 */
		System.out.println(fileName + "- HTML parsing completed");
	}
}

// 리턴 타입이 Parseable인 인터페이스
class ParserManager {
	public static Parseable getParser(String type) {
			
		if(type.equals("XML"))
			return new XMLParser();
		else if(type.equals("HTML"));
			return new HTMLParser();
	}
}



