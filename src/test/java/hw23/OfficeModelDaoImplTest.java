package hw23;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;
import java.sql.SQLException;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.JVM)
public class OfficeModelDaoImplTest {
    private OfficeModelDao officeModelDao = new OfficeModelDaoImpl();
    private static final OfficeModel officeModel = new OfficeModel(new BigDecimal(440), "Киев", "Центр", null,
            new BigDecimal(333), 44.258);

    @Test
    public void testInsertOfficeModel() throws SQLException {
        assertTrue(officeModelDao.insertOfficeModel(officeModel));
    }

    @Test
    public void testUpdateOfficeModel() throws SQLException {
        assertTrue(officeModelDao.updateOfficeModel(new OfficeModel(new BigDecimal(440), "Киевский", "Спорт",
                null, null, 11.400)));
    }

    @Test
    public void testDeleteOfficeModel() throws SQLException {
        assertTrue(officeModelDao.deleteOfficeModel(new BigDecimal(440)));
    }
}