package org.example.springexamples.form_types;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/axios")
public class FormTypesController {

    @RequestMapping("/test1")
    @ResponseBody
    public String test1(@RequestParam("name") String name, @RequestParam("age") String age, @RequestHeader("Content-Type") String contentType) {
        System.out.println("name: " + name);
        System.out.println("age: " + age);
        System.out.println(contentType);
        return "Hello Wrold";
    }

    /**
     * post 请求，前端传递 json 对象时
     *
     * @param jsonString
     * @return
     */
    @RequestMapping("/test2")
    @ResponseBody
    public String test2(@RequestBody String jsonString, @RequestHeader("Content-Type") String contentType) {
        System.out.println(jsonString);
        System.out.println(contentType);
        return "Hello Wrold";
    }

}
