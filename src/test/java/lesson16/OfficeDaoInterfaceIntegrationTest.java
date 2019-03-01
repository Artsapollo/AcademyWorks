package lesson16;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;
import java.sql.SQLException;

import static junit.framework.TestCase.assertTrue;

@FixMethodOrder(MethodSorters.JVM)
public class OfficeDaoInterfaceIntegrationTest {
    private OfficeDaoImplInt officeDao = new OfficeDaoImplInt();
    private static final Office office = new Office(new BigDecimal(440), "Киев", "Центр", null,
            new BigDecimal(333), 44.258);

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
        assertTrue(officeDao.deleteOffice(office));
    }

}