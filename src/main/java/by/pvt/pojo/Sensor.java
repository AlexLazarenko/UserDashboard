package by.pvt.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.logging.Logger;

@Entity
public class Sensor {
    @Transient
    private static Logger log = Logger.getLogger("Sensor");
    @Id
    @GenericGenerator(name = "sensorId", strategy = "increment")
    private String sensorId;
    @Column
    private int sensorValue;

    public Sensor() {
    }

    public Sensor( String sensorId, int sensorValue) {
        this.sensorId = sensorId;
        this.sensorValue = sensorValue;
    }
    public String getSensorId() {
        return sensorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sensor sensor = (Sensor) o;

        if (sensorValue != sensor.sensorValue) return false;
        return sensorId.equals(sensor.sensorId);
    }

    @Override
    public int hashCode() {
        int result = sensorId.hashCode();
        result = 31 * result + sensorValue;
        return result;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public int getSensorValue() {
        return sensorValue;
    }

    public void setSensorValue(int sensorValue) {
        this.sensorValue = sensorValue;
    }
}
