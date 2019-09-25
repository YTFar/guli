package com.guli.controller;

import com.guli.message.response.CommonCode;
import com.guli.pojo.GuliUser;
import com.guli.pojo.ordervo.GuliOrderAndCourseVo;
import com.guli.response.ObjectResult;
import com.guli.service.GuliUserService;
import com.guli.utils.Encryption;
import com.guli.utils.SendSms;
import com.guli.web.BaseController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/guliUser",method = RequestMethod.POST)
public class GuliUserController extends BaseController {

    @Resource
    GuliUserService guliUserService;

    ObjectResult objectResult = null;

    /**
     * 登录
     * @param userName
     * @param pwd
     * @return
     */
    @PostMapping("/uuuuulogin")
    public String login(RedirectAttributes redir,@RequestParam("userName") String userName, @RequestParam("userPassword") String pwd) {
        GuliUser guliUser = guliUserService.login(userName, pwd);
        if(guliUser != null){
            session.setAttribute("user",guliUser);
            return "index";
        } else {
            return "login";
        }

    }

    /**
     * 注册
     * @param guliUser
     * @return
     */
    @PostMapping("/register")
    @ResponseBody
    public ObjectResult register(GuliUser guliUser,@RequestParam("code") String code){
        Encryption encryption = new Encryption();
        String s = encryption.encryptionMD5(guliUser.getUserPassword());
        guliUser.setUserPassword(s);
        Object code1 = session.getAttribute("code");
        if(code1.equals(code)){
            int register = guliUserService.register(guliUser);
            if(register > 0){
                objectResult = new ObjectResult(CommonCode.REGISTER_FAIL,register);
            } else {
                objectResult = new ObjectResult(CommonCode.REGISTER_FAIL,register);
            }
            return objectResult;
        }else{
            return new ObjectResult(CommonCode.VERIFY_CODE_ERROR,"验证码有误!");
        }
    }

    @PostMapping("/checkName")
    @ResponseBody
    public ObjectResult checkName(@RequestParam("userName") String userName){
        int i = guliUserService.checkName(userName);
        System.out.println(i);
        if(i > 0){
            objectResult = new ObjectResult(CommonCode.USERNAME_EXIST,i);
        } else {
            objectResult = new ObjectResult(CommonCode.USERNAME_NOT_EXIST,i);
        }
        return objectResult;
    }

    /**
     * 发送短信
     * @param userPhone 输入的电话号码
     * @return
     */
    @PostMapping("/sendSms")
    @ResponseBody
    public String sendSms(@RequestParam("userPhone") String userPhone,HttpSession session){
        SendSms sendSms = new SendSms();
        String str = sendSms.smsCode(userPhone);
        if(str != null){
            session.setAttribute("userPhone",userPhone);
            session.setAttribute("code",str);
        }
        return str;
    }

    @PostMapping("/updateUserInfo")
    @ResponseBody
    public ObjectResult updateUserInfo(GuliUser guliUser){
        int i = guliUserService.updateUserInfo(guliUser);
        if(i > 0){
            objectResult = new ObjectResult(CommonCode.UPDATE_USERINFO_SUCCESS,i);

        } else {
            objectResult = new ObjectResult(CommonCode.UPDATE_USERINFO_ERROR,i);
        }
        return objectResult;
    }

    @GetMapping("/findUserById")
    @ResponseBody
    public ObjectResult findUserById(@RequestParam("userId") int userId,Model model){
        GuliUser userById = guliUserService.findUserById(userId);
        if(userById != null){
            objectResult = new ObjectResult(CommonCode.FIND_USER_BY_ID_SUCCESS,userById);
        }
        return objectResult;
    }

    @GetMapping("/findAllOrder")
    @ResponseBody
    public ObjectResult findAllOrder(@RequestParam("userId") int userId){
        List<GuliOrderAndCourseVo> allOrder = guliUserService.findAllOrder(userId);
        objectResult = new ObjectResult(CommonCode.FIND_ALL_ORDER_SUCCESS,allOrder);
        System.out.println(allOrder);
        return objectResult;
    }

    @GetMapping("/findAllRefundOrder")
    @ResponseBody
    public ObjectResult findAllRefundOrder(@RequestParam("userId") int userId){
        List<GuliOrderAndCourseVo> allRefundOrder = guliUserService.findAllRefundOrder(userId);
        objectResult = new ObjectResult(CommonCode.FIND_ALL_REFUND_ORDER,allRefundOrder);
        return objectResult;
    }

    @GetMapping("/searchVague")
    @ResponseBody
    public ObjectResult searchVague(@RequestParam("userId") int userId,@RequestParam("searchName") String searchName){
        List<GuliOrderAndCourseVo> guliOrderAndCourseVos = guliUserService.searchName(userId,searchName);
        return new ObjectResult(CommonCode.FIND_ALL_REFUND_ORDER,guliOrderAndCourseVos);

    }




}
