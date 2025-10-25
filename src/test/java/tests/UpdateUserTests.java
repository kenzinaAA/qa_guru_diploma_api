package tests;

import models.lombok.UpdateUserLombokModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.RequestSpec.*;
import static specs.ResponseSpec.responseSpec;

@DisplayName("Тесты на изменение существующих данных")
public class UpdateUserTests extends TestBase{

    @DisplayName("Обновление данных пользователя")
    @Test
    void updateUserTest() {
        UpdateUserLombokModel updateUser = new UpdateUserLombokModel();
        updateUser.setName("Kate");

        UpdateUserLombokModel response = step("Request", () ->
                given(requestSpec)
                .body(updateUser)
                .when()
                    .put("/users/2")
                .then()
                    .spec(responseSpec(200))
                        .extract()
                        .as(UpdateUserLombokModel.class));

        step("Check response", () -> {
            assertEquals(updateUser.getName(), response.getName());
            assertEquals(LocalDate.now(ZoneOffset.UTC), Instant.parse(response.getUpdatedAt()).atZone(ZoneOffset.UTC).toLocalDate());
        });
    }
}
