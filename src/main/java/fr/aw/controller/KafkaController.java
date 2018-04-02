package fr.aw.controller;

import fr.aw.model.kafka.gradients.GradientData;
import fr.aw.service.KafkaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by julian on 01/04/18.
 */
@RestController
@RequestMapping("/kafka")
@CrossOrigin(origins = "*")
public class KafkaController {

    private Logger logger= LoggerFactory.getLogger(KafkaController.class);

    @Autowired
    KafkaService kafkaService;

    @PostMapping(
            path = "/gradients",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public GradientData getGradients(@RequestBody GradientData data) {
        String message = String.format("sending %d gradients to kafka", data.getGradients().size());
        logger.info(message);
        kafkaService.send(data);
        return data;
    }
}