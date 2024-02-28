package com.compassuol.sp.challenge.msaddress.database;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class DatabaseConnectionTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void whenConnected_thenReturnsTrue() {
        assertThat(jdbcTemplate).isNotNull();
    }
}