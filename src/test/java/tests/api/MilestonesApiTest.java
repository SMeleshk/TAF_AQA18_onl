package tests.api;

import baseEntities.BaseApiGsonTest;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Milestone;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
public class MilestonesApiTest extends BaseApiGsonTest {

    private int milestoneID = 1;
    private int projectID;

    @Test (priority = 0)
    private void getMilestones() {
        String endpoint = "index.php?/api/v2/get_milestones/{project_id}";
        projectID = 1;
        given()
                .pathParam("project_id", projectID)
                .get(endpoint)
                .then()
                .assertThat()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract();
    }

    @Test (priority = 1)
    private void getMilestone() {
        String endpoint = "index.php?/api/v2/get_milestone/{milestone_id}";
        given()
                .pathParam("milestone_id", milestoneID)
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract();
    }

    @Test (priority = 0)
    private void addMilestone() {
        String endpoint = "index.php?/api/v2/add_milestone/{project_id}";
        projectID = 1;

        Milestone expectedMilestone = new Milestone();
        expectedMilestone.setName("Test");
        expectedMilestone.setDescription("for test");
        expectedMilestone.isCompleted();

        Response response = given()
                .body(expectedMilestone, ObjectMapperType.GSON)
                .log().body()
                .pathParam("project_id", projectID)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        assertThat(response.getBody().jsonPath().get("name"), equalTo(expectedMilestone.getName()));
        milestoneID = response.getBody().jsonPath().get("id");
    }

    @Test (priority = 1)
    private void updateMilestone() {
        String endpoint = "index.php?/api/v2/update_milestone/{milestone_id}";

        Milestone expectedMilestone = new Milestone();
        expectedMilestone.setName("UPDTest");

        Response response = given()
                .body(String.format("{\n" +
                                "  \"name\": \"%s\"\n" +
                                "}",

                        expectedMilestone.getName()
                ))

                .pathParam("milestone_id", milestoneID)
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        assertThat(response.getBody().jsonPath().get("name"), equalTo(expectedMilestone.getName()));
    }

    @Test (priority = 2)
    private void deleteMilestone() {
        String endpoint = "index.php?/api/v2/delete_milestone/{milestone_id}";

        given()
                .body("{}")
                .pathParam("milestone_id", milestoneID)
                .post(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract();

        System.out.println("Successfully deleted");
    }



}
