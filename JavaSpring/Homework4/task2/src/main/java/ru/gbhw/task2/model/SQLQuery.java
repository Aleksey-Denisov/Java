package ru.gbhw.task2.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesScan
@ConfigurationProperties(prefix = "sql")
@Data
public class SQLQuery {
    //Поля
    private String select;
    private String insert;
    private String delete;
    private String update;
}
