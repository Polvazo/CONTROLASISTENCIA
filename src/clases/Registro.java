package clases;

import java.util.Date;

public class Registro {

    private String id;
    private int horaregistroentrada;
    private int horaregistrosalida;
    private boolean estado;

    public Registro() {
    }

    public Registro(String id, int horaregistroentrada, int horaregistrosalida, boolean estado) {
        this.id = id;
        this.horaregistroentrada = horaregistroentrada;
        this.horaregistrosalida = horaregistrosalida;
        this.estado = estado;
    }
    
    
    void tardaza(){
        if(horaregistroentrada>=8){
            estado=false;
            System.out.println("Usted ha llegado tarde");
        }else{
            estado=true;
            System.out.println("Usted ha llegado temprano");
        }
    }

    
    
}
