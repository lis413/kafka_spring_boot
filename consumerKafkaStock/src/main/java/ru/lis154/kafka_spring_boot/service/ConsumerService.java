package ru.lis154.kafka_spring_boot.service;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.stereotype.Service;
import ru.lis154.kafka_spring_boot.entity.UserSec;

@EnableKafka
@Service
public class ConsumerService {
    @Autowired
    DefaultEmailService defaultEmailService;

    @KafkaListener(topics = "messages", groupId = "message_group_id")
    public void consume(ConsumerRecord<String, UserSec> record){
        System.out.println(record.partition());
        System.out.println(record.key());
        System.out.println(record.value());
        UserSec user = record.value();
        System.out.println(user.getEmail() + "___________" + user.getId() + "______________" + user.getFirstName() + " " + user.getLastName());
        defaultEmailService.sendSimpleEmail(user.getEmail(), String.valueOf(user.getId()), user.getFirstName() + " " + user.getLastName());
    }
}
