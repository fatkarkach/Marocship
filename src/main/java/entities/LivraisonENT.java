package entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "livraison", schema = "marocship", catalog = "")
public class LivraisonENT {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
   /* @Basic
    @Column(name = "chauffeur_id")
    private Integer chauffeurId;*/
    @Basic
    @Column(name = "poids")
    private int poids;
    @Basic
    @Column(name = "tarif")
    private int tarif;
    @Basic
    @Column(name = "ville_depart")
    private String villeDepart;
    @Basic
    @Column(name = "ville_arrivee")
    private String villeArrivee;
    @Basic
    @Column(name = "date_livraison")
    private Date dateLivraison;
    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;
    @ManyToOne
    @JoinColumn(name = "chauffeur_id", referencedColumnName = "id")
    private ChauffeurENT chauffeurByChauffeurId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

/*    public Integer getChauffeurId() {
        return chauffeurId;
    }

    public void setChauffeurId(Integer chauffeurId) {
        this.chauffeurId = chauffeurId;
    }*/

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public int getTarif() {
        return tarif;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }

    public String getVilleArrivee() {
        return villeArrivee;
    }

    public void setVilleArrivee(String villeArrivee) {
        this.villeArrivee = villeArrivee;
    }

    public Date getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LivraisonENT that = (LivraisonENT) o;

        if (id != that.id) return false;
        if (poids != that.poids) return false;
        if (tarif != that.tarif) return false;
/*
        if (chauffeurId != null ? !chauffeurId.equals(that.chauffeurId) : that.chauffeurId != null) return false;
*/
        if (villeDepart != null ? !villeDepart.equals(that.villeDepart) : that.villeDepart != null) return false;
        if (villeArrivee != null ? !villeArrivee.equals(that.villeArrivee) : that.villeArrivee != null) return false;
        if (dateLivraison != null ? !dateLivraison.equals(that.dateLivraison) : that.dateLivraison != null)
            return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
/*
        result = 31 * result + (chauffeurId != null ? chauffeurId.hashCode() : 0);
*/
        result = 31 * result + poids;
        result = 31 * result + tarif;
        result = 31 * result + (villeDepart != null ? villeDepart.hashCode() : 0);
        result = 31 * result + (villeArrivee != null ? villeArrivee.hashCode() : 0);
        result = 31 * result + (dateLivraison != null ? dateLivraison.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        return result;
    }

    public ChauffeurENT getChauffeurByChauffeurId() {
        return chauffeurByChauffeurId;
    }

    public void setChauffeurByChauffeurId(ChauffeurENT chauffeurByChauffeurId) {
        this.chauffeurByChauffeurId = chauffeurByChauffeurId;
    }
}
