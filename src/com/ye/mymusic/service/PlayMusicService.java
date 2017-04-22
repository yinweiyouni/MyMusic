package com.ye.mymusic.service;

import java.io.File;
import java.io.IOException;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;

public class PlayMusicService extends Service {
	private String musicpath;
	public PlayMusicService(String musicpath){
		this.musicpath = musicpath;
	}
	public PlayMusicService(){}
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		/**
		 * ���������߼���ͨ��musicpath����·��������󲥷����֣�
		 */
		MediaPlayer player= new MediaPlayer();
		try {
			player.setDataSource(getApplicationContext(), Uri.fromFile(new File(musicpath)));
			player.setVolume(0.5f, 0.5f);
			player.prepare();
			player.start();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		/**
		 * ֹͣ���ֲ��Ų����ٶ���
		 */
	}

	
}
