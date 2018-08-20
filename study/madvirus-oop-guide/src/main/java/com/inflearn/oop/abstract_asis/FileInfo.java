package com.inflearn.oop.abstract_asis;

import com.inflearn.oop.common.CloudId;

public class FileInfo {
	private CloudId cloudId;
	private String fileId;
	private String name;
	private long length;

	public void setCloudId(CloudId cloudId) {
		this.cloudId = cloudId;
	}

	public String getFileId() {
		return this.fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public CloudId getCloudId() {
		return this.cloudId;
	}
}
