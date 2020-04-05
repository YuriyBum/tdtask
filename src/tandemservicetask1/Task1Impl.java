package tandemservicetask1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
 		   
 		   
		   System.out.println(rows.get(columnIndex)[k]);
		   
	   }
 	   
   	//Читаем итоговый массив - 1 часть. Делим на части, облегчить поиск ошибок.
int firstPart = sortedRow.size();
for (int i = 0; i<firstPart;i++) {  
	 System.out.println(sortedRow.get(i));}



 	   
 	   //!!! Добавляем ячейки с цифрами
try {
 	  List<Integer> digitAdapter = new ArrayList<>();
 	   for (int u = 0; u < lg; u++) {
 
 		   if (an.AnFirst(rows.get(columnIndex)[u])[2]) {
 			   String d = "";
 			   //Массив последовательностей цифр в одной ячейке
 			  List<Integer> currentDigits = new ArrayList<>();
 			   for (int h = 0; h < rows.get(columnIndex)[u].length(); h++) {
 				  
 				   if(an.IsCharDigit(rows.get(columnIndex)[u].charAt(h))) {
 					   //Ищем максимальное количество по длине, собираем в массив последовательности цифр из ячейки
 					   String num = "";
 					   while(an.IsCharDigit(rows.get(columnIndex)[u].charAt(h))) {
 					   num = num + (rows.get(columnIndex)[u].charAt(h));
 					   }
 					  currentDigits.add(Integer.parseInt (num));
 					 num = "";
 				   }
 				   
 			   }
 			  digitAdapter.add(Collections.max(currentDigits));
 			 currentDigits.clear();
 		   }
		   
	   }
	   //Сортируем ифровые ячейки
 	  Collections.sort(digitAdapter);
		  for (int k = 0; k < digitAdapter.size(); k++) {
			
			  for (int g = 0; g < lg; g++) {
				  //Ищем строку с таким же значением, проверяем, что нет совпадений
				  if (rows.get(columnIndex)[g].contains(String.valueOf(digitAdapter.get(k)))) {
					//Убеждаемся, что нашли максимальное значение - запускаем цикл повторно
		 			  List<Integer> currentDigits = new ArrayList<>();
		 			   for (int h = 0; h < rows.get(columnIndex)[g].length(); h++) {
		 				  
		 				   if(an.IsCharDigit(rows.get(columnIndex)[g].charAt(h))) {
		 				
		 					   String num = "";
		 					   while(an.IsCharDigit(rows.get(columnIndex)[g].charAt(h))) {
		 					   num = num + (rows.get(columnIndex)[g].charAt(h));
		 					   }
		 					  currentDigits.add(Integer.parseInt (num));
		 					 num = "";
		 				   }
		 				   
		 			   }
		 			  int check = Collections.max(currentDigits);
		  			 currentDigits.clear();
		 			   if (digitAdapter.get(k) == check) {
		 				  List<String> newRow = new ArrayList<>();
		 	 			   for (int j = 0; j<rows.size(); j++ ) {
		 	 				  newRow.add(rows.get(j)[g]);  
		 	 			   }
		 	 			   //Добавление последовательно, в случае полного совпадения порядок не изменится
		 	 			   
		 	 			 sortedRow.add(newRow);
		 	 			newRow.clear();
		 				  break;
		 			   }
					  
				
				  }
			  }

		  }
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
