package com.bookmarks.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmarks.dto.BookmarkDto;
import com.bookmarks.repository.Bookmark;
import com.bookmarks.repository.BookmarkRepository;

@Service
public class BookmarkServiceImpl implements BookmarkService 
{
	private static final Logger logger = LoggerFactory.getLogger(BookmarkServiceImpl.class);
	
	@Autowired
	private BookmarkRepository bookmarkRepository;
	
	@Override
	public BookmarkDto saveBookMark(BookmarkDto bookmarkDto) 
	{
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Bookmark bookmarkEntity = modelMapper.map(bookmarkDto, Bookmark.class);
		logger.info("bookmarkEntity: "+bookmarkEntity);
		
		Bookmark updatedBookmark = bookmarkRepository.save(bookmarkEntity);
		logger.info("updatedBookmark: "+updatedBookmark);
		
		BookmarkDto updatedBookmarkDto = modelMapper.map(updatedBookmark, BookmarkDto.class);
		logger.info("updatedBookmarkDto: "+updatedBookmarkDto);
		
		return updatedBookmarkDto;
	}

	@Override
	public List<BookmarkDto> findAllBookmarks() 
	{
		 List<Bookmark> bookmarkList = bookmarkRepository.findAll();
		 return bookmarkList.stream().map(bmrk -> {
			 ModelMapper modelMapper = new ModelMapper();
			 modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			 return modelMapper.map(bmrk, BookmarkDto.class);
		 }).collect(Collectors.toList());
	}
}
