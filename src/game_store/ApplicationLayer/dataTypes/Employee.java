package game_store.ApplicationLayer.dataTypes;

/**
 * Created by Dana on 27-Apr-16.
 */
public class Employee {
    private int employee_id;
    private String employee_first_name;
    private String employee_last_name;
    private String employee_password;

    public Employee(int employee_id, String employee_first_name, String employee_last_name, String employee_password) {
        this.employee_id = employee_id;
        this.employee_first_name = employee_first_name;
        this.employee_last_name = employee_last_name;
        this.employee_password = employee_password;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_first_name() {
        return employee_first_name;
    }

    public void setEmployee_first_name(String employee_first_name) {
        this.employee_first_name = employee_first_name;
    }

    public String getEmployee_last_name() {
        return employee_last_name;
    }

    public void setEmployee_last_name(String employee_last_name) {
        this.employee_last_name = employee_last_name;
    }

    public String getEmployee_password()
    {
        return employee_password;
    }

    public void setEmployee_password(String employee_password)
    {
        this.employee_password = employee_password;
    }
}
