package com.refugio.dao;

import com.refugio.model.Animal;
import com.refugio.model.Familia;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Clase que proporciona acceso a los datos relacionados con los animales y las familias en la base de datos.
 * Utiliza Hibernate para realizar operaciones CRUD.
 */
public class AnimalDAO {

    /**
     * Guarda un nuevo animal en la base de datos. Si la familia asociada no existe, la crea.
     *
     * @param animal         el animal que se va a guardar.
     * @param nombreFamilia  el nombre de la familia que acoge al animal.
     * @param edadFamilia    la edad del responsable de la familia.
     * @param ciudadFamilia  la ciudad donde reside la familia.
     */
    public void saveAnimal(Animal animal, String nombreFamilia, int edadFamilia, String ciudadFamilia) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            // Buscar o crear la familia
            Familia familia = findOrCreateFamilia(session, nombreFamilia, edadFamilia, ciudadFamilia);

            // Asignar la familia al animal y guardar el animal
            animal.setFamilia(familia);
            session.save(animal);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * Busca y devuelve una lista de animales según su especie.
     *
     * @param especie la especie de los animales a buscar.
     * @return una lista de animales que coinciden con la especie proporcionada.
     */
    public List<Animal> findByEspecie(String especie) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Animal> query = session.createQuery("FROM Animal WHERE especie = :especie", Animal.class);
            query.setParameter("especie", especie);
            return query.list();
        }
    }

    /**
     * Actualiza el estado de un animal en la base de datos.
     *
     * @param id          el ID del animal cuyo estado se va a actualizar.
     * @param nuevoEstado el nuevo estado del animal.
     */
    public void updateEstado(Long id, String nuevoEstado) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // Buscar el animal por ID
            Animal animal = session.get(Animal.class, id);
            if (animal != null) {
                animal.setEstado(nuevoEstado);
                session.update(animal);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    /**
     * Actualiza los datos de la familia que acoge a un animal.
     *
     * @param id           el ID del animal cuyo dato de familia se va a actualizar.
     * @param nombreFamilia el nombre de la nueva familia.
     * @param edadFamilia   la edad del responsable de la nueva familia.
     * @param ciudadFamilia la ciudad de la nueva familia.
     */
    public void updateFamilia(Long id, String nombreFamilia, int edadFamilia, String ciudadFamilia) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // Buscar el animal por ID
            Animal animal = session.get(Animal.class, id);
            if (animal != null) {
                // Buscar o crear la familia
                Familia familia = findOrCreateFamilia(session, nombreFamilia, edadFamilia, ciudadFamilia);

                // Asignar la familia al animal y actualizar
                animal.setFamilia(familia);
                session.update(animal);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    /**
     * Devuelve una lista de todos los animales almacenados en la base de datos.
     *
     * @return una lista de todos los animales.
     */
    public List<Animal> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Animal> query = session.createQuery("FROM Animal", Animal.class);
            return query.list();
        }
    }

    /**
     * Busca una familia por su nombre. Si no existe, crea una nueva familia.
     *
     * @param session      la sesión de Hibernate actual.
     * @param nombreFamilia el nombre de la familia a buscar o crear.
     * @param edadFamilia   la edad del responsable de la familia.
     * @param ciudadFamilia la ciudad de la familia.
     * @return la familia encontrada o creada.
     * @throws IllegalArgumentException si el nombre de la familia es nulo o vacío.
     */
    private Familia findOrCreateFamilia(Session session, String nombreFamilia, int edadFamilia, String ciudadFamilia) {
        if (nombreFamilia == null || nombreFamilia.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la familia no puede ser nulo o vacío");
        }

        // Buscar la familia existente
        Query<Familia> query = session.createQuery("FROM Familia WHERE nombre = :nombre", Familia.class);
        query.setParameter("nombre", nombreFamilia);
        Familia familia = query.uniqueResult();

        if (familia == null) {
            // Crear una nueva familia si no existe
            familia = new Familia();
            familia.setNombre(nombreFamilia);
            familia.setEdad(edadFamilia);
            familia.setCiudad(ciudadFamilia);
            session.save(familia); // Guardar la nueva familia
        } else {
            // Actualizar los detalles de la familia existente si es necesario
            familia.setEdad(edadFamilia);
            familia.setCiudad(ciudadFamilia);
            session.update(familia);
        }

        return familia;
    }
}
