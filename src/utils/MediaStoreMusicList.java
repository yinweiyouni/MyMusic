package utils;

import java.util.ArrayList;
import java.util.List;

import com.ye.mymusic.db.MusicList;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

public class MediaStoreMusicList {
	private ContentResolver resolver;
	private String name = MediaStore.Audio.Media.TITLE;
	private String songer = MediaStore.Audio.Media.ARTIST;
	private String path= MediaStore.Audio.Media.DATA;
//	private Context context;

	public MediaStoreMusicList(Context context) {
		resolver = context.getContentResolver();
	}

	/**
	 * ��androidϵͳ�ṩ��mediastore�����ṩ���л�ȡ�ֻ��е�������Ϣ������musiclist����
	 * 
	 * @return
	 */
	public List<MusicList> getMediaStoreMusic() {
		List<MusicList> lists =new ArrayList<MusicList>();
		Cursor corsor =  resolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,null, null, null, null);
		while(corsor.moveToNext()){
			String title=corsor.getString(corsor.getColumnIndexOrThrow(name));
			String artist =  corsor.getString(corsor.getColumnIndexOrThrow(name));
			String data = corsor.getString(corsor.getColumnIndexOrThrow(path));
			lists.add(new MusicList(title,artist,data));
		}
		return lists;
	}
}
