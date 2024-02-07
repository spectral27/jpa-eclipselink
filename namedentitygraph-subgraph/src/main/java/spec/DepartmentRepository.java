package spec;

import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class DepartmentRepository {

    private final EntityManagerFactory factory = Factory.object;

    public List<Department> selectEntityGraph() {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        EntityGraph<?> entityGraph = manager.getEntityGraph("department.users");
        List<Department> departments = manager.createQuery("from Department d", Department.class)
                .setHint("jakarta.persistence.loadgraph", entityGraph)
                .getResultList();

        manager.getTransaction().commit();
        manager.close();

        return departments;
    }

}
