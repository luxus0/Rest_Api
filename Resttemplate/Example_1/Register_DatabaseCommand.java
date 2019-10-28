package spring_boot.spring_boot.Resttemplate.Example_1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@SuppressWarnings("ALL")
@Repository
public class Register_DatabaseCommand
{


    private RegisterRepo repo;
    private static JdbcTemplate jdbcTemplate;
    private static Config_Register config;

    @Autowired
    public Register_DatabaseCommand(JdbcTemplate jdbcTemplate,RegisterRepo repo,Config_Register config) {
        this.jdbcTemplate = jdbcTemplate;
        this.repo = repo;
        this.config = config;
    }

    public static void createDatabase() throws SQLException {
        Connection connection = DriverManager.getConnection(config.getUrl(),config.getUser(),config.getPassw());



        String sql = "CREATE DATABASE DATA";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
    }

    public static void createTable() throws SQLException {
        Connection connection = DriverManager.getConnection(config.getUrl(),config.getUser(),config.getPassw());



        String sql = "CREATE Table Movie(id int not null auto_increment,name text, length int,price int,description text)";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
    }

    public static void insertInto() throws SQLException
    {
        Connection connection = DriverManager.getConnection(config.getUrl(),config.getUser(),config.getPassw());



        String sql = "INSERT  INTO Movie VALUES(1,'Lakers',23,34000,'brakamoea')";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
    }


    public void saveDB(Register register)
    {
        String sql = "INSERT INTO Register VALUES (?,?,?,?,?,?)";

        jdbcTemplate.update(sql,new Object[]{
                register.getId(),
                register.getName(),
                register.getGender(),
                register.getDateOfBirth(),
                register.getWeight(),
                register.getDestination()

        });
    }

    public static void saveDB2() throws SQLException {
        Connection connection = DriverManager.getConnection(config.getUrl(),config.getUser(),config.getPassw());



        String sql = "INSERT INTO Register VALUES('Jsko', 'men','31.07.2008',86 ,'POLAND')";
        Statement statement = connection.createStatement();
       statement.executeUpdate(sql);

    }

    public static void read(Long id)
    {
        String sql = "SELECT name,weight FROM Register WHERE id = ?";

        jdbcTemplate.queryForList(sql,new Object[]{id});


    }

    public void delete()
    {
        String sql = "DELETE * FROM Register";
        jdbcTemplate.update(sql);
        System.out.println("DELETE ALL");
    }




    @EventListener(ApplicationReadyEvent.class)
public void saveDatabase()
{
   Register register = new Register("Bazyl","Male","30.07.2008",90,"1");
    saveDB(register);
    repo.save(register);
}

public static void main(String args[]) throws SQLException {
        createDatabase();
        createTable();
        insertInto();
}

}
