package com.future.hist.crm.test.controller;

import java.util.UUID;

import org.junit.Test;

public class App {
	
	@Test
	public void uuidTest(){
		String salesNumber= UUID.randomUUID().toString().substring(0, 18);
		System.out.println(salesNumber);
		
	}

}
