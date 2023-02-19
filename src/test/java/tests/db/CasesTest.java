package tests.db;

import adapters.CaseAdapter;
import baseEntities.BaseApiTest;
import dbTables.CasesTable;
import models.CaseBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CasesTest extends BaseApiTest {
    private int caseID;

    @BeforeTest
    public void createTable() {
        CasesTable table = new CasesTable(dbService);
        table.createTable();

        CaseBuilder expectedCase = CaseBuilder.builder()
                .title("DataBaseTest")
                .estimate("2h")
                .priority_id(1)
                .section_id(1)
                .suite_id(1)
                .build();

        table.addCase(expectedCase);
    }

    @AfterTest
    public void dropTable() {
        CasesTable table = new CasesTable(dbService);
        table.dropTable();
    }

    @Test
    public void addCase() throws SQLException {
        CaseAdapter caseAdapter = new CaseAdapter();
        CasesTable casesTable = new CasesTable(dbService);

        ResultSet rs = casesTable.getCaseById(1);
        rs.next();

        CaseBuilder expectedCase = CaseBuilder.builder()
                .title(rs.getString("title"))
                .estimate(rs.getString("estimate"))
                .priority_id(rs.getInt("priority_id"))
                .suite_id(rs.getInt("suite_id"))
                .build();

        CaseBuilder actualCase = caseAdapter.add(expectedCase, rs.getInt("section_id"));

        caseID = actualCase.getId();

        System.out.println(actualCase);
        Assert.assertEquals(actualCase, expectedCase);
    }
}
