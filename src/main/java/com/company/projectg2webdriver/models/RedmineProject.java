package com.company.projectg2webdriver.models;

public class RedmineProject {

    private String name;
    private String description;
    private String homePage;
    private Boolean isPublic;

    public RedmineProject(){

    }

    public RedmineProject(String name, String description, String homePage, Boolean isPublic) {
        this.name = name;
        this.description = description;
        this.homePage = homePage;
        this.isPublic = isPublic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    public Boolean getPublic() {
        return isPublic;
    }

    public void setPublic(Boolean aPublic) {
        isPublic = aPublic;
    }

    @Override
    public String toString() {
        return "RedmineProject{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", homePage='" + homePage + '\'' +
                ", isPublic=" + isPublic +
                '}';
    }
}
