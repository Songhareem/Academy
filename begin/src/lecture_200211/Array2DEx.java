package lecture_200211;

public class Array2DEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.printf("no.\t왼쪽\t오른쪽\t평균\n");
		System.out.println("============================");
		
		float[][] visionInfo = {{1.2f, 1.5f},
								{0.2f, 0.8f},
								{1.8f, 1.3f}};
		
		/*
		 * for(int i=0; i<visionInfo.length; i++) {
		 * 
		 * int row = i; float left = visionInfo[row][0]; float right =
		 * visionInfo[row][1]; float avg = (float)(left + right)/2;
		 * System.out.printf("%d\t%.1f\t%.1f\t%.1f\n",row+1, left, right, avg); }
		 */
		
		float left = 0f;
		float right = 0f;
		float avg = 0f;
		
		for(int i=0; i<visionInfo.length*visionInfo[0].length; i++) {
			
			int row = i/visionInfo[0].length;
			int col = i%visionInfo[0].length;
			
			//no 출력 및 left right 저장
			if(i%2 == 0) {
				System.out.printf("%d\t",(i+2)>>1);
				left = visionInfo[row][col];
			}
			else {
				right = visionInfo[row][col];
			}
			
			// left right 출력
			System.out.printf("%.1f\t",visionInfo[row][col]);
			
			// avg 출력
			if(i%2 == 1) {
				System.out.printf("%.1f\n", (left+right)/2);
			}
		}
	}
}
