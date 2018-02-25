package DAO;


import Entity.Registro;
 
public interface PersonalDAO {
    
  public void insert(Registro registro);   
  public Integer select(Integer dni);
  public void Salida(Registro registro);
  public String horarioInicial();
    
}
