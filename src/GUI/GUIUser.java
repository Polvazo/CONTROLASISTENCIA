/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Area;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import Entity.Registro;
import JDBC.JDBCPersonalDAO;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import rojerusan.RSNotifyFade;

/**
 *
 * @author HOLA
 */
public class GUIUser extends javax.swing.JFrame implements Runnable {

    /**
     * Creates new form GUIUser
     */
    String hora, minutos, segundos, amp, capturar;
    Integer day, mes, year;
    Calendar calendario;
    Thread h1;
    
    public GUIUser() {
        initComponents();
        h1 = new Thread(this);
        h1.start();
        setLocationRelativeTo(null);//para centrar la ventana
        setVisible(true);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btn_ingresar = new javax.swing.JButton();
        et_Dni = new javax.swing.JTextField();
        lbhora = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbFecha = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btn_ingresar.setText("Ingresar");
        btn_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ingresarActionPerformed(evt);
            }
        });
        btn_ingresar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_ingresarKeyPressed(evt);
            }
        });

        et_Dni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                et_DniActionPerformed(evt);
            }
        });
        et_Dni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                et_DniKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                et_DniKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(et_Dni, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_ingresar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(190, 190, 190))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(et_Dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_ingresar)
                .addGap(18, 18, 18))
        );

        lbhora.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lbhora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbhora.setText("HORARIO");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Universidad Nacional Mayor de San Marcos");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(135, 135, 135))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(43, 43, 43))
        );

        lbFecha.setText("FECHA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbhora, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lbFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(238, 238, 238))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbhora, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void et_DniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_et_DniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_et_DniActionPerformed

    private void btn_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ingresarActionPerformed
        Registrar();

    }//GEN-LAST:event_btn_ingresarActionPerformed

    private void et_DniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_et_DniKeyTyped
        
        char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter)) || et_Dni.getText().length() >= 8) {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_et_DniKeyTyped

    private void btn_ingresarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_ingresarKeyPressed

        /* if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            System.out.println("se presiono la tecla Enter");
            Registrar();
        }*/
    }//GEN-LAST:event_btn_ingresarKeyPressed

    private void et_DniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_et_DniKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            System.out.println("se presiono la tecla Enter");
            Registrar();
        }
    }//GEN-LAST:event_et_DniKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ingresar;
    private javax.swing.JTextField et_Dni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbhora;
    // End of variables declaration//GEN-END:variables

    public boolean evaluarLimite(Date date1, Date date2) {
        boolean correcto = false;
        long diferencia = (Math.abs(date1.getTime() - date2.getTime())) / 1000;
        long limit = (60 * 1000) / 1000L;//limite de tiempo

        if (diferencia <= limit) {
            correcto = true;
        }
        return correcto;
    }
    
    public void Registrar() {
        
        JDBCPersonalDAO jdbcPersonDAO = new JDBCPersonalDAO();
        jdbcPersonDAO.getConnection();
        try {
            
            if (jdbcPersonDAO.userExiste(Integer.parseInt(et_Dni.getText()))) {
                
                if (jdbcPersonDAO.registerSalida(jdbcPersonDAO.select(Integer.parseInt(et_Dni.getText()))) == false) {
                    //Estos son valores null
                    //NO SE ESTA SUBIENDO LOS DATOS  :v  Y ESO ES EL ERROR 
                    System.out.print("Log1:" + jdbcPersonDAO.horarioInicial(Integer.parseInt(et_Dni.getText())));
                    System.out.print("Log2:" + jdbcPersonDAO.horarioFinal(Integer.parseInt(et_Dni.getText())));
                    Registro registro = new Registro();
                    String horarioTrabajo = jdbcPersonDAO.horarioInicial(jdbcPersonDAO.select(Integer.parseInt(et_Dni.getText())));
                    //System.out.print("hora entrada" + jdbcPersonDAO.horarioInicial(4));
                    //DateTime HorarioTra = horarioTrabajo.getHoraEntrada();
                    DateTimeFormatter df = DateTimeFormat.forPattern("HH:mm:ss");
                    //String horaTrabajo = "08:00:00"; //hora de entrada

                    //String tolerancia = "08:15:00"; //hora de torelancia
                    Date dateActual = new Date();
                    Date dateActual2, toleranciaDate;
                    DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss"); //hora actual
                    //dateActual = hourFormat.parse(horaTrabajo);
                    //toleranciaDate = hourFormat.parse(tolerancia);
                    String horaActual = hourFormat.format(dateActual);
                    //dateActual2 = hourFormat.parse(horaActual);

                    DateTime horaTrabajo = df.parseLocalTime(horarioTrabajo).toDateTimeToday();
                    DateTime Tolerancia = df.parseLocalTime(horarioTrabajo).toDateTimeToday().plusHours(1);
                    
                    System.out.println(horaTrabajo);
                    
                    System.out.println(jdbcPersonDAO.registerSalida(Integer.parseInt(et_Dni.getText())));
                    
                    DateTime actual = df.parseLocalTime(horaActual).toDateTimeToday();
                    System.out.println(Tolerancia);
                    System.out.println(actual);
                    
                    Calendar calendar = Calendar.getInstance();
                    System.out.println(calendar.getTime().getTime());
                    java.sql.Timestamp nuestroJavaTimestampObject = new java.sql.Timestamp(calendar.getTime().getTime());
                    registro.setHoraRegistroIn(nuestroJavaTimestampObject);
                    registro.setPersonal_idPersonal(jdbcPersonDAO.select(Integer.parseInt(et_Dni.getText())));
                    if (actual.isBefore(horaTrabajo)) {
                        System.out.println("Llego temprano");
                        new  rojerusan.RSNotifyFade("TEMPRANO", "Se registró su ingreso",Color.white, Color.black, Color.black,1,RSNotifyFade.PositionNotify.BottomRight,RSNotifyFade.TypeNotify.SUCCESS).setVisible(true);
                        registro.setEstado("ASISTIÓ");
                    } else {
                        if (!actual.isBefore(horaTrabajo) && actual.isBefore(Tolerancia)) {
                            new  rojerusan.RSNotifyFade("TARDANZA", "Se registró con tardanza",Color.white, Color.black, Color.black,1,RSNotifyFade.PositionNotify.BottomRight,RSNotifyFade.TypeNotify.WARNING).setVisible(true);
                            System.out.println("Tardanza");
                            registro.setEstado("TARDANZA");
                        } else {
                            new  rojerusan.RSNotifyFade("FALTA", "Se registró su falta",Color.white, Color.black, Color.black,1,RSNotifyFade.PositionNotify.BottomRight,RSNotifyFade.TypeNotify.ERROR).setVisible(true);
                            System.out.println("FALTA");
                            registro.setEstado("FALTA");
                        }
                    }
                    
                    jdbcPersonDAO.insert(registro);
                    jdbcPersonDAO.closeConnection();
                    et_Dni.setText("");
                } else {
                    //VALIDAD LA HORA DE SALIDA
                    System.out.print("Se marco la hora de salida");
                    String horarioTrabajSalidad = jdbcPersonDAO.horarioFinal(jdbcPersonDAO.select(Integer.parseInt(et_Dni.getText())));
                    DateTimeFormatter df = DateTimeFormat.forPattern("HH:mm:ss");
                    DateTime horaTrabajo = df.parseLocalTime(horarioTrabajSalidad).toDateTimeToday();
                    
                    Date dateActual = new Date();
                    DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss"); //hora actual
                    String horaActual = hourFormat.format(dateActual);
                    DateTime actual = df.parseLocalTime(horaActual).toDateTimeToday();
                    
                    if (actual.isBefore(horaTrabajo)) {
                        System.out.print("no se puede firmar");
                        new  rojerusan.RSNotifyFade("ADVERTENCIA", "No puede registrar su salida antes de la hora, por favor"
                                + " intentelo mas tarde.",Color.white, Color.black, Color.black,1,RSNotifyFade.PositionNotify.BottomRight,RSNotifyFade.TypeNotify.INFORMATION).setVisible(true);
                    } else {
                        jdbcPersonDAO.registrarSalidad(jdbcPersonDAO.select(Integer.parseInt(et_Dni.getText())));
                        new  rojerusan.RSNotifyFade("REGISTRO DE SALIDA", "Se registró su salida",Color.white, Color.black, Color.black,1,RSNotifyFade.PositionNotify.BottomRight,RSNotifyFade.TypeNotify.SUCCESS).setVisible(true);
                    }
                    
                    et_Dni.setText("");
                }
                
            } else {
                
                System.out.println("no existe");
                if (et_Dni.getText().length() <= 8) {
                    new  rojerusan.RSNotifyFade("ERROR", "Ingrese DNI correcto",Color.white, Color.black, Color.black,1,RSNotifyFade.PositionNotify.BottomRight,RSNotifyFade.TypeNotify.ERROR).setVisible(true);
                    System.out.println("ingresar DNI correcto");
                }
                et_Dni.setText("");
                jdbcPersonDAO.closeConnection();
            }
            
        } catch (Exception e) {
        }
        
    }
    
    public void Calcular() {
        Calendar calendario = new GregorianCalendar();
        Date horaActual = new Date();
        
        calendario.setTime(horaActual);
        amp = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
        if (amp.equals("PM")) {
            int h = calendario.get(Calendar.HOUR_OF_DAY);
            hora = h > 9 ? "" + h : "0" + h;
        } else {
            hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY);
        }
        minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);
        
        day = calendario.get(Calendar.DAY_OF_MONTH);
        mes = calendario.get(Calendar.MONTH);
        year = calendario.get(Calendar.YEAR);
    }
    
    public void run() {
        Thread ct = Thread.currentThread();
        while (ct == h1) {
            Calcular();
            lbhora.setText(hora + ":" + minutos + ":" + segundos + " " + amp);
            lbFecha.setText(day + "-" + mes + "-" + year);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            
        }
    }
    
}
