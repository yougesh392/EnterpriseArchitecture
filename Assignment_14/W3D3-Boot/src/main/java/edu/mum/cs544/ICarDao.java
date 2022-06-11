package edu.mum.cs544;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ICarDao extends JpaRepository<Car ,Integer>{


//	public abstract List<Car> getAll();
//
//	public abstract void add(Car car);
//
//	public abstract Car get(int id);
//
//	public abstract void update(Car car);
//
//	public abstract void delete(int carId);

}