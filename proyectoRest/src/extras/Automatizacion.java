package extras;

import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * @author Devin Gaibor
 * Clase abstracta con métodos útiles para la reutilización del código.
 */
public abstract class Automatizacion 
{
    public static void eventos ( ArrayList < TextField > lista_campos, EventHandler < MouseEvent > evento  )
    {
        for ( TextField campo_texto: lista_campos )
        {   
            campo_texto.setOnMouseClicked ( evento );
        }
    }
}
