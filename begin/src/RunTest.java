
public class RunTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] src = { 0, 4, 2, 1, 3 };

		MySort sort = new MySort();
		sort.bubble(src);

		CuriousTest ct = new CuriousTest();
		ct.run();

	}
}
