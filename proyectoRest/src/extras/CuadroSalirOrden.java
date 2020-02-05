/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extras;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * Clase para salir de orden en mesero.
 * @author user
 */
public abstract class CuadroSalirOrden {
    
    public static Optional < ButtonType > confirmacion ( String titulo, String cabecera, String contenido  )
    {
        Alert alerta = new Alert ( Alert.AlertType.CONFIRMATION );
        alerta.setTitle ( "CONFIRMACIÓN" );
        alerta.setHeaderText ( "Cerrar orden?" );
        alerta.setContentText ( null );
        Optional < ButtonType > resultado = alerta.showAndWait ( );
        return resultado;
    }
    
    public static void alerta ( String titulo, String cabecera, String contenido )
    {
        Alert alerta = new Alert ( Alert.AlertType.ERROR );
        alerta.setTitle ( titulo );
        alerta.setHeaderText ( cabecera );
        alerta.setContentText ( contenido );
        alerta.showAndWait();
    }
}