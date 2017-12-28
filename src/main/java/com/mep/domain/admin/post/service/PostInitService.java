package com.mep.domain.admin.post.service;

import java.util.List;

import com.mep.domain.admin.post.dto.CategoryDropdownDto;

public interface PostInitService {

	List<CategoryDropdownDto> getCategoryDropdown();
}
