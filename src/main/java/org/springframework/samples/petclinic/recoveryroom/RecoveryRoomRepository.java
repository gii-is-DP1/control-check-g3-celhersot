package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecoveryRoomRepository extends CrudRepository<RecoveryRoom, Integer>{
	@Query("SELECT recoveryRoom FROM RecoveryRoom recoveryRoom")
	public List<RecoveryRoom> findAll();
	
	@Query("SELECT roomType FROM RecoveryRoomType roomType")
    public List<RecoveryRoomType> findAllRecoveryRoomTypes();
    //Optional<RecoveryRoom> findById(int id);
    //RecoveryRoom save(RecoveryRoom p);
	
	@Query("SELECT roomType FROM RecoveryRoomType roomType WHERE roomType.name =?1")
    public RecoveryRoomType getRecoveryRoomType(String name);
	
	@Query("SELECT recoveryRoom FROM RecoveryRoom recoveryRoom WHERE recoveryRoom.size > ?1")
    public List<RecoveryRoom> findBySizeMoreThan(double size);
}
