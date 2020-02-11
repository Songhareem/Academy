
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
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
		this.basic();
	}
	
	public int abs(int x) {
		
		return x>0? x:-x;
	}
	
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
	
	public byte reverseByteSign(byte x) {
		
		return (byte)(~x + 1);
	}
	
	public int recursionFactorial(int n) {
		
		// f(n) = n * f(n-1), 단 f(1) = 1
		if(n<1 || n >12)
			return -1;
		
		if(n == 1) return 1;
		
		return n * recursionFactorial(n-1);
	}
	
	public int loopFactorial(int n) {
		
		// f(n) = n * f(n-1), 단 f(1) = 1
		int result = 1;
		
		while(n!=0) {
			result *= n--;
		}
		
		return result;
	}
	
	public String concatenate(String delim, String... args) {
        String result = "";

        for(String str: args) {
            result += str + delim;
        }

        return result;
    }
	
	public String getTodayInfo() {
		
		Date today = new Date();
		
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss a");
		
		return "오늘 날짜는" + date.format(today) + "\n" + "현재 시간은" + time.format(today) + "\n"; 
	}
	
	//instanceOf test
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
	
	public void parserTest() {
		
		Parseable parser = ParserManager.getParser("XML");
		parser.parse("docsXml.xml");
		
		parser = ParserManager.getParser("HTML");
		parser.parse("docsHtml.html");
	}
	
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
	
	public void tryWithResourcesTest() throws FileNotFoundException, IOException {
		
		try(FileInputStream fis = new FileInputStream("log.txt");
			DataInputStream dis = new DataInputStream(fis)) {
			
			int i = 10/0;
			
		} catch (Exception e) {
			//if(e instanceof FileNotFoundException)
			e.printStackTrace();
		} 
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



