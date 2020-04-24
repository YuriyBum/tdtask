package tandemservicetask1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparedList {

	/*
	 * Для компаратора нужны сведения: сам массив (строка), индекс колонки и
	 * наибольшее значение, с каким он может столкнуться
	 */
	
 List<String> comparedList = new ArrayList<String>();

 int columnIndex;
 
 int largestDigit;


public Integer getColumnIndex() {
    return columnIndex;
}

public void setColumnIndex(Integer columnIndex) {
    this.columnIndex = columnIndex;
}

public List<String> getComparedList() {
    return comparedList;
}

public void setComparedList(List<String> comparedList) {
    this.comparedList = comparedList;
}

public Integer getLargestDigit() {
    return largestDigit;
}

public void setLargestDigit(Integer largestDigit) {
    this.largestDigit = largestDigit;
}
			
	}


