package com.test.restass;

import io.restassured.response.*;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Test001 {

    public static final String BASE_URL = "http://localhost:1235/v2";
    public static final String CATS = "/cats";

    @Test
    public void testConnect() {
        // http://localhost:1235/v2/cats?name=barsik
        Response response = given()
                .formParam("name", "barsik")
                // .header("aa", "dd")
                .when().get(BASE_URL + CATS);
        response.then().assertThat().statusCode(200);
        System.out.println(response);
    }
}
