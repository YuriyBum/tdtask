package tandemservicetask1;


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
				
				switch (ob.charAt(r)) {
				case '0':
					anRes[2] = true;
					break;
				case '1':
					anRes[2] = true;
					break;
				case '2':
					anRes[2] = true;
					break;
				case '3':
					anRes[2] = true;
					break;
				case '4':
					anRes[2] = true;
					break;
				case '5':
					anRes[2] = true;
				case '6':
					anRes[2] = true;
					break;
				case '7':
					anRes[2] = true;
					break;
				case '8':
					anRes[2] = true;
					break;
				case '9':
					anRes[2] = true;
					break;
				 default: 
					 anRes[2] = false;
					 break;}
				
			}
	}
			
		return anRes;
	
	}
	
	public boolean IsCharDigit (char a) {
		
		// Проверяем отдельный символ. Метод применим на любом этапе при анализе отдельной ячейки.
		
		boolean prov = false;
		
		switch (a) {
		case '0':
			prov = true;
			break;
		case '1':
			prov = true;
			break;
		case '2':
			prov = true;
			break;
		case '3':
			prov = true;
			break;
		case '4':
			prov = true;
			break;
		case '5':
			prov = true;
		case '6':
			prov = true;
			break;
		case '7':
			prov = true;
			break;
		case '8':
			prov = true;
			break;
		case '9':
			prov = true;
			break;
		 default: 
			 prov = false;
			 break;}
		
		
		return prov;
	}
	
	
	}
	
	

