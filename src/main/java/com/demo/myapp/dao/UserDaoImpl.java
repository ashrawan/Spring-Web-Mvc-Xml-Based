package com.demo.myapp.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.myapp.model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    Session session = null;

    
    public List<User> getAllUsers() {
        session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        criteria.from(User.class);
        List<User> userList = session.createQuery(criteria).getResultList();
        return userList;
    }
    
    @Override
    
    public User addUser(User user) {
        session = sessionFactory.getCurrentSession();
        user.setStatus(1);
        session.save(user);
        return user;
    }

    @Override
    
    public User getUser(long id) {
        session = sessionFactory.getCurrentSession();
        User user = session.find(User.class, id);
        return user;
    }

    @Override
    
    public User updateUser(User user) {
        session = sessionFactory.getCurrentSession();
        session.update(user);
        return user;
    }

    @Override
    
    public void deleteUser(long id) {
        session = sessionFactory.getCurrentSession();
        User user = session.find(User.class, id);
        session.delete(user);
    }


}
