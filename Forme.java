import org.newdawn.slick.Color;

public class Forme {
	private int xf;
	private int yf;
	private int typef;
	private Color couleur;
	private Carre[] carres = new Carre[4];
	private int rotation;
	// boolean estEnMvt;
/*
    
    0=>forme horizontale (couleur bleu-ciel)
    1=>forme en L (couleur bleu foncée)
    2=>forme en T renverse (couleur violet)     	
    3=>forme en o (cube de 4x4 carres) (couleur jaune)
    4=>forme en Z (couleur rouge)
    
    
    */
	//////////////////// SETTERS AND GETTERS//////////////////

	public static void Translation_x_y(Forme F, int xf, int yf) {
		for (int i = 0; i < 4; i++) {

			F.carres[i].setX(F.carres[i].getX() + xf);
			F.carres[i].setY(F.carres[i].getY() + yf);
		}

	}

	public static void roter(Forme F) // L'angle est soit 90 soit -90
	{
		int x1;
		int y1;
		if (F.rotation == 90 && F.typef != 3) {

			for (int i = 0; i < 4; i++) {
				if (i != 2) {
					x1 = F.carres[i].getX();
					y1 = F.carres[i].getY();
					F.carres[i].setX(y1 - F.carres[2].getY() + F.carres[2].getX());// this.carres[0].setX(this.xf-2);
					F.carres[i].setY(F.carres[2].getX() - x1 + F.carres[2].getY());// this.carres[0].setY(this.yf);

				}

			}

		}
		if (F.rotation == -90 && F.typef != 3) {

			for (int i = 0; i < 4; i++) {
				if (i != 2) {
					x1 = F.carres[i].getX();
					y1 = F.carres[i].getY();
					F.carres[i].setX(-y1 + F.carres[2].getY() + F.carres[2].getX());// this.carres[0].setX(this.xf-2);
					F.carres[i].setY(-F.carres[2].getX() + x1 + F.carres[2].getY());// this.carres[0].setY(this.yf);

				}

			}

		}

	}

	public Carre getcarresI(int i) {
		return carres[i];
	}

	public int getTypef() {
		return typef;
	}

	public void setTypef(int typef) {
		this.typef = typef;
	}

	public int getXf() {
		return xf;
	}

	public void setXf(int xf) {
		if (typef == 0) {
			if (xf <= 1 + 2 || xf >= 9 + 2)
				this.xf = this.xf;
			else
				this.xf = xf;

		}
		if (typef == 1) {

			if (xf <= 0 + 2 || xf >= 9 + 2)
				this.xf = this.xf;
			else
				this.xf = xf;

		}
		if (typef == 2) {
			if (xf <= 0 + 2 || xf >= 9 + 2)
				this.xf = this.xf;
			else
				this.xf = xf;
		}
		if (typef == 3) {
			if (xf < 0 + 2 || xf >= 9 + 2)
				this.xf = this.xf;
			else
				this.xf = xf;
		}
		if (typef == 4) {
			if (xf <= 0 + 2 || xf >= 9 + 2)
				this.xf = this.xf;
			else
				this.xf = xf;
		}

	}

	public int getYf() {
		return yf;
	}

	public void setYf(int yf) {
		if (yf < 0 + 2 || yf > 19 + 2)
			this.yf = 0;
		else
			this.yf = yf;

	}

	public int getRotation() {
		return rotation;
	}

	public void setRotation(int rotation) {
		if (rotation == 90 || rotation == -90 || rotation == 0)
			this.rotation = rotation;
	}

	public boolean carre_de_forme_en_cours(Carre c) {
		if (c.getX() == this.carres[0].getX() && c.getY() == this.carres[0].getY()) {
			return true;
		} else if (c.getX() == this.carres[1].getX() && c.getY() == this.carres[1].getY()) {
			return true;
		} else if (c.getX() == this.carres[2].getX() && c.getY() == this.carres[2].getY()) {
			return true;
		} else if (c.getX() == this.carres[3].getX() && c.getY() == this.carres[3].getY()) {
			return true;
		}

		else
			return false;

	}

////////////////////////////////////////////////////////////////////

/////////////////////CONSTRUCTEUR//////////////////////////////////
	Forme(int type, int xf, int yf, int rotation) {
		// C=new Carre();
		// estEnMvt=true;

		for (int i = 0; i < 4; i++) {
			carres[i] = new Carre();
		}
		this.xf = xf;
		this.yf = yf;
		if (type == 0) {

			this.typef = 0;
			if (xf <= 1 + 2 || xf >= 9 + 2)
				this.xf = 5;
			if (yf < 0 + 2 || yf > 19 + 2)
				this.yf = 0;

		}
		if (type == 1) {
			this.typef = 1;
			if (xf <= 1 + 2 || xf >= 9 + 2)
				this.xf = 4;
			if (yf < 0 + 2 || yf > 19 + 2)
				this.yf = 1;

		}
		if (type == 2) {
			this.typef = 2;
			if (xf <= 1 + 2 || xf >= 9 + 2)
				this.xf = 4;
			if (yf < 0 + 2 || yf > 19 + 2)
				this.yf = 1;

		}
		if (type == 3) {
			this.typef = 3;
			if (xf < 0 + 2 || xf >= 9 + 2)
				this.xf = 4;
			if (yf < 0 + 2 || yf > 19 + 2)
				this.yf = 1;

		}
		if (type == 4) {
			this.typef = 4;
			if (xf <= 1 + 2 || xf >= 9 + 2)
				this.xf = 4;
			if (yf < 0 + 2 || yf > 19 + 2)
				this.yf = 1;
		}
		if (rotation == 90 || rotation == -90 || rotation == 0)
			this.rotation = rotation;
		else
			this.rotation = 0;

	}
	////////////////////////////////////////////////////////////////////

	////////////////////// METHODE POUR LES COORDONNEES INITIALES DES CARRES D'UNE
	////////////////////// FORME(SANS ROTATION OU TRANSLATION DE LA FORME) TOUS PAR
	////////////////////// RAPPORT AU CARRE DE REFERENCE////////////////////////////

	public void propriete() {
		/*
		 * carres[i] represente le carré situé en position i sur la forme en question
		 * les positions varient de 0 a 3 soit(4 carrés) : -le carre0 (carres[0]) etant
		 * le premier carre place au dessus des autres(excepte le cas de la forme0 qui
		 * est une barre horizontale)partant de la gauche
		 */
		int i;
		if (typef == 0)// 0=>forme horizontale //////////COORDONNEES INITIALES DES CARRES DE LA FORME 0
		{

			this.carres[0].setX(this.xf - 2);
			this.carres[0].setY(this.yf);

			this.carres[1].setX(this.xf - 1);
			this.carres[1].setY(this.yf);

			this.carres[2].setX(this.xf);/// carre de reference (POINT EN HAUT ET A L'EXTREME GAUCHE DU 3e CARRE DE LA
											/// FORME 0 )
			this.carres[2].setY(this.yf);

			this.carres[3].setX(this.xf + 1);
			this.carres[3].setY(this.yf);

		}
		if (typef == 1)// 1=>forme en L //////////COORDONNEES INITIALES DES CARRES DE LA FORME 1
		{

			this.carres[0].setX(this.xf - 1);
			this.carres[0].setY(this.yf - 1);

			this.carres[1].setX(this.xf - 1);
			this.carres[1].setY(this.yf);

			this.carres[2].setX(this.xf);/// carre de reference
			this.carres[2].setY(this.yf);

			this.carres[3].setX(this.xf + 1);
			this.carres[3].setY(this.yf);

		}
		if (typef == 2)// 2=>forme en T renverse //////////COORDONNEES INITIALES DES CARRES DE LA FORME
						// 2
		{
			this.carres[0].setX(this.xf);
			this.carres[0].setY(this.yf - 1);

			this.carres[1].setX(this.xf - 1);
			this.carres[1].setY(this.yf);

			this.carres[2].setX(this.xf);/// carre de reference
			this.carres[2].setY(this.yf);

			this.carres[3].setX(this.xf + 1);
			this.carres[3].setY(this.yf);

		}
		if (typef == 3)// 3=>forme en o (cube de 4x4 carres) //////////COORDONNEES INITIALES DES CARRES
						// DE LA FORME 3
		{
			this.carres[0].setX(this.xf);
			this.carres[0].setY(this.yf - 1);

			this.carres[1].setX(this.xf + 1);
			this.carres[1].setY(this.yf - 1);

			this.carres[2].setX(this.xf);/// carre de reference
			this.carres[2].setY(this.yf);

			this.carres[3].setX(this.xf + 1);
			this.carres[3].setY(this.yf);

		}
		if (typef == 4)// 4=>forme en Z //////////COORDONNEES INITIALES DES CARRES DE LA FORME 4
		{
			this.carres[0].setX(this.xf - 1);
			this.carres[0].setY(this.yf - 1);

			this.carres[1].setX(this.xf);
			this.carres[1].setY(this.yf - 1);

			this.carres[2].setX(this.xf);/// carre de reference
			this.carres[2].setY(this.yf);

			this.carres[3].setX(this.xf + 1);
			this.carres[3].setY(this.yf);

		}

	}
	///////////////////////////////////////////////////////////////////////////////////////////

	///////////////////////// METHODE POUR METTRE UNE FORME DANS LA GRILLE SANS
	///////////////////////// L'AFFICHER///////////////////
	public void mettre_Forme(Grille grille) {

		for (int i = 0 + 2; i < 24 - 2; i++) {
			for (int j = 0 + 2; j < 14 - 2; j++) {
				if ((j == this.carres[0].getX() && i == this.carres[0].getY())
						|| (j == this.carres[1].getX() && i == this.carres[1].getY())
						|| (j == this.carres[2].getX() && i == this.carres[2].getY())
						|| (j == this.carres[3].getX() && i == this.carres[3].getY())) {

					grille.setGrille(i, j, typef + 1);
				}

			}
		}

	}

	public void effacer_Forme(Grille grille) {

		for (int i = 0 + 2; i < 24 - 2; i++) {
			for (int j = 0 + 2; j < 14 - 2; j++) {
				if ((j == this.carres[0].getX() && i == this.carres[0].getY())
						|| (j == this.carres[1].getX() && i == this.carres[1].getY())
						|| (j == this.carres[2].getX() && i == this.carres[2].getY())
						|| (j == this.carres[3].getX() && i == this.carres[3].getY()))
					grille.setGrille(i, j, 0);

			}
		}

	}

}
