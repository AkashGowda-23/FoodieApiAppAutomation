package Automation.Restaurant;

import static io.restassured.RestAssured.given;

import java.util.HashSet;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pojo.Dish.Dish;
import Pojo.Dish.DishResponse;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class AddDish {
	@Test
	public void Adddish() {
		
		

		RequestSpecification req = new RequestSpecBuilder().setBaseUri("http://localhost:8080/restaurants")
				.setContentType(ContentType.JSON).build();

		ResponseSpecification res = new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON)
				.build();

	Dish p = new Dish();
	p.setId((long) 21);
	p.setName("tandoorii");
	p.setDescription("grilled");
	p.setCategory("no veg");
	p.setPrice(200);
	p.setImage("m.jpg");
	Set<String> days = new HashSet<String>();
	days.add("monday");
	days.add("tuesday");
	p.setAvailableDays(days);
	
	
	

		RequestSpecification request = given().spec(req).body(p).log().all();

		Response resp = request.when().post("/addresto").then().spec(res).extract().response();

		DishResponse response = resp.as(DishResponse.class);
		
		Assert.assertEquals(response.getId(),p.getId());
		Assert.assertEquals(response.getName(),p.getName());
		Assert.assertEquals(response.getImage(),p.getImage());
		Assert.assertEquals(response.getPrice(),p.getPrice());
		Assert.assertEquals(response.getCategory(),p.getCategory());
		Assert.assertEquals(response.getDescription(),p.getDescription());
		
		
	}

}
