package com.industrialgroupproject.client.exceptions;

public class CompanyCertificationSelfDocumentsErrorResponse {

		private int status;
		private String message;
		private long timeStamp;

		public CompanyCertificationSelfDocumentsErrorResponse() {

		}

		public CompanyCertificationSelfDocumentsErrorResponse(int status, String message, long timeStamp) {
			this.status = status;
			this.message = message;
			this.timeStamp = timeStamp;
		}

		public CompanyCertificationSelfDocumentsErrorResponse(int status) {
			this.status = status;
		}

		public int getStatus() {
			return this.status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public String getMessage() {
			return this.message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public long getTimeStamp() {
			return this.timeStamp;
		}

		public void setTimeStamp(long timeStamp) {
			this.timeStamp = timeStamp;
		}
}
