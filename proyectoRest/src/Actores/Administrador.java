package Actores;

/**
 *Creacion de clase admin para manejo de interfaces administrador
 * @author Eddy Santibañez J
 */


public class Administrador extends Persona
{    
    public Administrador(String correo, String contrasena) 
    {
        super(correo, contrasena);
    }
    
    /**
     * No es necesario crear metodos, ya que el usuario admin no es necesario en general salvo para verificacion.
     * toString enteramente para mejora del array de personas
    */ 
    
    @Override
    public String toString(){
        return ("Administrador"+super.getCorreo());
    }
}
