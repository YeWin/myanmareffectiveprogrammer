package com.mep.domain.admin.administrator.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mep.domain.admin.administrator.dto.PasswordChangeDto;
import com.mep.handler.ApplicationException;
import com.mep.message.ResultMessages;
import com.mep.util.TestAbstract;

public class AdministratorPasswordConfirmUpdateServiceTest extends TestAbstract {

	@Autowired
	private AdministratorPasswordUpdateConfirmService administratorPasswordUpdateConfirmService;

	@Test
	public void validateTest() throws ApplicationException {
		PasswordChangeDto passwordChangeDto = new PasswordChangeDto();

		ResultMessages result1 = passwordEmptyTest(passwordChangeDto);
		assertThat(result1.getErrorList().isEmpty(), is(false));

		ResultMessages result2 = passwordAndConfirmPasswordNotEqualTest(passwordChangeDto);
		assertThat(result2.getErrorList().isEmpty(), is(false));

		ResultMessages result3 = passwordAndConfirmPasswordEqualTest(passwordChangeDto);
		assertThat(result3.getErrorList().isEmpty(), is(true));
		
		ResultMessages result4 = passwordComplexityTest(passwordChangeDto);
		assertThat(result4.getErrorList().isEmpty(), is(false));
	}

	private ResultMessages passwordEmptyTest(PasswordChangeDto passwordChangeDto) throws ApplicationException {		
		return this.administratorPasswordUpdateConfirmService.validatePassword(passwordChangeDto);
	}

	private ResultMessages passwordAndConfirmPasswordNotEqualTest(
			PasswordChangeDto passwordChangeDto) throws ApplicationException {

		passwordChangeDto.setNewAdminPassword("ADMINmep99#$");
		passwordChangeDto.setNewAdminConfirmPassword("1ADMINmep99#$12");
		return this.administratorPasswordUpdateConfirmService.validatePassword(passwordChangeDto);
	}

	private ResultMessages passwordAndConfirmPasswordEqualTest(
			PasswordChangeDto passwordChangeDto) throws ApplicationException {
		passwordChangeDto.setNewAdminPassword("ADMINmep99#$");
		passwordChangeDto.setNewAdminConfirmPassword("ADMINmep99#$");
		return this.administratorPasswordUpdateConfirmService.validatePassword(passwordChangeDto);
	}

	private ResultMessages passwordComplexityTest(PasswordChangeDto passwordChangeDto) throws ApplicationException {
		passwordChangeDto.setNewAdminPassword("ADMINmep99");
		return this.administratorPasswordUpdateConfirmService.validatePassword(passwordChangeDto);
	}

	@Test
	public void shouldUpdate() throws ApplicationException {
		PasswordChangeDto passwordChangeDto = new PasswordChangeDto();
		passwordChangeDto.setNewAdminPassword("TECHadmin123##");
		boolean flag = this.administratorPasswordUpdateConfirmService
				.updateAdministratorPassword(passwordChangeDto);
		assertThat(flag, is(true));
	}
}
