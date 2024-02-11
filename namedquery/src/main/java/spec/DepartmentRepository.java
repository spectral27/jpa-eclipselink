package spec;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DepartmentRepository {

    private final EntityManagerFactory factory = Factory.object;

    public List<Department> selectAll() {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        TypedQuery<Department> typedQuery = manager.createNamedQuery("select all departments", Department.class);
        List<Department> departments = typedQuery.getResultList();

        manager.getTransaction().commit();
        manager.close();

        return departments;
    }

}
