package com.guli.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;

@Controller
public class ReturnController {

    @GetMapping("/orders")
    public String searchVague(@RequestParam("userId") int userId){
        return "my/orders";
    }

    @GetMapping("/order_refund")
    public String getOrderRefundSession(@RequestParam("userId") int userId){ return "my/order_refunds"; }

    @GetMapping("/cards")
    public String getCardsSession(@RequestParam("userId") int userId){ return "my/cards"; }

    @GetMapping("/cardsuseable")
    public String getCardUsedAbleSession(@RequestParam("userId") int userId){ return "my/cardsuseable"; }

    @GetMapping("/cardsused")
    public String getCardUsedSession(@RequestParam("userId") int userId){ return "my/cardsused"; }

    @GetMapping("/cardsoutdate")
    public String getCardOutDateSession(@RequestParam("userId") int userId){ return "my/cardsoutdate"; }

    @GetMapping("/settings")
    public String getUserInfoSession(@RequestParam("userId") int userId){ return "settings"; }

    @GetMapping("/video/hls/{m3u8}")
    public String getUserInfoSession(@NotNull @PathVariable("m3u8") String meu8, Model model){
        String path = "/video/hls/"+meu8+".m3u8";
        model.addAttribute("path",path);
        return "course/video";
    }

}
