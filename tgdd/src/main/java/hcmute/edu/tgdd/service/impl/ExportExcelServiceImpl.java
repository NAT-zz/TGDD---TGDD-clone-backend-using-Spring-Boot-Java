package hcmute.edu.tgdd.service.impl;

import hcmute.edu.tgdd.model.Cart;
import hcmute.edu.tgdd.model.CartDetail;
import hcmute.edu.tgdd.model.Product;
import hcmute.edu.tgdd.model.Statistics;
import hcmute.edu.tgdd.service.CartService;
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
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ExportExcelServiceImpl implements ExportExcelService {
  @Autowired
  private ProductService productService;
  @Autowired
  private CartService cartService;
  private XSSFWorkbook workbook;
  private XSSFSheet sheet;
  private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

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

  private void writeDataRows(List<CartDetail> cartDetailList) {
    int rowCount = 1;
    int stt = 1;

    CellStyle style = workbook.createCellStyle();
    XSSFFont font = workbook.createFont();
    font.setFontHeight(14);
    style.setFont(font);

    HashMap<Integer, Integer> hashMap = new HashMap<>();
    List<CartDetail> shortCartDetailList = removeDuplicatesProductDetail(cartDetailList, hashMap);

    List<Product> productList = getProductListFromCartDetailList(shortCartDetailList);

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

  @Override
  public void exportStatisticsByDay(HttpServletResponse response, List<CartDetail> cartDetailList)
      throws Exception {
    workbook = new XSSFWorkbook();
    sheet = workbook.createSheet("StatisticsByDay");

    writeHeaderRowsDay();
    writeDataRowsDay(cartDetailList);

    ServletOutputStream outputStream = response.getOutputStream();
    workbook.write(outputStream);
    workbook.close();
    outputStream.close();
  }

  @Override
  public void exportStatisticsByYear(HttpServletResponse response, List<CartDetail> cartDetailList, int year)
          throws Exception {
    workbook = new XSSFWorkbook();
    sheet = workbook.createSheet("StatisticsByYear");

    writeHeaderRowsYear();
    writeDataRowsYear(cartDetailList, year);

    ServletOutputStream outputStream = response.getOutputStream();
    workbook.write(outputStream);
    workbook.close();
    outputStream.close();
  }

  private void writeDataRowsYear(List<CartDetail> cartDetailList, int year) {
    int rowCount = 1;

    CellStyle style = workbook.createCellStyle();
    XSSFFont font = workbook.createFont();
    font.setFontHeight(14);
    style.setFont(font);

    List<Product> productList = getProductListFromCartDetailList(cartDetailList);
    List<Cart> cartList = getCartListFromCartDetailList(cartDetailList);

    List<Statistics> statisticsByDay = statisticsByDay(cartDetailList, productList, cartList);

    for (int i = 0; i < 12; i++) {
      Row row = sheet.createRow(rowCount++);

      Cell cell = row.createCell(0);
      cell.setCellValue(i+1);
      sheet.autoSizeColumn(0);
      cell.setCellStyle(style);

      double price = getRevenueByMonth(statisticsByDay, i, year);
      DecimalFormat format = new DecimalFormat("###,###,###");

      cell = row.createCell(1);
      cell.setCellValue(format.format(price)+" VNĐ");
      sheet.autoSizeColumn(1);
      cell.setCellStyle(style);
    }
  }

  private double getRevenueByMonth(List<Statistics> statisticsByDay, int month, int year) {
    double revenue = 0;
    for (int i = 0; i < statisticsByDay.size(); i++){
      Date date = statisticsByDay.get(i).getDate();
      if(date.getYear()+1900 != year)
        continue;

      if(date.getMonth() == month){
        revenue = revenue + statisticsByDay.get(i).getTotalRevenue();
      }
    }
    return  revenue;
  }

  private void writeHeaderRowsYear() {
    Row row = sheet.createRow(0);

    CellStyle style = workbook.createCellStyle();
    XSSFFont font = workbook.createFont();
    font.setBold(true);
    font.setFontHeight(16);
    style.setFont(font);

    Cell cell = row.createCell(0);
    cell.setCellValue("Tháng");
    cell.setCellStyle(style);

    cell = row.createCell(1);
    cell.setCellValue("Doanh thu");
    cell.setCellStyle(style);
  }

  private void writeHeaderRowsDay() {
    Row row = sheet.createRow(0);

    CellStyle style = workbook.createCellStyle();
    XSSFFont font = workbook.createFont();
    font.setBold(true);
    font.setFontHeight(16);
    style.setFont(font);

    Cell cell = row.createCell(0);
    cell.setCellValue("Ngày");
    cell.setCellStyle(style);

    cell = row.createCell(1);
    cell.setCellValue("Số lượng sản phẩm bán được");
    cell.setCellStyle(style);

    cell = row.createCell(2);
    cell.setCellValue("Tổng doanh thu");
    cell.setCellStyle(style);
  }

  private void writeDataRowsDay(List<CartDetail> cartDetailList) {
    int rowCount = 1;

    CellStyle style = workbook.createCellStyle();
    XSSFFont font = workbook.createFont();
    font.setFontHeight(14);
    style.setFont(font);

    List<Product> productList = getProductListFromCartDetailList(cartDetailList);
    List<Cart> cartList = getCartListFromCartDetailList(cartDetailList);

    List<Statistics> statistics = statisticsByDay(cartDetailList, productList, cartList);

    for (int i = 0; i < statistics.size(); i++) {
      Statistics s = statistics.get(i);

      Row row = sheet.createRow(rowCount++);

      String date = simpleDateFormat.format(s.getDate());

      Cell cell = row.createCell(0);
      cell.setCellValue(date);
      sheet.autoSizeColumn(0);
      cell.setCellStyle(style);

      cell = row.createCell(1);
      cell.setCellValue(s.getProductsSold());
      sheet.autoSizeColumn(1);
      cell.setCellStyle(style);

      DecimalFormat format = new DecimalFormat("###,###,###");

      cell = row.createCell(2);
      cell.setCellValue(format.format(s.getTotalRevenue())+" VNĐ");
      sheet.autoSizeColumn(2);
      cell.setCellStyle(style);
    }
  }

  private List<Statistics> statisticsByDay(
      List<CartDetail> cartDetailList, List<Product> productList, List<Cart> cartList) {
    List<Statistics> statisticsList = new ArrayList<>();

    HashMap<Date, Integer> countDateMap = new HashMap<>();
    insertDateToHashMap(cartList, countDateMap);

    HashMap<Date, Double> hashMap = new HashMap<>();
    HashMap<Date, Integer> hashMapSold = new HashMap<>();

    for(int position = 0; position < countDateMap.size(); position++){
      Date key = (new ArrayList<>(countDateMap.keySet())).get(position);

      for (int i = 0; i < cartList.size(); i++) {
        if(cartList.get(i).getDate().compareTo(key) == 0)
        {
          for (int j = 0; j < cartDetailList.size(); j++) {
            if (cartDetailList.get(j).getCartId() == cartList.get(i).getId()) {
              if (hashMap.containsKey(key)) {
                double price = hashMap.get(key) + productList.get(j).getPrice() * cartDetailList.get(j).getQuantity();
                int sold = hashMapSold.get(key) + cartDetailList.get(j).getQuantity();
                hashMap.put(key, price);
                hashMapSold.put(key, sold);
              } else {
                double price = cartDetailList.get(j).getQuantity() * productList.get(j).getPrice();
                hashMap.put(key, price);
                hashMapSold.put(key,cartDetailList.get(j).getQuantity() );
              }
            }
          }
        }
      }
      Statistics statistics = new Statistics();
      statistics.setDate(key);
      statistics.setProductsSold(hashMapSold.get(key));
      statistics.setTotalRevenue(hashMap.get(key));
      statisticsList.add(statistics);
    }
    return statisticsList;
  }

  private void insertDateToHashMap(List<Cart> cartList, HashMap<Date, Integer> hashMap) {
    for (int i = 0; i < cartList.size(); i++) {
      Date date = cartList.get(i).getDate();
      if (hashMap.containsKey(date)) {
        int count = hashMap.get(date) + 1;
        hashMap.put(date, count);
      } else {
        hashMap.put(date, 1);
      }
    }
  }

  private List<CartDetail> removeDuplicatesProductDetail(
      List<CartDetail> list, HashMap<Integer, Integer> hashMap) {
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

  private List<Cart> getCartListFromCartDetailList(List<CartDetail> list) {
    List<Cart> productList = new ArrayList<>();
    Set<Integer> cartSet = new HashSet<>();

    for (int i = 0; i < list.size(); i++) {
      int id = list.get(i).getCartId();
      cartSet.add(id);
    }

    for (Integer integer : cartSet) {
      Optional<Cart> p = cartService.findById(integer);
      p.ifPresent(productList::add);
    }
    return productList;
  }
}
