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
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.joda.time.format.ISODateTimeFormat.date;

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

    @Override
    public List<Registro> registerSalida(Integer idpersonal) {

        String QUERY = "select Personal_idPersonal, HoraRegistroIn,IFNULL(validacion,'no validacion') AS estado from registro where Personal_idPersonal=? and validacion=1";
        List<Registro> personal = new LinkedList<Registro>();
        DateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setInt(1, idpersonal);
            ResultSet rs = preparedStatement.executeQuery();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Registro registro = null;
            while (rs.next()) {
                registro = new Registro();
                Date date = (Date) formatter.parse("HoraRegistroIn");
                Timestamp time = new Timestamp(date.getTime());
                registro.setHoraRegistroIn(time);
                registro.setValidacion(Integer.parseInt(rs.getString("estado")));
                personal.add(registro);
            }
            rs.close();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(JDBCPersonalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personal;

    }

    @Override
    public Boolean userExiste(Integer dni) {
        Boolean existe = false;
        String QUERY = "SELECT idPersonal FROM personal WHERE DNI=?";
        Personal person = new Personal();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setInt(1, dni);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.last()) {
                //System.out.print("esto es " +Boolean.parseBoolean(rs.getString("idPersonal")));
                //existe = Boolean.parseBoolean(rs.getString("idPersonal"));
                existe = true;
            }
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.print("paso por aca");
            e.printStackTrace();
        }
        return existe;
    }

}
