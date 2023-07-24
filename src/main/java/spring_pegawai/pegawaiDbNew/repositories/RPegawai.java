package spring_pegawai.pegawaiDbNew.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import spring_pegawai.pegawaiDbNew.entity.EPegawai;

@Repository
public class RPegawai extends SimpleJpaRepository<EPegawai, Long> {

    protected final EntityManager em;

    public RPegawai (EntityManager em) {
        super(EPegawai.class, em);
        this.em = em;
    }

    public EPegawai getAllPegawai(Long idPegawai) {
        String query = "Select e from EPegawai e";

        try {
            return em.createQuery(query, EPegawai.class)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
