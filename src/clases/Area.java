package clases;

import java.util.Date;

/**
 *
 * @author HOLA
 */
public class Area {
    private int ID;
    private String Nombre;
    private Date HoraIn;
    private Date HoraOut;

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the HoraIn
     */
    public Date getHoraIn() {
        return HoraIn;
    }

    /**
     * @param HoraIn the HoraIn to set
     */
    public void setHoraIn(Date HoraIn) {
        this.HoraIn = HoraIn;
    }

    /**
     * @return the HoraOut
     */
    public Date getHoraOut() {
        return HoraOut;
    }

    /**
     * @param HoraOut the HoraOut to set
     */
    public void setHoraOut(Date HoraOut) {
        this.HoraOut = HoraOut;
    } 
}
