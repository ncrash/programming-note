package com.inflearn.oop.abstract_tobe;

import com.inflearn.oop.common.DbFile;

import java.io.InputStream;
import java.io.OutputStream;

public class BoxCloudFile implements CloudFile {
	public BoxCloudFile(DbFile dbFile, BoxClient boxClient) {

	}

	@Override
	public String getId() {
		return null;
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public Long getLength() {
		return null;
	}

	@Override
	public Boolean hasUrl() {
		return null;
	}

	@Override
	public String getUrl() {
		return null;
	}

	@Override
	public InputStream getInputStream() {
		return null;
	}

	@Override
	public void write(OutputStream out) {

	}

	@Override
	public void delete() {

	}
}
