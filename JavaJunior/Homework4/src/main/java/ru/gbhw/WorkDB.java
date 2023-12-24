package ru.gbhw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class WorkDB {
    private SessionFactory sessionFactory;

    public WorkDB() {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml")
            .addAnnotatedClass(Course.class).buildSessionFactory();
    }

    public void recreateTable() {
        final String URL = "jdbc:mysql://host:3306/SchoolDB";
        final String USER = "user";
        final String PASSWORD = "password";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)){
            String sqlDrop = "drop table if exists Courses;";
            String sqlCreate = "create table Courses(id int not null auto_increment, title varchar(255) not null, duration double not null, primary key(id));";
            execStatment(connection.prepareStatement(sqlDrop));
            execStatment(connection.prepareStatement(sqlCreate));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void execStatment(PreparedStatement statement) throws SQLException {
        statement.execute();
        statement.close();
    }

    public void insertData(Course course) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(course);
        System.out.println("Save course: " + course);
        session.getTransaction().commit();
        session.close();
    }

    public void update(int id, String title, double duration) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Course course = session.get(Course.class, id);
        if(course != null) {
            course.setTitle(title);
            course.setDuration(duration);
            session.update(course);
            System.out.println("Update course: " + course);
            session.getTransaction().commit();
        }
        session.close();
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Course course = session.get(Course.class, id);
        if(course != null) {
            session.delete(course);
            System.out.println("Delete course: " + course);
            session.getTransaction().commit();
        }
        session.close();
    }

    public Course selectId(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Course course = session.get(Course.class, id);
        session.close();
        return course;
    }

    public List<Course> selectAll() {
        List<Course> courses;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        courses = session.createQuery("SELECT course FROM Course course", Course.class).getResultList();
        session.getTransaction();
        session.close();
        return courses;
    }
}
