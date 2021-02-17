package com.jsonserver;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;

import static  io.restassured.RestAssured.*;
public class BooksResourceTesting extends DataGenerator {
	@BeforeClass
	public void setUp() {
		baseURI="http://localhost:3000";
	}
	
	@Test(priority=1)
	public void getSingleBook() {
		given().pathParam("id",3).get("/books/{id}").
		then().statusCode(200).and().header("Content-Type","application/json; charset=utf-8").
		and().body("name",equalTo("Overthrown")).and().body("author",equalTo("Stephen Kinzer")).
		and().body("price",equalTo(29.99F)).and().body("published",equalTo(2002)).
		and().body("page",equalTo(370)).and().body("id",equalTo(3));
	}
	
	@Test(priority=2)
	public void createSingleBook() {
		Faker fk= new Faker();
		JSONObject book=new JSONObject();
		book.put("name", String.valueOf(fk.book().title()));
		book.put("author",String.valueOf(fk.book().author()));
		book.put("price",Math.round(Math.random()*20)+19.99);
		book.put("published",Math.round(Math.random()*100)+1900);
		book.put("page",560);
		book.put("id",Math.round(Math.random()*100)+100);
		given().header("Content-Type","application/json").accept(ContentType.JSON).
		body(book.toJSONString()).post("/books").then().statusCode(201);
	}
	@Test(priority=3)
	public void updateSingleBook(){
		JSONObject book=new JSONObject();
		book.put("name", "Mehrobdan Chayon");
		book.put("author","Qodiriy");
		book.put("price",39.99);
		book.put("published",1927);
		book.put("page",520);
		given().header("Content-Type","application/json").accept(ContentType.JSON).
		body(book.toJSONString()).put("/books/4").then().statusCode(200).
		and().body("name",equalTo("Mehrobdan Chayon")).and().body("author",equalTo("Qodiriy")).
		and().body("price",equalTo(39.99F)).and().body("published",equalTo(1927)).
		and().body("page",equalTo(520)).and().body("id",equalTo(4));
	}
	
	@Test(priority=4)
	public void deleteSingleBook() {
	   given().pathParam("id",5).delete("/books/{id}").then().statusCode(200);
	}
	
	
	
	
}
