package src.entities;


public class Employee{
    private String name;
    private Double salary;
    private Integer id;

    

    
    public Employee() {
    }
    public Employee(String name, Double salary, Integer id) {
        this.name = name;
        this.salary = salary;
        this.id = id;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }



    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }


    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "ID: " + id + ", "
        + "Name: " + name + ", "
        + "Salary: " + String.format("%.2f", salary);
    }

    
    public void increaseSalary(Double percentage){
        salary += salary * percentage / 100.0;
    }
    
    
}
