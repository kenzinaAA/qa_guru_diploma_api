package tests;

import models.lombok.*;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static specs.RequestSpec.*;
import static specs.ResponseSpec.responseSpec;

public class CreateUserTests extends TestBase {

    Integer keyMinLength = 17;

    @Test
    void successfulCreateUserTest() {
        CreateBodyLombokModel regData = new CreateBodyLombokModel();
        regData.setEmail("eve.holt@reqres.in");
        regData.setPassword("sinichka");

        CreateResponseLombokModel response = step("Make request", () ->
                given(requestSpec)
                        .body(regData)
                        .when()
                        .post("/register")
                        .then()
                        .spec(responseSpec(200))
                        .extract()
                        .as(CreateResponseLombokModel.class)
        );

        step("Check response", () -> {
            assertEquals(4, response.getId());
            assertThat(response.getToken(), not(isEmptyOrNullString()));
            assertTrue(response.getToken().length()>=keyMinLength);
            assertTrue (response.getToken().matches("^[A-Za-z0-9]+$"));
        });
    }
    @Test
    void unsuccessfulCreateUserTest() {
        LoginBodyLombokModel userData = new LoginBodyLombokModel();
        userData.setEmail("eve.holt@reqres.in");

        UnsuccessfulLoginResponseLombokModel response = step("Make request", () ->

        given(requestSpec)
                .body(userData)
                .when()
                    .post("/register")
                .then()
                .spec(responseSpec(400))
                .extract()
                .as(UnsuccessfulLoginResponseLombokModel.class)
        );

        step("Check response", () -> {
            assertEquals("Missing password", response.getError());
        });
    }
}