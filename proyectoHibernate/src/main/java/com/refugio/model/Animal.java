package com.refugio.model;

import javax.persistence.*;

/**
 * Representa un animal registrado en el refugio.
 * Contiene información básica como nombre, especie, edad, descripción y estado.
 * Además, tiene una relación con la familia que lo acoge.
 */
@Entity
@Table(name = "animales")
public class Animal {

    /**
     * ID único del animal.
     * Generado automáticamente por la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del animal.
     * No puede ser nulo.
     */
    @Column(nullable = false)
    private String nombre;

    /**
     * Especie del animal (e.g., perro, gato).
     * No puede ser nulo.
     */
    @Column(nullable = false)
    private String especie;

    /**
     * Edad del animal en años.
     * No puede ser nulo.
     */
    @Column(nullable = false)
    private int edad;

    /**
     * Descripción del animal (e.g., comportamiento o características).
     * Longitud máxima de 500 caracteres.
     */
    @Column(length = 500)
    private String descripcion;

    /**
     * Estado actual del animal (e.g., "recién abandonado", "adoptado").
     * No puede ser nulo.
     */
    @Column(nullable = false)
    private String estado;

    /**
     * Familia que acoge al animal.
     * Relación de muchos a uno con la tabla "familias".
     * No puede ser nulo.
     */
    @ManyToOne
    @JoinColumn(name = "familia_id", nullable = false)
    private Familia familia;

    // Getters y Setters

    /**
     * Obtiene el ID único del animal.
     *
     * @return el ID del animal.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID único del animal.
     *
     * @param id el nuevo ID del animal.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del animal.
     *
     * @return el nombre del animal.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del animal.
     *
     * @param nombre el nuevo nombre del animal.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la especie del animal.
     *
     * @return la especie del animal.
     */
    public String getEspecie() {
        return especie;
    }

    /**
     * Establece la especie del animal.
     *
     * @param especie la nueva especie del animal.
     */
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    /**
     * Obtiene la edad del animal en años.
     *
     * @return la edad del animal.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad del animal en años.
     *
     * @param edad la nueva edad del animal.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Obtiene la descripción del animal.
     *
     * @return la descripción del animal.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del animal.
     *
     * @param descripcion la nueva descripción del animal.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el estado actual del animal.
     *
     * @return el estado del animal.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado actual del animal.
     *
     * @param estado el nuevo estado del animal.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene la familia que acoge al animal.
     *
     * @return la familia que acoge al animal.
     */
    public Familia getFamilia() {
        return familia;
    }

    /**
     * Establece la familia que acoge al animal.
     *
     * @param familia la nueva familia que acoge al animal.
     */
    public void setFamilia(Familia familia) {
        this.familia = familia;
    }
}
