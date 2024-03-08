package org.example;

import jakarta.persistence.*;

import java.util.List;

@Entity
@NamedEntityGraph(
        name = "scopewithversions",
        attributeNodes = {
                @NamedAttributeNode(value = "name"),
                @NamedAttributeNode(
                        value = "versions",
                        subgraph = "versionssubgraph"
                )
        },
        subgraphs = @NamedSubgraph(
                name = "versionssubgraph",
                attributeNodes = {
                        @NamedAttributeNode(value = "version"),
                        @NamedAttributeNode(value = "released")
                }
        )
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
