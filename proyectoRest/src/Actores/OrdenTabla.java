/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actores;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Eddy Santibañez J
 */
public class OrdenTabla {
    private final SimpleStringProperty cliente; 
    private final SimpleStringProperty fecha;
    private final SimpleStringProperty mesa_orden;
    private final SimpleStringProperty cuenta;
    private final SimpleStringProperty total;
    private final SimpleStringProperty mesero;

    public OrdenTabla(String cliente, String fecha, String mesa_orden, String cuenta, String total,String mesero) {
        this.cliente = new SimpleStringProperty(cliente);
        this.fecha =new SimpleStringProperty(fecha) ;
        this.mesa_orden =new SimpleStringProperty(mesa_orden) ;
        this.cuenta = new SimpleStringProperty(cuenta);
        this.total = new SimpleStringProperty(total);
        this.mesero= new SimpleStringProperty();
    }

    public String getCliente() {
        return cliente.get();
    }

    public String getFecha() {
        return fecha.get();
    }

    public String getMesa_orden() {
        return mesa_orden.get();
    }

    public String getCuenta() {
        return cuenta.get();
    }

    public String getTotal() {
        return total.get();
    }

    public String getMesero() {
        return mesero.get();
    }
    
}
