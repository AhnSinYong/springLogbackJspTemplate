package demos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ahnsy on 2017-01-15.
 */
@Controller
public class SimpleConverterController {

    @RequestMapping(value = "/test/simpleTest.do", method = RequestMethod.GET)
    public String simpleTestForm() {
        //return "test/simpleTestForm"; // 타일즈 안쓰고 레이아웃 구성하기위해 dispatcher-servlet의 커스텀 org.template.JstlView 때문에 경로 못찾고 /WEB-INF/views/화면.jsp 파일만 호출됨
        return "test/simpleTestForm.tiles";
    }

    // @RequestBody 어노테이션은 @RequestMapping에 의해 POST 방식으로 전송된 HTTP 요청 데이터를 String 타입의 body 파라미터로 전달된다.(수신)
    // 그리고 @ResponseBody 어노테이션이 @RequestMapping 메서드에서 적용되면 해당 메서드의 리턴 값을 HTTP 응답 데이터로 사용한다.
    // simpleTest() 메서드의 리턴 값이 String 타입이므로 String 데이터를 HTTP 응답 데이터로 전송한다.(송신)
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String simpleTest(@RequestBody String body) {
        return body;
    }
}
