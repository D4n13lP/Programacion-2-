import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import javax.swing.JPanel;

public class Vista extends javax.swing.JFrame {

    public Vista() {
        initComponents();
        PanelFondo fondo = new PanelFondo(800, 30);
        this.add(fondo);
        fondo.setBounds(10, 10, 800, 800);
    }


    @SuppressWarnings("uncjhecked")
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }

}
