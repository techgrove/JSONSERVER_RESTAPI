package serialization_deserialization;

public class Users {
	
	String firstname;
	String lastname;
	int subjectId;
	int id;
	
	public Users() {
		
	}
	
	
	public Users(String firstname, String lastname, int subjectId, int id) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.subjectId = subjectId;
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

}
