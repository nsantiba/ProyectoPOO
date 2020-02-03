package Interfaz;

import Actores.Administrador;
import Actores.Mesa;
import Actores.Mesero;
import Actores.Persona;
import Actores.Producto;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import Interfaz.VistaPrograma;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import Interfaz.Programa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.SortedMap;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import Interfaz.Programa;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
/**
 *
 * @author Eddy Santibañez J
 */
public class InterfazAdministrador {
       static ArrayList<Mesa> mesas= new ArrayList<>();
       
       VBox _rootA;
       HBox _menu; 
       Pane _seccionPlanos= new Pane();
       Pane _planos;
       Pane _seccionMonitoreo= new Pane();
       VBox _SeccionMenu= new VBox();
       HBox opcionesMenu; 
       FlowPane productosMenu;
       Button _monitoreo; 
       Button _disenoPlano;
       Button _gestionMenu;
       Button _reporteVentas;
       Button _adminSalir; 
       Stage ventanaMesa;
       VBox rootMesa;
       Label _nuevaMesa;
        HBox _capacidad;
        HBox _numero;
        Label _capa;
        TextField _Tcapa;
        Label _num;
        TextField _Tnum;
        Button _aceptar;
        Scene sc2;
        Button borrarMesa=  new Button("Borrar Mesa"); 
        VBox _infoMesa= new VBox();
        Label cocina;
        Label cocina2;
        Rectangle rect = new Rectangle(10, 250); 
        Rectangle rect2= new Rectangle(10, 250);
        Label estadoMesa= new Label();
        private TableView table;
        TableColumn c_Fecha;
        TableColumn c_Mesa;
        TableColumn c_Mesero;
        TableColumn c_Cuenta;
        TableColumn c_Cliente;
        TableColumn c_Total;
        Label  _Finicio;
        Label _Ffin;
        TextField inicio;
        TextField fin;
        boolean continuar= true;
        VBox infoMesa;
        String estado= " ";
        String mesero=" ";
        String valorfac;
        Button buscar;
        Button postres;
        Button bebidas;
        Button salados; 
        
     
       public InterfazAdministrador() throws FileNotFoundException{
           crearMenu();
           crearSeccionPlanosyMonitoreo();
          
           manejoMonitoreo();
           manejoDisenoPlano();
           manejoGestionMenu();
           //MonitoreoPlano monitoreoPlano= new MonitoreoPlano();
           //Thread t1= new Thread(monitoreoPlano);
           //t1.start();
           
          
          
       }

         public VBox getRootA() {
            return _rootA;
        }

    
       
       
       public void crearMenu() throws FileNotFoundException{
           _rootA= new VBox();
           _menu= new HBox();
           _monitoreo = new Button ( "Monitoreo", new ImageView ( new Image ( new FileInputStream ( "src/recursos/botones/monitoreo.png" ) ) ) );
           _disenoPlano = new Button ( "Diseño Plano", new ImageView ( new Image ( new FileInputStream ( "src/recursos/botones/plano.png" ) ) )  );
           _gestionMenu = new Button ( "Gestión Menú", new ImageView ( new Image ( new FileInputStream ( "src/recursos/botones/menu.png" ) ) ) );
           _reporteVentas = new Button ( "ReporteVentas", new ImageView ( new Image ( new FileInputStream ( "src/recursos/botones/reporte.png" ) ) ) );           
           _adminSalir = new Button ( "Salir", new ImageView ( new Image ( new FileInputStream ( "src/recursos/botones/salir.png" ) ) ) ); 
           _planos= new Pane();
           
           _menu.getChildren().addAll(_monitoreo,_disenoPlano,_gestionMenu,_reporteVentas,_adminSalir);
           _rootA.getChildren().addAll(_menu,_planos);
          
           
           EventHandler<MouseEvent> ev= (MouseEvent ev1) -> {
               if (ev1.getSource() == _monitoreo) {
                   _planos.getChildren().clear();
                   _planos.getChildren().add(_seccionMonitoreo);
                   _planos.getChildren().add(infoMesa);
                   //_rootA.getChildren().add(infoMesa);
               }
               if (ev1.getSource() == _disenoPlano) {
                   _planos.getChildren().clear();///
                   _planos.getChildren().add(_seccionPlanos);
               }
               if (ev1.getSource() == _gestionMenu) {
                   _planos.getChildren().clear();
                   _planos.getChildren().add(_SeccionMenu);
               }
               if (ev1.getSource() == _reporteVentas) {
                   _planos.getChildren().clear();
                   manejoReporteVentas();
               }
               if (ev1.getSource() == _adminSalir) {
                   manejoAdminSalir();
               }
           };
          _monitoreo.setOnMouseClicked(ev);
          _disenoPlano.setOnMouseClicked(ev);
          _gestionMenu.setOnMouseClicked(ev);
          _reporteVentas.setOnMouseClicked(ev);
          _adminSalir.setOnMouseClicked(ev);

          }
       
       
  
         public void manejoMonitoreo(){
         
             infoMesa= new VBox(); 
             Label l_valor= new Label("Valor facturado"+valorfac);
             Label l_estado= new Label("Estado: "+estado);
             Label MeseroMesa= new Label("Mesero: "+mesero);        
             infoMesa.getChildren().addAll(l_estado,MeseroMesa,l_valor);
             infoMesa.setLayoutX(100);
             infoMesa.setLayoutY(300);
             
         
         }       
       
          public void manejoDisenoPlano(){
                   
            _seccionPlanos.setOnMouseClicked((MouseEvent e)->{  
                crearVentana();
                //se inicializa la ventana
                
                 
                ventanaMesa.setScene(sc2);
                _aceptar.setOnMouseClicked((MouseEvent e2)->{
                     
                        //Programa.sc.
                    int mesa_capacidad=Integer.parseInt(_Tcapa.getText());
                    String mesa_numero= _Tnum.getText();
                    ventanaMesa.close(); //cierro la ventana
                    double posx= e.getSceneX();
                    double posy= e.getSceneY();
                    Mesa m= new Mesa(mesa_capacidad,mesa_numero,posx,posy);
                    Mesa m2= new Mesa(mesa_capacidad,mesa_numero,posx,posy);
                    mesas.add(m);//agregp cada mesa a mesas 
                    System.out.println("se agregó");
                    Circle c=m.getCircle();
                    Circle c2= m2.getCircle();
                    Label _numeMesa= new Label(mesa_numero);
                    Label _numeMesa2= new Label(mesa_numero);
                    c.setCenterX(posx);
                    c.setCenterY(posy);
                    c2.setCenterX(posx);
                    c2.setCenterY(posy);
                    _numeMesa.setLayoutX(posx);
                    _numeMesa.setLayoutY(posy);
                    _numeMesa2.setLayoutX(posx);
                    _numeMesa2.setLayoutY(posy);

                    _seccionPlanos.getChildren().addAll(c,_numeMesa);
                    _seccionMonitoreo.getChildren().addAll(c2,_numeMesa2);
                    
                    c.setOnMouseDragged((MouseEvent e3)->{
                        double posx2=e3.getSceneX();
                        double posy2=e3.getSceneY();
                        
                        c.setCenterX(posx2);
                        c.setCenterY(posy2);
                        m.setCentrox(posx2);
                        m.setCentroy(posy2);
                        _numeMesa.setLayoutX(posx2);
                        _numeMesa.setLayoutY(posy2);
                        c2.setCenterX(posx2);
                        c2.setCenterY(posy2);
                        m2.setCentrox(posx2);
                        m2.setCentroy(posy2);
                        _numeMesa2.setLayoutX(posx2);
                        _numeMesa2.setLayoutY(posy2);
                        
                
                
                    });
                        
                    c.setOnMouseClicked((MouseEvent e4)->{
                    //_planos.getChildren().add(borrarMesa);
                        //borrarMesa.setOnMouseClicked((MouseEvent e5)->{

                    _seccionPlanos.getChildren().remove(_numeMesa);
                    _seccionPlanos.getChildren().remove(c);
                    mesas.remove(m);
                    _seccionMonitoreo.getChildren().remove(_numeMesa2);
                    _seccionMonitoreo.getChildren().remove(c2);
                    

                    //_planos.getChildren().remove(borrarMesa);


                    });
                    
                    c.setOnMouseEntered((MouseEvent e5)->{  
                        Mesero r  = m.getMesero();
                        String mesero = r.toString();
                           
                    });
                    
                     c2.setOnMouseMoved((MouseEvent e6)->{
                               System.out.println("ooo");
                              
                               
                           
                           });
                     
       
                    });
                     _capacidad.getChildren().addAll(_capa,_Tcapa);
                     _numero.getChildren().addAll(_num,_Tnum);
                     rootMesa.getChildren().addAll(_nuevaMesa,_capacidad,_numero,_aceptar);
                     ventanaMesa.show();
              
                    }) ;     
                         
                          
           
                }
          
    public void manejoGestionMenu() throws FileNotFoundException
    {  ComboBox<String> ctipo= new ComboBox (FXCollections.observableArrayList("Salado","Bebida","Postre"));
        TextField nombrePlato= new TextField();
        TextField precioPlato= new TextField();
        TextField rutaImg= new TextField();
        Button agregar= new Button("Agregar");
        postres = new Button ( "Postres ", new ImageView ( new Image ( new FileInputStream ( "src/recursos/botones/postres.png" ) ) ) );
        bebidas = new Button ( "Bebidas", new ImageView ( new Image ( new FileInputStream ( "src/recursos/botones/bebidas.png" ) ) ) );
        salados = new Button ( "Salados",  new ImageView ( new Image ( new FileInputStream ( "src/recursos/botones/salados.png" ) ) ) );
        Button btn_agregar = new Button ( "Agregar",  new ImageView ( new Image ( new FileInputStream ( "src/recursos/botones/agregar_plato.png" ) ) ) ); 
        opcionesMenu = new HBox();
        productosMenu = new FlowPane();
        opcionesMenu.getChildren ( ).addAll ( postres, bebidas, salados, btn_agregar ) ;
        _SeccionMenu.getChildren ( ).addAll ( opcionesMenu, productosMenu );
        //_planos.getChildren().add(_SeccionMenu);
            
        EventHandler < MouseEvent > ev2 = (MouseEvent ev1) -> {
            try {
                productosMenu.getChildren ( ).clear ( );
                if (ev1.getSource() == postres) {
                    System.out.println("Dentro");
                    mostrarPorductos("Postre");
                }
                if (ev1.getSource() == bebidas) {
                    System.out.println("Dentro1");
                    mostrarPorductos("Bebida");
                }
                if (ev1.getSource() == salados) {
                    System.out.println ( "Dentro3" );
                    mostrarPorductos ( "Salado" );
                }
                if (ev1.getSource() == btn_agregar) {
                    System.out.println ( "Dentro de Agregar Plato" );
                    GridPane grilla = new GridPane ( );
                        grilla.add ( new Label ( "Nombre plato:" ), 0, 0 );
                        grilla.add (nombrePlato, 1, 0 );
                        grilla.add ( new Label ( "Tipo:" ), 0, 1 );
                        grilla.add ( ctipo, 1, 1 );
                        grilla.add ( new Label ( "Precio:" ), 0, 2 );
                        grilla.add ( precioPlato, 1, 2 );
                        grilla.add ( new Label ( "Ruta:" ), 0, 3 );
                        grilla.add ( rutaImg, 1, 3 );
                    FileChooser fch = new FileChooser ( );
                    ImageView imgV_seleccionada = new ImageView ( );
                    imgV_seleccionada.setFitHeight ( 250 );
                    imgV_seleccionada.setFitWidth ( 250 );
                    Button btn_explorar = new Button ( "Explorar" );
                    /*btn_explorar.setOnAction
                                ((ActionEvent t) -> {
                                    try
                                    {
                                        File archivo = fch.showOpenDialog ( ventanaMesa );
                                        if ( archivo.isFile() && ( archivo.getName ( ).contains ( ".jpg" ) || archivo.getName ( ).contains ( ".png" ) ||
                                                archivo.getName ( ).contains ( ".bmp" ) || archivo.getName ( ).contains ( ".gif" ) ) )
                                        {
                                            String ruta = archivo.toURI ( ).toURL ( ).toString ( );
                                            Image img = new Image ( ruta );
                                            imgV_seleccionada.setImage ( img );*/
                                            agregar.setOnMouseClicked((MouseEvent e10)->{
                                               System.out.println("dentro evento");
                                               String tt= ctipo.getValue();
                                               //en este constrcutor esoy pasanndo lo qye obtengo del text field no del examinarr
                                               //por que sale error (corregir)
                                                Producto pnuevo= new Producto(nombrePlato.getText(),Double.parseDouble(precioPlato.getText()),rutaImg.getText(),tt);
                                                Programa.productos.add(pnuevo);
                                             //se deria agregar sola gg
                                             //eliminar la imagenen del grid
                                             nombrePlato.setText("");
                                             precioPlato.setText("");
                                             rutaImg.setText("");});
                                        /*}
                                    }
                                    catch ( Exception e )
                                    {
                                        System.out.println ( "Error" );
                                    }
                    });*/
                    grilla.add ( btn_explorar, 2, 2 );
                    grilla.add ( imgV_seleccionada,  1, 5 );
                    grilla.add ( agregar,  1, 6 );
                    grilla.setHgap ( 5 );
                    grilla.setVgap ( 5 );
                    grilla.setPadding ( new Insets ( 5 ) );
                    productosMenu.getChildren ( ).add ( grilla );
                }
            }catch ( FileNotFoundException ex )
            {
                System.out.println(ex.getMessage());
            }
        }; 
        postres.setOnMouseClicked ( ev2 );
        bebidas.setOnMouseClicked ( ev2 );
        salados.setOnMouseClicked ( ev2 );
        btn_agregar.setOnMouseClicked ( ev2 );
    }
    
    public void mostrarPorductos ( String tipo ) throws FileNotFoundException
    {
        for ( Producto p: Programa.productos )
        {
            if ( p.getTipo ( ).equals ( tipo ) )
            {
                VBox infoProducto = new VBox();
                String s = p.getN_imagen();
                FileInputStream inputstream = new FileInputStream(s); 
                Image img = new Image(inputstream);
                ImageView imgview = new ImageView(img);
                imgview.setFitHeight(100);
                imgview.setFitWidth(100);
                Label l1= new Label(p.getNombreProducto());
                Label l2= new Label(String.valueOf(p.getPrecio()));
                infoProducto.getChildren().addAll(imgview,l1,l2);
                productosMenu.getChildren().add(infoProducto);
            }
        }
    }
    
           //_planos.getChildren().add(l);
           
           //_rootA.getChildren().add(_seccionPlanos);  
               
         
          public void manejoReporteVentas(){
            Label l= new Label("manejar el evento en el flowPane");
            _planos.getChildren().add(l);
            table = new TableView();
            _Finicio= new Label("F inico");
            _Ffin= new Label("F inico");
            inicio= new TextField();
            fin= new TextField();
            buscar= new Button("Buscar");
            c_Fecha = new TableColumn("Fecha");
            c_Mesa = new TableColumn("Mesa");
            c_Mesero = new TableColumn("Mesero");
            c_Cuenta = new TableColumn("# Cuenta");
            c_Cliente = new TableColumn("Cliente");
            c_Total = new TableColumn("Total");
   
          table.getColumns().addAll(c_Fecha, c_Mesa, c_Mesero,c_Cuenta,c_Cliente,c_Total);
          _planos.getChildren().add(table);
           //_rootA.getChildren().add(_seccionPlanos);
              
         }
          public void manejoAdminSalir() {
            VistaPrograma p = new VistaPrograma();
            StackPane regreso = p.getRoot();
            _rootA.getChildren().clear();
            _rootA.getChildren().add(regreso);
            
            /*String filepath = "src/Archivos/archivoMesas";
            try (ObjectOutputStream objOutputStream =  new ObjectOutputStream(new FileOutputStream(filepath))){
                
            objOutputStream.writeObject(mesas);
        } catch (FileNotFoundException e1) {
            System.out.println(e1.getMessage());
        } catch (IOException e2) {
            System.out.println(e2.getMessage());
        }*/
            //stage.getScene().setRoot();
            
           //Label l= new Label("manejar el evento en el flowPane");
           //_planos.getChildren().add(l);
           //_rootA.getChildren().add(_seccionPlanos);
         }
           
           
          public void crearVentana(){
            ventanaMesa= new Stage();
            rootMesa= new VBox();
            _nuevaMesa= new Label("Nueva Mesa");
            _capacidad= new HBox();
            _numero= new HBox();
            _capa= new Label("Capacidad");
            _Tcapa= new TextField();
            _num= new Label("Numero");
            _Tnum= new TextField();
            _aceptar= new Button("Aceptar");
            sc2= new Scene(rootMesa, 300,300); 
          }
          
          public ArrayList<Mesa> getMesas(){
              return mesas;
          }
         
          public void crearSeccionPlanosyMonitoreo(){
            cocina= new Label("Cocina");
            cocina2= new Label("Cocina");
            rect.setLayoutX(400);
            rect.setLayoutY(5);
            cocina.setLayoutX(410);
            cocina.setLayoutY(35);
            
            rect2.setLayoutX(400);
            rect2.setLayoutY(5);
            cocina2.setLayoutX(410);
            cocina2.setLayoutY(35);
            
            Mesa m= new Mesa(10,"1",50.0,50.0);
            Mesa m2= new Mesa(10,"1",50.0,50.0);
            Circle c= m.getCircle();
            Circle c2= m2.getCircle();
            c.setCenterX(50.0);
            c.setCenterY(50.0);
            Label _numeMesa= new Label("1");
            _numeMesa.setLayoutX(50.0);
            _numeMesa.setLayoutY(50.0);
            c2.setCenterX(50.0);
            c2.setCenterY(50.0);
            Label _numeMesa2= new Label("1");
            _numeMesa2.setLayoutX(50.0);
            _numeMesa2.setLayoutY(50.0);
            _seccionPlanos.getChildren().addAll(cocina, rect,c,_numeMesa);
            _seccionMonitoreo.getChildren().addAll(cocina2, rect2,c2,_numeMesa2);
            mesas.add(m);
            c.setOnMouseDragged((MouseEvent e3)->{
                c.setCenterX(e3.getSceneX());
                c.setCenterY(e3.getSceneY());
                _numeMesa.setLayoutX(e3.getSceneX());
                _numeMesa.setLayoutY(e3.getSceneY());
                m.setCentrox(e3.getSceneX());
                m.setCentroy(e3.getSceneY());
                c2.setCenterX(e3.getSceneX());
                c2.setCenterY(e3.getSceneY());
                _numeMesa2.setLayoutX(e3.getSceneX());
                _numeMesa2.setLayoutY(e3.getSceneY());
                m2.setCentrox(e3.getSceneX());
                m2.setCentroy(e3.getSceneY());
            });
                        
            c.setOnMouseClicked((MouseEvent e4)->{
                //_planos.getChildren().add(borrarMesa);
                //borrarMesa.setOnMouseClicked((MouseEvent e5)->{
                _seccionPlanos.getChildren().remove(_numeMesa);
                _seccionPlanos.getChildren().remove(c);
               // _planos.getChildren().remove(borrarMesa);


             // });

            });
             c2.setOnMouseMoved((MouseEvent e6)->{
                System.out.println("ooo");
          
            });
         
        }
}