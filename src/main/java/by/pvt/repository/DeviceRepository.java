package by.pvt.repository;

import by.pvt.pojo.Device;
import by.pvt.pojo.Sensor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class DeviceRepository {


        @Autowired
        private SessionFactory sessionFactory;

        public List<Device> findAll(int count) {
            return sessionFactory.getCurrentSession()
                    .createQuery("from Device", Device.class)
                    .setMaxResults(count)
                    .list();
        }
    public List<Device> findAllByUserEmail(String email) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Device", Device.class)
                .setMaxResults(50)
                .list();
    }

        public Device findItemById(Long id) {
            return sessionFactory.getCurrentSession()
                    .get(Device.class, id);
        }


        public boolean add(Device item) {
            sessionFactory.getCurrentSession().persist(item);
            return true;
        }
    public List<Device> findByProductName(String str, int count) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Device where deviceName like :searchStr", Device.class)
                .setParameter("searchStr", "%" + str + "%")
                .setMaxResults(count)
                .list();
    }

    }

