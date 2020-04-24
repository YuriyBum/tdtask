package tandemservicetask1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DigitComparator implements Comparator<ComparedList> {

	/*
	 * <p>Метод предполагает поэтапное сравнение фрагментов строки. Приоритет наиболее</p>
	 * <p>длинного фрагмента из цифр (наибольший максимальный непрерывный фрагмент). Последующий фрагмент</p>
	 * <p>влияет на ранжирование в случае равенства предыдущих. Реализовано путем</p>
	 * <p>геометрической прогрессии (влияние последующего фрагмента ненулевое, но заведомо много меньше</p>
	 * <p>влияния предыдущего). Сравнение каждого последующего фрагмента влияет на</p>
	 * <p>индекс много меньше сравнения предыдущих. Если предыдущий неравен,</p>
	 * <p>последующий на ранжирование не повлияет.</p>
	 */


	@Override
	public int compare(ComparedList o1, ComparedList o2) throws IndexOutOfBoundsException {
		
		StringAnalyzer an = new StringAnalyzer();
	
		int r = 0;
		float coIndex = 0;
		List<String> ComparedO1 = new ArrayList();
		List<String> ComparedO2 = new ArrayList();
		ComparedO1 = an.FinallySplittedString(an.SplittedString(o1.getComparedList().get(o1.getColumnIndex())));
		ComparedO2 = an.FinallySplittedString(an.SplittedString(o2.getComparedList().get(o2.getColumnIndex())));
		//<p>Для контроля процедуры, в консоль выводятся промежуточные значения</p>
		System.out.println("DigitComparator 2 " + ComparedO2 + "Largest digit: " + o1.getLargestDigit());
		System.out.println("DigitComparator 1 " + ComparedO1);
		if (o1.getComparedList().size() > 0) {
			if (an.IsStringDigit(ComparedO1.get(0)) && an.IsStringDigit(ComparedO2.get(0))) {
			// <p>Возможна ситуация, когда отличие первого фрагмента минимально,</p>
			//	<p>а второго значительно, поэтому используем промежуточную переменную,</p>
			//	<p>чтобы гарантировать правильное ранжирование.</p>
			int u = Integer.parseInt(ComparedO1.get(0)) -
					Integer.parseInt(ComparedO2.get(0));
			if (u < 0) r = -o2.getLargestDigit();
			if (u > 0) r = o1.getLargestDigit();
			if (u == 0) r = 0;
			System.out.println("DigitComparator first index: " + r);	
			coIndex = r;
		List<Integer> minLength = new ArrayList();
		minLength.add(ComparedO1.size());
		minLength.add(ComparedO2.size());
			
		for (int i = 1; i < Collections.min(minLength); i++) {
			if (an.IsStringDigit(ComparedO1.get(i)) && an.IsStringDigit(ComparedO2.get(i))) {
				try {
					int k = (Integer.parseInt(ComparedO1.get(i-1)) - Integer.parseInt(ComparedO2.get(i-1)));
					if (k == 0) {
						int e = (Integer.parseInt(ComparedO1.get(i)) - Integer.parseInt(ComparedO2.get(i)));
						coIndex = coIndex + (e/(10^(i+1)));
					} else {
						//<p>Если ранжирование успешно прошло по предыдущему фрагменту, дальнейшее сравнение нецелесобразно</p>
						break;
					}
	
			} catch (Exception e) {
				System.out.println("DigitComparator exception " + e);
			}
				}
			
			if (an.IsStringDigit(ComparedO1.get(i)) && !an.IsStringDigit(ComparedO2.get(i))) {
				try {
					int k = (Integer.parseInt(ComparedO1.get(i-1)) - Integer.parseInt(ComparedO2.get(i-1)));
					if (k == 0) {
						coIndex = coIndex + (1/(10^(i+1)));
					} else {						
						break;
					}
	
			} catch (Exception e) {
				System.out.println("DigitComparator exception " + e);
			}
				}
			
			if (an.IsStringDigit(ComparedO1.get(i)) && !an.IsStringDigit(ComparedO2.get(i))) {
				try {
					int k = (Integer.parseInt(ComparedO1.get(i-1)) - Integer.parseInt(ComparedO2.get(i-1)));
					if (k == 0) {
						coIndex = coIndex + (1/(10^(i+1)));
					} else {						
						break;
					}

	
			} catch (Exception e) {
				System.out.println("DigitComparator exception " + e);
			}
				}
			
			if (!an.IsStringDigit(ComparedO1.get(i)) && an.IsStringDigit(ComparedO2.get(i))) {
				try {
					int k = (Integer.parseInt(ComparedO1.get(i-1)) - Integer.parseInt(ComparedO2.get(i-1)));
					if (k == 0) {
						coIndex = coIndex - (1/(10^(i+1)));
					} else {						
						break;
					}
	
			} catch (Exception e) {
				System.out.println("DigitComparator exception " + e);
			}
				}
			
			if (!an.IsStringDigit(ComparedO1.get(0)) && !an.IsStringDigit(ComparedO2.get(0)) 
					&& ComparedO1.get(0) != ComparedO2.get(0)) {
				try {
					List<String> comparingLetters = new ArrayList();
					comparingLetters.add(ComparedO1.get(0));
					comparingLetters.add(ComparedO2.get(0));
					Collections.sort(comparingLetters);
					
					if (Collections.min(comparingLetters) == ComparedO1.get(0)) {
						coIndex = coIndex + (1/(10^(i+1)));
					} else {
						coIndex = coIndex - (1/(10^(i+1)));
					}
	
			} catch (Exception e) {
				System.out.println("DigitComparator exception " + e);
			}
				}
			
	
		}

		System.out.println("DigitComparator index: " + coIndex);
		r = (int) (coIndex*10);
		System.out.println("DigitComparator index: " + r);
		
		
		
			System.out.println("DigitComparator : " + ComparedO1.get(0));
			System.out.println("DigitComparator : " + ComparedO2.get(0));
			
		} else if (an.IsStringDigit(ComparedO1.get(0)) && !an.IsStringDigit(ComparedO2.get(0))) {
			r = Integer.parseInt(ComparedO1.get(0));
		} else if (!an.IsStringDigit(ComparedO1.get(0)) && an.IsStringDigit(ComparedO2.get(0))) {
			r = - Integer.parseInt(ComparedO2.get(0));
		} else if (!an.IsStringDigit(ComparedO1.get(0)) && !an.IsStringDigit(ComparedO2.get(0)) 
				&& ComparedO1.get(0) != ComparedO2.get(0)) {
		
			List<String> comparingLetters = new ArrayList();
			comparingLetters.add(ComparedO1.get(0));
			comparingLetters.add(ComparedO2.get(0));
			Collections.sort(comparingLetters);
			
			if (Collections.min(comparingLetters) == ComparedO1.get(0)) {
				r = 10;
			} else {
				r = -10;
			}
			
		}
		}
	
		return r;
	}

}
