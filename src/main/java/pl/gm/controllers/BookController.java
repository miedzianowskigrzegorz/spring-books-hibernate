package pl.gm.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.gm.repository.BookRepository;


@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    @Autowired
    private final BookRepository bookRepository;
}
