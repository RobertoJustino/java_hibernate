package com.hitema.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Configuration et initialisation du framework Hibernate
 */
public class FactoryHibernate {

    private static final Logger log = LoggerFactory.getLogger(FactoryHibernate.class);


    private static String VERSION = "DAO Hibernate 1.0";

    private static SessionFactory sessionFactory;

    private static Session session;

    public static Session getSession() {
        if (session == null){
            try{
                session = getSessionFactory().openSession();
            } catch (Exception e) {
                log.error("ERROR while get session : {} ", e.getLocalizedMessage());
            }
        }
        return session;
    }

    public static SessionFactory getSessionFactory() throws Exception {
        if ( sessionFactory == null ) {
            log.info("Version DAO/Service :"+VERSION);
            // Create registry
            StandardServiceRegistry
                    registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();

            // Create MetadataSources
            MetadataSources sources = new MetadataSources(registry);

            // Create Metadata
            Metadata metadata = sources.getMetadataBuilder().build();

            // Create SessionFactory
            sessionFactory = metadata.getSessionFactoryBuilder().build();
        }
        return sessionFactory;
    }

}
