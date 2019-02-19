package Lesson16;

import java.sql.SQLException;
import java.util.Set;

public interface OfficeDao {

    boolean insertOffice(Office office) throws SQLException;

    boolean updateOffice(Office office) throws SQLException;

    boolean deleteOffice (Office office) throws SQLException;
}
