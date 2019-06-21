package com.in28minutes.jpa.jpain10steps.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.jpain10steps.entity.User;

@Repository
@Transactional
public class UserDAOService {
    @PersistenceContext
    private EntityManager entityManager;
    
    public long insert(User user) {
        // Open transaction
        entityManager.persist(user);
        // Close transaction
        return user.getId();
    }
    
}
