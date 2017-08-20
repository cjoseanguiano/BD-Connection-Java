package project.java.bd;

import java.sql.*;

/**
 *
 * @author c.joseanguiano
 */
public class ConnectionBD {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement preparedStatement;
    public ConnectionBD() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:8889/Estudiantes", "root", "root");
            st = con.createStatement();

        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }

    public void desconectar() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Error al intentar desconectar");
        }
    }

    public void prepararSentencia() {
        try {
            preparedStatement = con.prepareStatement("INSERT INTO `estudiante`(id,nombre,apellido,materia) VALUE (?,?,?,?)");
            preparedStatement.setInt(1, 18);
            preparedStatement.setString(2, "Perla");
            preparedStatement.setString(3, "Mercedez");
            preparedStatement.setString(4, "Ingles");

            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error de consulta");
        }
    }

    //    public void asignarParametro(int posicion, Object valor) {
    public void asignarParametro() {

        try {
            preparedStatement = con.prepareStatement("UPDATE estudiante SET id = ?, nombre = ? , apellido = ?, materia = ? WHERE id = 10");
            preparedStatement.setInt(1, 10);
            preparedStatement.setString(2, "Carlos");
            preparedStatement.setString(3, "Anguiano Roman");
            preparedStatement.setString(4, "Programacion");

            preparedStatement.executeUpdate();

            //            preparedStatement.setObject(posicion, valor);
        } catch (Exception e) {
            System.out.println("Error de asignacion");
        }
    }

    public void ejecutarConsulta() {

        try {
            String query = "select * from estudiante";
            rs = st.executeQuery(query);
            System.out.println("Todos los estudiantes");

            while (rs.next()) {
                String name = rs.getString("nombre");
                String materia = rs.getString("materia");
                System.out.println("Nombre: " + name + " Materia: " + materia);
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }

    public ResultSet llenarTablas() {
        try {
            rs = preparedStatement.executeQuery();
        } catch (Exception e) {
            System.out.println("Error al intentar llenar tabla " + e);
        }
        return rs;
    }
}