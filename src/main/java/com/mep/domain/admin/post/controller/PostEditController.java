package com.mep.domain.admin.post.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mep.domain.admin.post.dto.PostDto;
import com.mep.domain.admin.post.service.PostDeleteService;
import com.mep.domain.admin.post.service.PostInitService;
import com.mep.domain.admin.post.service.PostInsertService;
import com.mep.domain.admin.post.service.PostUpdateConfirmService;
import com.mep.domain.admin.post.service.PostUpdateService;
import com.mep.message.MessageHelper;

@Controller
@RequestMapping("/admin/*")
public class PostEditController extends PostControllerHelper {

	private static final String INPUT_PATH = "admin/post/postInput";

	private static final String INPUT_COMPLETE_PATH = "admin/post/postInputComplete";

	private static final String UPDATE_PATH = "admin/post/postUpdate";

	private static final String UPDATE_COMPLETE_PATH = "admin/post/postUpdateComplete";

	private static final String POST_DTO = "postDto";

	@Autowired
	private PostInitService postInitService;

	@Autowired
	private PostInsertService postInsertService;

	@Autowired
	private PostDeleteService postDeleteService;

	@Autowired
	private PostUpdateService postUpdateService;

	@Autowired
	private PostUpdateConfirmService postUpdateConfirmService;

	@Autowired
	private MessageHelper messageHelper;

	/* Converts empty strings into null when a form is submitted */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	@GetMapping(value = "/post/insert")
	public ModelAndView insert() {

		ModelAndView mav = new ModelAndView(INPUT_PATH);

		PostDto postDto = new PostDto();

		postDto = setCategoryDropdownToPostDtoObject(postInitService, postDto);

		mav.addObject(POST_DTO, postDto);

		return mav;
	}

	@PostMapping(value = "/post/insertConfirm")
	public @ResponseBody ModelAndView postInsert(
			@Validated @ModelAttribute("postDto") PostDto postDto,
			BindingResult bindingResult, HttpServletRequest request) {

		ModelAndView mav = new ModelAndView(INPUT_COMPLETE_PATH);
		mav.addObject(postDto);

		if (checkBeanValidator(bindingResult, postDto, mav, INPUT_PATH)) {
			return mav;
		}

		postInsertService.insertPost(getAdminIdFromSession(request), postDto);
		messageHelper.setCompleteMessage(mav, "MSP00001");

		return mav;
	}

	private boolean checkBeanValidator(BindingResult bindingResult,
			PostDto postDto, ModelAndView mav, String path) {

		if (bindingResult.hasErrors()) {
			postDto = setCategoryDropdownToPostDtoObject(postInitService,
					postDto);
			mav.setViewName(path);
			return true;
		}

		return false;
	}

	@GetMapping(value = "/post/update/{postId}")
	public ModelAndView postUpdate(@ModelAttribute("postId") Integer postId) {

		ModelAndView mav = new ModelAndView(UPDATE_PATH);

		PostDto postDto = postUpdateService.getPostById(postId);

		postDto = setCategoryDropdownToPostDtoObject(postInitService, postDto);
		
		postDto = setArticleDropdownToPostDtoObject(postInitService, postDto);

		mav.addObject(POST_DTO, postDto);

		return mav;
	}

	@PostMapping(value = "/post/updateConfirm")
	public ModelAndView postUpdateConfirm(
			@Validated @ModelAttribute("postDto") PostDto postDto,
			BindingResult bindingResult) {

		ModelAndView mav = new ModelAndView(UPDATE_COMPLETE_PATH);
		mav.addObject(postDto);

		if (checkBeanValidator(bindingResult, postDto, mav, UPDATE_PATH)) {
			return mav;
		}

		postUpdateConfirmService.updatePost(postDto);
		messageHelper.setCompleteMessage(mav, "MSP00001");

		return mav;
	}

	@GetMapping(value = "/post/delete/{postId}")
	public String postDelete(@PathVariable("postId") Integer postId) {

		postDeleteService.postDelete(postId);

		return "redirect:/admin/post/";
	}

}
