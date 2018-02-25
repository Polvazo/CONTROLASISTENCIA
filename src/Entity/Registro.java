package Entity;

import java.sql.Timestamp;
import java.util.Date;

public class Registro {

    private Integer idRegistro;
    private Timestamp HoraRegistroIn;
    private Timestamp HoraRegistroOut;
    private Integer Personal_idPersonal;
    private String Estado;

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Timestamp getHoraRegistroIn() {
        return HoraRegistroIn;
    }

    public void setHoraRegistroIn(Timestamp HoraRegistroIn) {
        this.HoraRegistroIn = HoraRegistroIn;
    }

    public Timestamp getHoraRegistroOut() {
        return HoraRegistroOut;
    }

    public void setHoraRegistroOut(Timestamp HoraRegistroOut) {
        this.HoraRegistroOut = HoraRegistroOut;
    }

    public Integer getPersonal_idPersonal() {
        return Personal_idPersonal;
    }

    public void setPersonal_idPersonal(Integer Personal_idPersonal) {
        this.Personal_idPersonal = Personal_idPersonal;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    
    
}
