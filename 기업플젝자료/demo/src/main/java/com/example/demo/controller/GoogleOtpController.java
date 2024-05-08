package com.example.demo.controller;

import org.apache.commons.codec.binary.Base32;
import org.springframework.boot.autoconfigure.quartz.QuartzTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.Random;

@Controller
public class GoogleOtpController {

//    @GetMapping("/")
    public String main(){
       return "test";
    }

    @GetMapping("/generateOTP")
    public String generateOTP(Model model) {
        byte[] buffer = new byte[5 + 5 * 5];
        new Random().nextBytes(buffer);

        Base32 codec = new Base32();
        byte[] secretKey = Arrays.copyOf(buffer, 5);
        byte[] bEncodedKey = codec.encode(secretKey);

        String encodedKey = new String(bEncodedKey);

        String url = getQRBarcodeURL("hj", "company.com", encodedKey);

        String view = "otpTest";

        model.addAttribute("encodedKey", encodedKey);
        model.addAttribute("url", url);

        return view;
    }

    public static String getQRBarcodeURL(String user, String host, String secret) {
        String format = "http://chart.apis.google.com/chart?cht=qr&amp;chs=300x300&amp;chl=otpauth://totp/%s@%s%%3Fsecret%%3D%s&amp;chld=H|0";

        return String.format(format, user, host, secret);
    }
}

