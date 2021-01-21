package com.web.stock.service.impl;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.stock.bean.User;
import com.web.stock.bean.UserProperty;
import com.web.stock.service.ChangeService;
import com.web.stock.service.LoginService;
import com.web.stock.service.StockOrderService;
import com.web.stock.service.UserPropertyService;
import com.web.stock.service.UserRoleService;
import com.web.stock.service.UserStockService;
import com.web.stock.service.Userservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 代相廷 修改服务实现
 */
@Service("ChangeService")
public class ChangeServiceImpl implements ChangeService {
    @Autowired
    UserStockService userstockservice;
    @Autowired
    StockOrderService stockorderservice;
    @Autowired
    UserRoleService userroleservice;
    @Autowired
    Userservice userservice;// 创建一个userservice
    @Autowired
    UserPropertyService userpropertyservice;
    @Autowired
    HttpSession session;
    @Autowired
    LoginService loginservice;
    Logger logger = LoggerFactory.getLogger(ChangeServiceImpl.class);

    @Override
    public Integer changeUserInfoService(String username, String sex, String address, Integer age,
            String introduction) {
        try {
            User u1 = userservice.getUserByName(username);
            Integer id = u1.getId();
            userservice.setSexbyId(id, sex);
            logger.info("修改sex={}", sex);
            userservice.setAddressbyId(id, address);
            logger.info("修改address={}", address);
            userservice.setAgebyId(id, age);
            logger.info("修改age={}", age);
            userservice.setIntroductionbyId(id, introduction);
            logger.info("修改introduction={}", introduction);

        } catch (Exception e) {

            logger.error("出现错误", e);
            return 0;
        }
        return 1;
    }

    @Override
    public Integer changePassordService(String password, String oldpassword, HttpServletResponse response) {
        try {
            logger.info("用户 {} 进入密码修改", session.getAttribute("username"));
            logger.info("开始密码修改");
            User u1 = userservice.getUserByName(session.getAttribute("username").toString());
            logger.info("输入的old密码={}", oldpassword);
            if (!oldpassword.equals(u1.getPassword())) {
                logger.info("原密码={}", u1.getPassword());
                // logger.info("输入的")
                logger.info("输入密码有误，返回");
                return 2;
            }
            // userservice.getUserByName(session.getAttribute("username").toString());
            logger.info("用户密码要修改的{}", password);
            Integer id = u1.getId();

            logger.info("用户ID={}", id.toString());
            userservice.setPassowrdbyId(id, password);
            // 修改成功之后注销
            loginservice.logoffservice(response);
            return 1;
        } catch (Exception e) {
            logger.error("有错误", e);

            return 3;
        }
    }

    @Override
    public Integer addUserPropertyService(String username, double property) {
        try {
            logger.info("进入资产添加");
            //User u1 = userservice.getUserByName(session.getAttribute("username").toString());// 获取用户
            //logger.info("获取到用户={}", u1.toString());
            logger.info("进入获取资产");
            UserProperty up1 = userpropertyservice.getUserPropertyByName(username);
            
            up1.setProperty(up1.getProperty() + property);
            logger.info("添加资产+{}", up1.getProperty());
            logger.info("添加成功");
            return userpropertyservice.updateUserPropertyById(up1.getId(), up1.getProperty());
        } catch (Exception e) {
            logger.error("添加失败", e);
            return 0;
        }
    }

    @Override
    public Integer subUserPropertyService(String username, double property) {
        try {
            logger.info("进入资产添加");
            //User u1 = userservice.getUserByName(session.getAttribute("username").toString());// 获取用户
            //logger.info("获取到用户={}", u1.toString());
            logger.info("进入获取资产");
            UserProperty up1 = userpropertyservice.getUserPropertyByName(username);
            if(up1.getProperty() < property){
                logger.info("余额不足");
                return 2;
            }
            up1.setProperty(up1.getProperty() - property);
            logger.info("添加资产+{}", up1.getProperty());
            logger.info("添加成功");
            return userpropertyservice.updateUserPropertyById(up1.getId(), up1.getProperty());
        } catch (Exception e) {
            logger.error("添加失败", e);
            return 0;
        }
    }

    @Override
    public Integer resetUserPassword(String username, String password) {
        try {
            logger.info("开始重置密码");
            User u1 = userservice.getUserByName(username);
            if(u1!=null){
                logger.info("用户信息={}",u1.toString());
                u1.setPassword(password);
                userservice.setPassowrdbyId(u1.getId(), password);
                return 1;
            }
            else return 0;
        } catch (Exception e) {
            logger.error("重置密码失败", e);
            return 0;
        }
    }

    @Override
    public Integer deletuser(String username) {
        try {
            logger.info("删除用户开始");
            int propertyid = userpropertyservice.getUserPropertyByName(username).getId();
            logger.info("propertyid={}",propertyid);
            int test1 = userpropertyservice.deletUserPropertyById(propertyid);
            if(test1!=0){logger.info("用户资产删除正常");}
            int test2 = userstockservice.deletUser(username);
            if(test2!=0){logger.info("用户持仓删除正常");}
            int test3 = stockorderservice.deletUser(username);
            if(test3!=0){logger.info("用户记录删除正常");}
            int userroleid = userroleservice.getUserRolebyName(username).getId();
            int test4 = userroleservice.deletUserRolebyId(userroleid);
            if(test4!=0){logger.info("用户权限删除正常");}
            int userid = userservice.getUserByName(username).getId();
            int test5 = userservice.deletUserById(userid);
            if(test5!=0){logger.info("用户删除正常");}
            
            return 1;
        } catch (Exception e) {
            logger.error("删除错误", 0);
            return 0;
        }
    }

    @Override
    public Integer changeroleid(String username, Integer roleid ) {
        try {
            if(userroleservice.getUserRoleIdbyname(session.getAttribute("username").toString())!=0){
                logger.info(userroleservice.getUserRoleIdbyname(session.getAttribute("username").toString()).toString());
                logger.info("无权限");
                return 0;
            }
            logger.info("修改权限={}",roleid);
            
            return userroleservice.updateRoleIdbyName(username, roleid);

        } catch (Exception e) {
            return 0;
        }
    }

}