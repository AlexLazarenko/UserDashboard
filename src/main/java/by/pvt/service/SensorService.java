package by.pvt.service;

import by.pvt.pojo.Sensor;
import by.pvt.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SensorService {

        @Autowired
        SensorRepository sensorRepository;

        @Transactional
        public List<Sensor> getFirstTopTenProducts() {
            return sensorRepository.findAll(10);
        }

        @Transactional
        public Sensor findItem(Long id) {
            return sensorRepository.findItemById(id);
        }

        @Transactional
        public boolean addItem(Sensor item) {
            if (item.getSensorId() == null ) {
                return false;
            }
            return sensorRepository.add(item);
        }
}
