package projectdemo2;

public class student {

	 int pid;
	 String pname;
	 String email;               
	 String phone;
	 int batch_id;
	 
	public student() {
		// TODO Auto-generated constructor stub
	}
	
	public student(int pid,String pname,String email,String phone,int bid) {
		
		this.pid=pid;
		this.pname=pname;
		this.email=email;
		this.phone=phone;
		this.batch_id=bid;
		
	}
	
	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getBatch_id() {
		return batch_id;
	}

	public void setBatch_id(int batch_id) {
		this.batch_id = batch_id;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getPid() {
		return pid;	
	}

	
	}
	
	
	
	


