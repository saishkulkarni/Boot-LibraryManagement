package org.jsp.library.controller;

import org.jsp.library.dto.Book;
import org.jsp.library.dto.Librarian;
import org.jsp.library.helper.LoginHelper;
import org.jsp.library.helper.ResponseStructure;
import org.jsp.library.service.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/librarian")
public class LibrarianController {

	@Autowired
	LibrarianService librarianService;

	@PostMapping
	public ResponseEntity<ResponseStructure<Librarian>> createLibrarianAccount(@RequestBody Librarian librarian){
		return librarianService.createLibrarianAccount(librarian);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Librarian>> createLibrarianAccount(@RequestParam int id,
			@RequestParam int otp){
		return librarianService.createLibrarianAccount(id, otp);
	}

	@PostMapping("/login")
	public ResponseEntity<ResponseStructure<Librarian>> login(@RequestBody LoginHelper helper) {
		return librarianService.login(helper);
	}

	@PostMapping("/book")
	public ResponseEntity<ResponseStructure<Book>> addBook(@RequestBody Book book)
	{
		return librarianService.addBook(book);
	}

	@GetMapping("/book/id/{id}")
	public ResponseEntity<ResponseStructure<Book>> fetchBook(@PathVariable int id)
	{
		return librarianService.fetchBook(id);
	}

	@GetMapping("/book/name/{name}")
	public ResponseEntity<ResponseStructure<Book>> fetchBook(@PathVariable String name)
	{
		return librarianService.fetchBook(name);
	}

	@GetMapping("/book/author/{author}")
	public ResponseEntity<ResponseStructure<Book>> fetchBookByAuthor(@PathVariable String author)
	{
		return librarianService.fetchBookByAuthor(author);
	}

	@GetMapping("/books")
	public ResponseEntity<ResponseStructure<Book>> fetchBook()
	{
		return librarianService.fetchAllBooks();
	}

	@GetMapping("/books/available")
	public ResponseEntity<ResponseStructure<Book>> fetchAvailableBooks()
	{
		return librarianService.fetchAllBooks(true);
	}

	@PutMapping("/book")
	public ResponseEntity<ResponseStructure<Book>> updateBook(@RequestBody Book book)
	{
		return librarianService.updateBook(book);
	}

	@DeleteMapping("/book/{id}")
	public ResponseEntity<ResponseStructure<Book>> deleteBook(@PathVariable int id)
	{
		return librarianService.deleteBook(id);
	}

}
