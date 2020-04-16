package tandemservicetask1;

import java.lang.StringBuffer;
import java.util.ArrayList;
import java.util.Collections;

//Вспомогательный класс для проверки строк, ячеек, колонок
public class StringAnalyzer {
	
	public boolean[] AnFirst (String ob) {
		
		/* index:
		 * 0. null
		 * 1. Пустые
		 * 2. Есть цифры */
		
		boolean[] anRes = {false, false, false};
		
		if (ob == null) {
			anRes[0] = true;
		} else if (ob == "") {
			anRes[1] = true;
		} else {
			for (int r = 0; r < ob.length(); r++) {
				
				if (Character.isDigit(ob.charAt(r))) {
					anRes[2] = true;
					 break;}
				
			}
	}
			
		return anRes;
	
	}
	
	public boolean IsCharDigit (char a) {
		
		// Проверяем отдельный символ. Метод добавлен в созданный нами класс для удобства
		
		boolean prov = false;		
		if (Character.isDigit(a)) 
			prov = true;
		
		return prov;
	}
	
	public String SelectDigits (String ob) {
		// Запасной метод
		StringBuffer resob = new StringBuffer("");
		
		for (int i = 0; i < ob.length(); i++) {
			if (Character.isDigit(ob.charAt(i))) {
				resob.append(ob.charAt(i));
			}
		}
		
		return resob.toString();
	}
	
	public int SelectLargestDigit (String ob) {
		
	        //Сортировка ведется по большему значению, поскольку больший порядок (больше цифр) 
		//априори означает большее значение, но устраняется проблема равного количества цифр
		
		StringBuffer resours = new StringBuffer("");
		int obr = 0;
		ArrayList<Integer> digitArray = new ArrayList<>();
		
		for (int i = 0; i < ob.length(); i++) {
			if (Character.isDigit(ob.charAt(i))) {
				int k = i;
				while(Character.isDigit(ob.charAt(k))) {
				resours.append(ob.charAt(k));
				if (k < (ob.length()-1)) {
				k++;
				} else {
					break;
				}
				}
				digitArray.add(Integer.parseInt(resours.toString()));
				resours.setLength(0);			
					i = k;

			}
		}
		if (digitArray.size()> 0) {
		obr = Collections.max(digitArray);
		}
				
		return obr;
	}
	
	
	
	}
	
	

