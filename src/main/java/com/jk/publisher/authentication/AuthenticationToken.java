package com.jk.publisher.authentication;

import java.util.ArrayList;
import java.util.List;

public class AuthenticationToken {
	private List<String> privileges = new ArrayList();
	
	public List<String> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<String> privileges) {
		this.privileges = privileges;
	}

	public AuthenticationToken (List<String> privileges) {
		this.privileges = privileges;
	}
	
	@Override
	public String toString() {
		String json = "AuthenticationToken { privileges: [";
		for(String privilege: privileges) {
			json += privilege + ", ";
		}
		
		json = json.substring(0, json.length()-1) + "] }";
		return json;
	}
}
