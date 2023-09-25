package com.dn.plugin;

import java.util.ArrayList;

/**
 * @Author: hzh
 * @Date: 2022/6/20
 * @Desc: 插件配置类
 */
public class FileHexConfig {
    /**
     * 是否启用白名单
     */
    private boolean enable_whitelist;

    /**
     * 白名单
     */
    private ArrayList<String> whitelist = null;
    /**
     * mp3 列表
     */
    private ArrayList<String> mp3list = null;


    public ArrayList<String> getMp3list() {
        return mp3list;
    }

    public void setMp3list(ArrayList<String> mp3list) {
        this.mp3list = mp3list;
    }

    public boolean isEnable_whitelist() {
        return enable_whitelist;
    }

    public void setEnable_whitelist(boolean enable_whitelist) {
        this.enable_whitelist = enable_whitelist;
    }

    public ArrayList<String> getWhitelist() {
        return whitelist;
    }

    public void setWhitelist(ArrayList<String> whitelist) {
        this.whitelist = whitelist;
    }



}
