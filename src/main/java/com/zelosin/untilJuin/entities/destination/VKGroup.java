package com.zelosin.untilJuin.entities.destination;


import com.zelosin.untilJuin.entities.material.info.MilledMaterial;
import com.zelosin.untilJuin.entities.users.info.LinkedVKAccount;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "account_groups")
@Data
public class VKGroup {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "group_id")
    private String groupId;

    @Column(name = "access_token")
    private String accessToken;

    @ManyToOne(
        cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
        }
    )
    @JoinColumn(name = "account_id")
    private LinkedVKAccount linkedVKAccount;

    @OneToMany(
        mappedBy = "assignedGroup",
        cascade = CascadeType.ALL,
        fetch = FetchType.EAGER
    )
    @Fetch(value = FetchMode.SUBSELECT)
    private List<MilledMaterial> milledMaterials = new ArrayList<>();

    public VKGroup() {
    }

    public VKGroup(String groupId, String accessToken) {
        this.groupId = groupId;
        this.accessToken = accessToken;
    }

    public VKGroup addPost(MilledMaterial material){
        material.setAssignedGroup(this);
        milledMaterials.add(material);
        return this;
    }

}







