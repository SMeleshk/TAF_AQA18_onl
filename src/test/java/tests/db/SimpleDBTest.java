package tests.db;

import baseEntities.BaseApiTest;
import dbServices.CustomerService;
import dbTables.CustomersTable;
import models.Customer;
import models.CustomerBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SimpleDBTest extends BaseApiTest {

    Logger logger = LogManager.getLogger(SimpleDBTest.class);

    @Test
    public void simpleTest() {
        String sql = "SELECT * FROM public.customers;";
        ResultSet rs = dbService.executeQuery(sql);

        try {
            while (rs.next()) { //циклом перебираем все записи
            int userID = rs.getInt("id");
            String firstname = rs.getString("firstname");
            String lastname = rs.getString("lastname");
            String email = rs.getString("email");
            int age = rs.getInt(5);

            logger.info("ID: " + userID);
            logger.info("Firstname: " + firstname);
            logger.info("Lastname: " + lastname);
            logger.info("email: " + email);
            logger.info("Age: " + age);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void advancedDBTest() throws SQLException {
        CustomersTable customersTable = new CustomersTable(dbService);

        customersTable.dropTable();
        customersTable.createTable();

        customersTable.addCustomer(CustomerBuilder.builder()
                        .firstname("Sveta")
                        .lastname("Meleshko")
                        .id(1)
                        .age(26)
                        .email("sveta@gmail.com")
                .build());

        customersTable.addCustomer(CustomerBuilder.builder()
                        .firstname("Masha")
                        .lastname("Ivanova")
                        .id(2)
                        .age(13)
                        .email("test@gmail.com")
                .build());

        ResultSet rs = customersTable.getCustomers();

        try {
            while (rs.next()) {
                int userID = rs.getInt("id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                int age = rs.getInt(5);

                logger.info("ID: " + userID);
                logger.info("Firstname: " + firstname);
                logger.info("Lastname: " + lastname);
                logger.info("email: " + email);
                logger.info("Age: " + age);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        rs = customersTable.getCustomerById(2);
        rs.next();

        logger.info("ID: " + rs.getString("id"));
        logger.info("Firstname: " + rs.getString("firstname"));
        logger.info("Lastname: " + rs.getString("lastname"));
        logger.info("email: " + rs.getString("email"));
        logger.info("Age: " + rs.getString("age"));

    }

    @Test
    public void hibernateTest() {
        CustomerService customerService = new CustomerService();
        Customer customer = new Customer("Ivan", "Grigoriev", "grtest@test.com", 30);

        customerService.saveUser(customer);

        List<Customer> customerList = customerService.findAllUsers();
        for (Customer user : customerList) {
            System.out.println(user.toString());
        }
    }
}
