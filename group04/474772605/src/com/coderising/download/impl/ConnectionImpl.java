package com.coderising.download.impl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import com.coderising.download.api.Connection;

public class ConnectionImpl implements Connection {
	public  HttpURLConnection conn = null;
	private static String urlfile = null;
	BufferedInputStream bis = null;
	int len = 0;
	int count = 0;
	byte[] b = new byte[1024];
	InputStream isInputStream=null;

	public byte[] read(int startPos, int endPos) throws IOException {
		byte[] c = new byte[endPos-startPos+1];
		try {
			URL url = new URL(getUrlfile());
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(3000);// 设置连接超时
			conn.setRequestMethod("GET");	
			conn.setRequestProperty("Range", "bytes=" + startPos + "-" +endPos);
			conn.connect();
			isInputStream = conn.getInputStream();
			bis = new BufferedInputStream(isInputStream);
			while ((len = bis.read(b)) != -1) {
			System.arraycopy(b, 0, c, count, len);		
				count += len;
			}
			// fos.write(b);
			bis.close();
			System.out.println("read结束");
			return c;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}

	public int getContentLength() {
		try {
			if (conn.getResponseCode() == 200) {
				return conn.getContentLength();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public void close() {

	}

	public void openConnection(String url1) {
		try {
			this.setUrlfile(url1);
			URL url = new URL(url1);
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(3000);// 设置连接超时
			conn.setRequestMethod("GET");	
		//	conn.setRequestProperty("Range", "bytes=" + 0 + "-" +10240);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getUrlfile() {
		return urlfile;
	}

	public static void setUrlfile(String urlfile) {
		ConnectionImpl.urlfile = urlfile;
	}
}
