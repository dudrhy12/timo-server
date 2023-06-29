package timo.timo.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.function.client.WebClient;
import timo.timo.Service.QRService;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class QRController {

    private final QRService qrService;

    @GetMapping("/qr")
    public String qr(@RequestParam String phone) {

        boolean isUser = qrService.findUser(phone);

        if (isUser){
            return "redirect:https://quickchart.io/qr?text=https://www.naver.com/";
        }else {
            return "redirect:https://quickchart.io/qr?text=https://www.google.com/";
        }

    }

    @GetMapping("/qrtest")
    @ResponseBody
    public void qrtest() throws IOException {

        WebClient client3 = WebClient.builder()
                .baseUrl("https://quickchart.io/qr")
                //.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();


        byte[] response = client3.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("text", "https://www.naver.com/")
                        .build())
                .accept(MediaType.IMAGE_PNG)
                .retrieve()
                .bodyToMono(byte[].class)
                .block();

        ByteArrayInputStream bis = new ByteArrayInputStream(response);
        BufferedImage bImage2 = ImageIO.read(bis);
        ImageIO.write(bImage2, "png", new File("output.png") );
        System.out.println("image created");

//        ImageIcon imageIcon = new ImageIcon(response);
//        return imageIcon.getImage();
//
//        //System.out.println("response = " + response);
//
//        //System.out.println("response = " + response);

    }


}
