package be.khleuven.vanransbeeck.kevin;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParserException;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class EquityNewsActivity extends EquityActivity {
	private ListView newsList;
	private String[] arrTitles;
	private String[] arrImages;
	private String[] arrPubDates;
	private String[] arrBody;
	
	
	private NewsDownloaderTask newsDownloaderTask;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.news);
		String path = "http://kevin.van-ransbeeck.be/equity/feed.xml";
		
		newsDownloaderTask = new NewsDownloaderTask();
		newsDownloaderTask.execute(path);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.eqoptions, menu);
		menu.findItem(R.id.help_menu_item).setIntent(new Intent(this, EquityHelpActivity.class));
		menu.findItem(R.id.settings_menu_item).setIntent(new Intent(this, EquitySettingsActivity.class));
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		super.onOptionsItemSelected(item);
		startActivity(item.getIntent());
		return true;
	}	
	
	private class NewsDownloaderTask extends AsyncTask<Object, String, Boolean> {
		ProgressDialog pleaseWaitDialog;
		@Override
		protected void onPreExecute() {
			pleaseWaitDialog = ProgressDialog.show(
					EquityNewsActivity.this,
					getString(R.string.waiting_news_title),
					getString(R.string.waiting_news_text),
					true);
		}
		@Override
		protected void onPostExecute(Boolean result) {
			newsList = (ListView) findViewById(R.id.ListView_News);
			NewsItemAdapter adapt = new NewsItemAdapter(EquityNewsActivity.this, arrTitles, arrPubDates, arrBody, arrImages);
			newsList.setAdapter(adapt);
			pleaseWaitDialog.dismiss();
		}
		@Override
		protected Boolean doInBackground(Object... params) {
			boolean result = false;
			try {
				URL feedUrl = new URL((String)params[0]);			
				processNews(feedUrl);
			} catch(IOException io) {
				io.printStackTrace();
			} catch (XmlPullParserException e) {
				e.printStackTrace();
			} finally {
			}
			return result;
		}
		
		private void processNews(URL feedXml) throws XmlPullParserException, IOException {
			int newsItems = 0;
			ArrayList<String> titles = new ArrayList<String>();
			ArrayList<String> pubDates = new ArrayList<String>();
			ArrayList<String> body = new ArrayList<String>();
			ArrayList<String> images = new ArrayList<String>();
	        InputStream stream = feedXml.openStream();
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db;
			
			try {
				db = dbf.newDocumentBuilder();		
				Document doc = db.parse(stream);
				
				Element e = doc.getDocumentElement();
				NodeList nodeList = doc.getElementsByTagName("item");
				
				for(int i = 0; i < nodeList.getLength(); i++) {
					Node node = nodeList.item(i);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						Element element = (Element) node;
						NodeList itemList = element.getChildNodes();
						for(int j = 0; j < itemList.getLength(); j++) {
							Node n = itemList.item(j);
							if (n.getNodeType() == Node.ELEMENT_NODE) {
								Element el = (Element) n;
								String value = el.getTextContent();
								String title = el.getNodeName();
								if(title.equalsIgnoreCase("title")) {
									titles.add(value);
								}
								if(title.equalsIgnoreCase("pubDate")) {
									pubDates.add(value);
								}
								if(title.equalsIgnoreCase("image")) {
									images.add(value);
								}
								if(title.equalsIgnoreCase("description")) {
									body.add(value);
								}
							}
						}
					}
				}
			} catch (ParserConfigurationException e) {
			} catch (SAXException e) {
			}
			
			
			publishNews(newsItems, titles, images, pubDates, body);
		}
		private void publishNews(int newsItems, ArrayList<String> titles,
				ArrayList<String> images, ArrayList<String> pubDates,
				ArrayList<String> body) {
			arrTitles = titles.toArray(new String[newsItems]);
			arrImages = images.toArray(new String[newsItems]);
			arrPubDates = pubDates.toArray(new String[newsItems]);
			arrBody = body.toArray(new String[newsItems]);
		}
		
	}
}
