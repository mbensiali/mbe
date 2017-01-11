package com.mbe.secondSecurity.utils;

public class HtmlSanitizer {

	public static String sanitize(String unsafeHtml) {
		 return  unsafeHtml.replaceAll("<", "&lt;")
				 .replaceAll(">", "&gt;")
				 .replaceAll("\"", "&quot;")
				 .replaceAll("'", "&apos;");
	}
	
}
