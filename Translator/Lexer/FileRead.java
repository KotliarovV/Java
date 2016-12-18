import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileRead {

	//public StringBuilder[] strings;
	public String[] strings;
	private BufferedReader reader;
	
	public FileRead(String name)
	{
		
		
		 try {
			 //ArrayList <StringBuilder> strings = new ArrayList<>();
			 ArrayList <String> strings = new ArrayList<>();
	             
			 File file = new File(name);
	            //создаем объект FileReader для объекта File
	            FileReader fr = new FileReader(file);
	            reader = new BufferedReader(fr);
	            // считаем сначала первую строку
	            String line = reader.readLine();
	            while (line != null) {
	            	
	            
	//                strings.add(new StringBuilder(line));
	            	strings.add(line);
	                // считываем остальные строки в цикле
	                line = reader.readLine();
	            }
	           //this.strings = strings.toArray(new StringBuilder[strings.size()]);
	            this.strings = strings.toArray(new String[strings.size()]);
		           
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
		
	}
}
