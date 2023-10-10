package Automation.user;

import static io.restassured.RestAssured.given;

import java.util.HashSet;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pojo.Dish.DishResponse;
import Pojo.Order.Order;
import Pojo.Order.OrderResponse;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class PlaceOrder {
@Test
	public void placeorder() {



		RequestSpecification req = new RequestSpecBuilder().setBaseUri("http://localhost:8080/api/User")
				.setContentType(ContentType.JSON).build();

		ResponseSpecification res = new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON)
				.build();


		Order p = new Order();
		p.setId((long) 21);
		p.setDishName("tandoori");
		p.setQuantity(2);
		p.setRestaurantName("cafe briyani");


		RequestSpecification request = given().spec(req).body(p).log().all();

		Response resp = request.when().post("/create").then().spec(res).extract().response();
		
		OrderResponse response = resp.as(OrderResponse.class);
		
		Assert.assertEquals(response.getId(),p.getId());
		Assert.assertEquals(response.getDishName(),p.getDishName());
		Assert.assertEquals(response.getQuantity(),p.getQuantity());
		Assert.assertEquals(response.getRestaurantName(),p.getRestaurantName());
		
		
		



	}
}
