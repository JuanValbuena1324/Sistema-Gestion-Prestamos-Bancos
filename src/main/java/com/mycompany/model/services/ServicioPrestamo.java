/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model.services;

import com.mycompany.model.IServicioPrestamo;
import com.mycompany.model.Prestamo;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Juan Pablo Valbuena
 */
public class ServicioPrestamo implements IServicioPrestamo {

    // 1. INSTANCIA ÚNICA (Estática y privada)
    private static ServicioPrestamo instancia;

    // 2. COLECCIÓN DE DATOS (Ya no es estática, es de instancia)
    private Map<Integer, Prestamo> prestamos;

    // 3. MÉTODOS DE INSTANCIA (Ya no son estáticos)
    @Override
    public Map<Integer, Prestamo> getPrestamos() {
        return Map.copyOf(prestamos);
    }

    // 4. CONSTRUCTOR PRIVADO (Evita que se creen instancias externas)
    private ServicioPrestamo() {
        this.prestamos = new HashMap<>();
    }

    // 5. MÉTODO DE ACCESO A LA INSTANCIA ÚNICA
    public static ServicioPrestamo getInstance() {
        if (instancia == null) {
            instancia = new ServicioPrestamo();
        }
        return instancia;
    }
    
    @Override
    public void addPrestamo(Prestamo prestamo) {
        prestamos.put(prestamo.getIdPrestamo(), prestamo);
    }
    
    @Override
    public Prestamo buscarPrestamo(int id) {
        return prestamos.get(id);
    }
    
    @Override
    public boolean eliminarPrestamo(int id) {
        if (prestamos.containsKey(id)) {
            prestamos.remove(id);
            return true;
        }
        return false;
    }
}
