package com.example.ktm.controller;

import com.example.ktm.apireponse.ApiResponse;
import com.example.ktm.constants.AppConst;
import com.example.ktm.entity.AppUser;
import com.example.ktm.enums.Types;
import com.example.ktm.exception.AppException;
import com.example.ktm.service.AppUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/app-users")
public class AppUserController {

    private final AppUserService service;

    public AppUserController(AppUserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> create (@RequestBody AppUser appUser){
        return ResponseEntity.ok(new ApiResponse(AppConst.OK, service.create(appUser), Types.ResponseType.SUCCESS));
    }

    @GetMapping
    public List<AppUser> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public AppUser findById(@PathVariable long id) {
//        throw new AppException(1001, "user", "Barani");
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public AppUser put(@PathVariable long id, @RequestBody AppUser appUser) {
         return service.update(id, appUser);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {
         service.deleteById(id);
         return "Deleted user with id: " + id;
    }
}
