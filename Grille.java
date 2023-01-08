import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Grille {
	public int[][] grille = new int[24][14];
	private int nb_lig = grille.length;
	private int nb_col = grille[0].length;
	private Color[] couleurs = new Color[5];
	private Image[] img = new Image[5];
	private Image vide;
	private Image bg;
	private Image logo;
	private Image vide2;
	private int lg1 = 0;
	private int val;

	public int getLg1() {
		return lg1;
	}

	public void setLg1(int lg1) {
		this.lg1 = lg1;
	}
	public void setGrille(int i, int j, int val) {
		this.grille[i][j] = val;
	}

	public int getNb_lig() {
		return nb_lig;
	}

	public int getNb_col() {
		return nb_col;
	}
	

	public void affich_acceuil(Graphics g) {
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[0].length; j++) {
				if (grille[i][j] == -1) {

					g.setColor(new Color((int) (Math.random() * 255), (int) (Math.random() * 255),
							(int) (Math.random() * 255), (int) (Math.random() * 255)));
					g.fillRect(j * 40 + 200, i * 40, 40, 40);

				}

			}

		}
	}

	
	
	public void initialiser() throws SlickException {

		int i, j;
		for (i = 0; i < grille.length; i++) {
			for (j = 0; j < grille[0].length; j++) {
				grille[i][j] = 0;
				if (j < 2 || j > 11)
					grille[i][j] = -1;

			}

		}
		for (i = 0; i < 2; i++) {
			for (j = 0; j < grille[0].length; j++) {
				grille[i][j] = -1;

			}

		}
		for (i = 22; i < grille.length; i++) {
			for (j = 0; j < grille[0].length; j++) {
				grille[i][j] = -1;

			}

		}
		img[0] = new Image("images/rouge.png");
		img[1] = new Image("images/bleu.png");
		img[2] = new Image("images/marron.png");
		img[3] = new Image("images/violet.png");
		img[4] = new Image("images/jaune.png");


	}
	
	
	

	public void afficher(Graphics g, Forme F)// affiche l'etat de la grille a un instant quelconque
	{
		Carre c;

		int i, j;
		for (i = 0; i < grille.length; i++) {
			for (j = 0; j < grille[0].length; j++) {
				if (grille[i][j] != 0) {

					if (grille[i][j] == 1) {
						g.drawImage(img[0], j * 40 + 200, i * 40, new Color(255, 255, 255, 255));
						g.setColor(new Color((int) (Math.random() * 255), (int) (Math.random() * 100),
								(int) (Math.random() * 255)));
					}
					if (grille[i][j] == 2) {
						g.drawImage(img[1], j * 40 + 200, i * 40, new Color(255, 255, 255, 255));
						g.setColor(new Color((int) (Math.random() * 255), (int) (Math.random() * 100),
								(int) (Math.random() * 255)));
					}
					if (grille[i][j] == 3) {

						g.drawImage(img[2], j * 40 + 200, i * 40, new Color(255, 255, 255, 255));

						g.setColor(new Color((int) (Math.random() * 255), (int) (Math.random() * 100),
								(int) (Math.random() * 255)));

					}
					if (grille[i][j] == 4) {

						g.drawImage(img[3], j * 40 + 200, i * 40, new Color(255, 255, 255, 255));

						g.setColor(new Color((int) (Math.random() * 255), (int) (Math.random() * 100),
								(int) (Math.random() * 255)));

					}
					if (grille[i][j] == 5) {

						g.drawImage(img[4], j * 40 + 200, i * 40, new Color(255, 255, 255, 255));

						g.setColor(new Color((int) (Math.random() * 255), (int) (Math.random() * 100),
								(int) (Math.random() * 255)));

					}

					c = new Carre(j, i);
					if (F.carre_de_forme_en_cours(c) && (grille[i][j] == 1 || grille[i][j] == 2 || grille[i][j] == 3
							|| grille[i][j] == 4 || grille[i][j] == 5)) {
						g.setColor(Color.white);
						g.fillRect(j * 40 + 200, i * 40, 40, 4);
						g.setColor(Color.white);
						g.fillRect(j * 40 + 200, i * 40 + 40, 40, 4);
						g.setColor(Color.white);
						g.fillRect(j * 40 + 200, i * 40, 4, 44);
						g.setColor(Color.white);
						g.fillRect(j * 40 + 40 + 200, i * 40, 4, 44);

					}

				}

			}
		}

	}
	
	

	public int arret_Forme(Forme F) {

		Carre[] position = new Carre[4];
		int pos = 0;// a modifier apres avoir gerer les rotations
		for (int i = 0; i < 4; i++) {
			position[i] = F.getcarresI(i);
		}
		Carre car;
		for (int i = 0; i < 4; i++) {
			car = new Carre(position[i].getX(), position[i].getY() + 1);
			if ((position[i].getY() + 1 <= 19 + 2 && grille[position[i].getY() + 1][position[i].getX()] != 0
					&& F.carre_de_forme_en_cours(car) == false) || position[i].getY() + 1 > 19 + 2) {
				pos = 1;

			}

		}

		return pos;

	}

	
	
	public boolean collision_a_Droite(Forme F) {

		Carre[] position = new Carre[4];
		boolean pos = false;// a modifier apres avoir gerer les rotations
		for (int i = 0; i < 4; i++) {
			position[i] = F.getcarresI(i);
		}
		Carre car;

		for (int i = 0; i < 4; i++) {
			if (position[i].getX() + 1 > 9 + 2 || position[i].getY() < 0 + 2)
				return true;
			car = new Carre(position[i].getX() + 1, position[i].getY());
			if ((position[i].getX() + 1 <= 9 + 2 && grille[position[i].getY()][position[i].getX() + 1] != 0
					&& F.carre_de_forme_en_cours(car) == false)) {
				pos = true;
			}

		}

		return pos;

	}
	
	

	public boolean collision_a_Gauche(Forme F) {

		Carre[] position = new Carre[4];
		boolean pos = false;// a modifier apres avoir gerer les rotations
		for (int i = 0; i < 4; i++) {
			position[i] = F.getcarresI(i);
		}
		Carre car;
		for (int i = 0; i < 4; i++) {
			if (position[i].getX() - 1 < 0 + 2 || position[i].getY() < 0 + 2)
				return true;
			car = new Carre(position[i].getX() - 1, position[i].getY());
			if ((position[i].getX() - 1 >= 0 + 2 && grille[position[i].getY()][position[i].getX() - 1] != 0
					&& F.carre_de_forme_en_cours(car) == false)) {
				pos = true;
			}

		}

		return pos;

	}

	
	
	public int supprimer(GameContainer gc) {
		int score = 0;
		int c = 0;
		for (int i = 0 + 2; i < grille.length - 2; i++) {
			int compt = 0;

			for (int j = 0 + 2; j < grille[0].length - 2; j++) {
				if (grille[i][j] != 0)
					compt++;

			}
			if (compt == 10) {
				lg1 = i;

				score += 100;
				c = i;

				for (int j = 0 + 2; j < grille[0].length - 2; j++) {
					grille[c][j] = 0;
				}
				if (c != 0) {
					for (i = c; i > 0 + 2; i--) {
						for (int j = 0 + 2; j < grille[0].length - 2; j++) {
							grille[i][j] = grille[i - 1][j];
						}
					}

					// gc.sleep(200);
					break;
				}

			}

		}

		return score;
	}
	
	

	public boolean GameOver() {
		int compt = 0;
		for (int j = 0 + 2; j < grille[0].length - 2; j++) {
			if (grille[0 + 2][j] == 0)
				compt++;
		}

		if ((grille[0 + 2][3 + 2] != 0 || grille[0 + 2][4 + 2] != 0 || grille[0 + 2][5 + 2] != 0
				|| grille[0 + 2][6 + 2] != 0) && compt != 0)
			return true;
		else
			return false;

	}

	
	
	public boolean collision_en_haut(Forme F) {

		Carre[] position = new Carre[4];
		boolean pos = false;

		for (int i = 0; i < 4; i++) {
			position[i] = F.getcarresI(i);
		}
		if (F.getTypef() == 0 && position[2].getY() < 2 + 2)
			return true;
		for (int i = 0; i < 4; i++) {

			if (position[i].getY() < 0 + 2) {
				pos = true;
			}

		}
		return pos;

	}

	
	
	public boolean collision_en_bas(Forme F) {

		Carre[] position = new Carre[4];
		boolean pos = false;

		for (int i = 0; i < 4; i++) {
			position[i] = F.getcarresI(i);
		}

		for (int i = 0; i < 4; i++) {

			if (position[i].getY() > 19 + 2) {
				pos = true;
			}

		}
		return pos;

	}

	
	
	
	public boolean limite_gauche(Forme F) {

		Carre[] position = new Carre[4];
		boolean pos = false;
		for (int i = 0; i < 4; i++) {
			position[i] = F.getcarresI(i);
		}

		for (int i = 0; i < 4; i++) {
			if (position[i].getX() - 1 < 0 + 2 || position[i].getY() < 0 + 2)
				return true;
		}
		return pos;
	}

	
	
	public boolean limite_droite(Forme F) {
		Carre[] position = new Carre[4];
		boolean pos = false;
		for (int i = 0; i < 4; i++) {
			position[i] = F.getcarresI(i);
		}

		for (int i = 0; i < 4; i++) {
			if (position[i].getX() + 1 > 9 + 2 || position[i].getY() < 0 + 2)
				return true;
		}
		return pos;
	}

	
	
	public boolean test_rotation(Forme F, int angle) {
		int compt1 = 0, compt2 = 0;
		Forme A = new Forme(F.getTypef(), F.getXf(), F.getYf(), 0);
		int ind = 0;
		boolean pos = false;

		for (int i = 0; i < 4; i++) {
			A.getcarresI(i).setX(F.getcarresI(i).getX());
			A.getcarresI(i).setY(F.getcarresI(i).getY());
		}

		A.setRotation(angle);
		A.roter(A);
		do {
			for (int j = 0; j < 4; j++) {
				if (grille[A.getcarresI(j).getY()][A.getcarresI(j).getX()] > 0 && j != 2
						&& !A.carre_de_forme_en_cours(A.getcarresI(j)))
					return false;
			}
			for (int i = 0; i < 4; i++) {
				ind = i;
				if (collision_en_haut(F) || collision_en_bas(A))
					return false;

				if (A.getcarresI(i).getX() <= 9 + 2 && A.getcarresI(i).getX() >= 0 + 2 && !collision_en_haut(F)
						&& !collision_en_bas(A)) {

					if (grille[A.getcarresI(i).getY()][A.getcarresI(i).getX()] == 0
							&& grille[A.getcarresI(i).getY()][A.getcarresI(i).getX()] != -1) {
						pos = true;
					}

				} else {
					pos = false;
					break;
				}

			}
			if (pos == false && A.getcarresI(ind).getX() < 0 + 2 && !collision_a_Droite(F)) {
				A.Translation_x_y(A, 1, 0);
				compt1++;

			}
			if (pos == false && A.getcarresI(ind).getX() > 9 + 2 && !collision_a_Gauche(F)) {
				A.Translation_x_y(A, -1, 0);
				compt2++;

			}
		} while (pos == false && (compt1 < 3 && compt2 < 3));

		if (pos == true && compt1 == 0) {
			this.val = -1 * compt2;
		}
		if (pos == true && compt2 == 0) {
			this.val = compt1;
		}

		return pos;

	}

	public int getVal() {
		return this.val;
	}

	public void setVal(int val) {
		this.val = val;
	}

}
