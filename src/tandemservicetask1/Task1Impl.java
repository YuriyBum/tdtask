package tandemservicetask1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <h1>������� �1</h1>
 * ���������� ��������� {@link IStringRowsListSorter}.
 *
 * <p>�� ����� �������� �������� � ������ ������� �� ��������� ���� � �������� ������������ ���������� java.</p>
 */
public class Task1Impl implements IStringRowsListSorter {

	 // ���� ���������� ������ ��������, ��� singleton. ���� ��� ������������� �� ���������� �������.
    public static final IStringRowsListSorter INSTANCE = new Task1Impl();

    @Override
    public void sort(final List<String[]> rows, final int columnIndex) {
    	
    	 // �������� ����� ���� ����������. �� ���� �� ��� ������ ������������������, ������������������ � ��������� ����.
    	
    	//��������� ���������� - ������� � ��������� �����
    	StringAnalyzer an = new StringAnalyzer();
    	try {
    		//����������� ������ � ����� ���������
    		
    		//��������� ����������. ������� ��������� ������ ��� ����������� - 
    	//����� �� ������������ ��������
    		
    		List<List<String>> sortedRow = new ArrayList<List<String>>();
    		int lg = rows.get(columnIndex).length;

    	
    			//��������� ������ � null. ���������� ���������������, ��� ���������
    			// ��������� ������� ����������
 	   for (int k = 0; k < lg; k++) {
 		   //k �������� �� ���� ������� ����������
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
 	
		//��������� ������ ������
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
 	   
   	//������ �������� ������ - 1 �����. ����� �� �����, ��������� ����� ������.
int firstPart = sortedRow.size();
for (int i = 0; i<firstPart;i++) {  
	 System.out.println(sortedRow.get(i));}



 	   
 	   //!!! ��������� ������ � �������
try {
 	  List<Integer> digitAdapter = new ArrayList<>();
 	   for (int u = 0; u < lg; u++) {
 
 		   if (an.AnFirst(rows.get(columnIndex)[u])[2]) {
 			   String d = "";
 			   //������ ������������������� ���� � ����� ������
 			  List<Integer> currentDigits = new ArrayList<>();
 			   for (int h = 0; h < rows.get(columnIndex)[u].length(); h++) {
 				  
 				   if(an.IsCharDigit(rows.get(columnIndex)[u].charAt(h))) {
 					   //���� ������������ ���������� �� �����, �������� � ������ ������������������ ���� �� ������
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
	   //��������� ������� ������
 	  Collections.sort(digitAdapter);
		  for (int k = 0; k < digitAdapter.size(); k++) {
			
			  for (int g = 0; g < lg; g++) {
				  //���� ������ � ����� �� ���������, ���������, ��� ��� ����������
				  if (rows.get(columnIndex)[g].contains(String.valueOf(digitAdapter.get(k)))) {
					//����������, ��� ����� ������������ �������� - ��������� ���� ��������
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
		 	 			   //���������� ���������������, � ������ ������� ���������� ������� �� ���������
		 	 			   
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
		  //��������� ������ ��� ����. ��������� �������� ������������������
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
		  
    	
    	
    	//������ �������� ������ - 2 �����

for (int i = firstPart; i<sortedRow.size();i++) {  
	 System.out.println(sortedRow.get(i));}


    		
			sortedRow.clear();
    		
    	} catch (IndexOutOfBoundsException e) {
    		//������������ ����� ������ ������ ������ ����� �������, ������� ������ ��������
    		System.out.println("Operation not completed, may be too large column index: " + e);
		} 
			 catch (Exception e) { System.out.println(e); }
			
   
    }
}
