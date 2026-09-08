package com.mycompany.model;

public class TarjetaPropiedad {

    private String placa;
    private String numMotor;
    private String estado;

    public TarjetaPropiedad(String placa, String numMotor) {
        this.placa = placa;
        this.numMotor = numMotor;
        this.estado = "AC";
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNumMotor() {
        return numMotor;
    }

    public void setNumMotor(String numMotor) {
        this.numMotor = numMotor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String mostrarTarjetaPropiedad() {
        return "Tarjeta de Propiedad:\n"
                + "Placa del Vehículo: " + placa + "\n"
                + "Número de Motor: " + numMotor;
    }
}
