package com.ibm.rest;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
public class FruitResourceTest {

    @Test
    public void testFruitsEndpoint() {
        given()
          .when().get("/fruits")
          .then()
             .statusCode(200)
             .body(is(notNullValue()));
    }

}