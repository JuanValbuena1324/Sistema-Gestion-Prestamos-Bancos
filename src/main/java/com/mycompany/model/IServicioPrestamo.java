/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.model;

import com.mycompany.model.Prestamo;
import java.util.Map;

/**
 *
 * @author Juan Pablo Valbuena
 */

// Contrato que define los métodos de gestión de préstamos
public interface IServicioPrestamo {

        // Método para obtener la lista de préstamos
        Map<Integer, Prestamo> getPrestamos();

        // Método para adicionar/crear un préstamo
        void addPrestamo(Prestamo prestamo);

        // Método para buscar un préstamo por ID
        Prestamo buscarPrestamo(int id);

        // Método para eliminar un préstamo por ID
        boolean eliminarPrestamo(int id);

}

