package Lesson16;

import org.junit.Test;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Set;

import static junit.framework.TestCase.assertTrue;

public class OfficeDaoImplIntegrationTest {
    public OfficeDao officeDao = new OfficeDaoImpl();

    @Test
    public void getAllOffices() throws SQLException {
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

    @Test
    public void testInsertOffice() throws SQLException {
        assertTrue(officeDao.insertOffice(new Office(new BigDecimal(440), "Киев", "Центр", null,
                new BigDecimal(333), 44.258)));
    }

    @Test
    public void testUpdateOffice() throws SQLException {
        assertTrue(officeDao.updateOffice(new Office(new BigDecimal(440), "Киевский", "Спорт",
                null, null, 11.400)));
    }

    @Test
    public void testDeleteOffice() throws SQLException {
        assertTrue(officeDao.deleteOffice(new BigDecimal(440)));
    }
}
