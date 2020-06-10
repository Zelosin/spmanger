package com.zelosin.untilJuin.entities.material.info;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "post_attachments")
@Data
public class Attachment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "attachment_type")
    private String attachmentType;

    @Column(name = "attachment_source")
    private String attachmentSource;

    @ManyToOne(
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            }
    )
    @JoinColumn(name = "assigned_post")
    private MilledMaterial postMaterial;

    public Attachment(String attachmentType, String attachmentSource, MilledMaterial postMaterial) {
        this.attachmentType = attachmentType;
        this.attachmentSource = attachmentSource;
        this.postMaterial = postMaterial;
    }
}

















