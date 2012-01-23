package be.khleuven.vanransbeeck.kevin;

import java.io.IOException;
import java.util.Locale;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import com.memetix.mst.translate.Translate;

public class EquityTranslateTextActivity extends EquityActivity implements OnClickListener, TextToSpeech.OnInitListener {
    private TextToSpeech tts;
    private int MY_DATA_CHECK_CODE = 0;
    private String langCode;
    private Button button;
	private String concat = "";
	private String texts = "";
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.translatetext);
		
		Intent callingIntent = getIntent();
		langCode = callingIntent.getStringExtra("langCode");
		// @TODO: enable Speak button if available?
		
		Button button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(this);
		
		Intent checkTTSIntent = new Intent();
		checkTTSIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
		startActivityForResult(checkTTSIntent, MY_DATA_CHECK_CODE);
		
		// @TODO: CHARSET? 
		try {
			Document doc = Jsoup.connect("http://kevin.van-ransbeeck.be/equity/food_1.html").get();
			String css = "<style type=\"text/css\">" +
					"body, html { " +
						"counter-reset: section;" +
						"color: #FFFFFF; " +
						"background-color: #000000;" +
						"font-size: 12px;" +
					"}" +
					"* {" +
					"color: #FFFFFF; " +
					"background-color: #000000;" +
					"font-size: 12px;" +
					"}" +
					"</style>";
			
			concat += css;
			
			Elements body = doc.getElementsByTag("body");
			Elements html = body.get(0).getAllElements();
			for(Element e : html) {
				if(e.tagName().equals("img")) {
					concat += "<img ";
					concat += "src='" + e.attr("src") + "' ";
					concat += "alt='" + e.attr("alt") + "' width='100%'/> ";
				} 
				if(e.tagName().equals("p")) {
					concat += "<p>";
					String text = e.text();
					Translate.setKey("F201136C4151E60657AFB717096F87C70F45EF30");
					try {
						String translatedText = Translate.execute(text, "en-us", langCode);
						concat += translatedText;
						texts += translatedText;
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
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if (requestCode == MY_DATA_CHECK_CODE) {
	        if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
	            tts = new TextToSpeech(this, this);
	        }
	        else {
	            Intent installTTSIntent = new Intent();
	            installTTSIntent.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
	            startActivity(installTTSIntent);
	        }
	    }

	    
	}
	public void onInit(int initStatus) {
		if (initStatus == TextToSpeech.ERROR) {
	        Toast.makeText(this, "Sorry! Text To Speech failed...", Toast.LENGTH_LONG).show();
	    }
	}
	@Override
    public void onDestroy()
    {
        super.onDestroy();
        tts.shutdown();
    }
	public void onClick(View arg0) {
		String[] locCode;
		
		try {
			locCode = langCode.split("-");
		} catch (Exception e) {
			locCode = new String[1];
			locCode[0] = langCode;
		} finally {
		}
		Locale loc;
		if (locCode.length > 1) {
			loc = new Locale(locCode[0], locCode[1].toUpperCase());
		} else {
			loc = new Locale(langCode);
		}
		try {
			if(tts.isLanguageAvailable(loc) >= TextToSpeech.LANG_AVAILABLE) {
				tts.setLanguage(loc);
			} else if(tts.isLanguageAvailable(new Locale(langCode)) >= TextToSpeech.LANG_AVAILABLE) {
				tts.setLanguage(new Locale(langCode));
			} else {
				tts.setLanguage(Locale.ENGLISH);
			}
		} catch (NullPointerException npe) {
			tts.setLanguage(Locale.ENGLISH);
		} 
		tts.speak(texts, TextToSpeech.QUEUE_FLUSH, null);
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onStop() {
		super.onStop();
		tts.shutdown();
	}
	
	

}
