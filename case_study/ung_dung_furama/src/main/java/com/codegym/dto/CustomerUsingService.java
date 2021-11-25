package com.codegym.dto;

public interface CustomerUsingService {
    Long getCustomer_id();
    String getFull_name();
    String getService_name();
    Long getContract_id();
    String getContract_start_day();
    String getContract_end_day();
}
