package by.pvt.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
public class Device {
    private static final long serialVersionUID=1L;
    @Id
    @GenericGenerator(name = "deviceId", strategy = "increment")

    private  String deviceId;
    @Column
    private String deviceName;
    @Column
    private  String deviceLocation;
    @Column
    private String deviceIpAdress;
    @Column
    @Lob
    private byte[] productImage;
    @OneToMany
    private List<Sensor> sensors;

    public Device() {
    }

    public Device(String deviceId, String deviceName,String deviceLocation,String deviceIpAdress ) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.deviceLocation = deviceLocation;
        this.deviceIpAdress=deviceIpAdress;
    }

    public byte[] getProductImage() {
        return productImage;
    }

    public void setProductImage(byte[] productImage) {
        this.productImage = productImage;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceLocation() {
        return deviceLocation;
    }

    public void setDeviceLocation(String deviceLocation) {
        this.deviceLocation = deviceLocation;
    }

    public String getDeviceIpAdress() {
        return deviceIpAdress;
    }

    public void setDeviceIpAdress(String deviceIpAdress) {
        this.deviceIpAdress = deviceIpAdress;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Device device = (Device) o;

        if (deviceId != null ? !deviceId.equals(device.deviceId) : device.deviceId != null) return false;
        if (!deviceName.equals(device.deviceName)) return false;
        if (deviceLocation != null ? !deviceLocation.equals(device.deviceLocation) : device.deviceLocation != null)
            return false;
        if (deviceIpAdress != null ? !deviceIpAdress.equals(device.deviceIpAdress) : device.deviceIpAdress != null)
            return false;
        if (!Arrays.equals(productImage, device.productImage)) return false;
        return sensors != null ? sensors.equals(device.sensors) : device.sensors == null;
    }

    @Override
    public int hashCode() {
        int result = deviceId != null ? deviceId.hashCode() : 0;
        result = 31 * result + deviceName.hashCode();
        result = 31 * result + (deviceLocation != null ? deviceLocation.hashCode() : 0);
        result = 31 * result + (deviceIpAdress != null ? deviceIpAdress.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(productImage);
        result = 31 * result + (sensors != null ? sensors.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Device{" +
                "deviceId='" + deviceId + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", deviceLocation='" + deviceLocation + '\'' +
                ", deviceIpAdress='" + deviceIpAdress + '\'' +
                '}';
    }
}
