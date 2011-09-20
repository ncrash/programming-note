package com.ncrash.code.jackson.rmf.ch4;

public class UserPreference {

	private static final long serialVersionUID = 1L;

	private String userId = "";
	private String wmode = "";
	private String content = "";
	private String countondownload = "false";
	private String encoding_notify = "";
	private EncodingProfile encoding_profile;

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param wmode
	 *            the wmode to set
	 */
	public void setWmode(String wmode) {
		this.wmode = wmode;
	}

	/**
	 * @return the wmode
	 */
	public String getWmode() {
		return wmode;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @param countondownload
	 *            the countondownload to set
	 */
	public void setCountondownload(String countondownload) {
		this.countondownload = countondownload;
	}

	/**
	 * @return the countondownload
	 */
	public String getCountondownload() {
		return countondownload;
	}

	public void setEncoding_notify(String encoding_notify) {
		this.encoding_notify = encoding_notify;
	}

	public String getEncoding_notify() {
		return encoding_notify;
	}

	public void setEncoding_profile(EncodingProfile encoding_profile) {
		this.encoding_profile = encoding_profile;
	}

	public EncodingProfile getEncoding_profile() {
		return encoding_profile;
	}

	public String toString() {
		return "UserPreference [userId=" + userId + ", wmode=" + wmode
				+ ", content=" + content + ", countondownload="
				+ countondownload + ", encoding_notify=" + encoding_notify
				+ ", encoding_profile=" + encoding_profile + "]";
	}
}
