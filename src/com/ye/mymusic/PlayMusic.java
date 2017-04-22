package com.ye.mymusic;

import java.io.IOException;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PlayMusic extends Activity {
	private Bundle bundle;
	private String musicpath;
	private MediaPlayer player;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play);
		bundle = getIntent().getExtras();
		// bundle.getString("musicname");
		musicpath = bundle.getString("musicpath");
		player = new MediaPlayer();
		player.setOnCompletionListener(new OnCompletionListener() {

			@Override
			public void onCompletion(MediaPlayer mp) {
				// TODO 自动生成的方法存根
				player.release();
			}
		});
		player.setOnErrorListener(new OnErrorListener() {

			@Override
			public boolean onError(MediaPlayer mp, int what, int extra) {
				player.release();
				return false;
			}
		});
	}

	/**
	 * 播放
	 * 
	 * @param v
	 */
	public void play(View v) {
		try {
			player.reset();
			play();
			// player.setDataSource(this, Uri.fromFile(new File(musicpath)));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void play() {
		try {
			player.setDataSource(musicpath);
			player.setVolume(0.5f, 0.5f);
			player.prepare();
			player.start();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}

	/**
	 * 暂停
	 */
	public void pause(View v) {
		int position = 0;
		if (player.isPlaying()) {
			player.pause();
			position = player.getCurrentPosition();
		} else {
			player.start();
			// player.seekTo(position);
		}
	}

	/**
	 * 重播
	 * 
	 * @param v
	 */
	public void reset(View v) {
		if (player.isPlaying()) {
			player.seekTo(0);
		} else {
			play();
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		player.stop();
		player = null;
	}

	@Override
	protected void onResume() {
		super.onResume();
		Toast.makeText(getApplicationContext(), "rein", 1).show();
	}

}
