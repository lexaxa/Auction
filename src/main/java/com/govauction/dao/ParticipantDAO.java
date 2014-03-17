package com.govauction.dao;

import com.govauction.dao.impl.AbstractDaoImpl;
import com.govauction.entity.Participant;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParticipantDAO extends AbstractDaoImpl<Participant> {

    @Override
    public void fillCreateStatement(PreparedStatement pstmt, Participant entity) {
        try {
            pstmt.setLong(1, entity.getParticipantId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void fillEditStatement(PreparedStatement pstmt, Participant entity) {
        try {
            pstmt.setLong(1, entity.getParticipantId());
            pstmt.setLong(2, entity.getParticipantId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Participant getEntity(ResultSet resultSet) {
        try {
            Participant participant = new Participant();
            participant.setParticipantId(resultSet.getLong("participantId"));
            return participant;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getCreateQuery() {
        return dbUtil.getQuery("create.participant");
    }

    @Override
    public String getDeleteQuery() {
        return dbUtil.getQuery("delete.participant");
    }

    @Override
    public String getEditQuery() {
        return dbUtil.getQuery("update.participant");
    }

    @Override
    public String getGetByIdQuery() {
        return dbUtil.getQuery("get.participant.by.id");
    }

    @Override
    public String getGetAllQuery() {
        return dbUtil.getQuery("get.all.participants");
    }
}
