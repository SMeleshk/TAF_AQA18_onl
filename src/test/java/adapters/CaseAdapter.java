package adapters;

import io.restassured.mapper.ObjectMapperType;
import models.Case;
import models.CaseBuilder;
import org.apache.http.HttpStatus;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class CaseAdapter extends BaseAdapter{

    public CaseBuilder add(CaseBuilder theCase, int sectionID) {

        return given()
                .body(theCase, ObjectMapperType.GSON)
                .log().body()
                .pathParam("section_id", sectionID)
                .when()
                .post(Endpoints.ADD_CASE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(CaseBuilder.class);
    }

       public Case getCase(int caseID) {

           return given()
                   .pathParam("case_id", caseID)
                   .get(Endpoints.GET_CASE)
                   .then()
                   .assertThat()
                   .log().body()
                   .statusCode(HttpStatus.SC_OK)
                   .extract()
                   .as(Case.class);
    }

       public Case updateCase(int caseID, int priorityID, String estimate) {

           return given()
                   .body(String.format("{\n" +
                                   "  \"priority_id\" : %d,\n" +
                                   "  \"estimate\": \"%s\"\n" +
                                   "}",

                           priorityID,
                           estimate
                   ))
                   .pathParam("case_id", caseID)
                   .post(Endpoints.UPDATE_CASE)
                   .then()
                   .log().body()
                   .statusCode(HttpStatus.SC_OK)
                   .extract()
                   .as(Case.class);
    }

       public void moveCasesToSection(int caseID, int suiteID, int sectionID) {

           given()
               .body(String.format("{\n" +
                               "  \"suite_id\" : %d,\n" +
                               "  \"case_ids\": [%d]\n" +
                               "}",

                       suiteID,
                       caseID
               ))
               .pathParam("section_id", sectionID)
               .post(Endpoints.MOVE_CASES_TO_SECTION)
               .then()
               .log().body()
               .statusCode(HttpStatus.SC_OK);
    }

       public void deleteCase(int caseID) {

           given()
                   .body("{}")
                   .pathParam("case_id", caseID)
                   .post(Endpoints.DELETE_CASE)
                   .then()
                   .statusCode(HttpStatus.SC_OK);
    }
}
