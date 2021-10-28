package com.codegym.service;

import com.codegym.model.Configuration;

public interface IConfigurationService {
    void updateConfiguration(Configuration configuration);
    Configuration getConfiguration(int id);
}
