package com.homebudget.authservice.dao;

import com.homebudget.authservice.entity.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;

@Transactional
@Repository
public class UserDaoImp implements UserDao{

    private final Log logger = LogFactory.getLog(getClass());

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Collection<User> findAllUsers() {
        String  configFileLocation = getClass().getProtectionDomain().getCodeSource().getLocation().getPath() + "hibernate.cfg.xml";
        logger.info(configFileLocation);
        String sql = "FROM User";
        return (Collection<User>)entityManager.createQuery(sql).getResultList();
    }

    @Override
    public User findByUsername(String username) {
        String sql = "FROM User u WHERE u.email = :username";
        return (User)entityManager.createQuery(sql).getResultList();
    }

    @Override
    public void saveUser(User user) {
        logger.info(user.getEmail());
        logger.info(user.getPassword());
        try {
            entityManager.persist(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
