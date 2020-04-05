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
		
		System.out.println(String.valueOf(an.AnFirst("23")[2]));
		
		for (int i = 0; i<3;i++) {
			switch (i){
			case 0: {String[] e = {"test1", "test2", "test3", null, "come to me","", "deg42k"};
			testList.add(e);}
			break;
			case 1: {String[] e = {"tog1", null, "", null, "45bfg","", "gothic"};
			testList.add(e);}
			break;
			case 2: {String[] e = {null, "organize", "apple3", null, "","", "xcom5"};
			testList.add(e);}
			break;
			}
			
		}
		
		task.sort(testList, 2);
	}

}
