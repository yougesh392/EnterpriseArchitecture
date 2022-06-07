import java.util.List;

public interface IBookDao {
    public List<Book> getAll();

    public void add(Book book);

    public Book get(int id);

    public void update(Book book);

    public void delete(int bookId);

}
