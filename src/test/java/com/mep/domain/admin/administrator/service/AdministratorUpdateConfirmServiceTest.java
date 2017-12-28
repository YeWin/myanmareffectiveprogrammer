package com.mep.domain.admin.administrator.service;

import static com.mep.util.TestServiceUtil.newAdministratorDto;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mep.domain.admin.administrator.dto.AdministratorDto;
import com.mep.message.ResultMessages;
import com.mep.util.TestAbstract;

public class AdministratorUpdateConfirmServiceTest extends TestAbstract {

	@Autowired
	private AdministratorUpdateConfirmService administratorUpdateConfirmService;

	@Test
	public void emailShouldNotUpdate() {
		AdministratorDto adminDto = newAdministratorDto();
		adminDto.setAdminEmail("admin1@gmail.com");
		adminDto.setAdminNewEmail("admin1@gmail.com");
		ResultMessages result = this.administratorUpdateConfirmService
				.validateEmailDuplicate(adminDto);
		assertThat(result.getErrorList().isEmpty(), is(true));
	}

	@Test
	public void emailShouldUpdate() {
		AdministratorDto adminDto = newAdministratorDto();

		adminDto.setAdminEmail("admin1@gmail.com");
		adminDto.setAdminNewEmail("admin123@gmail.com");
		ResultMessages result = this.administratorUpdateConfirmService
				.validateEmailDuplicate(adminDto);
		assertThat(result.getErrorList().isEmpty(), is(true));
	}

	@Test
	public void newEmailIsEmpty() {
		AdministratorDto adminDto = newAdministratorDto();
		adminDto.setAdminEmail("admin1@gmail.com");
		ResultMessages result = this.administratorUpdateConfirmService
				.validateEmailDuplicate(adminDto);
		assertThat(result.getErrorList().isEmpty(), is(true));
	}

	@Test
	public void newEmailIsDuplicate() {
		AdministratorDto adminDto = newAdministratorDto();
		adminDto.setAdminEmail("admin1@gmail.com");
		adminDto.setAdminNewEmail("yewin29081990@gmail.com");
		ResultMessages result = this.administratorUpdateConfirmService
				.validateEmailDuplicate(adminDto);
		assertThat(result.getErrorList().isEmpty(), is(false));
	}

	@Test
	public void shouldUpdate() {
		AdministratorDto adminDto = newAdministratorDto();
		adminDto.setAdminId(2);
		adminDto.setAdminEmail("yewin@gmail.com");
		boolean flag = this.administratorUpdateConfirmService
				.updateAdministrator(adminDto);
		assertThat(flag, is(true));
	}
}
