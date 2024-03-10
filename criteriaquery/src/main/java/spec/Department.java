package spec;

import jakarta.persistence.*;

import java.util.List;

@NamedQuery(
        name = "select all departments",
        query = "select d from Department d"
)
@Entity
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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name);

        if (users != null && !users.isEmpty()) {
            builder.append(" {\n");

            for (User user : users) {
                builder.append("  ").append(user.getFullName()).append("\n");
            }

            builder.append("}");
        }

        return builder.toString();
    }

}
