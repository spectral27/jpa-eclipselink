package spec;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        DepartmentRepository departmentRepository = new DepartmentRepository();

        List<Department> departments = departmentRepository.selectWhereNameIs("JPA");

        departments.forEach(System.out::println);

        List<Department> caseInsensitive = departmentRepository.selectByNameCaseInsensitive("eclipselink");

        caseInsensitive.forEach(System.out::println);
    }

}
