package example;

import java.util.List;

public class Scope {

    private int id;
    private String name;
    private String groupId;
    private String artifactId;
    private List<ScopeVersion> versions;

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

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public List<ScopeVersion> getVersions() {
        return versions;
    }

    public void setVersions(List<ScopeVersion> versions) {
        this.versions = versions;
    }

}
