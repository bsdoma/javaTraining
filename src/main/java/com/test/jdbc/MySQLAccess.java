package com.test.jdbc;


import java.sql.*;
import java.util.ArrayList;
import java.util.TimeZone;
import java.util.*;

public class MySQLAccess {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    static {
        List<Connection> connections = new ArrayList<>();
       // connections.add(createConnection())

    }



    public void readDataBase() throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/javatraining?serverTimezone=" + TimeZone.getDefault().getID(), "root", "bsdoma@05");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement
                    .executeQuery("select * from javatraining.Employee");
            writeResultSet(resultSet);

            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect
                    .prepareStatement("insert into  javatraining.Employee values (?, ?, ?, ?)");
            // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
            // Parameters start with 1
            preparedStatement.setString(1, "105");
            preparedStatement.setString(2, "Employee1");
            preparedStatement.setString(3, "Female");
            preparedStatement.setString(4, "80000");

            preparedStatement.executeUpdate();

            preparedStatement = connect
                    .prepareStatement("SELECT emp_id, emp_name, sex, salary from javatraining.Employee");
            resultSet = preparedStatement.executeQuery();
            writeResultSet(resultSet);

            // Remove again the insert comment
            preparedStatement = connect
                    .prepareStatement("delete from javatraining.Employee where emp_id= ? ; ");
            preparedStatement.setString(1, "Test");
            preparedStatement.executeUpdate();

            resultSet = statement
                    .executeQuery("select * from javatraining.Employee");
            writeMetaData(resultSet);

            invokeStoredProcedure();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            close();
        }

    }

    private void writeMetaData(ResultSet resultSet) throws SQLException {


        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
            System.out.println("Column " + i + " " + resultSet.getMetaData().getColumnName(i));
        }
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            String empId = resultSet.getString("emp_id");
            String empName = resultSet.getString("emp_name");
            String sex = resultSet.getString("sex");
            String salary = resultSet.getString("salary");
            System.out.println("empId: " + empId);
            System.out.println("empName: " + empName);
            System.out.println("sex: " + sex);
            System.out.println("salary: " + salary);
        }
    }

    private void invokeStoredProcedure() throws  SQLException{
        String query = "{CALL SP_GETMESSAGE()}";
        CallableStatement stmt = connect.prepareCall(query);
        resultSet = stmt.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
        }

    }

    // You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        try {
            MySQLAccess dao = new MySQLAccess();
            dao.readDataBase();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}