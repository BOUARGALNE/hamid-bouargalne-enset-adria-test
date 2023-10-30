package ma.bouargalne.walletservice.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity //pour JPA
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Wallet {
    private int clientId;
    private float solde;
    private Date dateCreation;
    private String devise;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Wallet (float solde, Date dateCreation, String devise) {
        this.solde=solde;
        this.dateCreation=dateCreation;
        this.devise=devise;
    }
}