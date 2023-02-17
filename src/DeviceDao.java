import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeviceDao {
    public List<Device> getAllDeviceWIthHearthRateAndGps(String username) throws SQLException {
        List<Device> devices = new ArrayList<>();

        String QUERY_SELECT = "SELECT * FROM device WHERE username = ? AND DEVICE_HAS_GPS = 1 AND DEVICE_HAS_HEARTRATE = 1";

        try (Connection connection = DriverManager.getConnection(ConnectionUtilities.getUrl(), ConnectionUtilities.getUser(), ConnectionUtilities.getPassword());

             PreparedStatement statement = connection.prepareStatement(QUERY_SELECT)) {
            statement.setString(1, username);
            ResultSet result = statement.executeQuery();

                while (result.next()) {
                    Device device = new Device();
                    device.setDevicePartNumber(result.getString("DEVICE_PART_NUMBER"));
                    device.setDeviceManufacturer(result.getString("DEVICE_MANUFACTURER"));
                    device.setDeviceModel(result.getString("DEVICE_MODEL"));
                    device.setDeviceHasGps(result.getShort("DEVICE_HAS_GPS"));
                    device.setDeviceHasHeartRate(result.getShort("DEVICE_HAS_HEARTRATE"));
                    device.setUsername(result.getString("USERNAME"));
                    devices.add(device);
                }
        }

        return devices;
    }
}