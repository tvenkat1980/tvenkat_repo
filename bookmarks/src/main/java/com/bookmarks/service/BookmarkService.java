package com.bookmarks.service;

import java.util.List;

import com.bookmarks.dto.BookmarkDto;

public interface BookmarkService {

	public BookmarkDto saveBookMark(BookmarkDto bookmarkDto);
	
	public List<BookmarkDto> findAllBookmarks();
}
