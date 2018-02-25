package JDBC;

import DAO.PersonalDAO;
import Entity.Personal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Entity.Registro;
import java.sql.Date;
import java.util.logging.Logger;

public class JDBCPersonalDAO implements PersonalDAO {

    Connection connection = null;
    public String bd = "bdproyectomate";
    public String url = "jdbc:mysql://localhost:3306/" + bd;
    public String user = "root";
    public String pass = "";
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Conectado!!");
            connection = DriverManager.getConnection(this.url, this.user, this.pass);

        } catch (Exception e) {
            System.out.println("No hay conexion");
            e.printStackTrace();

        }
        return connection;
    }

    @Override
    public void insert(Registro registro) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO bdproyectomate.registro (HoraRegistroIn,Personal_idPersonal,Estado) VALUES (?,?,?)");
            preparedStatement.setTimestamp(1, registro.getHoraRegistroIn());
            preparedStatement.setInt(2, registro.getPersonal_idPersonal());
            preparedStatement.setString(3, registro.getEstado());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            //do nothing
        }
    }

    @Override
    public Integer select(Integer dni) {
        Integer returnData = null;
        String QUERY = "SELECT idPersonal FROM personal WHERE DNI=?";
        Personal person = new Personal();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setInt(1, dni);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                returnData = Integer.parseInt(rs.getString("idPersonal"));
            }

            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return returnData;
    }

    @Override
    public void Salida(Registro registro) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO bdproyectomate.registro (HoraRegistroIn,Personal_idPersonal,Estado) VALUES (?,?,?)");
            preparedStatement.setTimestamp(1, registro.getHoraRegistroIn());
            preparedStatement.setInt(2, registro.getPersonal_idPersonal());
            preparedStatement.setString(3, registro.getEstado());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String horarioInicial() {
        String returnData = null;
        String QUERY = "select HoraEntrada, HoraSalida from bdproyectomate.area right outer join bdproyectomate.personal ON personal.Area_idArea=area.idArea;";
        Personal person = new Personal();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                returnData = rs.getString("HoraEntrada");
            }

            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return returnData;
    }

}
