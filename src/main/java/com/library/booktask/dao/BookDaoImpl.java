package com.library.booktask.dao;

import com.library.booktask.entity.book.Book;
import com.library.booktask.repository.DbConnection;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.hibernate.id.UUIDGenerator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookDaoImpl {

    private static BookDaoImpl bookDaoImpl;



    @SneakyThrows
    public Book save(Book book) {
        Connection connection = DbConnection.getInstance().db();
        try {
            PreparedStatement statement = connection.prepareStatement("insert into book(title, author) values (?, ?)");
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            ResultSet resultSet = statement.executeQuery();

            Book result = new Book();
            while (resultSet.next()){
                result.setId(resultSet.getLong("id"));
                result.setAuthor(resultSet.getString("author"));
                result.setTitle(resultSet.getString("title"));
                result.setDescription(resultSet.getString("description"));
            }

            return result;
        }catch (RuntimeException e){
            throw new RuntimeException("Error: Saving book");
        }

    }

    @SneakyThrows
    public List<Book> loadAllBookDescendingOrder() {
        Connection connection = DbConnection.getInstance().db();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from book order by title desc");
            ResultSet resultSet = statement.executeQuery();

            List<Book> result = new ArrayList<>();
            while (resultSet.next()){
                Book book = new Book();
                book.setId(resultSet.getLong("id"));
                book.setAuthor(resultSet.getString("author"));
                book.setTitle(resultSet.getString("title"));
                book.setDescription(resultSet.getString("description"));
                result.add(book);
            }

            return result;
        }catch (RuntimeException e){
            throw new RuntimeException("Error: Saving book");
        }
    }

    @SneakyThrows
    public Book findById(Long id) {
        Connection connection = DbConnection.getInstance().db();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from book where id = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            Book result = new Book();
            while (resultSet.next()){
                result.setId(resultSet.getLong("id"));
                result.setAuthor(resultSet.getString("author"));
                result.setTitle(resultSet.getString("title"));
                result.setDescription(resultSet.getString("description"));
            }

            return result;
        }catch (RuntimeException e){
            throw new RuntimeException("Error: Saving book");
        }
    }

    /*This is singleTon pattern*/
    public static BookDaoImpl getInstance() {
        if (bookDaoImpl == null) {
            return bookDaoImpl = new BookDaoImpl();
        }
        return bookDaoImpl;
    }

}
