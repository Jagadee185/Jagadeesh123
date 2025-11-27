package com.pack1;

import java.io.Serializable;

public class CustomerBean implements Serializable
{
	private String cust_Name;
	private String cust_pword;
	private String cust_fname;
	private String cust_lname;
	private String cust_add;
	private String cust_mail;
	private String cust_phone;
	public String getCust_Name() {
		return cust_Name;
	}
	public void setCust_Name(String cust_Name) {
		this.cust_Name = cust_Name;
	}
	public String getCust_pword() {
		return cust_pword;
	}
	public void setCust_pword(String cust_pword) {
		this.cust_pword = cust_pword;
	}
	public String getCust_fname() {
		return cust_fname;
	}
	public void setCust_fname(String cust_fname) {
		this.cust_fname = cust_fname;
	}
	public String getCust_lname() {
		return cust_lname;
	}
	public void setCust_lname(String cust_lname) {
		this.cust_lname = cust_lname;
	}
	public String getCust_add() {
		return cust_add;
	}
	public void setCust_add(String cust_add) {
		this.cust_add = cust_add;
	}
	public String getCust_mail() {
		return cust_mail;
	}
	public void setCust_mail(String cust_mail) {
		this.cust_mail = cust_mail;
	}
	public String getCust_phone() {
		return cust_phone;
	}
	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}

}
