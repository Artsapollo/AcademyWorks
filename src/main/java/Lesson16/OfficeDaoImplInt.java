package Lesson16;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

public class OfficeDaoImplInt implements OfficeDao{

    @Override
    public Set<Office> getAllOffices() throws SQLException {
        return null;
    }

    @Override
    public Set<Office> getOfficeByCity(String city) throws SQLException {
        return null;
    }

    @Override
    public boolean insertOffice(Office office) throws SQLException {
        CRUDTemplateInterface<Office> templateInterface = (office1, connection)->{
            String sql = "insert into offices (office, city, region, target, sales) values (?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setBigDecimal(1, office.getOffice());
            statement.setString(2, office.getCity());
            statement.setString(3, office.getRegion());
            statement.setBigDecimal(4, office.getTarget());
            statement.setDouble(5, office.getSales());
            return statement;
        };
        return templateInterface.templateOperation(office);
    }

    @Override
    public boolean updateOffice(Office office) throws SQLException {
        CRUDTemplateInterface<Office> templateInterface = (office1, connection) -> {
            String sql = "update offices set city = ?, region = ?, sales = ? where office = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, office.getCity());
            statement.setString(2, office.getRegion());
            statement.setDouble(3, office.getSales());
            statement.setBigDecimal(4, office.getOffice());
            return statement;
        };
        return templateInterface.templateOperation(office);
    }

    @Override
    public boolean deleteOffice(Office office) throws SQLException {
        CRUDTemplateInterface<Office> templateInterface = (office1, connection)-> {
            String sql = "delete from offices where office = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setBigDecimal(1, office.getOffice());
            return statement;
        };
        return templateInterface.templateOperation(office);
    }
}
