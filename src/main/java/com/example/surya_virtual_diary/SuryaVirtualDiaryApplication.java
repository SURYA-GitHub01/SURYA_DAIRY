package com.example.surya_virtual_diary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import java.util.Locale;

@SpringBootApplication
public class SuryaVirtualDiaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuryaVirtualDiaryApplication.class, args);
	}

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(new Locale("en", "IN")); // Set default locale to en_IN
        return localeResolver;
    }
}
