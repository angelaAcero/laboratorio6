/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio6;


import java.awt.Image;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author amace
 */
public class Carro implements Comparable <Carro>{
    
    private long tiempoInicio;
    private long tiempoFinal;
    private String nombre;
    private float limite;
    private JLabel etiqueta;
    private float tiempof;
    private String ruta;
    private int posicionX;
    private int velocidad;
    
    
    public Carro(String ruta, String nombre, float limite, JLabel etiqueta,float tiempof, int velocidad)
    {
        this.nombre= nombre;
        this.etiqueta = etiqueta;
        this.limite = limite;
        this.tiempof = tiempof;
        this.ruta = ruta;
        this.velocidad= velocidad;
        tiempoInicio = 0;
        
        ImageIcon imagenCarro = new ImageIcon(ruta);
        Icon Iconocarro = new ImageIcon(imagenCarro.getImage().getScaledInstance(etiqueta.getWidth(), etiqueta.getHeight(), Image.SCALE_DEFAULT));
        etiqueta.setIcon(Iconocarro);
        etiqueta.repaint();
        
    }
    
    public JLabel getlabel ()
    {
        return etiqueta;
    }
    
    public void setTiempoInicio(long tiempoInicio)
    {
        this.tiempoInicio = tiempoInicio;
    }
     public float setTiempoFinal(float tiempof)
    {
        this.tiempof = tiempof;
        return tiempof;
    }


    public long getTiempo() 
    {
       long resta= (tiempoFinal - tiempoInicio);
        
        return resta;
    }

    public String getNombre() 
    {
        return nombre;
    }
    
    public boolean finalizo()
    {
        return etiqueta.getLocation().x >= limite;
        
    }
    
    public void correr() 
    {

        int r = (int) (Math.random()*50) + 1;
        etiqueta.setLocation(etiqueta.getLocation().x+r, etiqueta.getLocation().y); 
        tiempoFinal = System.currentTimeMillis();

        if(finalizo())
        {
            etiqueta.setLocation((int)limite, etiqueta.getLocation().y); 
            this.tiempof = getTiempo();
        }
         
    }
    
    public int posicion ()
    {
        posicionX = etiqueta.getLocation().x;
        
        return posicionX;
    }
   
    
    public void reiniciar()
    {
        etiqueta.setLocation(100, etiqueta.getLocation().y);
    }

    public float limite()
    {
        return limite;
    }

    public String getRuta()
    {
        
        return ruta;
          
    }

    @Override
    public String toString() {
        return "    " + nombre +  "     " + tiempof ;
    }
   
    
    
    
    
    @Override
    public int compareTo(Carro b) {
        
         int resultado = 0; 
        if(this.tiempof> b.tiempof)
        {

            resultado = 1;
        }
        else if (this.tiempof < b.tiempof)
        {
            resultado = -1;

        }
            
       return resultado;
    }
    

}
