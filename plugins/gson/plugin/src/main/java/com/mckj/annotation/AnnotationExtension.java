package com.mckj.annotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnnotationExtension {

    List<String> whiteList;

    List<String> blackList;

    private final List<String> defaultWhiteList = Arrays.asList("com.google.gson");

    /**
     * 默认黑名单列表
     */
    private final List<String> defaultBlackList = Arrays.asList("androidx/", "kotlin/", "kotlinx/", "META-INF/", "android/support");

    List<String> checkBlackList = new ArrayList<String>();
    List<String> checkWhiteList = new ArrayList<String>();


    public boolean isWhiteList(String path) {
        return checkWhiteList(path);
    }

    public boolean checkWhiteList(String path) {
        if (checkWhiteList.isEmpty()) {
            if (whiteList != null && !whiteList.isEmpty()) {
                checkWhiteList.addAll(whiteList);
            }
            checkWhiteList.addAll(defaultWhiteList);
        }
        for (String packName : checkWhiteList) {
            String realPackName = packName.replaceAll("\\.", "/");
            boolean isWhiteList = path.startsWith(realPackName);
            if (isWhiteList) {
                return true;
            }
        }
        return false;
    }


    public boolean checkBlackList(String path) {
        if (checkBlackList.isEmpty()) {
            if (blackList != null && !blackList.isEmpty()) {
                checkBlackList.addAll(blackList);
            }
            checkBlackList.addAll(defaultBlackList);
        }
        for (String packName : checkBlackList) {
            String realPackName = packName.replaceAll("\\.", "/");
            boolean isSkip = path.startsWith(realPackName);
            if (isSkip) {
                return true;
            }
        }
        return false;
    }
}
