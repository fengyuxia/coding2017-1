package com.coderising.download;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.coderising.download.api.ConnectionManager;
import com.coderising.download.api.DownloadListener;
import com.coderising.download.impl.ConnectionManagerImpl;

public class FileDownloaderTest {
	boolean downloadFinished = false;
	int i=0;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDownload() {
		
		//String url = "http://27.159.182.56/file3.data.weipan.cn/64284607/e813290a4692f6874794f4723549af329e80e0b0?ip=1489504027,121.204.84.159&ssig=eWRmqE8tUr&Expires=1489504627&KID=sae,l30zoo1wmz&fn=TXT%E5%B0%8F%E8%AF%B4%E4%B8%8B%E8%BD%BD.url&skiprd=2&se_ip_debug=121.204.84.159&corp=2&from=1221134&wsiphost=local";
		String url = "http://pic6.huitu.com/res/20130116/84481_20130116142820494200_1.jpg";
		String filePathString = "src/test.jpg";
		int threadlen =10;
		FileDownloader downloader = new FileDownloader(url,filePathString,threadlen);

	
		ConnectionManager cm = new ConnectionManagerImpl();
		downloader.setConnectionManager(cm);		
		downloader.setListener(new DownloadListener() {
			public void notifyFinished() {
				downloadFinished = true;
				System.out.println("i="+i);
				i++;				
			}

		});

	
		downloader.execute();
		
		// 等待多线程下载程序执行完毕
		while (i!=threadlen) {
	//	while (!downloadFinished) {
			try {
				
				System.out.println("还没有下载完成，休眠五秒");
				//休眠5秒
				Thread.sleep(5000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
		System.out.println("下载完成！");
		
		

	}

}
