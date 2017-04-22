package com.ye.mymusic.db;

import org.litepal.crud.DataSupport;


public class MusicList extends DataSupport {

	private String name;
	private String songer;
	private String path;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSonger() {
		return songer;
	}
	public void setSonger(String songer) {
		this.songer = songer;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public MusicList(String name, String songer, String path) {
		super();
		this.name = name;
		this.songer = songer;
		this.path = path;
	}
	public MusicList() {
	}
}
