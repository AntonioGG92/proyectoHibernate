package com.refugio.service;

import com.refugio.dao.AnimalDAO;
import com.refugio.model.Animal;

import java.util.List;

/**
 * Servicio que proporciona métodos para gestionar animales en el refugio.
 * Actúa como un intermediario entre el controlador y el DAO.
 */
public class AnimalService {

    /**
     * DAO para realizar operaciones relacionadas con animales.
     */
    private AnimalDAO animalDAO;

    /**
     * Constructor que inicializa el DAO de animales.
     */
    public AnimalService() {
        this.animalDAO = new AnimalDAO();
    }

    /**
     * Registra un nuevo animal en la base de datos.
     * Si la familia asociada no existe, se crea.
     *
     * @param animal         el animal a registrar.
     * @param nombreFamilia  el nombre de la familia que acoge al animal.
     * @param edadFamilia    la edad del responsable de la familia.
     * @param ciudadFamilia  la ciudad donde reside la familia.
     */
    public void registrarAnimal(Animal animal, String nombreFamilia, int edadFamilia, String ciudadFamilia) {
        animalDAO.saveAnimal(animal, nombreFamilia, edadFamilia, ciudadFamilia);
    }

    /**
     * Busca animales en la base de datos según su especie.
     *
     * @param especie la especie de los animales a buscar.
     * @return una lista de animales que coinciden con la especie.
     */
    public List<Animal> buscarPorEspecie(String especie) {
        return animalDAO.findByEspecie(especie);
    }

    /**
     * Actualiza el estado de un animal en la base de datos.
     *
     * @param id          el ID del animal a actualizar.
     * @param nuevoEstado el nuevo estado del animal.
     */
    public void actualizarEstado(Long id, String nuevoEstado) {
        animalDAO.updateEstado(id, nuevoEstado);
    }

    /**
     * Actualiza los datos de la familia que acoge a un animal en la base de datos.
     * Si la familia no existe, se crea.
     *
     * @param id           el ID del animal cuya familia se va a actualizar.
     * @param nombreFamilia el nombre de la nueva familia.
     * @param edadFamilia   la edad del responsable de la familia.
     * @param ciudadFamilia la ciudad de la nueva familia.
     */
    public void actualizarFamilia(Long id, String nombreFamilia, int edadFamilia, String ciudadFamilia) {
        animalDAO.updateFamilia(id, nombreFamilia, edadFamilia, ciudadFamilia);
    }

    /**
     * Obtiene todos los animales registrados en la base de datos.
     *
     * @return una lista de todos los animales.
     */
    public List<Animal> obtenerTodosLosAnimales() {
        return animalDAO.findAll();
    }
}
