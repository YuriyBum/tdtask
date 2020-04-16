package tandemservicetask1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * <h1>Задание №1</h1>
 * Реализуйте интерфейс {@link IStringRowsListSorter}.
 *
 * <p>Мы будем обращать внимание в первую очередь на структуру кода и владение стандартными средствами java.</p>
 */
public class Task1Impl implements IStringRowsListSorter {

	 // ваша реализация должна работать, как singleton. даже при использовании из нескольких потоков.
    public static final IStringRowsListSorter INSTANCE = new Task1Impl();

    @Override
    public void sort(final List<String[]> rows, final int columnIndex) {
    	
    	 // напишите здесь свою реализацию. Мы ждем от вас хорошо структурированного, документированного и понятного кода.
    	
    	//Первичный анализатор - вынесен в отдельный класс
    	StringAnalyzer an = new StringAnalyzer();
    	try {
    		//Преобразуем массив в более мобильный
    		
    		//Результат сортировки. Создаем отдельный массив для результатов - 
    	//важно не перезаписать исходник
    		
    		List<List<String>> sortedRow = new ArrayList<List<String>>();
    		int lg = rows.get(columnIndex).length;

    	
    			//добавляем ячейки с null. Добавление последовательно, что позволяет
    			// сохранить порядок сортировки
 	   for (int k = 0; k < lg; k++) {
 		   //k подходит на роль индекса сортировки
 		   if (an.AnFirst(rows.get(columnIndex)[k])[0]) {
 			  List<String> newRow = new ArrayList<>();
 			   for (int j = 0; j<rows.size(); j++ ) {
 				  newRow.add(rows.get(j)[k]);
 			   }
 			  System.out.println("Added null: " + newRow);
 			 sortedRow.add(newRow);
 		   }
 		    		   
		   System.out.println(rows.get(columnIndex)[k]);
		   
	   }
 	
		//добавляем пустые ячейки
 	   for (int k = 0; k < lg; k++) {
 		   if (an.AnFirst(rows.get(columnIndex)[k])[1]) {
 			  List<String> newRow = new ArrayList<>();
 			   for (int j = 0; j<rows.size(); j++ ) {
 				  newRow.add(rows.get(j)[k]);  
 			   }
 			  System.out.println("Added empty: " + newRow);
 			 sortedRow.add(newRow);

 		   } 		    		  
		   
	   }
 	   
   	//Читаем итоговый массив - 1 часть. Делим на части, облегчить поиск ошибок.
int firstPart = sortedRow.size();
for (int i = 0; i<firstPart;i++) {  
	 System.out.println(sortedRow.get(i));}
 	   
 	  //!!! Добавляем ячейки с цифрами
			 try { 
				  //Добавляем класс, в котором будут учтены и массив строк, и номер колонки
				 List<ComparedList> digitAdapter = new ArrayList(); 
				 TreeMap<Integer, List<String>> collection = new TreeMap<>();
			 for (int u = 0; u < lg; u++) {
			 
			  if (an.AnFirst(rows.get(columnIndex)[u])[2]) { 
	
				  List<String> newRow = new ArrayList<>();
	 			   for (int j = 0; j<rows.size(); j++ ) {
	 				  newRow.add(rows.get(j)[u]);  
	 			   }
				  //Готовим сортировку через компаратор
	 			  ComparedList cList = new ComparedList();
	 			cList.setComparedList(newRow);
	 			cList.setColumnIndex(columnIndex);
	 			  digitAdapter.add(cList);

			  }		  
 }			  		 

            Collections.sort(digitAdapter, new DigitComparator());
		
 			for (int f = 0; f < digitAdapter.size(); f++ ) {
			sortedRow.add(digitAdapter.get(f).getComparedList());
 			}
			digitAdapter.clear();
			 
	 } catch (Exception e) { 
			 System.out.println(e); 
		 }
		
		//Добавляем ячейки без цифр. Сохраняем исходную последовательность
	 	   for (int k = 0; k < lg; k++) {
	 		   if (!an.AnFirst(rows.get(columnIndex)[k])[0] &&
	 				  !an.AnFirst(rows.get(columnIndex)[k])[1] &&
	 				 !an.AnFirst(rows.get(columnIndex)[k])[2] ) {
	 			  List<String> newRow = new ArrayList<>();
	 			   for (int j = 0; j<rows.size(); j++ ) {
	 				  newRow.add(rows.get(j)[k]);  
	 			   }
	 			 sortedRow.add(newRow);
	 		   }
			   
		   }
		    	
    	//Читаем итоговый массив - 2 часть

for (int i = firstPart; i<sortedRow.size();i++) {  
	 System.out.println(sortedRow.get(i));}
    		
			sortedRow.clear();
    		
    	} catch (IndexOutOfBoundsException e) {
    		//Пользователь может ввести индекс больше длины массива, поэтому делаем проверку
    		System.out.println("Operation not completed, may be too large column index: " + e);
		} 
			 catch (Exception e) { System.out.println(e); }
			   
    }
}
