import java.util.List;

public class Application {

    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        System.out.println("Создание(добавление) сущности Employee в таблицу:");
        //employeeDAO.create(new Employee("Григорий","Сафонов","М",77,2));
        System.out.println("Изменение конкретного объекта Employee в базе:");
        //employeeDAO.update(new Employee(11,"Григорий2","Сафонов","М",77,2));
        System.out.println("Удаление конкретного объекта Employee из базы:");
        //employeeDAO.delete(new Employee(11,"Григорий","Сафонов","М",77,2));
        System.out.println("Получение конкретного объекта Employee по id:");
        //System.out.println(employeeDAO.readById(7));
        System.out.println("Получение списка всех объектов Employee из базы:");
        /*List<Employee> employeeList = employeeDAO.readAll();
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }*/
    }
}