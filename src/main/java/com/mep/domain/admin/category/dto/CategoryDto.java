package com.mep.domain.admin.category.dto;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

public class CategoryDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer categoryId;

	@NotBlank
	private String categoryName;
	
	private Date createdDate;
	
	private Date updatedDate;

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}	
	
}
