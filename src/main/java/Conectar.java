import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conectar {

    static String timezone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static String dbName = "pole";
    static String url = "jdbc:mysql://127.0.0.1/" + dbName + timezone;
    static String user = "root";
    static String pass = "manolo";
    // static String driver = "com.mysql.cj.jdbc.Driver";

    static Connection conexion;
    static Statement consulta;
    static ResultSet resultado;

    public static void conectar() {
        try {
            conexion = DriverManager.getConnection(url, user, pass);
            consulta = conexion.createStatement();
            System.out.println("Conectado");
        } catch (SQLException e) {
            System.out.println("Ha fallado la conexión");
            e.printStackTrace();
        }
    }

    public static ResultSet EjecutarSentencia(String sentencia) {
        try {
            resultado = consulta.executeQuery(sentencia);
            //System.out.println("DONE");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public static void EjecutarUpdate(String sentencia) {
        try {
            consulta.executeUpdate(sentencia);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void CerrarConexion() {
        try {
            consulta.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}