package com.industrialgroupproject.client.Utils;

import org.springframework.http.HttpStatus;

import com.industrialgroupproject.client.messages.Messages;
public class HttpStatusCodeCheck {

	//needs to be improved
	public static String httpStatusCodeAndResponse(HttpStatus statusCode) {

		switch (statusCode) {
		case CREATED:
		case OK:
			return Messages.SUCCESS;
		default:
			return Messages.ERROR;
		}
	}

}
