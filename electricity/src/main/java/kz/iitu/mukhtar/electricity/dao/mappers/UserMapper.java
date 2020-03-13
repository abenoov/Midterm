package kz.iitu.mukhtar.electricity.dao.mappers;

import kz.iitu.mukhtar.electricity.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt(1));
        user.setName(resultSet.getString(2));
        user.setMoney(resultSet.getInt(3));


        return user;
    }
}
