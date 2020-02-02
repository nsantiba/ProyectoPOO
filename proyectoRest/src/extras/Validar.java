package extras;

import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * @author Devin Gaibor
 * Clase abstracta con métodos útiles para la implementación del código, que abarca desde validadores de campos hasta precarga de datos.
 */
public abstract class Validar
{
    public static void ingreso ( ArrayList < TextField > lista_campos, Button boton )
    {
        int condicion = 0;
        
        for ( TextField campo_texto: lista_campos )
        {   
            if ( campo_texto.getText ( ).length ( ) == 0 )
                break;
            condicion ++;
        }
        
        if ( condicion == lista_campos.size() )
            boton.setDisable ( false );
    }
}
