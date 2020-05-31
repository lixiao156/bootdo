package com.bootdo.article.domain;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * 统计文章的访问次数
 * @author helloLi
 * @version 1.0
 * @date 2020/5/25 16:59
 */
public class StatisticDo implements Serializable {
    int id;
    String url;
    Date clickDate;
    long newsId;
    int times;
    Date operateTime;

    public StatisticDo() {
    }

    public StatisticDo(int id, String url, Date clickDate, long newsId, int times, Date operateTime) {
        this.id = id;
        this.url = url;
        this.clickDate = clickDate;
        this.newsId = newsId;
        this.times = times;
        this.operateTime = operateTime;
    }

    public long getNewsId() {
        return newsId;
    }

    public void setNewsId(long newsId) {
        this.newsId = newsId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getClickDate() {
        return clickDate;
    }

    public void setClickDate(Date clickDate) {
        this.clickDate = clickDate;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    @Override
    public String toString() {
        return "StatisticDo{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", clickDate=" + clickDate +
                ", newsId=" + newsId +
                ", times=" + times +
                ", operateTime=" + operateTime +
                '}';
    }
}
