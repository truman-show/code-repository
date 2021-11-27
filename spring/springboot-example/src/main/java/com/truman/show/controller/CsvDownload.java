package com.truman.show.controller;

import com.truman.show.domain.Tutorial;
import com.truman.show.helper.WriteDataToCSV;
import com.truman.show.service.CSVService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CsvDownload {

  @Autowired
  CSVService fileService;

  @GetMapping("/download")
  public ResponseEntity<Resource> download() {
    String filename = "tutorials.csv";
    InputStreamResource file = new InputStreamResource(fileService.load());

    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
        .contentType(MediaType.parseMediaType("application/csv"))
        .body(file);
  }


  @GetMapping("/download2")
  public void download2(HttpServletResponse response) throws IOException {
    response.setContentType("text/csv;charset=UTF-8");
    response.setHeader("Content-Disposition", "attachment; file=customers.csv");

    WriteDataToCSV.writeObjectToCSV(response.getWriter(),
        List.of(
            Tutorial.builder()
                .id(1).description("설명1").published(true).title("안녕하세요1")
                .build()
            , Tutorial.builder()
                .id(2).description("설명2").published(false).title("안녕하세요2")
                .build())
    );

  }


  @GetMapping("/download3")
  public ResponseEntity<Resource> download3() {
    String filename = "tutorials.csv";
    InputStreamResource file = new InputStreamResource(fileService.load2());

    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
        .contentType(MediaType.parseMediaType("application/csv"))
        .body(file);
  }

  @ToString
  public static class Foo<T> {
    private Class<T> type;

    public Foo(Class<T> type) {
      this.type = type;
    }
  }

  public static void main(String[] args) {
    Foo<Integer> test = new Foo<>(Integer.class);
    System.out.println(test.getClass().getSimpleName());
    System.out.println(test.getClass());

    test(test.getClass());

    String temp = new String();
    temp.getClass();

    List<String> aaa = new ArrayList<>();
    test(aaa.get(0).getClass());
  }

  public static <T> void test(T test){
    System.out.println(test.getClass());
  }

}

