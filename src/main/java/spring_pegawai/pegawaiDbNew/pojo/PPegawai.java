package spring_pegawai.pegawaiDbNew.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import spring_pegawai.pegawaiDbNew.entity.EPegawai;

import java.util.ArrayList;
import java.util.List;

@JsonInclude
public class PPegawai {

    public long idPegawai;
    public String fullName;
    public String emailAddress;

    public EPegawai toEntity() {

        EPegawai entity = new EPegawai();

        entity.setIdPegawai(idPegawai);
        entity.setFullName(fullName);
        entity.setEmailAddress(emailAddress);

        return entity;

    }

    public static PPegawai fromEntity(EPegawai entity) {

        if (entity == null) { return null; }

        PPegawai pojo = null;
        pojo = new PPegawai();

        pojo.idPegawai = entity.getIdPegawai();
        pojo.fullName = entity.getFullName();
        pojo.emailAddress = entity.getEmailAddress();

        return pojo;

    }

    public static List<PPegawai> fromEntities(List<EPegawai> entities) {
        if (entities == null) return new ArrayList<>();

        List<PPegawai> pojos = new ArrayList<>();

        for (EPegawai entity : entities) {
            pojos.add(PPegawai.fromEntity(entity));
        }
        return pojos;
    }

}
