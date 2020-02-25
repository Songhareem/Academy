package com.song.file;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class FileEx {

	Scanner sc = new Scanner(System.in);
	
	//임의의 이름으로 폴더 생성
	public void randomMakeDir() {
		
		LocalDate currentDate = LocalDate.now();
		LocalTime currentTime = LocalTime.now();
		
		String name = currentDate.toString() + "_" 
		+ currentTime.getHour() + currentTime.getMinute() 
		+ currentTime.getSecond() + currentTime.getNano();
		System.out.println(name);
		File file = new File("C:\\test", name);
		if(file.mkdir())
			System.out.println("done");
	}
	
	// 생성할 폴더 받아서
	// 폴더 생성
	public void makeDir() {
		
		while(true) {
			System.out.println("만들 폴더명 입력 : ");
			String name = sc.next();
			File file = new File("C:\\test", name);
			if (!file.exists()) {
				if (file.mkdir()) {
					System.out.println("makeDir Done!");
					return;
				}
			} else {
				System.out.println("이미 존재하는 이름의 폴더");
			}
		}
	}
}
