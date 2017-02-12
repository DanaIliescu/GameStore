package game_store.DataAccessLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import game_store.ApplicationLayer.dataTypes.Employee;

// Class to receive data from and write in database, employees table

public class EmployeeSQL {
    private static ArrayList<Employee> employees = new ArrayList<Employee>();

    public static List<Employee> loadAllEmployees() throws Exception {   // receive data from database, put in array
        Connection con = MySqlConnection.getConnection();
        Statement st = con.createStatement();
        String sql = ("SELECT * FROM employees");
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            int employee_id = rs.getInt("employee_id");
            String employee_first_name = rs.getString("employee_first_name");
            String employee_last_name = rs.getString("employee_last_name");
            String employee_password = rs.getString("employee_password");
            employees.add(new Employee(employee_id, employee_first_name, employee_last_name, employee_password));
        }

        con.close();
        rs.close();
        st.close();


        return employees;
    }

    public static void createEmployee(Employee employee) {
        // write employee to the database
    }
}

