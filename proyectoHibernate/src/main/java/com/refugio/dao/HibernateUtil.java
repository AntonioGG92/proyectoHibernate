package com.refugio.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Clase de utilidad para configurar y proporcionar la {@link SessionFactory} de Hibernate.
 * Se encarga de inicializar y gestionar la configuración de Hibernate para el acceso a la base de datos.
 */
public class HibernateUtil {

    /**
     * Instancia única de la {@link SessionFactory}.
     */
    private static final SessionFactory sessionFactory = buildSessionFactory();

    /**
     * Construye la {@link SessionFactory} utilizando la configuración especificada en el archivo `hibernate.cfg.xml`.
     *
     * @return una instancia de {@link SessionFactory}.
     * @throws ExceptionInInitializerError si ocurre algún error al inicializar la {@link SessionFactory}.
     */
    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Proporciona la instancia única de {@link SessionFactory}.
     *
     * @return la instancia de {@link SessionFactory}.
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
