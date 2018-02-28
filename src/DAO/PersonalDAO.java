package DAO;



import Entity.Registro;

 
public interface PersonalDAO {
    
  public void insertRegistro(Registro registro);   
  public Integer selectIdPersonal(Integer dni);
  public String horarioEntradaTrabajo(Integer idPersonal);
  public String horarioTrabajoSalida(Integer idPersonal);
  public Boolean estadoValidacionSalida (Integer idpersonal);
  public Boolean userExiste(Integer dni);
  public void registrarSalidad(Integer idpersonal);
  public void updateSalida();
    
}
