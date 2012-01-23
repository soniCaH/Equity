package be.khleuven.vanransbeeck.kevin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsItemAdapter extends ArrayAdapter<String> {
	private String[] images;
	private String[] titles;
	private String[] dates;
	private String[] body;
	private Context context;
	
	public NewsItemAdapter(Context context, String[] titles, String[] dates, String[] body, String[] images) {
		super(context, R.layout.news_item, titles);
		this.context = context;
		this.images = images;
		this.titles = titles;
		this.dates = dates;
		this.body = body;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View news_item_view = inflater.inflate(R.layout.news_item, parent, false);
		
		ImageView imageView = (ImageView) news_item_view.findViewById(R.id.news_image);
		try {
            URL myFileUrl = new URL(images[position]);
			HttpURLConnection conn = (HttpURLConnection)myFileUrl .openConnection();
            conn.setDoInput(true);
            conn.connect();
            InputStream is = conn.getInputStream();
            
            Bitmap bmImg = BitmapFactory.decodeStream(is);
            imageView.setImageBitmap(bmImg);
       } catch (IOException e) {
            e.printStackTrace();
       }		
		TextView titleView = (TextView) news_item_view.findViewById(R.id.news_title);
		titleView.setText(titles[position]);
		
		TextView dateView = (TextView) news_item_view.findViewById(R.id.news_timestamp);
		dateView.setText(dates[position]);
		
		String css = "<style type=\"text/css\">" +
				"body, html { " +
					"counter-reset: section;" +
					"color: #FFF; " +
					"background-color: #000000;" +
					"font-size: 10px;" +
				"}" +
				"* {" +
				"color: #FFF; " +
				"background-color: #000000;" +
				"font-size: 10px;" +
				"}" +
				"</style>";
		
		WebView webView = (WebView) news_item_view.findViewById(R.id.news_body);
		webView.setBackgroundColor(R.color.black);
		webView.loadData(css + body[position], "text/html", "UTF-8");
		
//		TextView bodyView = (TextView) news_item_view.findViewById(R.id.news_body);
//		bodyView.setText(body[position]);
		
		return news_item_view;
	}
}
