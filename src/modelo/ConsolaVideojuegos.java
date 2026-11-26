/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Alex Carranza
 */
public class ConsolaVideojuegos extends EquipoReparacion {

    private int cantidadControles;

    public ConsolaVideojuegos(String nombreCliente, String fallaReportada, NivelUrgencia urgencia,
                              int horasManoObra, boolean respaldoDatos, boolean limpiezaInterna,
                              int cantidadControles) {
        super(nombreCliente, fallaReportada, urgencia, horasManoObra, respaldoDatos, limpiezaInterna);
        setCantidadControles(cantidadControles);
    }

    @Override
    public double calcularPresupuesto() {
        double subtotal = (getHorasManoObra() * 300.0) + (cantidadControles * 150.0);
        return aplicarExtrasYUrgencia(subtotal);
    }

    @Override
    public String getEspecificacionTecnica() {
        return "Controles revisados: " + cantidadControles;
    }

    public int getCantidadControles() {
        return cantidadControles;
    }

    public void setCantidadControles(int cantidadControles) {
        if (cantidadControles < 0 || cantidadControles > 4) {
            throw new IllegalArgumentException("La cantidad de controles debe estar entre 0 y 4.");
        }
        this.cantidadControles = cantidadControles;
    }
}
