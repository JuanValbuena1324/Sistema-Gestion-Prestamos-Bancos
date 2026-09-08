/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model.services;

import com.mycompany.model.ICambiable;
import com.mycompany.model.IServicioPrestamo;
import com.mycompany.model.Prestamo;
import com.mycompany.model.PrestamoHipotecario;
import com.mycompany.model.PrestamoVehicular;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Juan Pablo Valbuena
 */
public class ServicioPrestamo implements IServicioPrestamo {

    // SINGLETON - INSTANCIA ÚNICA (Estática y privada)
    private static ServicioPrestamo instancia;

    // COLECCIÓN DE DATOS (Ya no es estática, es de instancia)
    private Map<Integer, Prestamo> prestamos;

    // OBSERVER
    private ArrayList<ICambiable> guisPrestamos;

    // MÉTODOS DE INSTANCIA (Ya no son estáticos)
    @Override
    public Map<Integer, Prestamo> getPrestamos() {
        return Map.copyOf(prestamos);
    }

    // CONSTRUCTOR PRIVADO (Evita que se creen instancias externas)
    private ServicioPrestamo() {
        this.prestamos = new HashMap<>();
        this.guisPrestamos = new ArrayList<>(); //INICIALIZAR OBSERVER
    }

    // MÉTODO DE ACCESO A LA INSTANCIA ÚNICA
    public static ServicioPrestamo getInstance() {
        if (instancia == null) {
            instancia = new ServicioPrestamo();
        }
        return instancia;
    }

    // OBSERVER: Métodos de Suscripción
    public void addGUI(ICambiable gui) {
        guisPrestamos.add(gui);

    }

    public void delGUI(ICambiable gui) {
        guisPrestamos.remove(gui);
    }

    // OBSERVER: Método de Notificación
    private void notificar() {
        for (ICambiable gui : guisPrestamos) {
            gui.cambio();
        }
    }

    @Override
    public void addPrestamo(Prestamo prestamo) {
        prestamos.put(prestamo.getIdPrestamo(), prestamo);
        notificar(); // Notifica a GUIs de Listar

    }

    @Override
    public Prestamo buscarPrestamo(int id) {
        return prestamos.get(id);
    }

    @Override
    public boolean eliminarPrestamo(int id) {
        Prestamo prestamo = prestamos.get(id);
        if (prestamo != null) {
            prestamo.setEstado("IN");
            notificar(); 
            return true;
        }
        return false;
    }

    // Método para actualizar los datos permitidos de un préstamo
    @Override
    public boolean actualizarPrestamo(int id, double nuevoMonto, int nuevoPlazo, String nuevoTipoInmueble, double nuevoValorComercial) {
        Prestamo prestamo = prestamos.get(id);
        if (prestamo != null) {

            // 1. Actualizar los atributos comunes (del padre)
            prestamo.setMonto(nuevoMonto);
            prestamo.setPlazoMeses(nuevoPlazo);

            // 2. Actualizar los atributos propios (de las hijas) - Dependiendo del tipo
            if (prestamo instanceof PrestamoHipotecario) {
                PrestamoHipotecario hipo = (PrestamoHipotecario) prestamo;
                hipo.setTipoInmueble(nuevoTipoInmueble);
            } else if (prestamo instanceof PrestamoVehicular) {
                PrestamoVehicular veh = (PrestamoVehicular) prestamo;
                veh.setValorComercial(nuevoValorComercial);
            }

            // 3. Notificar a las GUIs de Listar (¡Este es el paso clave!)
            notificar();

            return true;
        }
        return false;
    }

}
