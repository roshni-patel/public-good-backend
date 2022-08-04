// package com.walmart.platform.common;

// import java.util.HashMap;

// class Data {
//     @JsonProperty
//     private Long created;
//     @JsonProperty
//     private String id;
//     @JsonProperty
//     private String type;
//     private Map<String, Object> optional = new HashMap<>();
//     public Data() { // empty public constructor is required
//     }
//     // getters/setters for all properties omitted for brevity
//     @JsonAnySetter
//     public void addOptional(String name, Object value) {
//         optional.put(name, value);
//     }
//     @JsonAnyGetter
//     public Object getOptional(String name) {
//         return optional.get(name);
//     }
// }