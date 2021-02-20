package com.jsonserver;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HTTPVERBSFORSUBJECTS {
	Logger logger=Logger.getLogger(HTTPVERBSFORSUBJECTS.class);
	
//	@BeforeClass
//	public void setUp() {
//		baseURI="http://restapi.demoqa.com/authentication";
//	}

	@Test
	public void getASingleSubject() {
		given().pathParam("id", 1).get("/subjects/{id}").
		then().statusCode(200).
		and().body("id",equalTo(1)).
		and().body("name",equalTo("api testing"));
	}
	@Test
	public void githubAuthentication() {
		JSONObject data = new JSONObject();
		data.put("name","WORLD_VIA_ECLIPSE");
		
		baseURI="https://api.github.com/repos/techgrove";
		//basePath="/repos/techgrove";
		Response res=given().auth().oauth2("6dde180defbae35712e79abc653a2fbc4eb1ba38").
		header("Content-Type","application/json").accept(ContentType.JSON).
		body(data.toJSONString()).patch("/textName");
		JsonPath js=res.jsonPath();
		String name=js.getString("name");
		System.out.println(name);
	}
	@Test
	public void testDelete() {
		baseURI="https://api.github.com/repos/techgrove";
		given().auth().oauth2("6dde180defbae35712e79abc653a2fbc4eb1ba38").when().delete("/SecondProject").then().statusCode(204);
	}



}
