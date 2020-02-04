/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actores;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Eddy Santibañez J
 */
public class Orden implements Serializable {
    private Cliente client;
    private ArrayList<Producto> productos_orden;
    private LocalDate fecha;
    private Mesa mesa_orden;
    private String cuenta;
    private double total;

    public Orden(Cliente client, ArrayList<Producto> productos_orden, LocalDate fecha, Mesa mesa_orden, String cuenta, double total) {
        this.client = client;
        this.productos_orden = productos_orden;
        this.fecha = fecha;
        this.mesa_orden = mesa_orden;
        this.cuenta = cuenta;
        this.total = total;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public ArrayList<Producto> getProductos_orden() {
        return productos_orden;
    }

    public void setProductos_orden(ArrayList<Producto> productos_orden) {
        this.productos_orden = productos_orden;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Mesa getMesa_orden() {
        return mesa_orden;
    }

    public void setMesa_orden(Mesa mesa_orden) {
        this.mesa_orden = mesa_orden;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.client);
        hash = 53 * hash + Objects.hashCode(this.productos_orden);
        hash = 53 * hash + Objects.hashCode(this.fecha);
        hash = 53 * hash + Objects.hashCode(this.mesa_orden);
        hash = 53 * hash + Objects.hashCode(this.cuenta);
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.total) ^ (Double.doubleToLongBits(this.total) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Orden other = (Orden) obj;
        if (Double.doubleToLongBits(this.total) != Double.doubleToLongBits(other.total)) {
            return false;
        }
        if (!Objects.equals(this.cuenta, other.cuenta)) {
            return false;
        }
        if (!Objects.equals(this.client, other.client)) {
            return false;
        }
        if (!Objects.equals(this.productos_orden, other.productos_orden)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.mesa_orden, other.mesa_orden)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Orden{" + "client=" + client + ", fecha=" + fecha + ", mesa_orden=" + mesa_orden + ", cuenta=" + cuenta + ", total=" + total + '}';
    }
    
}
