package be.khleuven.vanransbeeck.kevin;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import com.memetix.mst.translate.Translate;

public class EquityTranslateTextActivity extends EquityActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.translatetext);
		
		Intent callingIntent = getIntent();
		String langCode = callingIntent.getStringExtra("langCode");
		// @TODO: enable Speak button if available?
		
		// @TODO: CHARSET? 
		String concat = "";
		try {
			Document doc = Jsoup.connect("http://kevin.van-ransbeeck.be/equity/help.html").get();
			Element head = doc.head();
			String css = "<style type=\"text/css\">" +
					"body, html { " +
						"counter-reset: section;" +
						"color: #FFFFFF; " +
						"background-color: #000000;" +
						"font-size: 10px;" +
					"}" +
					"* {" +
					"color: #FFFFFF; " +
					"background-color: #000000;" +
					"font-size: 10px;" +
					"}" +
					"</style>";
			
			concat += css;
			
			Elements body = doc.getElementsByTag("body");
			Elements html = body.get(0).getAllElements();
			for(Element e : html) {
				if(e.tagName().equals("img")) {
					concat += e.html();
				} 
				if(e.tagName().equals("p")) {
					concat += "<p>";
					String text = e.text();
					Translate.setKey("F201136C4151E60657AFB717096F87C70F45EF30");
					try {
						String translatedText = Translate.execute(text, "en-us", langCode);
						concat += translatedText;
					} catch (Exception exc) {
						concat +="Unable to contact translation server";
					}
					concat += "</p>";
				}
			}
			
		} catch (IOException e) {
		} finally {
			WebView webView = (WebView) findViewById(R.id.webView1);
			webView.setBackgroundColor(R.color.black);
			webView.loadData(concat, "text/html", "UTF-8");
		}
		
		System.out.println(concat);
	}
}
