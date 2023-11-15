import javax.swing.*;
import java.awt.*;

import java.awt.Color;
import javax.swing.JPanel;

public class PanelFondo extends JPanel {

    Color colorfondo=Color.gray;
    int tammax,tam,can;

    public PanelFondo(int tammax, int can) {
        this.tammax=tammax;
        this.can=can;
        this.tam=tammax/can;
    }
    @Override
    public void paint(Graphics pintor) {    //crea la grafica
        super.paint(pintor);                //borra lo que ya se habia graficado   
        pintor.setColor(colorfondo);
        for(int i = 0; i < can; i++){
            for(int j = 0; j < can; j++){
                pintor.drawRect(i*tam, j*tam, tam-1, tam-1);
            } 
        }
    }
}
