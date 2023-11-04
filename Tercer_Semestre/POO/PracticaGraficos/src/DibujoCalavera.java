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
        // Cambia el color del dibujo a marrón
        g.setColor(new Color(139, 69, 19));
        // Dibuja la parte superior del sombrero (un óvalo)
        g.fillOval(75, 20, 250, 100);
        // Dibuja la parte inferior del sombrero (un óvalo más grande)
        g.fillOval(50, 70, 300, 50);
        // Cambia el color del dibujo a blanco para las velas
        g.setColor(Color.WHITE);
        // Dibuja la vela de la izquierda
        g.fillRect(30, 150, 30, 150);
        // Dibuja la vela de la derecha
        g.fillRect(340, 150, 30, 150);
        // Cambia el color del dibujo a amarillo para las llamas de las velas
        g.setColor(Color.YELLOW);
        // Dibuja la llama de la vela de la izquierda
        g.fillOval(35, 120, 20, 30);
        // Cambia el color del dibujo a rojo para las llamas de las velas
        g.setColor(Color.RED);
        // Dibuja la llama de la vela de la izquierda
        g.fillOval(40, 125, 10, 20);
        // Cambia el color del dibujo a amarillo para las llamas de las velas
        g.setColor(Color.YELLOW);
        // Dibuja la llama de la vela de la derecha
        g.fillOval(345, 120, 20, 30);
        // Cambia el color del dibujo a rojo para las llamas de las velas
        g.setColor(Color.RED);
        // Dibuja la llama de la vela de la derecha
        g.fillOval(350, 125, 10, 20);
    }
}


