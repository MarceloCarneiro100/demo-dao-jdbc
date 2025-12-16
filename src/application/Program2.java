package application;

import db.DbException;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: department findById =====");
        Department department = departmentDao.findById(4);
        System.out.println(department);
        System.out.println();

        System.out.println("=== TEST 2: department findAll =====");
        List<Department> list = departmentDao.findAll();
        list.forEach(System.out::println);
        System.out.println();

        System.out.println("=== TEST 3: department insert =====");
        Department newDepartment = new Department(null, "Music");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id: " + newDepartment.getId());
        System.out.println();

        System.out.println("=== TEST 4: department update =====");
        department = departmentDao.findById(6);
        department.setName("Food");
        departmentDao.update(department);
        System.out.println("Updated completed!");
        System.out.println();

        System.out.println("=== TEST 5: department delete =====");
        try {
            System.out.print("Enter id for delete test: ");
            int id = sc.nextInt();
            departmentDao.deleteById(id);
            System.out.println("Delete completed!");
        } catch (DbException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
        System.out.println();

        sc.close();
    }
}
