/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Actores.Administrador;
import Actores.Mesero;
import Actores.Persona;
import static Interfaz.Programa.restaurante;
import java.io.FileNotFoundException;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Eddy Santibañez J
 */
public class VistaPrograma {
    private  VBox root; 
    private HBox _seccion_correo; 
    private HBox _seccion_contrasena;

    public VBox getRoot() {
        return root;
    }

    public VistaPrograma() {
        crearInicio();
    }
    
    
    
    
   public void crearInicio(){
       root= new VBox();
       _seccion_correo= new HBox();
       _seccion_contrasena= new HBox();
       
       Label _iniciar= new Label("Iniciar sesión"); 
       Label _correo= new Label("Correo");
       TextField _textcorreo= new TextField();
       Label _contrasena= new Label("Contrasena");
       TextField _textcontrasena= new TextField();
       Button _continuar= new Button("Continuar");
       
       _seccion_correo.getChildren().addAll(_correo,_textcorreo);
       _seccion_contrasena.getChildren().addAll(_contrasena,_textcontrasena);
       root.getChildren().addAll(_iniciar,_seccion_correo,_seccion_contrasena,_continuar);
       
      EventHandler<MouseEvent> ev= new EventHandler<MouseEvent>(){
           @Override
           public void handle(MouseEvent ev) {
               String correo_ingresado= _textcorreo.getText();
               String contraseña_ingresada= _textcontrasena.getText();
               Persona p_dentro= buscarPersona(correo_ingresado,contraseña_ingresada);
               if (p_dentro==null){
                   root.getChildren().clear();
                   Label _noValido= new Label("Credenciales Incorrectas. Vuelva a inetntarlo ");
                   System.out.println("nooo");
                   //mejorarrr******************************
                   //indicar que no se existee
               }
               if(p_dentro instanceof Administrador ){
                   root.getChildren().clear();
                   crearInterfazAdmin();
               }
               if(p_dentro instanceof Mesero){
                   //interfaz del mesero llamar
                   System.out.println("wiii");
               }
               
        }};
       _continuar.setOnMouseClicked(ev);

  }
   
   public Persona buscarPersona(String correo, String contrasena){
         for (Persona p:  restaurante.getPersonas() ){
                   if(p.getContrasena().equals(contrasena)&& p.getCorreo().equals(correo)){
                       return p;
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
            VBox adminInterf= Interfaz_admin.getRootA();
            root.getChildren().add(adminInterf); 
        }
        catch ( FileNotFoundException e )
        {
            System.out.println ( "Archivo no encontrado" );
        }
        
    }
}