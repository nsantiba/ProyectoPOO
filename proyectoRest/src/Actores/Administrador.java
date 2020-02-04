package Actores;

/**
 *
 * @author Eddy Santibañez J
 */
public class Administrador extends Persona
{    
    public Administrador(String correo, String contrasena) 
    {
        super(correo, contrasena);
    }
    
    @Override
    public String toString(){
        return ("Administrador"+super.getCorreo());
    }
}
