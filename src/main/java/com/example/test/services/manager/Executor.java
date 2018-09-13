package com.example.test.services.manager;

public class Executor implements Runnable {
    String s;
    SiteManager siteManager;

    public Executor(SiteManager siteManager, String s) {
        this.s = s;
        this.siteManager = siteManager;
    }

    @Override
    public void run() {
        try {
            siteManager.setInputAndGetElements(s.charAt(0), s.charAt(1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
