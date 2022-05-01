package com.hxh.jdsearch.utils;

import com.hxh.jdsearch.pojo.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
public class HtmlParseUtil {
    public static void main(String[] args) throws Exception {
        new HtmlParseUtil().parseJD("中文").forEach(System.out::println);
    }
    public List<Content> parseJD(String keywords) throws Exception {
        String url = "https://search.jd.com/Search?keyword=" + keywords;
        Document document = Jsoup.parse(new URL(url), 30000);  //返回Document浏览器对象
        Element goodsElement = document.getElementById("J_goodsList");
        Elements liElement = goodsElement.getElementsByTag("li");
        ArrayList<Content> goodsList = new ArrayList<>();
        for (Element el: liElement) {
            String img = el.getElementsByTag("img").eq(0).attr("data-lazy-img");
            String price = el.getElementsByClass("p-price").eq(0).text();
            String title = el.getElementsByClass("p-name").eq(0).text();
            Content content = new Content(img, price, title);
            goodsList.add(content);
        }
        return goodsList;
    }
}
