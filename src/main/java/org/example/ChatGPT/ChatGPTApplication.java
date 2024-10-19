package org.example.ChatGPT;

/**
 * @Description:
 * @Author:yzy
 * @Date:2024-10-18  15:52
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ChatGPTApplication {

    private Logger logger = LoggerFactory.getLogger(ChatGPTApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ChatGPTApplication.class, args);
    }

    @GetMapping("/verify")
    public ResponseEntity<String> verify(String token){
        logger.info("验证 token:{}",token);
        System.out.println(token);
        if("success".equals(token)){
            return ResponseEntity.status(HttpStatus.OK).build();
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/success")
    public String success(){
        return "test success by yzy123";
    }

}
