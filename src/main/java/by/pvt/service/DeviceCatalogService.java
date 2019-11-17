package by.pvt.service;

import by.pvt.pojo.Device;
import by.pvt.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DeviceCatalogService {
    @Autowired
    DeviceRepository deviceRepository;

    @Transactional
    public List<Device> getFirstTopTenProducts() {
        return deviceRepository.findAll(10);
    }

    @Transactional
    public Device findItem(Long id) {
        return deviceRepository.findItemById(id);
    }

    @Transactional
    public List<Device> searchByProductName(String str) {
        return deviceRepository.findByProductName(str, 5);
    }

    @Transactional
    public boolean addItem(Device item) {
        if (item.getDeviceName() == null ) {
            return false;
        }
        return deviceRepository.add(item);
    }
}

