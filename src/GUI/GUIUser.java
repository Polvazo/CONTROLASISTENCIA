/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import Entity.Registro;
import JDBC.JDBCPersonalDAO;
import java.awt.Color;

import java.awt.event.KeyEvent;
import java.text.DateFormat;

import java.text.SimpleDateFormat;

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
    Date dateActual;
    DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
    DateTimeFormatter df = DateTimeFormat.forPattern("HH:mm:ss");
    DateTime registrarUpdate;
    DateTime compareUpdate;
    JDBCPersonalDAO jdbcPersonDAO = new JDBCPersonalDAO();
    
    public GUIUser() {
        initComponents();
         h1 = new Thread(this);
                setBounds(150, 150, 800, 693);
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
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel3 = new javax.swing.JPanel();
        btn_ingresar = new javax.swing.JButton();
        et_Dni = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lbhora = new javax.swing.JLabel();
        lbFecha = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

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

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(0, 0, 204));

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

        et_Dni.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        et_Dni.setAutoscrolls(false);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(292, Short.MAX_VALUE)
                .addComponent(btn_ingresar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(291, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(et_Dni, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(271, 271, 271))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(et_Dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_ingresar, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FACULTAD DE CIENCIAS MATEMATICAS");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("R E G I S T R O   D E   A S I S T E N C I A");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.setAutoscrolls(true);

        lbhora.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lbhora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbhora.setText("HORARIO");
        lbhora.setInheritsPopupMenu(false);

        lbFecha.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFecha.setText("FECHA");

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/sm3.png"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbFecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbhora, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbhora, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lbFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void et_DniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_et_DniKeyTyped

        char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter)) || et_Dni.getText().length() >= 8) {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_et_DniKeyTyped

    private void et_DniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_et_DniKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            System.out.println("se presiono la tecla Enter");
            Registrar();
        }
    }//GEN-LAST:event_et_DniKeyPressed

    private void et_DniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_et_DniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_et_DniActionPerformed

    private void btn_ingresarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_ingresarKeyPressed

        /* if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            System.out.println("se presiono la tecla Enter");
            Registrar();
        }*/
    }//GEN-LAST:event_btn_ingresarKeyPressed

    private void btn_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ingresarActionPerformed
        Registrar();
    }//GEN-LAST:event_btn_ingresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ingresar;
    private javax.swing.JTextField et_Dni;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
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
        
        
        jdbcPersonDAO.getConnection();
        try {
            
            if (jdbcPersonDAO.userExiste(Integer.parseInt(et_Dni.getText()))) {
                
                if (jdbcPersonDAO.estadoValidacionSalida(jdbcPersonDAO.selectIdPersonal(Integer.parseInt(et_Dni.getText()))) == false) {
                    //Estos son valores null
                    //NO SE ESTA SUBIENDO LOS DATOS  :v  Y ESO ES EL ERROR 
                    System.out.print("Log1:" + jdbcPersonDAO.horarioEntradaTrabajo(Integer.parseInt(et_Dni.getText())));
                    System.out.print("Log2:" + jdbcPersonDAO.horarioTrabajoSalida(Integer.parseInt(et_Dni.getText())));
                    Registro registro = new Registro();
                    String horarioTrabajo = jdbcPersonDAO.horarioEntradaTrabajo(jdbcPersonDAO.selectIdPersonal(Integer.parseInt(et_Dni.getText())));
                    //System.out.print("hora entrada" + jdbcPersonDAO.horarioInicial(4));
                    //DateTime HorarioTra = horarioTrabajo.getHoraEntrada();
                   // DateTimeFormatter df = DateTimeFormat.forPattern("HH:mm:ss");
                    //String horaTrabajo = "08:00:00"; //hora de entrada

                    //String tolerancia = "08:15:00"; //hora de torelancia
                    dateActual = new Date();
                    Date dateActual2, toleranciaDate;
                   // DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss"); //hora actual
                    //dateActual = hourFormat.parse(horaTrabajo);
                    //toleranciaDate = hourFormat.parse(tolerancia);
                    String horaActual = hourFormat.format(dateActual);
                    //dateActual2 = hourFormat.parse(horaActual);

                    DateTime horaTrabajo = df.parseLocalTime(horarioTrabajo).toDateTimeToday();
                    DateTime Tolerancia = df.parseLocalTime(horarioTrabajo).toDateTimeToday().plusHours(1);
                    
                    System.out.println(horaTrabajo);
                    
                    System.out.println(jdbcPersonDAO.estadoValidacionSalida(Integer.parseInt(et_Dni.getText())));
                    
                    DateTime actual = df.parseLocalTime(horaActual).toDateTimeToday();
                    System.out.println(Tolerancia);
                    System.out.println(actual);
                    
                    Calendar calendar = Calendar.getInstance();
                    System.out.println(calendar.getTime().getTime());
                    java.sql.Timestamp nuestroJavaTimestampObject = new java.sql.Timestamp(calendar.getTime().getTime());
                    registro.setHoraRegistroIn(nuestroJavaTimestampObject);
                    registro.setPersonal_idPersonal(jdbcPersonDAO.selectIdPersonal(Integer.parseInt(et_Dni.getText())));
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
                            new  rojerusan.RSNotifyFade("FALTA", "Se registró su falta",Color.white, Color.black, Color.black,1,RSNotifyFade.PositionNotify.BottomRight,RSNotifyFade.TypeNotify.WARNING).setVisible(true);
                            System.out.println("FALTA");
                            registro.setEstado("FALTA");
                        }
                    }
                    
                    jdbcPersonDAO.insertRegistro(registro);
                    jdbcPersonDAO.closeConnection();
                    et_Dni.setText("");
                } else {
                    //VALIDAD LA HORA DE SALIDA
                    System.out.print("Se marco la hora de salida");
                    String horarioTrabajSalidad = jdbcPersonDAO.horarioTrabajoSalida(jdbcPersonDAO.selectIdPersonal(Integer.parseInt(et_Dni.getText())));
                    //DateTimeFormatter df = DateTimeFormat.forPattern("HH:mm:ss");
                    DateTime horaTrabajo = df.parseLocalTime(horarioTrabajSalidad).toDateTimeToday();
                    
                    Date dateActual = new Date();
                    //DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss"); //hora actual
                    String horaActual = hourFormat.format(dateActual);
                    //la hora de tolerancia con un plus de 15 minutos
                    DateTime actual = df.parseLocalTime(horaActual).toDateTimeToday().plusMinutes(15);
                    
                    if (actual.isBefore(horaTrabajo)) {
                        System.out.print("no se puede firmar");
                        new  rojerusan.RSNotifyFade("ADVERTENCIA", "No puede registrar su salida antes de la hora, por favor"
                                + " intentelo mas tarde.",Color.white, Color.black, Color.black,1,RSNotifyFade.PositionNotify.BottomRight,RSNotifyFade.TypeNotify.INFORMATION).setVisible(true);
                    } else {
                        jdbcPersonDAO.registrarSalidad(jdbcPersonDAO.selectIdPersonal(Integer.parseInt(et_Dni.getText())));
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
        String horaUpdate="22:40:00"; // la hora en la que actualiza el sistema
        registrarUpdate = df.parseLocalTime(horaUpdate).toDateTimeToday();
        String horaHilo;
        
        while (ct == h1) {
            Calcular();
            //CALCULAR LA HORA
            horaHilo =hora + ":" + minutos + ":" + segundos;
            
           compareUpdate = df.parseLocalTime(horaHilo).toDateTimeToday();
           if(registrarUpdate.isEqual(compareUpdate)){
               jdbcPersonDAO.getConnection();
               jdbcPersonDAO.updateSalida();
           System.out.print("excelente");    
           }
            
            //System.out.print(hora + ":" + minutos + ":" + segundos + " ");
            lbhora.setText(hora + ":" + minutos + ":" + segundos + " " + amp);
            lbFecha.setText(day + "-" + mes + "-" + year);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            
        }
    }
    
}
