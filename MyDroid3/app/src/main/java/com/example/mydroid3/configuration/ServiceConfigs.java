package com.example.mydroid3.configuration;

public class ServiceConfigs {
    public static final String SERVER_PROTOCOL = "http";
    public static final String SERVER_IP = "192.168.50.71";
    public static final String SERVER_PORT = "3002";
    public static final String API_BASE_URL = String.format("%s://%s:%s",
            ServiceConfigs.SERVER_PROTOCOL,
            ServiceConfigs.SERVER_IP,
            ServiceConfigs.SERVER_PORT
    );
    public static final String API_GET_ALL_ROLES = ServiceConfigs.API_BASE_URL + "/api/locked/roles/all";
}
