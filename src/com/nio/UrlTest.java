package com.nio;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class UrlTest {

	/**
	 * @param args
	 * @throws URISyntaxException 
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws URISyntaxException, MalformedURLException {
		// TODO Auto-generated method stub
		URL url = new URL("http://f.hiphotos.baidu.com/image/pic/item/b3b7d0a20cf431adfe3942f34236acaf2fdd9814.jpg");
		File  file  =  new File(url.toURI());
		System.out.println(file.length());
	}

}
