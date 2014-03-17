package com.govauction.dao.impl;

import com.govauction.util.DatabaseUtil;
import com.govauction.dao.GenericDAO1;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created with IntelliJ IDEA.
 * User: akuzin
 * Date: 15.07.13
 * Time: 12:44
 * To change this template use File | Settings | File Templates.
 */
public abstract class GenericDAOImplTest<T> implements GenericDAO1<T> {

    @PersistenceContext
    protected EntityManager em;

    private Class<T> type;

    public GenericDAOImplTest(){
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    DatabaseUtil dbUtil = new DatabaseUtil();

    @Override
    public void create(T entity) {
        this.em.persist(entity);
        /*
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            connection = dbUtil.getConnection();
            String query = getCreateQuery();
            pstmt = connection.prepareStatement(query,  Statement.RETURN_GENERATED_KEYS);
            fillCreateStatement(pstmt, entity);
            pstmt.executeUpdate();

            resultSet = pstmt.getGeneratedKeys();
            if (resultSet.next()){
                Integer generatedId = resultSet.getInt(1);
                return getById(generatedId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null)  try { resultSet.close(); } catch (SQLException logOrIgnore) {}
            if (pstmt != null)      try { pstmt.close(); } catch (SQLException logOrIgnore) {}
            if (connection != null) try { connection.close(); } catch (SQLException logOrIgnore) {}
        }

        return null;
        */
    }

    @Override
    public void delete(T entity) {
        this.em.remove(entity);
        /*
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = dbUtil.getConnection();
            String query = getDeleteQuery();
            pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, entity.getId());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null)      try { pstmt.close(); } catch (SQLException logOrIgnore) {}
            if (connection != null) try { connection.close(); } catch (SQLException logOrIgnore) {}
        }
        */
    }

    @Override
    public void edit(T entity) {
        this.em.merge(entity);
        /*
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = dbUtil.getConnection();
            String query = getEditQuery();
            pstmt = connection.prepareStatement(query);
            fillEditStatement(pstmt, entity);
            pstmt.executeUpdate();
            return entity;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null)      try { pstmt.close(); } catch (SQLException logOrIgnore) {}
            if (connection != null) try { connection.close(); } catch (SQLException logOrIgnore) {}
        }
        return null;
        */
    }

    @Override
    public T getById(Long id) {
        return (T) this.em.find(type,id);
        /*
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            connection = dbUtil.getConnection();
            String query = getGetByIdQuery();
            pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id);
            resultSet = pstmt.executeQuery();
            if (resultSet.next()){
                return getEntity(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null)  try { resultSet.close(); } catch (SQLException logOrIgnore) {}
            if (pstmt != null)      try { pstmt.close(); } catch (SQLException logOrIgnore) {}
            if (connection != null) try { connection.close(); } catch (SQLException logOrIgnore) {}
        }
        return null;
        */
    }

/*    @Override
    public List<T> getAll() {

        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        List<T> list = new ArrayList<T>();
        try {
            connection = dbUtil.getConnection();
            String query = getGetAllQuery();
            pstmt = connection.prepareStatement(query);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()){
                list.add(getEntity(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null)  try { resultSet.close(); } catch (SQLException logOrIgnore) {}
            if (pstmt != null)      try { pstmt.close(); } catch (SQLException logOrIgnore) {}
            if (connection != null) try { connection.close(); } catch (SQLException logOrIgnore) {}
        }
        return list;
    }
*/
    public abstract void fillCreateStatement(PreparedStatement pstmt, T entity);
    public abstract void fillEditStatement(PreparedStatement pstmt, T entity);
    public abstract T getEntity(ResultSet resultSet);


    public abstract String getCreateQuery();
    public abstract String getDeleteQuery();
    public abstract String getEditQuery();
    public abstract String getGetByIdQuery();
    public abstract String getGetAllQuery();


}