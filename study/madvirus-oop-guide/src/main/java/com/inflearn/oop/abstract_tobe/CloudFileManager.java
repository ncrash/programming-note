package com.inflearn.oop.abstract_tobe;

import com.inflearn.oop.common.CloudId;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class CloudFileManager {
	public List<CloudFile> getFileInfos(CloudId cloudId) {
		CloudFileSystem fileSystem = CloudFileSystemFactory.getFileSystem(cloudId);
		return fileSystem.getFiles();
	}

	public void download(CloudFile file, File localTarget) throws FileNotFoundException {
		file.write(new FileOutputStream(localTarget));
	}

	public void copy(CloudFile file, CloudId target) {
		CloudFileSystem fileSystem = CloudFileSystemFactory.getFileSystem(target);

		fileSystem.copyFrom(file);
	}
}
