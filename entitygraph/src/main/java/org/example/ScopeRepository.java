package org.example;

import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class ScopeRepository {

    private final EntityManagerFactory factory = Factory.object;

    public List<Scope> selectAll() {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        EntityGraph<?> entityGraph = manager.getEntityGraph("scopewithversions");
        List<Scope> scopes = manager.createQuery("select s from Scope s", Scope.class)
                .setHint("jakarta.persistence.fetchgraph", entityGraph)
                .getResultList();

        manager.getTransaction().commit();
        manager.close();

        return scopes;
    }

    public void insert(Scope scope) {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        manager.persist(scope);

        if (scope.getVersions() != null && !scope.getVersions().isEmpty()) {
            scope.getVersions().forEach(version -> {
                version.setScope(scope);
                manager.persist(version);
            });
        }

        manager.getTransaction().commit();
        manager.close();
    }

}
