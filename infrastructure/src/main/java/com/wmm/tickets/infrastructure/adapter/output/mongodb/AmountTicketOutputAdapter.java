package com.wmm.tickets.infrastructure.adapter.output.mongodb;

import com.wmm.domain.entity.Movement;
import com.wmm.domain.vo.MovementType;
import com.wmm.tickets.application.ports.output.AmountTicketOutputPort;
import com.wmm.tickets.infrastructure.adapter.input.rest.model.response.TicketResponse;
import com.wmm.tickets.infrastructure.adapter.output.mongodb.entity.MovementEntity;
import com.wmm.tickets.infrastructure.adapter.output.mongodb.repository.MovementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.swing.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;

@Service
@RequiredArgsConstructor
public class AmountTicketOutputAdapter implements AmountTicketOutputPort {

    @Autowired
    private MongoTemplate mongoTemplate;


    public BigDecimal x(String userId,
                                                                                        MovementType movementType,
                                                                                        LocalDateTime startDate,
                                                                                        LocalDateTime endDate) {
        MatchOperation matchOperation = new MatchOperation(new Criteria("userId")
                .is(userId)
                .and("movementType")
                .is(movementType));

        GroupOperation groupOperation = group("userId")
                .sum("amount")
                .as("amount");

        Aggregation aggregation = newAggregation(matchOperation, groupOperation);
        AggregationResults<TicketResponse> ticketResponses =
                mongoTemplate.aggregate(aggregation, "movements",
                        TicketResponse.class);
        return new BigDecimal(ticketResponses.getMappedResults()
                .stream()
                .findFirst()
                .orElse(new TicketResponse("0.0")).getAmount());
    }

    @Override
    public BigDecimal sumAmountByUserIdAndMovementTypeAndDateGreaterThanAndDateLessThan(String userId,
                  MovementType movementType,
                  LocalDateTime startDate,
                  LocalDateTime endDate){
        Query query = new Query();
        query.addCriteria(Criteria
                .where("userId").is("1")
                .and("date").gt(startDate).lt(endDate)
                .and("movementType").is(movementType));

        List<MovementEntity> movements = mongoTemplate.find(query, MovementEntity.class);
        System.out.println(movements);

        return BigDecimal.valueOf(movements.stream()
                .map(m->m.getAmount())
                .reduce(0.0, Double::sum));
    }

}
