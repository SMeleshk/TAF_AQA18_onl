package dbTables;

import models.MilestoneBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.DataBaseService;

import java.sql.ResultSet;
public class MilestonesTable {
    Logger logger = LogManager.getLogger(MilestonesTable.class);
    private DataBaseService dbService;

    public MilestonesTable(DataBaseService dbService) {
        this.dbService = dbService;
    }

    public void createTable() {
        logger.info("Creating Milestones table");

        String createTableSQL = "" +
                "create table public.milestones " +
                "(id SERIAL PRIMARY KEY," +
                "    name CHARACTER VARYING(30)," +
                "    refs CHARACTER VARYING(30)," +
                "    description CHARACTER VARYING(30)," +
                "    is_completed BOOLEAN" +
                ");";

        dbService.executeSQL(createTableSQL);
    }

    public void dropTable() {
        logger.info("Deleting Milestones table");

        String dropTableSQL = "DROP TABLE public.milestones;";

        dbService.executeSQL(dropTableSQL);
    }

    public ResultSet getMilestones() {
        String sql = "SELECT * FROM public.milestones;";

        return dbService.executeQuery(sql);
    }

    public ResultSet getMilestoneById(int id) {
        String sql = "SELECT * FROM public.milestones WHERE id = " + id + ";";

        return dbService.executeQuery(sql);
    }

    public void addMilestone(MilestoneBuilder milestone) {

        String insertTableSQL = "INSERT INTO public.milestones(" +
                "name, refs, description, is_completed)" +
                "VALUES ('" + milestone.getName() + "', '" + milestone.getRefs() +
                "', '" + milestone.getDescription() + "', " + milestone.is_completed() +
                ");";

        dbService.executeSQL(insertTableSQL);
    }

    public void updateMilestone(int id, MilestoneBuilder milestone) {

        String updateMilestone = "UPDATE public.milestones SET name = '" + milestone.getName() +
                "', refs = '" + milestone.getRefs() +
                "', description = '" + milestone.getDescription() +
                "', is_completed = " + milestone.is_completed() +
                " WHERE id=" + id + ";";

        dbService.executeSQL(updateMilestone);
    }

    public void deleteMilestone(int id) {
        String deleteMilestone = "DELETE FROM public.milestones " +
                "WHERE id = " + id + ";";

        dbService.executeSQL(deleteMilestone);
    }
}
