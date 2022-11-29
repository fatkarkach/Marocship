package entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "vehicule", schema = "marocship", catalog = "")
public class  VehiculeENT {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "type")
    private String type;
    @OneToMany(mappedBy = "vehiculeByTypeVehicule")
    private Collection<ChauffeurENT> chauffeursById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VehiculeENT that = (VehiculeENT) o;

        if (id != that.id) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    public Collection<ChauffeurENT> getChauffeursById() {
        return chauffeursById;
    }

    public void setChauffeursById(Collection<ChauffeurENT> chauffeursById) {
        this.chauffeursById = chauffeursById;
    }
}
