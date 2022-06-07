import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookService {
    @Resource
    private IBookDao bookDao;

    public List<Book> getAll() {
        return bookDao.getAll();
    }

    public void add(Book book) {
        bookDao.add(book);
    }

    public Book get(int id) {
        return bookDao.get(id);
    }

    public void update(Book book) {
        bookDao.update(book);
    }

    public void delete(int bookId) {
        bookDao.delete(bookId);
    }
}
