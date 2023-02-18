package adapters;

import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Milestone;
import org.apache.http.HttpStatus;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class MilestoneAdapter extends BaseAdapter{

    public Response add(Milestone milestone, int projectID) {

        return given()
                .body(milestone, ObjectMapperType.GSON)
                .log().body()
                .pathParam("project_id", projectID)
                .when()
                .post(Endpoints.ADD_MILESTONE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();
    }

    public void getMilestones(int projectID) {

        given()
                .pathParam("project_id", projectID)
                .get(Endpoints.GET_MILESTONES)
                .then()
                .assertThat()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    public Response getMilestone(int milestoneID) {

        return given()
                .pathParam("milestone_id", milestoneID)
                .get(Endpoints.GET_MILESTONE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();
    }

    public Response updateMilestone(int milestoneID, String name) {

        return given()
                .body(String.format("{\n" +
                                "  \"name\": \"%s\"\n" +
                                "}",

                        name
                ))

                .pathParam("milestone_id", milestoneID)
                .post(Endpoints.UPDATE_MILESTONE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();
    }

    public void deleteMilestone(int milestoneID) {

        given()
                .body("{}")
                .pathParam("milestone_id", milestoneID)
                .post(Endpoints.DELETE_MILESTONE)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
