package javaObjRectangle;

public class Rectangle {
	
	private final double x1; 
	private final double y1;
	private final double x2;
	private final double y2;
	
	// constructeurs
	
	public Rectangle() {
		this(0,0,3,1);
	}
	
	public Rectangle(double x1, double y1, double x2, double y2) {

		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;

	}
	
	public double getLongueur(){
		return (x2 > x1)? (x2 - x1): (x1 - x2);
	}
	
	public double getLargeur(){
		return (y2 > y1)? (y2 - y1): (y1 - y2);
	}
	
	public void afficher(double Longueur, double Largeur){
		
		for (int index = 0; index < Largeur; index++){
			
			if(index == 0 || index == Largeur - 1){
				for (int j = 0; j < Longueur; j++){
					System.out.print('*');
				}
				System.out.println();				
			}
			else{
				System.out.print('*');
				for (int j = 1; j < Longueur - 1; j++){
					System.out.print(' ');
				}
				System.out.println('*');
			}
			
		}
	}
}
