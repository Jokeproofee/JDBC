import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {


    @Override
    public void create(Employee employee, Connection connection) {

        try(PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO employee (first_name, last_name, gender, age, city_id) VALUES ((?),(?),(?), (?), (?))")) {

            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getGender());
            statement.setInt(4, employee.getAge());
            statement.setInt(5, employee.getCity().getCityId());

            statement.executeUpdate();

            System.out.println("Пользователь добавлен!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee readById(int id,Connection connection) {

        Employee employee = new Employee();

        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM employee INNER JOIN city ON employee.city_id=city.city_id AND id=(?)")) {

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {

                employee.setId(resultSet.getInt(1));
                employee.setFirstName(resultSet.getString(2));
                employee.setLastName(resultSet.getString(3));
                employee.setGender(resultSet.getString(4));
                employee.setAge(resultSet.getInt(5));
                //employee.setCityId(resultSet.getInt(6));
                employee.setCity(new City(resultSet.getString("city_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> readAll(Connection connection) {

        List<Employee> employeeList = new ArrayList<>();

        try(PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM employee INNER JOIN city ON employee.city_id=city.city_id")) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                int id = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String gender = resultSet.getString(4);
                int age = resultSet.getInt(5);
                City city = new City(resultSet.getString("city_name"));

                employeeList.add(new Employee(id, firstName, lastName, gender, age, city));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employeeList;
    }

    @Override
    public void updateById(int id,String firstName, String lastName, String gender, int age, int cityId,Connection connection) {

        try(PreparedStatement statement = connection.prepareStatement(
                "UPDATE employee SET first_name=(?), last_name=(?),gender=(?), age=(?),city_id=(?) WHERE id=(?)")) {

            statement.setString(1,firstName);
            statement.setString(2,lastName);
            statement.setString(3,gender);
            statement.setInt(4, age);
            statement.setInt(5, cityId);
            statement.setInt(6, id);

            statement.executeUpdate();
            System.out.println("Возраст обновлён!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id,Connection connection) {

        try(PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM employee WHERE id=(?)")) {

            statement.setInt(1, id);
            statement.executeUpdate();

            System.out.println("Id удалён!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}