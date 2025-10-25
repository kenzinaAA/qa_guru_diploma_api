package tests;

import models.lombok.UsersListLombokModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.RequestSpec.requestSpec;
import static specs.ResponseSpec.responseSpec;

@DisplayName("Тесты на получение множественных данных")
public class GetListUsersTests extends TestBase {

    @DisplayName("Получение списка пользователей")
    @Test
    void getListUsersTest() {

        UsersListLombokModel response = step("Check response", () ->

        given(requestSpec)
                .when()
                    .queryParam("page", "7")
                    .get("/users")
                .then()
                .spec(responseSpec(200))
                .extract()
                .as(UsersListLombokModel.class));

        step("Check response", () -> {
            assertEquals(7, response.getPage());
            assertEquals(6, response.getPerPage());
            assertEquals(12, response.getTotal());
            assertEquals(2, response.getTotalPages());
            assertEquals(0, response.getUsers().size());
        });
    }
}
