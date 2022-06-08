package edu.mum.cs544;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class BookService {

    @Resource
    private IBookDAO bookDAO;

    public List<Book> getAll() {
        return bookDAO.findAll();
    }

    public void add(Book book) {
        bookDAO.save(book);
    }

    public Book get(int id) {
//        return bookDAO.findById(id).get();
        return bookDAO.getOne(id);
    }

    public void update(Book book) {
        bookDAO.save(book);
    }

    public void delete(int id) {
        bookDAO.deleteById(id);
    }
}
