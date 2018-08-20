package com.inflearn.oop.abstract_tobe;

import com.inflearn.oop.common.CloudId;

public abstract class CloudFileSystemFactory {
	public static CloudFileSystem getFileSystem(CloudId cloudId) {
		switch (cloudId) {
			case DROPBOX:
				return new DropBoxFileSystem();
			case BOX:
				return new BoxFileSystem();
			default:
				break;
		}

		throw new IllegalArgumentException();
	}
}