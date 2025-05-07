package com.LLD.LLD.HashMap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class HashMapDemo {

    public static void main(String[] args) throws Exception {
//        HashMap<String,String> hashMap = new HashMap<>();
//        hashMap.put("snehith","peace");
//        hashMap.put("jayanth","rude");
//        hashMap.put("trinath","neutral");
//
//        System.out.println(hashMap.get("charan"));
//        hashMap.delete("random");
//        hashMap.put("charan","muscular");
//
//        System.out.println(hashMap.get("snehith"));
//        System.out.println(hashMap.get("jayanth"));
//        hashMap.put("jayanth","peace");
//        hashMap.put("trinath","gay");
//        System.out.println(hashMap.get("snehith"));
//        System.out.println(hashMap.get("jayanth"));
//        System.out.println(hashMap.get("trinath"));
//        System.out.println(hashMap.get("charan"));
//
//        hashMap.delete("trinath");
//        System.out.println(hashMap.get("trinath"));


        HashMap<List<String>,String> hashMap1 = new HashMap<>();
        hashMap1.put(Arrays.asList("snehith"),"mental");
        hashMap1.put(Arrays.asList("jayanth","charan"),"calm");
        hashMap1.put(Arrays.asList("trinath","bharadwaj"),"friends");

        System.out.println(hashMap1.get(Arrays.asList("trinath","bharadwaj")));
        hashMap1.delete(Arrays.asList("trinath"));
        System.out.println(hashMap1.get(Arrays.asList("jayanth","charan")));
        hashMap1.put(Arrays.asList("jayanth","charan"),"idiots");
        hashMap1.put(Arrays.asList("trinath","bharadwaj"),"laugh");
        hashMap1.put(Arrays.asList("trinath","jayanth"),"bangbros");
        System.out.println(hashMap1.get(Arrays.asList("trinath","bharadwaj")));
        System.out.println(hashMap1.get(Arrays.asList("trinath","jayanth")));
        hashMap1.delete(Arrays.asList("trinath","bharadwaj"));
        System.out.println(hashMap1.get(Arrays.asList("trinath","bharadwaj")));
    }
}
