package com.jsonserver;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;

import static  io.restassured.RestAssured.*;

public class HTTPVERBSFORSUBJECTS {
	
	@BeforeClass
	public void setUp() {
		baseURI="http://localhost:3000";
	}
	@Test
	public void getASingleSubject() {
		given().pathParam("id", 1).get("/subjects/{id}").
		then().statusCode(200).
		and().body("id",equalTo(1)).
		and().body("name",equalTo("api testing"));
	}

}
