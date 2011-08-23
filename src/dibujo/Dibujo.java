/**
 * Dibujo.java
 *
 * @author Manuel Moreno Urcid	A01098039
 * @author Jos√© Rodrigo P√©rez Rodr√≠guez	A01094275
 * @author Jesus Flores Galindo	A01098108
 *
 * Este programa consiste en la creaci√≥n de un gradiente utilizando las
 * herramientas de Java 2D. Para ello se crea un JFrame que debe pintarse de
 * rojo en su esquina superior izquierda, de verde en su esquina superior
 * derecha, de azul en su esquina inferior izquierda y de negro en la esquina
 * restante. Todos los colores deben degradarse y combinarse.
 *
 */

package dibujo;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class Dibujo extends JApplet {

    final static Color bg = Color.black;
    final static Color fg = Color.white;
    
    
    /**
     * Constructor por default.
     */
    public Dibujo(){
        
       
    }
    
    
    /**
     * Esta función inicializa los colores de background y foreground.
     */
    public void init() {
        //Initialize drawing colors
        setBackground(bg);
        setForeground(fg);
    }
    
    /**
     * Esta función pinta a la casa como poligono.
     * @param g2 Area que se utilizará para pintar la casa.
     * @see fillPolygon()
     */
    static void paintHouse(Graphics2D g2){
        //Poligono de la casa
        int casax[] = {100,100,105,105,115,115,120,120,110,160,170,170,120,120,110};
	int casay[] = {200,220,220,210,210,220,220,200,190,190,200,220,220,200,190};
	g2.setColor(new Color(255,0,0));
	g2.fillPolygon(casax,casay,15);
        
        //Poligono de la puerta
        int puertax[] = {105,105,115,115};
        int puertay[] = {220,210,210,220};
        g2.setColor(new Color(139,69,19));
        g2.fillPolygon(puertax,puertay,4);
        
        //Ventana circular
        g2.setColor(new Color(30,144,255));
        g2.fillOval(105,195,10,10);
    }
    
    /**
     * Esta función pinta el sol utilizando Arcos.
     * @param g2 Area que se utilizará para pintar el sol.
     */
    static void paintSun(Graphics2D g2){
        g2.setColor(new Color(255,255,0));
        g2.fillArc(-30, -30, 60, 60, 0, -90);

        int a=255;
        for (int j=1; j<40; j++){
            g2.setColor(new Color(255,255,0,a-(j*6)));
            g2.drawArc(-30-j,-30-j,60+j+j,60+j+j,0,-90);
         }
        
    }
    
    /**
     * Esta función utiliza randoms para pintar nubes en posiciones y de tamaños aleatorios. Juega con las opacidades con randoms.
     * @param g2 Area que se utilizará para pintar el sol.
     */
    static void paintCloud(Graphics2D g2){
        Random rand = new Random();
        int opacidad = rand.nextInt(100);
        g2.setColor(new Color(255,255,255,opacidad));
        int x = rand.nextInt(250);
        int y = rand.nextInt(110);
        int width = 20 + rand.nextInt(15);
        int length = 19 + rand.nextInt(10);
        System.out.println("x = "+x);
        System.out.println("y = "+y);
        System.out.println("w = "+width);
        System.out.println("L = "+length);
        g2.fillOval(x,y,width,length);
        
        for(int i=0;i<(10+(rand.nextInt(10)));i++){
            g2.fillOval(x+(rand.nextInt(width)),y+(rand.nextInt(length)),width,length);
        }
    }
    
    /**
     * Esta función utiliza randoms para pintar triángulos de width y height random para generar la apariencia del pasto.
     * @param g2 Area que se utilizará para pintar el sol.
     */
    static void paintGrass(Graphics2D g2){
        g2.setColor(new Color(0,255,0));
        Random rand = new Random();
        int width = 0;
        int height = 0;
        int pos = 0;
        int[] xs = new int[3];
        int[] ys = new int[3];
        for(int i=0;i<200;i++){
            width = 1 + rand.nextInt(7);
            height = 1 + rand.nextInt(7);
            xs[0] = pos;
            ys[0] = 200;
            xs[1] = pos + (width/2);
            ys[1] = 200 - height;
            xs[2] = pos + width;
            ys[2] = 200;
            g2.fillPolygon(xs, ys, 3);
            pos = pos + width;
        }
        
    }
    
    /**
     * Esta función utiliza un poligono para pintar el coche.
     * @param g2 Area que se utilizará para pintar el sol.
     */
    static void paintCar(Graphics2D g2){
        //Poligono del auto
        int autox[] = {200,200,250,250};
	int autoy[] = {230,240,240,230};
	g2.setColor(new Color(192,192,192));
	g2.fillPolygon(autox,autoy,4);
        
        //Ovalos para las llantas
        g2.setColor(new Color(0,0,0));
        g2.fillOval(210,235,10,10);
        g2.fillOval(230,235,10,10);
        
        //Poligono del parabrisas del auto
        int parabrisasx[]={240,230,220,210};
        int parabrisasy[]={230,220,220,230};
        g2.setColor(new Color(0,151,255));
        g2.fillPolygon(parabrisasx,parabrisasy,4);
    }
    
    /**
     * Esta función pinta el background y después manda a llamar a todas las demás funciones para pintar todo el Dibujo.
     * @param g Instancia de clase Graphics que será casteada para convertirla en gráficas de 2D.
     */
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        //g2.setColor(Color.black);
	g2.fillRect(0,0,300, 300);
	//g2.setColor(Color.white);

	int rojo, verde, azul;
	double dis;

	for (int i=0; i<300; i++){
            for (int j=0; j<200; j++){

                g2.setColor(new Color(0, 0,255-(j/2)));
                g2.drawLine(i,j,i,j );
                g2.setColor(new Color(0, 255-(j/2),0));
                g2.drawLine(i,(j/2)+200,i,(j/2)+200 );

            }
	}
        paintGrass(g2);
        paintHouse(g2);
        paintCar(g2);
        paintSun(g2);
        for(int k=0;k<20;k++)
            paintCloud(g2);
        
    }
    
    /**
     * Método main. Crea un nuevo Dibujo y lo presenta en pantalla.
     * @param s Esta aplicación no requiere de parámetros por lo que este arreglo va vacío.
     */
    public static void main(String s[]) {
        JFrame f = new JFrame("Paisaje");
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });
        JApplet applet = new Dibujo();
        f.getContentPane().add("Center", applet);
        applet.init();
        f.pack();
        f.setSize(new Dimension(300,300));
        f.setVisible(true);
    }
}