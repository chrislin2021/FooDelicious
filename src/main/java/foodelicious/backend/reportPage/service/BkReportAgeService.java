package foodelicious.backend.reportPage.service;

import foodelicious.backend.productPage.model.BkProduct;

import java.util.List;

public interface BkReportAgeService {

    public List countByAge();

    public List<BkProduct> topFood();

    public List<BkProduct> topTool();
}
