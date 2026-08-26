/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model.services;

import com.mycompany.model.Prestamo;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Juan Pablo Valbuena
 */
public class ServicioPrestamo {

    private static Map<Integer, Prestamo> prestamos = new HashMap();

    public static Map<Integer, Prestamo> getPrestamos() {
        return Map.copyOf(prestamos);
    }

    public static void addPrestamo(Prestamo prestamo) {
        prestamos.put(prestamo.getIdPrestamo(), prestamo);
    }

    public static Prestamo buscarPrestamo(int id) {
        return prestamos.get(id);
    }

    public static boolean eliminarPrestamo(int id) {
        if (prestamos.containsKey(id)) {
            prestamos.remove(id);
            return true;
        }
        return false;
    }
}
