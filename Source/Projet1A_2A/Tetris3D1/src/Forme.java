import java.util.Random;

import java.lang.Math;


public class Forme {

    private Tetrominoes pieceForme;
    private int coords[][];
    private int[][][] coordsTable;


    public Forme() {

        coords = new int[4][2];//Position du plateau
        setForme(Tetrominoes.defaut);

    }

    public void setForme(Tetrominoes defaut) {

         coordsTable = new int[][][] {
        	
            { { 0, 0}, { 0, 0 }, { 0, 0 }, { 0, 0 } },//Piece par Defaut	
            { { 0, -1 },  { 0, 0 },   { -1, 0 },  { -1, 1 } },//Piece Z
            { { 0, -1 },  { 0, 0 },   { 1, 0 },   { 1, 1 } },//Piece S
            { { 0, -1 },  { 0, 0 },   { 0, 1 },   { 0, 2 } },//Piece barre
            { { -1, 0 },  { 0, 0 },   { 1, 0 },   { 0, 1 } },//Piece T
            { { 0, 0 },   { 1, 0 },   { 0, 1 },   { 1, 1 } },//Piece Carre
            { { -1, -1 }, { 0, -1 },  { 0, 0 },   { 0, 1 } },//Piece L
            { { 1, -1 },  { 0, -1 },  { 0, 0 },   { 0, 1 } }//LInvers
        };

        for (int i = 0; i < 4 ; i++) {
            for (int j = 0; j < 2; ++j) {
                coords[i][j] = coordsTable[defaut.ordinal()][i][j];//Ordinal renvoie la coordonn�e o� se trouve la piece
            }
        }
        pieceForme = defaut;

    }

    private void setX(int position, int x) { 
    	
    	coords[position][0] = x; 
    }
    private void setY(int position, int y) { 
    	
    	coords[position][1] = y; 
    }
    public int x(int position) { 
    	
    	return coords[position][0];
    }
    public int y(int position) {
    	
    	return coords[position][1]; 
    }
    public Tetrominoes getForme()  { 
    	
    	return pieceForme; 
    }
    public void setAleatForme(){
    	
        Random r = new Random();
        int x = Math.abs(r.nextInt()) % 7 + 1;
        Tetrominoes[] valeur = Tetrominoes.values(); 
        setForme(valeur[x]);
    }

    public int minX(){
    	
      int m = coords[0][0];
      for (int i=0; i < 4; i++) {
          m = Math.min(m, coords[i][0]);
      }
      return m;
    }


    public int minY(){
    	
      int m = coords[0][1];
      for (int i=0; i < 4; i++) {
          m = Math.min(m, coords[i][1]);
      }
      return m;
    }

    public Forme rotateLeft(){
    	
        if (pieceForme == Tetrominoes.carre)
            return this;

        Forme result = new Forme();
        result.pieceForme = pieceForme;

        for (int i = 0; i < 4; ++i) {
            result.setX(i, y(i));
            result.setY(i, -x(i));
        }
        return result;
    }

    public Forme rotateRight(){
        if (pieceForme == Tetrominoes.carre)
            return this;

        Forme result = new Forme();
        result.pieceForme = pieceForme;

        for (int i = 0; i < 4; ++i) {
            result.setX(i, -y(i));
            result.setY(i, x(i));
        }
        return result;
    }
}