package tests.api;

import baseEntities.BaseApiGsonTest;
import io.restassured.mapper.ObjectMapperType;
import models.Case;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CasesApiTest extends BaseApiGsonTest {
    private int caseID = 31;
    private int sectionID;

    @Test (priority = 0)
    private void addCase() {
        String endpoint = "index.php?/api/v2/add_case/{section_id}";
        sectionID = 1;

        Case expectedCase = new Case();
        expectedCase.setTitle("Test1");
        expectedCase.setEstimate("2h");
        expectedCase.setSection_id(1);
        expectedCase.setPriority_id(1);

        Case actualCase = given()
                .body(expectedCase, ObjectMapperType.GSON)
                .log().body()
                .pathParam("section_id", sectionID)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Case.class);

        caseID = actualCase.getId();

        System.out.println(actualCase);
        Assert.assertEquals(actualCase, expectedCase);
    }

    @Test(priority = 1)
    private void getCase() {
        String endpoint = "index.php?/api/v2/get_case/{case_id}";

        given()
                .pathParam("case_id", caseID)
                .get(endpoint)
                .then()
                .assertThat()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract();
    }

    @Test (priority = 1)
    private void updateCase() {
        String endpoint = "index.php?/api/v2/update_case/{case_id}";

        Case expectedCase = new Case();
        expectedCase.setEstimate("1h");
        expectedCase.setPriority_id(3);

        Case actualCase = given()
                .body(String.format("{\n" +
                                "  \"priority_id\" : %d,\n" +
                                "  \"estimate\": \"%s\"\n" +
                                "}",

                        expectedCase.getPriority_id(),
                        expectedCase.getEstimate()
                ))
                .pathParam("case_id", caseID)
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Case.class);

        Assert.assertEquals(actualCase.getEstimate(), expectedCase.getEstimate());
        Assert.assertEquals(actualCase.getPriority_id(), expectedCase.getPriority_id());
    }

    @Test (priority = 2)
    public void moveCasesToSection() {
        String endpoint = "index.php?/api/v2/move_cases_to_section/{section_id}";
        sectionID = 2;

        Case expectedCase = new Case();
        expectedCase.setSuite_id(1);

        given()
                .body(String.format("{\n" +
                                "  \"suite_id\" : %d,\n" +
                                "  \"case_ids\": [%d]\n" +
                                "}",

                        expectedCase.getSuite_id(),
                        caseID
                ))
                .pathParam("section_id", sectionID)
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract();
    }


    @Test (priority = 3)
    private void deleteCase() {
        String endpoint = "index.php?/api/v2/delete_case/{case_id}";

        given()
                .body("{}")
                .pathParam("case_id", caseID)
                .post(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract();

        System.out.println("Successfully deleted");
    }

}
