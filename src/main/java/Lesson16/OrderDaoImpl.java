package Lesson16;

import java.math.BigDecimal;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class OrderDaoImpl implements OrderDao {

    @Override
    public Set<Order> getAllOrders() throws SQLException {
        Connection connection = ConnectionToDbPool.getConnection();
        Set<Order> orders = new HashSet<>();

        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM  orders");
        ResultSet rs = stmt.executeQuery();
        showMetadata(rs);

        while (rs.next()) {
            Order order = new Order(rs.getBigDecimal("order_Num"), null, rs.getDate("order_Date"), rs.getString("mfr"),
                    rs.getBigDecimal("qty"), rs.getBigDecimal("amount"));

            stmt = connection.prepareStatement("SELECT * FROM  products WHERE product_id=?");
            stmt.setString(1, rs.getString("PRODUCT"));
            ResultSet rsPr = stmt.executeQuery();
            while (rsPr.next()) {
                Product product = new Product(rsPr.getString("product_Id"),
                        rsPr.getString("mfr_Id"),
                        rsPr.getString("description"),
                        rsPr.getBigDecimal("price"),
                        rsPr.getBigDecimal("qty_On_Hand"));
                order.setProduct(product);
            }
            rsPr.close();
            orders.add(order);
        }

        rs.close();
        stmt.close();
        connection.close();
        return orders;
    }

    @Override
    public Set<Order> getAllOrdersWithJoin() throws SQLException {
        Set<Order> orderSet = new HashSet<>();
        Connection connection = ConnectionToDbPool.getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from orders inner join products on product = product_id");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Product product = new Product(resultSet.getString("MFR_ID"), resultSet.getString("PRODUCT_ID"),
                    resultSet.getString("DESCRIPTION"), resultSet.getBigDecimal("PRICE"),
                    resultSet.getBigDecimal("QTY_ON_HAND"));

            Order order = new Order(resultSet.getBigDecimal("ORDER_NUM"),
                    product,
                    resultSet.getDate("ORDER_DATE"),
                    resultSet.getString("MFR"),
                    resultSet.getBigDecimal("QTY"),
                    resultSet.getBigDecimal("AMOUNT"));
            order.setProduct(product);
            orderSet.add(order);
        }
        resultSet.close();
        statement.close();
        connection.close();

        return orderSet;
    }

    public Order findOrderById(BigDecimal id) throws SQLException {
        Connection connection = ConnectionToDbPool.getConnection();
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM orders WHERE order_Num = ?");
        stm.setBigDecimal(1, id);
        ResultSet rs = stm.executeQuery();
        showMetadata(rs);
        Order order = null;
        if (rs.next()) {
            order = new Order(rs.getBigDecimal("order_Num"), null, rs.getDate("order_Date"), rs.getString("mfr"),
                    rs.getBigDecimal("qty"), rs.getBigDecimal("amount"));
        }
        rs.close();
        stm.close();
        connection.close();
        return order;
    }

    private void showMetadata(ResultSet rs) throws SQLException {
        ResultSetMetaData resultSetMetaData = rs.getMetaData();
        int columnCount = resultSetMetaData.getColumnCount();
        for (int i = 1; i <= columnCount; ++i) {
            System.out.println("---------------------");
            System.out.print("Column Name : " + resultSetMetaData.getColumnLabel(i) + " \n");
            System.out.print("Column Type : " + resultSetMetaData.getColumnType(i) + " \n");
            System.out.print("Column Class Name : " + resultSetMetaData.getColumnClassName(i) + " \n");
            System.out.print("Column Type Name :" + resultSetMetaData.getColumnTypeName(i) + " \n");
        }
    }


    @Override
    public boolean insertOrder(Order order) throws SQLException {
        boolean result = false;
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionToDbPool.getConnection();
            String sql = "insert into orders (order_num, mfr, qty) values (?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setBigDecimal(1, order.getOrderNum());
            statement.setString(2, order.getMfr());
            statement.setBigDecimal(3, order.getQty());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                result = true;
            }
        } finally {
            statement.close();
            connection.close();
        }
        return result;
    }

    @Override
    public boolean updateOrder(Order order) throws SQLException {
        boolean result = false;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionToDbPool.getConnection();
            String sql = "UPDATE orders SET qty=?, amount=?  WHERE order_num=?";
            statement = connection.prepareStatement(sql);
            statement.setBigDecimal(1, order.getQty());
            statement.setBigDecimal(2, order.getAmount());
            statement.setBigDecimal(3, order.getOrderNum());
            statement.executeUpdate();

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                result = true;
            }
        } finally {
            statement.close();
            connection.close();
        }

        return result;

    }

    @Override
    public boolean deleteOrder(BigDecimal id) throws SQLException {
        boolean result = false;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionToDbPool.getConnection();
            String sql = "DELETE orders WHERE order_num=?";
            statement = connection.prepareStatement(sql);
            statement.setBigDecimal(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                result = true;
            }
        } finally {
            statement.close();
            connection.close();
        }
        return result;
    }
}
