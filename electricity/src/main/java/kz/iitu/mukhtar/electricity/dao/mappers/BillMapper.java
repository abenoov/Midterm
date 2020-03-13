package kz.iitu.mukhtar.electricity.dao.mappers;

import kz.iitu.mukhtar.electricity.entity.Bill;
import kz.iitu.mukhtar.electricity.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BillMapper implements RowMapper<Bill> {
    @Override
    public Bill mapRow(ResultSet resultSet, int i) throws SQLException {
        Bill bill = new Bill();
        bill.setId(resultSet.getInt(1));
        bill.setName(resultSet.getString(2));
        bill.setKwh(resultSet.getInt(3));
        bill.setPrice(resultSet.getInt(4));


        return bill;
    }
}
