package tests.db;

import adapters.MilestoneAdapter;
import baseEntities.BaseApiTest;
import dbTables.MilestonesTable;
import io.restassured.response.Response;
import models.MilestoneBuilder;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MilestonesTest extends BaseApiTest {
    private int milestoneID;

    @BeforeTest
    public void createTable() {
        MilestonesTable table = new MilestonesTable(dbService);
        table.createTable();

        MilestoneBuilder expectedMilestone = MilestoneBuilder.builder()
                .name("DataBaseTest")
                .description("for test")
                .refs("reference")
                .is_completed(false)
                .build();

        table.addMilestone(expectedMilestone);
    }

    @AfterTest
    public void dropTable() {
        MilestonesTable table = new MilestonesTable(dbService);
        table.dropTable();
    }

    @Test
    public void addMilestone() throws SQLException {
        MilestoneAdapter milestoneAdapter = new MilestoneAdapter();
        MilestonesTable milestonesTable = new MilestonesTable(dbService);
        int projectID = 1;

        ResultSet rs = milestonesTable.getMilestoneById(1);
        rs.next();

        MilestoneBuilder expectedMilestone = MilestoneBuilder.builder()
                .name(rs.getString("name"))
                .description(rs.getString("description"))
                .refs(rs.getString("refs"))
                .is_completed(rs.getBoolean("is_completed"))
                .build();

        Response response = milestoneAdapter.add(expectedMilestone, projectID);

        assertThat(response.getBody().jsonPath().get("name"), equalTo(expectedMilestone.getName()));
        milestoneID = response.getBody().jsonPath().get("id");
    }
}