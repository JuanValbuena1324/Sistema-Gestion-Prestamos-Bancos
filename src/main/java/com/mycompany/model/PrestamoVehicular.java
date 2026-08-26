package com.mycompany.model;

import java.time.LocalDate;

/**
 *
 * @author Juan Pablo Valbuena
 */
public class PrestamoVehicular extends Prestamo {

    private double valorComercial;
    private String marcaVehiculo;
    
    private TarjetaPropiedad tarjetaPropiedad;

    public PrestamoVehicular(int idPrestamo, double monto, double tasaIntereses, int plazoMeses, LocalDate fechaRegistro, double valorComercial, String marcaVehiculo, TarjetaPropiedad tarjetaPropiedad) {
        super(idPrestamo, monto, tasaIntereses, plazoMeses, fechaRegistro);
        this.valorComercial = valorComercial;
        this.marcaVehiculo = marcaVehiculo;
        this.tarjetaPropiedad = tarjetaPropiedad;
    }

    public double getValorComercial() {
        return valorComercial;
    }

    public void setValorComercial(double valorComercial) {
        this.valorComercial = valorComercial;
    }

    public String getMarcaVehiculo() {
        return marcaVehiculo;
    }

    public void setMarcaVehiculo(String marcaVehiculo) {
        this.marcaVehiculo = marcaVehiculo;
    }

    // GETTER Y SETTER DE LA ASOCIACIÓN
    public TarjetaPropiedad getTarjetaPropiedad() {
        return tarjetaPropiedad;
    }

    public void setTarjetaPropiedad(TarjetaPropiedad tarjetaPropiedad) {
        this.tarjetaPropiedad = tarjetaPropiedad;
    }

    @Override
    public double calcularCuotaMensual() {

        try {
            double tasaMensual = getTasaIntereses() / 12 / 100;
            int plazoMeses = getPlazoMeses();
            double monto = getMonto();

            if (tasaMensual == 0) {
                return monto / plazoMeses;
            }

            return (monto * tasaMensual) / (1 - Math.pow(1 + tasaMensual, -plazoMeses));

        } catch (Exception e) {
            System.err.println("Error al calcular la cuota mensual: " + e.getMessage());
            return 0;
        }
    }
}
