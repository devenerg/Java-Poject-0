import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    void addUser(User user) throws SQLException;

    void addEUser(User user) throws SQLException;

    void updateUser(User user) throws SQLException;
    void deleteUser(int id) throws SQLException;
    List<User> getUser(int id) throws SQLException;

    List<User> getUsers() throws SQLException;

    User getUserById(int id) throws SQLException;
}