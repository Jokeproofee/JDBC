import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Application {
    public static void main(String[] args) throws SQLException, IOException {
        Properties properties = new Properties();
        properties.load(Files.newInputStream(Paths.get("db.properties").toFile().toPath()));

        try (final Connection connection = DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("user"),
                properties.getProperty("password"));
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE id = (?)")) {

            statement.setInt(1, 3);

            final ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                String firstName = "First name: " + resultSet.getString("first_name");
                String lastName = "Last name: " + resultSet.getString("last_name");
                String gender = "Gender: " + resultSet.getString("gender");
                int age = resultSet.getInt("age");
                int cityId = resultSet.getInt("city_id");

                System.out.println(firstName);
                System.out.println(lastName);
                System.out.println(gender);
                System.out.println("Age: " + age);
                System.out.println("City id: " + cityId);
            }

            System.out.println();
            EmployeeDAO employeeDAO = new EmployeeDAOImpl();
            System.out.println("Получение конкретного объекта Employee по id:");
            System.out.println(employeeDAO.readById(5, connection));

            /*System.out.println("Изменение конкретного объекта Employee в базе по id:");
            employeeDAO.updateById(2,"Ульяна","Серова","Ж",40,2, connection);*/

            /*System.out.println("Создание(добавление) сущности Employee в таблицу:");
            employeeDAO.create(new Employee("Алексей","Леонов","М",57,3),connection);*/

            /*System.out.println("Удаление конкретного объекта Employee из базы по id:");
            employeeDAO.deleteById(10,connection);*/

            System.out.println();
            System.out.println("Получение списка всех объектов Employee из базы:");
            List<Employee> employeeList = new ArrayList<>(employeeDAO.readAll(connection));
            for (Employee employee : employeeList) {
                System.out.println(employee);
            }
        }
    }
}