package com.mucheniski.mongodbspringboot.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {

	public static String decoreParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("Erro no URL: " + e);
			return "";
		}
	}
	
}
