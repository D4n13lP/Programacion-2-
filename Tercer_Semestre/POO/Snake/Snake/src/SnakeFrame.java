import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
 *  Función completada: agregar la opción de reiniciar el juego
 * */

public class SnakeFrame extends Frame{
	//el ancho y la longitud de la cuadrícula
	public static final int BLOCK_WIDTH = 15 ;
	public static final int BLOCK_HEIGHT = 15 ;
	//el número de filas y columnas de la cuadrícula en la interfaz
	public static final int ROW = 40;
	public static final int COL = 40;
	
	//Puntuación
	private int score = 0;
	
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	//el objeto de hilo para dibujar
	private MyPaintThread paintThread = new MyPaintThread();

	private Image offScreenImage = null;
	
	private Snake snake = new Snake(this);
	
	private Egg egg = new Egg();
	
	private static SnakeFrame sf =null;
	
	public static void main(String[] args) {
		sf = new SnakeFrame();
		sf.launch();
	}
	
	public void launch(){
		
		this.setTitle("Snake");
		this.setSize(ROW*BLOCK_HEIGHT, COL*BLOCK_WIDTH);
		this.setLocation(30, 40);
		this.setBackground(Color.WHITE);
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		this.setResizable(false);
		this.setVisible(true);
		
		//agregar un evento de escucha a la interfaz
		this.addKeyListener(new KeyMonitor());
		
		new Thread(paintThread).start();
	}
	
	
	private boolean b_gameOver = false;

	public void gameOver(){
		b_gameOver = true;
	}
	
	/*
	 * reescribir el método de actualización
	 * */
	@Override
	public void update(Graphics g) {
		if(offScreenImage==null){
			offScreenImage = this.createImage(ROW*BLOCK_HEIGHT, COL*BLOCK_WIDTH);
		}
		Graphics offg = offScreenImage.getGraphics();
		//primero dibuja el contenido en un lienzo virtual
		paint(offg);
		//luego dibuja todo el contenido del lienzo virtual en el lienzo
		g.drawImage(offScreenImage, 0, 0, null);
		
		if(b_gameOver){
			g.drawString("Fin del juego", ROW/2*BLOCK_HEIGHT, COL/2*BLOCK_WIDTH);
			paintThread.dead();
		}
		
		snake.draw(g);
		boolean b_Success=snake.eatEgg(egg);
		//comer uno suma 5 puntos
		if(b_Success){
			score+=5;
		}
		egg.draw(g);
		displaySomeInfor(g);
		
		
	}
	/*
	 * Función: mostrar algunos mensajes de ayuda en la interfaz
	 * */
	public void displaySomeInfor(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.drawString("Instrucciones de uso: tecla de espacio — pausa, tecla B — comienza después de la pausa, F2 — reinicia", 5*BLOCK_HEIGHT, 3*BLOCK_WIDTH);
		g.drawString("Puntuación:"+score, 5*BLOCK_HEIGHT, 5*BLOCK_WIDTH);		
		g.setColor(c);
		
	}

	@Override
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.GRAY);
		/*
		 * Dibujar la interfaz compuesta por cuadrículas de ROW COL, se puede resolver con dos bucles for  
		 * */
		for(int i = 0;i<ROW;i++){
			g.drawLine(0, i*BLOCK_HEIGHT, COL*BLOCK_WIDTH,i*BLOCK_HEIGHT );
		}
		for(int i=0;i<COL;i++){
			g.drawLine(i*BLOCK_WIDTH, 0 , i*BLOCK_WIDTH ,ROW*BLOCK_HEIGHT);
		}
		
		g.setColor(c);
	}
	
	
	/*
	 * Redibujar la clase de hilo 
	 * */
	private class MyPaintThread implements Runnable{
		//La ejecución no se puede cambiar. Este hilo finalizará después del cambio.
		private static final boolean  running = true;
		private boolean  pause = false;
		@Override
		public void run() {
			while(running){
				//Si la pausa es verdadera, pausa
				if(pause){
					continue;
				}
				repaint();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		/*
		 * Función: pausa
		 * */
		public void pause(){
			pause = true;
		}
		/*
		 * reanudar desde la pausa
		 * */
		public void recover(){
			pause = false;
		}
		/*
		 * Cuando el juego termina y muere, solo puedes configurar la pausa en verdadero, 
		 * y no puedes configurar ejecutar = falso, lo que hará que finalice el hilo de redibujo; De lo contrario, no se puede reiniciar
		 * 
		 * */
		public void dead(){
			pause = true;
		}
		
		/*
		 * Función: reiniciar una ronda
		 * */
		public void reStart(){
			sf.b_gameOver = false;
			this.pause = false;
			snake = new Snake(sf);
	
		}
		
	}
	
	private class KeyMonitor extends KeyAdapter{
		
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(key == KeyEvent.VK_SPACE){
				paintThread.pause();
			}
			else if(key == KeyEvent.VK_B){// comenzar
				paintThread.recover();
			}
			else if(key == KeyEvent.VK_F2){// Empezar otra ronda
				paintThread.reStart();
			}
			else{
				snake.keyPressed(e);
			}			
		}
		
	}
	
}