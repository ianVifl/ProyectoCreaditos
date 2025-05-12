/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.creditosuaem.controlador;

import vista.Login;

/**
 *
 * @author ianvi
 */
public class ControladorLogin {
    public static Login vista = new Login();
    
    public static void mostrar (){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    
}
