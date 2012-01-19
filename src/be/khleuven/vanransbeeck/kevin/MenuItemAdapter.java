package be.khleuven.vanransbeeck.kevin;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuItemAdapter extends ArrayAdapter<String> {
	private final Context context;
	private final String[] values;
	private final Drawable[] images;
	
	public MenuItemAdapter(Context context, String[] values, Drawable[] images) {
		super(context, R.layout.menu_item, values);
		this.context = context;
		this.values = values;
		this.images = images;
	} 
	
	public MenuItemAdapter(Context context, String[] values) {
		this(context, values, null);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View menu_item_view = inflater.inflate(R.layout.menu_item, parent, false);
		
		TextView textView = (TextView) menu_item_view.findViewById(R.id.menu_label);
		ImageView imageView = (ImageView) menu_item_view.findViewById(R.id.menu_icon);
		
		textView.setText(values[position]);
		if(images.length > 0 && images[position] != null) {
			imageView.setImageDrawable(images[position]);
		}
		
		return menu_item_view;
	}
	
	
}
