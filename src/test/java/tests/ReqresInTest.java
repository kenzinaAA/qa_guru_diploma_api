package tests;

import io.restassured.response.Response;
import models.User;
import models.lombok.LombokModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static specs.Specs.*;

public class ReqresInTest extends TestBase{

    @Test
    @DisplayName("Поиск информации о пользователе")
    void singleUserTest(){
        LombokModel response =
                given()
                        .spec(request)
                        .when()
                        .get("/users/2")
                        .then()
                        .spec(response200)
                        .log().body()
                        .extract().as(LombokModel.class);

        Integer id = 2;
        String email = "janet.weaver@reqres.in";
        String firstName = "Janet";
        String lastName = "Weaver";

        assertEquals(id,response.getUser().getId());
        assertEquals(email,response.getUser().getEmail());
        assertEquals(firstName,response.getUser().getFirstName());
        assertEquals(lastName,response.getUser().getLastName());
    }

    @Test
    @DisplayName("Получение списка пользователей")
    void listUserTest(){
                Response response =
                        given()
                        .spec(request)
                        .when()
                        .get("/users?page=2")
                        .then()
                        .spec(response200)
                        .log().body()
                        .extract().response();

        Integer id = 12;
        String email = "rachel.howell@reqres.in";
        String firstName = "Rachel";
        String lastName = "Howell";

        assertEquals(id,response.path("data[5].id"));
        assertEquals(email,response.path("data[5].email"));
        assertEquals(firstName,response.path("data[5].first_name"));
        assertEquals(lastName,response.path("data[5].last_name"));
    }

    @Test
    @DisplayName("Вывод списка ресурсов")
    void listResourseTest(){
        Response response =
                given()
                        .spec(request)
                        .when()
                        .get("/unknown")
                        .then()
                        .spec(response200)
                        .log().body()
                        .extract().response();

        Integer id = 1;
        String name = "cerulean";
        Integer year = 2000;
        String color = "#98B2D1";
        String pantoneValue = "15-4020";

        assertEquals(id,response.path("data[0].id"));
        assertEquals(name,response.path("data[0].name"));
        assertEquals(year,response.path("data[0].year"));
        assertEquals(color,response.path("data[0].color"));
        assertEquals(pantoneValue,response.path("data[0].pantone_value"));
    }

    @Test
    @DisplayName("Создание пользователя")
    void createUserTest(){
        User user = new User();
        user.setName("morpheus");
        user.setJob("leader");

        User responseUser =
                given()
                        .spec(request)
                        .body(user)
                        .when()
                        .post("/users")
                        .then()
                        .spec(response201)
                        .log().body()
                        .extract().as(User.class);

        assertNotEquals(responseUser.getId(),null);
        assertEquals(user.getName(),responseUser.getName());
        assertEquals(user.getJob(),responseUser.getJob());
    }

    @Test
    @DisplayName("Успешная регистрация")
    void registerSuccessfulTest(){
        User user = new User();
        user.setEmail("eve.holt@reqres.in");
        user.setPassword("pistol");

        User responseUser =
                given()
                        .spec(request)
                        .body(user)
                        .when()
                        .post("/register")
                        .then()
                        .spec(response200)
                        .log().body()
                        .extract().as(User.class);

        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";

        assertEquals(id,responseUser.getId());
        assertEquals(token,responseUser.getToken());
    }

    @Test
    @DisplayName("Безуспешная регитсрация")
    void registerUnsuccessfulTest(){
        User user = new User();
        user.setEmail("sydney@fife");

        Response response =
                given()
                        .spec(request)
                        .body(user)
                        .when()
                        .post("/register")
                        .then()
                        .spec(response400)
                        .log().body()
                        .extract().response();

        String message = "Missing password";
        assertEquals(message,response.path("error"));
    }

    @Test
    @DisplayName("Успешная авторизация")
    void loginSuccessfulTest(){
        User user = new User();
        user.setEmail("eve.holt@reqres.in");
        user.setPassword("cityslicka");

        User responseUser =
                given()
                        .spec(request)
                        .body(user)
                        .when()
                        .post("/login")
                        .then()
                        .spec(response200)
                        .log().body()
                        .extract().as(User.class);

        String token = "QpwL5tke4Pnpja7X4";
        assertEquals(token,responseUser.getToken());
    }

    @Test
    @DisplayName("Безуспешная авторизация")
    void loginUnsuccessfulTest(){
        User user = new User();
        user.setEmail("peter@klaven");

        Response response =
                given()
                        .spec(request)
                        .body(user)
                        .when()
                        .post("/login")
                        .then()
                        .spec(response400)
                        .log().body()
                        .extract().response();

        String message = "Missing password";
        assertEquals(message,response.path("error"));
    }
}
