package com.org.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.org.models.Book;



@Service
public class BookService {

	
	private JdbcTemplate jdbcTemplate;
	protected SessionFactory sessionFactory;

	@Autowired
	public BookService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	 protected void setup() {
    	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
    	        .configure() // configures settings from hibernate.cfg.xml
    	        .build();
    	try {
    	    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    	} catch (Exception ex) {
    	    StandardServiceRegistryBuilder.destroy(registry);
    	}
    }
	
	public List<Book> read() {
		Session session =  sessionFactory.openSession();
		
        long bookId = 1;
        List<Book> list= session.createCriteria(Book.class).list();
        session.close();
        this.exit();
        return list;
    }
	
	public Book add(Book book) {
        this.setup();
        Session session = sessionFactory.openSession();
        Transaction t =session.beginTransaction();
     
        session.save(book);
     
        t.commit();
        session.close();
        return book;
	}
	
	 protected void exit() {
        // code to close Hibernate Session factory
		 sessionFactory.close();
    }
	public List<Book> readData() {
		this.setup();
		return this.read();
	}
	
	public String getMessageOne() {
		return "this is from Book Controllers";
	}
}
