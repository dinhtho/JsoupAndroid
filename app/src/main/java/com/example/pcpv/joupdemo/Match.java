package com.example.pcpv.joupdemo;

/**
 * Created by PCPV on 10/12/2017.
 */

public class Match {
    private MatchTime matchTime;
    private String urlHomeLogo;
    private String urlAwayLogo;
    private String urlLeagueLogo;
    private String matchTitle;
    private String liveLink;

    public MatchTime getMatchTime() {
        return matchTime;
    }

    public String getUrlHomeLogo() {
        return urlHomeLogo;
    }

    public String getUrlAwayLogo() {
        return urlAwayLogo;
    }

    public String getMatchTitle() {
        return matchTitle;
    }

    public String getLiveLink() {
        return liveLink;
    }

    public void setMatchTime(MatchTime matchTime) {
        this.matchTime = matchTime;
    }

    public void setUrlHomeLogo(String urlHomeLogo) {
        this.urlHomeLogo = urlHomeLogo;
    }

    public void setUrlAwayLogo(String urlAwayLogo) {
        this.urlAwayLogo = urlAwayLogo;
    }

    public void setMatchTitle(String matchTitle) {
        this.matchTitle = matchTitle;
    }

    public void setLiveLink(String liveLink) {
        this.liveLink = liveLink;
    }

    public String getUrlLeagueLogo() {
        return urlLeagueLogo;
    }

    public void setUrlLeagueLogo(String urlLeagueLogo) {
        this.urlLeagueLogo = urlLeagueLogo;
    }
}
