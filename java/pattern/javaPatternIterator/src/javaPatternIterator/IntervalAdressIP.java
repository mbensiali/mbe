package javaPatternIterator;

import java.util.Iterator;

public class IntervalAdressIP implements Iterable<Integer> {
	
	AdressIP IPdebut;
	AdressIP IPfin;
	
	


	
	public IntervalAdressIP(int debutChamp1, int debutChamp2, int debutChamp3, int debutChamp4, int finChamp1,
			int finChamp2, int finChamp3, int finChamp4) {
				
		IPdebut = new AdressIP(debutChamp1, debutChamp2, debutChamp3, debutChamp4);
		IPfin = new AdressIP(finChamp1, finChamp2, finChamp3, finChamp4);
		
	}

	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return new IntervalIterator();
	}
	
	public class IntervalIterator implements Iterator<Integer>
	{
		private int positionCh1;
		private int positionCh2;
		private int positionCh3;
		private int positionCh4;
				

		public IntervalIterator() {
			positionCh1 = IPdebut.getChamp1() - 1;
			positionCh2 = IPdebut.getChamp2() - 1;
			positionCh3 = IPdebut.getChamp3() - 1;
			positionCh4 = IPdebut.getChamp4() - 1;
		}

		@Override
		public boolean hasNext() {
			boolean isLast = true;
			
			if (positionCh1 < IPfin.getChamp1() ||
				positionCh2 < IPfin.getChamp2() ||
				positionCh3 < IPfin.getChamp3() ||
				positionCh4 < IPfin.getChamp4())
				isLast = false;
			
			return isLast;
		}

		@Override
		public Integer next() {
			// TODO Auto-generated method stub
			return null;
		}
		
		
	}
	

}
