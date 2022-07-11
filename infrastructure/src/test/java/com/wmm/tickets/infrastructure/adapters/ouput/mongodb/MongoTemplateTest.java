package com.wmm.tickets.infrastructure.adapters.ouput.mongodb;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import com.netflix.discovery.converters.Auto;
import com.wmm.domain.entity.Movement;
import com.wmm.domain.vo.MovementType;
import com.wmm.tickets.infrastructure.adapter.TicketsApplication;
import com.wmm.tickets.infrastructure.adapter.input.rest.model.response.TicketResponse;
import com.wmm.tickets.infrastructure.adapter.output.mongodb.repository.MovementRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import util.TestUtil;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static util.TestUtil.CREDIT_AMOUNT;
import static util.TestUtil.USER_ID_TEST;

@SpringBootTest(classes = TicketsApplication.class)
public class MongoTemplateTest {

    @Autowired
    private MovementRepository movementRepository;

    @Test
    public void test(@Autowired MongoTemplate mongoTemplate) {
        assertThat(movementRepository).isNotNull();
        assertThat(mongoTemplate).isNotNull();
    }

    @Test
    public void testGroupAndSumValues(@Autowired MongoTemplate mongoTemplate) {
        GroupOperation groupOperationSum = group( "userId")
                .sum("amount")
                .as("amount")
                ;
        MatchOperation matchOperation = match(new Criteria("userId")
                .is(USER_ID_TEST));

        Aggregation aggregation = newAggregation(
                matchOperation,  groupOperationSum);

        AggregationResults<TicketResponse> response = mongoTemplate.aggregate(aggregation,

                "movements"
                , TicketResponse.class);

        System.out.println(response.getMappedResults());
    }

    @Test
    public void test2(@Autowired MongoTemplate mongoTemplate){
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(USER_ID_TEST));
        mongoTemplate.find(query, Movement.class, "movements");
    }

}
