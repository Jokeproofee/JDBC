import java.util.List;

public class Application {

    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        CityDAO cityDAO = new CityDAOImpl();

        System.out.println("Получение конкретного объекта по id:");
        //System.out.println(employeeDAO.readById(3));

        System.out.println("Создание(добавление) сущности в таблицу:");
        //Employee employee1 = new Employee("Лариса","Алексеевна","Ж",33,new City("Красноярск"));
        //employeeDAO.create(employee1);

        System.out.println("Изменение конкретного объекта в базе:");
        //Employee employee1 = new Employee(6,"Татьяна","Котова","Ж",33,new City(4,"Красноярск"));
        //employeeDAO.update(employee1);

        System.out.println("Удаление конкретного объекта из базы:");
        //City city1 = new City(4);
        //cityDAO.delete(city1);

        System.out.println("Получение списка всех объектов из базы:");
        /*List<Employee> employeeList = employeeDAO.readAll();
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }*/
    }
}