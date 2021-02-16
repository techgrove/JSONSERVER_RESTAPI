package com.jsonserver;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static  io.restassured.RestAssured.*;

public class CreateUsers {
	//long randomNum=Math.round(Math.random()*100)+10;
	@BeforeClass
	public void createUser() {
		baseURI="http://localhost:3000";
	}
	@Test(priority=1)
	public void createSingleUser() {
		JSONObject data= new JSONObject();
		data.put("fistname","fanki");
		data.put("lastname","sardor");
		data.put("subjectId", 10);
		
		given().header("Content-Type","application/json").accept(ContentType.JSON).
		and().body(data.toJSONString()).post("/users").then().statusCode(201);
	}
	@Test(priority=2)
	public void testPut() {
		JSONObject data= new JSONObject();
		data.put("firstname","komiljon");
		data.put("lastname", "hakimov");
		data.put("subject",2);
		given().header("Content-Type","application/json").accept(ContentType.JSON).
		body(data.toJSONString()).put("/users/10").then().statusCode(200);
	}
	@Test(priority=3)
	public void testPatch() {
		JSONObject data= new JSONObject();
		data.put("firstname","muzaffar");
		given().header("Content-Type","application/json").accept(ContentType.JSON).
		body(data.toJSONString()).patch("/users/10").then().statusCode(200);
	}
	@Test(priority=4)
	public void testDelete() {
		when().delete("/users/10").then().statusCode(200);
	}
	

}
