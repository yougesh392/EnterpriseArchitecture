package edu.mum.cs544;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CarService {
    @Resource
    private ICarDao carDao;
    
    public List<Car> getAll() {
        return carDao.findAll();
    }

    public void add(Car car) {
        carDao.save(car);
    }

    public Car get(int id) {
        return carDao.getById(id);
    }

    public void update(Car car) {
        carDao.save(car);
    }

    public void delete(int id) {
        carDao.deleteById(id);
    }
}