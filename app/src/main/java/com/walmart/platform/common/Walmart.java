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
		URL url = new URL("https://www.walmart.com/orchestra/home/graphql/browse?affinityOverride=default&page=1&prg=desktop&catId=5427_133283_4720344&sort=best_match&ps=40&searchArgs.cat_id=5427_133283_4720344&searchArgs.prg=desktop&fitmentFieldParams=true&fetchMarquee=true&fetchSkyline=true&fetchSbaTop=false&enablePortableFacets=true&tenant=WM_GLASS&enableFacetCount=true");
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		httpConn.setRequestMethod("POST");

		httpConn.setRequestProperty("authority", "www.walmart.com");
		httpConn.setRequestProperty("accept", "application/json");
		httpConn.setRequestProperty("accept-language", "en-US,en;q=0.9");
		httpConn.setRequestProperty("content-type", "application/json");
		httpConn.setRequestProperty("cookie", "mp_706c95f0b1efdbcfcce0f666821c2237_mixpanel=%7B%22distinct_id%22%3A%20%2218192b697aef09-0419d21b740702-1d525635-16a7f0-18192b697afea7%22%2C%22%24device_id%22%3A%20%2218192b697aef09-0419d21b740702-1d525635-16a7f0-18192b697afea7%22%2C%22%24initial_referrer%22%3A%20%22%24direct%22%2C%22%24initial_referring_domain%22%3A%20%22%24direct%22%7D; _gcl_au=1.1.1392224461.1656023855; _ga_1LB22TM2MG=GS1.1.1656023855.1.0.1656023855.0; _ga=GA1.2.1611646919.1656023756; __hstc=195562739.2b7e74e0fd3f71d9c227ee959384f881.1656023857266.1656023857266.1656023857266.1; hubspotutk=2b7e74e0fd3f71d9c227ee959384f881; _fbp=fb.1.1656023858266.1072122800; ACID=1b11efe4-db5a-4ab1-8cf3-3c30a2f7d4f1; hasACID=true; vtc=YBfoV0kSKPSBf6wglELIV0; dimensionData=805; _pxvid=cb6232ec-f350-11ec-bf4b-7a6542725454; QuantumMetricUserID=a735fa9a7b101d26f7b1eacb5c03b386; locGuestData=eyJpbnRlbnQiOiJQSUNLVVAiLCJpc0V4cGxpY2l0IjpmYWxzZSwic2Vjb25kYXJ5SW50ZW50IjoiaW5zdG9yZSIsInN0b3JlSW50ZW50IjoiUElDS1VQIiwibWVyZ2VGbGFnIjp0cnVlLCJpc0RlZmF1bHRlZCI6ZmFsc2UsInBpY2t1cCI6eyJub2RlSWQiOiIzMDk4IiwidGltZXN0YW1wIjoxNjU2MDI4ODg4MTYyfSwicG9zdGFsQ29kZSI6eyJ0aW1lc3RhbXAiOjE2NTYwMjg4ODgxNjIsImJhc2UiOiI5ODAwNyJ9LCJ2YWxpZGF0ZUtleSI6InByb2Q6djI6MWIxMWVmZTQtZGI1YS00YWIxLThjZjMtM2MzMGEyZjdkNGYxIn0%3D; _pxhd=3b33d783cef6864184923578ea90afbf2b6e32f22c4accc32807de5ad9f36a21:cb6232ec-f350-11ec-bf4b-7a6542725454; auth=MTAyOTYyMDE4yFWegjFLLRPCYSUjDpbSn9zeJrdjMb5n%2B1dqXXcpgcuTp4p29pNTOMQ%2BnZlnpNBdIjnmRcPmQ1sGAPIEOKPrejV7c1N5yVpDp8cl25FseCllzQKPU%2Fg2hpJm5OAIYat6767wuZloTfhm7Wk2KcjygsAEeU%2BeKCMhfP9XV060SY%2FVJq%2B4VLTM5zbtidP27iKwqVsWkc9clAYfNA%2FB0Sl34A5xGGTk%2FAqFlv1EwjpfEZ4UMk70P8glgOEpLOprhDfMM%2FFHGZ2dCNmxWrdkwqEKrsHzPxgcFzdLyenCiYrI8kwlKHP1ZLjmzcbJS%2FbbyPOyMWu5ZVxExFG4W8IQTd0RTK2%2FyV7xWOlUJ1hB5eVtl%2FsHrH5XYTms7EJ6J8%2BvuNlgWPKSgPo2%2BaWhC2QLnHF1YhAbajmc3a6HQbHZlS9HWyI%3D; assortmentStoreId=3098; hasLocData=1; TB_Latency_Tracker_100=1; TB_Navigation_Preload_01=1; TB_SFOU-100=; bstc=WrZZmZawBx2PRJl8cCMUzg; mobileweb=0; xpa=0oNAY|0t4gT|0wI6o|1A0pE|5mXkC|77hfu|927zv|9aQs1|AIud-|Ao5F6|CN28l|Gz2q7|HDfyl|IOIpg|Iui6D|JKpLb|L9j1I|Mta9s|NYsxn|NeQqX|Nrgbw|Nwf_w|O1c3v|SmVSa|T-onc|T4AR7|V-nnO|W7hWw|aPJIO|cfVAR|eEurn|gVG-b|lqVt_|mcVhX|nM__4|nzyw-|oDpYF|qsDvB|qyn67|qzcBg|r8csb|sbXp_|uHfV2|ymjfc|yuCad; exp-ck=0t4gT10wI6o177hfu1927zv19aQs12Gz2q71HDfyl2Iui6D1Nwf_w2O1c3v2SmVSa1T4AR71V-nnO1W7hWw1eEurn1gVG-b1nM__41nzyw-1qsDvB1qyn672r8csb1yuCad1; TS01b0be75=01538efd7cc49f2960a2381b26606567dc53059f4c784c856b6be642371249551bc53d2659a657acbed8885df00cd92aa049ac3905; TS013ed49a=01538efd7cc49f2960a2381b26606567dc53059f4c784c856b6be642371249551bc53d2659a657acbed8885df00cd92aa049ac3905; _astc=6bed189f391e741e6caf1bc065d82417; adblocked=false; xpm=1%2B1658957776%2BYBfoV0kSKPSBf6wglELIV0~%2B0; TBV=7; pxcts=2602085e-0df4-11ed-a7bf-7a716b725858; _pxff_cfp=1; tb_sw_supported=true; ak_bmsc=7E0E810C34E5116AAB4F1C04A8FE7D41~000000000000000000000000000000~YAAQP40duB4iQz6CAQAAl82WQRAEOEpaIywyq2ZW+VS4RFfctSUl2DrrwjRQIm4331+yGM5xnp3yaHlMEzlBfaYM/4WSa5wxNRmDqG2QkaP91tZsCsuNCK1Po3soOPlrIOf0HI9TXJxhWEo03pE6eIvSStGy2VWHmGPOUouMMS/XT/ajbJQOt8hylcqQDRpXqbl45ZoUYbloKr9b+T6cfQAwBzquTostw13RRQJ/MXk5D0ilaOiHagERki5ipusnm053YDT3qeToukpbssKXJful7jebMRhm6/+1XgSTepGcwB/oVm2umnTAVuZ6C9x7dGeXlR1Mo+LKLvxgyCsjo+pq0nzVGOjkx/ySMGizYeYoh1OQY4mGL4jT9S9HhJV9RHtFXhksrYrNbtlP7RxxLtC436XlXmy+ZPPrCYIZ/tnT5MDEKzH7eQ+E5cUTTSl20x6etCkirruZnighAKrvD8h7w/lDstJ966G6Q8BlnBXE4tuc+YZhtg1lJ7HW; locDataV3=eyJpc0RlZmF1bHRlZCI6ZmFsc2UsImlzRXhwbGljaXQiOmZhbHNlLCJpbnRlbnQiOiJQSUNLVVAiLCJwaWNrdXAiOlt7ImJ1SWQiOiIwIiwibm9kZUlkIjoiMzA5OCIsImRpc3BsYXlOYW1lIjoiQmVsbGV2dWUgTmVpZ2hib3Job29kIE1hcmtldCIsIm5vZGVUeXBlIjoiU1RPUkUiLCJhZGRyZXNzIjp7InBvc3RhbENvZGUiOiI5ODAwNyIsImFkZHJlc3NMaW5lMSI6IjE1MDYzIE1haW4gU3QiLCJjaXR5IjoiQmVsbGV2dWUiLCJzdGF0ZSI6IldBIiwiY291bnRyeSI6IlVTIiwicG9zdGFsQ29kZTkiOiI5ODAwNy01MjI1In0sImdlb1BvaW50Ijp7ImxhdGl0dWRlIjo0Ny42MDkwMzYsImxvbmdpdHVkZSI6LTEyMi4xMzk0ODd9LCJpc0dsYXNzRW5hYmxlZCI6dHJ1ZSwic2NoZWR1bGVkRW5hYmxlZCI6dHJ1ZSwidW5TY2hlZHVsZWRFbmFibGVkIjpmYWxzZSwiaHViTm9kZUlkIjoiMzA5OCIsInN0b3JlSHJzIjoiMDY6MDAtMjI6MDAiLCJzdXBwb3J0ZWRBY2Nlc3NUeXBlcyI6WyJQSUNLVVBfQ1VSQlNJREUiLCJQSUNLVVBfSU5TVE9SRSJdfV0sInNoaXBwaW5nQWRkcmVzcyI6eyJsYXRpdHVkZSI6NDcuNjExMSwibG9uZ2l0dWRlIjotMTIyLjE0MjgsInBvc3RhbENvZGUiOiI5ODAwNyIsImNpdHkiOiJCZWxsZXZ1ZSIsInN0YXRlIjoiV0EiLCJjb3VudHJ5Q29kZSI6IlVTQSIsImdpZnRBZGRyZXNzIjpmYWxzZX0sImFzc29ydG1lbnQiOnsibm9kZUlkIjoiMzA5OCIsImRpc3BsYXlOYW1lIjoiQmVsbGV2dWUgTmVpZ2hib3Job29kIE1hcmtldCIsImFjY2Vzc1BvaW50cyI6bnVsbCwic3VwcG9ydGVkQWNjZXNzVHlwZXMiOltdLCJpbnRlbnQiOiJQSUNLVVAiLCJzY2hlZHVsZUVuYWJsZWQiOmZhbHNlfSwiZGVsaXZlcnkiOnsiYnVJZCI6IjAiLCJub2RlSWQiOiIzMDk4IiwiZGlzcGxheU5hbWUiOiJCZWxsZXZ1ZSBOZWlnaGJvcmhvb2QgTWFya2V0Iiwibm9kZVR5cGUiOiJTVE9SRSIsImFkZHJlc3MiOnsicG9zdGFsQ29kZSI6Ijk4MDA3IiwiYWRkcmVzc0xpbmUxIjoiMTUwNjMgTWFpbiBTdCIsImNpdHkiOiJCZWxsZXZ1ZSIsInN0YXRlIjoiV0EiLCJjb3VudHJ5IjoiVVMiLCJwb3N0YWxDb2RlOSI6Ijk4MDA3LTUyMjUifSwiZ2VvUG9pbnQiOnsibGF0aXR1ZGUiOjQ3LjYwOTAzNiwibG9uZ2l0dWRlIjotMTIyLjEzOTQ4N30sImlzR2xhc3NFbmFibGVkIjp0cnVlLCJzY2hlZHVsZWRFbmFibGVkIjp0cnVlLCJ1blNjaGVkdWxlZEVuYWJsZWQiOmZhbHNlLCJhY2Nlc3NQb2ludHMiOlt7ImFjY2Vzc1R5cGUiOiJERUxJVkVSWV9BRERSRVNTIn1dLCJodWJOb2RlSWQiOiIzMDk4IiwiaXNFeHByZXNzRGVsaXZlcnlPbmx5IjpmYWxzZSwic3VwcG9ydGVkQWNjZXNzVHlwZXMiOlsiREVMSVZFUllfQUREUkVTUyJdfSwiaW5zdG9yZSI6ZmFsc2UsInJlZnJlc2hBdCI6MTY1ODk3OTM3ODAwOSwidmFsaWRhdGVLZXkiOiJwcm9kOnYyOjFiMTFlZmU0LWRiNWEtNGFiMS04Y2YzLTNjMzBhMmY3ZDRmMSJ9; wmlh=bbe15ccea55557656ad331309b819386c42bf6325aeb8f11421e1551e63f8ac4; AID=wmlspartner%253D0%253Areflectorid%253D0000000000000000000000%253Alastupd%253D1658957835354; TS01a90220=0147a2d386cef87c05d97cf123dab011fecf92a95a3fb6d2d6274c9edad24a10cd8c911e36ad3ddfc3a2584e8ec113435680354e45; _px3=e6849b4dfd7e43fda8b6d2ebd6f3fe6535a3c0ab11d9f2de017be166351a5865:z0BIGvvHke5ljn1hssWViMLDAtMgCTZkypW1djnx0yAbTYxNg7LJrrpFBTregorZulZaF9jDJT7hWMKmlR2eRA==:1000:PouIWs/Pv/hM6QXQo9VfUFUj1IwGDNUHqgGdXmyCMdMriWdIDSNxd1qaG5P5efhheqeCiPdIVnwiVXkuSWy2UANTk2C+2XhJfetXFo/doZ9BqWCaPTmYDxQh4oZbOHOc+DOThCjCg96q585ZQMlzb8FyQxRD2NSJgAOiBJh4UZ/v5DavHACKxWShqa+jmsILSpXq8xnQGhe0PVKtuVO9Pw==; TS012768cf=015c7eb6ff8514248f5d28cb195545dac0eddffb67c8a53bc5875c0940f822212abedf16f2071bed7114ad2d33ed9cbe1d8fa97eff; TS2a5e0c5c027=08ea1d1d60ab2000e867ecf06c046de366ad7cdb206b57dda400ca5f086277ed6ffc79b91f94a02b0805d5b93a11300076b057964fe0d81850652620aca873d5ab5c116a5395b8a825a3e7af9873db431434ad77a22f53d375b8f28bcd641ca4; akavpau_p2=1658958455~id=a728a6eff501fe5250007415196e9385; com.wm.reflector=\"reflectorid:0000000000000000000000@lastupd:1658957861000@firstcreate:1658957776277\"; xptwg=1810386799:16E05B095ECD7D0:3B39D76:4F7F5AF4:4544EE01:CBB1E5E0:; bm_sv=5B87CC24C8081B16DD9630049E664719~YAAQdY0duBIiBSaCAQAA9ROYQRA/2phDQukCzFBx7v/ZZ9HB2rOONoCOtJl/18CvoRmFhfwre4BLOt1SVIV5lODAgN6dAmLGbZBVpIPnEtvQlz7+WFFqE4aIqIAYHhgSG7buaVSDHRvp19w/a74w2BtU7s8kXtrzTZz0xdxYDGw2xI4jjCCbiAyi2wWWJY/yrxgQDxKIraFXKR5w20GM8dIXsGu4md8sRVrfMnjMkIEvF7z2FSXS/7DoBNTFIdU0Q4M=~1");
		httpConn.setRequestProperty("device_profile_ref_id", "Uoft1lqUUEP_C_9iHf4vRVLK3goSyBWJsxer");
		httpConn.setRequestProperty("origin", "https://www.walmart.com");
		httpConn.setRequestProperty("referer", "https://www.walmart.com/browse/feeding/baby-formula/5427_133283_4720344?redirectQuery=baby+formula&search_redirect=true&affinityOverride=default");
		httpConn.setRequestProperty("sec-ch-ua", "\".Not/A)Brand\";v=\"99\", \"Google Chrome\";v=\"103\", \"Chromium\";v=\"103\"");
		httpConn.setRequestProperty("sec-ch-ua-mobile", "?0");
		httpConn.setRequestProperty("sec-ch-ua-platform", "\"macOS\"");
		httpConn.setRequestProperty("sec-fetch-dest", "empty");
		httpConn.setRequestProperty("sec-fetch-mode", "cors");
		httpConn.setRequestProperty("sec-fetch-site", "same-origin");
		httpConn.setRequestProperty("traceparent", "t-sbevqzUb8YiVFeaw-RtwtKl9I-IOec3y8t");
		httpConn.setRequestProperty("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Safari/537.36");
		httpConn.setRequestProperty("wm_mp", "true");
		httpConn.setRequestProperty("wm_page_url", "https://www.walmart.com/browse/feeding/baby-formula/5427_133283_4720344?redirectQuery=baby+formula&search_redirect=true&affinityOverride=default");
		httpConn.setRequestProperty("wm_qos.correlation_id", "t-sbevqzUb8YiVFeaw-RtwtKl9I-IOec3y8t");
		httpConn.setRequestProperty("x-apollo-operation-name", "Browse");
		httpConn.setRequestProperty("x-enable-server-timing", "1");
		httpConn.setRequestProperty("x-latency-trace", "1");
		httpConn.setRequestProperty("x-o-bu", "WALMART-US");
		httpConn.setRequestProperty("x-o-ccm", "server");
		httpConn.setRequestProperty("x-o-correlation-id", "t-sbevqzUb8YiVFeaw-RtwtKl9I-IOec3y8t");
		httpConn.setRequestProperty("x-o-gql-query", "query Browse");
		httpConn.setRequestProperty("x-o-mart", "B2C");
		httpConn.setRequestProperty("x-o-platform", "rweb");
		httpConn.setRequestProperty("x-o-platform-version", "main-1.9.0-528d01");
		httpConn.setRequestProperty("x-o-segment", "oaoh");

		httpConn.setDoOutput(true);
		OutputStreamWriter writer = new OutputStreamWriter(httpConn.getOutputStream());
		writer.write("{\"query\":\"query Browse( $query:String $page:Int $prg:Prg! $facet:String $sort:Sort $catId:String! $max_price:String $min_price:String $module_search:String $affinityOverride:AffinityOverride $ps:Int $ptss:String $beShelfId:String $fitmentFieldParams:JSON ={}$fitmentSearchParams:JSON ={}$rawFacet:String $seoPath:String $trsp:String $fetchMarquee:Boolean! $fetchSkyline:Boolean! $additionalQueryParams:JSON ={}$enablePortableFacets:Boolean = false $intentSource:IntentSource $tenant:String! $enableFacetCount:Boolean = true $pageType:String! = \\\"BrowsePage\\\" ){search( query:$query page:$page prg:$prg facet:$facet sort:$sort cat_id:$catId max_price:$max_price min_price:$min_price module_search:$module_search affinityOverride:$affinityOverride additionalQueryParams:$additionalQueryParams ps:$ps ptss:$ptss trsp:$trsp intentSource:$intentSource _be_shelf_id:$beShelfId pageType:$pageType ){query searchResult{...BrowseResultFragment}}contentLayout( channel:\\\"WWW\\\" pageType:$pageType tenant:$tenant version:\\\"v1\\\" searchArgs:{query:$query cat_id:$catId _be_shelf_id:$beShelfId prg:$prg}){modules{...ModuleFragment configs{...on EnricherModuleConfigsV1{zoneV1}__typename...on _TempoWM_GLASSWWWSearchSortFilterModuleConfigs{facetsV1 @skip(if:$enablePortableFacets){...FacetFragment}topNavFacets @include(if:$enablePortableFacets){...FacetFragment}allSortAndFilterFacets @include(if:$enablePortableFacets){...FacetFragment}}...on TempoWM_GLASSWWWPillsModuleConfigs{moduleSource pillsV2{...PillsModuleFragment}}...TileTakeOverProductFragment...on TempoWM_GLASSWWWSearchFitmentModuleConfigs{fitments( fitmentSearchParams:$fitmentSearchParams fitmentFieldParams:$fitmentFieldParams ){...FitmentFragment sisFitmentResponse{...BrowseResultFragment}}}...on TempoWM_GLASSWWWStoreSelectionHeaderConfigs{fulfillmentMethodLabel storeDislayName}...on TempoWM_GLASSWWWSponsoredProductCarouselConfigs{_rawConfigs}...PopularInModuleFragment...CopyBlockModuleFragment...BannerModuleFragment...HeroPOVModuleFragment...InlineSearchModuleFragment...MarqueeDisplayAdConfigsFragment @include(if:$fetchMarquee)...SkylineDisplayAdConfigsFragment @include(if:$fetchSkyline)...HorizontalChipModuleConfigsFragment...SkinnyBannerFragment}}...LayoutFragment pageMetadata{location{pickupStore deliveryStore intent postalCode stateOrProvinceCode city storeId accessPointId accessType spokeNodeId}pageContext}}seoBrowseMetaData( id:$catId facets:$rawFacet path:$seoPath facet_query_param:$facet _be_shelf_id:$beShelfId ){metaTitle metaDesc metaCanon h1 noIndex}}fragment BrowseResultFragment on SearchInterface{title aggregatedCount...BreadCrumbFragment...ShelfDataFragment...DebugFragment...ItemStacksFragment...PageMetaDataFragment...PaginationFragment...RequestContextFragment...ErrorResponse modules{facetsV1 @skip(if:$enablePortableFacets){...FacetFragment}topNavFacets @include(if:$enablePortableFacets){...FacetFragment}allSortAndFilterFacets @include(if:$enablePortableFacets){...FacetFragment}pills{...PillsModuleFragment}}}fragment ModuleFragment on TempoModule{name version type moduleId schedule{priority}matchedTrigger{zone}}fragment LayoutFragment on ContentLayout{layouts{id layout}}fragment BreadCrumbFragment on SearchInterface{breadCrumb{id name url}}fragment ShelfDataFragment on SearchInterface{shelfData{shelfName shelfId}}fragment DebugFragment on SearchInterface{debug{sisUrl adsUrl}}fragment ItemStacksFragment on SearchInterface{itemStacks{displayMessage meta{adsBeacon{adUuid moduleInfo max_ads}query stackId stackType title layoutEnum totalItemCount totalItemCountDisplay viewAllParams{query cat_id sort facet affinityOverride recall_set min_price max_price}}itemsV2{...ItemFragment...InGridMarqueeAdFragment...TileTakeOverTileFragment}}}fragment ItemFragment on Product{__typename id usItemId fitmentLabel name checkStoreAvailabilityATC seeShippingEligibility brand type shortDescription imageInfo{...ProductImageInfoFragment}canonicalUrl externalInfo{url}itemType category{path{name url}}badges{flags{...on BaseBadge{key text type id}...on PreviouslyPurchasedBadge{id text key lastBoughtOn numBought}}tags{...on BaseBadge{key text type}}}classType averageRating numberOfReviews esrb mediaRating salesUnitType sellerId sellerName hasSellerBadge availabilityStatusV2{display value}groupMetaData{groupType groupSubType numberOfComponents groupComponents{quantity offerId componentType productDisplayName}}productLocation{displayValue aisle{zone aisle}}fulfillmentSpeed offerId preOrder{...PreorderFragment}priceInfo{...ProductPriceInfoFragment}variantCriteria{...VariantCriteriaFragment}snapEligible fulfillmentBadge fulfillmentTitle fulfillmentType brand manufacturerName showAtc sponsoredProduct{spQs clickBeacon spTags viewBeacon}showOptions showBuyNow rewards{eligible state minQuantity rewardAmt promotionId selectionToken cbOffer term expiry description}}fragment ProductImageInfoFragment on ProductImageInfo{thumbnailUrl size}fragment ProductPriceInfoFragment on ProductPriceInfo{priceRange{minPrice maxPrice}currentPrice{...ProductPriceFragment}wasPrice{...ProductPriceFragment}unitPrice{...ProductPriceFragment}listPrice{...ProductPriceFragment}shipPrice{...ProductPriceFragment}subscriptionPrice{priceString subscriptionString}priceDisplayCodes{priceDisplayCondition finalCostByWeight submapType}}fragment PreorderFragment on PreOrder{isPreOrder preOrderMessage preOrderStreetDateMessage}fragment ProductPriceFragment on ProductPrice{price priceString}fragment VariantCriteriaFragment on VariantCriterion{name type id isVariantTypeSwatch variantList{id images name rank swatchImageUrl availabilityStatus products selectedProduct{canonicalUrl usItemId}}}fragment InGridMarqueeAdFragment on MarqueePlaceholder{__typename type moduleLocation lazy}fragment TileTakeOverTileFragment on TileTakeOverProductPlaceholder{__typename type tileTakeOverTile{span title subtitle image{src alt}logoImage{src alt}backgroundColor titleTextColor subtitleTextColor tileCta{ctaLink{clickThrough{value}linkText title}ctaType ctaTextColor}}}fragment PageMetaDataFragment on SearchInterface{pageMetadata{storeSelectionHeader{fulfillmentMethodLabel storeDislayName}title canonical description location{addressId}}}fragment PaginationFragment on SearchInterface{paginationV2{maxPage pageProperties}}fragment RequestContextFragment on SearchInterface{requestContext{vertical isFitmentFilterQueryApplied searchMatchType categories{id name}}}fragment ErrorResponse on SearchInterface{errorResponse{correlationId source errorCodes errors{errorType statusCode statusMsg source}}}fragment PillsModuleFragment on PillsSearchInterface{title url image:imageV1{src alt}}fragment BannerModuleFragment on TempoWM_GLASSWWWSearchBannerConfigs{moduleType viewConfig{title image imageAlt displayName description url urlAlt appStoreLink appStoreLinkAlt playStoreLink playStoreLinkAlt}}fragment PopularInModuleFragment on TempoWM_GLASSWWWPopularInBrowseConfigs{seoBrowseRelmData(id:$catId){relm{id name url}}}fragment CopyBlockModuleFragment on TempoWM_GLASSWWWCopyBlockConfigs{copyBlock(id:$catId){cwc}}fragment FacetFragment on Facet{title name type layout min max selectedMin selectedMax unboundedMax stepSize isSelected values{id title name description type itemCount @include(if:$enableFacetCount) isSelected baseSeoURL}}fragment FitmentFragment on Fitments{partTypeIDs result{status formId position quantityTitle extendedAttributes{...FitmentFieldFragment}labels{...LabelFragment}resultSubTitle notes suggestions{...FitmentSuggestionFragment}}labels{...LabelFragment}savedVehicle{vehicleType{...VehicleFieldFragment}vehicleYear{...VehicleFieldFragment}vehicleMake{...VehicleFieldFragment}vehicleModel{...VehicleFieldFragment}additionalAttributes{...VehicleFieldFragment}}fitmentFields{...VehicleFieldFragment}fitmentForms{id fields{...FitmentFieldFragment}title labels{...LabelFragment}}}fragment LabelFragment on FitmentLabels{ctas{...FitmentLabelEntityFragment}messages{...FitmentLabelEntityFragment}links{...FitmentLabelEntityFragment}images{...FitmentLabelEntityFragment}}fragment FitmentLabelEntityFragment on FitmentLabelEntity{id label}fragment VehicleFieldFragment on FitmentVehicleField{id label value}fragment FitmentFieldFragment on FitmentField{id displayName value extended data{value label}dependsOn}fragment FitmentSuggestionFragment on FitmentSuggestion{id position loadIndex speedRating searchQueryParam labels{...LabelFragment}cat_id fitmentSuggestionParams{id value}}fragment HeroPOVModuleFragment on TempoWM_GLASSWWWHeroPovConfigsV1{povCards{card{povStyle image{mobileImage{...TempoCommonImageFragment}desktopImage{...TempoCommonImageFragment}}heading{text textColor textSize}subheading{text textColor}detailsView{backgroundColor isTransparent}ctaButton{button{linkText clickThrough{value}uid}}legalDisclosure{regularText shortenedText textColor textColorMobile legalBottomSheetTitle legalBottomSheetDescription}logo{...TempoCommonImageFragment}links{link{linkText}}}}}fragment TempoCommonImageFragment on TempoCommonImage{src alt assetId uid clickThrough{value}}fragment InlineSearchModuleFragment on TempoWM_GLASSWWWInlineSearchConfigs{headingText placeholderText}fragment MarqueeDisplayAdConfigsFragment on TempoWM_GLASSWWWMarqueeDisplayAdConfigs{_rawConfigs ad{...DisplayAdFragment}}fragment DisplayAdFragment on Ad{...AdFragment adContent{type data{__typename...AdDataDisplayAdFragment}}}fragment AdFragment on Ad{status moduleType platform pageId pageType storeId stateCode zipCode pageContext moduleConfigs adsContext adRequestComposite}fragment AdDataDisplayAdFragment on AdData{...on DisplayAd{json status}}fragment SkylineDisplayAdConfigsFragment on TempoWM_GLASSWWWSkylineDisplayAdConfigs{_rawConfigs ad{...SkylineDisplayAdFragment}}fragment SkylineDisplayAdFragment on Ad{...SkylineAdFragment adContent{type data{__typename...SkylineAdDataDisplayAdFragment}}}fragment SkylineAdFragment on Ad{status moduleType platform pageId pageType storeId stateCode zipCode pageContext moduleConfigs adsContext adRequestComposite}fragment SkylineAdDataDisplayAdFragment on AdData{...on DisplayAd{json status}}fragment HorizontalChipModuleConfigsFragment on TempoWM_GLASSWWWHorizontalChipModuleConfigs{chipModuleSource:moduleSource chipModule{title url{linkText title clickThrough{type value}}}chipModuleWithImages{title url{linkText title clickThrough{type value}}image{alt clickThrough{type value}height src title width}}}fragment SkinnyBannerFragment on TempoWM_GLASSWWWSkinnyBannerConfigs{bannerType desktopBannerHeight bannerImage{src title alt}mobileBannerHeight mobileImage{src title alt}clickThroughUrl{clickThrough{value}}backgroundColor heading{title fontColor}subHeading{title fontColor}bannerCta{ctaLink{linkText clickThrough{value}}textColor ctaType}}fragment TileTakeOverProductFragment on TempoWM_GLASSWWWTileTakeOverProductConfigs{dwebSlots mwebSlots TileTakeOverProductDetails{pageNumber span dwebPosition mwebPosition title subtitle image{src alt}logoImage{src alt}backgroundColor titleTextColor subtitleTextColor tileCta{ctaLink{clickThrough{value}linkText title}ctaType ctaTextColor}}}\",\"variables\":{\"id\":\"\",\"affinityOverride\":\"default\",\"dealsId\":\"\",\"query\":\"\",\"page\":1,\"prg\":\"desktop\",\"catId\":\"5427_133283_4720344\",\"facet\":\"\",\"sort\":\"best_match\",\"rawFacet\":\"\",\"seoPath\":\"\",\"ps\":40,\"ptss\":\"\",\"trsp\":\"\",\"beShelfId\":\"\",\"recall_set\":\"\",\"module_search\":\"\",\"min_price\":\"\",\"max_price\":\"\",\"storeSlotBooked\":\"\",\"additionalQueryParams\":{\"hidden_facet\":null,\"translation\":null},\"searchArgs\":{\"query\":\"\",\"cat_id\":\"5427_133283_4720344\",\"prg\":\"desktop\",\"facet\":\"\"},\"fitmentFieldParams\":{\"powerSportEnabled\":true},\"fitmentSearchParams\":{\"id\":\"\",\"affinityOverride\":\"default\",\"dealsId\":\"\",\"query\":\"\",\"page\":1,\"prg\":\"desktop\",\"catId\":\"5427_133283_4720344\",\"facet\":\"\",\"sort\":\"best_match\",\"rawFacet\":\"\",\"seoPath\":\"\",\"ps\":40,\"ptss\":\"\",\"trsp\":\"\",\"beShelfId\":\"\",\"recall_set\":\"\",\"module_search\":\"\",\"min_price\":\"\",\"max_price\":\"\",\"storeSlotBooked\":\"\",\"additionalQueryParams\":{\"hidden_facet\":null,\"translation\":null},\"searchArgs\":{\"query\":\"\",\"cat_id\":\"5427_133283_4720344\",\"prg\":\"desktop\",\"facet\":\"\"},\"cat_id\":\"5427_133283_4720344\",\"_be_shelf_id\":\"\"},\"fetchMarquee\":true,\"fetchSkyline\":true,\"fetchSbaTop\":false,\"enablePortableFacets\":true,\"tenant\":\"WM_GLASS\",\"enableFacetCount\":true,\"pageType\":\"BrowsePage\"}}");
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

		Set<String> BABYBRANDS = new HashSet<>();
		BABYBRANDS.add("Similac");
		BABYBRANDS.add("Enfamil");
		BABYBRANDS.add("Gerber");
		BABYBRANDS.add("Parent's Choice");
		BABYBRANDS.add("Enfagrow");
		BABYBRANDS.add("Earth's Best");
		BABYBRANDS.add("Aptamil");
		BABYBRANDS.add("Baby Water");
		BABYBRANDS.add("Bobbie Baby");
		BABYBRANDS.add("Enspire");
		BABYBRANDS.add("Nutramigen");
		BABYBRANDS.add("Nestle");
		BABYBRANDS.add("Bubs");
		BABYBRANDS.add("HappyBaby");
		BABYBRANDS.add("Kendamil");
		BABYBRANDS.add("Kinderlyte");
		BABYBRANDS.add("Pedialyte");
		BABYBRANDS.add("PediaSure");
		BABYBRANDS.add("Ready, Set, Food!");
		BABYBRANDS.add("up & up");

// Set<String> h = new HashSet<>(Arrays.asList("a", "b"));


		for (Object o : itemsAL) {
			// get name
			Map<String,Object> item = objectMapper.convertValue(o, Map.class);
			// System.out.println(item);
			Object name = item.get("name");
			String nameStr = objectMapper.convertValue(name, String.class);
			System.out.println(name);

			//get brand
			for (String brand : BABYBRANDS) {
				if (isBrand(nameStr, brand)) {
					System.out.println(brand);
					break;
				}
			}

			// get availability
			Map<String,Object> itemAvailability = objectMapper.convertValue(item.get("availabilityStatusV2"), Map.class);
			System.out.println(itemAvailability.get("display"));

			// get price
			Map<String,Object> itemPriceInfo = objectMapper.convertValue(item.get("priceInfo"), Map.class);
			if (itemPriceInfo.get("currentPrice") != null) {
				Map<String,Integer> itemCurPrice = objectMapper.convertValue(itemPriceInfo.get("currentPrice"), Map.class);
				System.out.println(itemCurPrice.get("price"));
			} else if (itemPriceInfo.get("priceRange") != null) {
				Map<String,Integer> itemPriceRange = objectMapper.convertValue(itemPriceInfo.get("priceRange"), Map.class);
				System.out.println(itemPriceRange.get("minPrice"));
				System.out.println(itemPriceRange.get("maxPrice"));
			}

			// get thumbnail image URL
			Object imageInfo = item.get("imageInfo");
			Map<String,Object> imageInfoMap = objectMapper.convertValue(imageInfo, Map.class);
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
			if (oneLetterAway(word, brand) || oneLetterAway(brand, word)) {
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

}

