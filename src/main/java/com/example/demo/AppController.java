package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private BookService service;
    @Autowired
    private CategoryService service_;



    @RequestMapping("/index2")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<Book> listBooks = service.listAll(keyword);
        model.addAttribute("listBooks", listBooks);
        model.addAttribute("keyword", keyword);

        return "index2";
    }

    @RequestMapping("/index3")
    public String viewHome2Page(Model model, @Param("keyword") String keyword) {
        List<Book> listBooks = service.listAll(keyword);
        model.addAttribute("listBooks", listBooks);
        model.addAttribute("keyword", keyword);

        return "index3";
    }


    @RequestMapping("/category")
    public String viewCategoryPage(Model model, @Param("keyword") String keyword) {
        List<Category> listCategory = service_.listAll(keyword);
        model.addAttribute("listCategory", listCategory);
        model.addAttribute("keyword", keyword);
        return "category_book";
    }

    @RequestMapping("/new")
    public String showNewBookForm(Model model, @Param("keyword") String keyword) {
        Book book = new Book();
        Category category = new Category();
        List<Category> listCategory = service_.listAll(keyword);
        model.addAttribute("listCategory", listCategory);
        model.addAttribute("keyword", keyword);
        model.addAttribute("book", book);
        model.addAttribute("category",category);
        return "new_book";
    }



    @RequestMapping("/new_book")
    public String showNewBookCatForm(Model model, @Param("keyword") String keyword) {
        Book book = new Book();
        Category category = new Category();
        List<Category> listCategory = service_.listAll(keyword);
        model.addAttribute("listCategory", listCategory);
        model.addAttribute("keyword", keyword);
        model.addAttribute("book", book);
        model.addAttribute("category",category);
        return "new_book";
    }



    @RequestMapping("/new_category")
    public String showNewCategoryForm(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);

        return "new_category_book";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute("book") Book book) {
        service.save(book);

        return "redirect:/index2";

    }

    @RequestMapping(value = "/save_category", method = RequestMethod.POST)
    public String saveCategory(@ModelAttribute("category") Category category) {
        service_.save(category);

        return "redirect:/index2";

    }


    @RequestMapping("/edit/{id}")
    public ModelAndView showEditBookForm(@PathVariable(name = "id") Long id, Model model, @Param("keyword") String keyword) {
        ModelAndView modelAndView = new ModelAndView("edit_book");
        Book book = service.get(id);
        modelAndView.addObject("book", book);
        Category category = new Category();
        List<Category> listCategory = service_.listAll(keyword);
        model.addAttribute("list2Category", listCategory);
        model.addAttribute("keyword", keyword);
        model.addAttribute("category",category);

        return modelAndView;
    }

    @RequestMapping("/edit_category/{id}")
    public ModelAndView showEditCategoryForm(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("edit_category_book");
        Category category = service_.get(id);
        modelAndView.addObject("category", category);

        return modelAndView;
    }



    @RequestMapping("/delete/{id}")
    public String deleteBook(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/index2";
    }

    @RequestMapping("/delete2/{id}")
    public String deleteCategory(@PathVariable(name = "id") Long id) {
        service_.delete(id);
        return "redirect:/index2";
    }


}

