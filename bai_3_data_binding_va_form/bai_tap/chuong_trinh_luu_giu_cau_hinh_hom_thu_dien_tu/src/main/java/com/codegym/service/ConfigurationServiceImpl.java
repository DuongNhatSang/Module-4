package com.codegym.service;

import com.codegym.model.Configuration;
import com.codegym.repository.ConfigurationRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationServiceImpl implements IConfigurationService{
    @Autowired
    ConfigurationRepositoryImpl configurationRepository;
    @Override
    public void updateConfiguration(Configuration configuration) {
        configurationRepository.updateConfiguration(configuration);
    }

    @Override
    public Configuration getConfiguration(int id) {
        return configurationRepository.getConfiguration(id);
    }

}
