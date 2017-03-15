package com.kylin.controller;

import com.kylin.vo.common.MyMessage;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by kylin on 14/03/2017.
 * All rights reserved.
 */
public class MyController {

    protected ModelAndView handleMessage(MyMessage myMessage, String page) {
        ModelAndView modelAndView = new ModelAndView(page);
        if (!myMessage.isSuccess()) {
            modelAndView.addObject("error", myMessage.getDisplayMessage());
        }
        return modelAndView;
    }

    protected ModelAndView handleMessage(MyMessage myMessage, String page, Map<String, Object> object) {
        ModelAndView modelAndView = new ModelAndView(page);
        if (!myMessage.isSuccess()) {
            modelAndView.addObject("error", myMessage.getDisplayMessage());
        }
        // 都返回相同的数据到界面
        this.addDataToMV(object,modelAndView);
        return modelAndView;
    }

    protected ModelAndView handleMessage(MyMessage myMessage, String successPage, String errorPage) {
        ModelAndView modelAndView;
        // 处理成功
        if (myMessage.isSuccess()) {
            modelAndView = new ModelAndView(successPage);
            // 处理失败
        } else {
            modelAndView = new ModelAndView(errorPage);
            modelAndView.addObject("error", myMessage.getDisplayMessage());
        }
        return modelAndView;
    }

    protected ModelAndView handleMessage(MyMessage myMessage, String successPage, String errorPage,
                                         Map<String, Object> successObject, Map<String, Object> errorObjects) {
        ModelAndView modelAndView;
        // 处理成功
        if (myMessage.isSuccess()) {
            modelAndView = new ModelAndView(successPage);
            // 添加成功时候的数据
            this.addDataToMV(successObject, modelAndView);

            // 处理失败
        } else {
            modelAndView = new ModelAndView(errorPage);
            modelAndView.addObject("error", myMessage.getDisplayMessage());
            // 添加错误时候的数据
            this.addDataToMV(errorObjects, modelAndView);
        }
        return modelAndView;
    }

    private void addDataToMV(Map<String, Object> inputMap, ModelAndView modelAndView) {
        if (inputMap == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : inputMap.entrySet()) {
            modelAndView.addObject(entry.getKey(), entry.getValue());
        }
    }
}
