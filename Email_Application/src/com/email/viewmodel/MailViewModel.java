package com.email.viewmodel;

import java.io.IOException;

import com.email.dto.Repository;
import com.email.view.MailView;

public class MailViewModel {
	
	Repository repository = Repository.getInstance();
	public MailViewModel(String from,String to,String content,String tagName) throws IOException{
		if(validate(from,to)) {
			repository.addMail(from+" ", to+" ", content+" ",tagName);	
		}else {
			MailView.invalidMailId();
		}
	}
	private boolean validate(String from, String to) {
		return true;
	}
}
