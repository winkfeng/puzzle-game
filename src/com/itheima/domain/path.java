package com.itheima.domain;

public class path {
    private String img;
    private String imgStr;

    public path() {
    }

    public path(String img, String imgStr) {
        this.img = img;
        this.imgStr = imgStr;
    }

    /**
     * 获取
     * @return img
     */
    public String getImg() {
        return img;
    }

    /**
     * 设置
     * @param img
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * 获取
     * @return imgStr
     */
    public String getImgStr() {
        return imgStr;
    }

    /**
     * 设置
     * @param imgStr
     */
    public void setImgStr(String imgStr) {
        this.imgStr = imgStr;
    }

    public String toString() {
        return "path{img = " + img + ", imgStr = " + imgStr + "}";
    }
}
