package com.company.app.csv;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import com.company.app.pojo.Book;

public class CsvFileHandler {

  public static void main(String[] args) {
//    readCsvFile("./files/Library.csv");
    writeCsvFile("./files/Library2.csv");
  }

  //Delimiter used in CSV file
  private static final String   NEW_LINE_SEPARATOR  = "\n";

  //CSV file header
  private static final Object[] FILE_HEADER         = { "id", "author", "title" };

  //CSV file header
  private static final String[] FILE_HEADER_MAPPING = { "id", "author", "title" };

  //book attributes
  private static final String   ID                  = "id";
  private static final String   AUTHOR              = "author";
  private static final String   TITLE               = "title";

  public static void readCsvFile(String fileName) {
    FileReader fileReader = null;
    CSVParser csvFileParser = null;

    //Create the CSVFormat object with the header mapping
    CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING);

    try {

      //Create a new list of student to be filled by CSV file data 
      List<Book> books = new ArrayList<Book>();

      //initialize FileReader object
      fileReader = new FileReader(fileName);

      //initialize CSVParser object
      csvFileParser = new CSVParser(fileReader, csvFileFormat);

      //Get a list of CSV file records
      List<CSVRecord> csvRecords = csvFileParser.getRecords();

      //Read the CSV file records starting from the second record to skip the header
      for (int i = 1; i < csvRecords.size(); i++) {
        CSVRecord record = csvRecords.get(i);
        //Create a new student object and fill his data
        Book book = new Book(Long.parseLong(record.get(ID)), record.get(AUTHOR), record.get(TITLE));
        books.add(book);
      }

      //Print the new student list
      for (Book book : books) {
        System.out.println(book.toString());
      }
      
      fileReader.close();
      csvFileParser.close();
    } catch (Exception e) {
      System.out.println("Error in CsvFileReader !!!");
      e.printStackTrace();
    } 
  }

  public static void writeCsvFile(String fileName) {

    //Create new students objects
    Book book1 = new Book(1L, "Ahmed", "My life");
    Book book2 = new Book(2L, "Sara", "Be Happy");
    Book book3 = new Book(3L, "Ali", "Be honest");

    //Create a new list of student objects
    List<Book> books = new ArrayList<Book>();
    books.add(book1);
    books.add(book2);
    books.add(book3);

    FileWriter fileWriter = null;

    CSVPrinter csvFilePrinter = null;

    //Create the CSVFormat object with "\n" as a record delimiter
    CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);

    try {

      //initialize FileWriter object
      fileWriter = new FileWriter(fileName);

      //initialize CSVPrinter object 
      csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);

      //Create CSV file header
      csvFilePrinter.printRecord(FILE_HEADER);

      //Write a new student object list to the CSV file
      for (Book book : books) {
        List<String> bookDataRecord = new ArrayList<String>();
        bookDataRecord.add(String.valueOf(book.getId()));
        bookDataRecord.add(book.getAuthor());
        bookDataRecord.add(book.getTitle());
        csvFilePrinter.printRecord(bookDataRecord);
      }
      fileWriter.flush();
      fileWriter.close();
      csvFilePrinter.close();
    } catch (IOException ioe) {
      System.out.println("Error in CsvFileWriter !!!");
      ioe.printStackTrace();
    }
  }
}
