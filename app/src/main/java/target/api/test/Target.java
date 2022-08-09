package target.api.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.fasterxml.jackson.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import java.util.Map;
// import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.ArrayList;
import org.checkerframework.checker.units.qual.s;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.fasterxml.jackson.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
// import jackson.databind.ObjectMapper;

class Target {

	public static void main(String[] args) throws IOException {
		String query_param = "alarm";
		URL url = new URL("https://redsky.target.com/redsky_aggregations/v1/web/plp_search_v1?key=9f36aeafbe60771e321a7cc95a78140772ab3e96&channel=WEB&count=24&default_purchasability_filter=true&include_sponsored=true&keyword=" + query_param +"&offset=0&page=%2Fs%2F" + query_param + "&platform=desktop&pricing_store_id=3286&scheduled_delivery_store_id=1284&store_ids=3286%2C1284%2C3327%2C2786%2C3275&useragent=Mozilla%2F5.0+%28Macintosh%3B+Intel+Mac+OS+X+10_15_7%29+AppleWebKit%2F537.36+%28KHTML%2C+like+Gecko%29+Chrome%2F103.0.0.0+Safari%2F537.36&visitor_id=0182843B4F9D0201868BE2386376FB07&zip=98115");
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		httpConn.setRequestMethod("GET");

		httpConn.setRequestProperty("authority", "redsky.target.com");
		httpConn.setRequestProperty("accept", "application/json");
		httpConn.setRequestProperty("accept-language", "en-US,en;q=0.9");
		httpConn.setRequestProperty("cache-control", "no-cache");
		httpConn.setRequestProperty("cookie", "TealeafAkaSid=RTUjt9VGF23P8jvML4ZtnvKj2gTiH8xj; visitorId=0182843B4F9D0201868BE2386376FB07; sapphire=1; UserLocation=98115|47.680|-122.320|WA|US; egsSessionId=09514e96-157a-45b9-913f-4eea401404da; accessToken=eyJraWQiOiJlYXMyIiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiIwZjVkZjNjNy1kZjNjLTRlMTYtOWQyYy04ZWNkZjRlMDEwMTUiLCJpc3MiOiJNSTYiLCJleHAiOjE2NjAxNjIyNTYsImlhdCI6MTY2MDA3NTg1NiwianRpIjoiVEdULmVmZTZkZTZiYTA1ODRjZmVhNTc1OWI1YmU0ZTk4Y2FmLWwiLCJza3kiOiJlYXMyIiwic3V0IjoiRyIsImRpZCI6ImNkNWMxMWJlYzU3NWM5MTM5MjdmNzExMWYzZGM5MzFkMDRmMmZkODAwZWU4OGZiMjJhNmM1MDQwNjliZWVjOTYiLCJzY28iOiJlY29tLm5vbmUsb3BlbmlkIiwiY2xpIjoiZWNvbS13ZWItMS4wLjAiLCJhc2wiOiJMIn0.aGlhShvcA2Ebplr8oGOenq4-yvghiSlCVv7E68YuPi-pgJ_2LVbpQfZVfmJpN-vqwuc0m6o_DkXeQvdrzjRI9oCWh0BYRN_l9YeY7mGZPwbWYu2s0DTUFHjvwX9qpFvhoFwKlpx-lcxiFkfiZXcsHn0aAQxs5PA5hFiCzrtfaxNbtJBtwn6pFiVIdc3uFUHSUA4CWbZ4lTAv150KrHXQW6w-MT0XBIy39gKvQ7_UelBUeO5Q0yZ3rorwcgJ1_S697SRCAkajr5q1q0jqiu3r3XpTbG2Mb7G8vvIuK3yrvBDUMGCrH5A8DPzXeNakyOg98BwZuaXOrnQj7af01RqTkw; idToken=eyJhbGciOiJub25lIn0.eyJzdWIiOiIwZjVkZjNjNy1kZjNjLTRlMTYtOWQyYy04ZWNkZjRlMDEwMTUiLCJpc3MiOiJNSTYiLCJleHAiOjE2NjAxNjIyNTYsImlhdCI6MTY2MDA3NTg1NiwiYXNzIjoiTCIsInN1dCI6IkciLCJjbGkiOiJlY29tLXdlYi0xLjAuMCIsInBybyI6eyJmbiI6bnVsbCwiZW0iOm51bGwsInBoIjpmYWxzZSwibGVkIjpudWxsLCJsdHkiOmZhbHNlfX0.; refreshToken=OD2VyL1pw-IAZRTuaG0f_gTNE0vxuXy-NpDpPq9NT0WVKhiV1JSMyuAyJWKa3FaOAcIiE_GKx2XB1Nxv7XfOkA; ffsession={%22sessionHash%22:%227edc48d97ec711660075856003%22%2C%22prevPageName%22:%22home%20page%22%2C%22prevPageType%22:%22home%20page%22%2C%22prevPageUrl%22:%22https://www.target.com/%22%2C%22sessionHit%22:1}; __gads=ID=7d1e1aea55049467:T=1660075856:S=ALNI_MZZkkXqduWzsF-W04xlnnLhamSkqw; __gpi=UID=000007bf85e8bf7a:T=1660075856:RT=1660075856:S=ALNI_MZFQzGyX4caavLN4GKEcnkNWcriZw; fiatsCookie=DSI_3286|DSN_Seattle%20University%20Way|DSZ_98105; ci_pixmgr=other; _uetsid=6102ac10181f11ed8bd0edd2f57e7248; _uetvid=6102afc0181f11ed97da8f2dc12d8943; _gcl_au=1.1.1067207836.1660075857; _mitata=OGJiOTdkNmIzMDAwOTEyYzIwODdjZGRkY2ZiMjJlZmJhYTU1YjM5ODZkNzMyNzNhNmUyMjMzNWU5ODgzZWNlOA==_/@#/1660075917_/@#/cCAdej1ZmSctaXAa_/@#/NTE1OTM2Y2UwMDc5YTY0M2M5NDk5ODJkODNjMWQ2ZWU0OWYzMmY2YzBlMGJlMTRmMzlhZTMxMzJjODVjZTkxNw==_/@#/000");
		httpConn.setRequestProperty("origin", "https://www.target.com");
		httpConn.setRequestProperty("pragma", "no-cache");
		httpConn.setRequestProperty("referer", String.format("https://www.target.com/s?searchTerm=%s", query_param));
		httpConn.setRequestProperty("sec-ch-ua", "\".Not/A)Brand\";v=\"99\", \"Google Chrome\";v=\"103\", \"Chromium\";v=\"103\"");
		httpConn.setRequestProperty("sec-ch-ua-mobile", "?0");
		httpConn.setRequestProperty("sec-ch-ua-platform", "\"macOS\"");
		httpConn.setRequestProperty("sec-fetch-dest", "empty");
		httpConn.setRequestProperty("sec-fetch-mode", "cors");
		httpConn.setRequestProperty("sec-fetch-site", "same-site");
		httpConn.setRequestProperty("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Safari/537.36");

		InputStream responseStream = httpConn.getResponseCode() / 100 == 2
				? httpConn.getInputStream()
				: httpConn.getErrorStream();
		Scanner s = new Scanner(responseStream).useDelimiter("\\A");
		String response = s.hasNext() ? s.next() : "";

		JsonElement jsonElement = new JsonParser().parse(response);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(jsonElement);

		System.out.println(json);
	}
}