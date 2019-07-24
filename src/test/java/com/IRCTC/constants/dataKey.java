package com.IRCTC.constants;

public enum dataKey {

    // URLS
    HomePage("HomePage.Url"),
    HomePage_UserName("LoginPage.UserName"),
    HomePage_Password("LoginPage.Password"),



       ;
    private String page;

    private dataKey(String page) {
        this.setPage(page);
    }

    public String getPage() {
        return this.page;
    }

    private void setPage(String name) {
        this.page = name;
    }
}
