package Interfaz;

import Actores.Administrador;
import Actores.Cliente;
import Actores.Mesa;
import Actores.Mesero;
import Actores.Orden;
import Actores.Persona;
import Actores.Producto;
//import Actores.Restaurante;
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
        
        /**
         * Principal contenido de arrays de datos de toda la aplicacion.
         */
{
    static ArrayList<Producto> productos;
    static ArrayList<Persona> personas;
    static ArrayList<Mesa> mesas;
    static ArrayList<Orden> ordenes;
    static ArrayList<Cliente> clientes= new ArrayList<Cliente>();
    static ArrayList<Mesero> meseros= new ArrayList<Mesero>();
    static int numcuneta=0;
    static Scene sc;
    
    
    /**
     * Metodo init, lee los archivos binarios que fueron creados y guardados. 
     */
    
    @Override
    public void init ( )
    {
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
        
       
        String filePath2 = "src/Archivos/archivoPersonas";
        try ( ObjectInputStream obj = new ObjectInputStream ( new FileInputStream ( filePath2 ) ) )
        {
            personas = ( ArrayList < Persona > ) obj.readObject ( );
            System.out.println ( "Leyendo personas" + personas );
            
            for (Persona p: personas)
            {                
                if ( p instanceof Mesero )
                    meseros.add ( ( Mesero ) p ); 
            }
          
        } catch (FileNotFoundException ex) {
            System.out.println("Error no encontrado");
        } catch (IOException | ClassNotFoundException el) {
            System.out.println("Error deserializar2");
            System.out.println(el.getMessage());
        } 

        String filePath3= "src/Archivos/archivoMesas";
         try(ObjectInputStream objInputStream = new ObjectInputStream(
                    new FileInputStream(filePath3))) {
            
            mesas = (ArrayList<Mesa>)objInputStream.readObject();
            System.out.println(mesas);
            
        } catch (FileNotFoundException e1) {
            System.out.println("Error no enotrado");
            System.out.println(e1.getMessage());
        } catch (IOException | ClassNotFoundException e3) {
            System.err.println("Error al desrializar3");
        }
         
            String filePath4= "src/Archivos/archivoOrdenes";
         try(ObjectInputStream objInputStream2 = new ObjectInputStream(
                    new FileInputStream(filePath4))) {
            
            ordenes = (ArrayList<Orden>)objInputStream2.readObject();
            for (Orden o: ordenes){
                System.out.println(o);
                System.out.println("aja");
            }
            System.out.println(ordenes);
             System.out.println("ordenes");
         
            
        } catch (FileNotFoundException e1) {
            System.out.println("Error no enotrado");
            System.out.println(e1.getMessage());
        } catch (IOException | ClassNotFoundException e3) {
            System.err.println("Error al desrializar3");
        }
         /*
         String filePath5 = "src/Archivos/archivoNroCuenta";
         try(ObjectInputStream objInputStream3 = new ObjectInputStream(
                    new FileInputStream(filePath5))) {
             numcuneta = objInputStream3.readInt();
         } catch (FileNotFoundException ex) {
            Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        //Programa.meseromain = new Mesero("test","test","test","test");
   */
    }
    
    /**
     * Escribe archivos de productos, ordenes, mesas y personas.
     */
    @Override
    public void stop ( )
    {
         System.out.println("fin");
        
        String filePath= "src/Archivos/archivoProdcutos";
         try(ObjectOutputStream objOutputStream = new ObjectOutputStream(
                    new FileOutputStream(filePath))) {
            ArrayList<Producto> productos2=(ArrayList<Producto>)productos.clone();
            objOutputStream.writeObject(productos2);
            System.out.println(productos2);
            
        } catch (FileNotFoundException e1) {
            System.out.println("Error no enotrado");
            System.out.println(e1.getMessage());
        } catch (IOException e2) {
            System.err.println("Error ");
       
    }
       
       String pathPersonas = "src/Archivos/archivoPersonas";
         try(ObjectOutputStream objOutputStream2 = new ObjectOutputStream(
                    new FileOutputStream(pathPersonas))) {
            ArrayList<Persona> personas2=(ArrayList<Persona>)personas.clone();
            objOutputStream2.writeObject(personas2);
            System.out.println(personas2);
            
        } catch (FileNotFoundException e1) {
            System.out.println("Error 1");
            System.out.println(e1.getMessage());
        } catch (IOException e2) {
            System.err.println("Error 2");
       
    }
          String pathMesas = "src/Archivos/archivoMesas";
         try(ObjectOutputStream objOutputStream2 = new ObjectOutputStream(
                    new FileOutputStream(pathMesas))) {
            ArrayList<Mesa> mesas2=(ArrayList<Mesa>)mesas.clone();
            objOutputStream2.writeObject(mesas2);
            System.out.println(mesas2);
            
        } catch (FileNotFoundException e1) {
            System.out.println("Error 1");
            System.out.println(e1.getMessage());
        } catch (IOException e2) {
            System.err.println("Error 2");
       
    }
         
         String pathOrdenes = "src/Archivos/archivoOrdenes";
         try(ObjectOutputStream objOutputStream3 = new ObjectOutputStream(
                    new FileOutputStream(pathOrdenes))) {
            ArrayList<Orden> ordenes2=(ArrayList<Orden>)ordenes.clone();
            objOutputStream3.writeObject(ordenes2);
            System.out.println(ordenes2);
            
        } catch (FileNotFoundException e1) {
            System.out.println("Error 1");
            System.out.println(e1.getMessage());
        } catch (IOException e2) {
            System.err.println("Error 2");
       
    }
         /*
         String pathNroCuenta = "src/Archivos/archivoNroCuenta";
         try(ObjectOutputStream objOutputStream4 = new ObjectOutputStream(
                    new FileOutputStream(pathNroCuenta))) {
             
             objOutputStream4.write(numcuneta);
         } catch (IOException ex) {
            System.out.println("Error");
        }
*/
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