package com.inflearn.oop.abstract_asis;

import com.inflearn.oop.abstract_common.CloudId;
import com.inflearn.oop.abstract_common.DbFile;

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
		} else if (cloudId == CloudId.SCLOUD) {

		} else if (cloudId == CloudId.NCLOUD) {

		} else if (cloudId == CloudId.DCLOUD) {

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

	public FileInfo copy(FileInfo fileInfo, CloudId to) {
		CloudId from = fileInfo.getCloudId();
		if (to == CloudId.DROPBOX) {
			DropboxClient dropboxClient = new DropboxClient();
			if (from == CloudId.BOX) {
				dropboxClient.copyFromUrl("http://www.box.com/files/"+fileInfo.getFileId());
			} else if (from == CloudId.SCLOUD) {
				dropboxClient.copyFromUrl("http://www.scloud.com/files/"+fileInfo.getFileId());
			} else if (from == CloudId.DCLOUD) {
				dropboxClient.copyFromUrl("http://www.dcloud.com/files/"+fileInfo.getFileId());
			} else if (from == CloudId.NCLOUD) {
				dropboxClient.copyFromUrl("http://www.ncloud.com/files/"+fileInfo.getFileId());
			}
		}

		return null;
	}

	private static class CopyUtil {
		public static void copy(InputStream is, FileOutputStream out) {

		}
	}
}
