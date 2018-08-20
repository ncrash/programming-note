package com.inflearn.oop.abstract_tobe;

import java.io.InputStream;
import java.io.OutputStream;

public interface CloudFile {
	String getId();

	String getName();

	Long getLength();

	Boolean hasUrl();

	String getUrl();

	InputStream getInputStream();

	void write(OutputStream out);

	void delete();
}
