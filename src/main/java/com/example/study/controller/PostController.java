package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class PostController {

//    html <form>
//    ajax 검색
//    http post body -> data
//    json, xml, multipart-form / text-plain

//    @RequestMapping(method = RequestMethod.POST, path = "/postMethod")
//    아래랑 같은 말임.
    @PostMapping(value = "/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam){
        return searchParam;
    }

    @PutMapping("/putMethod")
    public void put(){
    }

    @PatchMapping("/patchMethod")
    public void patch(){
    }
}
