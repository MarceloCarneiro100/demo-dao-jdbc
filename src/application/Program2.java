package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;

public class Program2 {
    public static void main(String[] args) {
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: department findById =====");
        Department department = departmentDao.findById(4);
        System.out.println(department);
        System.out.println();

        System.out.println("=== TEST 2: department findAll =====");
        List<Department> list = departmentDao.findAll();
        list.forEach(System.out::println);
        System.out.println();
    }
}
