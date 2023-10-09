package Automation.Restaurant;

import org.testng.Assert;

import Pojo.Dish.Dish;
import Pojo.Dish.DishResponse;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;


public class GetDishByid {
	
public static void main(String[] args) {
		
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("http://localhost:8080/restaurants").setContentType(ContentType.JSON).build();

        ResponseSpecification res = new  ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        
        RequestSpecification request =given().spec(req).pathParam("dishId",4).log().all();
        
        Response resp = request.when().get("/getdishbyid/{dishId}").then().spec(res).extract().response();
        
        DishResponse response= resp.as(DishResponse.class);
        System.out.println(resp.getBody().asString());
        
       Dish p = new Dish();
       p.setId((long) 4);
       p.setName("Fish");
       p.setDescription("Curry");
       p.setImage("abcd.png");
       p.setCategory("Non Veg");
        
        Assert.assertEquals(response.getId(),p.getId());
        Assert.assertEquals(response.getName(),p.getName());
        Assert.assertEquals(response.getDescription(),p.getDescription());
        Assert.assertEquals(response.getImage(),p.getImage());
        Assert.assertEquals(response.getCategory(),p.getCategory());

	

}}
