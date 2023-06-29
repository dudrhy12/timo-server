package timo.timo.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import timo.timo.Service.QRService;

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
}
