package com.test.kko;

import com.jayway.restassured.RestAssured;

import java.lang.reflect.Method;
import java.util.*;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

import static com.jayway.restassured.RestAssured.given;

public class BrandTests {

    @BeforeEach
    public void setUp(){
        RestAssured.baseURI = "http://dlb1.aureacentral.com:10203/api/data/brands";
    }

    /*
{
    "_embedded":{
        "brands":[
        {
            "id": 1,
            "name": "Versata",
            "subdomain": "projectkiwi",
            "sslEnabled": false,
            "defaultBrand": true,
            "enabled": true,
            "lastModifiedDate": "2018-05-08T13:29:04Z",
            "createdDate": "2018-02-05T08:19:46Z",
            "_links":{"self":{"href": "http://dlb1.aureacentral.com:10203/api/data/brands/1"…}
    },
    {"id": 2, "name": "Testing Team1", "subdomain": "testingteam-qa1", "sslEnabled": false,…},
    {"id": 3, "name": "Testing Team 122342", "subdomain": "asfasdf", "sslEnabled": false,…},
    {"id": 4, "name": "Backend brand 1", "subdomain": "rewrite1", "sslEnabled": false,…},
    {"id": 5, "name": "Backend brand 2", "subdomain": "rewrite2", "sslEnabled": false,…}
    ]
    },
    "_links":{
        "self":{
        "href": "http://dlb1.aureacentral.com:10203/api/data/brands{?page,size,sort,projection}",
        "templated": true
    },
    "profile":{
        "href": "http://dlb1.aureacentral.com:10203/api/data/profile/brands"
    },
    "search":{
        "href": "http://dlb1.aureacentral.com:10203/api/data/brands/search"
    }
    },
    "page":{
        "size": 20,
        "totalElements": 5,
        "totalPages": 1,
        "number": 0
    }
}
    */

    @Test
    @TestFactory
    public void getBrands(){

        // https://www.testingexcellence.com/parse-json-response-rest-assured/
        Response response = given()
                .when().get()
                .then().contentType(ContentType.JSON).extract().response();

        response.jsonPath().getString("_embedded").contains("Versata");
    }

    @Test
    public void readingTestName()
    {
        Method[] methods = this.getClass().getMethods();
        Arrays.asList(methods).forEach(item -> {
            if (item.isAnnotationPresent(Test.class)) {
                String pattern = "([a-z])([A-Z])";
                String testCaseName =
                        item.getName().substring(0, 1).toUpperCase() +
                                item.getName().substring(1).replaceAll(pattern, "$1 $2");
                System.out.println(testCaseName);
            }
        });
        assertTrue(true);
    }
}
