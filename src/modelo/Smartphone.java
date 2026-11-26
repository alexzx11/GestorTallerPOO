/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Alex Carranza
 */
public class Smartphone extends EquipoReparacion {

    private String sistemaOperativo;
    private boolean cambioPantalla;

    public Smartphone(String nombreCliente, String fallaReportada, NivelUrgencia urgencia,
                      int horasManoObra, boolean respaldoDatos, boolean limpiezaInterna,
                      String sistemaOperativo, boolean cambioPantalla) {
        super(nombreCliente, fallaReportada, urgencia, horasManoObra, respaldoDatos, limpiezaInterna);
        setSistemaOperativo(sistemaOperativo);
        setCambioPantalla(cambioPantalla);
    }

    @Override
    public double calcularPresupuesto() {
        double subtotal = getHorasManoObra() * 250.0;
        if (cambioPantalla) {
            subtotal += 1800.0;
        }
        return aplicarExtrasYUrgencia(subtotal);
    }

    @Override
    public String getEspecificacionTecnica() {
        String detalle = "SO: " + sistemaOperativo;
        if (cambioPantalla) {
            detalle += " | Cambio de pantalla";
        }
        return detalle;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        if (sistemaOperativo == null || (!sistemaOperativo.equalsIgnoreCase("Android") && !sistemaOperativo.equalsIgnoreCase("iOS"))) {
            throw new IllegalArgumentException("El sistema operativo debe ser Android o iOS.");
        }
        this.sistemaOperativo = sistemaOperativo;
    }

    public boolean isCambioPantalla() {
        return cambioPantalla;
    }

    public void setCambioPantalla(boolean cambioPantalla) {
        this.cambioPantalla = cambioPantalla;
    }
}
