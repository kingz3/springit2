package com.ehayes.springit2.Springitmodel;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Link extends Auditable {

    @Id
    @GeneratedValue
    private long id;
    @NonNull
    private String title;
    @NonNull
    private String url;

    //comments

    //when display a link may have comments on link display some comments about the link
    //one link to many comments map one to many
    @OneToMany(mappedBy = "link")
    private List<Comment> comments = new ArrayList<>();


    public Link(@NonNull String title, @NonNull String url) {
        this.title = title;
        this.url = url;
    }

    public void addComment(Comment comment){
        comments.add(comment);
    }
}
