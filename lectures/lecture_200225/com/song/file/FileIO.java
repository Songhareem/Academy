package com.song.file;

import java.io.File;

public class FileIO {

	public void fileDelete() {
		
		File file = new File("C:\\test\\t4");
		if(file.delete())
			System.out.println("삭제 성공");
	}
	
	public void fileInfo() {
		
		// 파일의 정보를 담고 있는 객체 생성
		File file = new File("C:\\test", "choa.txt");
		
		// 파일이 위치, 이름 등등
		
		System.out.println(file.exists());
		System.out.println(file.getName());
		System.out.println(file.getPath());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.isDirectory());
		System.out.println(file.isFile());
		
		file = new File("C:\\test");
		String[] names = file.list();
		for (String string : names) {
			File tmpFile = new File("C:\\test\\" + string);
			if(tmpFile.isDirectory())
				System.out.println("dir");
			else
				System.out.println("file");
		}

		file = new File("C:\\test");
		File[] files = file.listFiles();
		for (File file2 : files) {
			System.out.println(file2);
		}
		
		file = new File("C:\\test");
		
		File file2 = new File(file, "choa.txt");
		System.out.println(file2.exists());
		
		file2 = new File(file, " 1");
		System.out.println(file2.exists());
	
		System.out.println("==============================");
		
		file = new File("C:\\test\\t2");
		file.mkdir();
		
		file = new File("C:\\test\\t3\\s1");
		System.out.println(file.mkdirs());
	}
}
