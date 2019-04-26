package cn.edu.hfut.dmic.webcollector.plugin.mysql;

import java.util.HashMap;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

//import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 */
public class JDBCHelper {

    public static HashMap<String, JdbcTemplate> templateMap
            = new HashMap<String, JdbcTemplate>();

    public static JdbcTemplate createMysqlTemplate(String templateName,
                                                   String url, String username, String password,
                                                   int initialSize, int maxActive) {

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxActive(maxActive);
        JdbcTemplate template = new JdbcTemplate(dataSource);
        templateMap.put(templateName, template);
        return template;
    }

    public static JdbcTemplate getJdbcTemplate(String templateName){
        return templateMap.get(templateName);
    }

//    public static void main(String[] args) {
//        JDBCHelper.createMysqlTemplate("news", "jdbc:mysql://localhost:3306/db_whukg?characterEncoding=utf-8", "root", "password", 3, 100);
//    }

}