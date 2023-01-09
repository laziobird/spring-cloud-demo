package com.mingxinbeijing.agent;
import java.io.IOException;

import com.mingxinbeijing.agent.tool.HttpTool;

public class TestHttp {
	public static void main(String[] args) throws IOException {
		String[] urls = { "https://www.cnblogs.com/lujiango/p/11771319.html", "https://www.jianshu.com/p/4b3986d4640f",
				"https://www.oschina.net/news/107848/okhttp-4-0-0-released",
				"https://www.runoob.com/java/java-generics.html" };

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("正式开始！");
		for (String url : urls) {
			// HttpTool.get(url);
			HttpTool.getAsync(url);
		}

	}
}
