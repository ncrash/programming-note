package com.inflearn.oop.abstract_tobe;

import java.io.File;
import java.util.List;

public interface CloudFileSystem {

	List<CloudFile> getFiles();

	List<CloudFile> search(String query);

	CloudFile getFile(String fileId);

	void addFile(String name, File file);

	void copyFrom(CloudFile file);
}
