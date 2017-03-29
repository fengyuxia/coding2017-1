package com.coderising.download;

import java.io.File;
import java.io.RandomAccessFile;

import com.coderising.download.api.Connection;
import com.coderising.download.api.DownloadListener;

public class DownloadThread extends Thread{

	Connection conn;
	int startPos;
	int endPos;
	File file;
	DownloadListener listener;

	public DownloadThread( Connection conn, int startPos, int endPos,File file,DownloadListener listener){
		
		this.conn = conn;		
		this.startPos = startPos;
		this.endPos = endPos;
		this.file = file;
		this.listener=listener;
	}
	public void run(){		
		System.out.println("创建一个线程");
		try {
			
	        RandomAccessFile out = null;
	        if (file != null)
	        {        
	            out = new RandomAccessFile(file,"rwd");
	        }
	    //   System.out.println("起始位置"+startPos+"结束位置"+endPos);
	        out.seek(startPos);
	    	out.write(conn.read(startPos, endPos));
	        out.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		listener.notifyFinished();
		
	}
}
