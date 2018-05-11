package com.ghosh.jaagteyRahoBackend.dao;

import com.ghosh.jaagteyRahoBackend.dto.AutoCheckinSetting;

public interface SystemSetupDAO {

	AutoCheckinSetting getAutoCheckinSetting();

	boolean updateAutoCheckinSetting(AutoCheckinSetting autoCheckinSetting);

}
