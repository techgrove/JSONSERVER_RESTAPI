package serialization_deserialization;

public class Subjects {
	
	String name;
	int id;
	
	public Subjects() {
		
	}
	public Subjects(String name, int id) {
		this.name=name;
		this.id=id;
	}
	
	
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setId(int id) {
	  this.id=id;
	}
	
}
