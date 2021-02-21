package otroarbol;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JPanel;

/**
 * Alex
 */
public class PanelArbol<E> extends JPanel
{
    private int radio=15;
    private int espacioVertical=50;
    private ArbolGeneral<E> arbolGeneral;
    private HashMap<Elemento<E>,Point> coordenadas;

    public PanelArbol(ArbolGeneral<E> arbolGeneral)
    {
        this.arbolGeneral = arbolGeneral;
        this.coordenadas=new HashMap<Elemento<E>, Point>();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if(!arbolGeneral.estaVacia())
        {
            dibujar(g,arbolGeneral.getRaiz(),getWidth()/2,30,getWidth()/5);
        }
    }

    private void dibujar(Graphics g, Elemento<E> raiz, int x, int y, int espacioH)
    {
        g.drawOval(x-radio,y-radio,2*radio,2*radio);
        g.drawString(raiz.getElemento() + "", x - 6, y + 4);
        ArrayList<Elemento<E>>hijos=arbolGeneral.obtenerHijos(raiz);
        coordenadas.put(raiz,new Point(x,y));
        for(Elemento<E> hijo:hijos)
        {
            Point punto=coordenadas.get(arbolGeneral.obtenerPadre(hijo));
            dibujarLinea(g,x-espacioH,y+espacioVertical,punto.x,punto.y);
            dibujar(g,hijo,x-espacioH,y+espacioVertical,espacioH/hijos.size());
            x+=espacioH;
        }
    }

    private void dibujarLinea(Graphics g, int x1, int y1, int x2, int y2)
    {
        double  d=Math.sqrt(espacioVertical*espacioVertical+(x2-x1)*(x2-x1));
        int xx1=(int)(x1-radio*(x1-x2)/d);
        int yy1=(int)(y1-radio*(y1-y2)/d);
        int xx2=(int)(x2+radio*(x1-x2)/d);
        int yy2=(int)(y2+radio*(y1-y2)/d);

        g.drawLine(xx1,yy1,xx2,yy2);

    }

}
