package com.example.ktm.org.ctrl;

import com.example.ktm.apireponse.ApiResponse;
import com.example.ktm.constants.AppConst;
import com.example.ktm.enummisc.Types;
import com.example.ktm.opsunit.dto.OpsUnitDto;
import com.example.ktm.opsunit.service.OpsUnitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/org")
public class OrgCtrl {

    private final OpsUnitService unitService;

    public OrgCtrl(OpsUnitService unitService) {
        this.unitService = unitService;
    }

//  TODO: Use org id
    @PostMapping("/{id}/ops-unit")
    public ResponseEntity<ApiResponse> create (@RequestBody OpsUnitDto dto){
        return ResponseEntity.ok(
                new ApiResponse(AppConst.OK, unitService.createDto(dto), Types.ResponseType.SUCCESS));
    }
}
