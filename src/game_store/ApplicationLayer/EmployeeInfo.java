package game_store.ApplicationLayer;

import game_store.ApplicationLayer.dataTypes.Employee;
import game_store.DataAccessLayer.*;

import java.util.List;

public class EmployeeInfo {
    private static List<Employee> employees;
    Employee employee;

    public static List<Employee> selectAllEmployees() throws Exception
    {
        employees = EmployeeSQL.loadAllEmployees();
        return employees;
    }

    public void createEmployee(Employee e)
    {
        employee = e;
        EmployeeSQL.createEmployee(employee);
    }
}
