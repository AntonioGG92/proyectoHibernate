package com.refugio.dao;

import com.refugio.model.Animal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class AnimalDAOTest {

    @Test
    public void testSaveAndFindByEspecie() {
        AnimalDAO animalDAO = new AnimalDAO();

        Animal animal = new Animal();
        animal.setNombre("Paco");
        animal.setEspecie("Podenco");
        animal.setEdad(14);
        animal.setDescripcion("Perro blanco con mancha en la cara negra");
        animal.setEstado("recién abandonado");

        String nombreFamilia = "Guerrero";
        int edadFamilia = 36;
        String ciudadFamilia = "Sevilla";

        animalDAO.saveAnimal(animal, nombreFamilia, edadFamilia, ciudadFamilia);

        List<Animal> perros = animalDAO.findByEspecie("Podenco");
        assertFalse(perros.isEmpty());
        assertEquals("Paco", perros.get(0).getNombre());
    }

    @Test
    public void testUpdateEstado() {
        AnimalDAO animalDAO = new AnimalDAO();

        Animal animal = new Animal();
        animal.setNombre("Paco");
        animal.setEspecie("Podenco");
        animal.setEdad(14);
        animal.setDescripcion("Perro blanco con mancha en la cara negra");
        animal.setEstado("recién abandonado");

        animalDAO.saveAnimal(animal, "Guerrero", 36, "Sevilla");

        List<Animal> perros = animalDAO.findByEspecie("Podenco");
        Long animalId = perros.get(0).getId();

        String nuevoEstado = "Acogida";
        animalDAO.updateEstado(animalId, nuevoEstado);

        List<Animal> perrosActualizados = animalDAO.findByEspecie("Podenco");
        assertEquals(nuevoEstado, perrosActualizados.get(0).getEstado());
    }

    @Test
    public void testUpdateFamilia() {
        AnimalDAO animalDAO = new AnimalDAO();

        Animal animal = new Animal();
        animal.setNombre("Paco");
        animal.setEspecie("Podenco");
        animal.setEdad(14);
        animal.setDescripcion("Perro blanco con mancha en la cara negra");
        animal.setEstado("recién abandonado");

        animalDAO.saveAnimal(animal, "Guerrero", 36, "Sevilla");

        List<Animal> perros = animalDAO.findByEspecie("Podenco");
        Long animalId = perros.get(0).getId();

        String nuevaFamilia = "Nueva Familia";
        int nuevaEdad = 40;
        String nuevaCiudad = "Madrid";

        animalDAO.updateFamilia(animalId, nuevaFamilia, nuevaEdad, nuevaCiudad);

        List<Animal> perrosActualizados = animalDAO.findByEspecie("Podenco");
        assertEquals(nuevaFamilia, perrosActualizados.get(0).getFamilia().getNombre());
        assertEquals(nuevaEdad, perrosActualizados.get(0).getFamilia().getEdad());
        assertEquals(nuevaCiudad, perrosActualizados.get(0).getFamilia().getCiudad());
    }
}