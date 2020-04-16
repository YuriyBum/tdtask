package tandemservicetask1;

import java.util.ArrayList;
import java.util.List;

public class tdstask1 {
	
	
	//Вспомогательный класс для проверки реализации с тестовыми входными данными
	
	public static void main(String[] args) {
		
			StringAnalyzer an = new StringAnalyzer();
			
		Task1Impl task = new Task1Impl();
		//Тестовый входной надор данных
		List<String[]> testList = new ArrayList<String[]>();
		
		
		for (int i = 0; i<4;i++) {
			switch (i){
			case 0: {String[] e = {"Organization 584 test1", "test2", "test3 ", null, "come to me","", "deg42k", "givan ok"};
			testList.add(e);}
			break;
			case 1: {String[] e = {"tog1", null, "", null, "45bfg","", "gothic", "givan ok"};
			testList.add(e);}
			break;
			case 2: {String[] e = {null, "organize", "apple3", null, "","", "xcom 5 ok", "givan ok"};
			testList.add(e);}
			break;
			case 3: {String[] e = {"Location confirmed" , "Sheduled 568 units", "jrg 5 ok 32", "Attached 13 units", "","", "xcom 5 ok", "givan ok"};
			testList.add(e);}
			break;
			}
			
		}
		
		task.sort(testList, 0);
		
		
	}
	


}
