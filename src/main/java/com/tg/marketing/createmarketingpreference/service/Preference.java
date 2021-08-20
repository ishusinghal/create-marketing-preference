package com.tg.marketing.createmarketingpreference.service;

import com.tg.marketing.createmarketingpreference.constants.UpdatePreferenceEnum;
import com.tg.marketing.createmarketingpreference.dto.MarketingPreferenceDTO;

public interface Preference {

	public Long createPreferences(MarketingPreferenceDTO preference);

	public UpdatePreferenceEnum updatePreferences(MarketingPreferenceDTO preference);

}
