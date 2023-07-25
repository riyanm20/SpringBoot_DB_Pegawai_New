package spring_pegawai.pegawaiDbNew.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring_pegawai.pegawaiDbNew.entity.PegawaiEntity;
import spring_pegawai.pegawaiDbNew.pojo.Pegawai;
import spring_pegawai.pegawaiDbNew.repositories.PegawaiRepo;

@Service("pegawaiService")
public class PegawaiService {

    @Autowired
    private PegawaiRepo pegawaiRepo;

    public Pegawai getAllPegawai(Long idPegawai){
        return Pegawai.fromEntity(pegawaiRepo.getAllPegawai(idPegawai));
    }

    // Tambah Pegawai Baru
    @Transactional
    public PegawaiEntity add(PegawaiEntity entity) {
        return pegawaiRepo.save(entity);
    }

    // Edit Pegawai
    @Transactional
    public PegawaiEntity edit(PegawaiEntity entity) {
        return pegawaiRepo.save(entity);
    }

    // Delete Pegawai
    @Transactional
    public void  delete(Long idPegawai) {
        PegawaiEntity pegawaiEntity = pegawaiRepo.getAllPegawai(idPegawai);
        pegawaiRepo.delete(pegawaiEntity);
    }

}
