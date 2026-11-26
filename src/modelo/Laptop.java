/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Alex Carranza
 */
public class Laptop extends EquipoReparacion {

    private boolean esGamer;
    private boolean requiereRepuestoImportado;

    public Laptop(String nombreCliente, String fallaReportada, NivelUrgencia urgencia,
                  int horasManoObra, boolean respaldoDatos, boolean limpiezaInterna,
                  boolean esGamer, boolean requiereRepuestoImportado) {
        super(nombreCliente, fallaReportada, urgencia, horasManoObra, respaldoDatos, limpiezaInterna);
        setEsGamer(esGamer);
        setRequiereRepuestoImportado(requiereRepuestoImportado);
    }

    @Override
    public double calcularPresupuesto() {
        double tarifaHora = esGamer ? 500.0 : 350.0;
        double subtotal = getHorasManoObra() * tarifaHora;

        if (requiereRepuestoImportado) {
            subtotal += 1200.0;
        }
        return aplicarExtrasYUrgencia(subtotal);
    }

    @Override
    public String getEspecificacionTecnica() {
        String detalle = esGamer ? "Laptop Gamer" : "Laptop Estándar";
        if (requiereRepuestoImportado) {
            detalle += " | Repuesto importado";
        }
        return detalle;
    }

    public boolean isEsGamer() {
        return esGamer;
    }

    public void setEsGamer(boolean esGamer) {
        this.esGamer = esGamer;
    }

    public boolean isRequiereRepuestoImportado() {
        return requiereRepuestoImportado;
    }

    public void setRequiereRepuestoImportado(boolean requiereRepuestoImportado) {
        this.requiereRepuestoImportado = requiereRepuestoImportado;
    }
}
