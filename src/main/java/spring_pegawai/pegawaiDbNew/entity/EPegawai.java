package spring_pegawai.pegawaiDbNew.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pegawai")
public class EPegawai {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_pegawai")
    private long idPegawai;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email_address")
    private String emailAddress;

    public EPegawai(){}

    public EPegawai(String fullName, String emailAddress) {
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
