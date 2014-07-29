/*
Copyright 2012 Aphid Mobile

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
 
   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package com.aphidmobile.flip.demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.*;
import android.widget.*;

import com.aphidmobile.flip.FlipViewController;
import com.aphidmobile.flipview.demo.R;
import com.aphidmobile.utils.AphidLog;
import com.aphidmobile.utils.IO;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
	private FlipViewController flipView;
	

	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setTitle(R.string.activity_title);

		flipView = new FlipViewController(this);

		flipView.setAdapter(new MyBaseAdapter(this));

		setContentView(flipView);
		
		
		
		
		 LinearLayout bt1 = (LinearLayout)findViewById(R.id.bt1); 
		    LinearLayout bt2 = (LinearLayout)findViewById(R.id.bt2); 
		    LinearLayout bt3 = (LinearLayout)findViewById(R.id.bt3); 
		    LinearLayout bt4 = (LinearLayout)findViewById(R.id.bt4); 
		    LinearLayout bt5 = (LinearLayout)findViewById(R.id.bt5); 
	        bt1.setClickable(true); 

			
			
			bt1.setOnClickListener(new View.OnClickListener(){
				
				
				  public void onClick(View v) { 
			            // TODO Auto-generated method stub 
			            Toast.makeText(getApplicationContext(), "正在进入", Toast.LENGTH_LONG).show(); 
			            
			            Intent intent=new Intent();
			            intent.setClass(MainActivity.this, NewActivity.class);//页面跳转

			            MainActivity.this.startActivity(intent);//点击button时便跳到第二个界面了。
			            finish();
			            
			            
			            
			            
			        } 
				
			                     });

			            
			            
	


			
		

		
			
			
			
			
			
			
			
			
		
		
		
		
		
		
		
	}

	@Override
	protected void onResume() {
		super.onResume();
		flipView.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
		flipView.onPause();
	}

	private static class MyBaseAdapter extends BaseAdapter {
		private static List<Data> IMG_DESCRIPTIONS = new ArrayList<Data>();

		static {
			IMG_DESCRIPTIONS.add(new Data("", "", "", "The <b>Potala Palace</b> is located in Lhasa, Tibet Autonomous Region, China. It is named after Mount Potalaka, the mythical abode of Chenresig or Avalokitesvara.","catch1.PNG","catch2.PNG","catch3.PNG","catch4.PNG","catch5.PNG"));
		    IMG_DESCRIPTIONS.add(new Data("", "", "", "<b>Drepung Monastery</b>, located at the foot of Mount Gephel, is one of the \"great three\" Gelukpa university monasteries of Tibet.","001.jpg","002.jpg","003.jpg","004.jpg","005.jpg"));
			IMG_DESCRIPTIONS.add(new Data("", "", "", "<b>Sera Monastery</b> is one of the 'great three' Gelukpa university monasteries of Tibet, located 1.25 miles (2.01 km) north of Lhasa.","1","2","3","4","5"));
			IMG_DESCRIPTIONS.add(new Data("", "", "", "<b>Samye Monastery</b> is the first Buddhist monastery built in Tibet, was most probably first constructed between 775 and 779 CE.","1","2","3","4","5"));
			IMG_DESCRIPTIONS.add(new Data("", "", "", "<b>Tashilhunpo Monastery</b>, founded in 1447 by Gendun Drup, the First Dalai Lama, is a historic and culturally important monastery next to Shigatse, the second-largest city in Tibet.","1","2","3","4","5"));
			IMG_DESCRIPTIONS.add(new Data("", "", "", "<b>Zhangmu/Dram</b> is a customs town and port of entry located in Nyalam County on the Nepal-China border, just uphill and across the Bhote Koshi River from the Nepalese town of Kodari.","1","2","3","4","5"));
			IMG_DESCRIPTIONS.add(new Data("", "", "", "<b>Pokhara Sub-Metropolitan City</b> is the second largest city of Nepal with approximately 250,000 inhabitants and is situated about 200 km west of the capital Kathmandu.","1","2","3","4","5"));
			IMG_DESCRIPTIONS.add(new Data("", "", "", "<b>Patan</b>, officially Lalitpur Sub-Metropolitan City, is one of the major cities of Nepal located in the south-central part of Kathmandu Valley.","1","2","3","4","5"));
		}

		private LayoutInflater inflater;

		private MyBaseAdapter(Context context) {
			inflater = LayoutInflater.from(context);
		}

		@Override
		public int getCount() {
			return IMG_DESCRIPTIONS.size();
		}

		@Override
		public Object getItem(int position) {
			return position;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View layout = convertView;
			if (convertView == null)
				layout = inflater.inflate(R.layout.complex1, null);

			final Data data = IMG_DESCRIPTIONS.get(position);
			
			TextView titleView = (TextView) layout.findViewById(R.id.title);
			titleView.setText(AphidLog.format("%d. %s", position, data.title));
			
			ImageView photoView = (ImageView) layout.findViewById(R.id.photo);
			photoView.setImageBitmap(IO.readBitmap(inflater.getContext().getAssets(), data.imageFilename));
			
			TextView textView = (TextView) layout.findViewById(R.id.description);
			textView.setText(Html.fromHtml(data.description));
			
			

			ImageView photoView1 = (ImageView) layout.findViewById(R.id.btt1);
			photoView1.setImageBitmap(IO.readBitmap(inflater.getContext().getAssets(), data.btt1));
			
			ImageView photoView2 = (ImageView) layout.findViewById(R.id.btt2);
			photoView2.setImageBitmap(IO.readBitmap(inflater.getContext().getAssets(), data.btt2));
			ImageView photoView3 = (ImageView) layout.findViewById(R.id.btt3);
			photoView3.setImageBitmap(IO.readBitmap(inflater.getContext().getAssets(), data.btt3));
			ImageView photoView4 = (ImageView) layout.findViewById(R.id.btt4);
			photoView4.setImageBitmap(IO.readBitmap(inflater.getContext().getAssets(), data.btt4));
			ImageView photoView5 = (ImageView) layout.findViewById(R.id.btt5);
			photoView5.setImageBitmap(IO.readBitmap(inflater.getContext().getAssets(), data.btt5));
			
			
			Button wikipedia = (Button) layout.findViewById(R.id.wikipedia);
			wikipedia.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(
						Intent.ACTION_VIEW,
						Uri.parse(data.link)
					);
					inflater.getContext().startActivity(intent);
				}
			});
			
			return layout;
		}

		private static class Data {
			public String title;
			public String imageFilename;
			public String link;
			public String description;
			public String btt1;
			public String btt2;
			public String btt3;
			public String btt4;
			public String btt5;
			
			private Data(String title, String imageFilename, String link, String description,String btt1,String btt2,String btt3,String btt4,String btt5) {
				this.title = title;
				this.imageFilename = imageFilename;
				this.link = link;
				this.description = description;
				this.btt1 = btt1;
				this.btt2 = btt2;
				this.btt3 = btt3;
				this.btt4 = btt4;
				this.btt5 = btt5;
				
			}
		}
	}
	 public void onBackPressed() {  
	        // do something what you want  
	        super.onBackPressed();  
	    }  
	 
	 
	 
	 
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
