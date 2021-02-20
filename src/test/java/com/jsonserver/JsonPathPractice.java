package com.jsonserver;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.Map;

import static  io.restassured.RestAssured.*;

public class JsonPathPractice {
	
	@BeforeClass
	public void setUp() {
		baseURI="http://localhost:3000";
		//baseURI="http://ergast.com/api/f1/2010";
	}
	@Test
	public void getBooksData() {
		
		Response response=given().get("/books");
	//	System.out.println(response.asPrettyString());
	//	System.out.println(response.getStatusCode());
		int statusCode=response.getStatusCode();
		Assert.assertEquals(statusCode,200);
		
		JsonPath jsonData=response.jsonPath();
	//	System.out.println(jsonData.toString());
		List<Integer>page=jsonData.getList("page");
	//	System.out.println(page);
		
		List<String> authors=jsonData.getList("author");
	//	System.out.println(authors);
		
		String id=jsonData.getString("[5].id");
	//	System.out.println("First book's page : "+id);
		
		
		Map<String,Integer> pageKV=jsonData.getMap("[2]"); 
	//	System.out.println(pageKV.values());
		// get the first obejct
	//	System.out.println(jsonData.getString("[0].name"));
		System.out.println(jsonData.getList("books").size());
	}

}
