package ru.netology.rest;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.patch;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

class MobileBankApiTestV4 {
  @Test
  void shouldReturnDemoAccounts() {
    // Given - When - Then
    // Предусловия
    given()
            .baseUri("http://localhost:9999/api/v1")
            // Выполняемые действия
            .when()
            .get("/demo/accounts")
            // Проверки
            .then()
            .statusCode(200)
            .body(matchesJsonSchemaInClasspath("accounts.schema.json"));
  }
}