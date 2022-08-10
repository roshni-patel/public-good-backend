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

		HashMap<String, HashMap> productsInfo = new HashMap<>();


		// TO GET TITLE, BRAND, IMAGEURL, PRICE INFO
		String query_param = "tampons";
		URL url1 = new URL("https://redsky.target.com/redsky_aggregations/v1/web/plp_search_v1?key=9f36aeafbe60771e321a7cc95a78140772ab3e96&channel=WEB&count=24&default_purchasability_filter=true&include_sponsored=true&keyword=" + query_param +"&offset=0&page=%2Fs%2F" + query_param + "&platform=desktop&pricing_store_id=3286&scheduled_delivery_store_id=1284&store_ids=3286%2C1284%2C3327%2C2786%2C3275&useragent=Mozilla%2F5.0+%28Macintosh%3B+Intel+Mac+OS+X+10_15_7%29+AppleWebKit%2F537.36+%28KHTML%2C+like+Gecko%29+Chrome%2F103.0.0.0+Safari%2F537.36&visitor_id=0182843B4F9D0201868BE2386376FB07&zip=98115");
		HttpURLConnection httpConn1 = (HttpURLConnection) url1.openConnection();
		httpConn1.setRequestMethod("GET");

		httpConn1.setRequestProperty("authority", "redsky.target.com");
		httpConn1.setRequestProperty("accept", "application/json");
		httpConn1.setRequestProperty("accept-language", "en-US,en;q=0.9");
		httpConn1.setRequestProperty("cache-control", "no-cache");
		httpConn1.setRequestProperty("origin", "https://www.target.com");
		httpConn1.setRequestProperty("cookie", "TealeafAkaSid=RTUjt9VGF23P8jvML4ZtnvKj2gTiH8xj; visitorId=0182843B4F9D0201868BE2386376FB07; sapphire=1; UserLocation=98115|47.680|-122.320|WA|US; egsSessionId=09514e96-157a-45b9-913f-4eea401404da; accessToken=eyJraWQiOiJlYXMyIiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiIwZjVkZjNjNy1kZjNjLTRlMTYtOWQyYy04ZWNkZjRlMDEwMTUiLCJpc3MiOiJNSTYiLCJleHAiOjE2NjAxNjIyNTYsImlhdCI6MTY2MDA3NTg1NiwianRpIjoiVEdULmVmZTZkZTZiYTA1ODRjZmVhNTc1OWI1YmU0ZTk4Y2FmLWwiLCJza3kiOiJlYXMyIiwic3V0IjoiRyIsImRpZCI6ImNkNWMxMWJlYzU3NWM5MTM5MjdmNzExMWYzZGM5MzFkMDRmMmZkODAwZWU4OGZiMjJhNmM1MDQwNjliZWVjOTYiLCJzY28iOiJlY29tLm5vbmUsb3BlbmlkIiwiY2xpIjoiZWNvbS13ZWItMS4wLjAiLCJhc2wiOiJMIn0.aGlhShvcA2Ebplr8oGOenq4-yvghiSlCVv7E68YuPi-pgJ_2LVbpQfZVfmJpN-vqwuc0m6o_DkXeQvdrzjRI9oCWh0BYRN_l9YeY7mGZPwbWYu2s0DTUFHjvwX9qpFvhoFwKlpx-lcxiFkfiZXcsHn0aAQxs5PA5hFiCzrtfaxNbtJBtwn6pFiVIdc3uFUHSUA4CWbZ4lTAv150KrHXQW6w-MT0XBIy39gKvQ7_UelBUeO5Q0yZ3rorwcgJ1_S697SRCAkajr5q1q0jqiu3r3XpTbG2Mb7G8vvIuK3yrvBDUMGCrH5A8DPzXeNakyOg98BwZuaXOrnQj7af01RqTkw; idToken=eyJhbGciOiJub25lIn0.eyJzdWIiOiIwZjVkZjNjNy1kZjNjLTRlMTYtOWQyYy04ZWNkZjRlMDEwMTUiLCJpc3MiOiJNSTYiLCJleHAiOjE2NjAxNjIyNTYsImlhdCI6MTY2MDA3NTg1NiwiYXNzIjoiTCIsInN1dCI6IkciLCJjbGkiOiJlY29tLXdlYi0xLjAuMCIsInBybyI6eyJmbiI6bnVsbCwiZW0iOm51bGwsInBoIjpmYWxzZSwibGVkIjpudWxsLCJsdHkiOmZhbHNlfX0.; refreshToken=OD2VyL1pw-IAZRTuaG0f_gTNE0vxuXy-NpDpPq9NT0WVKhiV1JSMyuAyJWKa3FaOAcIiE_GKx2XB1Nxv7XfOkA; ffsession={%22sessionHash%22:%227edc48d97ec711660075856003%22%2C%22prevPageName%22:%22home%20page%22%2C%22prevPageType%22:%22home%20page%22%2C%22prevPageUrl%22:%22https://www.target.com/%22%2C%22sessionHit%22:1}; __gads=ID=7d1e1aea55049467:T=1660075856:S=ALNI_MZZkkXqduWzsF-W04xlnnLhamSkqw; __gpi=UID=000007bf85e8bf7a:T=1660075856:RT=1660075856:S=ALNI_MZFQzGyX4caavLN4GKEcnkNWcriZw; fiatsCookie=DSI_3286|DSN_Seattle%20University%20Way|DSZ_98105; ci_pixmgr=other; _uetsid=6102ac10181f11ed8bd0edd2f57e7248; _uetvid=6102afc0181f11ed97da8f2dc12d8943; _gcl_au=1.1.1067207836.1660075857; _mitata=OGJiOTdkNmIzMDAwOTEyYzIwODdjZGRkY2ZiMjJlZmJhYTU1YjM5ODZkNzMyNzNhNmUyMjMzNWU5ODgzZWNlOA==_/@#/1660075917_/@#/cCAdej1ZmSctaXAa_/@#/NTE1OTM2Y2UwMDc5YTY0M2M5NDk5ODJkODNjMWQ2ZWU0OWYzMmY2YzBlMGJlMTRmMzlhZTMxMzJjODVjZTkxNw==_/@#/000");
		httpConn1.setRequestProperty("pragma", "no-cache");
		httpConn1.setRequestProperty("referer", String.format("https://www.target.com/s?searchTerm=%s", query_param));
		httpConn1.setRequestProperty("sec-ch-ua", "\".Not/A)Brand\";v=\"99\", \"Google Chrome\";v=\"103\", \"Chromium\";v=\"103\"");
		httpConn1.setRequestProperty("sec-ch-ua-mobile", "?0");
		httpConn1.setRequestProperty("sec-ch-ua-platform", "\"macOS\"");
		httpConn1.setRequestProperty("sec-fetch-dest", "empty");
		httpConn1.setRequestProperty("sec-fetch-mode", "cors");
		httpConn1.setRequestProperty("sec-fetch-site", "same-site");
		httpConn1.setRequestProperty("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Safari/537.36");

		InputStream responseStream1 = httpConn1.getResponseCode() / 100 == 2
				? httpConn1.getInputStream()
				: httpConn1.getErrorStream();
		Scanner s1 = new Scanner(responseStream1).useDelimiter("\\A");
		String response1 = s1.hasNext() ? s1.next() : "";

		JsonElement jsonElement1 = new JsonParser().parse(response1);
		Gson gson1 = new GsonBuilder().setPrettyPrinting().create();
		String json1 = gson1.toJson(jsonElement1);

		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> jsonMap1 = objectMapper.readValue(json1, new TypeReference<Map<String, Object>>(){});
		Object data1 = jsonMap1.get("data");

		Map<String, Object> dataMap1 = objectMapper.convertValue(data1, Map.class);
		Object search1 = dataMap1.get("search");

		Map<String, Object> searchMap1 = objectMapper.convertValue(search1, Map.class);
		Object products1 = searchMap1.get("products");

		ArrayList<Object> productsAL1 = objectMapper.convertValue(products1, ArrayList.class);
		for (Object product : productsAL1) {
			HashMap<String, String> productInfo = new HashMap<>();

			Map<String, Object> productMap = objectMapper.convertValue(product, Map.class);

			// get title
			Object item = productMap.get("item");
			Map<String, Object> itemMap = objectMapper.convertValue(item, Map.class);
			Object productDescription = itemMap.get("product_description");
			Map<String, Object> productDescriptionMap = objectMapper.convertValue(productDescription, Map.class);
			Object title = productDescriptionMap.get("title");
			String titleStr = objectMapper.convertValue(title, String.class);
			productsInfo.put(titleStr, productInfo);

			// get brand name
			Object brandInfo = itemMap.get("primary_brand");
			Map<String, Object> brandInfoMap = objectMapper.convertValue(brandInfo, Map.class);
			Object brandName = brandInfoMap.get("name");
			String brandNameStr = objectMapper.convertValue(brandName, String.class);
			productInfo.put("brand", brandNameStr);

			// get price
			Object price = productMap.get("price");
			Map<String, Object> priceMap = objectMapper.convertValue(price, Map.class);
			Object curPrice = priceMap.get("formatted_current_price");
			String curPriceStr = objectMapper.convertValue(curPrice, String.class);
			productInfo.put("price", curPriceStr);

			// get primary image URL
			Object enrichment = itemMap.get("enrichment");
			Map<String, Object> enrichmentMap = objectMapper.convertValue(enrichment, Map.class);
			Object images = enrichmentMap.get("images");
			Map<String, Object> imagesMap = objectMapper.convertValue(images, Map.class);
			Object primaryImage = imagesMap.get("primary_image_url");
			String primaryImageStr = objectMapper.convertValue(primaryImage, String.class);
			productInfo.put("imageURL", primaryImageStr);
		}


		// TO GET AVAILABILITY INFO AND BUY URL FROM FULFILLMENT DATA
		URL url = new URL("https://redsky.target.com/redsky_aggregations/v1/web_platform/product_summary_with_fulfillment_v1?key=9f36aeafbe60771e321a7cc95a78140772ab3e96&tcins=79186014%2C13368852%2C46793820%2C13369122%2C13369121%2C15104004%2C13397722%2C51709785%2C84863038%2C14670716%2C13190964%2C84743590%2C50616712%2C75663439%2C13368609%2C50567052%2C13397719%2C75663435%2C13368852%2C75665714%2C76155403%2C53062312%2C76155398%2C13368851%2C84743601%2C84743593%2C13341830%2C76155405&store_id=3286&zip=98115&state=WA&latitude=47.680&longitude=-122.320&scheduled_delivery_store_id=1284&required_store_id=3286&has_required_store_id=true&channel=WEB&page=%2Fs%2F" + query_param);
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		httpConn.setRequestMethod("GET");

		httpConn.setRequestProperty("authority", "redsky.target.com");
		httpConn.setRequestProperty("accept", "application/json");
		httpConn.setRequestProperty("accept-language", "en-US,en;q=0.9");
		httpConn.setRequestProperty("cache-control", "no-cache");
		httpConn.setRequestProperty("cookie", "TealeafAkaSid=neJUPNahtbVSqTEu0frCOURvt6rBMr_3; visitorId=01828564AF2C0201A12B15E355E0BB85; sapphire=1; UserLocation=98115|47.680|-122.320|WA|US; egsSessionId=d135ad95-d091-4020-a73a-217dec91497c; accessToken=eyJraWQiOiJlYXMyIiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiI3NjQ5MDkyYy1kZWJlLTQzNDMtOTkxOS0wODllODQ4OTVjNWUiLCJpc3MiOiJNSTYiLCJleHAiOjE2NjAxODE3NDUsImlhdCI6MTY2MDA5NTM0NSwianRpIjoiVEdULjRkYzA4ZDc1M2FkYTRmMDc4N2QzZGNjYmQ4Zjk0MDJhLWwiLCJza3kiOiJlYXMyIiwic3V0IjoiRyIsImRpZCI6ImNhYWI3YmY1NmU1MDk5NjNiODgwNGViMzcwNTQ4NmFlZjAwMTJlMGM5ZWYwM2FlMTI1ZmI5YTdlNjRjMDI5MjUiLCJzY28iOiJlY29tLm5vbmUsb3BlbmlkIiwiY2xpIjoiZWNvbS13ZWItMS4wLjAiLCJhc2wiOiJMIn0.Nm3dCBqQpbBv0KqIV4zW6z4W7pCcRUir1bGfxyW35TsyiL7Z7Khp-wV6Ua_ZQOXToT0qWuzQKVYEd82hbHWxpz6eL4N2C-RHo0Htr8Rj4fVAOEPKtb_R9imMpkhNRKsbn_LkDblK0Im5iPgU7maItABI1V8lXG_I62_gUrMR245ACgq6SuFqy6dFLdIjEGuzWEiR1P_pFwgyedLKz4-BOUDoXz5qTQFPk-NPivPV0592wTV4PBCMyZ1237al8n2aUl4Fwbc9xsToOF-4_7t9XIrtUWRIUrel9dgDlFtOPTyv7023sYEUn6ZLpmiUp86qeN3AEKkmgGv0Cw5jJuMROQ; idToken=eyJhbGciOiJub25lIn0.eyJzdWIiOiI3NjQ5MDkyYy1kZWJlLTQzNDMtOTkxOS0wODllODQ4OTVjNWUiLCJpc3MiOiJNSTYiLCJleHAiOjE2NjAxODE3NDUsImlhdCI6MTY2MDA5NTM0NSwiYXNzIjoiTCIsInN1dCI6IkciLCJjbGkiOiJlY29tLXdlYi0xLjAuMCIsInBybyI6eyJmbiI6bnVsbCwiZW0iOm51bGwsInBoIjpmYWxzZSwibGVkIjpudWxsLCJsdHkiOmZhbHNlfX0.; refreshToken=95PKAAiF3guIPI77-2ORAqcMoIRHHIyu2bbhITzbL-AiCB_dDh9muywUSaqvJRBr9wXKGfRSSPYRXI9gPFTw2g; __gads=ID=911f663aeccde146:T=1660095345:S=ALNI_Ma8Ak8zbU5sSnvzyxdwc8K2YhFPtw; __gpi=UID=000007bfdb189f77:T=1660095345:RT=1660095345:S=ALNI_MYX_gQQw1ip8hniPB2p89WnUofbSA; ffsession={%22sessionHash%22:%22b4e729eba84cc1660095344942%22%2C%22prevPageName%22:%22home%20page%22%2C%22prevPageType%22:%22home%20page%22%2C%22prevPageUrl%22:%22https://www.target.com/%22%2C%22sessionHit%22:1}; fiatsCookie=DSI_3286|DSN_Seattle%20University%20Way|DSZ_98105; ci_pixmgr=other; _uetsid=c14d62e0184c11ed8e6d03b5ba7086e2; _uetvid=c14d7de0184c11eda2425f1127ebaa1d; _gcl_au=1.1.719876752.1660095346; _mitata=ODVhZjFiMWYxYTQ3NTMxYmRhNTVmOTQ4OWNmYjUyYzBmNDlmMjAyZDAwOGY3YjM0ODBlM2ViOTNmMmMwNDVhNg==_/@#/1660095405_/@#/cWhiS6B6I0gHwUPO_/@#/NDUyMmJkZGQ1YmQyYTJmNTE5MzYwOGNmNTljYTI0YzA0NDcyYTBhM2MzNzgxMGFkMmI0ZjBmYWM2NjljOTE3MA==_/@#/000");
		httpConn.setRequestProperty("origin", "https://www.target.com");
		httpConn.setRequestProperty("pragma", "no-cache");
		httpConn.setRequestProperty("referer", "https://www.target.com/s?searchTerm=" + query_param);
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

		Map<String, Object> jsonMap = objectMapper.readValue(json, new TypeReference<Map<String, Object>>(){});
		Object data = jsonMap.get("data");

		Map<String, ArrayList<Object>> dataMap = objectMapper.convertValue(data, Map.class);
		ArrayList<Object> productSummaries = dataMap.get("product_summaries");

		for (Object product : productSummaries) {
			Map<String, Object> productMap = objectMapper.convertValue(product, Map.class);


			Object productItem = productMap.get("item");
			Map<String, Object> productItemMap = objectMapper.convertValue(productItem, Map.class);


			// get title
			Object productDescription = productItemMap.get("product_description");
			Map<String, Object> productDescriptionMap = objectMapper.convertValue(productDescription, Map.class);
			Object productTitle = productDescriptionMap.get("title");
			String productTitleStr = objectMapper.convertValue(productTitle, String.class);
			HashMap<String, String> selectedProduct = null;
			if (productsInfo.get(productTitleStr) != null) {
				selectedProduct = productsInfo.get(productTitleStr);
			} else {
				System.out.println("NOT FOUND! CHECK FOR ERRORS!");
				continue;
			}

			// get brand

			// get purchase url
			Object enrichment = productItemMap.get("enrichment");
			Map<String, String> enrichmentMap = objectMapper.convertValue(enrichment, Map.class);
			String buyURL = enrichmentMap.get("buy_url");
			selectedProduct.put("buyURL", buyURL);

			// get image url

			// get price
			Object productPrice = productMap.get("price");
			Map<String, Double> productPriceMap = objectMapper.convertValue(productPrice, Map.class);
			Double productRTP = productPriceMap.get("current_retail");
			System.out.println(productRTP);

			// get availability
			Object productFulfillment = productMap.get("fulfillment");
			Map<String, Object> productFulfillmenteMap = objectMapper.convertValue(productFulfillment, Map.class);
			// all store locations
			boolean productInStock = objectMapper.convertValue(productFulfillmenteMap.get("is_out_of_stock_in_all_store_locations"), boolean.class);
			String inStockAtAllStores = objectMapper.convertValue(!(productInStock), String.class);
			selectedProduct.put("allStoresAvailability", inStockAtAllStores);
			// primary store location
			Object storeOptions = productFulfillmenteMap.get("store_options");
			ArrayList<Object> storeOptionsAL = objectMapper.convertValue(storeOptions, ArrayList.class);
			Object chosenStoreOption = storeOptionsAL.get(0);
			Map<String, Object> chosenStoreOptionMap = objectMapper.convertValue(chosenStoreOption, Map.class);
			Object inStoreOnly = chosenStoreOptionMap.get("in_store_only");
			Map<String, String> inStoreOnlyMap = objectMapper.convertValue(inStoreOnly, Map.class);
			String inStoreOnlyStatus = inStoreOnlyMap.get("availability_status");
			Object orderPickup = chosenStoreOptionMap.get("order_pickup");
			Map<String, String> orderPickupMap = objectMapper.convertValue(orderPickup, Map.class);
			String orderPickupStatus = orderPickupMap.get("availability_status");
			if (inStoreOnlyStatus.equals("IN_STOCK") || orderPickupStatus.equals("IN_STOCK")) {
				selectedProduct.put("closestStoreAvailability", "true");
			} else {
				selectedProduct.put("closestStoreAvailability", "false");
			}
		}
		Gson gsonFinal = new GsonBuilder().setPrettyPrinting().create();
		String jsonFinal = gson.toJson(productsInfo);
		System.out.println(jsonFinal);
	}
}