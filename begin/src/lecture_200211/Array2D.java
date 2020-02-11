package lecture_200211;

public class Array2D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 이차원배열 for문 하나로 출력
		int[][] data = new int[][] {{1,2,3},{4,5,6}};
		for (int i = 0; i < data.length * data[0].length; i++) {
            int row = i / data[0].length; // 행
            int col = i % data[0].length; // 열
            System.out.print(data[row][col] + "\t");
 
            if (col == data[0].length - 1) {
                System.out.println();
            }
        }
		
		// 이차원배열 for문 하나 안에서 가벼운 로직
		String[][] sw = new String[2][2];
		for (int i = 0; i < sw.length * sw[0].length; i++) {
            int row = i / sw[0].length; // 행
            int col = i % sw[0].length; // 열
            
            sw[row][col] = row == col?"on":"off";
            
            System.out.print(sw[row][col] + "\t");
            
            if (col == sw[0].length - 1) {
                System.out.println();
            }
		}
		
		// 문자형 2차원 배열(2행 4열) chs 선언, 생성 및 초기화
		char[][] chs = {{'a','b','c','d'},
						{'e','f','g','h'}};
		
		for(int i=0; i<chs.length * chs[0].length; i++) {
			int row = i/chs[0].length;
			int col = i%chs[0].length;
			
			System.out.print(chs[row][col] + "\t");
			
			if(col == chs[0].length - 1) {
				System.out.println();
			}
		}
		
		// 가변 길이의 2차원 문자열 배열 strArr 선언 및 생성(2행 ?열)
		String[][] strArr = new String[2][];
		
		strArr[0] = new String[2];
		strArr[1] = new String[3];
		
		
	}

}
