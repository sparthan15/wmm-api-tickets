package com.wmm.tickets.infrastructure.adapter.output.mongodb.repository;

import com.wmm.domain.entity.Movement;
import com.wmm.domain.vo.MovementType;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface MovementRepository extends MongoRepository<Movement, String> {

    void deleteByUserId(String userId);

    long countByUserIdAndMovementType(String userId, MovementType movementType);

    @Aggregation(pipeline = {
            "{$match: { userId: ?0}}",
            "{$match: { movementType: ?1}}",
            "{$group: { _id: '', total: {$sum: amount}}}"
    })
    Optional<BigDecimal> sumAmountByUserIdAndMovementType(String userId, MovementType movementType);

}
