package com.test.kkk;

import com.jayway.restassured.RestAssured;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class BrandTests {

    @Before
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
    public void getBrands(){
/*
        JsonObject obj = Json.createObjectBuilder()
                .add("id", 1)
                .add("name", "Versata")
                .add("subdomain", "projectwiki1")
                .add("sslEnabled", false)
                .build();
        */

        Response response = given()
                .when().get()
                .then().contentType(ContentType.JSON).extract().response();
        response.jsonPath().getString("_embedded").contains("Versata");
    }
}
