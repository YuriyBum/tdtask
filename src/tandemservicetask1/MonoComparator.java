package tandemservicetask1;

import java.util.Comparator;
import java.util.List;

public class MonoComparator implements Comparator<String> {



	@Override
	public int compare(String o1, String o2) throws IndexOutOfBoundsException {
		
		StringAnalyzer an = new StringAnalyzer();
		// <p>Используется для сортировки фрагментов строки под фильтр. Ключевая задача - выстраивание цифр впереди</p> 
		// <p>остальных фрагментов. В ходе выполнения программы, как цифры будут распознаны только непрерывные максимальные</p> 
		// <p>фрагменты из цифр.</p>
		int r = 0;
		if (an.IsStringDigit(o1) && an.IsStringDigit(o2)) {
		r = 20;
		}
		if (!an.IsStringDigit(o1) && an.IsStringDigit(o2)) {
			r = 10;
			}
		if (an.IsStringDigit(o1) && !an.IsStringDigit(o2)) {
			r = -10;
			}
		if (!an.IsStringDigit(o1) && !an.IsStringDigit(o2)) {
			r = 0;
			}
		
		return r;
	}

}
