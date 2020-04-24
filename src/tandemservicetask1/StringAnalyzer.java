package tandemservicetask1;

import java.lang.StringBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sun.istack.internal.NotNull;

//<h2>Вспомогательный класс для проверки строк, ячеек, колонок</h2>
public class StringAnalyzer {
	
	public boolean[] AnFirst (String ob) {
		
		/* <p>Сбор данных по строке, возвращает boolean[]:</p>
		 * <ul>
		 * <li>0. null</li>
		 * <li>1. Пустые</li>
		 * <li>2. Есть цифры</li>
		 * <li>3. Только цифры</li> 
		 * </ul>*/
		
		boolean[] anRes = {false, false, false, false};
		
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
                            for (int r = 0; r < ob.length(); r++) {
				
				if (!Character.isDigit(ob.charAt(r))) {
					anRes[3] = false;
					 } else {
						 anRes[3] = true; 
					 }
				
			}
	}
			
		return anRes;
	
	}
	
	public boolean IsStringDigit (String a) throws NumberFormatException {
		
		// <p>Проверяем отдельную строку на предмет состава из цифр, возвращает boolean</p>
		boolean b;	 
		    try {
		        Integer.parseInt(a);
		        b = true;
		    } catch (NumberFormatException e) {
		        b = false;
		    }
		
		
		return b;
	}
	
	public String SelectDigits (String ob) {
		// <p>Сбор цифр из строки, возвращает String</p>
		StringBuffer resob = new StringBuffer("");
		
		for (int i = 0; i < ob.length(); i++) {
			if (Character.isDigit(ob.charAt(i))) {
				resob.append(ob.charAt(i));
			}
		}
		
		return resob.toString();
	}
	
	public int TotalLargestDigit(String[] ob) {
		/*
		 * <p>Для корректной работы основного компаратора {@link: DigitComparator} важно</p>
		 * <p>знать максимально возможное число, с каким он может столкнуться. Для этого</p>
		 * <p>используется TotalLargestDigit, возвращает int</p>
		 */
		int a = 0;
		List<Integer> dList = new ArrayList();
		for (int i = 0; i < ob.length; i++) {
			dList.add(this.SelectLargestDigit(ob[i]));
		}
		a = Collections.max(dList);
		return a;
	}
	
	public int SelectLargestDigit (String ob) {
		
		//<p>Выделение наибольшей цифры. Возвращает String, использование для вычислений требует дополнительного преобразования</p>
		//<p>результата методом Integer.parseInt(SelectLargestDigit (String )) или аналогичным</p>
		//<p>Сортировка ведется по большему значению, поскольку больший порядок (больше цифр)</p> 
		//<p>априори означает большее значение, но устраняется проблема равного количества цифр</p>
		
		StringBuffer resours = new StringBuffer("");
		int obr = 0;
		ArrayList<Integer> digitArray = new ArrayList<>();
		
		for (int i = 0; i < String.valueOf(ob).length(); i++) {
			if (Character.isDigit(String.valueOf(ob).charAt(i))) {
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
	//<p>Разбивка строки на части из текста и цифр. Возвращает List<String>. Данный метод не выделяет максимальный фрагмент из цифр.</p>  
	//<p>Последнее реализуется дополнительным методом FinallySplittedString, для лучшем масштабируемости приложения.</p> 
	
	public List<String> SplittedString (String ob) {
		List<String> fragments = new ArrayList();
		
		
		for (int i = 0; i < ob.length(); i++) {
			if (Character.isDigit(ob.charAt(i))) {
				int k = i;
				
				StringBuffer resours = new StringBuffer("");
				if(k > 1)
				resours.append(ob.charAt(k-1));
				
				while(Character.isDigit(ob.charAt(k))) {
				resours.append(ob.charAt(k));
				if (k < (ob.length()-1)) {
					k++;
					} else {
						break;
			} 
				}
				
				fragments.add(resours.toString());
				resours.setLength(0);			
				i = k;
		} else  {
			int k = i;
			StringBuffer resours = new StringBuffer("");
			while(!Character.isDigit(ob.charAt(k))) {
				resours.append(ob.charAt(k));
				if (k < (ob.length()-1)) {
					k++;
					} else {
						break;
					}
		}
			fragments.add(resours.toString());
			resours.setLength(0);			
			i = k;
		}
		}

		return fragments;
		}

	//<p>Метод выделяет в отдельные фрагменты непрерывные максимальные фрагменты, состоящие только из цифр. Возвращает List<String>.</p>  
	//<p>Символ "." не является цифрой, цифра и число - разные понятия. Для значений "3445" и "31.344523" искомым будет считаться "344523"</p> 
	  public List<String> FinallySplittedString (List<String> ob) {
		  List<String> fragments = new ArrayList();
		  StringBuffer combine = new StringBuffer();
		  List<Integer> buffer = new ArrayList();

		  int maxnumbers = 0;
		  for(int i = 0; i < ob.size(); i++) {
			  if(this.IsStringDigit(ob.get(i))) {
				  buffer.add(Integer.parseInt(ob.get(i)));
			  }
		  }
		  
		  if(buffer.size() > 0) {
			  maxnumbers = (int)Math.log10(Collections.max(buffer))+1;
		  } 
		  
		  for(int i = 0; i < ob.size(); i++) {
			  if(!this.IsStringDigit(ob.get(i))) {
				  combine.append(ob.get(i));
			  } else if (ob.get(i).length() == maxnumbers) {
				 if(combine.length()>0) fragments.add(combine.toString());
				  fragments.add(ob.get(i));
				combine.setLength(0);
			  } else {
				  combine.append(ob.get(i) + " ");
			  }
		  }
		  if(combine.length()>0) fragments.add(combine.toString());
		  combine.setLength(0);
		  Collections.sort(fragments, new MonoComparator());
		return fragments;
		  	  
	  }


}	

