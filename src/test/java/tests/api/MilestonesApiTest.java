package tests.api;

import adapters.MilestoneAdapter;
import baseEntities.BaseApiGsonTest;
import io.restassured.response.Response;
import models.Milestone;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
public class MilestonesApiTest extends BaseApiGsonTest {
    //это CRUD test, нужно запускать сразу весь класс, поэтому для каждого метода выставлен приоретет
    private int milestoneID = 66; //milestoneID при старте теста обновляется.
    // Данное значение используется, чтоб иметь возможность запустить тесты отдельно.
    private int projectID;

    @Test (priority = 0)
    private void getMilestones() {
        MilestoneAdapter milestoneAdapter = new MilestoneAdapter();
        projectID = 1;

        milestoneAdapter.getMilestones(projectID);
    }

    @Test (priority = 1)
    private void getMilestone() {
        MilestoneAdapter milestoneAdapter = new MilestoneAdapter();

        Response response = milestoneAdapter.getMilestone(milestoneID);
    }

//    @Test (priority = 0)
//    private void addMilestone() {
//        MilestoneAdapter milestoneAdapter = new MilestoneAdapter();
//        projectID = 1;
//
//        Milestone expectedMilestone = new Milestone();
//        expectedMilestone.setName("Test");
//        expectedMilestone.setDescription("for test");
//        expectedMilestone.isCompleted();
//
//        Response response = milestoneAdapter.add(expectedMilestone, projectID);
//
//        assertThat(response.getBody().jsonPath().get("name"), equalTo(expectedMilestone.getName()));
//        milestoneID = response.getBody().jsonPath().get("id");
//    }

    @Test (priority = 1)
    private void updateMilestone() {
        MilestoneAdapter milestoneAdapter = new MilestoneAdapter();

        Milestone expectedMilestone = new Milestone();
        expectedMilestone.setName("UPDTest");

        Response response = milestoneAdapter.updateMilestone(milestoneID, expectedMilestone.getName());

        assertThat(response.getBody().jsonPath().get("name"), equalTo(expectedMilestone.getName()));
    }

    @Test (priority = 2)
    private void deleteMilestone() {
        MilestoneAdapter milestoneAdapter = new MilestoneAdapter();

        milestoneAdapter.deleteMilestone(milestoneID);

        System.out.println("Successfully deleted");
    }
}
