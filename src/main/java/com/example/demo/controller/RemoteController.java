package com.example.demo.controller;

import com.example.demo.models.RemoteControl;
import com.example.demo.models.RemoteControlRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class RemoteController {

    private RemoteControlRepository controlData;

    public RemoteController(RemoteControlRepository controlData) {
        this.controlData = controlData;
    }

    @GetMapping("/TVRemoteController")
    public String printVersion() {
        System.out.println("The version is GX321");
        return "The version is GX321";
    }

    @GetMapping("/printRemoteControlId/{id}")
    public RemoteControl printRemoteControlId(@PathVariable Long id) {
        return controlData.findById(id).get();
    }

    @GetMapping("/printAllRemoteControlIds")
    public List<RemoteControl> printAllRemoteControls() {
        return controlData.findAll();
    }

    @DeleteMapping("/deleteRemoteControl/{id}")
    public void deleteRemoteControlId(@PathVariable Long id) {
        controlData.deleteById(id);
    }


    @PostMapping("/insert")
    public RemoteControl printVersion(@RequestBody RemoteControl rmt) {
        System.out.println("Insert rmt");
        return controlData.save(rmt);
    }


    @PutMapping("/updateRemoteControl/{id}")
    public RemoteControl updateRemoteControlID(@RequestBody RemoteControl rmt, @PathVariable Long id) {
        return controlData.findById(id).
                map(remoteControl -> {
                    remoteControl.setDistance(rmt.getDistance());
                    remoteControl.setPowerButton(rmt.isPowerButton());
                    return controlData.save(remoteControl);
                }).get();

    }


}
