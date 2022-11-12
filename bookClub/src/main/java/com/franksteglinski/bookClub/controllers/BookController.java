package com.franksteglinski.bookClub.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.franksteglinski.bookClub.models.Book;
import com.franksteglinski.bookClub.services.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookServ;
	
	@GetMapping("/")
	public String index(Model model) {
		//show all the books
		List<Book> alldabooks = bookServ.allBooks();
		//pass the books to the jsp
		model.addAttribute("alldabooks", alldabooks);
		
		return "index.jsp";
	}
	
//	//Vanilla Create
//	@GetMapping("/create")
//	public String create(Model model) {
////		crate book object
//		Book newBook = new Book();
//		model.addAttribute("book", newBook);
//		return "create.jsp";
//	}
	
	//Simplified Create Page
    @GetMapping("/create")
    public String newBook(@ModelAttribute("book") Book book) {
        return "create.jsp";
    }
	
    //Create Method- Redirect
	@PostMapping("/books")
    public String create(
    		@Valid @ModelAttribute("book") Book book, 
    		BindingResult result, RedirectAttributes flash) {
        if (result.hasErrors()) {
            System.out.println(result);
        	return "create.jsp";
        } else {
            bookServ.createBook(book);
            flash.addFlashAttribute("success", "cool you made a book!");
            return "redirect:/";
        }
    }
	
	//Edit Page
	@GetMapping("/edit/{id}")
	public String updatePage(@PathVariable("id") Long id, Model model) {
//		System.out.println(id);
		Book book = bookServ.findBook(id);
		model.addAttribute("book", book);
		return "edit.jsp";
	}
	
	//Edit Method
	@RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            bookServ.updateBook(book);
            return "redirect:/";
        }
    }
	
	//Delete
	@RequestMapping(value="/books/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        bookServ.deleteBook(id);
        return "redirect:/";
    }
	
	//Read One
	@GetMapping("/books/{id}")
	public String showOne(@PathVariable("id") Long id, Model model) {
		Book thisBook = bookServ.findBook(id);
		model.addAttribute("thisBook", thisBook);
		return "showOne.jsp";
	}
}
