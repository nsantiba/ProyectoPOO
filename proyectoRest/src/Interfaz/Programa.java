package Interfaz;

import Actores.Administrador;
import Actores.Cliente;
import Actores.Mesa;
import Actores.Mesero;
import Actores.Persona;
import Actores.Producto;
import Actores.Restaurante;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Eddy Santibañez J
 */

public class Programa extends Application
{
    static ArrayList<Producto> productos;
    static ArrayList<Persona> personas;
    static ArrayList<Mesa> mesas;
    static ArrayList<Cliente> clientes;
    static Restaurante restaurante;
    static Scene sc;
    //static Mesero meseromain;
    
    @Override
    public void init ( )
    {
        restaurante= new Restaurante(); 
        
        Mesero m1= new Mesero("mesero1@gmail.com","mesero1","Cristiano","Ronaldo");
        Administrador a1= new Administrador("admin","admin");
        Administrador test = new Administrador("a","a");
        Mesero test2 = new Mesero("m","m","Chi","Chenol");
        restaurante.getPersonas().add(test);
        restaurante.getPersonas().add(a1);
        restaurante.getPersonas().add(m1);
        restaurante.getPersonas().add(test2);
        restaurante.getMeseros().add(test2);
        
        String filePath= "src/Archivos/archivoProdcutos";
         try(ObjectInputStream objInputStream = new ObjectInputStream(
                    new FileInputStream(filePath))) {
            
            productos = (ArrayList<Producto>)objInputStream.readObject();
            System.out.println(productos);
            
        } catch (FileNotFoundException e1) {
            System.out.println("Error no enotrado");
            System.out.println(e1.getMessage());
        } catch (IOException | ClassNotFoundException e2) {
            System.err.println("Error al deserializar1");
        }
        
       
        String filePath2= "src/Archivos/archivoPersonas";
         try(ObjectInputStream obj = new ObjectInputStream(
                new FileInputStream(filePath2))) {
            
            //Por alguna razon el arraylist retorna null
            personas = (ArrayList<Persona>)obj.readObject();
            System.out.println(personas);
            
            //Esta siguiente linea rompe el programa porque el arraylist anterior retorna null NO SE POR QUE

            /*for (Persona p: personas){
                restaurante.getPersonas().add(p);
                if (p instanceof Mesero){
                    restaurante.getMeseros().add((Mesero) p);
                } 
            }*/
            //System.out.println(restaurante.getPersonas());
            //System.out.println(restaurante.getMeseros());
                       
        } catch (FileNotFoundException ex) {
            System.out.println("Error no encontrado");
        } catch (IOException | ClassNotFoundException el) {
            System.out.println("Error deserializar2");
            System.out.println(el.getMessage());
        } 

        /*String filePath3= "src/Archivos/archivoMesas";
         try(ObjectInputStream objInputStream = new ObjectInputStream(
                    new FileInputStream(filePath3))) {
            
            mesas = (ArrayList<Mesa>)objInputStream.readObject();
            System.out.println(mesas);
            
        } catch (FileNotFoundException e1) {
            System.out.println("Error no enotrado");
            System.out.println(e1.getMessage());
        } catch (IOException | ClassNotFoundException e3) {
            System.err.println("Error al desrializar3");
        }*/
         
        //Programa.meseromain = new Mesero("test","test","test","test");
   
    }
    
    @Override
    public void stop ( )
    {
         System.out.println("fin");
        
        String filePath= "src/Archivos/archivoProdcutos";
         try(ObjectOutputStream objOutputStream = new ObjectOutputStream(
                    new FileOutputStream(filePath))) {
            
            objOutputStream.writeObject(productos);
            System.out.println(productos);
            
        } catch (FileNotFoundException e1) {
            System.out.println("Error no enotrado");
            System.out.println(e1.getMessage());
        } catch (IOException e2) {
            System.err.println("Error ");
       
    }
        String pathPersonas = "src/Archivos/archivoPersonas";
         try(ObjectOutputStream objOutputStream2 = new ObjectOutputStream(
                    new FileOutputStream(pathPersonas))) {
            
            objOutputStream2.writeObject(personas);
            System.out.println(personas);
            
        } catch (FileNotFoundException e1) {
            System.out.println("Error 1");
            System.out.println(e1.getMessage());
        } catch (IOException e2) {
            System.err.println("Error 2");
       
    }
    }
    
    @Override
    public void start ( Stage primaryStage )
    {
        VistaPrograma vistaPrograma = new VistaPrograma();
        sc = new Scene ( vistaPrograma.getRoot ( ), 675, 700 );
        primaryStage.setScene ( sc );
        primaryStage.show ( );
    }
    
    public static void main ( String [ ] args )
    {
        launch ( args );
    }
}