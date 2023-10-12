package Automation.Restaurant;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Disabledish {
	@Test
	public void disabledish() {
        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("http://localhost:8080/restaurants")
                .setContentType(ContentType.JSON)
                .build();

        ResponseSpecification res = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType("text/plain;charset=UTF-8") 
                .build();

        RequestSpecification request = given()
                .spec(req)
                .pathParam("dishId", 4)
                .log().all();

        Response resp = request.when().put("/dish/{dishId}/disable").then().spec(res).extract().response();

        String responseText = resp.getBody().asString();
        System.out.println(responseText);
        
        Assert.assertEquals(responseText,"Dish disabled successfully");
    }
	
	

}
