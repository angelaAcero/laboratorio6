/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package laboratorio6;

import java.awt.Graphics;
import java.awt.Image;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amace
 */
public class CARRERA extends javax.swing.JFrame {

    Timer temporizador = new Timer();
    Carro[] corredores = new Carro[10];
    int velocidad = 1;
    int limite;

    fondopanel fondant = new fondopanel();

    ArrayList<Carro> listaDeCorredores = new ArrayList();

    /**
     * Creates new form CARRERA
     */
    public CARRERA() {

        this.setContentPane(fondant);
        initComponents();
        titulo.setVisible(false);
        encabezado.setVisible(false);
        palyer1.setVisible(false);
        palyer2.setVisible(false);
        palyer3.setVisible(false);
        palyer4.setVisible(false);
        palyer5.setVisible(false);
        palyer6.setVisible(false);
        palyer7.setVisible(false);
        palyer8.setVisible(false);
        palyer9.setVisible(false);
        palyer11.setVisible(false);
        GANADOR.setVisible(false);

        limite = meta.getLocation().x + meta.getWidth();

        corredores[0] = new Carro("src/imagen/carro0.png", "Rayo", limite, rayo, 0, velocidad);
        corredores[1] = new Carro("src/imagen/carro1.png", "Cruz", limite, cruz, 0, velocidad);
        corredores[2] = new Carro("src/imagen/carro2.png", "Los Picapiedra", limite, lospicapierda, 0, velocidad);
        corredores[3] = new Carro("src/imagen/carro3.png", "Francesco", limite, francesco, 0, velocidad);
        corredores[4] = new Carro("src/imagen/carro5.png", "La Maquina Del Misterio", limite, LaMisteryMachine, 0, velocidad);
        corredores[5] = new Carro("src/imagen/carro6.png", "Delorian", limite, Delorian, 0, velocidad);
        corredores[6] = new Carro("src/imagen/carro7.png", "Herbie", limite, Herbie, 0, velocidad);
        corredores[7] = new Carro("src/imagen/carro4.png", "Sally", limite, Sally, 0, velocidad);
        corredores[8] = new Carro("src/imagen/carro8.png", "Barbie", limite, Barbie, 0, velocidad);
        corredores[9] = new Carro("src/imagen/carro9.png", "Mate", limite, Mate, 0, velocidad);

    }

    public void correr1() {
        
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < corredores.length; i++)
        {
            corredores[i].setTiempoInicio(startTime);
        }
        Thread t = new Thread() {
            @Override
            public void run() {

                int finalistas = 0;
                int k = 0;
                while (finalistas <= corredores.length-1) 
                {
                   finalistas = 0;
                    for (int i = 0; i < corredores.length; i++) 
                    {
                        if (!corredores[i].finalizo()) 
                        {
                            corredores[i].correr();
                        }
                        else 
                        {
                            finalistas++;
                        }
                    }
                    
                    try {
                        Thread.sleep(101-velocidad);
                        } 
                    catch (InterruptedException ex) {
                            
                            Logger.getLogger(CARRERA.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }
                
                if (finalistas == corredores.length)
                {
                   ordenar();   
                }
            }
        };
        t.start();
    }

    public void agregarCorredores(Carro carrito) {
        this.listaDeCorredores.add(carrito);

    }

    public void ListarCorredores() {
        for (Carro motores : listaDeCorredores) {
            System.out.println(motores);
        }
    }

    public void ordenar() {

        for (int q = 0; q < corredores.length; q++) {

            agregarCorredores(corredores[q]);
        }
        Collections.sort(listaDeCorredores);

        //ListarCorredores();
        titulo.setVisible(true);
        encabezado.setVisible(true);
        palyer1.setVisible(true);
        palyer2.setVisible(true);
        palyer3.setVisible(true);
        palyer4.setVisible(true);
        palyer5.setVisible(true);
        palyer6.setVisible(true);
        palyer7.setVisible(true);
        palyer8.setVisible(true);
        palyer9.setVisible(true);
        palyer11.setVisible(true);

        palyer1.setText(palyer1.getText() + listaDeCorredores.get(0).getNombre() + "     " + listaDeCorredores.get(0).getTiempo());
        palyer2.setText(palyer2.getText() + listaDeCorredores.get(1).getNombre() + "     " + listaDeCorredores.get(1).getTiempo());
        palyer3.setText(palyer3.getText() + listaDeCorredores.get(2).getNombre() + "     " + listaDeCorredores.get(2).getTiempo());
        palyer4.setText(palyer4.getText() + listaDeCorredores.get(3).getNombre() + "     " + listaDeCorredores.get(3).getTiempo());
        palyer5.setText(palyer5.getText() + listaDeCorredores.get(4).getNombre() + "     " + listaDeCorredores.get(4).getTiempo());
        palyer6.setText(palyer6.getText() + listaDeCorredores.get(5).getNombre() + "     " + listaDeCorredores.get(5).getTiempo());
        palyer7.setText(palyer7.getText() + listaDeCorredores.get(6).getNombre() + "     " + listaDeCorredores.get(6).getTiempo());
        palyer8.setText(palyer8.getText() + listaDeCorredores.get(7).getNombre() + "     " + listaDeCorredores.get(7).getTiempo());
        palyer9.setText(palyer9.getText() + listaDeCorredores.get(8).getNombre() + "     " + listaDeCorredores.get(8).getTiempo());
        palyer11.setText(palyer11.getText() + listaDeCorredores.get(9).getNombre() + "     " + listaDeCorredores.get(9).getTiempo());

        apostar();

    }

    public void apostar() {

        if (contador.getText().isEmpty()) {
            contador.setText("0");
        }
        if (apostador.getText().isEmpty()) {
            apostador.setText("0");
        }

        if (elejidor.getSelectedItem().equals(listaDeCorredores.get(0).getNombre())) {
            float Numero1 = Float.parseFloat(contador.getText());
            float Numero2 = Float.parseFloat(apostador.getText());

            float total = Numero1 + Numero2;

            contador.setText(String.valueOf(total));
            GANADOR.setVisible(true);
        } else {
            float Numero1 = Float.parseFloat(contador.getText());
            float Numero2 = Float.parseFloat(apostador.getText());
            float total = Numero1 - Numero2;
            contador.setText(String.valueOf(total));
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        palyer10 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lospicapierda = new javax.swing.JLabel();
        meta = new javax.swing.JLabel();
        rayo = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        palyer1 = new javax.swing.JTextField();
        palyer2 = new javax.swing.JTextField();
        palyer3 = new javax.swing.JTextField();
        palyer4 = new javax.swing.JTextField();
        palyer5 = new javax.swing.JTextField();
        palyer6 = new javax.swing.JTextField();
        palyer7 = new javax.swing.JTextField();
        palyer8 = new javax.swing.JTextField();
        palyer9 = new javax.swing.JTextField();
        palyer11 = new javax.swing.JTextField();
        cruz = new javax.swing.JLabel();
        francesco = new javax.swing.JLabel();
        Herbie = new javax.swing.JLabel();
        Sally = new javax.swing.JLabel();
        Delorian = new javax.swing.JLabel();
        LaMisteryMachine = new javax.swing.JLabel();
        encabezado = new javax.swing.JLabel();
        elejidor = new javax.swing.JComboBox<>();
        apostador = new javax.swing.JTextField();
        contador = new javax.swing.JTextField();
        Barbie = new javax.swing.JLabel();
        Mate = new javax.swing.JLabel();
        GANADOR = new javax.swing.JLabel();

        palyer10.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jButton1.setText("INICIO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        meta.setBackground(new java.awt.Color(51, 255, 204));
        meta.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 102, 102))); // NOI18N

        jSlider1.setMinimum(1);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        jLabel1.setText("Velocidad");

        jButton2.setText("Reiniciar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Apuestas");

        jLabel3.setText("Cuenta");

        titulo.setBackground(new java.awt.Color(255, 255, 255));
        titulo.setFont(new java.awt.Font("SWTxt", 1, 18)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("CLASIFICACION");
        titulo.setAlignmentX(0.5F);
        titulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titulo.setOpaque(true);

        palyer1.setBackground(new java.awt.Color(204, 255, 255));
        palyer1.setFont(new java.awt.Font("SWTxt", 1, 14)); // NOI18N
        palyer1.setText("1    ");
        palyer1.setOpaque(true);
        palyer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                palyer1ActionPerformed(evt);
            }
        });

        palyer2.setBackground(new java.awt.Color(204, 255, 204));
        palyer2.setFont(new java.awt.Font("SWTxt", 1, 14)); // NOI18N
        palyer2.setText("2    ");
        palyer2.setOpaque(true);

        palyer3.setBackground(new java.awt.Color(204, 255, 204));
        palyer3.setFont(new java.awt.Font("SWTxt", 1, 14)); // NOI18N
        palyer3.setText("3    ");
        palyer3.setOpaque(true);

        palyer4.setBackground(new java.awt.Color(204, 255, 204));
        palyer4.setFont(new java.awt.Font("SWTxt", 1, 14)); // NOI18N
        palyer4.setText("4    ");
        palyer4.setOpaque(true);

        palyer5.setBackground(new java.awt.Color(255, 255, 204));
        palyer5.setFont(new java.awt.Font("SWTxt", 1, 14)); // NOI18N
        palyer5.setText("5    ");
        palyer5.setOpaque(true);

        palyer6.setBackground(new java.awt.Color(255, 255, 204));
        palyer6.setFont(new java.awt.Font("SWTxt", 1, 14)); // NOI18N
        palyer6.setText("6    ");
        palyer6.setOpaque(true);

        palyer7.setBackground(new java.awt.Color(255, 255, 204));
        palyer7.setFont(new java.awt.Font("SWTxt", 1, 14)); // NOI18N
        palyer7.setText("7    ");
        palyer7.setOpaque(true);

        palyer8.setBackground(new java.awt.Color(255, 204, 204));
        palyer8.setFont(new java.awt.Font("SWTxt", 1, 14)); // NOI18N
        palyer8.setText("8    ");
        palyer8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                palyer8ActionPerformed(evt);
            }
        });

        palyer9.setBackground(new java.awt.Color(255, 204, 204));
        palyer9.setFont(new java.awt.Font("SWTxt", 1, 14)); // NOI18N
        palyer9.setText("9    ");
        palyer9.setOpaque(true);

        palyer11.setBackground(new java.awt.Color(255, 204, 204));
        palyer11.setFont(new java.awt.Font("SWTxt", 1, 14)); // NOI18N
        palyer11.setText("10    ");
        palyer11.setOpaque(true);
        palyer11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                palyer11ActionPerformed(evt);
            }
        });

        encabezado.setBackground(new java.awt.Color(255, 255, 255));
        encabezado.setFont(new java.awt.Font("SWTxt", 1, 18)); // NOI18N
        encabezado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        encabezado.setText("N°    CARRO      TIEMPO(MS)");
        encabezado.setAlignmentX(0.5F);
        encabezado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        encabezado.setOpaque(true);

        elejidor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rayo", "Cruz", "Los Picapierda", "Francesco", "La Maquina Del Misterio", "Delorean", "Herbie", "Sally", "Barbie", "Mate", " " }));

        apostador.setText("0");

        contador.setText("0");

        GANADOR.setBackground(new java.awt.Color(0, 204, 204));
        GANADOR.setFont(new java.awt.Font("SWTxt", 1, 14)); // NOI18N
        GANADOR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GANADOR.setText("GANASTE");
        GANADOR.setToolTipText("");
        GANADOR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        GANADOR.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Barbie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Sally, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                            .addComponent(Herbie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Delorian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LaMisteryMachine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(francesco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lospicapierda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cruz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rayo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(167, 167, 167)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(palyer1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(palyer2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                            .addComponent(palyer3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(palyer4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(palyer5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(palyer6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(palyer7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(palyer9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(palyer11, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(encabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(titulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(palyer8, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addComponent(Mate, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addComponent(meta, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(apostador)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(elejidor, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(contador)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(GANADOR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(apostador, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(elejidor, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(contador, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(GANADOR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(53, 53, 53))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rayo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(cruz, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lospicapierda, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(francesco, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LaMisteryMachine, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Delorian, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Herbie, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Sally, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Barbie, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(Mate, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(meta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(encabezado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(palyer1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(palyer2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(palyer3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(palyer4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(palyer5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(palyer6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(palyer7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(palyer8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(palyer9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(palyer11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        meta.getAccessibleContext().setAccessibleName("arroz con huevo");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        correr1();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        velocidad = jSlider1.getValue();
    }//GEN-LAST:event_jSlider1StateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        for (int i = 0; i < corredores.length; i++) {
            corredores[i].reiniciar();

        }
        titulo.setVisible(false);
        encabezado.setVisible(false);
        palyer1.setVisible(false);
        palyer2.setVisible(false);
        palyer3.setVisible(false);
        palyer4.setVisible(false);
        palyer5.setVisible(false);
        palyer6.setVisible(false);
        palyer7.setVisible(false);
        palyer8.setVisible(false);
        palyer9.setVisible(false);
        palyer11.setVisible(false);
        GANADOR.setVisible(false);
        palyer1.setText(" 1         ");
        palyer2.setText(" 2         ");
        palyer3.setText(" 3         ");
        palyer4.setText(" 4         ");
        palyer5.setText(" 5         ");
        palyer6.setText(" 6         ");
        palyer7.setText(" 7         ");
        palyer8.setText(" 8         ");
        palyer9.setText(" 9         ");
        palyer11.setText(" 10         ");

        listaDeCorredores.clear();


    }//GEN-LAST:event_jButton2ActionPerformed

    private void palyer8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_palyer8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_palyer8ActionPerformed

    private void palyer11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_palyer11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_palyer11ActionPerformed

    private void palyer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_palyer1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_palyer1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CARRERA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CARRERA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CARRERA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CARRERA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CARRERA().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Barbie;
    private javax.swing.JLabel Delorian;
    private javax.swing.JLabel GANADOR;
    private javax.swing.JLabel Herbie;
    private javax.swing.JLabel LaMisteryMachine;
    private javax.swing.JLabel Mate;
    private javax.swing.JLabel Sally;
    private javax.swing.JTextField apostador;
    private javax.swing.JTextField contador;
    private javax.swing.JLabel cruz;
    private javax.swing.JComboBox<String> elejidor;
    private javax.swing.JLabel encabezado;
    private javax.swing.JLabel francesco;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JLabel lospicapierda;
    private javax.swing.JLabel meta;
    private javax.swing.JTextField palyer1;
    private javax.swing.JTextField palyer10;
    private javax.swing.JTextField palyer11;
    private javax.swing.JTextField palyer2;
    private javax.swing.JTextField palyer3;
    private javax.swing.JTextField palyer4;
    private javax.swing.JTextField palyer5;
    private javax.swing.JTextField palyer6;
    private javax.swing.JTextField palyer7;
    private javax.swing.JTextField palyer8;
    private javax.swing.JTextField palyer9;
    private javax.swing.JLabel rayo;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables

    class fondopanel extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/imagen/fondoPistav2.png")).getImage();

            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

            setOpaque(false);

            super.paint(g);

        }

    }

}
