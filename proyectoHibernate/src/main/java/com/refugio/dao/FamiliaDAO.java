package com.refugio.dao;

import com.refugio.model.Familia;
import org.hibernate.Session;

/** Clase para gestionar operaciones relacionadas con Familias en la base de datos. */
public class FamiliaDAO {
    /**
     * Busca una familia en la base de datos por su ID.
     * @param id el ID de la familia a buscar.
     * @return la familia encontrada o null si no existe.
     */
    public Familia findById(long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Familia.class, id);
        }
    }
}
