package com.codegym.repository;

import com.codegym.model.Configuration;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository
public class ConfigurationRepositoryImpl implements IConfigurationRepository{
    public static List<Configuration> configurationList;
    static {
        configurationList = new ArrayList<>();
        configurationList.add(new Configuration(1,"Chinese",50,true,"abcbb"));
    }
    @Override
    public void updateConfiguration(Configuration configuration) {
        for (int i = 0; i < configurationList.size(); i++) {
            if(configurationList.get(i).getId() == configuration.getId()){
                configurationList.get(i).setLanguages(configuration.getLanguages());
                configurationList.get(i).setPageSize(configuration.getPageSize());
                configurationList.get(i).setSpamsFilter(configuration.getSpamsFilter());
                configurationList.get(i).setSignature(configuration.getSignature());
            }
        }
    }
    public Configuration getConfiguration(int id){
        Configuration configuration = null;
        for (int i = 0; i < configurationList.size(); i++) {
            if(configurationList.get(i).getId() == id){
                configuration = configurationList.get(i);
                break;
            }
        }
        return configuration;
    }
}
