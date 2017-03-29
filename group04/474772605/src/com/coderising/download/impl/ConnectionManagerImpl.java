package com.coderising.download.impl;


import com.coderising.download.api.Connection;
import com.coderising.download.api.ConnectionException;
import com.coderising.download.api.ConnectionManager;

public class ConnectionManagerImpl implements ConnectionManager {

	public Connection open(String url) throws ConnectionException {
		ConnectionImpl connectionImpl = new ConnectionImpl();
		connectionImpl.openConnection(url);
		return connectionImpl;
	}

}
