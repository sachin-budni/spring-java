package com.org.controllers;

import java.io.OutputStream;
import java.io.Reader;
import java.util.List;

import org.apache.catalina.connector.OutputBuffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.json.ReaderBasedJsonParser;
import com.org.models.Book;
import com.org.services.BookService;

import jdk.nashorn.internal.parser.JSONParser;

@Controller
public class BookController {
	//@Autowired
		private BookService bookService;
		
		@Autowired
		public BookController(BookService bookService) {
			this.bookService = bookService;
		}
		
		@RequestMapping("/book/message")
		@ResponseBody
		public String sayHello() {
			return this.bookService.getMessageOne();
		}
		
		@RequestMapping("/book/read")
		@ResponseBody
		public List<Book> read() {
			return this.bookService.readData();
		}
		
//		@RequestMapping("/book/add")
//		@ResponseBody
//		public Book add() {
//			return this.bookService.add();
//		}
//		
		
		 @RequestMapping(value = "/book/add", method = RequestMethod.POST)
		 @ResponseBody
		 public Book setData(@RequestBody Book book) {
			 return this.bookService.add(book);
		 }


}
