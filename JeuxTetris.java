import java.awt.event.MouseEvent;
import java.awt.Component;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;

public class JeuxTetris extends BasicGame {
	public static Grille grille;
	int acceuil;
	int timer = 0;
	int temps;
	int t;
	int t2;
	Temps T;
	Forme f;
	int type;
	int stop;
	int suppr;
	int pause;
	Input inp;
	int press;
	int pos_fin;
	int pos_pause;
	public int scor;
	public int scor2;
	boolean fin;
	int r;
	int compt;// gere la supression

	private Image bg0;
	private Image bg;
	private Image bg2;
	private Image logo;
	private Image start2;
	private Image start2b;
	private Image pause1;
	private Image fin1;
	private Image pause2;
	private Image fin2;
	private Image F0;
	private Image F1;
	private Image F2;
	private Image F3;
	private Image F4;
	private Image score;
	private Image time;
	private Image next;
	private Image plateau415x815;

	java.awt.Font font;
	TrueTypeFont ttf;

	public JeuxTetris(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		// TODO Auto-generated method stub

		if (acceuil == 1) {
			g.drawImage(bg2, 0, 0, new Color(255, 255, 100, 200));
			grille.affich_acceuil(g);
			g.drawImage(logo, 181, 160, new Color(200, 200, 200, 255));
			g.drawImage(start2b, 290 + 90, 690, new Color(200, 200, 200));
			if (inp.getMouseX() >= 300 + 90 && inp.getMouseX() <= 300 + 90 + 165 && inp.getMouseY() >=735
					&& inp.getMouseY() <= 735 + 90)
				g.drawImage(start2, 290 + 90, 690, new Color(200, 200, 200));
			ttf.drawString(0, 0, "TATIEZE EMMANUEL", Color.green);

		}

		if (acceuil != 1) {

			if (fin) {

				r = JOptionPane.showConfirmDialog(null,"		score : " + scor2 + "\n		Temps: " + T.toString() + "\n		recommancer ?","La partie est terminée", 0);
				if (r == 0)
					acceuil = 0;
				else
					acceuil = 1;
				pause = 1;
				fin = false;
				scor = 0;
				scor2 = 0;
				suppr = 0;
				grille = new Grille();

				f = new Forme((int) (Math.random() * 5), 5 + 2, 2, 0);
				f.propriete();
				type = (int) (Math.random() * 5);

				grille.initialiser();

				f.mettre_Forme(grille);
				inp = gc.getInput();
				press = 0;
				compt = 0;
				pos_fin = 0;
				pos_pause = 0;
				temps = 0;
				t = 0;
				t2 = 0;
			}

			if (inp.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {

				if ((inp.getMouseX() >= 694 + 80 && inp.getMouseX() <= 694 + 80 + 92 && inp.getMouseY() >= 80 + 63
						&& inp.getMouseY() <= 80 + 63 + 102)) {
					r = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment quitter la partie ?", null, 0);
					if (r == 1) {
					}

					else {
						acceuil = 1;
						fin = false;
						scor = 0;
						scor2 = 0;
						suppr = 0;
						pause = 1;
						grille = new Grille();
						f = new Forme((int) (Math.random() * 5), 5 + 2, 2, 0);
						f.propriete();
						type = (int) (Math.random() * 5);
						grille.initialiser();
						f.mettre_Forme(grille);
						inp = gc.getInput();
						press = 0;
						compt = 0;
						pos_fin = 0;
						pos_pause = 0;
						temps = 0;
						t = 0;
						t2 = 0;

					}
				} else if ((inp.getMouseX() >= 694 + 80 && inp.getMouseX() <= 694 + 80 + 92
						&& inp.getMouseY() >= 80 + 189 && inp.getMouseY() <= 80 + 189 + 102)||inp.isKeyPressed(Input.KEY_ENTER)) {
					pause = pause * (-1);
					System.out.println(pause);
					if (pause == -1)
						gc.pause();
					if (pause == 1)
						gc.resume();

				}

			}

			g.drawImage(bg2, 0, 0, new Color(255, 255, 100, 200));
			g.drawImage(bg0, 80, 80);

			g.drawImage(plateau415x815, 280 - 15 - 3, 80 - 15 - 2);

			g.drawImage(score, 665 + 80, 534 + 80);
			ttf.drawString(665 + 80, 534 + 80 + 8, " " + scor2, Color.white);
			g.drawImage(time, 665 + 80, 658 + 80);
			ttf.drawString(665 + 80, 658 + 80 + 8, " " + T.toString(), Color.white);
			g.drawImage(next, 660 + 80, 334 + 80 + 7);

			if (type == 0)
				g.drawImage(F0, 660 + 80, 334 + 80 + 50);
			if (type == 1)
				g.drawImage(F1, 660 + 80 + 15, 334 + 80 + 50);
			if (type == 2)
				g.drawImage(F2, 660 + 80 + 15, 334 + 80 + 50);
			if (type == 3)
				g.drawImage(F3, 660 + 80 + 30, 334 + 80 + 50);
			if (type == 4)
				g.drawImage(F4, 660 + 80 + 15, 334 + 80 + 50);

			grille.afficher(g, f);


			if (pos_fin == 1)
				g.drawImage(fin2, 686 + 80, 80 + 63 - 2);
			else {
				g.drawImage(fin1, 686 + 80, 80 + 63 - 2);
			}
			if (pos_pause == 1)
				g.drawImage(pause2, 686 + 80, 80 + 183);
			else {
				g.drawImage(pause1, 686 + 80, 80 + 183);
			}

		}

	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		// TODO Auto-generated method stub
		acceuil = 1;
		fin = false;
		scor = 0;
		scor2 = 0;
		suppr = 0;
		pause = 1;
		
		grille = new Grille();
		f = new Forme((int) (Math.random() * 5), 5 + 2, 2, 0);
		f.propriete();
		type = (int) (Math.random() * 5);

		grille.initialiser();

		f.mettre_Forme(grille);
		inp = gc.getInput();
		press = 0;
		compt = 0;
		pos_fin = 0;
		pos_pause = 0;
		temps = 0;
		t = 0;
		t2 = 0;
		

		logo = new Image("images/logo.png");
		bg0 = new Image("images/bg0.png");
		bg2 = new Image("images/bg2.png");
		start2 = new Image("images/start2.png");
		start2b = new Image("images/start2b.png");
		plateau415x815 = new Image("images/plateau415x815.png");
		pause1 = new Image("images/pause1.png");
		fin1 = new Image("images/fin1.png");
		pause2 = new Image("images/pause2.png");
		fin2 = new Image("images/fin2.png");

		F0 = new Image("images/F0.png");
		F1 = new Image("images/F1.png");
		F2 = new Image("images/F2.png");
		F3 = new Image("images/F3.png");
		F4 = new Image("images/F4.png");

		score = new Image("images/score.png");
		time = new Image("images/time.png");
		next = new Image("images/next.png");

		font = new java.awt.Font("ALGERIAN", 25, 25);
		ttf = new TrueTypeFont(font, true);

	}

	@Override
	public void update(GameContainer gc, int alpha) throws SlickException {
		// TODO Auto-generated method stub

		if (acceuil == 1 &&inp.isKeyPressed(Input.KEY_ENTER)) {
				acceuil = 0;
		}
		if (acceuil == 1 && inp.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
			if (inp.getMouseX() >= 300 + 90 && inp.getMouseX() <= 300 + 90 + 200 && inp.getMouseY() >= 735
					&& inp.getMouseY() <= 735 + 90)
				acceuil = 0;

		}
		if (acceuil == 0) {
			if (inp.getMouseX() >= 686 + 80 && inp.getMouseX() <= 686 + 80 + 90 && inp.getMouseY() >= 80 + 63
					&& inp.getMouseY() <= 80 + 63 + 107)
				pos_fin = 1;
			else
				pos_fin = 0;

			if (inp.getMouseX() >= 686 + 80 && inp.getMouseX() <= 686 + 80 + 90 && inp.getMouseY() >= 80 + 183
					&& inp.getMouseY() <= 80 + 183 + 107)
				pos_pause = 1;
			else
				pos_pause = 0;
		}

		if (fin == false && acceuil != 1) {
			suppr = 0;

			temps += alpha;
			t2 += alpha;
			int v = 500;
			T = new Temps(t2);
			if (temps >= 60000) {
				t = temps;
				temps = 0;

			}
			timer += alpha;

			if (scor2 >= 1000)
				v = v - 300;
			if (scor2 >= 5000)
				v = v - 200;

			if (timer > v) {
				timer = 0;

				stop = grille.arret_Forme(f);
				if (f.getYf() < 19 + 2 && stop != 1) {
					f.effacer_Forme(grille);

					Forme.Translation_x_y(f, 0, 1);

					f.mettre_Forme(grille);
				} else {

					grille.setLg1(0);

					compt = 0;
					do {

						compt++;
						scor = grille.supprimer(gc);// suprimer une ligne
						if (scor != 0)
							suppr++;

					} while (compt <= 4);
					if (suppr == 4) {
						scor2 += 800;
					}
					if (suppr == 3) {
						scor2 -= 300;
						scor2 += 600;
					} else if (suppr > 0)
						scor2 += 100;

					if (grille.GameOver() == false) {

						f = new Forme(type, 5 + 2, 2, 0);
						f.propriete();
						f.mettre_Forme(grille);
						type = (int) (Math.random() * 5);
					} else
						fin = true;

				}

			}
			if (inp.isKeyPressed(Input.KEY_D) && f.getTypef() != 3 && grille.test_rotation(f, 90)
					&& grille.arret_Forme(f) != 1 && !grille.collision_en_haut(f) && !grille.collision_en_bas(f)
					&& f.getYf() < 21&& f.getYf() >=2) {
				f.effacer_Forme(grille);

				f.setRotation(90);
				f.Translation_x_y(f, grille.getVal(), 0);
				grille.setVal(0);
				Forme.roter(f);
				f.mettre_Forme(grille);
				gc.sleep(50);

			}
			if (inp.isKeyPressed(Input.KEY_A)&& f.getTypef() != 3 && grille.test_rotation(f, -90)
					&& !grille.collision_en_haut(f) && !grille.collision_en_bas(f) && grille.arret_Forme(f) != 1
					&& f.getYf() < 21&& f.getYf() >=2) {
				f.effacer_Forme(grille);
				f.setRotation(-90);
				f.Translation_x_y(f, grille.getVal(), 0);
				grille.setVal(0);
				Forme.roter(f);
				f.mettre_Forme(grille);
				gc.sleep(50);

			}
			if (inp.isKeyPressed(Input.KEY_RIGHT) && !grille.collision_a_Droite(f)) {
				f.effacer_Forme(grille);
				Forme.Translation_x_y(f, 1, 0);
				f.mettre_Forme(grille);

			}

			if (inp.isKeyPressed(Input.KEY_LEFT) && !grille.collision_a_Gauche(f)) {
				f.effacer_Forme(grille);
				Forme.Translation_x_y(f, -1, 0);
				f.mettre_Forme(grille);

			}

			if (inp.isKeyDown(Input.KEY_DOWN) && grille.arret_Forme(f) != 1 && f.getYf() < 19) {
				f.effacer_Forme(grille);
				Forme.Translation_x_y(f, 0, 1);
				f.mettre_Forme(grille);

				gc.sleep(50);
			}

		}
	}

}
