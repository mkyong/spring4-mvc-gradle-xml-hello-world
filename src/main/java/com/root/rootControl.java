package com.root;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class rootControl {

	@RequestMapping("/")
	public String index(Model md) {
		md.addAttribute("title", "title");
		return "index";
	}
	
	@RequestMapping("/{path}")
	public String root(@PathVariable String path,Model md) {
		md.addAttribute("title", path);
		return path;
	}
}
