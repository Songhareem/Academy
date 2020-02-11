
public class MySort {

public void bubble(int[] src) {
		
		System.out.println("do bubble sort");

		for (int i = 0; i < src.length - 1; i++) {

			for (int j = 0; j < src.length - 1 - i; j++) {
				// System.out.println("i :" + i);
				// System.out.println("j :" + j);
				// System.out.println("j+1 :" + (j+1));

				if (src[j] > src[j + 1]) {
					int tmp = src[j];
					src[j] = src[j + 1];
					src[j + 1] = tmp;
				}

			}
		}

		for (int item : src) {
			System.out.print(item);
		}
		System.out.println();
	}
}
