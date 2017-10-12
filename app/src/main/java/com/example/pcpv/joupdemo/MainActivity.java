package com.example.pcpv.joupdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v4.net.ConnectivityManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity implements MainActivityInterface {
    private static final String TAG = "MainActivity";

    @ViewById(R.id.iv_league)
    protected ImageView ivLeague;
    @ViewById(R.id.iv_home)
    protected ImageView ivHome;
    @ViewById(R.id.iv_away)
    protected ImageView ivAway;
    @ViewById(R.id.tv_time)
    protected TextView tvTime;
    @ViewById(R.id.tv_link)
    protected TextView tvLink;
    @ViewById(R.id.tv_title)
    protected TextView tvTile;

    @AfterViews
    public void init() {
        getHtml("http://tructiepbongda.com/");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Background
    public void getHtml(String url) {
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.getResponse(doc);


    }

    @Override
    public void getResponse(Document response) {
        if (response != null) {
            Elements matchList = response.select("div.listmatch");
            if (matchList != null) {
                Element firstMatch = matchList.select("div.match").first();
                Match match = new Match();
                String date = firstMatch.select("div.matchtime.column").first().select("p").first().text();
                String hour = firstMatch.select("div.matchtime.column").first().select("b").first().text();
                String matchTitle = firstMatch.select("div.matchtitle.column").first().select("h1").first().text();

                String urlLeagueLogo = firstMatch.select("div.leaguelogo.column").first().getElementsByTag("img").first().absUrl("src");
                String urlHomeLogo = firstMatch.select("div.homelogo.column").first().getElementsByTag("img").first().absUrl("src");
                String urlAwayLogo = firstMatch.select("div.awaylogo.column").first().getElementsByTag("img").first().absUrl("src");
                String liveLink = firstMatch.select("div.livelink.column").first().getElementsByTag("a").first().absUrl("href");

                match.setMatchTime(new MatchTime(hour, date));
                match.setUrlLeagueLogo(urlLeagueLogo);
                match.setUrlHomeLogo(urlHomeLogo);
                match.setUrlAwayLogo(urlAwayLogo);
                match.setLiveLink(liveLink);
                match.setMatchTitle(matchTitle);
                Log.i(TAG, "getResponse: " + match.getMatchTime().getDate());
                Log.i(TAG, "getResponse: " + match.getMatchTime().getHour());
                Log.i(TAG, "getResponse: " + match.getUrlLeagueLogo());
                Log.i(TAG, "getResponse: " + match.getUrlHomeLogo());
                Log.i(TAG, "getResponse: " + match.getUrlAwayLogo());
                Log.i(TAG, "getResponse: " + match.getLiveLink());
                renderMatchInfomation(match);
            }

        }

    }

    @UiThread
    public void renderMatchInfomation(Match match) {
        loadImage(match.getUrlLeagueLogo(), ivLeague);
        loadImage(match.getUrlHomeLogo(), ivHome);
        loadImage(match.getUrlAwayLogo(), ivAway);
        tvTime.setText(match.getMatchTime().getHour() + "\n" + match.getMatchTime().getDate());
        tvTile.setText(match.getMatchTitle());
        tvLink.setText(match.getLiveLink());
    }

    private void loadImage(String Url, ImageView image) {
        Picasso.with(this)
                .load(Url)
                .into(image);
    }


}

interface MainActivityInterface {
    void getResponse(Document response);
}
