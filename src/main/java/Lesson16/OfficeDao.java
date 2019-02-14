package Lesson16;

import java.sql.SQLException;
import java.util.Set;

public interface OfficeDao {
    Set<Office> getAllOffices() throws SQLException;

    Office getOfficeByCity(String city) throws SQLException;
}
