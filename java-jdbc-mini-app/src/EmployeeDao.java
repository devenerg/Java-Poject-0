import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
    void addEmployee(Employee employee) throws SQLException;
    void updateEmployee(Employee employee) throws SQLException;
    void deleteEmployee(int id) throws SQLException;
    List<Employee> getEmployees() throws SQLException;
    Employee getEmployeeById(int id) throws SQLException;

    void addUser(User user) throws SQLException;

    void addEUser(User user) throws SQLException;

    void updateUser(User user) throws SQLException;
    void deleteUser(int id) throws SQLException;
    List<User> getUser(int id) throws SQLException;

    List<User> getUsers() throws SQLException;

    User getUserById(int id) throws SQLException;
}