package src.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import src.entities.Employee;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();

        System.out.println("How many employees will be registered? ");
        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            System.out.println();
            System.out.println("Employee #" + (i+1) + ": ");

            System.out.print("ID: ");
            Integer id = sc.nextInt();

            while(hasId(list, id)) {
                System.out.println("ID already taken! Try again: ");
                id = sc.nextInt();
            }


            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();


            System.out.print("Salary: ");
            Double salary = sc.nextDouble();


            Employee emp = new Employee(name, salary, id);

            list.add(emp);
        }

        System.out.println();
        System.out.println("Enter the employee ID that will have salary increase: ");
        Integer idSalary = sc.nextInt();
        System.out.println();

        //Integer pos = position(list, idSalary);
        Employee emp = list.stream().filter(x -> x.getId() == idSalary).findFirst().orElse(null);

        if(emp == null) {
            System.out.println("ID does not exist!");
        } else {
            System.out.println("Enter the percentage: ");
            double percent = sc.nextDouble();

            emp.increaseSalary(percent);
        }

        System.out.println();
        System.out.println("Employees list: ");

        for (Employee employee : list) {
            System.out.println(employee);
        }



        sc.close();
    }

    public static Integer position(List<Employee> list, Integer id){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getId() == id){
                return i;
            }
        }
        return null;
    }

    public static boolean hasId(List<Employee> list, int id) {
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return emp != null;
    }

}
