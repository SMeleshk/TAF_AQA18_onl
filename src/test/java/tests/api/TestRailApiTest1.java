package tests.api;

import adapters.ProjectAdapter;
import baseEntities.BaseApiTest;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Project;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TestRailApiTest1 extends BaseApiTest {
    int projectID;
    Project expectedProject;

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

    @Test
    public void addProject3_1() {
        ProjectAdapter projectAdapter = new ProjectAdapter();

        Project expectedProject = new Project();
        expectedProject.setName("WP_Project_03");
        expectedProject.setAnnouncement("This is a description!!!");
        expectedProject.setType(1);
        expectedProject.setShowAnnouncement(true);

        Project actualProject = projectAdapter.add(expectedProject);
        Assert.assertEquals(actualProject, expectedProject);
    }

    @Test
    public void addProject4() {
        String endpoint = "index.php?/api/v2/add_project";

        expectedProject = new Project();
        expectedProject.setName("WP_Proj_48");
        expectedProject.setAnnouncement("description");
        expectedProject.setType(1);
        expectedProject.setShowAnnouncement(true);

        int projectID = given()
                .body(expectedProject, ObjectMapperType.GSON)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .jsonPath()
                .getInt("id"); //ТАК РАБОТАЕТ С ЕДИНИЧНЫМ ОБЪЕКТОМ, а не массивом

        System.out.println(projectID);
    }

    @Test
    public void addProject5() {
        String endpoint = "index.php?/api/v2/add_project";

        expectedProject = new Project();
        expectedProject.setName("WP_Proj_801");
        expectedProject.setAnnouncement("description");
        expectedProject.setType(1);
        expectedProject.setShowAnnouncement(true);

        Response response = given()
                .body(expectedProject, ObjectMapperType.GSON)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response(); //ТАК РАБОТАЕТ С ЕДИНИЧНЫМ ОБЪЕКТОМ, а не массивом

        projectID = response.getBody().jsonPath().get("id");

        Assert.assertEquals(response.getBody().jsonPath().getString("name"), expectedProject.getName());
    }

    @Test (dependsOnMethods = "addProject5")
    public void readProject() {
        String endpoint = "index.php?/api/v2/get_project/{project_id}";

        Response response = given()
                .pathParam("project_id", projectID)
                .log().body()
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("id", equalTo(projectID)) //когда не массив, то обращение сразу к id
                .body("name", is(expectedProject.getName())) //если массив, то "get(0).name"
                .extract().response();
    }



}
