package cn.longQ.fast;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import cn.longQ.common.utils.FastDFSClient;

public class FastDFStest {
	
	@Test
	public void UpdadeLoadTest() throws Exception {
		ClientGlobal.init("F:/Java web/project/elf-manager-web/src/main/resources/conf/client.conf");
		TrackerClient trackerClient = new TrackerClient();
		TrackerServer trackerServer = trackerClient.getConnection();
		StorageServer storageServer =null;
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		String[] strings = storageClient.upload_file("C:/Users/龍/Desktop/11.jpg", "jpg", null);
		for (String string : strings) {
			System.out.println(string);
		}
	}
	
	@Test
	public void Uploadfiletest() throws Exception {
		FastDFSClient client = new FastDFSClient("F:/Java web/project/elf-manager-web/src/main/resources/conf/client.conf");
		String file = client.uploadFile("C:/Users/龍/Desktop/11.jpg");
		System.out.println(file);
	
	}

}
