package razdwatrzy.zzpj.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@Getter
@Setter
@Table(name ="Campaigns")
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "CampaignName")
    private @NonNull String CampaignName;
    @Column(name = "Owner")
    private long OwnerId;

}
