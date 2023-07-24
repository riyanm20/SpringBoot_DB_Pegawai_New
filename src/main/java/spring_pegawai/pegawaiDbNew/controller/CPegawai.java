package spring_pegawai.pegawaiDbNew.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring_pegawai.pegawaiDbNew.pojo.PPegawai;
import spring_pegawai.pegawaiDbNew.services.SPegawai;
import spring_pegawai.pegawaiDbNew.util.ApiResponse;

@RestController
@RequestMapping("/api/")
public class CPegawai {

    @Autowired
    private SPegawai sPegawai;

    // GET
    @GetMapping("/getPegawaiNew")
    public ApiResponse get(@RequestParam(required = false) Long idPegawai) throws JsonProcessingException {
        PPegawai pPegawai = sPegawai.getAllPegawai(idPegawai);
        return ApiResponse.data("item", pPegawai);
    }

}
