package com.repex.model;

import java.util.ArrayList;

public class CompanyRepositories {
    String company;
    ArrayList<RepositoryInfo> repositories;
    
    public CompanyRepositories() { }
    
    public String getCompany() {
        return this.company;
    }
    
    public ArrayList<RepositoryInfo> getRepositories() {
        return this.repositories;
    }
}
