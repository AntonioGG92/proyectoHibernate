package com.refugio.model;

import javax.persistence.*;
import java.util.List;

/**
 * Representa una familia que acoge animales en el refugio.
 * Contiene información básica de la familia, como nombre, edad del responsable y ciudad.
 * También tiene una relación con los animales acogidos por esta familia.
 */
@Entity
@Table(name = "familias")
public class Familia {

    /**
     * ID único de la familia.
     * Generado automáticamente por la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del responsable de la familia.
     * No puede ser nulo.
     */
    @Column(nullable = false)
    private String nombre;

    /**
     * Edad del responsable de la familia.
     * No puede ser nulo.
     */
    @Column(nullable = false)
    private int edad;

    /**
     * Ciudad donde reside la familia.
     * No puede ser nulo.
     */
    @Column(nullable = false)
    private String ciudad;

    /**
     * Lista de animales acogidos por esta familia.
     * Relación de uno a muchos con la clase {@link Animal}.
     */
    @OneToMany(mappedBy = "familia", cascade = CascadeType.ALL)
    private List<Animal> animales;

    // Getters y Setters

    /**
     * Obtiene el ID único de la familia.
     *
     * @return el ID de la familia.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID único de la familia.
     *
     * @param id el nuevo ID de la familia.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del responsable de la familia.
     *
     * @return el nombre del responsable.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del responsable de la familia.
     *
     * @param nombre el nuevo nombre del responsable.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la edad del responsable de la familia.
     *
     * @return la edad del responsable.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad del responsable de la familia.
     *
     * @param edad la nueva edad del responsable.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Obtiene la ciudad donde reside la familia.
     *
     * @return la ciudad de la familia.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece la ciudad donde reside la familia.
     *
     * @param ciudad la nueva ciudad de la familia.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Obtiene la lista de animales acogidos por esta familia.
     *
     * @return la lista de animales acogidos.
     */
    public List<Animal> getAnimales() {
        return animales;
    }

    /**
     * Establece la lista de animales acogidos por esta familia.
     *
     * @param animales la nueva lista de animales.
     */
    public void setAnimales(List<Animal> animales) {
        this.animales = animales;
    }
}
