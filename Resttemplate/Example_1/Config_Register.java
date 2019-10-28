package spring_boot.spring_boot.Resttemplate.Example_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:Register.properties")
public class Config_Register {


    @Value("${url}")
    private String Url;

    @Value("${username}")
    private String user;

    @Value("${password}")
    private String passw;

    @Value("${geturl}")
    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    @Value("${getusername}")
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Value("${getpassword}")
    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public DataSource getDataSource()
    {
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.driverClassName("com.mysql.jdbc.Driver");
        builder.url(Url);
        builder.username(user);
        builder.password(passw);

        return builder.build();
    }

    public JdbcTemplate getJdbcTemplate()
    {
        return new JdbcTemplate(getDataSource());
    }
}
