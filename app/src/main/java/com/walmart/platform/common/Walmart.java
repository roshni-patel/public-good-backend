package com.walmart.platform.common;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
// import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.ArrayList;
// import java.util.TypeReference;
// import ObjectMapper;

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

class Walmart {

	public static void main(String[] args) throws IOException {
		String query_param = "tampons";
		// System.out.println(String.format("https://www.walmart.com/orchestra/home/graphql/search?query=%s&page=1&prg=desktop&sort=best_match&ps=40&searchArgs.query=%s&searchArgs.prg=desktop&fitmentFieldParams=true&enablePortableFacets=true&enableFacetCount=false&fetchMarquee=true&fetchSkyline=true&fetchSbaTop=true&tenant=WM_GLASS", query_param, query_param));
		URL url = new URL(String.format("https://www.walmart.com/orchestra/home/graphql/search?query=%s&page=1&prg=desktop&sort=best_match&ps=40&searchArgs.query=%s&searchArgs.prg=desktop&fitmentFieldParams=true&enablePortableFacets=true&enableFacetCount=false&fetchMarquee=true&fetchSkyline=true&fetchSbaTop=true&tenant=WM_GLASS", query_param, query_param));
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		httpConn.setRequestMethod("POST");

		httpConn.setRequestProperty("authority", "www.walmart.com");
		httpConn.setRequestProperty("accept", "application/json");
		httpConn.setRequestProperty("accept-language", "en-US,en;q=0.9");
		httpConn.setRequestProperty("cache-control", "no-cache");
		httpConn.setRequestProperty("content-type", "application/json");
		httpConn.setRequestProperty("cookie", "QuantumMetricUserID=1b74567bde43517f2d6f05ce031d4174; brwsr=cfd042ac-b896-11ec-95b6-41dad55d245b; vtc=ZQEKmh8wbDUTmajKGEX264; _pxvid=f230629f-de29-11ec-8e01-43685866486c; _abck=ijx6zhigxlc4pcaigas8_1982; wm_ul_plus=INACTIVE|1653878769217; WMP=4; oneapp_customer=true; _gcl_au=1.1.899230111.1654187236; s_pers_2=om_mv3d%3Daff%3Aadid-%3Asourceid-imp_QNXzy4XWkxyIRLjXHcR4YXWRUkDx7ZQiESQYU80%3Awmls-imp_1924488%3Acn-%7C1654450057037%3B%20%2Bom_mv7d%3Daff%3Aadid-%3Asourceid-imp_QNXzy4XWkxyIRLjXHcR4YXWRUkDx7ZQiESQYU80%3Awmls-imp_1924488%3Acn-%7C1654795635601%3B%20%2Bom_mv14d%3Daff%3Aadid-%3Asourceid-imp_QNXzy4XWkxyIRLjXHcR4YXWRUkDx7ZQiESQYU80%3Awmls-imp_1924488%3Acn-%7C1655400435601%3B%20%2Bom_mv30d%3Daff%3Aadid-%3Asourceid-imp_QNXzy4XWkxyIRLjXHcR4YXWRUkDx7ZQiESQYU80%3Awmls-imp_1924488%3Acn-%7C1656782835601%3B%20useVTC%3DY%7C1717302429%3B%20om_mv7d%3Daff%3Aadid-%3Asourceid-imp_QNXzy4XWkxyIRLjXHcR4YXWRUkDx7ZQiESQYU80%3Awmls-imp_1924488%3Acn-%7C1654795657038%3B%20om_mv14d%3Daff%3Aadid-%3Asourceid-imp_QNXzy4XWkxyIRLjXHcR4YXWRUkDx7ZQiESQYU80%3Awmls-imp_1924488%3Acn-%7C1655400457039%3B%20om_mv30d%3Daff%3Aadid-%3Asourceid-imp_QNXzy4XWkxyIRLjXHcR4YXWRUkDx7ZQiESQYU80%3Awmls-imp_1924488%3Acn-%7C1656782857039; _m=5; _mc=w4gsWbTg0xkrfQgD9HILwVZ6v6K8N1MWZbgGt5GB7oE%3D; _ga=GA1.2.273003026.1655925375; _pxhd=48ce569874e7cd889801984565bb87e5201c493f26cb184dcf817845eb30c404:f230629f-de29-11ec-8e01-43685866486c; TS013ed49a=01538efd7cfca0d42335465517f5b7f323b776b83819246b3706f4ec8b40384b383974f11ebf767fea70ae590dec3bb7ff9575d049; pxcts=ec36027a-02b7-11ed-bc9e-7551764d517a; _sp_id.ad94=36e22216-6f8e-483e-9ee9-09cf91242034.1653852715.7.1657908281.1657905359.e2622c52-32cd-415a-9ee2-962ecdf69ca3; akavpau_p1=1657909918~id=14b887157d1ed615d2de81397a1f72a9; TBV=7; _vc=2OJpNSzuUzCmgF6gTlPAMbJOZodHe5UVPLQ%2Bf43VUAo%3D; rtoken=MDgyNTUyMDE4MPD5wLV63wE6dW1TLhB%2F8wPtScoKmdCW8EQmEbLCBG41lqRL19UULAO5vLMfZRsrtxfcRLRZPa426GII7ltTeGWcHBeJeOrRi%2BkfY3gUvC7BAwYZMKT2hMdkxRIbqc%2Bcp35krirml1mhC%2FJ7HDpiUcfpUSt2NnSxmBrsvS7kZEJ3FNKJalZNsIvLoY%2B7rfrJot8OeBqCLaPydL1XFj8DtSt%2FCfaYAXvteOZzeGUvSRnM3I4JEklk6eAXW4GMBJ77tCXzTLjXqEC6dkiikM6kWEF6Pj%2Byj7rPXBD5Z%2BCsM7GYJKHFzn0XwpwpeufCfGob6OcrmFydbBOCpJADN4cwuwJZeRUYSpqTKoY%2FD8tESaUYqJtlQF6DxOhMnYwfMBUKL%2BS%2Fczl4Kqb1ns%2FsRFhN0Y5Je%2BWo0WP%2FZxmCBgXHUeI%3D; SPID=88e22adcc196bbba262702c9c789aa42da041976be7aa6d6f09a9986002b32130103080d40eddc19efbde44d88129db0cprof; CID=a3179fde-3160-4911-8c21-918967d2e9ec; hasCID=1; customer=%7B%22firstName%22%3A%22Yingyue%22%2C%22lastNameInitial%22%3A%22G%22%7D; type=REGISTERED; userContext=eyJhZGRyZXNzRGF0YSI6eyJoYXNEZWxpdmVyYWJsZUFkZHJlc3MiOnRydWV9LCJoYXNJdGVtU3Vic2NyaXB0aW9uIjpmYWxzZSwiaGFzTWVtYmVyc2hpcEluZm8iOnRydWUsImlzRGVmYXVsdCI6ZmFsc2UsInBheW1lbnREYXRhIjp7ImNhcGl0YWxPbmVCYW5uZXJTbm9vemVUUyI6MCwiaGFzQ2FwT25lIjpmYWxzZSwiaGFzQ2FwT25lTGlua2VkIjpmYWxzZSwiaGFzQ3JlZGl0Q2FyZCI6dHJ1ZSwiaGFzRGlyZWN0ZWRTcGVuZENhcmQiOmZhbHNlLCJoYXNFQlQiOmZhbHNlLCJoYXNHaWZ0Q2FyZCI6dHJ1ZSwic2hvd0NhcE9uZUJhbm5lciI6dHJ1ZSwid3BsdXNOb0JlbmVmaXRCYW5uZXIiOnRydWV9LCJwcm9maWxlRGF0YSI6eyJpc0Fzc29jaWF0ZSI6ZmFsc2UsImlzVGVzdEFjY291bnQiOmZhbHNlLCJtZW1iZXJzaGlwT3B0SW4iOnsiaXNPcHRlZEluIjpmYWxzZSwib3B0ZWRJbkF0dHJpYnV0ZUlkIjoiODZiNTViYTctNDM5NS00ZmJkLTlkNDQtODU5NDY5N2RkYWNmIn19fQ%3D%3D; AID=wmlspartner%253D0%253Areflectorid%253D0000000000000000000000%253Alastupd%253D1658956066948; _uetvid=6c4168608db611ec9379317f76753255; tb_sw_supported=true; DL=98105%2C%2C%2Cip%2C98105%2C%2C; locDataV3=eyJpc0RlZmF1bHRlZCI6ZmFsc2UsImlzRXhwbGljaXQiOmZhbHNlLCJpbnRlbnQiOiJTSElQUElORyIsInBpY2t1cCI6W3siYnVJZCI6IjAiLCJub2RlSWQiOiIzMDk4IiwiZGlzcGxheU5hbWUiOiJCZWxsZXZ1ZSBOZWlnaGJvcmhvb2QgTWFya2V0Iiwibm9kZVR5cGUiOiJTVE9SRSIsImFkZHJlc3MiOnsicG9zdGFsQ29kZSI6Ijk4MDA3IiwiYWRkcmVzc0xpbmUxIjoiMTUwNjMgTWFpbiBTdCIsImNpdHkiOiJCZWxsZXZ1ZSIsInN0YXRlIjoiV0EiLCJjb3VudHJ5IjoiVVMiLCJwb3N0YWxDb2RlOSI6Ijk4MDA3LTUyMjUifSwiZ2VvUG9pbnQiOnsibGF0aXR1ZGUiOjQ3LjYwOTAzNiwibG9uZ2l0dWRlIjotMTIyLjEzOTQ4N30sImlzR2xhc3NFbmFibGVkIjp0cnVlLCJzY2hlZHVsZWRFbmFibGVkIjp0cnVlLCJ1blNjaGVkdWxlZEVuYWJsZWQiOmZhbHNlLCJodWJOb2RlSWQiOiIzMDk4Iiwic3RvcmVIcnMiOiIwNjowMC0yMjowMCIsInN1cHBvcnRlZEFjY2Vzc1R5cGVzIjpbIlBJQ0tVUF9DVVJCU0lERSIsIlBJQ0tVUF9JTlNUT1JFIl19XSwic2hpcHBpbmdBZGRyZXNzIjp7ImlkIjoiZTdhZjY1MjQtNDIwNy00ZTE4LWJmOGItNjdhZTBkZGY4OWU3IiwiYWRkcmVzc0xpbmVPbmUiOiI0NzMwIFVuaXZlcnNpdHkgV2F5IE5FIiwiYWRkcmVzc0xpbmVUd28iOiJTdGUgMjA2IiwibGF0aXR1ZGUiOjQ3LjY2MzUzMywibG9uZ2l0dWRlIjotMTIyLjMxMjg5MSwicG9zdGFsQ29kZSI6Ijk4MTA1NDQyNCIsImNpdHkiOiJTZWF0dGxlIiwic3RhdGUiOiJXQSIsImNvdW50cnlDb2RlIjoiVVNBIiwiaXNBcG9GcG8iOmZhbHNlLCJpc1BvQm94IjpmYWxzZSwiYWRkcmVzc1R5cGUiOiJSRVNJREVOVElBTCIsImxvY2F0aW9uQWNjdXJhY3kiOiJoaWdoIiwibW9kaWZpZWREYXRlIjoxNjQ0OTg0NDQzMDIzLCJnaWZ0QWRkcmVzcyI6ZmFsc2UsImZpcnN0TmFtZSI6Illpbmd5dWUiLCJsYXN0TmFtZSI6IkdvaW5ncyJ9LCJhc3NvcnRtZW50Ijp7Im5vZGVJZCI6IjMwOTgiLCJkaXNwbGF5TmFtZSI6IkJlbGxldnVlIE5laWdoYm9yaG9vZCBNYXJrZXQiLCJhY2Nlc3NQb2ludHMiOm51bGwsInN1cHBvcnRlZEFjY2Vzc1R5cGVzIjpbXSwiaW50ZW50IjoiUElDS1VQIiwic2NoZWR1bGVFbmFibGVkIjpmYWxzZX0sImluc3RvcmUiOmZhbHNlLCJyZWZyZXNoQXQiOjE2NjAwMTI2MzQ5MzMsInZhbGlkYXRlS2V5IjoicHJvZDp2MjphMzE3OWZkZS0zMTYwLTQ5MTEtOGMyMS05MTg5NjdkMmU5ZWMifQ%3D%3D; assortmentStoreId=3098; hasLocData=1; TB_Latency_Tracker_100=1; TB_Navigation_Preload_01=1; TB_SFOU-100=; bstc=SIagoB2tyG62i7hTVu8vng; mobileweb=0; xpa=1A0pE|4eEiX|5mXkC|78jM7|927zv|9aQs1|AIud-|Af1yH|CN28l|E4WND|IOIpg|LTD5Y|MZ8aF|Nnski|NuISU|O1c3v|QFWT5|RZlxg|SmVSa|TA_mk|X6RCs|XBPw9|ZKQTc|bcl64|cfVAR|dK8qH|duBe9|elin2|iaKHs|kUFvx|lqVt_|n3tYK|nybjr|oDpYF|oIQlM|odFJG|phpX6|q826r|qsDvB|qyn67|qzcBg|r8csb|rxmwe|uJQh6|uru_L|yefCT|yxNJ6|zCylr|zIYIr; exp-ck=4eEiX178jM71927zv19aQs12Af1yH1E4WND1MZ8aF1Nnski1NuISU1O1c3v2QFWT51SmVSa1TA_mk2X6RCs1XBPw91dK8qH1iaKHs1kUFvx1n3tYK1nybjr2oIQlM1odFJG1phpX61q826r1qsDvB1qyn672r8csb1yefCT1yxNJ65zIYIr1; _astc=a90c415f4aa683a6946d96c09b6578e6; xpm=1%2B1659991034%2BZQEKmh8wbDUTmajKGEX264~a3179fde-3160-4911-8c21-918967d2e9ec%2B0; dimensionData=743; wmlh=d4831d3c66d3a76c555ec3826b29dac4556990c5a6188d6c05b7f34ff1192735; bm_mi=1E9824AAD8CBBE1D0B66C94539231D9D~YAAQFY0duDSiiGOCAQAAVQUwfxDuC6u0QHSlyyBoxf4sb6HpBqAJ7ZHei31AdPzgLKlNTSZ3wOzNkPH+J1qK1GcgoMLsrGOcGaZnGmuaBC/3VznEhZHk5yqOuY+BYpiXZ5g4O/PmLa3TWw/bxFzCkb00/TXui1THxEWbx9Jr6/GF0fU3lD0yV+NnMZQCvv7WvFjJhooOzspBegVubMWN5s7gnia8a3lNK3914TCQDRfkdyB7Q/LEn3Sb4yPcI76sA7EFpQN9EENlHAhyPDNfOioCOJmVr8vZtDz67wyMP4pvP9MM6/25mJt2Q6IGq5C58WHurjQ=~1; bm_sv=FF0C069C5A54A66787A1AD1A59970A2B~YAAQFY0duE+riGOCAQAA7UAwfxDR+MQ+SqkCkvobaDx7HLV4VQH5NzYwoCWJwgwndFlwil3mNaQA4YdHHIa/qxLncnZMqJ63DegILmdWNxrVnDtIs6VjVY8osWmu3B0J1QiguljA6ZjJUXc+U/MvWpm+cX0b+7+bpbQcHMJzK6BBfoOzLufjDd+tp9GyEVZ9dt3p5UQVbR4QiWIDbKuFxQFF2hf49wOwtqJu8MdQN5RM8y0kxGc2/YI4g+pZcmd15ac=~1; ak_bmsc=E9B2A792FB3C45F5FF3256E5AFFF5305~000000000000000000000000000000~YAAQFY0duJariGOCAQAAk0IwfxDI8W5ztmzNG0SG0pXdhuUfRSntCY8tj5Y4ozd2G+Jk8sfy/f+UTEy63P5PeBc9kGxTVt1TDuCXkim8YlQnA1tPPyEpfX9GItifYvQ6Wjnlp7VEe2vldV2pq3bmG8w9r9R/DvBtEu5TTmfg2FJjhi94IlXjxRTJKLSHhAF8+vfvmLHrpHv0vd9X3S0c5qxNHJHPBkBJp+bWYXdsl1Oq77D8l3glq7Bg6Qdq4YH814Mmz0yCUSUmgqFM9Oz7f3usXfNX11DJnNS0qsa1x3LUTD0ezkt1tdSMDxPgwpI6QCVtH1jvuNns/DplVvDq7Q/mDiwNnH+enadgEVWcDm3YdR16B9ZksHcLgV8UUJa/iFErhgtf+dAoTSJrEqFemvdk4zy0K1kVC1/Gdeuev6tMQ+4AHJcIqOKfOuu8n2a/L/PL0ys=; adblocked=true; com.wm.reflector=\"reflectorid:imp_QNXzy4XWkxyIRLjXHcR4YXWRUkDx7ZQiESQYU80@lastupd:1659991637000@firstcreate:1654187256686\"; TS01b0be75=01538efd7cb0f7d70d3f2a4f0184e2dfb62522b821df71739c28bee1098661c999cf79df51e8c1fe3f71e480b215f28df2770b502e; auth=MTAyOTYyMDE4%2FlD8kJIulEW7LgRHWgcH94ei7v0GYSi3oby5oozhfRD4ZzF9B0xi8xy1%2FVQ%2Fs3Dm7u1n4XQ7wE7VSsKevYOuY9fGXWdEY%2F24RTdMylPqkvhvmJGVGaqwo%2BHDx6bZQptJEk8ozGbo5MEn1vkTvRAX7b7LUiIDuTvf5uU3uvySDLvFZsa13wS3MTN7U8eO5wXn43u2Fuo%2B2u39VG2IRjjn2TWK8DRV7WegEDnNeeLB8fE%2FRn9yGf%2FIUg7988ZIy%2FAl9gq5HzyXSnOoFi9bPAYpjSsQ5HsQluZiyTdisdCvQao5iZ1YH1p%2FztKBuD3RTboo%2B19Gsh6kCyN%2FRZN%2BRDk5D6sxB2psTVmBueMQLCOsWd7HhfaU2QlRCS1TvguTy8BWLf%2F5yvR5dY1HivPS2AYXZpacwyh4jmkr9TcCIXD4RZk%3D; xptwg=3312775449:156C9E1226C3610:376E951:85554D8D:2323FFBB:27BC18AB:; TS012768cf=0162aeaf8603e1df16ad86ebb5a0adf83b53d26253fcd943fbcdd82662836da53a4095af02264ed456939d0bc1976b84d95a078d09; TS01a90220=0162aeaf8603e1df16ad86ebb5a0adf83b53d26253fcd943fbcdd82662836da53a4095af02264ed456939d0bc1976b84d95a078d09; TS2a5e0c5c027=08281e41a8ab2000b3b2223b213663b430113057e560ae289edfb58b0568623b971c67aa967f3e490820678f7a1130006b222de4e06a27846604bedcf0e5269837a80419599d340389e78e1e431b30fbb10712d171509f6d78902cbb7f30d071; akavpau_p2=1659992571~id=bbde09c6234375969238c0fca4213b0f");
		httpConn.setRequestProperty("device_profile_ref_id", "ypgq4T9i5Oi1JN7brkk0rgeejZx0rrHpAIhq");
		httpConn.setRequestProperty("origin", "https://www.walmart.com");
		httpConn.setRequestProperty("pragma", "no-cache");
		httpConn.setRequestProperty("referer", String.format("https://www.walmart.com/search?q=%s", query_param));
		httpConn.setRequestProperty("sec-ch-ua", "\".Not/A)Brand\";v=\"99\", \"Google Chrome\";v=\"103\", \"Chromium\";v=\"103\"");
		httpConn.setRequestProperty("sec-ch-ua-mobile", "?0");
		httpConn.setRequestProperty("sec-ch-ua-platform", "\"macOS\"");
		httpConn.setRequestProperty("sec-fetch-dest", "empty");
		httpConn.setRequestProperty("sec-fetch-mode", "cors");
		httpConn.setRequestProperty("sec-fetch-site", "same-origin");
		httpConn.setRequestProperty("traceparent", "DRmPfZEvmPQ42cVmI3XUawgFu8VdvXfR3I8E");
		httpConn.setRequestProperty("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Safari/537.36");
		httpConn.setRequestProperty("wm_mp", "true");
		httpConn.setRequestProperty("wm_page_url", String.format("https://www.walmart.com/search?q=%s", query_param));
		httpConn.setRequestProperty("wm_qos.correlation_id", "DRmPfZEvmPQ42cVmI3XUawgFu8VdvXfR3I8E");
		httpConn.setRequestProperty("x-apollo-operation-name", "Search");
		httpConn.setRequestProperty("x-enable-server-timing", "1");
		httpConn.setRequestProperty("x-latency-trace", "1");
		httpConn.setRequestProperty("x-o-bu", "WALMART-US");
		httpConn.setRequestProperty("x-o-ccm", "server");
		httpConn.setRequestProperty("x-o-correlation-id", "DRmPfZEvmPQ42cVmI3XUawgFu8VdvXfR3I8E");
		httpConn.setRequestProperty("x-o-gql-query", "query Search");
		httpConn.setRequestProperty("x-o-mart", "B2C");
		httpConn.setRequestProperty("x-o-platform", "rweb");
		httpConn.setRequestProperty("x-o-platform-version", "main-1.13.0-da9c05");
		httpConn.setRequestProperty("x-o-segment", "oaoh");

		httpConn.setDoOutput(true);
		OutputStreamWriter writer = new OutputStreamWriter(httpConn.getOutputStream());
		writer.write(String.format("{\"query\":\"query Search( $query:String $page:Int $prg:Prg! $facet:String $sort:Sort = best_match $catId:String $max_price:String $min_price:String $spelling:Boolean = true $affinityOverride:AffinityOverride $storeSlotBooked:String $ps:Int $ptss:String $recall_set:String $fitmentFieldParams:JSON ={}$fitmentSearchParams:JSON ={}$fetchMarquee:Boolean! $trsp:String $fetchSkyline:Boolean! $fetchSbaTop:Boolean! $additionalQueryParams:JSON ={}$searchArgs:SearchArgumentsForCLS $enablePortableFacets:Boolean = false $intentSource:IntentSource $tenant:String! $enableFacetCount:Boolean = true $pageType:String! = \\\"SearchPage\\\" ){search( query:$query page:$page prg:$prg facet:$facet sort:$sort cat_id:$catId max_price:$max_price min_price:$min_price spelling:$spelling affinityOverride:$affinityOverride storeSlotBooked:$storeSlotBooked ps:$ps ptss:$ptss recall_set:$recall_set trsp:$trsp intentSource:$intentSource additionalQueryParams:$additionalQueryParams pageType:$pageType ){query searchResult{...SearchResultFragment}}contentLayout( channel:\\\"WWW\\\" pageType:$pageType tenant:$tenant searchArgs:$searchArgs ){modules{...ModuleFragment configs{...SearchNonItemFragment __typename...on TempoWM_GLASSWWWSponsoredProductCarouselConfigs{_rawConfigs}...on _TempoWM_GLASSWWWSearchSortFilterModuleConfigs{facetsV1 @skip(if:$enablePortableFacets){...FacetFragment}topNavFacets @include(if:$enablePortableFacets){...FacetFragment}allSortAndFilterFacets @include(if:$enablePortableFacets){...FacetFragment}}...on _TempoWM_GLASSWWWSearchGuidedNavModuleConfigs{guidedNavigation{...GuidedNavFragment}}...on TempoWM_GLASSWWWPillsModuleConfigs{moduleSource pillsV2{...PillsModuleFragment}}...TileTakeOverProductFragment...on TempoWM_GLASSWWWSearchFitmentModuleConfigs{fitments( fitmentSearchParams:$fitmentSearchParams fitmentFieldParams:$fitmentFieldParams ){...FitmentFragment sisFitmentResponse{...SearchResultFragment}}}...on TempoWM_GLASSWWWStoreSelectionHeaderConfigs{fulfillmentMethodLabel storeDislayName}...BrandAmplifierAdConfigs @include(if:$fetchSbaTop)...BannerModuleFragment...MarqueeDisplayAdConfigsFragment @include(if:$fetchMarquee)...SkylineDisplayAdConfigsFragment @include(if:$fetchSkyline)...HorizontalChipModuleConfigsFragment...SkinnyBannerFragment}}...LayoutFragment pageMetadata{location{pickupStore deliveryStore intent postalCode stateOrProvinceCode city storeId accessPointId accessType spokeNodeId}pageContext}}}fragment SearchResultFragment on SearchInterface{title aggregatedCount...BreadCrumbFragment...DebugFragment...ItemStacksFragment...PageMetaDataFragment...PaginationFragment...SpellingFragment...SpanishTranslationFragment...RequestContextFragment...ErrorResponse modules{facetsV1 @skip(if:$enablePortableFacets){...FacetFragment}topNavFacets @include(if:$enablePortableFacets){...FacetFragment}allSortAndFilterFacets @include(if:$enablePortableFacets){...FacetFragment}guidedNavigation{...GuidedNavFragment}guidedNavigationV2{...PillsModuleFragment}pills{...PillsModuleFragment}spellCheck{title subTitle urlLinkText url}}}fragment ModuleFragment on TempoModule{name version type moduleId schedule{priority}matchedTrigger{zone}}fragment LayoutFragment on ContentLayout{layouts{id layout}}fragment BreadCrumbFragment on SearchInterface{breadCrumb{id name url}}fragment DebugFragment on SearchInterface{debug{sisUrl adsUrl}}fragment ItemStacksFragment on SearchInterface{itemStacks{displayMessage meta{adsBeacon{adUuid moduleInfo max_ads}query stackId stackType title layoutEnum totalItemCount totalItemCountDisplay viewAllParams{query cat_id sort facet affinityOverride recall_set min_price max_price}}itemsV2{...ItemFragment...InGridMarqueeAdFragment...TileTakeOverTileFragment}}}fragment ItemFragment on Product{__typename id usItemId fitmentLabel name checkStoreAvailabilityATC seeShippingEligibility brand type shortDescription weightIncrement imageInfo{...ProductImageInfoFragment}canonicalUrl externalInfo{url}itemType category{path{name url}}badges{flags{...on BaseBadge{key text type id}...on PreviouslyPurchasedBadge{id text key lastBoughtOn numBought}}tags{...on BaseBadge{key text type}}}classType averageRating numberOfReviews esrb mediaRating salesUnitType sellerId sellerName hasSellerBadge availabilityStatusV2{display value}groupMetaData{groupType groupSubType numberOfComponents groupComponents{quantity offerId componentType productDisplayName}}productLocation{displayValue aisle{zone aisle}}fulfillmentSpeed offerId preOrder{...PreorderFragment}priceInfo{...ProductPriceInfoFragment}variantCriteria{...VariantCriteriaFragment}snapEligible fulfillmentBadge fulfillmentTitle fulfillmentType brand manufacturerName showAtc sponsoredProduct{spQs clickBeacon spTags viewBeacon}showOptions showBuyNow rewards{eligible state minQuantity rewardAmt promotionId selectionToken cbOffer term expiry description}}fragment ProductImageInfoFragment on ProductImageInfo{thumbnailUrl size}fragment ProductPriceInfoFragment on ProductPriceInfo{priceRange{minPrice maxPrice}currentPrice{...ProductPriceFragment}comparisonPrice{...ProductPriceFragment}wasPrice{...ProductPriceFragment}unitPrice{...ProductPriceFragment}listPrice{...ProductPriceFragment}savingsAmount{...ProductSavingsFragment}shipPrice{...ProductPriceFragment}subscriptionPrice{priceString subscriptionString}priceDisplayCodes{priceDisplayCondition finalCostByWeight submapType}}fragment PreorderFragment on PreOrder{isPreOrder preOrderMessage preOrderStreetDateMessage}fragment ProductPriceFragment on ProductPrice{price priceString variantPriceString priceType currencyUnit priceDisplay}fragment ProductSavingsFragment on ProductSavings{amount percent priceString}fragment VariantCriteriaFragment on VariantCriterion{name type id isVariantTypeSwatch variantList{id images name rank swatchImageUrl availabilityStatus products selectedProduct{canonicalUrl usItemId}}}fragment InGridMarqueeAdFragment on MarqueePlaceholder{__typename type moduleLocation lazy}fragment TileTakeOverTileFragment on TileTakeOverProductPlaceholder{__typename type tileTakeOverTile{span title subtitle image{src alt}logoImage{src alt}backgroundColor titleTextColor subtitleTextColor tileCta{ctaLink{clickThrough{value}linkText title}ctaType ctaTextColor}}}fragment PageMetaDataFragment on SearchInterface{pageMetadata{storeSelectionHeader{fulfillmentMethodLabel storeDislayName}title canonical description location{addressId}}}fragment PaginationFragment on SearchInterface{paginationV2{maxPage pageProperties}}fragment SpanishTranslationFragment on SearchInterface{translation{metadata{originalQuery translatedQuery isTranslated translationOfferType moduleSource}translationModule{title urlLinkText originalQueryUrl}}}fragment SpellingFragment on SearchInterface{spelling{correctedTerm}}fragment RequestContextFragment on SearchInterface{requestContext{vertical isFitmentFilterQueryApplied searchMatchType categories{id name}}}fragment ErrorResponse on SearchInterface{errorResponse{correlationId source errorCodes errors{errorType statusCode statusMsg source}}}fragment GuidedNavFragment on GuidedNavigationSearchInterface{title url}fragment PillsModuleFragment on PillsSearchInterface{title url image:imageV1{src alt}}fragment BannerModuleFragment on TempoWM_GLASSWWWSearchBannerConfigs{moduleType viewConfig{title image imageAlt displayName description url urlAlt appStoreLink appStoreLinkAlt playStoreLink playStoreLinkAlt}}fragment FacetFragment on Facet{title name type layout min max selectedMin selectedMax unboundedMax stepSize isSelected values{id title name description type itemCount @include(if:$enableFacetCount) isSelected baseSeoURL}}fragment FitmentFragment on Fitments{partTypeIDs result{status formId position quantityTitle extendedAttributes{...FitmentFieldFragment}labels{...LabelFragment}resultSubTitle notes suggestions{...FitmentSuggestionFragment}}labels{...LabelFragment}savedVehicle{vehicleType{...VehicleFieldFragment}vehicleYear{...VehicleFieldFragment}vehicleMake{...VehicleFieldFragment}vehicleModel{...VehicleFieldFragment}additionalAttributes{...VehicleFieldFragment}}fitmentFields{...VehicleFieldFragment}fitmentForms{id fields{...FitmentFieldFragment}title labels{...LabelFragment}}}fragment LabelFragment on FitmentLabels{ctas{...FitmentLabelEntityFragment}messages{...FitmentLabelEntityFragment}links{...FitmentLabelEntityFragment}images{...FitmentLabelEntityFragment}}fragment FitmentLabelEntityFragment on FitmentLabelEntity{id label}fragment VehicleFieldFragment on FitmentVehicleField{id label value}fragment FitmentFieldFragment on FitmentField{id displayName value extended data{value label}dependsOn}fragment FitmentSuggestionFragment on FitmentSuggestion{id position loadIndex speedRating searchQueryParam labels{...LabelFragment}cat_id fitmentSuggestionParams{id value}}fragment MarqueeDisplayAdConfigsFragment on TempoWM_GLASSWWWMarqueeDisplayAdConfigs{_rawConfigs ad{...DisplayAdFragment}}fragment DisplayAdFragment on Ad{...AdFragment adContent{type data{__typename...AdDataDisplayAdFragment}}}fragment AdFragment on Ad{status moduleType platform pageId pageType storeId stateCode zipCode pageContext moduleConfigs adsContext adRequestComposite}fragment AdDataDisplayAdFragment on AdData{...on DisplayAd{json status}}fragment SkylineDisplayAdConfigsFragment on TempoWM_GLASSWWWSkylineDisplayAdConfigs{_rawConfigs ad{...SkylineDisplayAdFragment}}fragment SkylineDisplayAdFragment on Ad{...SkylineAdFragment adContent{type data{__typename...SkylineAdDataDisplayAdFragment}}}fragment SkylineAdFragment on Ad{status moduleType platform pageId pageType storeId stateCode zipCode pageContext moduleConfigs adsContext adRequestComposite}fragment SkylineAdDataDisplayAdFragment on AdData{...on DisplayAd{json status}}fragment BrandAmplifierAdConfigs on TempoWM_GLASSWWWBrandAmplifierAdConfigs{_rawConfigs moduleLocation ad{...SponsoredBrandsAdFragment}}fragment SponsoredBrandsAdFragment on Ad{...AdFragment adContent{type data{__typename...AdDataSponsoredBrandsFragment}}}fragment AdDataSponsoredBrandsFragment on AdData{...on SponsoredBrands{adUuid adExpInfo moduleInfo brands{logo{featuredHeadline featuredImage featuredImageName featuredUrl logoClickTrackUrl}products{...ProductFragment}}}}fragment ProductFragment on Product{usItemId offerId badges{flags{__typename...on BaseBadge{id text key query type}...on PreviouslyPurchasedBadge{id text key lastBoughtOn numBought criteria{name value}}}labels{__typename...on BaseBadge{id text key}...on PreviouslyPurchasedBadge{id text key lastBoughtOn numBought}}tags{__typename...on BaseBadge{id text key}}}priceInfo{priceDisplayCodes{rollback reducedPrice eligibleForAssociateDiscount clearance strikethrough submapType priceDisplayCondition unitOfMeasure pricePerUnitUom}currentPrice{price priceString}wasPrice{price priceString}priceRange{minPrice maxPrice priceString}unitPrice{price priceString}}showOptions sponsoredProduct{spQs clickBeacon spTags}canonicalUrl numberOfReviews averageRating availabilityStatus imageInfo{thumbnailUrl allImages{id url}}name fulfillmentBadge classType type showAtc p13nData{predictedQuantity flags{PREVIOUSLY_PURCHASED{text}CUSTOMERS_PICK{text}}labels{PREVIOUSLY_PURCHASED{text}CUSTOMERS_PICK{text}}}}fragment SearchNonItemFragment on TempoWM_GLASSWWWSearchNonItemConfigs{title subTitle urlLinkText url}fragment HorizontalChipModuleConfigsFragment on TempoWM_GLASSWWWHorizontalChipModuleConfigs{chipModuleSource:moduleSource chipModule{title url{linkText title clickThrough{type value}}}chipModuleWithImages{title url{linkText title clickThrough{type value}}image{alt clickThrough{type value}height src title width}}}fragment SkinnyBannerFragment on TempoWM_GLASSWWWSkinnyBannerConfigs{bannerType desktopBannerHeight bannerImage{src title alt}mobileBannerHeight mobileImage{src title alt}clickThroughUrl{clickThrough{value}}backgroundColor heading{title fontColor}subHeading{title fontColor}bannerCta{ctaLink{linkText clickThrough{value}}textColor ctaType}}fragment TileTakeOverProductFragment on TempoWM_GLASSWWWTileTakeOverProductConfigs{dwebSlots mwebSlots TileTakeOverProductDetails{pageNumber span dwebPosition mwebPosition title subtitle image{src alt}logoImage{src alt}backgroundColor titleTextColor subtitleTextColor tileCta{ctaLink{clickThrough{value}linkText title}ctaType ctaTextColor}}}\",\"variables\":{\"id\":\"\",\"dealsId\":\"\",\"query\":\"%s\",\"page\":1,\"prg\":\"desktop\",\"catId\":\"\",\"facet\":\"\",\"sort\":\"best_match\",\"rawFacet\":\"\",\"seoPath\":\"\",\"ps\":40,\"ptss\":\"\",\"trsp\":\"\",\"beShelfId\":\"\",\"recall_set\":\"\",\"module_search\":\"\",\"min_price\":\"\",\"max_price\":\"\",\"storeSlotBooked\":\"\",\"additionalQueryParams\":{\"hidden_facet\":null,\"translation\":null},\"searchArgs\":{\"query\":\"%s\",\"cat_id\":\"\",\"prg\":\"desktop\",\"facet\":\"\"},\"fitmentFieldParams\":{\"powerSportEnabled\":true},\"fitmentSearchParams\":{\"id\":\"\",\"dealsId\":\"\",\"query\":\"%s\",\"page\":1,\"prg\":\"desktop\",\"catId\":\"\",\"facet\":\"\",\"sort\":\"best_match\",\"rawFacet\":\"\",\"seoPath\":\"\",\"ps\":40,\"ptss\":\"\",\"trsp\":\"\",\"beShelfId\":\"\",\"recall_set\":\"\",\"module_search\":\"\",\"min_price\":\"\",\"max_price\":\"\",\"storeSlotBooked\":\"\",\"additionalQueryParams\":{\"hidden_facet\":null,\"translation\":null},\"searchArgs\":{\"query\":\"%s\",\"cat_id\":\"\",\"prg\":\"desktop\",\"facet\":\"\"},\"cat_id\":\"\",\"_be_shelf_id\":\"\"},\"enablePortableFacets\":true,\"enableFacetCount\":false,\"fetchMarquee\":true,\"fetchSkyline\":true,\"fetchSbaTop\":true,\"tenant\":\"WM_GLASS\",\"pageType\":\"SearchPage\"}}", query_param, query_param, query_param, query_param));
		writer.flush();
		writer.close();
		httpConn.getOutputStream().close();

		InputStream responseStream = httpConn.getResponseCode() / 100 == 2
				? httpConn.getInputStream()
				: httpConn.getErrorStream();
		Scanner s = new Scanner(responseStream).useDelimiter("\\A");
		String response = s.hasNext() ? s.next() : "";

		JsonElement jsonElement = new JsonParser().parse(response);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(jsonElement);

		System.out.println(json);

		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> jsonMap = objectMapper.readValue(json, new TypeReference<Map<String, Object>>(){});
		Object data = jsonMap.get("data");
		Map<String, Object> dataMap = objectMapper.convertValue(data, Map.class);

		// GETTING BRANDS

		Object contentLayout = dataMap.get("contentLayout");
		Map<String, Object> contentLayoutMap = objectMapper.convertValue(contentLayout, Map.class);

		Object modules = contentLayoutMap.get("modules");
		ArrayList<Object> modulesAL = objectMapper.convertValue(modules, ArrayList.class);

		Object chosenModule = modulesAL.get(1);
		Map<String, Object> moduleMap = objectMapper.convertValue(chosenModule, Map.class);

		Object configs = moduleMap.get("configs");
		Map<String, Object> configsMap = objectMapper.convertValue(configs, Map.class);

		Object topNavFacets = configsMap.get("topNavFacets");
//		if ()
		ArrayList<Object> topNavFacetsAL = objectMapper.convertValue(topNavFacets, ArrayList.class);

		Object chosenFacet = topNavFacetsAL.get(2);
		Map<String, Object> chosenFacetMap = objectMapper.convertValue(chosenFacet, Map.class);

		Object values = chosenFacetMap.get("values");
		ArrayList<Object> brandsAL = objectMapper.convertValue(values, ArrayList.class);

		Set<String> brands = new HashSet<>();

		for (Object brand : brandsAL) {
			Map<String, String> brandInfo = objectMapper.convertValue(brand, Map.class);
			brands.add(brandInfo.get("name"));
		}

//		System.out.println(brands);

		// GETTING PRODUCTS

		Object search = dataMap.get("search");

		Map<String, Object> searchMap = objectMapper.convertValue(search, Map.class);
		Object searchResult = searchMap.get("searchResult");

		Map<String, Object> searchResultMap = objectMapper.convertValue(searchResult, Map.class);
		Object itemStacks = searchResultMap.get("itemStacks");

		ArrayList<Object> itemStacksAL = objectMapper.convertValue(itemStacks, ArrayList.class);
		Object firstInAL = itemStacksAL.get(0);

		Map<String, Object> itemsV2Map = objectMapper.convertValue(firstInAL, Map.class);
		Object itemsV2 = itemsV2Map.get("itemsV2");

		ArrayList<Object> itemsAL = objectMapper.convertValue(itemsV2, ArrayList.class);

		for (Object o : itemsAL) {
			// get name
			Map<String, Object> item = objectMapper.convertValue(o, Map.class);
			// System.out.println(item);
			Object name = item.get("name");
			String nameStr = objectMapper.convertValue(name, String.class);
			System.out.println(name);

			//get brand
			for (String brand : brands) {
				if (isBrand(nameStr, brand)) {
					System.out.println(brand);
					break;
				}
			}

			// get availability
			Map<String, Object> itemAvailability = objectMapper.convertValue(item.get("availabilityStatusV2"), Map.class);
			System.out.println(itemAvailability.get("display"));

			// get price
			Map<String, Object> itemPriceInfo = objectMapper.convertValue(item.get("priceInfo"), Map.class);
			if (itemPriceInfo.get("currentPrice") != null) {
				Map<String, Integer> itemCurPrice = objectMapper.convertValue(itemPriceInfo.get("currentPrice"), Map.class);
				System.out.println(itemCurPrice.get("price"));
			} else if (itemPriceInfo.get("priceRange") != null) {
				Map<String, Integer> itemPriceRange = objectMapper.convertValue(itemPriceInfo.get("priceRange"), Map.class);
				System.out.println(itemPriceRange.get("minPrice"));
				System.out.println(itemPriceRange.get("maxPrice"));
			}

			// get thumbnail image URL
			Object imageInfo = item.get("imageInfo");
			Map<String, Object> imageInfoMap = objectMapper.convertValue(imageInfo, Map.class);
			Object thumbnailURL = imageInfoMap.get("thumbnailUrl");
			System.out.println(thumbnailURL);
			System.out.println("--------------------------------------------------------");
		}
	}

	public static boolean isBrand(String name, String brand) {
		if (name.contains(brand)) {
			return true;
		}
		String[] words = name.split(" ");
		for (String word : words) {
			if (word.length() > 1 && (oneLetterAway(word, brand) || oneLetterAway(brand, word))) {
				return true;
			}
		}
		return false;
	}

	public static boolean oneLetterAway(String word1, String word2) {
		if (word1.equals(word2.substring(1))) {
			return true;
		} else if (word1.equals(word2.substring(0,word2.length()-1))) {
			return true;
		} else {
			for (int i = 1; i < word2.length()-1; i++) {
				if (word1.contains(word2.substring(0,i) + word2.substring(i+1))) {
					return true;
				}
			}
		}
		return false;
	}


//         JsonElement jsonElement = new JsonParser().parse(response);
//         Gson gson = new GsonBuilder().setPrettyPrinting().create();
//         String json = gson.toJson(jsonElement);

// 		System.out.println(json);

// 		ObjectMapper objectMapper = new ObjectMapper();
// 		Map<String, Object> jsonMap = objectMapper.readValue(json, new TypeReference<Map<String, Object>>(){});
// 		Object data = jsonMap.get("data");

// 		Map<String, Object> dataMap = objectMapper.convertValue(data, Map.class);
// 		Object search = dataMap.get("search");

// 		Map<String, Object> searchMap = objectMapper.convertValue(search, Map.class);
// 		Object searchResult = searchMap.get("searchResult");

// 		Map<String, Object> searchResultMap = objectMapper.convertValue(searchResult, Map.class);
// 		Object itemStacks = searchResultMap.get("itemStacks");

// 		ArrayList<Object> itemStacksAL = objectMapper.convertValue(itemStacks, ArrayList.class);
// 		Object firstInAL = itemStacksAL.get(0);

// 		Map<String, Object> itemsV2Map = objectMapper.convertValue(firstInAL, Map.class);
// 		Object itemsV2 = itemsV2Map.get("itemsV2");

// 		ArrayList<Object> itemsAL = objectMapper.convertValue(itemsV2, ArrayList.class);

// 		Set<String> BABYBRANDS = new HashSet<>();
// 		BABYBRANDS.add("Similac");
// 		BABYBRANDS.add("Enfamil");
// 		BABYBRANDS.add("Gerber");
// 		BABYBRANDS.add("Parent's Choice");
// 		BABYBRANDS.add("Enfagrow");
// 		BABYBRANDS.add("Earth's Best");
// 		BABYBRANDS.add("Aptamil");
// 		BABYBRANDS.add("Baby Water");
// 		BABYBRANDS.add("Bobbie Baby");
// 		BABYBRANDS.add("Enspire");
// 		BABYBRANDS.add("Nutramigen");
// 		BABYBRANDS.add("Nestle");
// 		BABYBRANDS.add("Bubs");
// 		BABYBRANDS.add("HappyBaby");
// 		BABYBRANDS.add("Kendamil");
// 		BABYBRANDS.add("Kinderlyte");
// 		BABYBRANDS.add("Pedialyte");
// 		BABYBRANDS.add("PediaSure");
// 		BABYBRANDS.add("Ready, Set, Food!");
// 		BABYBRANDS.add("up & up");

// // Set<String> h = new HashSet<>(Arrays.asList("a", "b"));


// 		for (Object o : itemsAL) {
// 			// get name
// 			Map<String,Object> item = objectMapper.convertValue(o, Map.class);
// 			// System.out.println(item);
// 			Object name = item.get("name");
// 			String nameStr = objectMapper.convertValue(name, String.class);
// 			System.out.println(name);

// 			//get brand
// 			for (String brand : BABYBRANDS) {
// 				if (isBrand(nameStr, brand)) {
// 					System.out.println(brand);
// 					break;
// 				}
// 			}

// 			// get availability
// 			Map<String,Object> itemAvailability = objectMapper.convertValue(item.get("availabilityStatusV2"), Map.class);
// 			System.out.println(itemAvailability.get("display"));

// 			// get price
// 			Map<String,Object> itemPriceInfo = objectMapper.convertValue(item.get("priceInfo"), Map.class);
// 			if (itemPriceInfo.get("currentPrice") != null) {
// 				Map<String,Integer> itemCurPrice = objectMapper.convertValue(itemPriceInfo.get("currentPrice"), Map.class);
// 				System.out.println(itemCurPrice.get("price"));
// 			} else if (itemPriceInfo.get("priceRange") != null) {
// 				Map<String,Integer> itemPriceRange = objectMapper.convertValue(itemPriceInfo.get("priceRange"), Map.class);
// 				System.out.println(itemPriceRange.get("minPrice"));
// 				System.out.println(itemPriceRange.get("maxPrice"));
// 			}

// 			// get thumbnail image URL
// 			Object imageInfo = item.get("imageInfo");
// 			Map<String,Object> imageInfoMap = objectMapper.convertValue(imageInfo, Map.class);
// 			Object thumbnailURL = imageInfoMap.get("thumbnailUrl");
// 			System.out.println(thumbnailURL);


// 			System.out.println("--------------------------------------------------------");
// 		}
// 	}

// 	public static boolean isBrand(String name, String brand) {
// 		if (name.contains(brand)) {
// 			return true;
// 		}
// 		String[] words = name.split(" ");
// 		for (String word : words) {
// 			if (oneLetterAway(word, brand) || oneLetterAway(brand, word)) {
// 				return true;
// 			}
// 		}
// 		return false;
// 	}

// 	public static boolean oneLetterAway(String word1, String word2) {
// 		if (word1.equals(word2.substring(1))) {
// 			return true;
// 		} else if (word1.equals(word2.substring(0,word2.length()-1))) {
// 			return true;
// 		} else {
// 			for (int i = 1; i < word2.length()-1; i++) {
// 				if (word1.contains(word2.substring(0,i) + word2.substring(i+1))) {
// 					return true;
// 				}
// 			}
// 		}
// 		return false;
// 	}

}

