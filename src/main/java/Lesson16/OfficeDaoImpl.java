package Lesson16;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class OfficeDaoImpl implements OfficeDao {

    @Override
    public Set<Office> getAllOffices() throws SQLException {
        Set<Office> officeSet = new HashSet<>();
        Connection connection = ConnectToDB.getConnection();
        PreparedStatement pst = connection.prepareStatement("select * from offices");
        ResultSet rs = pst.executeQuery();
        Office office = null;

        while (rs.next()) {
            office = new Office(rs.getString("office"), rs.getString("city"), rs.getString("region"),
                    rs.getBigDecimal("mgr"), rs.getBigDecimal("target"), rs.getDouble("sales"));
            officeSet.add(office);
        }

        rs.close();
        pst.close();
        connection.close();
        return officeSet;
    }

    @Override
    public Office getOfficeByCity(String city) throws SQLException {
        Connection connection = ConnectToDB.getConnection();
        PreparedStatement pst = connection.prepareStatement("select * from offices where city = ?");
        pst.setString(1, city);
        ResultSet rs = pst.executeQuery();

        Office office = null;
        if (rs.next()) {
            office = new Office(rs.getString("office"), rs.getString("city"), rs.getString("region"),
                    rs.getBigDecimal("mgr"), rs.getBigDecimal("target"), rs.getDouble("sales"));
        }
        rs.close();
        pst.close();
        connection.close();
        return office;
    }
}
