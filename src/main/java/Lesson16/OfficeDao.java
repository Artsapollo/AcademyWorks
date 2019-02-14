package Lesson16;

import java.sql.SQLException;
import java.util.Set;

public interface OfficeDao {
    Set<Office> getAllOffices() throws SQLException;

    Set<Office> getOfficeByCity(String city) throws SQLException;
}
