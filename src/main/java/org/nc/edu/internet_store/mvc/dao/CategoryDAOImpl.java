package org.nc.edu.internet_store.mvc.dao;

import org.hibernate.Session;
import org.nc.edu.internet_store.mvc.domain.Category;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;

@Repository
public class CategoryDAOImpl implements CategoryDAO{

    @Autowired
    private SessionFactory sessionFactory;

    public void addCategory(Category category){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(category);
        session.close();
    }

    @SuppressWarnings("unchecked")
    public List<Category> listCategory() {
        String query = "    from Category ";
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Category> list = session.createQuery(query).list();
        session.close();
        return list;
    }

    public void removeCategory(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        //Category category = session.load(Category.class, id);
        Query query = session.createQuery("delete from Category where id = :id");
        query.setParameter("id",id);
        query.executeUpdate();
        session.close();
    }
}
