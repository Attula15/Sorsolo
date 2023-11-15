package com.example.Sorsolo;

import com.sun.tools.javac.Main;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class MainController {
    private ArrayList<String> lista;
    private Random rand = new Random();

    public MainController(){
        List<String> tempList = List.of("Cseszka","Hérincs","Ákos","Dávid","Marci");
        lista = new ArrayList<>(tempList);
    }

    @GetMapping("/getOne/{name}")
    public String getOne(@PathVariable("name") String name){
        int newIndex = -1;
        boolean reroll = true;
        String rolledName = "None";

        if(lista.size() == 1){
            return lista.get(0);
        }

        while(reroll) {
            newIndex = rand.nextInt(0, lista.size());
            if(!lista.get(newIndex).equals(name)){
                reroll = false;
                rolledName = lista.get(newIndex);
                lista.remove(rolledName);
            }
        }

        return rolledName;
    }
}
