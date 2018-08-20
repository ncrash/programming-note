package com.inflearn.oop.abstract_tobe;

import com.inflearn.oop.common.DbFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BoxFileSystem implements CloudFileSystem {
	private BoxClient boxClient = new BoxClient();

	@Override
	public List<CloudFile> getFiles() {
		List<DbFile> dbFiles = boxClient.getFiles();
		List<CloudFile> results = new ArrayList<>(dbFiles.size());
		for (DbFile dbFile : dbFiles) {
			BoxCloudFile cf = new BoxCloudFile(dbFile, boxClient);
			results.add(cf);
		}
		return results;
	}

	@Override
	public List<CloudFile> search(String query) {
		return null;
	}

	@Override
	public CloudFile getFile(String fileId) {
		return null;
	}

	@Override
	public void addFile(String name, File file) {

	}

	@Override
	public void copyFrom(CloudFile file) {

	}
}
