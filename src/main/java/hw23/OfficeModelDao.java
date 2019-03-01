package hw23;

import java.math.BigDecimal;
import java.util.Set;

public interface OfficeModelDao {

    Set<OfficeModel> getAllOffices();

    Set<OfficeModel> getOfficeByCity(String city);

    boolean insertOfficeModel(OfficeModel officeModel);

    boolean updateOfficeModel(OfficeModel officeModel);

    boolean deleteOfficeModel (BigDecimal office);
}
