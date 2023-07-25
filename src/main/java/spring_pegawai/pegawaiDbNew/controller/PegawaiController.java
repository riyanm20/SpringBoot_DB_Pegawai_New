package spring_pegawai.pegawaiDbNew.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring_pegawai.pegawaiDbNew.entity.PegawaiEntity;
import spring_pegawai.pegawaiDbNew.pojo.Pegawai;
import spring_pegawai.pegawaiDbNew.services.PegawaiService;
import spring_pegawai.pegawaiDbNew.util.ApiResponse;

@RestController
@RequestMapping("/api/apicek")
public class PegawaiController {

    @Autowired
    private PegawaiService pegawaiService;

    @GetMapping
    // CEK API
    // public static void cekApiResponse() { System.out.println("Api Berhasil"); }
    public ApiResponse get(@RequestParam(required = false) Long idPegawai) throws JsonProcessingException {
        Pegawai pegawai = pegawaiService.getAllPegawai(idPegawai);
        return ApiResponse.data("item", pegawai);
    }

    // Tambah Pegawai Baru
    @PostMapping
    public ApiResponse add(@RequestBody Pegawai pojo) {
        PegawaiEntity added = pegawaiService.add(pojo.toEntity());
        return ApiResponse.data("item", Pegawai.fromEntity(added));
    }

    // Edit Pegawai
    @PutMapping
    public ApiResponse edit(@RequestBody Pegawai pojo) {
        PegawaiEntity edited = pegawaiService.edit(pojo.toEntity());
        return ApiResponse.data("item", Pegawai.fromEntity(edited));
    }

    // Delete Pegawai
    @DeleteMapping
    public ApiResponse delete(@RequestParam(required = false) Long idPegawai) {
        pegawaiService.delete(idPegawai);
        return ApiResponse.ok();
    }

}
