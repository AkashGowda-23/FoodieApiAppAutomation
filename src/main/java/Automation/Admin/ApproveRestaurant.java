package Automation.Admin;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.given;

import org.testng.Assert;

public class ApproveRestaurant {

	public static void main(String[] args) {
        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("http://localhost:8080/api/admin")
                .setContentType(ContentType.JSON)
                .build();

        ResponseSpecification res = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType("text/plain;charset=UTF-8") 
                .build();

        RequestSpecification request = given()
                .spec(req)
                .pathParam("restaurantId", 3)
                .log().all();

        Response resp = request.when().post("/approveRestaurant/{restaurantId}").then().spec(res).extract().response();

        String responseText = resp.getBody().asString();
        System.out.println(responseText);
        
        Assert.assertEquals(responseText,"Restaurant approved successfully");
	}
}
