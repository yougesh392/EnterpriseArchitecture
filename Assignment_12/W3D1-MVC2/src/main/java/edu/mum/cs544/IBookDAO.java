package edu.mum.cs544;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBookDAO extends JpaRepository<Book, Integer> {


}
