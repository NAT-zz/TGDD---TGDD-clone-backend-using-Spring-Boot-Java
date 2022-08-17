package hcmute.edu.tgdd.service;

import hcmute.edu.tgdd.model.CartDetail;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface ExportExcelService {
    void export(HttpServletResponse response, List<CartDetail> cartDetailList) throws Exception;
<<<<<<< HEAD
=======
    void exportStatisticsByDay(HttpServletResponse response, List<CartDetail> cartDetailList) throws Exception;
    void exportStatisticsByYear(HttpServletResponse response, List<CartDetail> cartDetailList, int year) throws Exception;
>>>>>>> 55042fe5d447965f194e5c2a93da6211c76f0a91
}
