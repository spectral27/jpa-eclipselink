package spec;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        DepartmentRepository departmentRepository = new DepartmentRepository();

        List<Department> departments = departmentRepository.selectAll();

        departments.forEach(System.out::println);
    }

}
