package day1_12_21;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Mail {
	private long id;
	private String to;
	private String from;
	private String subject;
	private String content;
	private Date reveivedDate;
	private double size;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getReveivedDate() {
		return reveivedDate;
	}
	public void setReveivedDate(Date reveivedDate) {
		this.reveivedDate = reveivedDate;
	}
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public Mail(long id, String to, String from, String subject, String content, Date reveivedDate, double size) {
		super();
		this.id = id;
		this.to = to;
		this.from = from;
		this.subject = subject;
		this.content = content;
		this.reveivedDate = reveivedDate;
		this.size = size;
	}
	public Mail() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		
		return "Id:" + id + "\nTo:" + to + "\nFrom:" + from + "\nSubject:" + subject + "\nContent:" + content
				+ "\nReveivedDate:" + sdf.format(reveivedDate) + "\nSize:" + size;
	}
	@Override
	public int hashCode() {
		return Objects.hash(from, subject, to);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Mail other = (Mail) obj;
		return Objects.equals(from, other.from) && Objects.equals(subject, other.subject)
				&& Objects.equals(to, other.to);
	}
	
	public boolean equal1(Mail mail2)
	{
		if(this==mail2)
		{
			return true;
		}
		if(this.getClass()!=mail2.getClass())
		{
			return false;
		}
		if(this.from.equals(mail2.from)&&(this.to.equals(mail2.to))&&(this.subject==mail2.subject))
		{
			return true;
			
		}
		else
		{
			return false;
		}
		
		
	}
	
	
	 
	
	

}


