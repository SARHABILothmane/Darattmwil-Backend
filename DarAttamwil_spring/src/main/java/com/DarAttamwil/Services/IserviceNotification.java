package com.DarAttamwil.Services;

public interface IserviceNotification {
//	public void sendmail(int id) ;
	public void sendEmail(String email , String subject, String html);
}
