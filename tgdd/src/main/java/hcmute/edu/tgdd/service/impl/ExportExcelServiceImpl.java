package hcmute.edu.tgdd.service.impl;

import hcmute.edu.tgdd.model.CartDetail;
import hcmute.edu.tgdd.model.Product;
import hcmute.edu.tgdd.service.ExportExcelService;
import hcmute.edu.tgdd.service.ProductService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ExportExcelServiceImpl implements ExportExcelService {
  @Autowired
  private ProductService productService;
  private XSSFWorkbook workbook;
  private XSSFSheet sheet;

  private void writeHeaderRows() {
    Row row = sheet.createRow(0);

    CellStyle style = workbook.createCellStyle();
    XSSFFont font = workbook.createFont();
    font.setBold(true);
    font.setFontHeight(16);
    style.setFont(font);

    Cell cell = row.createCell(0);
    cell.setCellValue("STT");
    cell.setCellStyle(style);

    cell = row.createCell(1);
    cell.setCellValue("Tên sản phẩm");
    cell.setCellStyle(style);

    cell = row.createCell(2);
    cell.setCellValue("Id sản phẩm");
    cell.setCellStyle(style);

    cell = row.createCell(3);
    cell.setCellValue("Số lượng bán được");
    cell.setCellStyle(style);

    cell = row.createCell(4);
    cell.setCellValue("Đơn giá");
    cell.setCellStyle(style);

    cell = row.createCell(5);
    cell.setCellValue("Số tiền thu được");
    cell.setCellStyle(style);
  }

  private void writeDataRows(List<CartDetail> cartDetailList ) {
    int rowCount = 1;
    int stt = 1;

    CellStyle style = workbook.createCellStyle();
    XSSFFont font = workbook.createFont();
    font.setFontHeight(14);
    style.setFont(font);

    HashMap<Integer, Integer> hashMap = new HashMap<>();
    List<CartDetail> shortCartDetailList = removeDuplicatesProductDetail(cartDetailList, hashMap);

    List<Product> productList = getProductListFromCartDetailList(shortCartDetailList);

    System.out.println(hashMap);

    for (int i = 0; i < shortCartDetailList.size(); i++) {
      CartDetail c = shortCartDetailList.get(i);
      Product p = productList.get(i);
      Row row = sheet.createRow(rowCount++);

      Cell cell = row.createCell(0);
      cell.setCellValue(stt);
      sheet.autoSizeColumn(0);
      cell.setCellStyle(style);

      cell = row.createCell(1);
      cell.setCellValue(productList.get(stt - 1).getName());
      sheet.autoSizeColumn(1);
      cell.setCellStyle(style);

      cell = row.createCell(2);
      cell.setCellValue(c.getProductId());
      sheet.autoSizeColumn(2);
      cell.setCellStyle(style);

      cell = row.createCell(3);
      cell.setCellValue(c.getQuantity() * hashMap.get(c.getProductId()));
      sheet.autoSizeColumn(3);
      cell.setCellStyle(style);

      cell = row.createCell(4);
      cell.setCellValue(productList.get(stt - 1).getPrice());
      sheet.autoSizeColumn(4);
      cell.setCellStyle(style);

      cell = row.createCell(5);
      cell.setCellValue(p.getPrice() * hashMap.get(p.getId()) * c.getQuantity());
      sheet.autoSizeColumn(5);
      cell.setCellStyle(style);

      stt++;
    }
  }

  @Override
  public void export(HttpServletResponse response, List<CartDetail> cartDetailList)
      throws Exception {
    workbook = new XSSFWorkbook();
    sheet = workbook.createSheet("CartDetail");

    writeHeaderRows();
    writeDataRows(cartDetailList);

    ServletOutputStream outputStream = response.getOutputStream();
    workbook.write(outputStream);
    workbook.close();
    outputStream.close();
  }

  private List<CartDetail> removeDuplicatesProductDetail(List<CartDetail> list,  HashMap<Integer, Integer> hashMap) {
    List<CartDetail> newList = new ArrayList<>();
    newList.add(list.get(0));
    hashMap.put(1, 1);
    for (int i = 1; i < list.size(); i++) {
      CartDetail element = list.get(i);
      hashMap.put(element.getProductId(), 1);
      int flag = 1;
      for (int j = 0; j < newList.size(); j++) {
        if (newList.get(j).getProductId() == element.getProductId()) {
          int loopCount = hashMap.get(element.getProductId()) + 1;
          hashMap.put(element.getProductId(), loopCount);
          flag = 0;
          break;
        }
      }
      if (flag == 1) {
        newList.add(element);
      }
    }
    return newList;
  }

  private List<Product> getProductListFromCartDetailList(List<CartDetail> list) {
    List<Product> productList = new ArrayList<>();

    for (CartDetail cartDetail : list) {
      int id = cartDetail.getProductId();
      Optional<Product> p = productService.findById(id);
      p.ifPresent(productList::add);
    }
    return productList;
  }
}
