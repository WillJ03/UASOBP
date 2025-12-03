package com.example.demospringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demospringboot.entity.Buku;
import com.example.demospringboot.entity.DetailPeminjaman;
import com.example.demospringboot.entity.Mahasiswa;
import com.example.demospringboot.entity.Orang;
import com.example.demospringboot.entity.Staff;
import com.example.demospringboot.entity.TransaksiPeminjaman;
import com.example.demospringboot.service.BukuService;
import com.example.demospringboot.service.DetailPeminjamanService;
import com.example.demospringboot.service.MahasiswaService;
import com.example.demospringboot.service.OrangService;
import com.example.demospringboot.service.StaffService;
import com.example.demospringboot.service.TransaksiPeminjamanService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class OrangController {

    @Autowired
    private OrangService orangService;
    @Autowired
    private MahasiswaService mahasiswaService;
    @Autowired
    private StaffService staffService;
    @Autowired
    private BukuService bukuService;
    @Autowired
    private DetailPeminjamanService detailPeminjamanService;
    @Autowired
    private TransaksiPeminjamanService transaksiPeminjamanService;


   // =========LOGIN ORANG==========
    @GetMapping("/loginOrang")
    public String orangLoginPage(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("Orang") != null) {
            return "redirect:/orang";
        }
        return "loginorang";  
    }

    @PostMapping(value="/validateLoginOrang")
    public String orangLogin(Model model, @RequestParam(value="id") Long kodeUser,
    @RequestParam(value="nama") String passUser, HttpServletRequest request) {
        Orang O = orangService.findOrang(kodeUser);
        model.addAttribute("userRec", O);
            if(O != null && passUser.equals(O.getNama())) {
            request.getSession().setAttribute("Orang", O);
            model.addAttribute("userRec", O);
            return "redirect:/orang";
        }
        else return "redirect:/loginOrang";
    }

    @GetMapping("/logoutOrang")
    public String orangLogout(HttpServletRequest request) {
        if (request.getSession().getAttribute("Orang") != null) {
            request.getSession().invalidate();
        }
        return "redirect:/loginOrang";
}


@GetMapping({"/homepage", "/homepage/"})
public String HomePage(Model model) {
    
    return "homepage.html";
}

// =========LOGIN MAHASISWA==========
    @GetMapping("/loginMahasiswa")
    public String mahasiswaLoginPage(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("Mahasiswa") != null) {
            return "redirect:/mahasiswa";
        }
        return "loginmahasiswa";  
    }

    @PostMapping(value="/validateLoginMahasiswa")
    public String mahasiswaLogin(Model model, @RequestParam(value="id") Long kodeUser,
    @RequestParam(value="nim") String passUser, HttpServletRequest request) {
        Mahasiswa M = mahasiswaService.findMahasiswa(kodeUser);
        model.addAttribute("userRec", M);
            if(M != null && passUser.equals(M.getNim())) {
            request.getSession().setAttribute("Mahasiswa", M);
            model.addAttribute("userRec", M);
            return "redirect:/mahasiswa";
        }
        else return "redirect:/loginMahasiswa";
    }

    @GetMapping("/logoutMahasiswa")
    public String mahasiswaLogout(HttpServletRequest request) {
        if (request.getSession().getAttribute("Mahasiswa") != null) {
            request.getSession().invalidate();
        }
        return "redirect:/loginMahasiswa";
}   

// =========LOGIN STAFF==========
    @GetMapping("/loginStaff")
    public String staffLoginPage(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("Staff") != null) {
            return "redirect:/staff";
        }
        return "loginstaff";  
    }

    @PostMapping(value="/validateLoginStaff")
    public String staffLogin(Model model, @RequestParam(value="id") Long kodeUser,
    @RequestParam(value="divisi") String passUser, HttpServletRequest request) {
        Staff S = staffService.findStaff(kodeUser);
        model.addAttribute("userRec", S);
            if(S != null && passUser.equals(S.getDivisi())) {
            request.getSession().setAttribute("Staff", S);
            model.addAttribute("userRec", S);
            return "redirect:/staff";
        }
        else return "redirect:/loginStaff";
    }

    @GetMapping("/logoutStaff")
    public String staffLogout(HttpServletRequest request) {
        if (request.getSession().getAttribute("Staff") != null) {
            request.getSession().invalidate();
        }
        return "redirect:/loginStaff";
}   

    // ========== MAHASISWA ==========
    @GetMapping({"/mahasiswa", "/mahasiswa/"})
    public String mahasiswaPage(Model model, HttpServletRequest request) {
        if(request.getSession().getAttribute("Mahasiswa") != null){
        List<Mahasiswa> mahasiswaList = mahasiswaService.getAllMahasiswa();
        model.addAttribute("mahasiswaList", mahasiswaList);
        model.addAttribute("mahasiswaInfo", new Mahasiswa());
        model.addAttribute("logMahasiswa", request.getSession().getAttribute("Mahasiswa"));
        return "mahasiswa.html";
    }
    else return "redirect:/loginMahasiswa";
    }

    @GetMapping("/mahasiswa/{id}")
    public String mahasiswaGetRec(Model model, @PathVariable int id) {
        model.addAttribute("mahasiswaList", mahasiswaService.getAllMahasiswa());
        model.addAttribute("mahasiswaRec", mahasiswaService.getMahasiswaById(id));
        return "mahasiswa.html";
    }

    @PostMapping(value={"/mahasiswa/submit/", "/mahasiswa/submit/{id}"}, params="add")
    public String MahasiswaAdd(@ModelAttribute Mahasiswa mahasiswaInfo) {
        mahasiswaService.addMahasiswa(mahasiswaInfo);
        return "redirect:/mahasiswa";
    }

    @PostMapping(value="/mahasiswa/submit/{id}", params="edit")
    public String MahasiswaEdit(@ModelAttribute Mahasiswa mahasiswaInfo, @PathVariable int id) {
        mahasiswaService.updateMahasiswa(id, mahasiswaInfo);
        return "redirect:/mahasiswa";
    }

    @PostMapping(value="/mahasiswa/submit/{id}", params="delete")
    public String mahasiswaDelete(@PathVariable int id) {
        mahasiswaService.deleteMahasiswa(id);
        return "redirect:/mahasiswa";
    }

    // ========== Staff ==========
@GetMapping({"/staff", "/staff/"})
public String staffPage(Model model, HttpServletRequest request) {
        if(request.getSession().getAttribute("Staff") != null){
    List<Staff> staffList = staffService.getAllStaff();
    model.addAttribute("staffList", staffList);
    model.addAttribute("staffInfo", new Staff());
    model.addAttribute("logStaff", request.getSession().getAttribute("Staff"));
    return "staff.html";
    }
    else return "redirect:/loginStaff";
    }

@GetMapping("/staff/{id}")
public String StaffGetRec(Model model, @PathVariable int id) {
    model.addAttribute("staffList", staffService.getAllStaff());
    model.addAttribute("staffRec", staffService.getStaffById(id));
    return "staff.html";
}

@PostMapping(value={"/staff/submit/", "/staff/submit/{id}"}, params="add")
public String StaffAdd(@ModelAttribute Staff staffInfo) {
    staffService.addStaff(staffInfo);
    return "redirect:/staff";
}

@PostMapping(value="/staff/submit/{id}", params="edit")
public String StaffEdit(@ModelAttribute Staff staffInfo, @PathVariable int id) {
    staffService.updateStaff(id, staffInfo);
    return "redirect:/staff";
}

@PostMapping(value="/staff/submit/{id}", params="delete")
public String StaffDelete(@PathVariable int id) {
    staffService.deleteStaff(id);
    return "redirect:/staff";
}


// ============BUKU=============

@GetMapping({"/buku", "/buku/"})
public String BukuPage(Model model) {
    List<Buku> bukuList = bukuService.getAllBuku();
    model.addAttribute("bukuList", bukuList);
    model.addAttribute("bukuInfo", new Buku());
    return "buku.html";
}

@GetMapping("/buku/{id}")
public String BukuGetRec(Model model, @PathVariable int id) {
    model.addAttribute("bukuList", bukuService.getAllBuku());
    model.addAttribute("bukuRec", bukuService.getBukuById(id));
    return "buku.html";
}

@PostMapping(value={"/buku/submit/", "/buku/submit/{id}"}, params="add")
public String BukuAdd(@ModelAttribute Buku bukuInfo) {
    bukuService.addBuku(bukuInfo);
    return "redirect:/buku";
}

@PostMapping(value="/buku/submit/{id}", params="edit")
public String BukuEdit(@ModelAttribute Buku bukuInfo, @PathVariable int id) {
    bukuService.updateBuku(id, bukuInfo);
    return "redirect:/buku";
}

@PostMapping(value="/buku/submit/{id}", params="delete")
public String BukuDelete(@PathVariable int id) {
    bukuService.deleteBuku(id);
    return "redirect:/buku";
}

// ===============DETAILPEMINJAMAN==================
@GetMapping({"/detailPeminjaman", "/detailPeminjaman/"})
public String DetailPeminjamanPage(Model model) {
    List<DetailPeminjaman> detailPeminjamanList = detailPeminjamanService.getAllDetailPeminjaman();
    List<Buku> bukuList = bukuService.getAllBuku();
    List<Mahasiswa> mahasiswaList = mahasiswaService.getAllMahasiswa();  
    model.addAttribute("mahasiswaList", mahasiswaList);
    model.addAttribute("bukuList", bukuList);
    model.addAttribute("detailPeminjamanList", detailPeminjamanList);
    model.addAttribute("detailPeminjamanInfo", new DetailPeminjaman());
    return "detailpeminjaman.html";
}

@GetMapping("/detailPeminjaman/{id}")
public String DetailPeminjamanGetRec(Model model, @PathVariable int id) {
    List<DetailPeminjaman> detailPeminjamanList = detailPeminjamanService.getAllDetailPeminjaman();
    List<Buku> bukuList = bukuService.getAllBuku();
    List<Mahasiswa> mahasiswaList = mahasiswaService.getAllMahasiswa();  
    model.addAttribute("mahasiswaList", mahasiswaList);
    model.addAttribute("bukuList", bukuList);
    model.addAttribute("detailPeminjamanList", detailPeminjamanList);
    model.addAttribute("detailPeminjamanList", detailPeminjamanService.getAllDetailPeminjaman());
    model.addAttribute("detailPeminjamanRec", detailPeminjamanService.getDetailPeminjamanById(id));
    return "detailpeminjaman.html";
}

@PostMapping(value={"/detailPeminjaman/submit/", "/detailPeminjaman/submit/{id}"}, params="add")
public String DetailPeminjamanAdd(@ModelAttribute DetailPeminjaman detailPeminjamanInfo) {
    detailPeminjamanService.addDetailPeminjaman(detailPeminjamanInfo);
    return "redirect:/detailPeminjaman";
}

@PostMapping(value="/detailPeminjaman/submit/{id}", params="edit")
public String DetailPeminjamanEdit(@ModelAttribute DetailPeminjaman detailPeminjamanInfo, @PathVariable int id) {
    detailPeminjamanService.updateDetailPeminjaman(id, detailPeminjamanInfo);
    return "redirect:/detailPeminjaman";
}

@PostMapping(value="/detailPeminjaman/submit/{id}", params="delete")
public String DetailPeminjamanDelete(@PathVariable int id) {
    detailPeminjamanService.deleteDetailPeminjaman(id);
    return "redirect:/detailPeminjaman";
}


// ==============TRANSAKSIPEMINJAMAN================
@GetMapping({"/transaksiPeminjaman", "/transaksiPeminjaman/"})
public String TransaksiPeminjamanPage(Model model) {
    List<Mahasiswa> mahasiswaList = mahasiswaService.getAllMahasiswa();
    List<Buku> bukuList = bukuService.getAllBuku();
            
    model.addAttribute("mahasiswaList", mahasiswaList);
    model.addAttribute("bukuList", bukuList);
    
    List<TransaksiPeminjaman> transaksiPeminjamanList = transaksiPeminjamanService.getAllTransaksiPeminjaman();
    model.addAttribute("transaksiPeminjamanList", transaksiPeminjamanList);
    model.addAttribute("transaksiPeminjamanInfo", new TransaksiPeminjaman());
    return "transaksipeminjaman.html";
}

@GetMapping("/transaksiPeminjaman/{id}")
public String TransaksiPeminjamanGetRec(Model model, @PathVariable int id) {
    List<Mahasiswa> mahasiswaList = mahasiswaService.getAllMahasiswa();
    List<Buku> bukuList = bukuService.getAllBuku();
            
    model.addAttribute("mahasiswaList", mahasiswaList);
    model.addAttribute("bukuList", bukuList);
    model.addAttribute("transaksiPeminjamanList", transaksiPeminjamanService.getAllTransaksiPeminjaman());
    model.addAttribute("transaksiPeminjamanRec", transaksiPeminjamanService.getTransaksiPeminjamanById(id));
    return "transaksipeminjaman.html";
}

@PostMapping(value={"/transaksiPeminjaman/submit/", "/transaksiPeminjaman/submit/{id}"}, params="add")
public String TransaksiPeminjamanAdd(@ModelAttribute TransaksiPeminjaman transaksiPeminjamanInfo) {
    transaksiPeminjamanService.addTransaksiPeminjaman(transaksiPeminjamanInfo);
    return "redirect:/transaksiPeminjaman";
}

@PostMapping(value="/transaksiPeminjaman/submit/{id}", params="edit")
public String TransaksiPeminjamanEdit(@ModelAttribute TransaksiPeminjaman transaksiPeminjamanInfo, @PathVariable int id) {
    transaksiPeminjamanService.updateTransaksiPeminjaman(id, transaksiPeminjamanInfo);
    return "redirect:/transaksiPeminjaman";
}

@PostMapping(value="/transaksiPeminjaman/submit/{id}", params="delete")
public String TransaksiPeminjamanDelete(@PathVariable int id) {
    transaksiPeminjamanService.deleteTransaksiPeminjaman(id);
    return "redirect:/transaksiPeminjaman";
}


}