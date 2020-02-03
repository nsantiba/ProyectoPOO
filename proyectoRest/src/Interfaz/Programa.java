package Interfaz;

import Actores.Administrador;
import Actores.Mesero;
import Actores.Producto;
import Actores.Restaurante;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Eddy Santibañez J
 */

public class Programa extends Application
{
    static  ArrayList<Producto> productos;
    static ArrayList<Mesero> meseros;
    static Restaurante restaurante;
    static Scene sc;
    static Mesero meseromain;
    
    @Override
    public void init ( )
    {
        //lo de los meseros usuarios tambien es en un archivo
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
            for(Producto p: productos){
                System.out.println(p.getN_imagen());
            }
            
        } catch (FileNotFoundException e1) {
            System.out.println("Error no enotrado");
            System.out.println(e1.getMessage());
        } catch (IOException e2) {
            System.err.println("Error al desrializar");
        } catch (ClassNotFoundException ex){
            System.err.println("Error al desrializar");
        }
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