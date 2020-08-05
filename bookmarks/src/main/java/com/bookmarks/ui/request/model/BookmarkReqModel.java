package com.bookmarks.ui.request.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class BookmarkReqModel {
	@NotEmpty
	@Size(min = 2, max = 30)
	private String name;

	@NotEmpty
	private String url;

	@NotEmpty
	@Size(min = 2, max = 10)
	private String category;

	private String notes;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "BookmarkReqModel [name=" + name + ", url=" + url + ", category=" + category + ", notes=" + notes + "]";
	}
}
