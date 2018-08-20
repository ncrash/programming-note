package com.inflearn.oop.abstract_asis;

import java.io.IOException;
import java.io.InputStream;

public class BoxService {
	public InputStream getInputStream(String fileId) {
		return new InputStream() {
			@Override
			public int read() throws IOException {
				return 0;
			}
		};
	}
}
