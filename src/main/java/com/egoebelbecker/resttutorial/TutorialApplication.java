package com.egoebelbecker.resttutorial;

import com.egoebelbecker.resttutorial.controller.TutorialController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootApplication
public class TutorialApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(TutorialApplication.class, args);
        log.info("TutorialApplication started");


        TutorialController commandController = context.getBean(TutorialController.class);
        commandController.init();




    }



}
