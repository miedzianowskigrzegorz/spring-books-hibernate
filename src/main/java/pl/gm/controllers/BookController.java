package pl.gm.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.gm.model.Book;
import pl.gm.repository.BookRepository;

import javax.validation.Valid;


@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    @Autowired
    private final BookRepository bookRepository;

    @GetMapping("/add")
    public String getForm(Model model) {
        model.addAttribute("book", new Book());
        return "book/form";
    }

    @GetMapping("/all")
    public String getAllBooks(Model model) {
        model.addAttribute("books",bookRepository.findAll());
        return "book/list";
    }
    @GetMapping("/edit/{id}")
    public String getBookEditForm(@PathVariable long id, Model model) {
        model.addAttribute("book", bookRepository.findById(id));
        return "book/edit";
    }

    @PostMapping("/edit")
    public String updateBook(@Valid Book book, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "book/edit";
        } else {
            bookRepository.save(book);
            return "redirect:/books/all";
        }
    }
    @GetMapping("/remove/{id}")
    public String getRemoveForm(@PathVariable long id, Model model) {
        model.addAttribute("bookId", id);
        return "book/delete";
    }

    @GetMapping("/delete/{id}")
    public String removeBook(@PathVariable long id, Model model) {
        bookRepository.deleteById(id);
        model.addAttribute("bookId", null);
        return "redirect:/books/all";
    }

}
