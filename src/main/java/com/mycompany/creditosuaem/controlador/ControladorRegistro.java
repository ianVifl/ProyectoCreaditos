/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.creditosuaem.controlador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Registros;
import modelo.UsuarioDAO;
import vista.Registro;

/**
 *
 * @author alber
 */
public class ControladorRegistro {
    public static Registro vista = new Registro();
    private static final String ARCHIVO_REGISTROS = "registros_estudiantes.txt";

    public static void mostrar() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    public static void registrar() {
        var errores = new StringBuilder();
        var usuario = new Registros();
        
        // Validación de campos
        if (vista.getTxtNombreCompleto().getText().trim().length() > 0) {
            usuario.setNombreCompleto(vista.getTxtNombreCompleto().getText().trim());
        } else {
            errores.append("El campo nombre no debe estar vacío. ");
        }
        
        if (!vista.getTxtMatricula().getText().trim().equals("")) {
            usuario.setMatricula(vista.getTxtMatricula().getText().trim());
        } else {
            errores.append("El campo matrícula no debe estar vacío. ");
        }
        
        if (!vista.getTxtFacultad().getText().trim().equals("")) {
            usuario.setFacultad(vista.getTxtFacultad().getText());
        } else {
            errores.append("El campo facultad no debe estar vacío. ");
        }
        
        if (!vista.getTxtCarrera().getText().trim().equals("")) {
            usuario.setCarrera(vista.getTxtCarrera().getText());
        } else {
            errores.append("El campo carrera no debe estar vacío. ");
        }
        
        if (!vista.getTxtSemestre().getText().trim().equals("")) {
            usuario.setSemestre(vista.getTxtSemestre().getText());
        } else {
            errores.append("El campo semestre no debe estar vacío. ");
        }
        
        if (!vista.getTxtEdad().getText().trim().equals("")) {
            usuario.setEdad(vista.getTxtEdad().getText());
        } else {
            errores.append("El campo edad no debe estar vacío. ");
        }

        if (errores.length() > 0) {
            JOptionPane.showMessageDialog(
                    null,
                    errores.toString(),
                    "Errores de validación",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            if (guardarEnArchivo(usuario)) {
                JOptionPane.showMessageDialog(
                        null,
                        "El usuario ha sido registrado exitosamente.",
                        "Registro exitoso",
                        JOptionPane.INFORMATION_MESSAGE);
                limpiar();
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "Error al guardar el registro.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static boolean guardarEnArchivo(Registros usuario) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_REGISTROS, true))) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fechaRegistro = dateFormat.format(new Date());
            
            writer.write("Fecha Registro: " + fechaRegistro);
            writer.newLine();
            writer.write("Nombre: " + usuario.getNombreCompleto());
            writer.newLine();
            writer.write("Matrícula: " + usuario.getMatricula());
            writer.newLine();
            writer.write("Facultad: " + usuario.getFacultad());
            writer.newLine();
            writer.write("Carrera: " + usuario.getCarrera());
            writer.newLine();
            writer.write("Semestre: " + usuario.getSemestre());
            writer.newLine();
            writer.write("Edad: " + usuario.getEdad());
            writer.newLine();
            writer.write("----------------------------------------");
            writer.newLine();
            writer.newLine();
            
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void limpiar() {
        vista.getTxtNombreCompleto().setText("");
        vista.getTxtMatricula().setText("");
        vista.getTxtFacultad().setText("");
        vista.getTxtCarrera().setText("");
        vista.getTxtSemestre().setText("");
        vista.getTxtEdad().setText("");
    }
}
    
