package pojos;

public class DummyApiDataPojo {

    private String employee_name;
    private int employee_salary;
    private int employee_age;
    private String employee_image;

    public DummyApiDataPojo() {
    }

    public DummyApiDataPojo(String employee_name, int employee_salary, int employee_age, String employee_image) {
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
        this.employee_image = employee_image;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public int getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(int employee_salary) {
        this.employee_salary = employee_salary;
    }

    public int getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(int employee_age) {
        this.employee_age = employee_age;
    }

    public String getEmployee_image() {
        return employee_image;
    }

    public void setEmployee_image(String employee_image) {
        this.employee_image = employee_image;
    }

    @Override
    public String toString() {
        return "DummyApiDataPojo{" +
                "employee_name='" + employee_name + '\'' +
                ", employee_salary=" + employee_salary +
                ", employee_age=" + employee_age +
                ", employee_image='" + employee_image + '\'' +
                '}';
    }
}
