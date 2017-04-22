package com.ye.mymusic.test;

import java.util.List;

import com.ye.mymusic.db.MusicList;

import android.test.AndroidTestCase;
import utils.MediaStoreMusicList;

public class MediaStoreTest extends AndroidTestCase{

	public void musiclisttest(){
		MediaStoreMusicList lists =new MediaStoreMusicList(MediaStoreTest.this.getContext());
		List<MusicList> musiclists = lists.getMediaStoreMusic();
		for(MusicList music :musiclists){
			System.out.println(music.getName());
		}
	}
}
