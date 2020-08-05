package com.bookmarks.controller;



import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.bookmarks.dto.BookmarkDto;
import com.bookmarks.service.BookmarkService;
import com.bookmarks.ui.request.model.BookmarkReqModel;

@Controller
public class BookMarksController implements WebMvcConfigurer
{
	private static final Logger logger = LoggerFactory.getLogger(BookMarksController.class);
	
	@Autowired
	private BookmarkService bookmarkService;
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/results").setViewName("bookmarkview");
	}
	
	@GetMapping("/")
	public String displayBookmarksForm(Model model) {
		model.addAttribute("bookmark", new BookmarkReqModel());
		return "index";
	}
	
	@PostMapping("/addBookmark")
	public String addBookMarks(@Valid @ModelAttribute(name = "bookmark") BookmarkReqModel bookmark, 
			BindingResult result, ModelMap model) {
		logger.info("bookmark: "+bookmark);
        if (result.hasErrors()) {
            return "index";
        }
        
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        BookmarkDto bookmarkDto = modelMapper.map(bookmark, BookmarkDto.class);
        logger.info("bookmarkDto: " +bookmarkDto);
        
        BookmarkDto updatedBookmarkDto = bookmarkService.saveBookMark(bookmarkDto);
        model.addAttribute("id",updatedBookmarkDto.getId());
        model.addAttribute("name",updatedBookmarkDto.getName());
        model.addAttribute("url",updatedBookmarkDto.getUrl());
        model.addAttribute("category",updatedBookmarkDto.getCategory());
        model.addAttribute("notes",updatedBookmarkDto.getNotes());
        //return "redirect:/results"
        return "bookmarkview";
	}
	
	@GetMapping("/getAllBookmarks")
	public String getBookmarks(Model model) {
		List<BookmarkDto> bookmarkList = bookmarkService.findAllBookmarks();
		model.addAttribute("bookmarksList",bookmarkList);
		return "bookmarkslist";
	}
	
	
	
}
