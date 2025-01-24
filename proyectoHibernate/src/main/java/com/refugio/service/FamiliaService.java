package com.refugio.service;

import com.refugio.dao.FamiliaDAO;
import com.refugio.model.Familia;

/**
 * Servicio que proporciona métodos para gestionar las familias en el refugio.
 * Actúa como intermediario entre el controlador y el DAO de familias.
 */
public class FamiliaService {

    /**
     * DAO para realizar operaciones relacionadas con familias.
     */
    private FamiliaDAO familiaDAO;

    /**
     * Constructor que inicializa el DAO de familias.
     */
    public FamiliaService() {
        this.familiaDAO = new FamiliaDAO();
    }

    /**
     * Obtiene una familia de la base de datos según su ID.
     *
     * @param id el ID de la familia a buscar.
     * @return la familia encontrada, o {@code null} si no existe.
     */
    public Familia obtenerFamiliaPorId(long id) {
        return familiaDAO.findById(id);
    }
}
