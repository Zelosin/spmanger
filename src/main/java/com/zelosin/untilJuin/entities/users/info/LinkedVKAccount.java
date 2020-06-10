package com.zelosin.untilJuin.entities.users.info;


import com.zelosin.untilJuin.entities.destination.VKGroup;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "linked_vk_accounts")
@Data
public class LinkedVKAccount {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "access_token")
    private String accessToken;

    @Column(name = "user_id")
    private String userId;

    @OneToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "spuser_id")
    private SPUser SPUser;

    @OneToMany(
            mappedBy = "linkedVKAccount",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @Fetch(value = FetchMode.SUBSELECT)
    private List<VKGroup> accountGroups = new ArrayList<>();

    public LinkedVKAccount() {

    }

    public void addGroup(VKGroup group){
        accountGroups.add(group);
        group.setLinkedVKAccount(this);
    }
}














