/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.lichongbing.lswagger.springbootstarter.configuration;


/***
 * 配置文件
 * @since:Lswagger 2.0.0
 * @author <a href="mailto:873610008@qq.com">873610008@qq.com</a>
 * 2019/08/27 15:40
 */
public class LswaggerHttpBasic {

    /**
     * basick是否开启,默认为false
     */
    private boolean enable=false;

    /**
     * basic 用户名
     */
    private String username;

    /**
     * basic 密码
     */
    private String password;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
