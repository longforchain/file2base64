package com.longfor.base64;

public enum MIMEType {

	asf("asf", "video/x-ms-asf"), threegp("3gp", "video/3gpp"), avi("avi",
			"video/x-msvideo"), m4u("m4u", "video/vnd.mpegurl"), m4v("m4v",
			"video/x-m4v"), mov("mov", "video/quicktime"),
	// mp4 统一使用mp4
	mp4("mp4", "video/mp4"), mpg4("mpg4", "video/mp4"),

	mpe("mpe", "video/x-mpeg"),
	// mpeg 使用相应的默认程序打开，但不添加文件拓展名
	mpeg("mpeg", "video/mpg"), mpg("mpg", "video/mpg"),

	// audio
	m3u("m3u", "audio/x-mpegurl"),
	// mp4a-latm 使用相应的默认程序打开，但不添加文件拓展名
	m4a("m4a", "audio/mp4a-latm"), m4b("m4b", "audio/mp4a-latm"), m4p("m4p",
			"audio/mp4a-latm"),

	// x-mpeg
	mp2("mp2", "x-mpeg"), mp3("mp3", "audio/x-mpeg"),

	mpga("mpga", "audio/mpeg"), ogg("ogg", "audio/ogg"), rmvb("rmvb",
			"audio/x-pn-realaudio"), wav("wav", "audio/x-wav"), wma("wma",
			"audio/x-ms-wma"), wmv("wmv", "audio/x-ms-wmv"),

	c("c", "text/plain"), java("java", "text/plain"), conf("conf", "text/plain"), cpp(
			"cpp", "text/plain"), h("h", "text/plain"), prop("prop",
			"text/plain"), rc("rc", "text/plain"), sh("sh", "text/plain"), log(
			"log", "text/plain"), txt("txt", "text/plain"), xml("xml",
			"text/plain"),

	// 统一使用html
	html("html", "text/html"), htm("htm", "text/html"),

	css("css", "text/css"),

	// image
	// jpeg统一使用jpg
	jpg("jpg", "image/jpeg"), jpeg("jpeg", "image/jpeg"),

	bmp("bmp", "image/bmp"), gif("gif", "image/gif"), png("png", "image/png"),

	// application
	bin("bin", "application/octet-stream"), exe("exe",
			"application/octet-stream"),

	apk("apk", "application/vnd.android.package-archive"), doc("doc",
			"application/msword"), docx("docx",
			"application/vnd.openxmlformats-officedocument.wordprocessingml.document"), xls(
			"xls", "application/vnd.ms-excel"), xlsx("xlsx",
			"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"),

	gtar("gtar", "application/x-gtar"), gz("gz", "application/x-gzip"), jar(
			"jar", "application/java-archive"), js("js",
			"application/x-javascript"), mpc("mpc",
			"application/vnd.mpohun.certificate"), msg("msg",
			"application/vnd.ms-outlook"), pdf("pdf", "application/pdf"), pps(
			"pps", "application/vnd.ms-powerpoint"), ppt("ppt",
			"application/vnd.ms-powerpoint"),

	pptx("pptx",
			"application/vnd.openxmlformats-officedocument.presentationml.presentation"), rtf(
			"rtf", "application/rtf"), tar("tar", "application/x-tar"), tgz(
			"tgz", "application/x-compressed"), wps("wps",
			"application/vnd.ms-works"), z("z", "application/x-compress"), zip(
			"zip", "application/x-zip-compressed");

	private String suffix;
	private String contentType;

	MIMEType(String suffix, String contentType) {
		this.suffix = suffix;
		this.contentType = contentType;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public static String getSuffixOfContentType(String contentType) {
		MIMEType[] tps = MIMEType.values();
		for(MIMEType type :tps)
		{
			if(type.getContentType().equalsIgnoreCase(contentType))
			{
				return type.getSuffix();
			}
		}
		return null;
	}

	public static String getContentTypeOfSuffix(String suffix) {
		MIMEType[] tps = MIMEType.values();
		for(MIMEType type :tps)
		{
			if(type.getSuffix().equalsIgnoreCase(suffix))
			{
				return type.getContentType();
			}
		}
		return "image/*";
	}
	
	
	

}
