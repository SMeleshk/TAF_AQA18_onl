package tests.api;

import adapters.CaseAdapter;
import baseEntities.BaseApiGsonTest;
import models.Case;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CasesApiTest extends BaseApiGsonTest {
    //это CRUD test, нужно запускать сразу весь класс, поэтому для каждого метода выставлен приоретет
    private int caseID = 31; //caseID при старте теста обновляется.
    // Данное значение используется, чтоб иметь возможность запустить тесты отдельно.
    private int sectionID;

//    @Test (priority = 0)
//    private void addCase() {
//        CaseAdapter caseAdapter = new CaseAdapter();
//        sectionID = 1;
//
//        Case expectedCase = new Case();
//        expectedCase.setTitle("Test1");
//        expectedCase.setEstimate("2h");
//        expectedCase.setSection_id(1);
//        expectedCase.setPriority_id(1);
//
//        Case actualCase = caseAdapter.add(expectedCase, sectionID);
//
//        caseID = actualCase.getId();
//
//        System.out.println(actualCase);
//        Assert.assertEquals(actualCase, expectedCase);
//    }

    @Test(priority = 1)
    private void getCase() {
        CaseAdapter caseAdapter = new CaseAdapter();

        Case actualCase = caseAdapter.getCase(caseID);
    }

    @Test (priority = 1)
    private void updateCase() {
        CaseAdapter caseAdapter = new CaseAdapter();

        Case expectedCase = new Case();
        expectedCase.setEstimate("1h");
        expectedCase.setPriority_id(3);

        Case actualCase = caseAdapter.updateCase(caseID, expectedCase.getPriority_id(), expectedCase.getEstimate());

        Assert.assertEquals(actualCase.getEstimate(), expectedCase.getEstimate());
        Assert.assertEquals(actualCase.getPriority_id(), expectedCase.getPriority_id());
    }

    @Test (priority = 2)
    public void moveCasesToSection() {
        sectionID = 2;
        CaseAdapter caseAdapter = new CaseAdapter();

        Case expectedCase = new Case();
        expectedCase.setSuite_id(1);

        caseAdapter.moveCasesToSection(caseID, expectedCase.getSuite_id(), sectionID);
    }

    @Test (priority = 3)
    private void deleteCase() {
        CaseAdapter caseAdapter = new CaseAdapter();

        caseAdapter.deleteCase(caseID);

        System.out.println("Successfully deleted");
    }
}
