package foodelicious.backend.reportPage.service;

import foodelicious.backend.reportPage.model.BkReportAgeDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BkReportAgeServiceImpl implements BkReportAgeService{

    private BkReportAgeDao bkReportAgeDao;

    public BkReportAgeServiceImpl(BkReportAgeDao bkReportAgeDao) {
        this.bkReportAgeDao = bkReportAgeDao;
    }

    @Override
    public List countByAge() {
        return bkReportAgeDao.countByAge();
    }
}
