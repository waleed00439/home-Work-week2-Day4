package com.example.homeworkday4week2.controller;

import com.example.homeworkday4week2.model.Api;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class takscontroller {

    ArrayList<Mytaks> taks = new ArrayList<>();
@GetMapping("/taks")
    public ArrayList<Mytaks> getTaks() {
        return taks;
    }
    @PostMapping("/taks")
    public Api addTaks(@RequestBody Mytaks mytaks) {
        taks.add(mytaks);
        return new  Api("taks added !");
    }
    @PutMapping("/taks/{index}")
    public Api editTaks(@RequestBody Mytaks mytaks , @PathVariable int index) {
        taks.set(index,mytaks);
        return new  Api("taks updated !");
}
    @DeleteMapping("/taks/{index}")
    public Api DELTaks(@PathVariable int index) {
        taks.remove(index);
        return new  Api("taks dleeted !");
}
@PostMapping("/taks/{status}")
public Api Changestat(@PathVariable int index, @PathVariable String  stat){

        Mytaks takss = taks.get(index);
        takss.setStatus(stat);
        return  new Api ("status updated");
}
@GetMapping("/taks/search")
    public Api searchtaks(@RequestParam String taks1){
    for (int i = 0; i <taks.size() ; i++) {
       if (taks.get(i).getTitle().equals(taks1));
       return new Api("went ok ");
    }
   return new Api("not found");
}




}



