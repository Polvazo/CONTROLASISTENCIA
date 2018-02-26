package DAO;


import Entity.Registro;
import java.util.List;
 
public interface PersonalDAO {
    
  public void insert(Registro registro);   
  public Integer select(Integer dni);
  public void Salida(Registro registro);
  public String horarioInicial();
  public Boolean registerSalida (Integer idpersonal);
  public Boolean userExiste(Integer dni);
    
}
