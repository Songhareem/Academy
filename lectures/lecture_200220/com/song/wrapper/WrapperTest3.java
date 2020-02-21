package com.song.wrapper;

public class WrapperTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 주민등록번호 검증
		// 		9 2 0  2 0  8 - 1 0 3  8 0 1 0 (검증용 번호)
		// 	X	2 3 4  5 6  7   8 9 2  3 4 5 
		//     18 6 0 10 0 56 0 8 0 6 24 0 5 0
		String auth = "Fail";
		String index = "920208-1038010";
		int[] salted = new int[index.length()];
		
		// 각자리수 검증 번호 배열로 구하기
		// 검증용 곱할 번호 시작 = 2
		int saltInit = 0;
		int saltAdd = 2;
		for(int i=0; i<index.length(); i++) {
			
			if(index.charAt(i) == '-')
				continue;
			
			if(i == index.length()-1)
				saltInit = 1;
			
			salted[i] = Character.getNumericValue(index.charAt(i)) * (saltInit%8+saltAdd);
			saltInit++;
		}
		
		// 각자리수의 합
		int sum = 0;
		for(int i=0; i<index.length(); i++)
			sum += salted[i];
		
		// 11에서 합산결과를 11로 나눈 나머지를 뺀 결과 구하기
		int result = 11 - sum%11;
		
		// 결과가 10 이상이면 다시 10으로 나눈 나머지를 검증용 번호와 비교
		if(result >= 10)
			result %= 10; 
		
		// 비교해서 결과가 같다면 끝!
		if(result == salted[salted.length-1])
			auth = "OK";
		
		// 결과 출력
		System.out.println(auth);
	}

}
