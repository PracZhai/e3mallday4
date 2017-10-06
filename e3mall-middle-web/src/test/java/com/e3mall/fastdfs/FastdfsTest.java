package com.e3mall.fastdfs;

import static org.junit.Assert.*;
import java.io.FileOutputStream;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import com.e3mall.utils.FastDFSClient;

public class FastdfsTest {
	
	/**
	 * 上传图片
	 * @throws Exception
	 */
	@Test
	public void upload() throws Exception {
		//加载配置文件
		ClientGlobal.init("E:/JavaEE/Tools/eclipseworkSpacePro2/e3mall-middle-web/src/main/resources/conf/client.conf");
		//创建trackerClient对象
		TrackerClient trackerClient = new TrackerClient();
		//创建trackerServer对象
		TrackerServer trackerServer = trackerClient.getConnection();
		//创建storageClient对象
		StorageServer storageServer = null;
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		//上传文件
		//参数返回文件的路径及文件名、文件后缀、元数据
		String[] upload_file = storageClient.upload_file("C:/Users/Administrator/Desktop/1.jpg", "jpg", null);
		//打印返回信息
		for (String string : upload_file) {
			System.out.println(string);
		}
	}
	
	/**
	 * 下载图片
	 */
	
	@Test
	public void downLoad() throws Exception {
		//加载配置文件
		ClientGlobal.init("E:/JavaEE/Tools/eclipseworkSpacePro2/e3mall-middle-web/src/main/resources/conf/client.conf");
		//创建trackerClient对象
		TrackerClient trackerClient = new TrackerClient();
		//创建trackerServer对象
		TrackerServer trackerServer = trackerClient.getConnection();
		//创建storageClient
		StorageServer storageServer = null;
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		byte[] download_file = storageClient.download_file("group1", "M00/00/00/wKgZhVnMrxqAH8VDAALNBR7ceVw660.jpg");
		FileOutputStream fileOutputStream = new FileOutputStream("d:/1.jpg");
		fileOutputStream.write(download_file);
		fileOutputStream.close();
	}
	
	/**
	 * 使用工具类上传图片
	 * @throws Exception 
	 */
	@Test
	public void testUtils() throws Exception{
		FastDFSClient fastDFSClient = new FastDFSClient("E:/JavaEE/Tools/eclipseworkSpacePro2/e3mall-middle-web/src/main/resources/conf/client.conf");
		String uploadFile = fastDFSClient.uploadFile("C:/Users/Administrator/Desktop/1.jpg");
		System.out.println(uploadFile);
	}
}
