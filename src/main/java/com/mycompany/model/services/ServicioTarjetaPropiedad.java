/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model.services;

import com.mycompany.model.TarjetaPropiedad;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Juan Pablo Valbuena
 */

public class ServicioTarjetaPropiedad {

    // SINGLETON
    private static ServicioTarjetaPropiedad instancia;

    // COLECCIÓN (Map, diferente a List)
    private Map<String, TarjetaPropiedad> tarjetas;

    // CONSTRUCTOR PRIVADO
    private ServicioTarjetaPropiedad() {
        this.tarjetas = new HashMap<>();
    }

    // MÉTODO DE ACCESO A LA INSTANCIA ÚNICA
    public static ServicioTarjetaPropiedad getInstance() {
        if (instancia == null) {
            instancia = new ServicioTarjetaPropiedad();
        }
        return instancia;
    }

    // MÉTODOS DE CRUD
    public Map<String, TarjetaPropiedad> getTarjetas() {
        return Map.copyOf(tarjetas);
    }

    public void addTarjetaPropiedad(TarjetaPropiedad tarjeta) {
        tarjetas.put(tarjeta.getPlaca(), tarjeta);
    }

    public TarjetaPropiedad buscarTarjetaPropiedad(String placa) {
        return tarjetas.get(placa);
    }

    public boolean eliminarTarjetaPropiedad(String placa) {
        if (tarjetas.containsKey(placa)) {
            tarjetas.remove(placa);
            return true;
        }
        return false;
    }

}
