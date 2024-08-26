import java.util.Random;

public class Main {

    private final static Random RANDOM = new Random();
    private final static String [] FIRSTNAMES = {"Даниил", "Максим", "Владислав", "Никита", "Артем", "Иван", "Кирилл", "Егор", "Илья", "Андрей"};
    private final static String [] PATRONICNAMES = {"Николаевич", "Владимирович", "Александрович", "Иванович", "Васильевич", "Сергеевич", "Викторович", "Михайлович", "Артемович", "Андреевич"};
    private final static String [] LASTNAMES = {"Иванов", "Смирнов", "Кузнецов", "Попов", "Васильев", "Петров", "Соколов", "Лазарев", "Медведев", "Ершов"};

    private final static Employee [] EMPLOYEES = new Employee [10];
    
    private static void nameGen () {
        for (int i = 0; i < EMPLOYEES.length; i++) {
            String name = LASTNAMES[RANDOM.nextInt(0, LASTNAMES.length)] + " " +
                    FIRSTNAMES[RANDOM.nextInt(0, FIRSTNAMES.length)] + " " +
                    PATRONICNAMES[RANDOM.nextInt(0, PATRONICNAMES.length)];
            EMPLOYEES[i] = new Employee(name, RANDOM.nextInt(1, 6), RANDOM.nextFloat(75_000, 200_000));
        }
    } 

    public static void main(String[] args) {
        System.out.println("-----------Уровень 1-----------");
        nameGen();
        printAll ();
        System.out.println("Сумма затрат на ЗП в месяц: " + calcSum ());
        System.out.println("Среднее значение зарплат: " + avgSum());
        System.out.println("Сотрудник с минимальной ЗП: " + minSalary());
        System.out.println("Сотрудник с максимальной ЗП: " + maxSalary());
        printName();

        System.out.println("-----------Уровень 2-----------");
        indexSalary(1.05F);
        printAll();
        int department = 2;
        System.out.println("Сотрудник с минимальной зп: " + minSalaryDepartment(department));
        System.out.println("Сотрудник с максимальной зп: " + maxSalaryDepartment(department));
        System.out.println("Сумму затрат на зп по отделу: " + calcSumDepartment(department));
        System.out.println("Средняя зп по отделу: " + avgSumDepartment(department));
        indexSalaryDepartment(department, 1.1f);
        printDepartment(department);
        float salary = 150_000;
        printMinSalary(salary);
        printMaxSalary(salary);

    }

    private static void printAll () {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee);
        }
    }

    private static float calcSum () {
        float sum = 0f;
        for (Employee employee: EMPLOYEES){
            sum += employee.getSalary();
        }
        return sum;
    }

    private static Employee minSalary () {
        Employee employeeMinSalary= null;
        for (Employee employee: EMPLOYEES){
            if (employeeMinSalary == null || employee.getSalary() < employeeMinSalary.getSalary()) {
                employeeMinSalary = employee;
            }
        }
        return employeeMinSalary;
    }
    private static Employee maxSalary () {
        Employee employeeMaxSalary= null;
        for (Employee employee: EMPLOYEES){
            if (employeeMaxSalary == null || employee.getSalary() > employeeMaxSalary.getSalary()) {
                employeeMaxSalary = employee;
            }
        }
        return employeeMaxSalary;
    }

    private static float avgSum () {
    return calcSum() / EMPLOYEES.length;
    }

    private static void printName () {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee.getName());
        }
    }

    // level 2

    private static void indexSalary (float index) {
        for (Employee employee : EMPLOYEES) {
            employee.setSalary(employee.getSalary() * index);
        }
    }

    private static float calcSumDepartment (int department) {
        float sumDepartment = 0f;
        for (Employee employee: EMPLOYEES){
            if (employee.getDepartment() == department) {
                sumDepartment += employee.getSalary();
            };
        }
        return sumDepartment;
    }

    private static Employee minSalaryDepartment (int department) {
        Employee employeeDepartmentMinSalary= null;
        for (Employee employee: EMPLOYEES){
            if (employeeDepartmentMinSalary == null ||
                    employee.getSalary() < employeeDepartmentMinSalary.getSalary() && employee.getDepartment() == department) {
                employeeDepartmentMinSalary = employee;
            }
        }
        return employeeDepartmentMinSalary;
    }
    private static Employee maxSalaryDepartment (int department) {
        Employee employeeDepartmentMaxSalary= null;
        for (Employee employee: EMPLOYEES){
            if (employeeDepartmentMaxSalary == null ||
                    employee.getSalary() > employeeDepartmentMaxSalary.getSalary() && employee.getDepartment() == department) {
                employeeDepartmentMaxSalary = employee;
            }
        }
        return employeeDepartmentMaxSalary;
    }

    private static float avgSumDepartment (int department) {
        float sumDepartment = 0f;
        int employeeDepartment =0;
        for (Employee employee: EMPLOYEES){
            if (employee.getDepartment() == department) {
                sumDepartment += employee.getSalary();
                employeeDepartment++;
            };
        }
        return sumDepartment/employeeDepartment;
    }

    private static void indexSalaryDepartment (int department, float index) {
        for (Employee employee : EMPLOYEES) {
            if (employee.getDepartment() == department) {
                employee.setSalary(employee.getSalary() * index);
            };
        }
    }
    private static void printDepartment (int department) {
        for (Employee employee : EMPLOYEES) {
            if (employee.getDepartment() == department) {
            System.out.println("Employee{" + "id=" + employee.getId() + ", name='" + employee.getName() + ", salary=" + employee.getSalary() + '}');}
        }
    }
    private static void printMinSalary (float salary) {
        for (Employee employee : EMPLOYEES) {
            if (employee.getSalary() < salary) {
                System.out.println("Employee{" + "id=" + employee.getId() + ", name='" + employee.getName() + ", salary=" + employee.getSalary() + '}');}
        }
    }
    private static void printMaxSalary (float salary) {
        for (Employee employee : EMPLOYEES) {
            if (employee.getSalary() >= salary) {
                System.out.println("Employee{" + "id=" + employee.getId() + ", name='" + employee.getName() + ", salary=" + employee.getSalary() + '}');}
        }
    }
}