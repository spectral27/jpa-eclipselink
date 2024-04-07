package example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ScopeRepository {

    private final EntityManagerFactory factory = Factory.object;

    public List<Scope> selectAll() {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        TypedQuery<Scope> query = manager.createQuery("select s from Scope s left join fetch s.versions", Scope.class);
        List<Scope> scopes = query.getResultList();

        manager.getTransaction().commit();
        manager.close();

        return scopes;
    }

}
