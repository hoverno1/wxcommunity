package dn.MyConfig;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;

@Configuration
public class MyConfig {
    @Bean
    public DataModel getMySQLDataModel() throws IOException {
        //读取数据库方式失败
//        MysqlDataSource dataSource= new MysqlDataSource();
//        dataSource.setServerName("localhost");
//        dataSource.setUser("root");
//        dataSource.setPassword("root");
//        dataSource.setDatabaseName("wxcommunity");
//        JDBCDataModel dataModel = new MySQLJDBCDataModel(dataSource, "score", "aid", "postId",
//                "score","ts");
        DataModel dataModel = new FileDataModel(new File("C:\\Users\\Administrator\\Desktop\\dataset.csv"));
        return dataModel;
    }
}
