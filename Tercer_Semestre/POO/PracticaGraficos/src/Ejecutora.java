import javax.swing.JFrame;

public class Ejecutora {
    public static void main(String[] args) {
        DibujoCalavera dibujoCalavera = new DibujoCalavera();
        JFrame ventana = new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(dibujoCalavera);
        ventana.setSize(600, 600);
        ventana.setVisible(true);
    }
}