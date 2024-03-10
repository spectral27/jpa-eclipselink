package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ScopeRepository {

    private final EntityManagerFactory factory = Factory.object;

    @SuppressWarnings("unchecked")
    public List<Scope> selectAll() {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        Query q = manager.createNativeQuery(
                "SELECT s.id, s.name, v.id as versionid, v.version, v.released, v.scope_id " +
                        "FROM scope s, version v " +
                        "WHERE s.id = v.scope_id",
                "ScopeVersionResultSet"
        );

        List<Object[]> result = q.getResultList();

        List<Scope> scopes = new ArrayList<>();
        List<ScopeVersion> versions = new ArrayList<>();

        for (Object[] resultSet : result) {
            Scope scope = (Scope) resultSet[0];
            scopes.add(scope);

            if (resultSet[1] != null) {
                ScopeVersion version = (ScopeVersion) resultSet[1];
                versions.add(version);
            }
        }

        scopes = scopes.stream().distinct().collect(Collectors.toList());
        versions = versions.stream().distinct().collect(Collectors.toList());

        for (Scope scope : scopes) {
            List<ScopeVersion> scopeVersions = versions.stream()
                    .filter(version -> scope.getId() == version.getScope().getId())
                    .toList();

            if (!scopeVersions.isEmpty()) {
                scope.setVersions(scopeVersions);
            }
        }

        manager.getTransaction().commit();
        manager.close();

        return scopes;
    }

}
