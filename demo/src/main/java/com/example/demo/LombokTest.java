package com.example.demo;

public class LombokTest {
	
	public static void main(String[] args) {
		MemDTO dto = new MemDTO();
		dto.setName("황윤정");
		dto.setAge(30);
		dto.setLoc("부산");
		
		System.out.printf("%s %d %s\n", dto.getName(), dto.getAge(),dto.getLoc());
	
	MemDTO dto2 = new MemDTO("조영원", 29, "용인");
	System.out.printf("%s %d %s\n", dto2.getName(), dto2.getAge(),dto2.getLoc());
	}

}
