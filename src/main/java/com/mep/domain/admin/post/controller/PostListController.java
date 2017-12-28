package com.mep.domain.admin.post.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mep.domain.admin.post.dto.PostDto;
import com.mep.domain.admin.post.dto.PostListDto;
import com.mep.domain.admin.post.service.PostInitService;
import com.mep.domain.admin.post.service.PostListService;

@Controller
@RequestMapping("/admin/*")
public class PostListController extends PostControllerHelper {

	private static final String INIT_PATH = "admin/post/postList";

	private static final String POST_DTO = "postDto";

	@Autowired
	private PostInitService postInitService;

	@Autowired
	private PostListService postListService;

	@GetMapping(value = "/post")
	public ModelAndView init() {

		ModelAndView mav = new ModelAndView(INIT_PATH);

		PostDto postDto = new PostDto();

		postDto = setCategoryDropdownToPostDtoObject(postInitService, postDto);

		mav.addObject(POST_DTO, postDto);

		return mav;
	}

	@PostMapping(value = "/post/search")
	public @ResponseBody ModelAndView postSearch(
			@ModelAttribute("postDto") PostDto postDto) {

		ModelAndView mav = new ModelAndView(INIT_PATH);

		List<PostListDto> postList = postListService.getPostList(postDto);

		postDto = setCategoryDropdownToPostDtoObject(postInitService, postDto);

		mav.addObject(POST_DTO, postDto);
		mav.addObject("postList", postList);

		return mav;
	}
}
