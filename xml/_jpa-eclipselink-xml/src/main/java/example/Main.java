package example;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            DriverManager.getConnection(
                    "jdbc:h2:mem:mydatabase;INIT=runscript from 'classpath:create.sql';MODE=LEGACY",
                    "username",
                    "password"
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        ScopeRepository repository = new ScopeRepository();
        List<Scope> scopes = repository.selectAll();
        for (Scope s : scopes) {
            System.out.printf("%s %s %s%n", s.getName(), s.getGroupId(), s.getArtifactId());
            if (s.getVersions() != null && !scopes.isEmpty()) {
                for (ScopeVersion v : s.getVersions()) {
                    System.out.printf("%s %s%n", v.getVersion(), v.getReleased());
                }
            }
        }
    }

}
