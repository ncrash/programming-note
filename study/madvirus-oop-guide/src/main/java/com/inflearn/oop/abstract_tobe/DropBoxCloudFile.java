package com.inflearn.oop.abstract_tobe;

import com.inflearn.oop.abstract_common.DbFile;

import java.io.InputStream;
import java.io.OutputStream;

public class DropBoxCloudFile implements CloudFile {
	private DropBoxClient dbClient;
	private DbFile dbFile;

	public DropBoxCloudFile(DbFile dbFile, DropBoxClient dbClient) {
		this.dbFile = dbFile;
		this.dbClient = dbClient;
	}

	@Override
	public String getId() {
		return dbFile.getId();
	}

	@Override
	public String getName() {
		return dbFile.getFileName();
	}

	@Override
	public Long getLength() {
		return null;
	}

	@Override
	public Boolean hasUrl() {
		return true;
	}

	@Override
	public String getUrl() {
		return dbFile.getFileUrl();
	}

	@Override
	public InputStream getInputStream() {
		return dbClient.createStreamOfFile(dbFile);
	}

	@Override
	public void write(OutputStream out) {

	}

	@Override
	public void delete() {
		dbClient.deleteFile(dbFile.getId());

	}
}
