package com.example.ktm.appuser.ctrl;

import com.example.ktm.apireponse.ApiResponse;
import com.example.ktm.constants.AppConst;
import com.example.ktm.appuser.dto.AppUserDto;
import com.example.ktm.appuser.entity.AppUser;
import com.example.ktm.enummisc.Types;
import com.example.ktm.fetchview.Views;
import com.example.ktm.appuser.service.AppUserService;
import com.fasterxml.jackson.annotation.JsonView;
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
public class AppUserCtrl {

    private final AppUserService service;

    public AppUserCtrl(AppUserService service) {
        this.service = service;
    }

    @PostMapping
    @JsonView(Views.Create.class)
    public ResponseEntity<ApiResponse> create (@RequestBody @JsonView(Views.Create.class) AppUserDto dto){
        return ResponseEntity.ok(
                new ApiResponse(AppConst.OK, service.createDto(dto), Types.ResponseType.SUCCESS));
    }

    @GetMapping
    public List<AppUser> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public AppUser findById(@PathVariable long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    @JsonView(Views.Response.class)
    public ResponseEntity<ApiResponse> put(@PathVariable long id, @RequestBody @JsonView(Views.Update.class) AppUserDto dto) {
        return ResponseEntity.ok(
                new ApiResponse(AppConst.OK, service.updateDto(id, dto), Types.ResponseType.SUCCESS));
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {
         service.deleteById(id);
         return "Deleted user with id: " + id;
    }
}
