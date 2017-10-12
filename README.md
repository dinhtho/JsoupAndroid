# Jsoup Demo Parse HTML

## Set up
```
compile 'org.jsoup:jsoup:1.10.3'
```
## code
```
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


```
## Html CODE
```
<div class="listmatch">
<h2><span>Lịch trực tiếp bóng đá</span><a href="http://tructiepbongda.com/lich-truc-tiep-bong-da">Xem đầy đủ</a></h2>
<ul>

<li class="odd"> <div class="match">
<div class="leaguelogo column">
<a href="http://tructiepbongda.com/brasileirao" title="Brasileirao"><img src="./Trực tiếp bóng đá - Xem trực tiếp, xem lại, xem video bóng đá_files/brasileirao.png" height="50px" onerror="this.src=&#39;/images/leagues/default.png&#39;"></a>
</div>
<div class="matchtime column">
<b>03:00</b>
<p>13/10</p>
</div>
<div class="homelogo column">
<a href="http://tructiepbongda.com/tag/flamengo" title="Flamengo"><img src="./Trực tiếp bóng đá - Xem trực tiếp, xem lại, xem video bóng đá_files/flamengo.png" height="50" onerror="this.src=&#39;/images/teams/default.png&#39;"></a>
</div>
<div class="matchtitle column">
<h1>Flamengo vs Fluminense</h1>
</div>
<div class="awaylogo column">
<a href="http://tructiepbongda.com/tag/fluminense" title="Fluminense"><img src="./Trực tiếp bóng đá - Xem trực tiếp, xem lại, xem video bóng đá_files/fluminense.png" height="50" onerror="this.src=&#39;/images/teams/default.png&#39;"></a>
</div>
<div class="livelink column">
<a href="http://tructiepbongda.com/brasileirao/flamengo-vs-fluminense-13-10.html">Trực tiếp</a>
</div>
</div> </li>


<li> <div class="match">
<div class="leaguelogo column">
<a href="http://tructiepbongda.com/brasileirao" title="Brasileirao"><img src="./Trực tiếp bóng đá - Xem trực tiếp, xem lại, xem video bóng đá_files/brasileirao.png" height="50px" onerror="this.src=&#39;/images/leagues/default.png&#39;"></a>
</div>
<div class="matchtime column">
<b>07:00</b>
<p>13/10</p>
</div>
<div class="homelogo column">
<a href="http://tructiepbongda.com/tag/palmeiras" title="Palmeiras"><img src="./Trực tiếp bóng đá - Xem trực tiếp, xem lại, xem video bóng đá_files/palmeiras.png" height="50" onerror="this.src=&#39;/images/teams/default.png&#39;"></a>
</div>
<div class="matchtitle column">
<h1>Palmeiras vs Bahia</h1>
</div>
<div class="awaylogo column">
<a href="http://tructiepbongda.com/tag/bahia" title="Bahia"><img src="./Trực tiếp bóng đá - Xem trực tiếp, xem lại, xem video bóng đá_files/bahia.png" height="50" onerror="this.src=&#39;/images/teams/default.png&#39;"></a>
</div>
<div class="livelink column">
<a href="http://tructiepbongda.com/brasileirao/palmeiras-vs-bahia-13-10.html">Trực tiếp</a>
</div>
</div> </li>
</ul>
</div>
```

![img](https://github.com/dinhtho/JsoupAndroid/blob/master/image.png)