package spring_pegawai.pegawaiDbNew.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_pegawai.pegawaiDbNew.pojo.PPegawai;
import spring_pegawai.pegawaiDbNew.repositories.RPegawai;

@Service("sPegawai")
public class SPegawai {

    @Autowired
    private RPegawai rPegawai;

    // Get All Pegawai
    public PPegawai getAllPegawai(Long idPegawai){
        return PPegawai.fromEntity(rPegawai.getAllPegawai(idPegawai));
    }

}
