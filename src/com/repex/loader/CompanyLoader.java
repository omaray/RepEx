package com.repex.loader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.repex.Constants;
import com.repex.Util;
import com.repex.model.CompanyRepositories;
import com.repex.model.RepositoryInfo;;

public class CompanyLoader {
    private LinkedList<CompanyRepositories> companyData;
    
    public void load() {
        Gson gson = new Gson();
        String repositoriesInJson= Util.readFromFile(Constants.REPOSITORIES_FILE_PATH);
        CompanyRepositories[] companyRepositoriesArray = gson.fromJson(repositoriesInJson, CompanyRepositories[].class);
        
        this.companyData = new LinkedList<CompanyRepositories>(Arrays.asList(companyRepositoriesArray));
    }
    
    public LinkedList<CompanyRepositories> getCompanyData() {
        return this.companyData;
    }
    
    public static void main(String[] args) {
        CompanyLoader loader = new CompanyLoader();
        loader.load();
        List<CompanyRepositories> companyRespositoryList = loader.getCompanyData();
        for (CompanyRepositories companyRepos : companyRespositoryList) {
            System.out.println(companyRepos.getCompany());
            ArrayList<RepositoryInfo> respositories = companyRepos.getRepositories();
            for (RepositoryInfo repo : respositories) {
                System.out.print("  Language: " + repo.getLanguage());
                System.out.print("  Name: " + repo.getName());
                System.out.println("  Org: " + repo.getOrg());
            }
        }
    }
}
