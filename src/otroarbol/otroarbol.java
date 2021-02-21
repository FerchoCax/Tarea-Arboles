package otroarbol;

import javax.swing.JFrame;

/**
 * Creado por hadexexplade el 01 de febrero del 2016
 */
public class otroarbol
{

    public static void main(String[] args)
    {
        JFrame jf=new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(800,600);
        jf.add(new Escena());
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);

    }
}
