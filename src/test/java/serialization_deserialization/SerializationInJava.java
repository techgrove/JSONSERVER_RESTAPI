package serialization_deserialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationInJava {

	
	public static void main(String[] args) throws Exception  {
		//Serialize
		FileOutputStream fos=new FileOutputStream("src\\test\\java\\serialization_deserialization\\data.txt");
		ObjectOutputStream oos= new ObjectOutputStream(fos);
		
		Data d1= new Data();
		d1.name="hello";
		d1.number=101;
		
		oos.writeObject(d1);
		
		
		//Deserialize
		FileInputStream fis= new FileInputStream("src\\test\\java\\serialization_deserialization\\data.txt");
		ObjectInputStream ois= new ObjectInputStream(fis);
		
		Data d2=(Data)ois.readObject();
		System.out.println(d2.name +"   "+d2.number);
	}
}

class Data implements Serializable{

	String name;
	int number;
	
}
