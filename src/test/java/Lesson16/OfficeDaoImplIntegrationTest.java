package Lesson16;

import org.junit.Test;

import java.sql.SQLException;
import java.util.Set;

import static junit.framework.TestCase.assertTrue;

public class OfficeDaoImplIntegrationTest {
    public OfficeDao officeDao = new OfficeDaoImpl();

    @Test
    public void getAllOffices() throws SQLException{
        Set<Office> offices = officeDao.getAllOffices();
        System.out.println(offices);
        assertTrue(offices.size() != 0);
    }

    @Test
    public void testFindOfficeByCity() throws SQLException {
        Set<Office> office = officeDao.getOfficeByCity("Бубурино");
        System.out.println(office);
        assertTrue(office.size() != 0);
    }
}
