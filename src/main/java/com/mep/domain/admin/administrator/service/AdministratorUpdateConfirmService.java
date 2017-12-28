package com.mep.domain.admin.administrator.service;

import com.mep.domain.admin.administrator.dto.AdministratorDto;
import com.mep.message.ResultMessages;

public interface AdministratorUpdateConfirmService {
	
	ResultMessages validateEmailDuplicate(AdministratorDto adminDto);

	boolean updateAdministrator(AdministratorDto adminDto);
}
