package com.jsonserver;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static  io.restassured.RestAssured.*;

public class HTTPVERBS {
	
	@BeforeClass
	public void setUp() {
		baseURI="http://localhost:3000";
	}
	@Test
	public void getAllUsers() {
		given().get("/users").then().statusCode(200);
	}
	@Test
	public void testQueryParameter() {
		given().queryParam("subjectId",2).get("/users").prettyPrint();
	}
	@Test
	public void testPathParameter() {
		given().pathParam("id",1).get("/users/{id}").prettyPrint();
	}
	
	
	
	
	

}
