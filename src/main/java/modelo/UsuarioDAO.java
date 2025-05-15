/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author alber
 */
public class UsuarioDAO {
    
    public boolean autenticar(String usuario, String contrasena) {
        // Credenciales de prueba (puedes cambiarlas)
        String usuarioValido = "admin";
        String contrasenaValida = "12345";
        
        return usuarioValido.equals(usuario) && contrasenaValida.equals(contrasena);
    }

    public int registrar(Registros usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
