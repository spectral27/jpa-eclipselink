package spec;

import jakarta.persistence.*;

import java.util.List;

@Entity
@NamedEntityGraph(
        name = "department.users",
        attributeNodes = @NamedAttributeNode(
                value = "users",
                subgraph = "department.users.devices"
        ),
        subgraphs = @NamedSubgraph(
                name = "department.users.devices",
                attributeNodes = @NamedAttributeNode("devices")
        )
)
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "department")
    private List<User> users;

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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}
