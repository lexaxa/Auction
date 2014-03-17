package com.govauction.dao;

import com.govauction.dao.impl.AbstractDaoImpl;
import com.govauction.entity.Lot;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: akuzin
 * Date: 28.06.13
 * To change this template use File | Settings | File Templates.
 */
public class LotDAO extends AbstractDaoImpl<Lot> {

    @Override
    public void fillCreateStatement(PreparedStatement pstmt, Lot entity) {
        try {
            pstmt.setLong(1, entity.getLotId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void fillEditStatement(PreparedStatement pstmt, Lot entity) {
        try {
            pstmt.setLong(1, entity.getLotId());
            pstmt.setInt(2, entity.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Lot getEntity(ResultSet resultSet) {
        try {
            Lot lot = new Lot();
            lot.setLotId(resultSet.getLong("lotId"));
            return lot;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getCreateQuery() {
        return dbUtil.getQuery("create.lot");
    }

    @Override
    public String getDeleteQuery() {
        return dbUtil.getQuery("delete.lot");
    }

    @Override
    public String getEditQuery() {
        return dbUtil.getQuery("update.lot");
    }

    @Override
    public String getGetByIdQuery() {
        return dbUtil.getQuery("get.lot.by.id");
    }

    @Override
    public String getGetAllQuery() {
        return dbUtil.getQuery("get.all.lots");
    }
}
