/**
 * 
 */
package com.gizlo.ms.usuario.utils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author fobregon
 *
 */
@Controller
public class HomeController {
	
	@RequestMapping("/")
    public String index() {
        return "redirect:swagger-ui.html";
    }

}
