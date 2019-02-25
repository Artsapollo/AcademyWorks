package HW23;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Set;

public interface OfficeModelDao {

    Set<OfficeModel> getAllOffices() throws SQLException;

    Set<OfficeModel> getOfficeByCity(String city) throws SQLException;

    boolean insertOfficeModel(OfficeModel officeModel) throws SQLException;

    boolean updateOfficeModel(OfficeModel officeModel) throws SQLException;

    boolean deleteOfficeModel (BigDecimal office) throws SQLException;
}
