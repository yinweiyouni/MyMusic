package com.ye.mymusic;

import java.util.ArrayList;
import java.util.List;

import com.ye.mymusic.db.MusicList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import utils.MediaStoreMusicList;

public class HomeActivity extends Activity{
	private ListView lv_musiclist;
	private List<MusicList> musiclists;
	private static final String TAG = "HomeActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		/*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

	        int hasWritePermission = checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
	        int hasReadPermission = checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE);

	        List<String> permissions = new ArrayList<String>();
	        if (hasWritePermission != PackageManager.PERMISSION_GRANTED) {
	            permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
	        } else {
	            preferencesUtility.setString("storage", "true");
	        }

	        if (hasReadPermission != PackageManager.PERMISSION_GRANTED) {
	            permissions.add(Manifest.permission.READ_EXTERNAL_STORAGE);

	        } else {
	        	
	            PreferencesUtility.setString("storage", "true");
	        }

	        if (!permissions.isEmpty()) {
	            requestPermissions(permissions.toArray(new String[permissions.size()]), REQUEST_CODE_SOME_FEATURES_PERMISSIONS);
	        }
	    }*/
//		LitePal.getDatabase();
		//从mediastore中获取音乐信息并添加到数组中
		musiclists = new MediaStoreMusicList(this).getMediaStoreMusic();
		List<String> names= new ArrayList<String>();
		for(MusicList music :musiclists){
			names.add(music.getName());
		}
//		names.add("1");
//		names.add("2");
//		names.add("3");
//		names.add("4");
//		names.add("5");
//		names.add("6");
		
		lv_musiclist = (ListView)findViewById(R.id.lv_musiclist);
		lv_musiclist.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names));
		lv_musiclist.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent playintent = new Intent(getApplicationContext(), PlayMusic.class);
				MusicList m=musiclists.get(position);
				playintent.putExtra("musicname",m.getName());
				playintent.putExtra("musicsonger",m.getSonger());
				playintent.putExtra("musicpath",m.getPath());
				startActivity(playintent);
			}
		});
	}

	

}
