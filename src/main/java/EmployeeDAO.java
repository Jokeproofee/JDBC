import java.sql.Connection;
import java.util.List;

public interface EmployeeDAO {
    void create(Employee employee, Connection connection);
    Employee readById(int id,Connection connection);
    List<Employee> readAll(Connection connection);
    void updateById(int id,String firstName, String lastName, String gender, int age, int cityId,Connection connection);
    void deleteById(int id,Connection connection);
}
