package lecture_200214;

import java.text.SimpleDateFormat;

public class AbstractSub extends Abstract {

	@Override
	public void printDate() {
	
		//SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
		//String format_time1 = format1.format (System.currentTimeMillis());
		//System.out.println(format_time1);
				
		SimpleDateFormat format2 = new SimpleDateFormat ( "yyyy년 MM월dd일");
		System.out.println(format2.format (System.currentTimeMillis()));		        				 		
	}
}
