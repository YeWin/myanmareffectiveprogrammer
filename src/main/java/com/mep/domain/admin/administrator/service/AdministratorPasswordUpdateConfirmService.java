package com.mep.domain.admin.administrator.service;

import com.mep.domain.admin.administrator.dto.PasswordChangeDto;
import com.mep.handler.ApplicationException;
import com.mep.message.ResultMessages;

public interface AdministratorPasswordUpdateConfirmService {

	ResultMessages validatePassword(PasswordChangeDto passwordChangeDto)throws ApplicationException;

	boolean updateAdministratorPassword(PasswordChangeDto passwordChangeDto)throws ApplicationException;
}
