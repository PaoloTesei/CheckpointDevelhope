import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class TestDeviceDao {
    public static void main(String[] args) throws SQLException{

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(ConnectionUtilities.getUrl(),
                    ConnectionUtilities.getUser(),
                    ConnectionUtilities.getPassword());
            System.out.println("Connecting to mySQL!");

            DeviceDao deviceDao = new DeviceDao();
            List<Device> devices = deviceDao.getAllDeviceWIthHearthRateAndGps("paolo");
            for (Device device : devices) {
                String manufacturer = device.getDeviceManufacturer().toLowerCase();
                String model = device.getDeviceModel().toUpperCase();
                System.out.println("Device part number: " + device.getDevicePartNumber() +" ");
                System.out.println("Manufacturer: " + manufacturer + " ");
                System.out.println("Model: " + model + "\n");
                }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try{
                if(connection !=null )
                    connection.close();
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }

    }
}
