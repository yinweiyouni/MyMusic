package com.ye.mymusic.db.dao;

import java.util.List;

import com.ye.mymusic.db.MusicList;

import android.content.Context;
import utils.MediaStoreMusicList;

public class MusicListDao {
	private Context context;
	public MusicListDao(Context context){
		this.context = context;
	}
	public void save(){
		List<MusicList> lists = new MediaStoreMusicList(context).getMediaStoreMusic();
		for(MusicList music : lists){
			music.save();
		}
	}
}
