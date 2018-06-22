package com.ghosh.jaagteyRahoBackend.dao;

import java.util.List;

import com.ghosh.jaagteyRahoBackend.dto.AutoCheckinSetting;
import com.ghosh.jaagteyRahoBackend.dto.ContactPerson;
import com.ghosh.jaagteyRahoBackend.dto.PushNotificationsStatus;
import com.ghosh.jaagteyRahoBackend.dto.Site;
import com.ghosh.jaagteyRahoBackend.dto.User;

public interface SystemSetupDAO {

	List<AutoCheckinSetting> getAutoCheckinSetting();

	AutoCheckinSetting getAutoCheckinSettingByUser(int userId);

	AutoCheckinSetting getAutoCheckinSettingById(int id);
	
	boolean deleteAutoCheckinSetting(AutoCheckinSetting autoCheckinSetting);

	boolean updateAutoCheckinSetting(AutoCheckinSetting autoCheckinSetting);

	List<ContactPerson> getAllContactPersons();

	boolean addUpdatedContactPerson(ContactPerson contactPerson);

	ContactPerson getContactPersonById(int id);

	boolean deleteContactPerson(ContactPerson contactPerson);

	boolean addPustNotificationStatus(PushNotificationsStatus status);

	boolean UpdatePustNotificationStatus(PushNotificationsStatus status);

	List<PushNotificationsStatus> getLatestPushNotifications();

	PushNotificationsStatus getLatestPushNotificationByUser(User user);

	List<PushNotificationsStatus> getPushNotificationsByEmployee(User emp);

}
