package org.example;

import jakarta.persistence.*;

import java.util.List;

@Entity
@SqlResultSetMapping(
        name = "ScopeVersionResultSet",
        entities = {
                @EntityResult(entityClass = org.example.Scope.class),
                @EntityResult(entityClass = org.example.ScopeVersion.class)
        }
)
public class Scope {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToMany(mappedBy = "scope")
    List<ScopeVersion> versions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ScopeVersion> getVersions() {
        return versions;
    }

    public void setVersions(List<ScopeVersion> versions) {
        this.versions = versions;
    }

}
