package com.inflearn.oop.abstract_asis;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CloudFileManager {
	public List<FileInfo> getFileInfos(CloudId cloudId) {
		if (cloudId == CloudId.DROPBOX) {
			DropboxClient dc = new DropboxClient();
			List<DbFile> dbFiles = dc.getFiles();
			List<FileInfo> result = new ArrayList<>();
			for (DbFile dbFile : dbFiles) {
				FileInfo fi = new FileInfo();
				fi.setCloudId(CloudId.DROPBOX);
				fi.setFileId(fi.getFileId());

				result.add(fi);
			}
			return result;
		} else if (cloudId == CloudId.BOX) {
			BoxService boxSvc = new BoxService();
		}

		return null;
	}

	public void download(FileInfo file, File localTarget) throws IOException {
		if (file.getCloudId() == CloudId.DROPBOX) {
			DropboxClient dc = new DropboxClient();
			FileOutputStream out = new FileOutputStream(localTarget);
			dc.copy(file.getFileId(), out);
			out.close();
		} else if (file.getCloudId() == CloudId.BOX) {
			BoxService boxSvc = new BoxService();
			InputStream is = boxSvc.getInputStream(file.getFileId());
			FileOutputStream out = new FileOutputStream(localTarget);
			CopyUtil.copy(is, out);
		}
	}

	private static class CopyUtil {
		public static void copy(InputStream is, FileOutputStream out) {

		}
	}
}
