public class User {
    private final int id;
    private final String name;
    private final int age;
    private final String department;
    private final double salary;

    public User(int id, String name, int age, String department, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return name + "(" + age + "|" + department + "|" + salary + ")";
    }
}
