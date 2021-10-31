package com.codegym.repository;

import com.codegym.model.Song;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class SongRepositoryImpl implements ISongRepository {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Song> findAll() {
       Session session = null;
       Transaction transaction = null;
       List<Song> songList = new ArrayList<>();
       try {
           session = sessionFactory.openSession();
           transaction = session.beginTransaction();
           songList = session.createQuery("FROM Song ").getResultList();
           transaction.commit();
       }catch (Exception e){
           e.printStackTrace();
           if(transaction != null){
               transaction.rollback();
           }
       }finally {
           if(session != null){
               session.close();
           }
       }
       return songList;
    }

    @Override
    public void save(Song song) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
           session.save(song);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }finally {
            if(session != null){
                session.close();
            }
        }
    }


    @Override
    public Song findById(int id) {
       String stringQuery = "select s from Song as s where s.id = :id";
       Song song = new Song();
       try {
           TypedQuery<Song> typedQuery = entityManager.createQuery(stringQuery,Song.class);
           typedQuery.setParameter("id",id);
           song = typedQuery.getSingleResult();
       }catch (Exception e){
           e.printStackTrace();
       }
        return song;
    }

    @Override
    public void update(Song song) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Song oldSong = findById(song.getId());
            oldSong.setSingerName(song.getSingerName());
            oldSong.setSong(song.getSong());
            oldSong.setSongName(song.getSongName());
            oldSong.setSongType(song.getSongType());
            session.saveOrUpdate(oldSong);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    @Override
    public void remove(int id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Song song = findById(id);
            session.remove(song);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }finally {
            if(session != null){
                session.close();
            }
        }
    }
}
