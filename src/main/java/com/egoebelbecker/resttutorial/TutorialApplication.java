package com.egoebelbecker.resttutorial;

import com.egoebelbecker.resttutorial.controller.TutorialController;
import com.thomsonreuters.atr.messaging.config.FixDomainJSONConfiguration;
import com.thomsonreuters.atr.messaging.config.IFixDomainConfiguration;
import com.thomsonreuters.atr.messaging.exceptions.FixDomainException;
import com.egoebelbecker.resttutorial.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@ComponentScan(basePackageClasses = TutorialController.class)
@SpringBootApplication
public class TutorialApplication {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(TutorialApplication.class, args);
        log.info("TutorialApplication started");
    }



}
