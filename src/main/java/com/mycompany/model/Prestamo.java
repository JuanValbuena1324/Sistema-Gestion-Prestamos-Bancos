package com.mycompany.model;

/**
 *
 * @author Juan Pablo Valbuena
 */
import java.time.LocalDate;

public abstract class Prestamo {

    private int idPrestamo;
    private double monto;
    private double tasaIntereses;
    private int plazoMeses;
    private LocalDate fechaRegistro;
    private String estado;

    public Prestamo(int idPrestamo, double monto, double tasaIntereses, int plazoMeses, LocalDate fechaRegistro) {
        this.idPrestamo = idPrestamo;
        this.monto = monto;
        this.tasaIntereses = tasaIntereses;
        this.plazoMeses = plazoMeses;
        this.fechaRegistro = fechaRegistro;
        this.estado = "AC";
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getTasaIntereses() {
        return tasaIntereses;
    }

    public void setTasaIntereses(double tasaIntereses) {
        this.tasaIntereses = tasaIntereses;
    }

    public int getPlazoMeses() {
        return plazoMeses;
    }

    public void setPlazoMeses(int plazoMeses) {
        this.plazoMeses = plazoMeses;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public abstract double calcularCuotaMensual();

}
