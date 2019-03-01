package lesson16;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class CRUDTemplateAbstract <T> {
    public boolean templateOperation(T t) throws SQLException {
        boolean result = false;
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionToDbPool.getConnection();

            statement = returnPrepareStatement(t, connection);

            result = statement.executeUpdate() > 0;

        } finally {
            statement.close();
            connection.close();
        }
        return result;
    }

    public abstract PreparedStatement returnPrepareStatement(T t, Connection connection) throws SQLException;
}
