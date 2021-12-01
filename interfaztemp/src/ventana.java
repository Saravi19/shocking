
 // @author Nicolas Arroyave
 

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.net.FileNameMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;//importamos la libreria que permite crear la ventana principal
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
public class  ventana extends   JFrame {
    

 public static final int WIDTH = 800, HEIGHT = 600;
 public JPanel panel;
 
   
    
 public  ventana(){//Metodo constructor de la ventana
 
  setTitle("Shocking colorful meteors");//titulo de la ventana
        setSize(WIDTH, HEIGHT);//Llamos las variables de dimension
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //declaramos esta linea para poder cerrar la ventana 
        setResizable(false);//esta linea no deja redimensionar en live 
        setLocationRelativeTo(null);// esto es para que la ventana se vea en la mitad de la pantalla 
        setVisible(true);
        iniciarcomponentes();
        colocaretiquetas();
        botones();
 
 
 }
 
 
 private void iniciarcomponentes(){//este metodo monta el panel sobre la ventana 
      panel = new JPanel();
     panel.setBackground(Color.black);//fondo
     this.getContentPane().add(panel);//agrega el panel
     panel.setLayout(null);
   
 }
 
 private void colocaretiquetas(){
   JLabel etiqueta = new JLabel();//se crea la etiqueta
     JLabel etiqueta2 = new JLabel();
     JLabel etiqueta3 = new JLabel();
     JLabel etiqueta4 = new JLabel();
     
     etiqueta.setBounds(10, 10, 455, 80);
     etiqueta2.setBounds(85, 10, 600, 80);
     etiqueta3.setBounds(85, 10, 760, 80);
     etiqueta4.setBounds(85, 10, 980, 80);
     
    etiqueta.setForeground(Color.WHITE);
    etiqueta2.setForeground(Color.GREEN);
    etiqueta3.setForeground(Color.RED);
    etiqueta4.setForeground(Color.WHITE);
    
    etiqueta.setText("Shocking");
    etiqueta2.setText("color");
    etiqueta3.setText("ful");
    etiqueta4.setText("meteors");
    
    etiqueta.setHorizontalAlignment(SwingConstants.CENTER);//alinea el texto en el centro
    etiqueta2.setHorizontalAlignment(SwingConstants.CENTER);
    etiqueta3.setHorizontalAlignment(SwingConstants.CENTER);
    etiqueta4.setHorizontalAlignment(SwingConstants.CENTER);
    
    
    etiqueta.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,40));
    etiqueta2.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,40));
    etiqueta3.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,40));
    etiqueta4.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,40));//sirve para cambiar el tipo y tamaño de la fuente
     
    
                                                                    
     panel.add(etiqueta);
     panel.add(etiqueta2);
     panel.add(etiqueta3);
     panel.add(etiqueta4);

}
 
 private void botones(){
     JButton boton1 = new JButton();
     JButton boton2 = new JButton();
     
     boton1.setBounds(300, 200, 200, 50);
     boton2.setBounds(300, 290, 200, 40);
     
     
     boton1.setText("Jugar");
     boton2.setText("salir");
     
  
     
    boton1.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,40));
    boton2.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,40));
     
     panel.add(boton1);
     panel.add(boton2);
     
     
     
     
 }
 
 
    
    public static void main(String[] args) {
        
        new ventana();
        
    }
    
}
