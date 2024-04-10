package projectdemo2;

import java.util.Date;

public class batch {

	 int batch_id;  
	 String batch_name;         
	 Date start_date;  
	 Date end_date;    
	 String instructor;    
	 int max_capacity;
	 
	 public batch() {
			// TODO Auto-generated constructor stub
		}
	 
	 public batch(int bid,String bname,Date start_date,Date end_date,String instructor,int max_capacity) {
			this.batch_id=bid;
			this.batch_name=bname;
			this.start_date=start_date;
			this.end_date=end_date;
			this.instructor=instructor;
			this.max_capacity=max_capacity;
			
		}
		
	 
	 public int getBatch_id() {
		return batch_id;
	}

	public void setBatch_id(int batch_id) {
		this.batch_id = batch_id;
	}

	public String getBatch_name() {
		return batch_name;
	}

	public void setBatch_name(String batch_name) {
		this.batch_name = batch_name;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public int getMax_capacity() {
		return max_capacity;
	}

	public void setMax_capacity(int max_capacity) {
		this.max_capacity = max_capacity;
	}

	 

	

}
