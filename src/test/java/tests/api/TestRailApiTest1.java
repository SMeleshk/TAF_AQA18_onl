package tests.api;

import baseEntities.BaseApiTest;
import io.restassured.mapper.ObjectMapperType;
import models.Project;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TestRailApiTest1 extends BaseApiTest {

    @Test
    public void addProject1() {
        String endpoint = "index.php?/api/v2/add_project";

        Project expectedProject = new Project();
        expectedProject.setName("WP_Proj_01");
        expectedProject.setAnnouncement("description");
        expectedProject.setType(1);
        expectedProject.setShowAnnouncement(true);

        given()
                .body(String.format("{\n" +
                        "  \"name\": \"%s\",\n" +
                        "  \"announcement\": \"%s\",\n" +
                        "  \"show_announcement\": %b,\n" +
                        "  \"suite_mode\" : %d\n" +
                        "}",

        expectedProject.getName(),
                expectedProject.getAnnouncement(),
                expectedProject.isShowAnnouncement(),
                expectedProject.getType()
                ))
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }


    @Test
    public void addProject2() {
        String endpoint = "index.php?/api/v2/add_project";

        Project expectedProject = new Project();
        expectedProject.setName("WP_Proj_20");
        expectedProject.setAnnouncement("description");
        expectedProject.setType(1);
        expectedProject.setShowAnnouncement(true);

        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("name", expectedProject.getName());
        jsonMap.put("suite_mode", expectedProject.getType());


        given()
                .body(jsonMap)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }


    @Test
    public void addProject3() {
        String endpoint = "index.php?/api/v2/add_project";

        Project expectedProject = new Project();
        expectedProject.setName("WP_Proj_29");
        expectedProject.setAnnouncement("description");
        expectedProject.setType(1);
        expectedProject.setShowAnnouncement(true);



        given()
                .body(expectedProject, ObjectMapperType.GSON)
                //!!!но тут важно, чтоб поля имели правильное название
                //для этого @SerialisedName перед полями в классе объекта (show_announcement, например)
                .log().body()
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }


}
