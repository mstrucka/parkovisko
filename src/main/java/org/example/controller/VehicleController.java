//package org.example.controller;
//
//import org.example.repository.Vehicle;
//import org.example.service.VehicleService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class VehicleController {
//    @Autowired
//    private VehicleService vehicleService;
//
//    @GetMapping("/")
//    public String viewHomePage() {
//        return "dont know what";
//    }
//
//    @GetMapping("/add")
//    public String showNewCourseForm(Model model) {
//        Vehicle vehicle = new Vehicle();
//        model.addAttribute("vehicle", Vehicle);
//        return "new_vehicle";
//    }
//
//    @PostMapping("/save")
//    public String saveVehicle(@ModelAttribute("vehicle") Vehicle vehicle) {
//        // save Course to database
//        vehicleService.saveVehicle(vehicle);
//        return "redirect:/";
//    }
//
//    @GetMapping("/update/{id}")
//    public String showFormForUpdate(@PathVariable( value = "id") int id, Model model) {
//
//        Vehicle vehicle = vehicleService.getVehicleById(id);
//        model.addAttribute("vehicle", vehicle);
//        return "update_vehicle";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String deleteVehicle(@PathVariable (value = "id") int id) {
//
//        this.vehicleService.deleteVehicleById(id);
//        return "redirect:/";
//    }
//}
