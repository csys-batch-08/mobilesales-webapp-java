package com.mobilesalesapp.util;



public class EncryptionAndDecryption {
	private  String password;
	private  char[] chars;
	private char[] let;
	private String encryptedPassword;
	
	EncryptionAndDecryption() {
		password="oracle";
		chars=password.toCharArray();
		let=new char[chars.length];
		
		int i=0;
		for(char c : chars) {
			c+=7;
			let[i]=c;
			i++;
		}
		encryptedPassword=String.valueOf(let);
	
	}
	public  String decryt() {
		
		chars=encryptedPassword.toCharArray();
		let=new char[chars.length];
		int i=0;
		for(char c : chars) {
			c-=7;
			let[i]=c;
			i++;
		}
		String decryptedPassword=String.valueOf(let);
		return decryptedPassword;
	}

}
