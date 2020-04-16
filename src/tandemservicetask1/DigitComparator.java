package tandemservicetask1;

import java.util.Comparator;

public class DigitComparator implements Comparator<ComparedList> {



	@Override
	public int compare(ComparedList o1, ComparedList o2) throws IndexOutOfBoundsException {
		
		StringAnalyzer an = new StringAnalyzer();
		// TODO Auto-generated method stub
		int r = 0;
		if (o1.getComparedList().size() > 0) {
			r = an.SelectLargestDigit(o1.getComparedList().get(o1.getColumnIndex())) 
			- an.SelectLargestDigit(o2.getComparedList().get(o2.getColumnIndex()));
		}
		
		return r;
	}

}
