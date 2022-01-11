package foodelicious.backend.reportPage.controller;

import foodelicious.backend.reportPage.repository.BkReportAgeRepository;
import foodelicious.backend.reportPage.service.BkReportAgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class BkReportAgeController {

    private BkReportAgeService bkReportAgeService;

    public BkReportAgeController(BkReportAgeService bkReportAgeService) {
        this.bkReportAgeService = bkReportAgeService;
    }

    @GetMapping("/report/age")
    public List countByAge(){
        return bkReportAgeService.countByAge();
    }
}
