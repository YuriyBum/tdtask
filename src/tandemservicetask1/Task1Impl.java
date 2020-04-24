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
    //<p>Создаем хранилище полученного результата</p>
    private List<String[]> theSortedRow;

    @Override
    public void sort(final List<String[]> rows, final int columnIndex) {
    	
    	 // <p>Напишите здесь свою реализацию. Мы ждем от вас хорошо структурированного, документированного и понятного кода.</p>
    	 // <p>Реализация не работает корректно с десятичными дробями, только с последовательностями цифр. Значение "." это не цифра!</p>
    	 // <p>Первичный анализатор - вынесен в отдельный класс {@link StringAnalyzer}</p>
    	 // <p>Главный сортировщик строк применяется для строк из букв и цифр {@link DigitComparator}</p>
    	 // <p>Для проверки используется класс {@link tdtask1}</p>
    	StringAnalyzer an = new StringAnalyzer();
    	try {
    		//<p>Преобразуем массив в более мобильный</p>
    		
    		//<p>Результат сортировки. Создаем отдельный массив для результатов - 
    	    // важно не перезаписать исходник</p>
    		
    		List<List<String>> sortedRow = new ArrayList<List<String>>();
    		int lg = rows.get(columnIndex).length;

    	
    			// <p>добавляем ячейки с null. Добавление последовательно, что позволяет
    			// сохранить порядок сортировки</p>
 	   for (int k = 0; k < lg; k++) {
 		   //k подходит на роль индекса сортировки
 		   if (an.AnFirst(rows.get(columnIndex)[k])[0]) {
 			  List<String> newRow = new ArrayList<>();
 			 // <p>Найдя нужную колонку, добавляем циклом значения строки во все остальные колонки</p>
 			   for (int j = 0; j<rows.size(); j++ ) {
 				  newRow.add(rows.get(j)[k]);
 			   }
 			  System.out.println("Added null: " + newRow);
 			 sortedRow.add(newRow);
 		   }
 		    		   
		   System.out.println(rows.get(columnIndex)[k]);
		   
	   }
 	
		//<p>добавляем пустые ячейки</p>
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
 	   
   	//<p>Читаем итоговый массив - 1 часть. Делим на части, облегчить поиск ошибок.</p>
int firstPart = sortedRow.size();
for (int i = 0; i<firstPart;i++) {  
	 System.out.println(sortedRow.get(i));}
 	   
 	   //<h3>!!! Добавляем ячейки с цифрами</h3>
			 try { 
				 
				 List<ComparedList> digitAdapter = new ArrayList(); 
				 TreeMap<Integer, List<String>> collection = new TreeMap<>();
			 for (int u = 0; u < lg; u++) {
			 
			  if (an.AnFirst(rows.get(columnIndex)[u])[2] && !an.AnFirst(rows.get(columnIndex)[u])[3]) { 
	
			  //<p>Массив  последовательностей цифр в одной ячейке</p> 
				  List<String> newRow = new ArrayList<>();
	 			   for (int j = 0; j<rows.size(); j++ ) {
	 				  newRow.add(rows.get(j)[u]);  
	 			   }
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
			 
		 	   //<h3>!!! Добавляем ячейки только с цифрами</h3>
					 try { 
						 
						 List<ComparedList> digitAdapter = new ArrayList(); 
						 TreeMap<Integer, List<String>> collection = new TreeMap<>();
					 for (int u = 0; u < lg; u++) {
					 
					  if (an.AnFirst(rows.get(columnIndex)[u])[3]) { 
			
					  //<p>Массив  последовательностей цифр в одной ячейке</p> 
						  List<String> newRow = new ArrayList<>();
			 			   for (int j = 0; j<rows.size(); j++ ) {
			 				  newRow.add(rows.get(j)[u]);  
			 			   }
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
		
		  //<p>Добавляем ячейки без цифр. Сохраняем исходную последовательность</p>
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
		    	
    	//<p>Читаем итоговый массив - 2 часть</p>
	 	   
	 	  

for (int i = firstPart; i<sortedRow.size();i++) {  
	 System.out.println(sortedRow.get(i));}
    		
System.out.println("Total rows: " + sortedRow.size() + ", columns: " + sortedRow.get(columnIndex).size());
//<p>Возвращаем все в исходный формат. Для сортировки нам требовался массив строк. Теперь воссоздаем массив колонок</p>
List<String[]> thSortedRow = new ArrayList<String[]>();

for (int i = 0; i<sortedRow.size();i++) {
	String[] newColumn = new String[sortedRow.get(i).size()];
	for (int j = 0; j<sortedRow.get(i).size();j++) {
		newColumn[j] = sortedRow.get(i).get(j);
		System.out.println(sortedRow.get(i).get(j));
	}
	thSortedRow.add(newColumn);
}
//<h3>Записываем результат сортировки в хранилище</h3>
this.theSortedRow = thSortedRow;

			sortedRow.clear();
    		
    	} catch (IndexOutOfBoundsException e) {
    		//<p>Пользователь может ввести индекс больше длины массива, поэтому делаем проверку</p>
    		System.out.println("Operation not completed, may be too large column index: " + e);
		} 
			 catch (Exception e) { System.out.println(e); }
			   
    }
    // <p>Добавляем метод, возвращающий результат сортировки. 
    //Вызов метода должен быть заключен в попытку на случай, если сортировка не осуществлялась ранее.</p>
    public List<String[]> getSortedRows() {
    return theSortedRow;
    }
}
