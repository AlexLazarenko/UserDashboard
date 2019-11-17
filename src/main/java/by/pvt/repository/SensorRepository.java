package by.pvt.repository;

import by.pvt.pojo.Sensor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class SensorRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Sensor> findAll(int count) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Sensor", Sensor.class)
                .setMaxResults(count)
                .list();
    }

    public Sensor findItemById(Long id) {
        return sessionFactory.getCurrentSession()
                .get(Sensor.class, id);
    }


    public boolean add(Sensor item) {
        sessionFactory.getCurrentSession().persist(item);
        return true;
    }


}
