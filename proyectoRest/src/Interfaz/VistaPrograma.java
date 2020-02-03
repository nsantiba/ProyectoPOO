package Interfaz;

import Actores.Administrador;
import Actores.Mesero;
import Actores.Persona;
//import  Interfaz.Programa.restaurante;
import Interfaz.InterfazMesero;
import Interfaz.Programa;
import extras.Automatizacion;
import extras.Validar;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import Interfaz.Programa;
import extras.CuadroDialogo;
import javafx.scene.control.Alert;

/**
 *
 * @author Eddy Santibañez J
 */
public class VistaPrograma
{
    private StackPane root;
    //static Mesero meseroprin;
    
    public VistaPrograma ( )
    {
        crearInicio ( );
    }
    
    public void crearInicio ( )
    {
        //System.out.println("Null? " +meseroprin);
        
        try
        {
            root = new StackPane ( );
            ArrayList < TextField > lista_campos = new ArrayList < TextField > ( );
            GridPane grilla = new GridPane ( );
            grilla.setAlignment ( Pos.CENTER );
            ImageView fondo = new ImageView ( new Image ( new FileInputStream ( "src/recursos/login1.png" ) ) );
            //fondo.setOpacity ( 0.25 );
            ImageView img = new ImageView ( new Image ( new FileInputStream ( "src/recursos/usuario.png" ) ) );
            Label lbl_login = new Label ( "Iniciar Sesión" );
            Button btn_ingresar = new Button ( "Ingresar" );
            btn_ingresar.setDisable ( true );
            TextField txt_usuario = new TextField ( );
            TextField txt_contrasenia = new TextField ( );
            //btn_ingresar.setDefaultButton ( true );
            
            lista_campos.add ( txt_usuario );
            lista_campos.add ( txt_contrasenia );
            
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

            EventHandler < MouseEvent > ev = (MouseEvent ev1) -> {
              String correo_ingresado = txt_usuario.getText ( );
              String contrasenia_ingresada = txt_contrasenia.getText ( );
              Persona persona = buscarPersona ( correo_ingresado, contrasenia_ingresada );
              
                if ( persona == null )
                {
                    CuadroDialogo.alerta ( "ERROR", null, "Credenciales Incorrectas" );
                }
                
                if ( persona instanceof Administrador )
                {
                    root.getChildren().clear();
                    crearInterfazAdmin();
                }
                
                if ( persona instanceof Mesero )
                {
                    Mesero m= (Mesero)persona;
                    //El mesero es P_dentro ya lo tienes.
                    //Mesero m_dentro = buscarMesero(correo_ingresado, contrasenia_ingresada);
                    //System.out.println(m_dentro);
                   // meseroprin = m_dentro; //No se esta cambiando la variable??
                    //System.out.println("Que mesero es? "+meseroprin.toString());
                    root.getChildren().clear();
                  try {
                      crearInterfazMesero(m);
                  } catch (FileNotFoundException ex) {
                      System.out.println("No hay archivo.");
                  }
                    

                }
            };
            
            EventHandler < MouseEvent > evt_validar_ingreso = new EventHandler < MouseEvent > ( )
            {
                @Override
                public void handle ( MouseEvent ev )
                {
                    Validar.ingreso ( lista_campos, btn_ingresar );
                }
            };
            
            btn_ingresar.setOnMouseClicked(ev);
            //txt_contrasenia.setOnMouseClicked ( evt_validar_ingreso );
            //txt_usuario.setOnMouseClicked ( evt_validar_ingreso );
            
            Automatizacion.eventos ( lista_campos, evt_validar_ingreso );
        }
        catch ( Exception e )
        {
            System.out.println ( "Error" );
        }
    }
   
    public Persona buscarPersona ( String correo, String contrasena )
    {
        for ( Persona persona: Programa.personas )
        {
            if ( persona.getCorreo ( ).equals ( correo ) && persona.getContrasena ( ).equals ( contrasena ) )
                return persona;
        }
        return null;
    }
    
    /*public Mesero buscarMesero(String correo, String contra){
        for (Mesero mesero:Programa.meseros){
            if (mesero.getCorreo().equals(correo) && mesero.getContrasena().equals(contra)){
                return mesero;
            }
        }
        return null;
    }*/
    
    /*public void setMesero(Mesero meseroprin){
        this.meseroprin=meseroprin;
    }*/
    
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
    
    public void crearInterfazMesero(Mesero m) throws FileNotFoundException{ 
        InterfazMesero Interfaz_mesero = new InterfazMesero(m);
        VBox meseroInterf = Interfaz_mesero.getRootM();
        root.getChildren().add(meseroInterf);
    }
    
    public StackPane getRoot ( )
    {
        return root;
    }
}