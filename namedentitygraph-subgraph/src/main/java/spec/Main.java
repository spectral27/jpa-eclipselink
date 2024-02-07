package spec;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        DepartmentRepository departmentRepository = new DepartmentRepository();

        List<Department> departments = departmentRepository.selectEntityGraph();

        for (Department department : departments) {
            System.out.println(department.getName());

            if (department.getUsers() != null && !department.getUsers().isEmpty()) {
                for (User user : department.getUsers()) {
                    System.out.println(user.getFullName());

                    if (user.getDevices() != null && !user.getDevices().isEmpty()) {
                        for (Device device : user.getDevices()) {
                            System.out.println(device.getBrand());
                        }
                    }
                }
            }
        }
    }

}
