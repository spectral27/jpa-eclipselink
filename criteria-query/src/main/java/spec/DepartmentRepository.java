package spec;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;

import java.util.List;

public class DepartmentRepository {

    private final EntityManagerFactory factory = Factory.object;

    public List<Department> selectAll() {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Department> criteriaQuery = criteriaBuilder.createQuery(Department.class);
        Root<Department> fromDepartment = criteriaQuery.from(Department.class);
        criteriaQuery.select(fromDepartment);

        TypedQuery<Department> query = manager.createQuery(criteriaQuery);
        List<Department> departments = query.getResultList();

        manager.getTransaction().commit();
        manager.close();

        return departments;
    }

    public List<Department> selectWhereNameIs(String departmentName) {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Department> criteriaQuery = criteriaBuilder.createQuery(Department.class);
        Root<Department> fromDepartment = criteriaQuery.from(Department.class);
        criteriaQuery.select(fromDepartment);
        Predicate namePredicate = criteriaBuilder.equal(fromDepartment.get(Department_.name), departmentName);
        criteriaQuery.where(namePredicate);

        TypedQuery<Department> query = manager.createQuery(criteriaQuery);
        List<Department> departments = query.getResultList();

        manager.getTransaction().commit();
        manager.close();

        return departments;
    }

    public List<Department> selectByNameCaseInsensitive(String departmentName) {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Department> criteriaQuery = criteriaBuilder.createQuery(Department.class);
        Root<Department> fromDepartment = criteriaQuery.from(Department.class);
        criteriaQuery.select(fromDepartment);

        Expression<String> expression = criteriaBuilder.lower(fromDepartment.get(Department_.name));
        Predicate namePredicate = criteriaBuilder.equal(expression, departmentName.toLowerCase());
        criteriaQuery.where(namePredicate);

        TypedQuery<Department> query = manager.createQuery(criteriaQuery);
        List<Department> departments = query.getResultList();

        manager.getTransaction().commit();
        manager.close();

        return departments;
    }

}
