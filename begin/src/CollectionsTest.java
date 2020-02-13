import java.util.ArrayList;
import java.util.Iterator;

public class CollectionsTest {

	// main method
	public void run() {
		
		arrayListTest();
	}
	
	//========================
	// List Interface 관련
	//
	// ArrayList
	// 
	//========================
	
	// ArrayList
	public void arrayListTest() {
		
		ArrayList list = new ArrayList();	 	// 크기 10
		
		for(int i=0;i<10; i++)
			list.add(i);						// enque
		
		for(int i=list.size()-1; i>=0; i--) {
		
			int val = (int) list.get(0); // peek
			System.out.println(val);
			list.remove(0); // deque
		}
		
		System.out.println(list.size());	// size
	}
}
