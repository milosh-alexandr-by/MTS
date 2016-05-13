package by.it.academy.pojos;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by USER on 11.05.2016.
 */
@Entity
@Table(name = "news")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class News implements Serializable {
    private static final long serialVersionUID = 5L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "news_id")
    private Long newsId;

    @Column(name = "content")
    private String content;

    public News() {

    }

    public News(Long newsId, String content) {
        this.newsId = newsId;
        this.content = content;
    }

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        System.out.println("2. Проверка кодировки------------------------------------------------------------------");
        System.out.println("content: " +  content);
        this.content = content;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + newsId.hashCode();
        result = prime * result + content.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News)) return false;
        News news = (News) o;
        if (!(newsId == news.newsId)) return false;
        if (!(content.equals(news.content))) return false;
        return true;
    }

    @Override
    public String toString() {
        return "News: id = " + this.newsId +
                ", content = " + this.content +
                ".";
    }

}
