package com.hxh.jdsearch.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class HtmlParseUtil {
    public static void main(String[] args) throws IOException {
        String url = "https://search.jd.com/Search?keyword=python";

        Document document = Jsoup.parse(new URL(url), 30000);  //返回Document浏览器对象
        Element element = document.getElementById("J_goodsList");

    }
}
