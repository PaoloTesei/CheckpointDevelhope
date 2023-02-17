public class ConnectionUtilities {

    private static final String dbName = "mydb";
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String user = "root";
    private static final String password = "Develhope1!";

    public static String getDbName() {
        return dbName;
    }

    public static String getUrl() {
        return url;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }
}