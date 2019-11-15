/**
 * Projet Java: jeu Snake.
 * <AUTHORS> Bouquoyoue Bilel 2TL2,  Derreumaux Valentin 2TL2, Tang Jean-Michaël 2TL2
 */
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Random;


public class snakefini extends JPanel{
	/**
	 * Création du jeu snake.
	 */

    private Point oeuf = new Point(0,0);
    private Random rand = new Random();
    private boolean isGrowing = false;
    private int gameLost = 0;
    private int offset = 0;
    private int newDirection = 39;
    public boolean eggEaten = false;

    public static void main(String[] args) {
    	/**
    	 * Lancement des méthodes du jeu et capture des touches directionnelles
    	 * 
    	 */
        frame.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }
            public void keyReleased(KeyEvent e) {
            }
            public void keyPressed(KeyEvent e) {
                e.getKeyCode();
            }
        });
    }
 
    public snake() {
    	/**
    	 * Lance le serpent du jeu snake
    	 */
        creerOeuf();
        snake.add(new PartieSerpent(0, 0, 39));
        new Thread(new Runnable() {
            public void run() {
                while(true) {
                    jeu();
                }
            }
        })
        .start();
    }
   
    public void creerOeuf() {
    	/**
    	 * Création de l'oeuf à un endroit au hasard du plateau de jeu
    	 * sans apparaître sur le serpent
    	 */
    }
        boolean positionAvailable;
        do {
            oeuf.x = rand.nextInt(12);
            oeuf.y = rand.nextInt(12);
            positionAvailable = true;
            eggEaten = true;
            for(snakeIsAlive) {
                if(checkNotAvailablePositions) positionAvailable = false;
            }
        } while(!positionAvailable);
    }

    protected void game() {
       /**
        * Implémentation de la logique du jeu.
        * 
        */
        if(gameLost) System.out.println("Game Over");
       
        offset += 5;
        PartieSerpent head = null;
        if(offset == WIDTH) {
            offset = 0;
            head.move();
            head.direction = newDirection;
            snake.addFirst(head);
            if(head.x == oeuf.x && head.y == oeuf.y) {
                isGrowing = true;
                creerOeuf();
            }
            if(!isGrowing)
                snake.pollLast();
            else
                isGrowing = false;
        }
       
        for(snakeIsAlive) {
            if(checkIfAlive()) gameLost = 1;
        }
       
        objet.drawString("Score : "+(snake.size() -1), 9, 15);
       
    }


    public void onKeyPressed(int keyCode) {
        /**
         * Checke les inputs au clavier pour donner la direction du serpent
         */
    	if(pressedKey) {
            changeDirection;
        }
    }
    /**
     * Constructeur qui donne la position et la direction du serpent
     * pour le faire bouger
     */
    class PartieSerpent {
       
        public int x, y, direction;
       
        public PartieSerpent(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        /**
        * Méthode pour passer le serpent d'un côté à l'autre de l'écran
        */

        public void move() {
            if(direction == 37 || direction == 39) {
                x += (direction == 37) ? -1 : 1;
                if(x > 18)
                    gameLost = 1;
                else if(x < 0)
                	gameLost = 1;
            }else {
                y += (direction == 38) ? -1 : 1;
                if(y > 18)
                	gameLost = 1;
                else if(y < 0)
                	gameLost = 1;
            }
        }
    }