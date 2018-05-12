package com.ghosh.jaagteyRahoBackend.dao;

import java.util.List;

import com.ghosh.jaagteyRahoBackend.dto.AutoCheckinSetting;
import com.ghosh.jaagteyRahoBackend.dto.ContactPerson;

public interface SystemSetupDAO {

	AutoCheckinSetting getAutoCheckinSetting();

	boolean updateAutoCheckinSetting(AutoCheckinSetting autoCheckinSetting);

	List<ContactPerson> getAllContactPersons();

	boolean addUpdatedContactPerson(ContactPerson contactPerson);

	ContactPerson getContactPersonById(int id);

	boolean deleteContactPerson(ContactPerson contactPerson);
}
