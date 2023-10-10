package Automation.user;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pojo.Restaurant;
import Pojo.RestaurantResponse;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GetRestaurantByName {

	@Test
public void getbyname() {
		
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("http://localhost:8080/api/User").setContentType(ContentType.JSON).build();

        ResponseSpecification res = new  ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        
        RequestSpecification request =given().spec(req).log().all();
        
        Response resp = request.when().queryParam("name","cafe briyani") 
                .log().all().get("/searchByName").then().spec(res).extract().response();
        
        RestaurantResponse[] response= resp.as( RestaurantResponse[].class);
        System.out.println(resp.getBody().asString());
        
       Restaurant p = new Restaurant();
       p.setId((long) 3);
       p.setName("cafe briyani");
       p.setLocation("hydrabad");
       p.setContact("cafeee@gmail.com");
       
       RestaurantResponse responsee = response[0];
       Assert.assertEquals(responsee.getId(),p.getId());
       Assert.assertEquals(responsee.getName(),p.getName());
       Assert.assertEquals(responsee.getLocation(),p.getLocation());
       Assert.assertEquals(responsee.getContact(),p.getContact());
       
}}
