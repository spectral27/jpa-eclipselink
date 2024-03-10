package spec;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class DepartmentRepository {

    private final EntityManagerFactory factory = Factory.object;

    public List<Department> selectAll() {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        String query = "from Department d left join fetch d.users order by d.id";
        List<Department> departments = manager.createQuery(query, Department.class)
                .getResultList();

        manager.getTransaction().commit();
        manager.close();

        return departments;
    }

    public void insert(Department department) {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        manager.persist(department);
        if (department.getUsers() != null && !department.getUsers().isEmpty()) {
            for (User user : department.getUsers()) {
                manager.persist(user);
            }
        }

        manager.getTransaction().commit();
        manager.close();
    }

    public void update(int id, String newName) {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        Department department = manager.find(Department.class, id);
        department.setName(newName);

        manager.getTransaction().commit();
        manager.close();
    }

    public void delete(int id) {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        manager.remove(manager.getReference(Department.class, id));

        manager.getTransaction().commit();
        manager.close();
    }

}
