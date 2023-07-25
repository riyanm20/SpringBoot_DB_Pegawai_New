package spring_pegawai.pegawaiDbNew.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import spring_pegawai.pegawaiDbNew.entity.PegawaiEntity;
import spring_pegawai.pegawaiDbNew.repositories.PegawaiRepo;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(Include.ALWAYS)
public class Pegawai {

    public long idPegawai;

    public String fullName;

    public String emailAddress;

    public PegawaiEntity toEntity() {

        PegawaiEntity entity = new PegawaiEntity();

        entity.setIdPegawai(idPegawai);
        entity.setFullName(fullName);
        entity.setEmailAddress(emailAddress);

        return entity;

    }

    public static Pegawai fromEntity(PegawaiEntity entity) {

        if (entity == null) return null;

        Pegawai pojo = null;
        pojo = new Pegawai();

        pojo.idPegawai = entity.getIdPegawai();
        pojo.fullName = entity.getFullName();
        pojo.emailAddress = entity.getEmailAddress();

        return pojo;

    }

    public static List<Pegawai> fromEntities(List<PegawaiEntity> entities) {
        if (entities == null) return new ArrayList<>();

        List<Pegawai> pojos = new ArrayList<>();

        for (PegawaiEntity entity : entities) {
            pojos.add(Pegawai.fromEntity(entity));
        }
        return pojos;
    }

}
