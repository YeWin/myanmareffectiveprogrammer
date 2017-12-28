package com.mep.security.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mep.database.entity.Administrator;
import com.mep.domain.login.dto.SessionLoginAdminDto;
import com.mep.security.dao.AdministratorReferDao;
import com.mep.security.dto.AuthLoginAdminDto;
import com.mep.util.Constant;

@Service
public class AdminDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AdministratorReferDao administratorReferDao;

	@Autowired
	private HttpSession session;

	@Override
	public UserDetails loadUserByUsername(String adminEmail)
			throws UsernameNotFoundException {

		List<Administrator> administratorList = getAdminInformationByEmail(adminEmail);

		AuthLoginAdminDto admin = getAuthLoginAdminDtoWithAuthData(administratorList);

		saveAdminInformationInSession(administratorList);

		return new LoginAdmin(admin);
	}

	private void saveAdminInformationInSession(
			List<Administrator> administratorList) {
		SessionLoginAdminDto sessionLoginAdminDto = new SessionLoginAdminDto();
		sessionLoginAdminDto.setAdminId(administratorList.get(0).getAdminId());
		sessionLoginAdminDto.setAdminName(administratorList.get(0)
				.getAdminName());
		sessionLoginAdminDto.setAdminEmail(administratorList.get(0)
				.getAdminEmail());
		session.setAttribute(Constant.SESSION_KEY, sessionLoginAdminDto);
	}

	private AuthLoginAdminDto getAuthLoginAdminDtoWithAuthData(
			List<Administrator> administratorList) {

		AuthLoginAdminDto admin = new AuthLoginAdminDto();

		admin.setAdminId(String.valueOf(administratorList.get(0).getAdminId()));
		admin.setAdminPassword(administratorList.get(0).getAdminPassword());

		return admin;
	}

	private List<Administrator> getAdminInformationByEmail(String adminEmail)
			throws UsernameNotFoundException {

		List<Administrator> administratorList = administratorReferDao
				.getAdminInformationByEmail(adminEmail);

		if (administratorList.isEmpty()) {
			throw new UsernameNotFoundException(
					"Administrator information was not found");
		}

		return administratorList;
	}
}
