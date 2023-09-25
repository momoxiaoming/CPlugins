package com.dn.plugin;

/**
 * @Author: hzh
 * @Date: 2022/6/20
 * @Desc:  插件配置扩展
 */
public class FileHexExtension {
    /**
     * 是否启动插件
     */
    private boolean enable = true;

    /**
     * 配置文件路径
     */
    private String configFile = "";

    /**
     * 日志
     */
    private boolean logEnable = false;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getConfigFile() {
        return configFile;
    }

    public void setConfigFile(String configFile) {
        this.configFile = configFile;
    }

    public boolean isLogEnable()
    {
        return logEnable;
    }

    public void setLogEnable(boolean logEnable)
    {
        this.logEnable = logEnable;
    }

    @Override
    public String toString() {
        return "FileHexExtension{" +
                "enable=" + enable +
                ", configFile='" + configFile + '\'' +
                '}';
    }
}