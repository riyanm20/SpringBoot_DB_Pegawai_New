package spring_pegawai.pegawaiDbNew.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Access(AccessType.FIELD)
@Table(name = "pegawai")
public class PegawaiEntity implements Serializable {

    // Entity (Column di Table)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pegawai")
    private long idPegawai;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "emailAddress")
    private String emailAddress;

    public PegawaiEntity() {}

    public PegawaiEntity(String fullName, String emailAddress) {
        this.fullName = fullName;
        this.emailAddress = emailAddress;
    }

    public long getIdPegawai() {
        return idPegawai;
    }

    public void setIdPegawai(long idPegawai) {
        this.idPegawai = idPegawai;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
