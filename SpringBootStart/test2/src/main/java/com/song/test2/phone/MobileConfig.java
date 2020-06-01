package com.song.test2.phone;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MobileConfig {

	@Bean
	public MobilePhone getMobilePhone(MobileCamera mobileCamera) {
		MobilePhone mobilePhone = new MobilePhone();
		mobilePhone.setMobileCamera(mobileCamera);
		return mobilePhone;
	}
	
	@Bean
	public MobileCamera getMobileCamera() {
		return new MobileCamera();
	}
}
