package com.codegym.repository;

import com.codegym.model.Configuration;
import org.springframework.beans.factory.annotation.Configurable;

public interface IConfigurationRepository {
    void updateConfiguration(Configuration configuration);
    Configuration getConfiguration(int id);
}
