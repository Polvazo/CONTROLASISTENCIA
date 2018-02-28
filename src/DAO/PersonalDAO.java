package DAO;



import Entity.Registro;

 
public interface PersonalDAO {
    
  public void insert(Registro registro);   
  public Integer select(Integer dni);
  public void Salida(Registro registro);
  public String horarioInicial(Integer idPersonal);
  public String horarioFinal(Integer idPersonal);
  public Boolean registerSalida (Integer idpersonal);
  public Boolean userExiste(Integer dni);
  public void registrarSalidad(Integer idpersonal);
  public void updateSalida();
    
}
