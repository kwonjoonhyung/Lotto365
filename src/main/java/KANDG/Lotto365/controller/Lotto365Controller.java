package KANDG.Lotto365.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

@Controller
public class Lotto365Controller {
    @GetMapping("Lotto365")
    public String Lotto365(Model model){
        boolean[] check = new boolean[46];
        check[0] = true;
        int[] lottoNum = new int[6];

        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        int numSet = 0;

        while (numSet != 6) {
            int randNum = random.nextInt(45);
            if (check[randNum] == false) {
                lottoNum[numSet++] = randNum;
                check[randNum] = true;
            } else
                continue;
        }

        model.addAttribute("num1",lottoNum[0]);
        model.addAttribute("num2",lottoNum[1]);
        model.addAttribute("num3",lottoNum[2]);
        model.addAttribute("num4",lottoNum[3]);
        model.addAttribute("num5",lottoNum[4]);
        model.addAttribute("num6",lottoNum[5]);
        return "Lotto365";
    }
}
