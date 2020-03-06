package com.uttesh.exude.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author uttesh
 *
 */
public class ExudeBean {

	String data = null;
	List<String> links = new ArrayList<>();

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public List<String> getLinks() {
		return links;
	}

	public void setLinks(List<String> links) {
		this.links = links;
	}

}
