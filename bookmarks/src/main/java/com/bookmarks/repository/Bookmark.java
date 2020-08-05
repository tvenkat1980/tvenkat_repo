package com.bookmarks.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK_MARKS")
public class Bookmark {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "BKMRK_NAME")
	private String name;

	@Column(name = "BKMRK_URL")
	private String url;

	@Column(name = "BKMRK_CATEGORY")
	private String category;

	@Column(name = "BKMRK_NOTES")
	private String notes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
		return "Bookmark [id=" + id + ", name=" + name + ", url=" + url + ", category=" + category + ", notes=" + notes
				+ "]";
	}

}
