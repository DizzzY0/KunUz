package com.company.kunuz.Repository;




import com.company.kunuz.Entity.ProfileEntity;
import com.company.kunuz.Enums.ProfileStatus;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ProfileRepository extends CrudRepository<ProfileEntity, Integer> {

    Optional<ProfileEntity> findByEmailAndVisibleTrue(String email);

    @Transactional
    @Modifying
    @Query("update ProfileEntity set status =?2 where id =?1")
    int updateStatus(Integer profileId, ProfileStatus status);

}
