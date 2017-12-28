package com.mep.domain.admin.administrator.service;

import static com.mep.util.TestServiceUtil.newAdministratorDto;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mep.domain.admin.administrator.dto.AdministratorDto;
import com.mep.handler.ApplicationException;
import com.mep.message.ResultMessages;
import com.mep.util.TestAbstract;

public class AdministratorInsertServiceTest extends TestAbstract {

	@Autowired
	private AdministratorInsertService administratorInsertService;

	@Test
	public void validateTest() {
		AdministratorDto adminDto = newAdministratorDto();

		ResultMessages result1 = passwordEmptyTest(adminDto);
		assertThat(result1.getErrorList().isEmpty(), is(false));

		ResultMessages result2 = passwordAndConfirmPasswordNotEqualTest(adminDto);
		assertThat(result2.getErrorList().isEmpty(), is(false));

		ResultMessages result3 = passwordAndConfirmPasswordEqualTest(adminDto);
		assertThat(result3.getErrorList().isEmpty(), is(true));
		
		ResultMessages result4 = passwordComplexityTest(adminDto);
		assertThat(result4.getErrorList().isEmpty(), is(false));
	}

	private ResultMessages passwordEmptyTest(AdministratorDto adminDto) {		
		return this.administratorInsertService.validate(adminDto);
	}

	private ResultMessages passwordAndConfirmPasswordNotEqualTest(
			AdministratorDto adminDto) {

		adminDto.setAdminPassword("ADMINmep99#$");
		adminDto.setAdminConfirmPassword("1ADMINmep99#$12");
		return this.administratorInsertService.validate(adminDto);
	}

	private ResultMessages passwordAndConfirmPasswordEqualTest(
			AdministratorDto adminDto) {
		adminDto.setAdminPassword("ADMINmep99#$");
		adminDto.setAdminConfirmPassword("ADMINmep99#$");
		return this.administratorInsertService.validate(adminDto);
	}

	private ResultMessages passwordComplexityTest(AdministratorDto adminDto) {
		adminDto.setAdminPassword("ADMINmep99");
		return this.administratorInsertService.validate(adminDto);
	}
	
	@Test
	public void validateEmailDuplicateTest() {
		AdministratorDto adminDto = newAdministratorDto();
		adminDto.setAdminEmail("admin1@gmail.com");
		ResultMessages result = this.administratorInsertService.validateEmailDuplicate(adminDto);
		assertThat(result.getErrorList().isEmpty(), is(false));
	}

	@Test
	public void shouldInsert() throws ApplicationException {
		AdministratorDto adminDto = newAdministratorDto();
		adminDto.setAdminPassword("123456");
		boolean flag = this.administratorInsertService
				.insertAdministrator(adminDto);
		assertThat(flag, is(true));
	}
}
