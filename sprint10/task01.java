import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MyUtils {
    private Connection connection;
    private Statement statement;
    private String schemaName;

    public Connection createConnection() throws SQLException {
        DriverManager.registerDriver(new org.h2.Driver());
        connection = DriverManager.getConnection("jdbc:h2:mem:test", "", "");
        return connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public Statement createStatement() throws SQLException {
        statement = connection.createStatement();
        return statement;
    }

    public void closeStatement() throws SQLException {
        statement.close();
    }

    public void createSchema(String schemaName) throws SQLException {
        statement.execute("CREATE SCHEMA " + schemaName + ";");
        this.schemaName = schemaName;
    }

    public void dropSchema() throws SQLException {
        statement.execute("DROP SCHEMA " + schemaName + ";");
    }

    public void useSchema() throws SQLException {
        statement.execute("USE " + schemaName + ";");
    }

    public void createTableRoles() throws SQLException {
        statement.execute("CREATE TABLE Roles(\n" +
                "id INT NOT NULL AUTO_INCREMENT,\n" +
                "roleName VARCHAR(30) NOT NULL,\n" +
                "PRIMARY KEY (id),\n" +
                "UNIQUE INDEX id_ROLES (id ASC));");
    }

    public void createTableDirections() throws SQLException {
        statement.execute("CREATE TABLE Directions(\n" +
                "id INT NOT NULL AUTO_INCREMENT,\n" +
                "directionName VARCHAR(30) NOT NULL,\n" +
                "PRIMARY KEY (id),\n" +
                "UNIQUE INDEX id_DIRECTIONS (id ASC));");
    }

    public void createTableProjects() throws SQLException {
        statement.execute("CREATE TABLE Projects(\n" +
                "id INT NOT NULL AUTO_INCREMENT,\n" +
                "projectName VARCHAR(30) NOT NULL,\n" +
                "directionId INT NOT NULL,\n" +
                "PRIMARY KEY (id),\n" +
                "UNIQUE INDEX id_PROJECTS (id ASC),\n" +
                "FOREIGN KEY (directionId)\n" +
                "REFERENCES Directions (ID));");
    }

    public void createTableEmployee() throws SQLException {
        statement.execute("CREATE TABLE Employee (\n" +
                "id INT NOT NULL AUTO_INCREMENT,\n" +
                "firstName VARCHAR(20) NOT NULL,\n" +
                "roleId INT NOT NULL,\n" +
                "projectId INT NOT NULL,\n" +
                "PRIMARY KEY (id),\n" +
                "UNIQUE INDEX id_EMPLOYEE (id ASC),\n" +
                "FOREIGN KEY (roleId)\n" +
                "REFERENCES Roles(id),\n" +
                "FOREIGN KEY (projectId)\n" +
                "REFERENCES Projects(id));");
    }

    public void dropTable(String tableName) throws SQLException {
        statement.execute("DROP TABLE " + tableName + ";");
    }

    public void insertTableRoles(String roleName) throws SQLException {
        statement.execute("INSERT INTO ROLES (roleName) VALUES ('" + roleName + "');");
    }

    public void insertTableDirections(String directionName) throws SQLException {
        statement.execute("INSERT INTO DIRECTIONS (directionName) VALUES ('" + directionName + "');");
    }

    public void insertTableProjects(String projectName, String directionName) throws SQLException {
        statement.execute("INSERT INTO PROJECTS (projectName, directionId)" +
                " VALUES ('" + projectName + "', " + getDirectionId(directionName) + ");");
    }

    public void insertTableEmployee(String firstName, String roleName, String projectName) throws SQLException {
        statement.execute("INSERT INTO EMPLOYEE (firstName, roleId, projectId) " +
                "VALUES ('" + firstName + "', " + getRoleId(roleName) + ", " + getProjectId(projectName) + ");");
    }

    public int getRoleId(String roleName) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT ID FROM ROLES WHERE ROLENAME =('" + roleName + "');");
        resultSet.next();
        return resultSet.getInt("id");

    }

    public int getDirectionId(String directionName) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT ID FROM DIRECTIONS WHERE DIRECTIONNAME =('" + directionName + "');");
        resultSet.next();
        return resultSet.getInt("id");
    }

    public int getProjectId(String projectName) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT ID FROM PROJECTS WHERE PROJECTNAME =('" + projectName + "');");
        resultSet.next();
        return resultSet.getInt("id");
    }

    public int getEmployeeId(String firstName) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT ID FROM EMPLOYEE WHERE FIRSTNAME =('" + firstName + "');");
        resultSet.next();
        return resultSet.getInt("id");
    }

    public List<String> getAllRoles() throws SQLException {
        List<String> list = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery("SELECT ROLENAME FROM ROLES;");
        while (resultSet.next()) {
            list.add(resultSet.getString("roleName"));
        }
        return list;
    }

    public List<String> getAllDirestion() throws SQLException {
        List<String> list = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery("SELECT DIRECTIONNAME FROM DIRECTIONS;");
        while (resultSet.next()) {
            list.add(resultSet.getString("directionName"));
        }
        return list;
    }

    public List<String> getAllProjects() throws SQLException {
        List<String> list = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery("SELECT PROJECTNAME FROM PROJECTS;");
        while (resultSet.next()) {
            list.add(resultSet.getString("projectName"));
        }
        return list;
    }

    public List<String> getAllEmployee() throws SQLException {
        List<String> list = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery("SELECT FIRSTNAME FROM EMPLOYEE;");
        while (resultSet.next()) {
            list.add(resultSet.getString("firstName"));
        }
        return list;
    }

    public List<String> getAllDevelopers() throws SQLException { //problem
        List<String> list = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery("SELECT FIRSTNAME FROM EMPLOYEE WHERE ROLEID =" 
                + getRoleId("Developer") + ";");
        while (resultSet.next()) {
            list.add(resultSet.getString("firstName"));
        }
        return list;
    }

    public List<String> getAllJavaProjects() throws SQLException {
        List<String> list = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery("SELECT PROJECTNAME FROM PROJECTS WHERE DIRECTIONID =" 
                + getDirectionId("Java") + ";");
        while (resultSet.next()) {
            list.add(resultSet.getString("projectName"));
        }
        return list;
    }

    public List<String> getAllJavaDevelopers() throws SQLException { //problem
        List<String> list = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery("SELECT FIRSTNAME FROM EMPLOYEE WHERE ROLEID ="
                + getRoleId("Developer")
                + " AND (PROJECTID =" + getProjectId("MoonLight") + " OR PROJECTID =" 
                + getProjectId("Sun") + ");");
        while (resultSet.next()) {
            list.add(resultSet.getString("firstName"));
        }
        return list;
    }

}
