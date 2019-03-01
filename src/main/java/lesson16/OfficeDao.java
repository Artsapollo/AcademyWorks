package lesson16;

import java.sql.SQLException;
import java.util.Set;

public interface OfficeDao {
    Set<Office> getAllOffices() throws SQLException;

    Set<Office>  getOfficeByCity(String city) throws SQLException;

    boolean insertOffice(Office office) throws SQLException;

    boolean updateOffice(Office office) throws SQLException;

    boolean deleteOffice (Office office) throws SQLException;
}
