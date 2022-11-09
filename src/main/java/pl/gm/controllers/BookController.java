package pl.gm.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.gm.model.Book;
import pl.gm.service.BookServiceImpl;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;


@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookServiceImpl bookServiceImpl;

    @GetMapping("/add")
    public String getForm(Model model) {
        model.addAttribute("book", new Book());
        return "book/form";
    }
    @PostMapping("/add")
    public String saveBook(@Valid Book book, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "book/form";
        } else {
            bookServiceImpl.add(book);
            return "redirect:/books/all";
        }
    }

    @GetMapping("/all")
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookServiceImpl.getBooks());
        return "book/list";
    }
    @GetMapping("/show/{id}")
    public String showBook(Model model, @PathVariable long id) {
        model.addAttribute("book", bookServiceImpl.get(id).orElseThrow(EntityNotFoundException::new));
        return "book/show";
    }

    @GetMapping("/edit/{id}")
    public String getBookEditForm(@PathVariable long id, Model model) {
        model.addAttribute("book", bookServiceImpl.get(id));
        return "book/edit";
    }

    @PostMapping("/edit")
    public String updateBook(@Valid Book book, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "book/edit";
        } else {
            bookServiceImpl.update(book);
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
        bookServiceImpl.delete(id);
        model.addAttribute("bookId", null);
        return "redirect:/books/all";
    }

}
