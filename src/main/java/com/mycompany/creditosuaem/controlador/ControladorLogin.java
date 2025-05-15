/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.creditosuaem.controlador;

import static com.mycompany.creditosuaem.controlador.ControladorSistema.ocultar;
import javax.swing.JOptionPane;
import modelo.UsuarioDAO;
import vista.Login;
import vista.Menu;
/**
 *
 * @author ianvi
 */


public class ControladorLogin {
    public static Login vista = new Login();
    
    public static void mostrar() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        // Agregar el listener al botón de login
        vista.getBtnLoginIniciar().addActionListener(e -> login());
    }
    
    public static void login() {
        String usuario = vista.getTxtLoginUsuario().getText().trim();
        char[] passwordChars = vista.getTxtLoginContraseña().getPassword();
        String contrasena = new String(passwordChars).trim();
        
        java.util.Arrays.fill(passwordChars, '0');

        if(usuario.isEmpty() || contrasena.isEmpty()) {
            mostrarError("Debe ingresar usuario y contraseña", "Campos vacíos");
            return;
        }

        UsuarioDAO dao = new UsuarioDAO();
        
        if (dao.autenticar(usuario, contrasena)) {
            mostrarExito("Bienvenido " + usuario, "Login exitoso");
            ocultar();

            // Aquí mostramos la vista del menú
            Menu menu = new Menu();
            menu.setVisible(true);

        } else {
            mostrarError("Credenciales incorrectas", "Error de autenticación");
            limpiar();
        }
    }

    public static void ocultar() {
        vista.setVisible(false);
    }

    public static void limpiar() {
        vista.getTxtLoginUsuario().setText("");
        vista.getTxtLoginContraseña().setText("");
        vista.getTxtLoginUsuario().requestFocus();
    }
    
    private static void mostrarError(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(vista, mensaje, 
                titulo, JOptionPane.ERROR_MESSAGE);
    }
    
    private static void mostrarExito(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(vista, mensaje, 
                titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}
