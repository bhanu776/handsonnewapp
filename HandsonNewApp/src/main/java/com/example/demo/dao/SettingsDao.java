package com.example.demo.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Settings;
import com.example.demo.repository.SettingsRepository;

@Service
public class SettingsDao {
	
	@Autowired
	SettingsRepository settingsRepository;
	
	public Settings saveSettings(Settings settings){
		return settingsRepository.save(settings);
	}
	
	public Settings getSettings(int id) {
		Optional<Settings> settings = settingsRepository.findById(id);
		if(settings.isPresent())
			return settings.get();
		else
			return new Settings();
	}
	
	
}
