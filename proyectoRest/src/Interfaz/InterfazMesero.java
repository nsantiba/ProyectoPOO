/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Actores.Cliente;
import Actores.Mesa;
import Actores.Mesero;
import Actores.Orden;
import Actores.Producto;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import Interfaz.Programa;
import extras.CuadroDialogo;
import extras.CuadroSalirOrden;
import java.time.LocalDate;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;

/**
 *
 * @author Eddy Santibañez J
 */
public class InterfazMesero  {
    
      VBox _rootM;
      Label _nombre; 
      Pane _seccionPlanoM = new Pane();
      //Mesero meseroprin;
      Scene sc2;
      Button _aceptar;
      Label _nuevaCuenta;
      VBox rootVentana;
      Stage nuevaVentana;
      Button salir;
      Circle c;
      //Orden or;
      TextField _nombreCliente;
      Stage nuevaVentanaOrden;
      VBox rootVentanaOrden;
      Label _labelOrdenHeader;
      Scene sc3;
      Button _finalizarOrden;
      HBox _ventanaSig;
      Button _regresar;
      VBox _seccionMenu;
      VBox _menu;
      VBox _seccionOrdenes;
      VBox ordenes; 
      FlowPane productosMenu;
      Button infoProducto;
      //ArrayList<Mesa> mesas;
       HBox info_orden;
       VBox itemOrden_precio;
       Label precioFinal;
       Label nombreProducto;
       Label cant_Punitario;
       TextField buscar;
       String busqueda;
       Label valorTotal;
       double valorFinalO;
      
      public InterfazMesero (Mesero mesero) throws FileNotFoundException{
          crearMenu(mesero);
          _seccionPlanoM(mesero);
      }
      
      /*public Mesero getMeseroPrincipal(){
          return meseroprin;
      }*/
      
      public VBox getRootM(){
          return _rootM;
      }
          
      
      public void crearMenu(Mesero mesero) throws FileNotFoundException{ 
          
          //meseroprin = VistaPrograma.meseroprin;
          System.out.println("Check:" +mesero);
          _rootM = new VBox();
          _nombre = new Label(mesero.toString());
          salir = new Button ( "Salir", new ImageView ( new Image ( new FileInputStream ( "src/recursos/botones/salir.png" ) ) ) );
          EventHandler<MouseEvent> ev = (MouseEvent ev1) -> {
                  manejoMeseroSalir();
          };
          salir.setOnMouseClicked(ev);
          
          _rootM.getChildren().addAll(_nombre, _seccionPlanoM,salir);
          
          
      }
      
      /**
       * Seccion principal. Recibe un mesero para referenciar y se encarga de la creacion de mesas en el interfazMesero y su manipulacion en base a color.
       * Crea y termina ordenes guardando info en arraylist ordenes.
       * Funcionalidad de botones de finalizar orden y regresar, regresa las mesas a su color y habilita nuevos pedidos y clientes.
       * @param mesero: Se consiguio de la eleccion anterior en eventhandler de vistaPrograma.
       */
    
    public void _seccionPlanoM(Mesero mesero){
        Label cocina= new Label("Cocina");
        Rectangle rect= new Rectangle(10, 250);
            rect.setLayoutX(400);
            rect.setLayoutY(5);        
            cocina.setLayoutX(410);
            cocina.setLayoutY(35);
        _seccionPlanoM.getChildren().addAll(cocina, rect);
          for (Mesa m: Programa.mesas){
                //c = m.getCircle();
                c= new Circle(m.getRadio()*4);//*4 para aumentar tamaño
                m.setCircle(c);
                Label _numero = new Label(m.getNumero());
                c.setCenterX(m.getCentrox());
                c.setCenterY(m.getCentroy());
                //c.setFill(Color.web(m.getColor()));
                _numero.setLayoutX(m.getCentrox());
                _numero.setLayoutY(m.getCentroy());
                if((m.getOcupado()==true)&& (mesero.getMesas().contains(m)==false)){
                    System.out.println("no es mia");
                    c.setFill(Color.RED);
                    System.out.println(mesero.getMesas().contains(m)); 
                }
                if((m.getOcupado()==true) &&(mesero.getMesas().contains(m)==true)){
                     System.out.println("es mia");
                     c.setFill(Color.GREEN);
                    
                }if(m.getOcupado()==false){
                    c.setFill(Color.YELLOW);
                }
                c.setOnMouseClicked((MouseEvent e4)->{
                        System.out.println("dentro");
                        
                        if(m.getOcupado()==false){
                             System.out.println("Amarillo");
                             
                            crearVentana();
                            _aceptar.setOnMouseClicked((MouseEvent ev5)->{
                                m.getCircle().setFill(Color.GREEN);
                                String infocliente = _nombreCliente.getText();
                                nuevaVentana.close();
                                int cuenta = Programa.numcuneta + 1;
                                    Programa.numcuneta+= 1;
                                    System.out.println(cuenta);
                                    Cliente infocliente2 = new Cliente(infocliente);
                                    Orden or= new Orden(infocliente2,LocalDate.now(),m,cuenta,mesero);
                                    System.out.println(or);
                                 //m.setOrd(or);
                                Programa.ordenes.add(or);//se añade la orden
                                System.out.println("orden creada");
                                
                                System.out.println(or);
                                Programa.clientes.add(infocliente2);
                                m.setCliente(infocliente2);
                                m.setOcupado(true);
                                mesero.getMesas().add(m);
                                m.setMesero(mesero);
                                
                                System.out.println(m.getCliente().getInfo());
                            });}
                        
                        if((m.getOcupado()==true)&& (mesero.getMesas().contains(m)==false)){
                                System.out.println("Esta ocupada (Rojo)");
                                }
                        
                        if((m.getOcupado()==true) && (mesero.getMesas().contains(m)==true)){
                            System.out.println("Verde");
                            
                            _labelOrdenHeader= new Label("Mesa: "+m.getNumero()+" - Cliente: "+m.getCliente().getInfo());
                           
                            try {
                                 for(Orden o: Programa.ordenes){//esto puede ser un metodo a parte
                                     System.out.println(o);
                                     System.out.println("aja");
                                     System.out.println(o.getMesa_orden());
                                    if ((o.getMesa_orden().equals(m))&& (o.getClient().equals(m.getCliente()))){
                                        crearVentanaOrden(_labelOrdenHeader,o);//de una orden
                                        manejoMenuMesero(o);//akiii
                                        _finalizarOrden.setOnMouseClicked((MouseEvent ev5)->{
                                            if ( CuadroSalirOrden.confirmacion ( "CONFIRMACIÓN", "Cerrar orden?", null ).get ( ) == ButtonType.OK ){
                                                nuevaVentanaOrden.close();
                                                m.getCircle().setFill(Color.YELLOW);
                                                m.setOcupado(false);
                                                double valorTotal= 0;
                                            }
                                           /* for (Producto p2: o.getProductos_orden()){
                                                valorTotal= valorTotal+p2.getPrecio();
                                                
                                            }
                                            o.setTotal(valorTotal);*/
                                            //se debe finalizar la ordenn
                                            
                                            
                                        });
                                        
                                        _regresar.setOnMouseClicked((MouseEvent ev6)->{
                                            nuevaVentanaOrden.close();
                                            
                                        });
                                        
                                        
                                    }
                                }
                            } catch (FileNotFoundException ex) {
                                System.out.println("No se encontro archivo");
                            }
                        }                        
                    
                    });
                _seccionPlanoM.getChildren().addAll(c, _numero);
            
       
      
    }
        
        //mesas = InterfazAdministrador.mesas;
        //System.out.println("Check mesas: " +mesas);
        
         }
    
    
    /**
     * Creacion de ventana para el manejo de crearOrden e ingresar cliente nuevo.
     */
    
    public void crearVentana(){
      nuevaVentana= new Stage();
      rootVentana= new VBox();
      _nuevaCuenta= new Label("Abrir Cuenta");
      Label l= new Label("Ingrese Nombre del Cliente"); 
      _nombreCliente = new TextField();
      _aceptar= new Button("Aceptar");
      sc2= new Scene(rootVentana, 300,300); 
      rootVentana.getChildren().addAll(_nuevaCuenta,l,_nombreCliente,_aceptar);
      nuevaVentana.setScene(sc2);
      nuevaVentana.show();

    }
    
    /**
     * Manejo interior que crea ventana de eleccion de productos y contiene el display del arraylist que muestra cantidad y total de orden.
     * Al otro lado contiene el menu con la funcion de busqueda en menu, y 4 categorias. Define el total de la orden.
     * @param l: Label de header para titulo de ventana.
     * @param o: Orden sobre la que se trabaja.
     */

    public void crearVentanaOrden(Label l,Orden o){
          nuevaVentanaOrden= new Stage();
          rootVentanaOrden= new VBox();
          
          _ventanaSig= new HBox();
          
          Rectangle rect= new Rectangle(3, 250);
            //rect.setLayoutX(285);
            //rect.setLayoutY(5);
            
          _seccionOrdenes = new VBox();
           ordenes = new VBox();
           
          ArrayList<Producto> p_unicos= new ArrayList<>();
           for (Producto p: o.getProductos_orden()){
               if(p_unicos.contains(p)==false){
                   p_unicos.add(p);
               }
           }
           
          
          for (Producto p: p_unicos){
                int nuevo= Collections.frequency(o.getProductos_orden(), p);
                 info_orden= new HBox();
                 itemOrden_precio= new VBox();
                 precioFinal= new Label("$ "+p.getPrecio()*nuevo);
                 nombreProducto= new Label(p.getNombreProducto());
                 cant_Punitario= new Label(nuevo+ "unidad(es) a "+p.getPrecio()+"/unidad");
                 //valorFinalO = valorFinalO + (p.getPrecio()*nuevo);
                 //System.out.println("El valor final es CREARVENT: "+valorFinalO);
                 
                 itemOrden_precio.getChildren().addAll(nombreProducto,cant_Punitario);
                 info_orden.getChildren().addAll(itemOrden_precio,precioFinal);
                 ordenes.getChildren().add(info_orden);
                 
               
           }
          
          
          
          _finalizarOrden= new Button("Finalizar Orden");
          _regresar = new Button("Regresar");
          
          _seccionMenu = new VBox();
          _menu = new VBox();
          
          sc3= new Scene(rootVentanaOrden, 800,600); 
          
          _seccionOrdenes.getChildren().addAll(ordenes,_finalizarOrden,_regresar);
          _seccionMenu.getChildren().addAll(_menu);
          _ventanaSig.getChildren().addAll(_seccionOrdenes,rect,_seccionMenu);
          rootVentanaOrden.getChildren().addAll(l,_ventanaSig);
          
          nuevaVentanaOrden.setScene(sc3);
          nuevaVentanaOrden.show();

        }    
    
    /**
     * Metodo que crea el menu de igual manera que el de administrador, pero sin la funcionalidad de agregar ordenes, y todos los items son botones para poder ser accionados.
     * Contiene TextField para buscar y evento.
     * @param o: Orden a trabajar.
     * @throws FileNotFoundException : Lo arroja por el manejo de FileInputStream.
     */

    public void manejoMenuMesero(Orden o) throws FileNotFoundException{
        
         //valorTotal = new Label("Total: $ "+o.getTotal());
         //info_orden.getChildren().add(valorTotal);
        
        ComboBox<String> ctipo= new ComboBox (FXCollections.observableArrayList("Salado","Bebida","Postre","Todos"));
          Button postres = new Button ( "Postres ", new ImageView ( new Image ( new FileInputStream ( "src/recursos/botones/postres.png" ) ) ) );
          Button bebidas = new Button ( "Bebidas", new ImageView ( new Image ( new FileInputStream ( "src/recursos/botones/bebidas.png" ) ) ) );
          Button salados = new Button ( "Salados",  new ImageView ( new Image ( new FileInputStream ( "src/recursos/botones/salados.png" ) ) ) );
          Button todos = new Button ( "Todos" );
          
          
          buscar = new TextField();
          
          
          
          HBox opcionesMenu = new HBox();
          productosMenu = new FlowPane();
          opcionesMenu.getChildren ( ).addAll ( postres, bebidas, salados, todos, buscar ) ;
          _menu.getChildren ( ).addAll ( opcionesMenu, productosMenu );
        
            EventHandler < MouseEvent > ev2 = (MouseEvent ev1) -> {
                try{
                    productosMenu.getChildren ( ).clear ( );
                    if (ev1.getSource() == postres) {
                        System.out.println("Dentro");
                        mostrarPorductos("Postre",o);
                    }
                    if (ev1.getSource() == bebidas) {
                        System.out.println("Dentro1");
                        mostrarPorductos("Bebida",o);
                    }
                    if (ev1.getSource() == salados) {
                        System.out.println ( "Dentro3" );
                        mostrarPorductos ( "Salado",o );
                    }
                    if (ev1.getSource()== todos) {
                        System.out.println("Dentro4");
                        mostrarPorductos("Postre",o);
                        mostrarPorductos("Bebida",o);
                        mostrarPorductos ( "Salado",o );
                    }
                    }catch ( FileNotFoundException ex )
                            {
                                System.out.println(ex.getMessage());
                            }
               }; 
            postres.setOnMouseClicked ( ev2 );
            bebidas.setOnMouseClicked ( ev2 );
            salados.setOnMouseClicked ( ev2 );
            todos.setOnMouseClicked(ev2);
            
            
            buscar.setOnKeyReleased((KeyEvent k)->{
            try {
                busqueda = buscar.getText();
                mostrarBusqueda(busqueda,o);
            } catch (FileNotFoundException ex) {
                System.out.println("Archivo no encontrado");
            }
                
            });
            
    }
    
    /**
     * Metodo de muestra de productos en base a eleccion.
     * @param tipo: String de tipo de producto.
     * @param o: Orden a trabajar.
     * @throws FileNotFoundException : Se arroja por manejo de FileInputStream.
     */
    
    public void mostrarPorductos ( String tipo, Orden o ) throws FileNotFoundException
    {
        for ( Producto p: Programa.productos )
        {
            if ( p.getTipo ( ).equals ( tipo ) )
            {
                
                String s = p.getN_imagen();
                FileInputStream inputstream = new FileInputStream(s); 
                Image img = new Image(inputstream);
                ImageView imgview = new ImageView(img);
                imgview.setFitHeight(50);
                imgview.setFitWidth(50);
                String l1= p.getNombreProducto();
                String l2= String.valueOf(p.getPrecio());
                String l3 = ("Nombre: "+l1+"\n"+"Precio: "+l2);
                infoProducto = new Button(l3,imgview);
                //manejo de info producto
                 infoProducto.setOnMouseClicked((MouseEvent e20)->{
                      o.getProductos_orden().add(p);
                         System.out.println("Dentro para añadir");
                        precioFinal= new Label();
                        nombreProducto= new Label();
                        cant_Punitario= new Label();
                        ArrayList<Producto> p_unicos= new ArrayList<>();
                        for (Producto p2: o.getProductos_orden()){
                            if(p_unicos.contains(p2)==false){
                             p_unicos.add(p2);
                        }
                        }
                       System.out.println(p_unicos);
                        ordenes.getChildren().clear();
                        valorFinalO = 0;
                        for (Producto p3: p_unicos){
                            int nuevo= Collections.frequency(o.getProductos_orden(), p3);
                            info_orden= new HBox();
                            itemOrden_precio= new VBox();
                            precioFinal= new Label("$ "+p3.getPrecio()*nuevo);
                            nombreProducto= new Label(p3.getNombreProducto());
                            cant_Punitario= new Label(nuevo+ "unidad(es) a "+p3.getPrecio()+"/unidad");
                            valorFinalO = valorFinalO + (p3.getPrecio()*nuevo);
                            System.out.println("El valor final es MOSTRARPROD: "+valorFinalO);
                            itemOrden_precio.getChildren().addAll(nombreProducto,cant_Punitario);
                            info_orden.getChildren().add(itemOrden_precio);
                           
                           ordenes.getChildren().add(info_orden);
                            }
                o.setTotal(valorFinalO);       
                valorTotal = new Label("Total: $ "+valorFinalO);
                info_orden.getChildren().add(valorTotal);
            });productosMenu.getChildren().add(infoProducto);
        }
    }}
    
    /**
     * Metodo para retornar y displayear el producto de string busqueda.
     * @param busqueda : String del textfield.
     * @throws FileNotFoundException : Por manejo de FileInputStream.
     */
        
    public void mostrarBusqueda(String busqueda, Orden o) throws FileNotFoundException{
        productosMenu.getChildren ( ).clear ( );
        for (Producto p:Programa.productos){
            System.out.println("Nombre: " +p.getNombreProducto());
            System.out.println("Producto a buscar: "+busqueda);
              if (p.getNombreProducto().toLowerCase().contains(busqueda.toLowerCase())){
                String s = p.getN_imagen();
                FileInputStream inputstream = new FileInputStream(s); 
                Image img = new Image(inputstream);
                ImageView imgview = new ImageView(img);
                imgview.setFitHeight(50);
                imgview.setFitWidth(50);
                String l1= p.getNombreProducto();
                String l2= String.valueOf(p.getPrecio());
                String l3 = ("Nombre: "+l1+"\n"+"Precio: "+l2);
                infoProducto = new Button(l3,imgview);
                 infoProducto.setOnMouseClicked((MouseEvent e20)->{
                      o.getProductos_orden().add(p);
                         System.out.println("Dentro para añadir");
                        precioFinal= new Label();
                        nombreProducto= new Label();
                        cant_Punitario= new Label();
                        ArrayList<Producto> p_unicos= new ArrayList<>();
                        for (Producto p2: o.getProductos_orden()){
                            if(p_unicos.contains(p2)==false){
                             p_unicos.add(p2);
                        }
                        }
                       System.out.println(p_unicos);
                        ordenes.getChildren().clear();
                        valorFinalO = 0;
                        for (Producto p3: p_unicos){
                            int nuevo= Collections.frequency(o.getProductos_orden(), p3);
                            info_orden= new HBox();
                            itemOrden_precio= new VBox();
                            precioFinal= new Label("$ "+p3.getPrecio()*nuevo);
                            nombreProducto= new Label(p3.getNombreProducto());
                            cant_Punitario= new Label(nuevo+ "unidad(es) a "+p3.getPrecio()+"/unidad");
                            valorFinalO = valorFinalO + (p3.getPrecio()*nuevo);
                            System.out.println("El valor final es MOSTRARPROD: "+valorFinalO);
                            itemOrden_precio.getChildren().addAll(nombreProducto,cant_Punitario);
                            info_orden.getChildren().add(itemOrden_precio);
                           
                           ordenes.getChildren().add(info_orden);
                            }
                o.setTotal(valorFinalO);       
                valorTotal = new Label("Total: $ "+valorFinalO);
                info_orden.getChildren().add(valorTotal);
            });
                
                productosMenu.getChildren().add(infoProducto);
            }
          }
    }
    
    /**
     * Salida de interfazMesero.
     */
    
    private void manejoMeseroSalir ( )
    {
        if ( CuadroDialogo.confirmacion ( "CONFIRMACIÓN", "¿Está seguro que desea cerrar sesión?", null ).get ( ) == ButtonType.OK )
        {
            VistaPrograma p = new VistaPrograma();
            StackPane regreso = p.getRoot();
            _rootM.getChildren().clear();
            _rootM.getChildren().add(regreso);
        }
    }


}
