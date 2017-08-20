/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.java.bd;

import javax.swing.JOptionPane;

/**
 *
 * @author carlosjoseanguiano
 */
public class ProjectJavaBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ConnectionBD connection = new ConnectionBD();
        try {

            int seleccion = Integer.parseInt(JOptionPane.showInputDialog("Elige tu opcion" +
                "\n 1 .- + Ejecutar Consulta" +
                "\n 2 .- + Asignar Parametro" +
                "\n 3 .- + Preparar Sentencia" +
                "\n 4 .-Llenar Tablas" +
                "\n 5 .- + Desconectar" +
                "\n 6 .- + Salir"));

            switch (seleccion) {
                case 1:
                    System.out.println("Ejecutar Consulta");
                    connection.ejecutarConsulta();
                    break;
                case 2:
                    System.out.println("Asignar Parametro");
                    connection.asignarParametro();
                    break;
                case 3:
                    System.out.println("Preparar Sentencia");
                    connection.prepararSentencia();
                    break;
                case 4:
                    System.out.println("Llenar Tablas");
                    break;
                case 5:
                    System.out.println("Conexion cerrada");
                    connection.desconectar();
                    System.exit(0);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Default");
                    break;

            }
        } catch (Exception e) {
            System.out.println("Selecciona numeros ");
        }
    }
}