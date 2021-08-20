package com.tg.marketing.createmarketingpreference.factory;

//@Configuration
public class PreferenceFactory {

	/*@Bean
	public EmailPreferenceServiceImpl getEmailPreferenceServiceImpl() {
		return new EmailPreferenceServiceImpl();
	}

	@Bean
	public PostPreferenceServiceImpl getPostPreferenceServiceImpl() {
		return new PostPreferenceServiceImpl();
	}

	@Bean
	public SmsPreferenceServiceImpl getSmsPreferenceServiceImpl() {
		return new SmsPreferenceServiceImpl();
	}

	public Preference createPreferenceByType(String type) {
		if (type == null || type.isEmpty())
			return null;
		if (Constants.SMS.equals(type)) {
			return getSmsPreferenceServiceImpl();
		} else if (Constants.EMAIL.equals(type)) {
			return getEmailPreferenceServiceImpl();
		} else if (Constants.POST.equals(type)) {
			return getPostPreferenceServiceImpl();
		}
		return null;
	}
*/
}
