package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static specs.RequestSpec.requestSpec;
import static specs.ResponseSpec.responseSpec;

public class DeleteUserTests extends TestBase {

    @DisplayName("Удаление пользователя")
    @Test
    void deleteUserTest () {
        step("Request", ()->
        given(requestSpec)
                .when()
                    .delete("/users/4")
                .then()
                .spec(responseSpec(204)));
    }
}
