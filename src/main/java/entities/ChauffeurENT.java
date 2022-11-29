package entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "chauffeur", schema = "marocship", catalog = "")
public class ChauffeurENT {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "password")
    private String password;
//    @Basic
//    @Column(name = "type_vehicule")
//    private int typeVehicule;
    @Basic
    @Column(name = "distance_parcourue")
    private int distanceParcourue;
    @ManyToOne
    @JoinColumn(name = "type_vehicule", referencedColumnName = "id", nullable = false)
    private VehiculeENT vehiculeByTypeVehicule;
    @OneToMany(mappedBy = "chauffeurByChauffeurId")
    private Collection<LivraisonENT> livraisonsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public int getTypeVehicule() {
//        return typeVehicule;
//    }
//
//    public void setTypeVehicule(int typeVehicule) {
//        this.typeVehicule = typeVehicule;
//    }

    public int getDistanceParcourue() {
        return distanceParcourue;
    }

    public void setDistanceParcourue(int distanceParcourue) {
        this.distanceParcourue = distanceParcourue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChauffeurENT that = (ChauffeurENT) o;

        if (id != that.id) return false;
//        if (typeVehicule != that.typeVehicule) return false;
        if (distanceParcourue != that.distanceParcourue) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
//        result = 31 * result + typeVehicule;
        result = 31 * result + distanceParcourue;
        return result;
    }

    public VehiculeENT getVehiculeByTypeVehicule() {
        return vehiculeByTypeVehicule;
    }

    public void setVehiculeByTypeVehicule(VehiculeENT vehiculeByTypeVehicule) {
        this.vehiculeByTypeVehicule = vehiculeByTypeVehicule;
    }

    public Collection<LivraisonENT> getLivraisonsById() {
        return livraisonsById;
    }

    public void setLivraisonsById(Collection<LivraisonENT> livraisonsById) {
        this.livraisonsById = livraisonsById;
    }
}
