package fr.aw.controller;

import fr.aw.model.cassandra.gradients.GradientMessage;
import fr.aw.repository.GradientsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by julian on 01/04/18.
 */
@RestController
@RequestMapping("/cassandra")
@CrossOrigin(origins = "*")
public class CassandraController {

    private Logger logger= LoggerFactory.getLogger(CassandraController.class);

    @Autowired
    GradientsRepository gradientsRepository;

    @GetMapping("/gradients")
    public List<GradientMessage> getAllGradients() {
        return gradientsRepository.findAll();
    }

    @DeleteMapping("/gradients")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllGradients() {
        logger.info("delete all!!");
        gradientsRepository.deleteAll();
    }

    @GetMapping("/gradients/by-key/{key}")
    public List<GradientMessage> getGradients(@PathVariable("key") String key) {
        return gradientsRepository.findByKeyKey(key);
    }
}
