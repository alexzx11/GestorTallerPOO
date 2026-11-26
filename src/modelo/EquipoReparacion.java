/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Alex Carranza
 */
public abstract class EquipoReparacion {

    private static int contadorOrdenes = 101;

    private final String codigoOrden;
    private String nombreCliente;
    private String fallaReportada;
    private EstadoOrden estado;
    private NivelUrgencia urgencia;
    private int horasManoObra;
    private boolean respaldoDatos;
    private boolean limpiezaInterna;

    public EquipoReparacion(String nombreCliente, String fallaReportada, NivelUrgencia urgencia,
                            int horasManoObra, boolean respaldoDatos, boolean limpiezaInterna) {
        this.codigoOrden = "ORD-" + contadorOrdenes++;
        this.estado = EstadoOrden.RECIBIDO;
        setNombreCliente(nombreCliente);
        setFallaReportada(fallaReportada);
        setUrgencia(urgencia);
        setHorasManoObra(horasManoObra);
        setRespaldoDatos(respaldoDatos);
        setLimpiezaInterna(limpiezaInterna);
    }
    
protected double aplicarExtrasYUrgencia(double costoBase) {
        double subtotal = costoBase;

        if (respaldoDatos) {
            subtotal += 200.0;
        }
        if (limpiezaInterna) {
            subtotal += 150.0;
        }

        if (urgencia == NivelUrgencia.GARANTIA) {
            return 0.0;
        }
        if (urgencia == NivelUrgencia.PRIORITARIO) {
            return subtotal * 1.25;
        }

        return subtotal;
    }

    public abstract double calcularPresupuesto();

    public abstract String getEspecificacionTecnica();

    public String getCodigoOrden() {
        return codigoOrden;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        if (nombreCliente == null || nombreCliente.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del cliente no puede estar vacío.");
        }
        this.nombreCliente = nombreCliente.trim();
    }

    public String getFallaReportada() {
        return fallaReportada;
    }

    public void setFallaReportada(String fallaReportada) {
        if (fallaReportada == null || fallaReportada.trim().length() < 5) {
            throw new IllegalArgumentException("La falla reportada debe tener al menos 5 caracteres.");
        }
        this.fallaReportada = fallaReportada.trim();
    }

    public EstadoOrden getEstado() {
        return estado;
    }

    public void setEstado(EstadoOrden estado) {
        if (estado == null) {
            throw new IllegalArgumentException("El estado de la orden es obligatorio.");
        }
        this.estado = estado;
    }

    public NivelUrgencia getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(NivelUrgencia urgencia) {
        if (urgencia == null) {
            throw new IllegalArgumentException("Debe seleccionar un nivel de urgencia.");
        }
        this.urgencia = urgencia;
    }

    public int getHorasManoObra() {
        return horasManoObra;
    }

    public void setHorasManoObra(int horasManoObra) {
        if (horasManoObra < 1 || horasManoObra > 40) {
            throw new IllegalArgumentException("Las horas de mano de obra deben estar entre 1 y 40.");
        }
        this.horasManoObra = horasManoObra;
    }

    public boolean isRespaldoDatos() {
        return respaldoDatos;
    }

    public void setRespaldoDatos(boolean respaldoDatos) {
        this.respaldoDatos = respaldoDatos;
    }

    public boolean isLimpiezaInterna() {
        return limpiezaInterna;
    }

    public void setLimpiezaInterna(boolean limpiezaInterna) {
        this.limpiezaInterna = limpiezaInterna;
    }
}
