package Interfaz;

import Actores.Administrador;
import Actores.Mesero;
import Actores.Persona;
import static Interfaz.Programa.restaurante;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Eddy Santibañez J
 */
public class VistaPrograma
{
    private StackPane root;
    
    public VistaPrograma ( )
    {
        crearInicio ( );
    }
    
    public void crearInicio ( )
    {
        try
        {
            root = new StackPane ( );
            GridPane grilla = new GridPane ( );
            grilla.setAlignment ( Pos.CENTER );
            ImageView fondo = new ImageView ( new Image ( new FileInputStream ( "src/recursos/login1.png" ) ) );
            //fondo.setOpacity ( 0.25 );
            ImageView img = new ImageView ( new Image ( new FileInputStream ( "src/recursos/usuario.png" ) ) );
            Label lbl_login = new Label ( "Iniciar Sesión" );
            Button btn_ingresar = new Button ( "Ingresar");
            TextField txt_usuario = new TextField ( );
            TextField txt_contrasenia = new TextField ( );
            //btn_ingresar.setDefaultButton ( true );
            
            grilla.add (img, 0, 0 );
            grilla.add ( lbl_login, 0, 1 );
            grilla.add ( new Label ( "Usuario:" ), 0, 2 );
            grilla.add ( txt_usuario, 1, 2 );
            grilla.add ( new Label ( "Contraseña:" ), 0, 3 );
            grilla.add ( txt_contrasenia, 1, 3 );
            grilla.add ( btn_ingresar, 0, 4  );
            grilla.setPadding ( new Insets ( 5 ) );
            grilla.setHgap ( 5 );
            grilla.setVgap ( 5 );
            
            GridPane.setColumnSpan (img, 2);
            GridPane.setHalignment (img, HPos.CENTER );
            GridPane.setColumnSpan ( lbl_login, 2);
            GridPane.setHalignment ( lbl_login, HPos.CENTER );
            GridPane.setColumnSpan ( btn_ingresar, 2);
            GridPane.setHalignment ( btn_ingresar, HPos.CENTER );

            root.getChildren ( ).addAll ( fondo, grilla );

            EventHandler < MouseEvent > ev = new EventHandler < MouseEvent > ( )
            {
                @Override
                public void handle ( MouseEvent ev )
                {
                    String correo_ingresado = txt_usuario.getText ( );
                    String contrasenia_ingresada = txt_contrasenia.getText ( );
                    Persona p_dentro = buscarPersona ( correo_ingresado, contrasenia_ingresada );

                    if ( p_dentro == null )
                    {
                       Label _noValido= new Label("Credenciales Incorrectas. Vuelva a inetntarlo ");
                       grilla.getChildren().remove(_noValido);
                       grilla.add(_noValido, 1, 6);
                       System.out.println("nooo");
                       //mejorarrr******************************
                       //indicar que no se existee
                    }

                    if ( p_dentro instanceof Administrador )
                    {
                       root.getChildren().clear();
                       crearInterfazAdmin();
                    }

                    if ( p_dentro instanceof Mesero )
                    {
                       //interfaz del mesero llamar
                       System.out.println("wiii");
                    }    
                }
            };
            btn_ingresar.setOnMouseClicked(ev);
        }
        catch ( Exception e )
        {
            System.out.println ( "Error" );
        }
    }
   
    public Persona buscarPersona ( String correo, String contrasena )
    {
        for ( Persona persona: restaurante.getPersonas ( ) )
        {
            if ( persona.getContrasena ( ).equals ( contrasena ) && persona.getCorreo ( ).equals ( correo ) )
            {
                return persona;
            }
            //verificar que exista la persona gg
        }
        return null;
    }
    
    public void crearInterfazAdmin ( )
    {
        try
        {
            InterfazAdministrador Interfaz_admin = new InterfazAdministrador ( );
            VBox adminInterf = Interfaz_admin.getRootA();
            root.getChildren().add(adminInterf); 
        }
        catch ( FileNotFoundException e )
        {
            System.out.println ( "Archivo no encontrado" );
        }
    }
    
    public StackPane getRoot ( )
    {
        return root;
    }
}