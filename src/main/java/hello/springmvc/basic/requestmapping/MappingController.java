package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {
    private Logger log = LoggerFactory.getLogger(getClass());
    @RequestMapping(value = "/hello-basic")
    public String helloBasic(){
        log.info("helloBasic");
        return "ok";
    }
    @RequestMapping(value ="/mapping-get-v1",method = RequestMethod.GET)
    public String mappingGetV1(){
        log.info("mappingGetV1");
        return "ok";
    }
    /**
     * 편리한 축약 에노테이션(코드보기)
     * @GetMapping
     * @PostMapping
     * @PutMapping
     * @DeleteMapping
     * @PatchMapping
     * */
    @GetMapping(value = "/mapping-get-v2")
    public String mappingGetV2(){
        log.info("mapping-get-v2");
        return "ok";
    }
    /**
     * PathVariable 사용
     * 변수명이 같으면 생략 가능
     * @PathVariagble("userId") String userId -> @PathVariable userId
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId")String data){
        log.info("mappingPath userId={}",data);
        return "ok";
    }
    /**
     * PathVariable 사용 다중
     */
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId){
        log.info("mappingPath userId={},orderId={}",userId,orderId);
        return "ok";
    }
    /**
     * 이것은 자주 안사용하고 위에 소스코드에 다중사용으로 경로 변수를 많이 사용한다.
     * 파라미터로 추가 매핑
     * params="mode",
     * params="!mode"
     * params="mode=debug"
     * params="mode!=debug"(!=)
     * params={"mdoe=debug","data=good"}
     */
    @GetMapping(value = "/mapping-param",params = "mdoe-debug")
    public String mappingParam(){
        log.info("mappingParam");
        return "ok";
    }
}
