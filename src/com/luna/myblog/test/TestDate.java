package com.luna.myblog.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {
public static void main(String[] args) throws ParseException {
	Date date = new Date();
	System.out.println(date.toLocaleString());
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//小写的mm表示的是分钟  
	String dstr="2008-4-24";  
	java.util.Date mydate=sdf.parse(dstr);  
	
	SimpleDateFormat ssf=new SimpleDateFormat("yyyy-MM-dd");  
	java.util.Date mydate1=new java.util.Date();  
	String str=ssf.format(date);  
	System.out.println(date.toString());
}
}
