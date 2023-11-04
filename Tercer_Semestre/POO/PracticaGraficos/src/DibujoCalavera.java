import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class DibujoCalavera extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Cambia el color de fondo a negro
        setBackground(Color.BLACK);
        // Cambia el color del dibujo a beige
        g.setColor(new Color(245, 245, 220));
        // Dibuja la parte superior de la calavera (un círculo)
        g.fillOval(100, 50, 200, 200);
        // Dibuja la parte inferior de la calavera (un rectángulo redondeado más angosto)
        g.fillRoundRect(140, 215, 120, 75, 50, 50);
        g.setColor(Color.BLACK);
        g.fillOval(140, 150, 50, 50); // Ojo izquierdo
        g.fillOval(210, 150, 50, 50); // Ojo derecho
        // Dibuja la nariz como un triángulo más pequeño y más abajo
        g.fillPolygon(new int[] {185, 200, 215}, new int[] {210, 240, 210}, 3);
        // Dibuja los dientes
        for (int i = 160; i <= 240; i += 20) {
            g.drawLine(i, 275, i, 300);
        }
    }
}


