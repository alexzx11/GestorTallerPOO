/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

/**
 *
 * @author Alex Carranza
 */
import java.util.ArrayList;
import modelo.EquipoReparacion;
import modelo.EstadoOrden;

public class GestorTaller {

    private final ArrayList<EquipoReparacion> listaOrdenes;

    public GestorTaller() {
        this.listaOrdenes = new ArrayList<>();
    }

    public void registrarOrden(EquipoReparacion equipo) {
        if (equipo == null) {
            throw new IllegalArgumentException("La orden de equipo no puede ser nula.");
        }
        listaOrdenes.add(equipo);
    }

    public ArrayList<EquipoReparacion> obtenerTodas() {
        return listaOrdenes;
    }

    public ArrayList<EquipoReparacion> filtrarPorEstado(String estadoFiltro) {
        if (estadoFiltro == null || estadoFiltro.equalsIgnoreCase("TODOS")) {
            return listaOrdenes;
        }

        ArrayList<EquipoReparacion> filtradas = new ArrayList<>();
        for (EquipoReparacion equipo : listaOrdenes) {
            if (equipo.getEstado().name().equalsIgnoreCase(estadoFiltro)) {
                filtradas.add(equipo);
            }
        }
        return filtradas;
    }

    public void avanzarEstado(String codigoOrden) {
        for (EquipoReparacion equipo : listaOrdenes) {
            if (equipo.getCodigoOrden().equals(codigoOrden)) {
                if (equipo.getEstado() == EstadoOrden.RECIBIDO) {
                    equipo.setEstado(EstadoOrden.EN_DIAGNOSTICO);
                    return;
                } else if (equipo.getEstado() == EstadoOrden.EN_DIAGNOSTICO) {
                    equipo.setEstado(EstadoOrden.LISTO_ENTREGA);
                    return;
                } else {
                    throw new IllegalArgumentException("La orden " + codigoOrden + " ya está lista para entrega.");
                }
            }
        }
        throw new IllegalArgumentException("No se encontró la orden con código: " + codigoOrden);
    }

    public double calcularRecaudacionTotal() {
        double total = 0.0;
        for (EquipoReparacion equipo : listaOrdenes) {
            total += equipo.calcularPresupuesto();
        }
        return total;
    }
}
