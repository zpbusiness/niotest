package com.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ServerSocketChannel server = ServerSocketChannel.open();
			Selector selector = Selector.open();
			server.socket().bind(new InetSocketAddress(8080));
			server.configureBlocking(false);
			server.register(selector, SelectionKey.OP_ACCEPT);
			while (true) {
				int count = selector.select();
				if (count<1) {
					continue;
				}
				Set<SelectionKey> keys = selector.selectedKeys();
				Iterator<SelectionKey> iterator = keys.iterator();
				while (iterator.hasNext()) {
					SocketChannel client = null;
					SelectionKey key = iterator.next();
					if (key.isValid()&&key.isAcceptable()) {
						client = server.accept();
						client.configureBlocking(false);
						client.register(selector, SelectionKey.OP_READ);
					}else if (key.isValid()&&key.isReadable()) {
						client = (SocketChannel)key.channel();
						//我修改一下
						
					}
					
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
