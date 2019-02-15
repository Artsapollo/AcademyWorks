package Lesson16;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Set;

public interface OfficeDao {
    Set<Office> getAllOffices() throws SQLException;

    Set<Office> getOfficeByCity(String city) throws SQLException;

    boolean insertOffice(Office office) throws SQLException;

    boolean updateOffice(Office office) throws SQLException;

    boolean deleteOffice (BigDecimal id) throws SQLException;
}
