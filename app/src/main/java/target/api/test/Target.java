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
		String query_param = "tampons";
		URL url = new URL("https://redsky.target.com/redsky_aggregations/v1/web_platform/product_summary_with_fulfillment_v1?key=9f36aeafbe60771e321a7cc95a78140772ab3e96&tcins=47919599%2C12213583%2C46793820%2C13369122%2C13369121%2C15104004%2C84743593%2C81782496%2C79186014%2C14670716%2C84743590%2C13190964%2C50616712%2C75663439%2C13368609%2C50567052%2C75663435%2C75665714%2C13397719%2C13368852%2C76155403%2C13368851%2C76155398%2C76155405%2C84743601%2C84743593%2C14013693%2C53062312&store_id=341&zip=98466&state=WA&latitude=47.220&longitude=-122.500&scheduled_delivery_store_id=341&required_store_id=341&has_required_store_id=true&channel=WEB&page=%2Fs%2F" + query_param);
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		httpConn.setRequestMethod("GET");

		httpConn.setRequestProperty("authority", "redsky.target.com");
		httpConn.setRequestProperty("accept", "application/json");
		httpConn.setRequestProperty("accept-language", "en-US,en;q=0.9");
		httpConn.setRequestProperty("cookie", "visitorId=0181938BBD490101090C181D718F7791; _ga=GA1.2.1006365120.1656037818; TealeafAkaSid=I7QGfsmWIy3e_1wGLzGAYN-W45q5pP6w; sapphire=1; UserLocation=98466|47.220|-122.500|WA|US; __gads=ID=2a1410723e0ab8e1:T=1658858371:S=ALNI_MbhEV1f5RMDlF0K918Ksx8AZs7WGA; fiatsCookie=DSI_341|DSN_North%20Tacoma|DSZ_98405; ci_pixmgr=other; _gcl_au=1.1.951098859.1658858374; accessToken=eyJraWQiOiJlYXMyIiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJjOWNkM2U1Zi0yMzA0LTRjNWItOGExNC1kNzQxNWI2NTZmNDQiLCJpc3MiOiJNSTYiLCJleHAiOjE2NjAxMDc4NjIsImlhdCI6MTY2MDAyMTQ2MiwianRpIjoiVEdULjZhZmYzMjczMjY5NTRkZDE5MWExNDhkMTUxOGJiNDA2LWwiLCJza3kiOiJlYXMyIiwic3V0IjoiRyIsImRpZCI6ImRiOTU5MjUzMjEyZjJhYjFlNWI0NDA4MjFjZmVkYTllOTcyYTE5YjExYTlhNzNhYjliMTM5NzFhMzlmYzM0NTgiLCJzY28iOiJlY29tLm5vbmUsb3BlbmlkIiwiY2xpIjoiZWNvbS13ZWItMS4wLjAiLCJhc2wiOiJMIn0.prX2bMXAWm6QKnKvUYSf59RIyZGGKbud5-iAd7LdpHkR5tMKjDQXuclF0NTt1txO8YrzZANLE8KlOA-q1rEkHDAhKS8Kysgor3MRem0V1QneTTfECPOXVseNmhcmO8-iE1EQcHVlJg5unyQiGX5uwZJw_yTge4DzV8x_T7i9Xyrj7a9eRhH7C9HEn9nwtCbypeXfZPuvvjn4oPZa_2XuvTZ2lXgAJfpfkbcV8dc2vdTCRm0M5qcExNrOdLmCA4rTBv-ZUEp-oqv8ZY2k6IBbiftrqfnVQ-s6HCABGMyWe2D_AbpCodO23o4Cgs2kWNIuvT4N4I8mUEcYj_0b1_7GyA; idToken=eyJhbGciOiJub25lIn0.eyJzdWIiOiJjOWNkM2U1Zi0yMzA0LTRjNWItOGExNC1kNzQxNWI2NTZmNDQiLCJpc3MiOiJNSTYiLCJleHAiOjE2NjAxMDc4NjIsImlhdCI6MTY2MDAyMTQ2MiwiYXNzIjoiTCIsInN1dCI6IkciLCJjbGkiOiJlY29tLXdlYi0xLjAuMCIsInBybyI6eyJmbiI6bnVsbCwiZW0iOm51bGwsInBoIjpmYWxzZSwibGVkIjpudWxsLCJsdHkiOmZhbHNlfX0.; refreshToken=ZD_fSy1b847w6l6QifD3eunjwblypCApwutLPCbRhgeBcRCJ69Q52ZFvZp-orKwlXHx3m0yStP9Qz2dId6GpRg; __gpi=UID=00000765560dad2f:T=1658858371:RT=1660079921:S=ALNI_Mb_xIu8kUl-Mk0pZX5BVqhxk88i7A; ffsession={%22sessionHash%22:%221fd1ef4adc48651658858368483%22%2C%22prevPageName%22:%22home%20page%22%2C%22prevPageType%22:%22home%20page%22%2C%22prevPageUrl%22:%22https://www.target.com/%22%2C%22sessionHit%22:45%2C%22prevSearchTerm%22:%22tampax%20pearl%22}; _uetsid=d77e2980182811ed954b85f674280740; _uetvid=b4a23c200d0c11ed8f60adcad669d115; _mitata=ZDJhNjc4OTkwZDU3OTRiNWM5MzJkMDE5ZGVkOGFlYjhhMWUzOTVlMTg5N2E2OWY3YTc3ODViYTc4MDJjNDA0Mw==_/@#/1660080403_/@#/cXvOXFmcHZHhiEid_/@#/ODE3OTNhNGRiMmI1ZWUzN2U0YjJlNTFhZWZlNDRjNmQ0MDcyOGEwNzZhOTI5ZWI1MDYwZThmY2NlZDFlNmIxZA==_/@#/000");
		httpConn.setRequestProperty("origin", "https://www.target.com");
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

		ObjectMapper objectMapper = new ObjectMapper();
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
			System.out.println(productTitle);

			// get brand

			// get purchase url
			Object enrichment = productItemMap.get("enrichment");
			Map<String, String> enrichmentMap = objectMapper.convertValue(enrichment, Map.class);
			String buyURL = enrichmentMap.get("buy_url");
			System.out.println(buyURL);

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
//			Object productInStock = productFulfillmenteMap.get("is_out_of_stock_in_all_store_locations");
			System.out.println(!(productInStock));
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
				System.out.println(true);
			} else {
				System.out.println(false);
			}

			//

			System.out.println("-------------------------------------------------------------------------");
		}

//		System.out.println(productSummaries);
	}
}