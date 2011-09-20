package com.ncrash.code.jackson.rmf.ch4;

public class EncodingProfileVideoSize {

	private int width;
	private int height;

	public EncodingProfileVideoSize(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String toString() {
		return "EncodingProfileVideoSize [width=" + width + ", height="
				+ height + "]";
	}
}
