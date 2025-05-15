/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.creditosuaem.controlador;

import vista.Menu;

/**
 *
 * @author ianvi
 */
public class ControladorSistema {
  public static Menu vista = new Menu();
  
    public static void mostrar() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    public static void ocultar() {
        vista.setVisible(false);

    }

    public static void iniciarRegistro() {
        System.out.print("Inicia Registro");
        ControladorRegistro.mostrar();
    }

   

    public static void iniciarConsulta() {
        System.out.print("Iniciar Consulta");
        ControladorConsulta.mostrar();

    }
}
