package dbTables;

import models.CustomerBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.DataBaseService;

import java.sql.ResultSet;

public class CustomersTable {
    Logger logger = LogManager.getLogger(CustomersTable.class);
    private DataBaseService dbService;

    public CustomersTable(DataBaseService dbService) {
        this.dbService = dbService;
    }

    public void createTable() {
        logger.info("Creating Customers table");

        String createTableSQL = "" +
                "create table public.customers " +
                "(id SERIAL PRIMARY KEY," +
                "    firstname CHARACTER VARYING(30)," +
                "    lastname CHARACTER VARYING(30)," +
                "    email CHARACTER VARYING(30)," +
                "    age INTEGER" +
                ");";

        dbService.executeSQL(createTableSQL);
    }

    public void dropTable() {
        logger.info("Deleting Customers table");

        String dropTableSQL = "DROP TABLE public.customers;";

        dbService.executeSQL(dropTableSQL);
    }

    public ResultSet getCustomers() {
        String sql = "SELECT * FROM public.customers;";

        return dbService.executeQuery(sql);
    }

    public ResultSet getCustomerById(int id) {
        String sql = "SELECT * FROM public.customers WHERE id = " + id + ";";

        return dbService.executeQuery(sql);
    }

    public void addCustomer(CustomerBuilder customer) {

        String insertTableSQL = "INSERT INTO public.customers(" +
                "firstname, lastname, email, age)" +
                "VALUES ('" + customer.getFirstname() + "', '" + customer.getLastname() +
                "', '" + customer.getEmail() + "', " + customer.getAge() + ");";

        dbService.executeSQL(insertTableSQL);
    }

    public void updateCustomer(CustomerBuilder customer) {

    }

    public void deleteCustomer(int id) {

    }


}
