package dbTables;

import models.CaseBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.DataBaseService;

import java.sql.ResultSet;
public class CasesTable {

    Logger logger = LogManager.getLogger(CasesTable.class);
    private DataBaseService dbService;

    public CasesTable(DataBaseService dbService) {
        this.dbService = dbService;
    }

    public void createTable() {
        logger.info("Creating Cases table");

        String createTableSQL = "" +
                "create table public.cases " +
                "(id SERIAL PRIMARY KEY," +
                "    title CHARACTER VARYING(30)," +
                "    estimate CHARACTER VARYING(30)," +
                "    priority_id INTEGER," +
                "    section_id INTEGER," +
                "    suite_id INTEGER" +
                ");";

        dbService.executeSQL(createTableSQL);
    }

    public void dropTable() {
        logger.info("Deleting Cases table");

        String dropTableSQL = "DROP TABLE public.cases;";

        dbService.executeSQL(dropTableSQL);
    }

    public ResultSet getCases() {
        String sql = "SELECT * FROM public.cases;";

        return dbService.executeQuery(sql);
    }

    public ResultSet getCaseById(int id) {
        String sql = "SELECT * FROM public.cases WHERE id = " + id + ";";

        return dbService.executeQuery(sql);
    }

    public void addCase(CaseBuilder theCase) {

        String insertTableSQL = "INSERT INTO public.cases(" +
                "title, estimate, priority_id, section_id, suite_id)" +
                "VALUES ('" + theCase.getTitle() + "', '" + theCase.getEstimate() +
                "', " + theCase.getPriority_id() + ", " + theCase.getSection_id() +
                ", " + theCase.getSuite_id() + ");";

        dbService.executeSQL(insertTableSQL);
    }

    public void updateCase(int id, CaseBuilder theCase) {

        String updateCase = "UPDATE public.cases SET title = '" + theCase.getTitle() +
                "', estimate = '" + theCase.getEstimate() +
                "', priority_id = " + theCase.getPriority_id() +
                ", section_id = " + theCase.getSection_id() +
                ", suite_id =" + theCase.getSuite_id() +
        " WHERE id=" + id + ";";

        dbService.executeSQL(updateCase);
    }

    public void deleteCase(int id) {
        String deleteCase = "DELETE FROM public.cases " +
                "WHERE id = " + id + ";";

        dbService.executeSQL(deleteCase);
    }
}
