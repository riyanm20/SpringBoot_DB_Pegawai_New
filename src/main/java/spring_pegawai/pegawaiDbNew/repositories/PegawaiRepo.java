package spring_pegawai.pegawaiDbNew.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import spring_pegawai.pegawaiDbNew.entity.PegawaiEntity;

@Repository
public class PegawaiRepo extends SimpleJpaRepository<PegawaiEntity, Long> {

    protected final EntityManager em;

    public PegawaiRepo(EntityManager em) {
        super(PegawaiEntity.class, em);
        this.em = em;
    }

    public PegawaiEntity getAllPegawai(Long idPegawai) {
        String query = "Select e from PegawaiEntity e";

        try {
            return em.createQuery(query, PegawaiEntity.class)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }

}
