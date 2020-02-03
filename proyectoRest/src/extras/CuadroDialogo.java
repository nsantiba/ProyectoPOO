package extras;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author steve
 */
public abstract class CuadroDialogo
{
    public static Optional < ButtonType > confirmacion ( String titulo, String cabecera, String contenido  )
    {
        Alert alerta = new Alert ( Alert.AlertType.CONFIRMATION );
        alerta.setTitle ( "CONFIRMACIÓN" );
        alerta.setHeaderText ( "¿Está seguro que desea cerrar sesión?" );
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
