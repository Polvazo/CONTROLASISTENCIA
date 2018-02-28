package JDBC;

import DAO.PersonalDAO;
import Entity.Personal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.Registro;


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
            rs.close();
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
    public String horarioInicial(Integer idPersonal) {
        String returnData = null;
        String QUERY = "select HoraEntrada from bdproyectomate.area right outer join bdproyectomate.personal ON personal.Area_idArea=area.idArea where personal.idPersonal=?;";
        Personal person = new Personal();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setInt(1, idPersonal);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.last()) {
                returnData = rs.getString("HoraEntrada");
                System.out.print("hora entrada:" + returnData + "\n");
            }
            rs.close();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return returnData;

    }

    @Override
    public String horarioFinal(Integer idPersonal) {
        String returnData = null;
        String horaFinal = null;
        String QUERY = "select HoraSalida from bdproyectomate.area right outer join bdproyectomate.personal ON personal.Area_idArea=area.idArea where personal.idPersonal=?;";
        Personal person = new Personal();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setInt(1, idPersonal);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.last()) {
                returnData = rs.getString("HoraSalida");

            }
            rs.close();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return returnData;

    }

    @Override
    public Boolean registerSalida(Integer idpersonal) {

        String QUERY = "select validacion from registro WHERE Personal_idPersonal=? and validacion=1";
        String idRegistro = "SELECT idRegistro from registro where Personal_idPersonal=? and validacion=1";
        String UPDATE = "UPDATE registro SET validacion=2 WHERE idRegistro=?";
        Boolean existe = false;
        Integer idRegistroNumber = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setInt(1, idpersonal);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.last()) {
                //System.out.print("esto es " +Boolean.parseBoolean(rs.getString("idPersonal")));
                //existe = Boolean.parseBoolean(rs.getString("idPersonal"));
                existe = true;
            }
            rs.close();
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.print("paso por aca");
            System.out.print("LA HORA NO PUEDE SER 24 DE LA NOCHE");
        }
        return existe;

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
            } else {

            }
            rs.close();
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.print("paso por aca");
            e.printStackTrace();
        }
        return existe;
    }

    @Override
    public void registrarSalidad(Integer idpersonal) {
        String idRegistro = "SELECT idRegistro from registro where Personal_idPersonal=? and validacion=1";
        String UPDATE = "UPDATE registro SET validacion=2 WHERE idRegistro=?";
        Integer idRegistroNumber = null;
        try {

            PreparedStatement preparedStatement1 = connection.prepareStatement(idRegistro);
            preparedStatement1.setInt(1, idpersonal);
            ResultSet rs1 = preparedStatement1.executeQuery();
            while (rs1.next()) {
                idRegistroNumber = Integer.parseInt(rs1.getString("idRegistro"));
            }
            System.out.print(idRegistroNumber);
            PreparedStatement preparedStatement2 = connection.prepareStatement(UPDATE);
            preparedStatement2.setInt(1, idRegistroNumber);
            preparedStatement2.executeUpdate();

            rs1.close();
            preparedStatement1.close();

            preparedStatement2.close();

        } catch (SQLException e) {
            System.out.print("paso por aca");
            System.out.print("LA HORA NO PUEDE SER 24 DE LA NOCHE");
        }
    }

    @Override
    public void updateSalida() {
        String Activacion = "SET SQL_SAFE_UPDATES = 0;";
        String UPDATE = "UPDATE registro SET Estado='FALTA, NO REGISTRO SALIDA', validacion=2 WHERE validacion = 1;";
        String Desactivar = "SET SQL_SAFE_UPDATES = 1;";
        try {
            //ACTIVA EL EDITOR
            PreparedStatement preparedStatement = connection.prepareStatement(Activacion);
            preparedStatement.executeUpdate();
            preparedStatement.close();

            PreparedStatement preparedStatement2 = connection.prepareStatement(UPDATE);
            preparedStatement2.executeUpdate();
            preparedStatement2.close();
            
            //DESACTIVA EL EDITOR
            PreparedStatement preparedStatement3 = connection.prepareStatement(Desactivar);
            preparedStatement3.executeUpdate();
            preparedStatement3.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
