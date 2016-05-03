package com.example.hdu.qingyinongnong.model;

/**
 * Created by Aimee on 2016/4/29.
 */
public class Menu {
    private String title;
    private String mainPic;
    private int lookNum;
    private int loveNum;
    private String contenturl;

    public void setContenturl(String contenturl) {
        this.contenturl = contenturl;
    }

    public void setLookNum(int lookNum) {
        this.lookNum = lookNum;
    }

    public void setLoveNum(int loveNum) {
        this.loveNum = loveNum;
    }

    public void setMainPic(String mainPic) {
        this.mainPic = mainPic;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContenturl() {
        return contenturl;
    }

    public int getLookNum() {
        return lookNum;
    }

    public int getLoveNum() {
        return loveNum;
    }

    public String getMainPic() {
        return mainPic;
    }

    public String getTitle() {
        return title;
    }
}
