package com.zelosin.untilJuin.entities.material.info;


import com.zelosin.untilJuin.entities.destination.VKGroup;
import com.zelosin.untilJuin.entities.users.info.LinkedVKAccount;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
@Data
public class MilledMaterial {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "post_date")
    private String postDate;

    @Column(name = "plain_text")
    private String plainText;

    @Column(name = "tags")
    private String postTags;

    @Column(name = "source_link")
    private String sourceLink;

    @ManyToOne(
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            }
    )
    @JoinColumn(name = "assigned_group_id")
    private VKGroup assignedGroup;

    @OneToMany(
            mappedBy = "postMaterial",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Attachment> postAttachments = new ArrayList<>();

    public MilledMaterial() {
    }

    public MilledMaterial(String postDate, String plainText, String postTags, String sourceLink) {
        this.postDate = postDate;
        this.plainText = plainText;
        this.postTags = postTags;
        this.sourceLink = sourceLink;
    }

    public MilledMaterial addAttachment(Attachment attachment){
        postAttachments.add(attachment);
        attachment.setPostMaterial(this);
        return this;
    }
}
