package day1_12_21;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter mail 1 detail");
		String detail=scan.nextLine();
		String [] details=detail.split(",");
		Mail mail1=new Mail();
		
		
	//	long id=Long.parseLong(details[0]);
		
		mail1.setId(Long.parseLong(details[0]));
		mail1.setTo(details[1]);
		mail1.setFrom(details[2]);
		mail1.setSubject(details[3]);
		mail1.setContent(details[4]);
		mail1.setReveivedDate(sdf.parse(details[5]));
		mail1.setSize(Double.parseDouble(details[6]));
		
		System.out.println("Enter mail 2 detail");
		detail=scan.nextLine();
		Mail mail2=new Mail(Long.parseLong(detail.split(",")[0]), detail.split(",")[1], detail.split(",")[2], detail.split(",")[3]
				,detail.split(",")[4], sdf.parse(detail.split(",")[5]), Double.parseDouble(detail.split(",")[6]));
		
		System.out.println("Mail 1:\n"+mail1);
		System.out.println("Mail 2:\n"+mail2);
		
		System.out.println(mail1.equals(mail2)?"Mail 1 and Mail 2 are Same":"Mail 1 and mail 2 are different");

	}

}

